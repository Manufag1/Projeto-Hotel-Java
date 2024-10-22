package objetos;
import java.time.LocalDate;


public class Hóspede {
	private String nomeHhospede;
	private LocalDate dataHreserva;
	private Integer quartosHreservados;
	private Integer tipoHreservado;
	public String getNomeHhospede() {
		return nomeHhospede;
	}
	public void setNomeHhospede(String nomeHhospede) {
		this.nomeHhospede = nomeHhospede;
	}
	public LocalDate getDataHreserva() {
		return dataHreserva;
	}
	public void setDataHreserva(LocalDate dataHreserva) {
		this.dataHreserva = LocalDate.now();
	}
	public Integer getQuartosHreservados() {
		return quartosHreservados;
	}
	public void setQuartosHreservados(Integer quartosHreservados) {
		this.quartosHreservados = quartosHreservados;
	}
	public Integer getTipoHreservado() {
		return tipoHreservado;
	}
	public void setTipoHreservado(Integer tipoHreservado) {
		this.tipoHreservado = tipoHreservado;
	}
	
	
	public Hóspede(String nomeHhospede, LocalDate dataHreserva, Integer quartosHreservados, Integer tipoHreservado) {
		super();
		this.nomeHhospede = nomeHhospede;
		this.dataHreserva = dataHreserva;
		this.quartosHreservados = quartosHreservados;
		this.tipoHreservado = tipoHreservado;
	}

	public Hóspede() {
		
	}
}
