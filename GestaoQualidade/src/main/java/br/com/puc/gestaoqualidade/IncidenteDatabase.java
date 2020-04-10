package br.com.puc.gestaoqualidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


import br.com.puc.gestaoqualidade.model.Incidente;

@ManagedBean(name = "incidenteDatabaseService")
@ApplicationScoped
public class IncidenteDatabase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String[] areas;
	private final static String[] turnos;
	private final static String[] descricoes;
	private final static String[] motivos;
	private final static String[] status;
	private final static String[] simNao;
	private final static String[] protocolos;
	private final static Date[] datasTratamento;
	private final static String[] descricaoTratamentos;
    
	private static IncidenteDatabaseFactory factory = new IncidenteDatabaseFactory();

	public IncidenteDatabase criaEntityManager() {
		return new IncidenteDatabase();
	}
	
    static {
         
    	areas = new String[8];
    	areas[0] = "Estamparia";
    	areas[1] = "Estruturacao";
    	areas[2] = "Funilaria";
    	areas[3] = "Pintura";
    	areas[4] = "Portas";
    	areas[5] = "Motor";
    	areas[6] = "Montagem";
    	areas[7] = "Carro Pronto";

    	turnos = new String[3];
    	turnos[0] = "Matutino";
    	turnos[1] = "Vespertino";
    	turnos[2] = "Noturno";
    	
    	descricoes = new String[6];
    	descricoes[0] = "Funcionario Caiu na esteira";
    	descricoes[1] = "Porta desalinhada";
    	descricoes[2] = "Sensor de Mesa danificado";
    	descricoes[3] = "Pane do Exoesqueleto";
    	descricoes[4] = "Pane Maquina de Pintura";
    	descricoes[5] = "Acidente com Funcionario";

    	motivos = new String[3];
    	motivos[0] = "Acidente de Trabalho";
    	motivos[1] = "Deficiencia no Processo de Producao do Veiculo";
    	motivos[2] = "Irregularidade no Insumo";
    	
    	simNao = new String[2];
    	simNao[0] = "Sim";
    	simNao[1] = "Nao";
    	
    	status = new String[3];
    	status[0] = "Aberto";
    	status[1] = "Inativo";
    	status[2] = "Tratado";

    	protocolos = new String[21];
    	protocolos[0] = "20200804233";
    	protocolos[1] = "20200804231";
    	protocolos[2] = "20200804111";
    	protocolos[3] = "20200804332";
    	protocolos[4] = "20200804444";
    	protocolos[5] = "20200804342";
    	protocolos[6] = "20200804987";
    	protocolos[7] = "20200804883";
    	protocolos[8] = "20200804555";
    	protocolos[9] = "20200804233";
    	protocolos[10] = "20200804111";
    	protocolos[11] = "20200804112";
    	protocolos[12] = "20200804134";
    	protocolos[13] = "20200804136";
    	protocolos[14] = "20200804277";
    	protocolos[15] = "20200804355";
    	protocolos[16] = "20200804453";
    	protocolos[17] = "20200804387";
    	protocolos[18] = "20200804976";
    	protocolos[19] = "20200804875";
    	protocolos[20] = "20200804656";
    	
    	datasTratamento = new Date[5];
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_YEAR, - 15);
    	cal.add(Calendar.HOUR, - 3);
    	datasTratamento[0] = cal.getTime();
    	cal.add(Calendar.DAY_OF_YEAR, - 3);
    	cal.add(Calendar.HOUR, - 4);
    	cal.add(Calendar.MINUTE, - 43);
    	datasTratamento[1] = cal.getTime();
    	cal.add(Calendar.DAY_OF_YEAR, - 7);
    	cal.add(Calendar.HOUR, - 8);
    	cal.add(Calendar.MINUTE, - 88);
    	datasTratamento[2] = cal.getTime();
    	cal.add(Calendar.DAY_OF_YEAR, - 5);
    	cal.add(Calendar.HOUR, - 3);
    	cal.add(Calendar.MINUTE, - 44);
    	datasTratamento[3] = cal.getTime();
    	cal.add(Calendar.DAY_OF_YEAR, - 8);
    	cal.add(Calendar.HOUR, - 2);
    	cal.add(Calendar.MINUTE, - 9);
    	datasTratamento[4] = cal.getTime();

    	descricaoTratamentos = new String[10];
    	descricaoTratamentos[0] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[1] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[3] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[4] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[5] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[6] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[7] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[8] = "Descricao Tratamento " +Math.random();
    	descricaoTratamentos[9] = "Descricao Tratamento " +Math.random();
    	    	
    }
	
	public List<Incidente> createIncidente(int size) {
        List<Incidente> list = new ArrayList<Incidente>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Incidente(getRandomId(), 
            		getRandomArea(), 
            		getRandomTurno(), 
            		getRandomDescricoes(), 
            		getRandomMotivos(), 
            		getRandomStatus(), 
            		getRandomSimNao(),
            		getRandomProtocol(),
            		getRandomDataTratamento(), 
            		getRandomDescricaoTratamento()));
        }
         
        return list;
    }
	private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
	private String getRandomArea() {
        return areas[(int) (Math.random() * 8)];
    }
	private String getRandomTurno() {
        return turnos[(int) (Math.random() * 3)];
    }
	private String getRandomDescricoes() {
        return descricoes[(int) (Math.random() * 6)];
    }
	private String getRandomMotivos() {
        return motivos[(int) (Math.random() * 3)];
    }
	private String getRandomStatus() {
        return status[(int) (Math.random() * 3)];
    }
	private String getRandomSimNao() {
        return simNao[(int) (Math.random() * 2)];
    }
	private String getRandomProtocol() {
        return protocolos[(int) (Math.random() * 21)];
	}
	private Date getRandomDataTratamento() {
        return datasTratamento[(int) (Math.random() * 5)];
	}
	private String getRandomDescricaoTratamento() {
        return descricaoTratamentos[(int) (Math.random() * 10)];
		
	}
}
