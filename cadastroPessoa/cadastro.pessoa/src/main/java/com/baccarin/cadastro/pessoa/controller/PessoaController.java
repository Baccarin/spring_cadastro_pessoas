package com.baccarin.cadastro.pessoa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.baccarin.cadastro.pessoa.model.*;
import com.baccarin.cadastro.pessoa.repository.PessoaRepository;
import com.baccarin.cadastro.pessoa.response.PessoaResponse;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> getPessoas() {
		return pessoaRepository.findAll();
	}

	/*@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}*/

	@PostMapping(produces = "application/json")
	public ResponseEntity<PessoaResponse> createPessoa(@RequestBody Pessoa pessoa) {
		Optional<Pessoa> txtIdentificador = pessoaRepository.findPessoaByIdentificador(pessoa.getIdentificador());
		PessoaResponse response = new PessoaResponse();
		if (txtIdentificador.isPresent()) {
			response.setMensagem("Identificador deve ser único.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
		
			pessoaRepository.save(pessoa);
			response.setPessoa(pessoa);
			response.setMensagem("Success");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	}
}
