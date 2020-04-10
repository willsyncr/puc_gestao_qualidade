package br.com.puc.gestaoqualidade;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.puc.gestaoqualidade.model.ProfileENUM;
import br.com.puc.gestaoqualidade.model.Usuario;

/**
 * 
 * @author willsyncr
 * 
 */
@ViewScoped
@ManagedBean
public class LoginMB extends AbstractMB implements Serializable {

	private static final long serialVersionUID = 3407200317460558632L;

	public LoginMB() {
		super();

	}

	private String login;
	private String senha;

	public boolean validate(Usuario domainBean) {
		return true;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String executeLogin() {
		Usuario usuario = null;

		if (getLogin().equalsIgnoreCase("admin")) {
			usuario = loginUsuarioAdmin("Paulo Ricardo", getLogin(), ProfileENUM.ADMINISTRADOR);
		} else if (getLogin().equalsIgnoreCase("vendedor")) {
			usuario = loginUsuarioAdmin("Samuel Rosa",getLogin(), ProfileENUM.VENDEDOR);
		} else if (getLogin().equalsIgnoreCase("Vanderson")) {
			usuario = loginUsuarioAdmin("Vanderson Lins Matos",getLogin(), ProfileENUM.VENDEDOR);
		} else if (getLogin().equalsIgnoreCase("Montador")) {
			usuario = loginUsuarioAdmin("Juvenal Antena",getLogin(), ProfileENUM.MONTADOR);
		} else if (getLogin().equalsIgnoreCase("Mauro")) {
			usuario = loginUsuarioAdmin("Mauro Borges",getLogin(), ProfileENUM.MONTADOR);
		} else if (getLogin().equalsIgnoreCase("Cliente")) {
			usuario = loginUsuarioAdmin("Viviane Araudo",getLogin(), ProfileENUM.CLIENTE);
		} else if (getLogin().equalsIgnoreCase("Claudio")) {
			usuario = loginUsuarioAdmin("Claudio Reis",getLogin(), ProfileENUM.CLIENTE);
		}

		if (usuario != null) {
			getFacesContext().getExternalContext().getSessionMap().put("usuario", usuario);
			return "home?faces-redirect=true";
		} else {
			addMessage("Login ou Senha inválidos", "");
			return null;
		}
	}

	private Usuario loginUsuarioAdmin(String nomeUsuario, String login, ProfileENUM profileEnum) {
		Usuario usuario = new Usuario();
		usuario.setNome(nomeUsuario);
		usuario.setLogin(login);
		usuario.setSenha(getSenha());
		usuario.setPerfil(profileEnum);
		usuario.setLogado(true);
		return usuario;
	}

	public String logout() {
		getFacesContext().getExternalContext().getSessionMap().clear();
		return "login";
	}
	
	@Override
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	 
	@Override
	public boolean isUsuarioTemPermissaoTela() {
		return true;
	}
	
}
