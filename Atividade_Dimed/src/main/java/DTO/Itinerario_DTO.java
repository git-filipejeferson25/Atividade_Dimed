package DTO;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Itinerario_DTO {


	private String idlinha;
	
	@NotBlank(message = "Informe a latitude")
	@Min(value = 34, message = "Permitido o mínimo de 34 horas aula.")
	@Max(value = 102, message = "Permitido o máximo de 102 horas aula.")
	private Long latitude;
	
	@NotBlank(message = "Informe a Longitude")
	@Min(value = 34, message = "Permitido o mínimo de 34 horas aula.")
	@Max(value = 102, message = "Permitido o máximo de 102 horas aula.")
	private Long longitude;
	
	@NotBlank(message = "Informe o código da itinerário.")
	private String codigo;

	
	public void setIdlinha() {
		// TODO Auto-generated method stub
		
	}

	public String getIdlinha() {
		return idlinha;
	}

	public void setIdlinha(String string) {
		this.idlinha = string;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	

	public void setNome(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

