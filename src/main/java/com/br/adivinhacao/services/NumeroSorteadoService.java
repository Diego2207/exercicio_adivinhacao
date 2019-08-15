package com.br.adivinhacao.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.adivinhacao.models.Jogador;
import com.br.adivinhacao.models.NumeroSorteado;
import com.br.adivinhacao.repositories.JogadorRepository;
import com.br.adivinhacao.repositories.NumeroSorteadoRepository;

@Service
public class NumeroSorteadoService {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private NumeroSorteadoRepository numeroSorteadoRepository;
	
	public String salvarJogo(Jogador jogador) {
		
		NumeroSorteado jogo = new NumeroSorteado();
		Random random = new Random();
		int numero = 1+random.nextInt(5);
		String mensagen = "";
		
		if(jogador.getNumeroJogado()== numero) {
			jogo.setNumero(numero);
			jogo.setJogador(jogador);
			jogador.setNumeroSortiado(jogo);
			jogadorRepository.save(jogador);
			
			mensagen = "Boa você ganhou\nNumero jogado "+ jogador.getNumeroJogado()+ "numero Sorteado" + numero;
		}else {
			mensagen = "puxa você perdeu\nNumero jogado" + jogador.getNumeroJogado()+ "numero sorteado" + numero;
		}
		
		return mensagen;
	}
}
