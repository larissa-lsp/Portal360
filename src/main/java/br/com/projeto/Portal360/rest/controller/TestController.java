package br.com.projeto.Portal360.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

	@GetMapping("test")
	public String getTest() {
		return "Escreva sua mensagem!";
	}
		// END POINT
	@GetMapping("message")
	public String getMessage() {
		return "ROMERO É PAULEIRA!";
	}
	
	@GetMapping("ola")
	public String getOla() {
		return "Olá, mundo";
	}
}
