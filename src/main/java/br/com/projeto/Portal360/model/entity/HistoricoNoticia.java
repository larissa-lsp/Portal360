package br.com.projeto.Portal360.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HistoricoNoticia")
public class HistoricoNoticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="noticia_id")
	private Noticia noticia;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	private LocalDate dataModeracao;
	private String observacoes;
	private String statusHistoricoNoticia;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataModeracao() {
		return dataModeracao;
	}

	public void setDataModeracao(LocalDate dataModeracao) {
		this.dataModeracao = dataModeracao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getStatusHistoricoNoticia() {
		return statusHistoricoNoticia;
	}

	public void setStatusHistoricoNoticia(String statusHistoricoNoticia) {
		this.statusHistoricoNoticia = statusHistoricoNoticia;
	}

}