package com.br.adivinhacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adivinhacao.models.Jogador;
import com.br.adivinhacao.repositories.JogadorRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	public void salvarJogador(Jogador jogador) {
		
		jogadorRepository.save(jogador);
	}
	
	public Iterable<Jogador> listaGanhadores(){
		
		return jogadorRepository.findAll();
	}
}
