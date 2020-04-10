package br.com.puc.gestaoqualidade.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Incidente  implements Serializable {

	private static final long serialVersionUID = 1L;

	public Incidente(String id, String area, String turno, String descricao, String motivo, String status, String paraProducao, String protocolo, Date dataTratamento, String descricaoTratamento ) {
        this.id = id;
        this.area = area;
        this.turno = turno;
        this.descricao = descricao;
        this.motivo = motivo;
        this.status = status;
        this.dataCriacao = new Date();
        this.paraProducao = paraProducao;
        this.dataTratamento = dataTratamento;
        this.protocolo = protocolo;
        this.descricaoTratamento = descricaoTratamento;
        this.recallEnviado = "Nao";
        this.textoRecall = "";
    }
     
	private String id;
	private String area;
	private String motivo;
	private String descricao;
	private String status;
	private Date dataCriacao;
	private String turno;
	private String recall;
	private String textoRecall;
	private Date previsaoCorrecao;
	private String paraProducao;
	private String protocolo;
	private Date dataTratamento;
	private String recallEnviado;
	private String dataTratamentoFormatado;
	private String descricaoTratamento;
	
	public String getDataTratamentoFormatado() {
		if(getDataTratamento() != null) {
			dataTratamentoFormatado = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(getDataTratamento());
		}
		return dataTratamentoFormatado;
	}
	public void setDataTratamentoFormatado(String dataTratamentoFormatado) {
		this.dataTratamentoFormatado = dataTratamentoFormatado;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public Date getDataTratamento() {
		return dataTratamento;
	}
	public void setDataTratamento(Date dataTratamento) {
		this.dataTratamento = dataTratamento;
	}
	public String getDescricaoTratamento() {
		return descricaoTratamento;
	}
	public void setDescricaoTratamento(String descricaoTratamento) {
		this.descricaoTratamento = descricaoTratamento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTextoRecall() {
		return textoRecall;
	}
	public void setTextoRecall(String textoRecall) {
		this.textoRecall = textoRecall;
	}
	public String getRecallEnviado() {
		return recallEnviado;
	}
	public void setRecallEnviado(String recallEnviado) {
		this.recallEnviado = recallEnviado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRecall() {
		return recall;
	}
	public void setRecall(String recall) {
		this.recall = recall;
	}
	public Date getDataCriacao() {
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
	public String getParaProducao() {
		return paraProducao;
	}
	public void setParaProducao(String paraProducao) {
		this.paraProducao = paraProducao;
	}
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Incidente other = (Incidente) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
	
}
