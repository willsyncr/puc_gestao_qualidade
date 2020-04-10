package br.com.puc.gestaoqualidade;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.puc.gestaoqualidade.model.ProfileENUM;

/**
 * 
 * @author willsyncr
 * 
 */
@ViewScoped
@ManagedBean
public class CriaIncidenteMB extends AbstractMB implements Serializable {

	private static final long serialVersionUID = 3407200317460558632L;

	public CriaIncidenteMB() {
		super();
	}

	private String area;
	private String turno;
	private String descricao;
	private String motivo;
	private String status;
	private Date dataCriacao;
	private Date previsaoCorrecao;
	private boolean paraProducao;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getDataCriacao() {
		if (dataCriacao == null) {
			dataCriacao = new Date();
		}
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getPrevisaoCorrecao() {
		return previsaoCorrecao;
	}

	public void setPrevisaoCorrecao(Date previsaoCorrecao) {
		this.previsaoCorrecao = previsaoCorrecao;
	}

	public boolean isParaProducao() {
		return paraProducao;
	}

	public void setParaProducao(boolean paraProducao) {
		this.paraProducao = paraProducao;
	}

	public String criaIncidente() {
		addMessage("Incidente Registrado com sucesso!!!", "");
		return "";
	}
	public String pararProducao() {
		addMessage("Incidente Registrado com sucesso!!!", "");
		addMessage("Requisção de Parada de Producao realizada com sucesso!!!", "");
		return "";
	}

	public String logout() {
		getFacesContext().getExternalContext().getSessionMap().clear();
		return "/login.jsf?faces-redirect=true";
	}

	@Override
	public boolean isUsuarioTemPermissaoTela() {
		if(getUsuarioLogado().getPerfil().equals(ProfileENUM.VENDEDOR) || getUsuarioLogado().getPerfil().equals(ProfileENUM.CLIENTE) || getUsuarioLogado().getPerfil().equals(ProfileENUM.MONTADOR) || getUsuarioLogado().getPerfil().equals(ProfileENUM.ADMINISTRADOR)) {
			return true;
		}
		return false;
	}
	public boolean isUsuarioTemPermissaoPararProducao() {
		if(getUsuarioLogado().getPerfil().equals(ProfileENUM.MONTADOR) || getUsuarioLogado().getPerfil().equals(ProfileENUM.ADMINISTRADOR)) {
			return true;
		}
		return false;
	}
	public boolean isUsuarioVendedor() {
		if(getUsuarioLogado().getPerfil().equals(ProfileENUM.VENDEDOR)) {
			return true;
		}
		return false;
	}
	public boolean isUsuarioMontador() {
		if(getUsuarioLogado().getPerfil().equals(ProfileENUM.MONTADOR) || getUsuarioLogado().getPerfil().equals(ProfileENUM.ADMINISTRADOR)) {
			return true;
		}
		return false;
	}
	public boolean isUsuarioCliente() {
		if(getUsuarioLogado().getPerfil().equals(ProfileENUM.CLIENTE)) {
			return true;
		}
		return false;
	}

}
