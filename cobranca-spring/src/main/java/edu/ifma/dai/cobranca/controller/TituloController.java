package edu.ifma.dai.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifma.dai.cobranca.model.StatusTitulo;
import edu.ifma.dai.cobranca.model.Titulo;
import edu.ifma.dai.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")
	public String novo( Titulo titulo ) {

		//ModelAndView mv = new ModelAndView("cadastroTitulo");
		//mv.addObject(titulo);
		return "cadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {

		ModelAndView mv = new ModelAndView("cadastroTitulo");
		if (errors.hasErrors()) {
			return mv;
		}
		titulos.save(titulo);
		attributes.addFlashAttribute("mensagem", "Título Salvo com Sucesso");
		ModelAndView mv2 = new ModelAndView("redirect:/titulos/novo");
		
		return mv2;
	}

	@RequestMapping
	public ModelAndView pesquisar() {

		List<Titulo> todosOsTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("pesquisaTitulos");

		mv.addObject("titulos", todosOsTitulos);
		return mv;
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
}
