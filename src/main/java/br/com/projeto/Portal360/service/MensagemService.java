package br.com.projeto.Portal360.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import br.com.projeto.Portal360.model.entity.Mensagem;
import br.com.projeto.Portal360.model.repository.MensagemRepository;
import jakarta.transaction.Transactional;

@Service
public class MensagemService {

	private MensagemRepository mensagemRepository;

	public MensagemService(MensagemRepository mensagemRepository) {
		super();
		this.mensagemRepository = mensagemRepository;
	}

	public List<Mensagem> findAll() {
		List<Mensagem> mensagem = mensagemRepository.findAll();
		return mensagem;
	}
	
	@Transactional
	public Mensagem create(Mensagem mensagem){
		mensagem.setDataMensagem(LocalDateTime.now());
		mensagem.setTipo("MENSAGEM");
		mensagem.setStatusMensagem("ATIVO");
		
		return mensagemRepository.save(mensagem);
	}
	
	@Transactional
	public Mensagem update(long id) {
		
		Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
		
		if(_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("LIDA");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}
	@Transactional
	public Mensagem inativar(long id) {
		
		Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
		
		if(_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("INATIVO");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		return null;
	}

	public Mensagem findById(long id) {
		Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
		if (_mensagem.isPresent()) {
			Mensagem mensagem = _mensagem.get();
			return mensagem;
		}
		return null;
	}
	
}
