package com.coding.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coding.web.models.NuevaPregunta;
import com.coding.web.models.Preguntas;
import com.coding.web.models.Respuestas;
import com.coding.web.services.MainService;


@Controller
public class MainController {
	@Autowired
	private MainService mainService;

	
	@GetMapping("/")
	 public String raiz() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	 public String questions(Model viewModel) {
		viewModel.addAttribute("allQuestions", mainService.allQuestions());
		return "raiz.jsp";
	}
	
	@GetMapping("/questions/new")
	 public String questionsFormular(@ModelAttribute("question") Preguntas pregunta) {
		return "qformular.jsp";
	}


	@PostMapping("/questions/new")
	 public String questionsCreate(@Validated @ModelAttribute("question") NuevaPregunta nuevaPregunta, 
			 BindingResult resultado ) 
	{
		if(resultado.hasErrors()) {
		return "qformular.jsp";
		}
		mainService.crearPregunta(nuevaPregunta);
		return "redirect:/";
	}
	
	@GetMapping("/questions/{idQuestion}")
	public String mostrarPregunta(@PathVariable("idQuestion") Long idQuestion,
			@ModelAttribute("question") Preguntas preguntas, @ModelAttribute("respuesta_add") Respuestas respuesta_add, 
			Model viewModel) {
		Preguntas pregunta = mainService.findPreguntaByid(idQuestion);
		viewModel.addAttribute("question", pregunta);
		return "detail.jsp";
	}
	@PostMapping("/answers/new")
	 public String answerCreate( @Validated @ModelAttribute("respuesta_add") Respuestas respuesta, 
			 BindingResult resultado ) 
	{
		if(resultado.hasErrors()) {
		return "detail.jsp";
		}
		
		mainService.crearRespuesta(respuesta);
		
		return "redirect:/questions/"+respuesta.getPregunta().getId();
	}
	
	

}
