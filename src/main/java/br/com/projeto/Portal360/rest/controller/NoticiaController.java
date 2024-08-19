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

import br.com.projeto.Portal360.service.NoticiaService;
import br.com.projeto.Portal360.model.entity.Noticia;

@RestController
@RequestMapping("/noticia/")
public class NoticiaController {

	private NoticiaService noticiaService;

	public NoticiaController(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Noticia>> findAll() {

		List<Noticia> noticias = noticiaService.findAll();

		return new ResponseEntity<List<Noticia>>(noticias, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Noticia> findById(@PathVariable long id) {
		Noticia noticia = noticiaService.findById(id);

		return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Noticia> create(@RequestBody Noticia noticia) {

		Noticia _noticia = noticiaService.create(noticia);

		return new ResponseEntity<Noticia>(_noticia, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<Noticia> inativar(@PathVariable long id) {
		Noticia noticia = noticiaService.inativar(id);

		return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
	}

	@PutMapping("alterar/{id}")
	public ResponseEntity<Noticia> alterar(@PathVariable long id, @RequestBody Noticia noticia) {

		Noticia _noticia = noticiaService.alterar(id, noticia);

		return new ResponseEntity<Noticia>(_noticia, HttpStatus.OK);
	}

}
