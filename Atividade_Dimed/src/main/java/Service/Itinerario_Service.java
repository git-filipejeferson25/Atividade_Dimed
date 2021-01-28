package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import DTO.Itinerario_DTO;
import Entity.Itinerario;
import Exception.MessageException;
import Repository.Itinerario_Repository;


@Service
public class Itinerario_Service {


	private static final String MENSAGEM_ERRO = "Erro interno identificado. Contate o suporte";

	@SuppressWarnings("unused")
	private static final String ITINERARIO_NAO_ENCONTRADO = "Itinerário não encontrado";
	private Itinerario_Repository itinerarioRepository;
	private ModelMapper mapper;

	@Autowired
	public Itinerario_Service(Itinerario_Repository itinerarioRepository) {
		this.mapper = new ModelMapper();
		this.itinerarioRepository = itinerarioRepository;
	}

	public Boolean atualizar(Itinerario itinerario) {
		try {

			this.consultar(itinerario);
			Itinerario itinerarioEntityAtualizada = this.mapper.map(itinerario, Itinerario.class);

			this.itinerarioRepository.save(itinerarioEntityAtualizada);

			return Boolean.TRUE;

		} catch (MessageException m) {
			throw m;
		} catch (Exception e) {
			throw e;
		}
	}

	public Boolean excluir(Itinerario id) {
		try {
			this.consultar(id);
			this.itinerarioRepository.delete(id);
			return Boolean.TRUE;
		} catch (MessageException m) {
			throw m;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Itinerario_DTO> listar() {
		try {
			ModelMapper mapper = new ModelMapper();
			return mapper.map(this.itinerarioRepository.findAll(), new TypeToken<List<Itinerario_DTO>>() {
			}.getType());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public Itinerario_DTO consultar(Itinerario itinerario) {
		try {
			ModelMapper mapper = new ModelMapper();
			Optional<Itinerario> itinerarioOptional = Optional
					.ofNullable(this.itinerarioRepository.findByCodigo(null));
			if (itinerarioOptional.isPresent()) {
				return mapper.map(itinerarioOptional.get(), Itinerario_DTO.class);
			}
			throw new MessageException(" ", HttpStatus.NOT_FOUND);
		} catch (MessageException m) {
			throw m;
		} catch (Exception e) {
			throw new MessageException(" ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public Boolean cadastrar(Itinerario_DTO itinerario) {
		try {

			Itinerario itinerarioEnt = this.mapper.map(itinerario, Itinerario.class);
			this.itinerarioRepository.save(itinerarioEnt);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new MessageException(MENSAGEM_ERRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
