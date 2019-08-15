package com.br.adivinhacao.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Jogador implements Serializable {
	private static final long serilVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome obrigatorio")
	@NotNull
	private String nome;
	
	@DecimalMin(value = "1", message = "numero do jogo deve ser entre 1 e 5")
	private Integer numeroJogado;

	@OneToOne(cascade = { CascadeType.ALL})
	private NumeroSorteado numeroSorteado;
	
	public Jogador() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroJogado() {
		return numeroJogado;
	}

	public void setNumeroJogado(Integer numeroJogado) {
		this.numeroJogado = numeroJogado;
	}
	public NumeroSorteado getNumeroSorteado() {
		return numeroSorteado;
	}

	public void setNumeroSortiado(NumeroSorteado numeroSorteado) {
		this.numeroSorteado = numeroSorteado;
	}
	
	
}
