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

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import br.com.puc.gestaoqualidade.model.Incidente;
import br.com.puc.gestaoqualidade.model.ProfileENUM;

/**
 * 
 * @author willsyncr
 * 
 */
@ViewScoped
@ManagedBean
public class ReportIncidentesMB extends AbstractMB implements Serializable {

	private static final long serialVersionUID = 3407200317460558632L;

	public ReportIncidentesMB() {
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
		incidentes = incidenteService.createIncidente(50);
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
	public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
 
        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }

//	public void clearMultiViewState() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        String viewId = context.getViewRoot().getViewId();
//        PrimeFaces.current().multiViewState().clearAll(viewId, true, (clientId) -> {
//            showMessage(clientId);
//        });
//    }
 
    private void showMessage(String clientId) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
    }
	
	@Override
	public boolean isUsuarioTemPermissaoTela() {
		if(getUsuarioLogado().getPerfil().equals(ProfileENUM.ADMINISTRADOR) || getUsuarioLogado().getPerfil().equals(ProfileENUM.MONTADOR)) {
			return true;
		}
		return false;
	}
}
