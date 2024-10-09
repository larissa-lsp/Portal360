package br.com.projeto.Portal360.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.projeto.Portal360.model.entity.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

	List<Noticia> findByStatusNoticia(String statusNoticia);
	List<Noticia> findByStatusNoticiaNot(String statusNoticia);
	
}
