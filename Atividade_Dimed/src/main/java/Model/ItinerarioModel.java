package Model;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.NoArgsConstructor;



@NoArgsConstructor
public class ItinerarioModel {
	
	@NotBlank(message = "nome deve ser preenchido")
	@Size(max = 100)
	private Long idlinha;

	@NotBlank(message = "nome deve ser preenchido")
	@Size(max = 100)
	private String nome;
	
	@NotBlank(message = "código deve ser preenchido")
	@Size(max = 5)
	private String codigo;	
	
	
	public Long getIdlinha() {
		return idlinha;
	}

	public void setIdlinha(Long idlinha) {
		this.idlinha = idlinha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	private List<Long> itinerario;
	

	public List<Long> getItinerario() {
		return itinerario;
	}

	public void setItinerario(List<Long> itinerario) {
		this.itinerario = itinerario;
	}

	public Boolean cadastrar(@Valid ItinerarioModel itinerario2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}

}
