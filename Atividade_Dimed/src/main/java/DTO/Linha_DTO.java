package DTO;


import javax.validation.constraints.NotBlank;

public class Linha_DTO {
	
	@NotBlank(message = "Informe o id da linha.")
	private String id;

	@NotBlank(message = "Informe o nome da linha.")
	private String nome;
	
	@NotBlank(message = "Informe o código da linha.")
	private String codigo;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	

}
