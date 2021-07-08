package com.baccarin.cadastro.pessoa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.baccarin.cadastro.pessoa.enumeration.Identificador;

import lombok.Data;


@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(unique = true)
	private String identificador;
	private Identificador tipoIdentificador;
	
	public Pessoa() {
		
	}

	public Pessoa(Long id, String nome, String identificador) {
		super();
		this.id = id;
		this.nome = nome;
		this.identificador = identificador;
		this.tipoIdentificador = identificador.length() == 11 ? Identificador.CPF : Identificador.CNPJ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Identificador getTipoIdentificador() {
		return tipoIdentificador;
	}

	public void setTipoIdentificador(Identificador tipoIdentificador) {
		this.tipoIdentificador = tipoIdentificador;
	}

	
	
}
