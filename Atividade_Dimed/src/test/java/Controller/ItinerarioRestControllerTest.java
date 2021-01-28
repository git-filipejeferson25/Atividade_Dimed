package Controller;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import DTO.Itinerario_DTO;
import Model.Response;
import Service.I_Itinerario_Service;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(JUnitPlatform.class)
class ItinerarioRestControllerTest {

	@LocalServerPort
	private int port;

	@MockBean
	private I_Itinerario_Service itinerarioService;

	@Autowired
	private TestRestTemplate restTemplate;

	private static Itinerario_DTO itinerario_Dto;

	@BeforeAll
	public static void init() {

		itinerario_Dto = new Itinerario_DTO();
		itinerario_Dto.setIdlinha("5566");
		itinerario_Dto.setNome("SAFIRA/LEOPOLDINA/RUBEM B./NAVEGANTES");
		itinerario_Dto.setCodigo("66139-2");

	}

	@Test
	public void testListarItinerarios() {
		Mockito.when(this.itinerarioService.listar()).thenReturn(new ArrayList<Itinerario_DTO>());

		ResponseEntity<Response<List<Itinerario_DTO>>> itinerarios = restTemplate.exchange(
				"http://localhost:" + this.port + "/itinerario", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<List<Itinerario_DTO>>>() {
				});
		assertNotNull(itinerarios.getBody().getData());
		assertEquals(200, itinerarios.getBody().getStatusCode());
	}

	@Test
	public void testConsultarItinerarios() {
		Mockito.when(this.itinerarioService.consultar(1L)).thenReturn(itinerario_Dto);

		ResponseEntity<Response<Itinerario_DTO>> itinerarios = restTemplate.exchange(
				"http://localhost:" + this.port + "/itinerario", HttpMethod.GET, null,
				new ParameterizedTypeReference<Response<Itinerario_DTO>>() {
				});
		assertNotNull(itinerarios.getBody().getData());
		assertEquals(200, itinerarios.getBody().getStatusCode());
	}

	@Test
	public void testCadastrarItinerarios() {
		Mockito.when(this.itinerarioService.cadastrar(itinerario_Dto)).thenReturn(Boolean.TRUE);

		HttpEntity<Itinerario_DTO> request = new HttpEntity<>(itinerario_Dto);

		ResponseEntity<Response<Boolean>> itinerarios = restTemplate.exchange(
				"http://localhost:" + this.port + "/itinerario", HttpMethod.POST, request,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});
		assertNotNull(itinerarios.getBody().getData());
		assertEquals(201, itinerarios.getBody().getStatusCode());
	}

	@Test
	public void testAtualizarItinerarios() {
		Mockito.when(this.itinerarioService.atualizar(itinerario_Dto)).thenReturn(Boolean.TRUE);

		HttpEntity<Itinerario_DTO> request = new HttpEntity<>(itinerario_Dto);

		ResponseEntity<Response<Boolean>> itinerarios = restTemplate.exchange(
				"http://localhost:" + this.port + "/itinerario", HttpMethod.PUT, request,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});
		assertNotNull(itinerarios.getBody().getData());
		assertEquals(200, itinerarios.getBody().getStatusCode());
	}

	@Test
	public void testExcluitItinerarios() {
		Mockito.when(this.itinerarioService.excluir(1L)).thenReturn(Boolean.TRUE);

		ResponseEntity<Response<Boolean>> itinerarios = restTemplate.exchange(
				"http://localhost:" + this.port + "/itinerario", HttpMethod.DELETE, null,
				new ParameterizedTypeReference<Response<Boolean>>() {
				});
		assertNotNull(itinerarios.getBody().getData());
		assertEquals(200, itinerarios.getBody().getStatusCode());
	}

	

}