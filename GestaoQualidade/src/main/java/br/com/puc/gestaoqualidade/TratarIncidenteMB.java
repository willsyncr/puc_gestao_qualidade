package br.com.puc.gestaoqualidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.puc.gestaoqualidade.model.Incidente;
import br.com.puc.gestaoqualidade.model.ProfileENUM;

/**
 * 
 * @author willsyncr
 * 
 */
@ViewScoped
@ManagedBean
public class TratarIncidenteMB extends AbstractMB implements Serializable {

	private static final long serialVersionUID = 3407200317460558632L;

	public TratarIncidenteMB() {
		super();
	}
	
	@ManagedProperty(value="#{incidenteDatabaseService}")
    private IncidenteDatabase incidenteService;	

    private List<Incidente> incidentes;
     
    private Incidente selectedIncidente;
	
	private String status;
	private String descricao;
	private Date previsaoCorrecao;

	
	public IncidenteDatabase getIncidenteService() {
		return incidenteService;
	}

	public void setIncidenteService(IncidenteDatabase incidenteService) {
		this.incidenteService = incidenteService;
	}

	public List<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}

	public Incidente getSelectedIncidente() {
		return selectedIncidente;
	}

	public void setSelectedIncidente(Incidente selectedIncidente) {
		this.selectedIncidente = selectedIncidente;
	}

	@PostConstruct
    public void init() {
		incidentes = incidenteService.createIncidente(10);
    }
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getPrevisaoCorrecao() {
		if(previsaoCorrecao == null) {
			previsaoCorrecao = new Date();
		}
		return previsaoCorrecao;
	}
	public void setPrevisaoCorrecao(Date previsaoCorrecao) {
		this.previsaoCorrecao = previsaoCorrecao;
	}
	public String alterarIncidente() {
		addMessage("Tratativa Incidente Registrada com sucesso!!!", "");
		return "";
	}
	public String enviaRecall() {
		addMessage("Incidente tratado e solicitação de Recall Registrado com sucesso!!!", "");
		return "";
	}
 
    private void showMessage(String clientId) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
    }
	
	@Override
	public boolean isUsuarioTemPermissaoTela() {
		if(getUsuarioLogado().getPerfil().equals(ProfileENUM.ADMINISTRADOR)) {
			return true;
		}
		return false;
	}
}
