package Service;

import java.util.List;

import DTO.Itinerario_DTO;

public interface I_Itinerario_Service {

	public Boolean atualizar(final Itinerario_DTO itinerario);
	
	public Boolean excluir(final Long id);

	public Itinerario_DTO consultar(final Long id);
	
	public Boolean cadastrar(final Itinerario_DTO itinerario);

	public List<Itinerario_DTO> listar();
	
	public List<Itinerario_DTO> listarPorHorarioMinimo(int horaMinima);

	public List<Itinerario_DTO> listarPorFrequencia(int frequencia);
}
