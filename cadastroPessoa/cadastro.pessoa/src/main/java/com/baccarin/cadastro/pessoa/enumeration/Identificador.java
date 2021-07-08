package com.baccarin.cadastro.pessoa.enumeration;

public enum Identificador {

		CPF, CNPJ;
	
	public String getDescricao() {
		String descricao = "";
		switch (this) {
		case CPF:
			descricao = "CPF";
			break;
		case CNPJ:
			descricao = "CNPJ";
			break;
		}
		return descricao;
	}
}
