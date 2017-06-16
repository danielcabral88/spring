package com.aprendizagem.festa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.aprendizagem.festa.model.Convidado;
import com.aprendizagem.festa.repository.Convidados;



@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;

	@RequestMapping
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("ListarConvidados");
		mv.addObject("convidados", convidados.todos());
		mv.addObject(new Convidado());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Convidado convidado){
		this.convidados.adicionar(convidado);
		return "redirect:/convidados";

	}

}

