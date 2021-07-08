package com.baccarin.cadastro.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import com.baccarin.cadastro.pessoa.model.*;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    @Query("select p from Pessoa p where p.identificador like ?1")
    public Optional<Pessoa> findPessoaByIdentificador(String identificador);

}
