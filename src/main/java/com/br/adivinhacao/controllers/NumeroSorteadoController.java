package com.br.adivinhacao.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.adivinhacao.models.Jogador;
import com.br.adivinhacao.services.JogadorService;
import com.br.adivinhacao.services.NumeroSorteadoService;

@Controller
public class NumeroSorteadoController {
	
	@Autowired
	private NumeroSorteadoService numeroSorteadoService;
	
	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping("/")
	public ModelAndView mapearHome() {
		ModelAndView modelAndView = new ModelAndView("home.html");
		modelAndView.addObject("ganhadores", jogadorService.listaGanhadores());
		return modelAndView;
	}
	
	@GetMapping("/jogar")
	public ModelAndView mapearJogar() {
		ModelAndView modelAndView = new ModelAndView("jogar.html");
		return modelAndView;
	}

	@PostMapping("/jogar")
	public ModelAndView salvarGanhador(@Valid Jogador jogador, BindingResult bindingJogador) {
		ModelAndView modelAndView = new ModelAndView("jogador.html");
		
		List<String> mensagens = new ArrayList<String>();
		List<String> erros = new ArrayList<String>();
		
		if(bindingJogador.hasErrors()) {
			modelAndView.addObject("erros", erros);
		}else {
			mensagens.add(numeroSorteadoService.salvarJogo(jogador));
			modelAndView.addObject("menssagens", mensagens);
		}
	}
	return modelAndView;

}
