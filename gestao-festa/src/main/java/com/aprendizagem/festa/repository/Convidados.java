package com.aprendizagem.festa.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.aprendizagem.festa.model.Convidado;

@Repository
public class Convidados {
	
	private static final List<Convidado> LISTA_CONVIDADOS = new ArrayList<>();
	
	static {
		LISTA_CONVIDADOS.add(new Convidado("Daniel Cabra", 1));
		LISTA_CONVIDADOS.add(new Convidado("Pedro Lucas", 2));
		LISTA_CONVIDADOS.add(new Convidado("Eliza Cabral", 3));
	}
	
	public List<Convidado> todos(){
		return Convidados.LISTA_CONVIDADOS;
	}
	
	public void adicionar(Convidado convidado){
		Convidados.LISTA_CONVIDADOS.add(convidado);
	}

}
