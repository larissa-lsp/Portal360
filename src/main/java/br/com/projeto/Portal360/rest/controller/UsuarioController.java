package br.com.projeto.Portal360.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.Portal360.model.entity.Usuario;
import br.com.projeto.Portal360.rest.exception.ResourceNotFoundException;
import br.com.projeto.Portal360.service.UsuarioService;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
/*	ADM
 *	+ logar(): void
	+ cadastrarNovoColaborador(): Colaborador
	+ consultarColaborador(Colaborador): Colaborador 
	+ editarColaborador(Colaborador): Colaborador
	+ inativarColaborador(Colaborador): void
	+ aprovarNoticia(Noticia): void
	+ criarNoticia(): Noticia
	+ consultarNoticia(): Noticia
	+ editarNoticia(Noticia): Noticia
	
	Coloborador
	+ logar(): void
	+ criarNoticia(): Noticia
	+ consultarNoticia(): Noticia
	+ editarNoticia(Noticia): Noticia
	+ inativarNoticia(Noticia): boolean
	+ enviarMensagem: Mensagem
	
	Leitor
	+ compartilharNoticia(Noticia): void
	+ visualizarNoticia(): Noticia
	+ enviarMensagem: Mensagem*/

	@GetMapping("findAll")
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> usuarios = usuarioService.findAll();

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id) {
		Usuario usuario = usuarioService.findById(id);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@GetMapping("findByEmail/")

	public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {
		Usuario usuario = usuarioService.findByEmail(email);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		Usuario _usuario = usuarioService.create(usuario);

		return new ResponseEntity<Usuario>(_usuario, HttpStatus.OK);
	}
	
	/*@PostMapping("signin")
	public ResponseEntity<?> signin(
			@RequestParam String email, @RequestParam String senha) {
		Usuario usuario = usuarioService.signin(email, senha);

		if (usuario != null) {
			return ResponseEntity.ok().body(usuario);
		}
		return ResponseEntity.badRequest().body("Dados incorretos");
	}
	*/
	@PostMapping("signin")
	public ResponseEntity<?> signin(@RequestBody Usuario usuario) {

		Usuario _usuario = usuarioService
				.signin(usuario.getEmail(), usuario.getSenha());

		if (_usuario == null) {
			throw new ResourceNotFoundException("*** Dados Incorretos! *** ");
		}

		return ResponseEntity.ok(_usuario);
	}

	@PutMapping("inativar/{id}")
	public ResponseEntity<Usuario> inativar(@PathVariable long id) {
		Usuario usuario = usuarioService.inativar(id);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<Usuario> reativar(@PathVariable long id) {
		Usuario usuario = usuarioService.reativar(id);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@PutMapping("alterarSenha/{id}")
	public ResponseEntity<Usuario> alterarSenha(@PathVariable long id, @RequestBody Usuario usuario) {
		Usuario _usuario = usuarioService.alterarSenha(id, usuario);

		return new ResponseEntity<Usuario>(_usuario, HttpStatus.OK);
	}
}
