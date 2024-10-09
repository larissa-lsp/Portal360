package br.com.projeto.Portal360.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projeto.Portal360.service.NoticiaService;
import br.com.projeto.Portal360.model.entity.Noticia;
import br.com.projeto.Portal360.rest.response.MessageResponse;

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
	
	@GetMapping("findAll_Publicadas")
	public ResponseEntity<List<Noticia>> findAll_Publicadas() {

		List<Noticia> noticias = noticiaService.findAll_Publicadas();

		return new ResponseEntity<List<Noticia>>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("findAll_EmAnalise")
	public ResponseEntity<List<Noticia>> findAll_EmAnalise() {

		List<Noticia> noticias = noticiaService.findAll_EmAnalise();

		return new ResponseEntity<List<Noticia>>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("findAll_Pubs_EmAnalise")
	public ResponseEntity<List<Noticia>> findAll_Pubs_EmAnalise() {

		List<Noticia> noticias = noticiaService.findAll_Pubs_EmAnalise();

		return new ResponseEntity<List<Noticia>>(noticias, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Noticia> findById(@PathVariable long id) {
		Noticia noticia = noticiaService.findById(id);

		return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Noticia> create(@ModelAttribute Noticia noticia) {
		
		System.out.println(noticia.getManchete());
		
		Noticia _noticia = noticiaService.create(noticia);

		return new ResponseEntity<Noticia>(_noticia, HttpStatus.OK);
	}
	
	@PostMapping("createComFoto/{email}")
	public ResponseEntity<?> createComFoto(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute("noticia") Noticia noticia, @PathVariable String email ) {

		noticiaService.createComFoto(file, noticia, email);
	
		return ResponseEntity.ok()
				.body(new MessageResponse("Notícia cadastrada com sucesso!"));
	}
		
	@PutMapping("publicar/{id}")
	public ResponseEntity<Noticia> publicar(@PathVariable long id) {
		Noticia noticia = noticiaService.publicar(id);

		return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<Noticia> inativar(@PathVariable long id) {
		Noticia noticia = noticiaService.inativar(id);

		return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
	}

	@PutMapping("alterar/{id}")
	public ResponseEntity<?> alterar(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@PathVariable long id, @ModelAttribute Noticia noticia) {
		
		noticiaService.alterar(file, id, noticia);

		return ResponseEntity.ok()
				.body(new MessageResponse("Notícia alterada com sucesso!"));
	}

}
