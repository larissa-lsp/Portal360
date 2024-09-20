package br.com.projeto.Portal360.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.projeto.Portal360.model.entity.Noticia;
import br.com.projeto.Portal360.model.entity.Usuario;
import br.com.projeto.Portal360.model.repository.NoticiaRepository;
import br.com.projeto.Portal360.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class NoticiaService {

	private NoticiaRepository noticiaRepository;
	
	private UsuarioRepository usuarioRepository;

	public NoticiaService(NoticiaRepository noticiaRepository, UsuarioRepository usuarioRepository) {
		super();
		this.noticiaRepository = noticiaRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public List<Noticia> findAll() {
		List<Noticia> noticias = noticiaRepository.findAll();

		return noticias;
	}
	
	public Noticia findById(long id) {
		Noticia noticia = noticiaRepository.findById(id).orElseThrow();

		return noticia;
	}

	@Transactional
	public Noticia create(Noticia noticia) {

		noticia.setDataEnvio(LocalDateTime.now());
		noticia.setDataPublicacao(null);
		noticia.setStatusNoticia("ATIVO");

		return noticiaRepository.save(noticia);
	}

	@Transactional
	public Noticia inativar(long id) {

		Optional<Noticia> _noticia = noticiaRepository.findById(id);

		if (_noticia.isPresent()) {
			Noticia noticiaAtualizada = _noticia.get();
			noticiaAtualizada.setStatusNoticia(null);

			return noticiaRepository.save(noticiaAtualizada);
		}
		return null;
	}

	@Transactional
	public Noticia alterar(long id, Noticia noticia) {

		Optional<Noticia> _noticia = noticiaRepository.findById(id);

		if (_noticia.isPresent()) {
			Noticia noticiaAtualizada = _noticia.get();

			noticiaAtualizada.setConteudo(noticia.getConteudo());
			noticiaAtualizada.setPalavrasChave(noticia.getPalavrasChave());
			noticiaAtualizada.setFonte(noticia.getFonte());

			return noticiaRepository.save(noticiaAtualizada);
		}
		return null;
	}

	@Transactional
	public Noticia createComFoto(MultipartFile file, Noticia noticia, long id) {
		
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();
		
		if (file != null && file.getSize() > 0) {
			try {
				noticia.setFoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			noticia.setFoto(null);
		}
		noticia.setUsuario(usuario);
		noticia.setDataEnvio(LocalDateTime.now());
		noticia.setDataPublicacao(null);
		noticia.setStatusNoticia("ATIVO");

		return noticiaRepository.save(noticia);
	}

}
