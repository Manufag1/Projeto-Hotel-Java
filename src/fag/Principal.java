package fag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import objetos.Quarto;
import objetos.Reserva;
import objetos.Hóspede;


public class Principal {
	static Scanner scanner = new Scanner(System.in);
	static List<Quarto> listarQuartos = new ArrayList<Quarto>();
	static List<Reserva> listarReservas = new ArrayList<Reserva>();
	static List<Hóspede> listarHóspedes = new ArrayList<Hóspede>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		menuPrincipal();
		
	}
	
	public static void menuPrincipal() {
		 System.out.println("Bem-vindo ao sistema de gerenciamento de hotéis!");
		 System.out.println("Digite a opção que deseja:");
		 System.out.println("1- Cadastrar quarto");
		 System.out.println("2- Cadastrar reservas");
		 System.out.println("3- Gerenciamento de check-in/check-out");
		 System.out.println("4- Acompanhamento de ocupação de quartos ");
		 System.out.println("5- Histórico de reservas ");
		 System.out.println("0- Encerrar sistema");
		 
		 int op = scanner.nextInt();
		 
		 if (op==1) {
			 cadastrarQuarto();
		
		 }
		 else if(op==2) {
			 cadastrarReserva();
			 
		 }
		 else if(op==3) {
			 gerenciarCheck();
			 
		 }
		 else if (op==4) {
			 acompanhamentoQuarto();
			 
		 }
		 else if (op==5){
			 históricoReserva();
		 }
		 else if(op==0) {
			 System.out.println("Sistema encerrando...");
			 System.exit(0);
		 }
		 else {
			 System.out.println("ERRO- Digite uma opção disponível no menu.");
		 }
	}
	
	public static void cadastrarQuarto() {
		Quarto quarto = new Quarto();
		System.out.println("Digite o número do quarto:");
		quarto.setNumQuarto(scanner.nextInt());
		
		System.out.println("Qual o tipo de quarto?  1-Casal, 2-Solteiro ou 3-Suíte");
		int escolha = scanner.nextInt();
		if (escolha==1) {
			quarto.setTipoQuarto("Casal");
		}
		else if(escolha==2) {
			quarto.setTipoQuarto("Solteiro");
		}
		else if(escolha==3) {
			quarto.setTipoQuarto("Suíte");
		}
		else {
			System.out.println("Erro- Digite um número correspondente a uma opção");
		}
		
		System.out.println("Digite o preço da diária do quarto:");
		quarto.setPrecoDiario(scanner.nextDouble());
		
		
		quarto.setDisponibilidade(true);
		
		listarQuartos.add(quarto);
		
		System.out.println("Quarto cadastrado com sucesso!");
		menuPrincipal();
	}
	
	public static void cadastrarReserva() {
		Reserva reserva = new Reserva();
		Hóspede hospede = new Hóspede();
		
		System.out.println("Digite o nome do hóspede:");
		String nomeHospede = scanner.next();
		hospede.setNomeHhospede(nomeHospede);
		listarHóspedes.add(hospede);
		reserva.setDataEntrada();
		System.out.println("A data de entrada é:"+ reserva.getDataEntrada());
		System.out.println("Digite a data de sáida (yyyy-MM-dd):");
		String  dataSaidaStr = scanner.next();
		LocalDate dataSaida = LocalDate.parse(dataSaidaStr);
		reserva.setDataSaida(dataSaida);
		scanner.nextLine();
		
		boolean continuarAdicionandoQuartos = true;
	    while (continuarAdicionandoQuartos) {
	    	System.out.println("Número do quarto que deseja reservar (ou 0 para finalizar):");
	        int numeroQuarto = scanner.nextInt();
	        scanner.nextLine(); 
	        if (numeroQuarto == 0) {
	            continuarAdicionandoQuartos = false; 
	        } else {
	            Quarto quarto = encontrarQuartoPorNumero(numeroQuarto);
	            if (quarto != null && quarto.getDisponibilidade()) {
	            	reserva.adicionarQuarto(quarto);
	            	quarto.setDisponibilidade(false);
	            	 System.out.println("Quarto " + numeroQuarto + " adicionado à reserva.");

	            } 
	
	            	else {
                System.out.println("Quarto não encontrado ou indisponível.");
            }
	        }
	        }
	    if (reserva.getQuartosReservados().isEmpty()) {
	    	reserva.setTipoReservado(reserva.getQuartosReservados().get(0).getTipoQuarto());
	    	
	    }
	    listarReservas.add(reserva);
	    System.out.println("Reserva concluída com sucesso!");
	    
	    for (Reserva listarreservas : listarReservas) {
	    	System.out.println(listarreservas);
	    }
		
		menuPrincipal();
		
		
	}
	

	public static void gerenciarCheck() {
		System.out.println("Digite a opção desejada:");
	    System.out.println("1- Check-in");
	    System.out.println("2- Check-out");
	    System.out.println("0- Voltar ao menu principal");
	    
	    int op = scanner.nextInt();
	    
	    if (op == 1) {
	        realizarCheckIn();
	    } else if (op == 2) {
	        realizarCheckOut();
	    } else if (op == 0) {
	        menuPrincipal();
	    } else {
	        System.out.println("ERRO- Digite uma opção válida.");
	        gerenciarCheck();
	    }
	    
	}

	public static void realizarCheckIn() {
	    System.out.println("Digite o nome do hóspede para check-in:");
	    String nomeHospede = scanner.next();
	    
	    Hóspede hospede = encontrarHospedePorNome(nomeHospede);
	    if (hospede == null) {
	        System.out.println("Hóspede não encontrado. Verifique o nome.");
	        return;
	    }
	    
	    System.out.println("Digite o número do quarto para check-in:");
	    int numeroQuarto = scanner.nextInt();
	    
	    Quarto quarto = encontrarQuartoPorNumero (numeroQuarto);
	    if (quarto != null && !quarto.getDisponibilidade()) {
	        System.out.println("Check-in realizado com sucesso no quarto " + numeroQuarto);
	        quarto.setDisponibilidade(false); 
	    } else {
	        System.out.println("Quarto não encontrado ou já ocupado.");
	    }
	    menuPrincipal();
	}

	public static void realizarCheckOut() {
	    System.out.println("Digite o nome do hóspede para check-out:");
	    String nomeHospede = scanner.next();
	    
	    Hóspede hospede = encontrarHospedePorNome(nomeHospede);
	    if (hospede == null) {
	        System.out.println("Hóspede não encontrado. Verifique o nome.");
	        return;
	    }
	    
	    System.out.println("Digite o número do quarto para check-out:");
	    int numeroQuarto = scanner.nextInt();
	    
	    Quarto quarto = encontrarQuartoPorNumero(numeroQuarto);
	    if (quarto != null && !quarto.getDisponibilidade()) {
	        System.out.println("Check-out realizado com sucesso do quarto " + numeroQuarto);
	        quarto.setDisponibilidade(false);
	    } else {
	        System.out.println("Quarto não encontrado ou já está livre.");
	    }
	    menuPrincipal();
	}

	public static Hóspede encontrarHospedePorNome(String nome) {
	    for (Hóspede h : listarHóspedes) {
	        if (h.getNomeHhospede().equalsIgnoreCase(nome)) {
	            return h;
	        }
	    }
	    return null;
		
	}
	public static void acompanhamentoQuarto() {
		System.out.println("Acompanhamento de ocupação de quartos:");

	    
	    if (listarReservas.isEmpty()) {
	        System.out.println("Não há quartos ocupados no momento.");
	        return;
	    }

	   
	    for (Reserva reserva : listarReservas) {
	        
	        if (reserva.isCheckIn()) {
	           
	            System.out.println("Hóspede: " + reserva.getNomeHospede());
	            System.out.println("Data de entrada: " + reserva.getDataEntrada());
	            System.out.println("Data de saída: " + reserva.getDataSaida());
	            System.out.println("Quartos ocupados:");

	            LocalDate dataEntrada;
	            LocalDate dataSaida;
	            
	            
	            for (Quarto quarto : reserva.getQuartosReservados()) {
	                System.out.println("Número do quarto: " + quarto.getNumQuarto() + 
	                                   " | Tipo de quarto: " + quarto.getTipoQuarto());
	            }

	            
	        }
	    }

	    
	    menuPrincipal();
	}
	public static void históricoReserva() {
		System.out.println("Histórico de Reservas:");

	    if (listarReservas.isEmpty()) {
	        System.out.println("Não há reservas registradas.");
	        return;
	    }

	    for (Reserva reserva : listarReservas) {
	        Hóspede hospede = reserva.getHospede();
	        System.out.println("Hóspede: " + hospede.getNomeHhospede());
	        System.out.println("Data de entrada: " + reserva.getDataEntrada());
	        System.out.println("Data de saída: " + reserva.getDataSaida());
	        System.out.println("Quartos reservados:");

	        for (Quarto quarto : reserva.getQuartosReservados()) {
	            System.out.println("Número do quarto: " + quarto.getNumQuarto() + 
	                               " | Tipo de quarto: " + quarto.getTipoQuarto());
	        }
	        
	    }

	    menuPrincipal();
		
	}
	public static Quarto encontrarQuartoPorNumero(int numeroQuarto) {
		for(Quarto q: listarQuartos) {
			if (q.getNumQuarto()== numeroQuarto) {
				return q;
			}
		}
		return null;
	}

}
