package com.aprendizagem.festa.model;

public class Convidado {

	private String nome;
	private Integer qtdConvidados;
	
	public Convidado(){
		
	}
	
	public Convidado(String nome, Integer qtdConvidados){
		this.nome = nome;
		this.qtdConvidados = qtdConvidados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdConvidados() {
		return qtdConvidados;
	}

	public void setQtdConvidados(Integer qtdConvidados) {
		this.qtdConvidados = qtdConvidados;
	}
}
