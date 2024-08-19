package br.com.projeto.Portal360.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.Portal360.model.entity.Noticia;
import br.com.projeto.Portal360.model.repository.NoticiaRepository;
import jakarta.transaction.Transactional;

@Service
public class NoticiaService {

	private NoticiaRepository noticiaRepository;

	public NoticiaService(NoticiaRepository noticiaRepository) {
		this.noticiaRepository = noticiaRepository;
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

}
