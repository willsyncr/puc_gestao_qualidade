package br.com.puc.gestaoqualidade.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public String nome;
	public String login;
	public String senha;
	public boolean logado;
	public ProfileENUM perfil;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isLogado() {
		return logado;
	}
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ProfileENUM getPerfil() {
		return perfil;
	}
	public void setPerfil(ProfileENUM perfil) {
		this.perfil = perfil;
	}
	
}
