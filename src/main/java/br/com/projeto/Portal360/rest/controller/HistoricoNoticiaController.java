package br.com.projeto.Portal360.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.Portal360.model.entity.HistoricoNoticia;
import br.com.projeto.Portal360.service.HistoricoNoticiaService;

@RestController
@RequestMapping("/historicoNoticia/")
public class HistoricoNoticiaController {

	private HistoricoNoticiaService historicoNoticiaService;

	public HistoricoNoticiaController(HistoricoNoticiaService historicoNoticiaService) {
		this.historicoNoticiaService = historicoNoticiaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<HistoricoNoticia>> FindAll() {
		List<HistoricoNoticia> historicosNoticias = historicoNoticiaService.findAll();
		return new ResponseEntity<List<HistoricoNoticia>>(historicosNoticias, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<HistoricoNoticia> create(@RequestBody HistoricoNoticia historicoNoticia){
		HistoricoNoticia _historicoNoticia = historicoNoticiaService.create(historicoNoticia);
		
		return new ResponseEntity<HistoricoNoticia>(_historicoNoticia, HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<HistoricoNoticia> update(@PathVariable long id){
		HistoricoNoticia historicoNoticia = historicoNoticiaService.update(id);
		
		return new ResponseEntity<HistoricoNoticia>(historicoNoticia, HttpStatus.OK);
	}
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<HistoricoNoticia> inativar(@PathVariable long id){
		HistoricoNoticia historicoNoticia = historicoNoticiaService.inativar(id);
		
		return new ResponseEntity<HistoricoNoticia>(historicoNoticia, HttpStatus.OK);
	}
}