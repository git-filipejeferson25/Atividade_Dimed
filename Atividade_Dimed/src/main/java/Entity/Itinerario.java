package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
public class Itinerario {

	@JsonInclude(Include.NON_NULL)
	@Column(name = "ID_Linha")
	private int idlinha;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Nome")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Código")
	private String codigo;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Latitude")
	private String latitude;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Longitude")
	private String longitude;
	
	
	
	
	public int getIdlinha() {
		return idlinha;
	}
	public void setIdlinha(int idlinha) {
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
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public void setId() {
		// TODO Auto-generated method stub
		
	}
	
	
}
