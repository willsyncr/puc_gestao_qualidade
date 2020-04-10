package br.com.puc.gestaoqualidade;

import java.io.Serializable;
import java.util.ArrayList;
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
public class RecallMB extends AbstractMB implements Serializable {

	private static final long serialVersionUID = 3407200317460558632L;

	public RecallMB() {
		super();
	}
	
	@ManagedProperty(value="#{incidenteDatabaseService}")
    private IncidenteDatabase incidenteService;	

    private List<Incidente> incidentes;
    private List<Incidente> incidentesTratados;
     
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

	public List<Incidente> getIncidentesTratados() {
		List<Incidente> incidentesTratadosBuild = new ArrayList<Incidente>();
		if(getIncidentes() != null && incidentesTratados == null) {
			for (Incidente incidente : getIncidentes()) {
				if (incidente.getStatus().equalsIgnoreCase("Tratado") ) {
					incidente.setRecall("Sim");
					incidente.setDataTratamento(new Date());
					incidentesTratadosBuild.add(incidente);
				}
				
			}
			incidentesTratados = incidentesTratadosBuild;
		}
		return incidentesTratados;
	}

	public void setIncidentesTratados(List<Incidente> incidentesTratados) {
		this.incidentesTratados = incidentesTratados;
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
	public String enviarRecall() {
		getSelectedIncidente().setRecallEnviado("Sim");
		addMessage("Recall enviado aos parceiros com sucesso!!!", "");
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
