package br.com.projeto.Portal360.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.Portal360.model.entity.HistoricoNoticia;

@Repository
public interface HistoricoNoticiaRepository extends JpaRepository<HistoricoNoticia, Long>{

}
