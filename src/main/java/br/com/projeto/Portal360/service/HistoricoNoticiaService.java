package br.com.projeto.Portal360.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.Portal360.model.entity.HistoricoNoticia;
import br.com.projeto.Portal360.model.repository.HistoricoNoticiaRepository;
import jakarta.transaction.Transactional;

@Service
public class HistoricoNoticiaService {

	private HistoricoNoticiaRepository historicoNoticiaRepository;

	public HistoricoNoticiaService(HistoricoNoticiaRepository historicoNoticiaRepository) {
		super();
		this.historicoNoticiaRepository = historicoNoticiaRepository;
	}

	public List<HistoricoNoticia> findAll() {
		List<HistoricoNoticia> historicoNoticia = historicoNoticiaRepository.findAll();
		return historicoNoticia;
	}
	
	@Transactional
	public HistoricoNoticia create(HistoricoNoticia historicoNoticia){
		historicoNoticia.setStatusHistoricoNoticia("ATIVO");

		return historicoNoticiaRepository.save(historicoNoticia);
	}
	
	@Transactional
	public HistoricoNoticia update(long id) {
		
		Optional<HistoricoNoticia> _historicoNoticia = historicoNoticiaRepository.findById(id);
		
		if(_historicoNoticia.isPresent()) {
			HistoricoNoticia historicoNoticiaAtualizado = _historicoNoticia.get();
			historicoNoticiaAtualizado.setStatusHistoricoNoticia("LIDA");
			
			return historicoNoticiaRepository.save(historicoNoticiaAtualizado);
		}
		return null;
	}
	@Transactional
	public HistoricoNoticia inativar(long id) {
		
		Optional<HistoricoNoticia> _historicoNoticia = historicoNoticiaRepository.findById(id);
		
		if(_historicoNoticia.isPresent()) {
			HistoricoNoticia historicoNoticiaAtualizado = _historicoNoticia.get();
			historicoNoticiaAtualizado.setStatusHistoricoNoticia("INATIVO");
			
			return historicoNoticiaRepository.save(historicoNoticiaAtualizado);
		}
		return null;
	}
}
	
