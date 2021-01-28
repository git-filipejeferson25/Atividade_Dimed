package Controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import DTO.Itinerario_DTO;
import Model.Response;
import Service.I_Itinerario_Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/itinerario")
@Api(tags = { "API de cadastro, atualizações, listagem, pesquisa e exclusão" })
@CrossOrigin(origins = "*")
public class ItinerarioRestController {
	
	
	@Autowired
	private I_Itinerario_Service itinerario_Service;
	
	/*
	 * LISTAR TODOS OS ITINERÁRIOS
	 */

	@ApiOperation(value = "Listar todos os itinerário cadastrados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de itinerário exibida com sucesso"),
			@ApiResponse(code = 500, message = "Erro interno no serviço"), })
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Itinerario_DTO>>> listar_Itinerario() {
		Response<List<Itinerario_DTO>> response = new Response<>();
		response.setData(this.itinerario_Service.listar());
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/*
	 * CONSULTAR ITINERÁRIOS
	 */
	
	@ApiOperation(value = "Consultar itinerário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Itinerário encontrado com sucesso"),
			@ApiResponse(code = 404, message = "Itinerário não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no serviço"), })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Itinerario_DTO>> consultar_Itinerario(@PathVariable Long id) {
		Response<Itinerario_DTO> response = new Response<>();
		Itinerario_DTO itinerario = this.itinerario_Service.consultar(id);
		response.setData(itinerario);
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	/*
	 * CADASTRAR ITINERÁRIO
	 */

	@ApiOperation(value = "Cadastrar um novo itinerário")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Itinerário criado com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição enviada pelo cliente"),
			@ApiResponse(code = 500, message = "Erro interno no serviço"), })
	@PostMapping(value = "/{cadastrar}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Boolean>> cadastrar_Itinerario(@Valid @RequestBody Itinerario_DTO itinerario) {
		Response<Boolean> response = new Response<>();
		response.setData(this.itinerario_Service.cadastrar(itinerario));
		response.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	/*
	 * EXCLUIR ITINERÁRIO
	 */

	@ApiOperation(value = "Excluir itinerário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Itinerário excluído com sucesso"),
			@ApiResponse(code = 404, message = "Itinerário não encontrada"),
			@ApiResponse(code = 500, message = "Erro interno no serviço"), })
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Boolean>> excluir_Itinerario(@PathVariable Long id) {
		Response<Boolean> response = new Response<>();
		response.setData(this.itinerario_Service.excluir(id));
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	/*
	 * ATUALIZAR DADOS CADASTRADOS
	 */

	@ApiOperation(value = "Atualizar itinerário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Itinerário atualizado com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição enviada pelo usuário"),
			@ApiResponse(code = 404, message = "Itinerário não encontrado"),
			@ApiResponse(code = 500, message = "Erro interno no serviço"), })
	@PutMapping(value = "/{atualizar}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Boolean>> atualizar_Itinerario(@RequestBody Itinerario_DTO itinerario) {
		Response<Boolean> response = new Response<>();
		response.setData(this.itinerario_Service.atualizar(itinerario));
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
