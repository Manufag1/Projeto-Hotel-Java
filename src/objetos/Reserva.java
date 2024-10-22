package objetos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

	private String nomeHospede;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String tipoReservado;
	private List<Quarto> quartosReservados;
	private boolean checkIn;
	 private Hóspede hospede;
	
	public Reserva() {
		quartosReservados = new ArrayList<Quarto>();
		this.checkIn = false;
	}
	public void adicionarQuarto(Quarto quarto) {
	       this.quartosReservados.add(quarto);
	    }
	
	public String getNomeHospede() {
		return nomeHospede;
	}
	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada() {
		this.dataEntrada = LocalDate.now();
	}
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getTipoReservado() {
		return tipoReservado;
	}
	public void setTipoReservado(String tipoReservado) {
		this.tipoReservado = tipoReservado;
	}
	public List<Quarto> getQuartosReservados() {
		return quartosReservados;
	}
	public void setQuartosReservados(List<Quarto> quartosReservados) {
		this.quartosReservados = quartosReservados;
	}
	public boolean isCheckIn() {
		return checkIn;
	}
	public void setCheckIn(boolean checkIn) {
		this.checkIn = true;
	}
	public Hóspede getHospede() {
		return hospede;
	}
	public void setHospede(Hóspede hospede) {
		this.hospede = hospede;
	}
	@Override
	public String toString() {
		return "Reserva [nomeHospede=" + nomeHospede + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", tipoReservado=" + tipoReservado + ", quartosReservados=" + quartosReservados + ", checkIn="
				+ checkIn + "]";
	}
	
	
	
	
	
	
	
}
