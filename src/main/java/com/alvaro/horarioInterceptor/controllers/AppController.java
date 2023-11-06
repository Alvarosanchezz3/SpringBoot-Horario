package com.alvaro.horarioInterceptor.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({"/", "", "/index"})
	public String index (Model model) {
		
		model.addAttribute("titulo", "Bienvenido al horario de at.Cliente");
		return "index";
	}
	
	// Valores del application.properties
	
	@Value("${config.horario.apertura}") 
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	// Vista en caso de estar fuera del horario de at.Cliente
	
	@GetMapping("/cerrado")
	public String cerrado (Model model) {
		
		model.addAttribute("titulo", "Fuera de horario de atención");
		
		StringBuilder mensajeCierre = new StringBuilder
				("Cerrado, por favor, visítenos desde las " + apertura + " hasta las " + cierre);
		
		model.addAttribute("mensajeCierre", mensajeCierre);
		
		return "cerrado";
	}
}