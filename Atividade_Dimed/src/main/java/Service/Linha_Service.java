package Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import DTO.Linha_DTO;
import Entity.Linha;
import Exception.MessageException;
import Model.ItinerarioModel;
import Repository.I_Linha_Repository;


@Service
public class Linha_Service {

	private static final String MENSAGEM_ERRO = "Erro interno identificado. Contate o suporte";
	
	@SuppressWarnings("unused")
	private static final String ITINERÁRIO_NAO_ENCONTRADA = "Itinerário não encontrada";
	
	private ModelMapper mapper;
	
	private I_Linha_Repository linhaRepository;
	
	@Autowired
	public Linha_Service(I_Linha_Repository linhaRepository) {
		this.mapper = new ModelMapper();
		this.linhaRepository = linhaRepository;
	}


	public Boolean atualizar(Linha linha) {
		try {
			this.consultar(linha.getId());
			Linha_Service linhaEntityAtualizada = this.mapper.map(linha, Linha_Service.class);

			this.linhaRepository.save(linhaEntityAtualizada);

			return Boolean.TRUE;

		}catch (MessageException m) {
			throw m;
		} catch (Exception e) {
			throw e;
		}
	}

	public Boolean excluir(Long id) {
		try {
			this.consultar(id);
			this.linhaRepository.deleteById(id);
			return Boolean.TRUE;
		} catch (MessageException m) {
			throw m;
		} catch (Exception e) {
			throw e;
		}
	}


	public List<Linha_DTO> listar() {
		try {
			ModelMapper mapper =  new ModelMapper();
			return mapper.map(this.linhaRepository.findAll(),new TypeToken<List<Linha_DTO>>() {}.getType());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}


	public Linha_DTO consultar(long id) {
		try {
			ModelMapper mapper =  new ModelMapper();
			Optional<Linha> linhaOptional = Optional.ofNullable(this.linhaRepository.findByCodigo(null));
			if (linhaOptional.isPresent()) {
				return mapper.map(linhaOptional.get(),Linha_DTO.class);
			}
			throw new MessageException("Matéria não encontrada", HttpStatus.NOT_FOUND);
		} catch (MessageException m) {
			throw m;
		} catch (Exception e) {
			throw new MessageException("Erro interno identificado. Contate o suporte",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	public Boolean cadastrar(ItinerarioModel cursoModel) {
		try {
			Linha linhaEntityAtualizada = this.mapper.map(cursoModel, Linha.class);
			this.linhaRepository.save(linhaEntityAtualizada);
			return Boolean.TRUE;
		} catch (Exception e) {
			throw new MessageException(MENSAGEM_ERRO,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	public Linha consultar(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean atualizar(ItinerarioModel linhabus) {
		// TODO Auto-generated method stub
		return null;
	}


}





