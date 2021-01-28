package Constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HyperLink_Constant {


	
	ATUALIZAR("UPDATE"),
	EXCLUIR("DELETE"),
	LISTAR("GET_ALL"),
	CONSULTAR("GET");
	
	HyperLink_Constant(String string) {
		this.setValor("");
		// TODO Auto-generated constructor stub
	}

	void HyperLinkConstant(String string) {
		this.setValor("");
		// TODO Auto-generated constructor stub
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	private String valor;
	

}