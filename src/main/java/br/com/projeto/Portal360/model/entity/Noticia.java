package br.com.projeto.Portal360.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Noticia")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String manchete;
	private String conteudo;
	private String palavrasChave;
	private LocalDateTime dataEnvio;
	private LocalDateTime dataPublicacao;
	private byte[] foto;
	private String fonte;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	private String statusNoticia;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getManchete() {
		return manchete;
	}


	public void setManchete(String manchete) {
		this.manchete = manchete;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public String getPalavrasChave() {
		return palavrasChave;
	}


	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}


	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}


	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}


	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}


	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}


	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	public String getFonte() {
		return fonte;
	}


	public void setFonte(String fonte) {
		this.fonte = fonte;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getStatusNoticia() {
		return statusNoticia;
	}


	public void setStatusNoticia(String statusNoticia) {
		this.statusNoticia = statusNoticia;
	}

	
}