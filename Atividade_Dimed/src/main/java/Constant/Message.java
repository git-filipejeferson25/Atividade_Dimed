package Constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Message {

	ERRO_GENERICO("Erro interno identificado. Contate o suporte."),
	ERRO_ITINERÁRIO_NAO_ENCONTRADO("Itinerário não encontrado."),
	ERRO_ITINERÁRIO_CADASTRADO_ANTERIORMENTE("Itinerário já cadastrado."),
	ERRO_LINHA_CADASTRADA_ANTERIORMENTE("Linha já cadastrada."),
	ERRO_LINHA_NAO_ENCONTRADA("Linha não encontrada."),
	ERRO_ID_INFORMADO("ID não pode ser informado na operação de cadastro.");
	
	Message(String m) {
		this.valor = "";
		// TODO Auto-generated constructor stub
	}

	public String getValor() {
		return valor;
	}

	private final String valor;


}
