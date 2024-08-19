package br.com.projeto.Portal360.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.Portal360.model.entity.Usuario;
import br.com.projeto.Portal360.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		return usuarios;
	}

	public Usuario findById(long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();

		return usuario;
	}

	public Usuario findByEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);

		return usuario;
	}

	@Transactional
	public Usuario create(Usuario usuario) {

		String senha = Base64.getEncoder().encodeToString(usuario.getSenha().getBytes());

		usuario.setSenha(senha);
		usuario.setStatusUsuario("ATIVO");

		return usuarioRepository.save(usuario);
	}

	@Transactional
	public Usuario signin(String email, String senha) {

		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario != null) {
			if (!usuario.getStatusUsuario().equals("INATIVO")) {
				byte[] decodedPass = Base64.getDecoder().decode(usuario.getSenha());

				if (new String(decodedPass).equals(senha)) {
					return usuario;
				}
			}
		}
		return null;
	}

	@Transactional
	public Usuario inativar(long id) {

		Optional<Usuario> _usuario = usuarioRepository.findById(id);

		if (_usuario.isPresent()) {
			Usuario usuarioAtualizado = _usuario.get();
			usuarioAtualizado.setStatusUsuario("INATIVO");

			return usuarioRepository.save(usuarioAtualizado);
		}
		return null;
	}

	@Transactional
	public Usuario reativar(long id) {

		Optional<Usuario> _usuario = usuarioRepository.findById(id);

		if (_usuario.isPresent()) {
			Usuario usuarioAtualizado = _usuario.get();
			usuarioAtualizado.setStatusUsuario("ATIVO");
			String senha = Base64.getEncoder().encodeToString("12345678".getBytes());
			usuarioAtualizado.setSenha(senha);

			return usuarioRepository.save(usuarioAtualizado);
		}
		return null;
	}

	@Transactional
	public Usuario alterarSenha(long id, Usuario usuario) {

		Optional<Usuario> _usuario = usuarioRepository.findById(id);

		if (_usuario.isPresent()) {
			Usuario usuarioAtualizado = _usuario.get();

			String senha = Base64.getEncoder().encodeToString(usuario.getSenha().getBytes());
			usuarioAtualizado.setSenha(senha);

			return usuarioRepository.save(usuarioAtualizado);
		}
		return null;
	}

}
