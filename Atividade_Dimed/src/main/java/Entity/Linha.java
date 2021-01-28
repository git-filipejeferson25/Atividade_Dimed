package Entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tabela itinerário")
@NoArgsConstructor
public class Linha implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5200026768500098141L;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ID")
	private long id;
	
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Código")
	private String codigo;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Nome")
	private String nome;
	
	
	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setItinerario(ArrayList arrayList) {		
		
	}
	
	
	
	

}
