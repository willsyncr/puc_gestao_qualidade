package br.com.puc.gestaoqualidade;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.puc.gestaoqualidade.model.Usuario;

public abstract class AbstractMB {

	public Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if (getFacesContext().getExternalContext().getSessionMap().containsKey("usuario")) {
			usuarioLogado = (Usuario) getFacesContext().getExternalContext().getSessionMap().get("usuario");
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public abstract boolean isUsuarioTemPermissaoTela();
}
