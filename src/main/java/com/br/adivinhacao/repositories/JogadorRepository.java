package com.br.adivinhacao.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.adivinhacao.models.Jogador;

public interface JogadorRepository extends CrudRepository<Jogador, Integer> {

}
