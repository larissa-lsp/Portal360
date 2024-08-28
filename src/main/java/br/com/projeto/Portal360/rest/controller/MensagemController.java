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

import br.com.projeto.Portal360.model.entity.Mensagem;
import br.com.projeto.Portal360.rest.exception.ResourceNotFoundException;
import br.com.projeto.Portal360.rest.response.MessageResponse;
import br.com.projeto.Portal360.service.MensagemService;

@RestController
@RequestMapping("/mensagem/")
public class MensagemController {

	private MensagemService mensagemService;

	public MensagemController(MensagemService mensagemService) {
		super();
		this.mensagemService = mensagemService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Mensagem>> findAll() {
		List<Mensagem> mensagens = mensagemService.findAll();

		return new ResponseEntity<List<Mensagem>>(mensagens, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Mensagem> findById(@PathVariable long id) {

		Mensagem mensagem = mensagemService.findById(id);

		if (mensagem != null) {
			return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("*** Mensagem não encontrada! *** " + "ID: " + id);
		}

	}

	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody Mensagem mensagem) {

		Mensagem _mensagem = mensagemService.create(mensagem);

		if (_mensagem == null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Mensagem já cadastrada!"));
		}
		return ResponseEntity.ok().body(new MessageResponse("Mensagem enviada com sucesso!"));
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<Mensagem> inativar(@PathVariable long id) {

		Mensagem _mensagem = mensagemService.inativar(id);

		return new ResponseEntity<Mensagem>(_mensagem, HttpStatus.OK);
	}

	@PutMapping("marcarComoLida/{id}")
	public ResponseEntity<Mensagem> marcarComoLida(@PathVariable long id) {

		Mensagem _mensagem = mensagemService.marcarComoLida(id);

		return new ResponseEntity<Mensagem>(_mensagem, HttpStatus.OK);
	}
}