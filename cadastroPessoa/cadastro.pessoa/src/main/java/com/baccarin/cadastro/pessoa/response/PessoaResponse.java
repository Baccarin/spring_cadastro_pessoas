package com.baccarin.cadastro.pessoa.response;

import com.baccarin.cadastro.pessoa.model.Pessoa;

public class PessoaResponse {

	private Pessoa pessoa;
	private String mensagem;
	
	public PessoaResponse() {
	}
	
	public PessoaResponse(Pessoa pessoa, String mensagem) {
		super();
		this.pessoa = pessoa;
		this.mensagem = mensagem;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
