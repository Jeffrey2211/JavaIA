import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.html.HTMLBaseFontElement;

public class GestisciDipendenti {
	
	public static ArrayList<Dipendente> ListaDipendenti = new ArrayList<Dipendente>();
	public static Scanner inputInt = new Scanner (System.in);
	public static Scanner inputStr = new Scanner (System.in);
	public static Scanner inputDou = new Scanner (System.in);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//ISTANZIO UN OGGETTO LEGGI SCRIVI
		LeggiScrivi fonte = new LeggiScrivi("Dipendenti.csv");
		//SCARICO LA SUA LISTA NELLA MIA
		ListaDipendenti = fonte.getListaDipendenti();
		
		int scelta;
		do {
			scelta = mostramenu();
			faiswitch(scelta, fonte);
		}while (scelta != 0);

	}

	private static int mostramenu() {
		
		System.out.println("1 Mostra dipendenti");
		System.out.println("2 Inserisci dipendente");
		System.out.println("3 Modifica dipendente");
		System.out.println("4 Elimina dipendenti");
		System.out.println("5 Salva modifiche");
		System.out.println("0 Esci");
		
		return inputInt.nextInt();
	}

	private static void faiswitch(int scelta, LeggiScrivi fonte) throws IOException {
		
		switch(scelta) {
		
		case 1:
			mostradipendenti();
			break;
		case 2:
			inseriscidipendente();
			break;
		case 3:
			modificadipendente();
			break;
		case 4:
			eliminadipendente();
			break;
		case 5:
			salvamodifiche(fonte);
			break;
		case 0:
			break;
			
			default: System.out.println("Attenzione scelta nmon valida");
		
		}
		
	}

	private static void mostradipendenti() {
		
		System.out.println("Mostra lista dipendenti");
		
		for (int i = 0; i < ListaDipendenti.size(); i++) {
			
			ListaDipendenti.get(i).mostradipendente();
			
			
		}
		
	}

	private static void inseriscidipendente() {
		
		int nuovoid = ListaDipendenti.size() + 1;
		System.out.println("Inserisci Nome:");
		String nome = inputStr.nextLine();
		System.out.println("Inserisci Cognome:");
		String cognome = inputStr.nextLine();
		System.out.println("Inserisci Mansione:");
		String mansione = inputStr.nextLine();
		System.out.println("Inserisci Stipendio:");
		double stipendio = inputDou.nextDouble();
		
		ListaDipendenti.add(new Dipendente(nuovoid, nome, cognome, mansione, stipendio));
		
	}

	private static void modificadipendente() {
		// TODO Auto-generated method stub
		
	}

	private static void eliminadipendente() {
		// TODO Auto-generated method stub
		
	}

	private static void salvamodifiche(LeggiScrivi fonte) throws IOException {
		
		//SINCRONIZZO LA LISTA DEL PROGRAMMA
		//CHE E' STATA LAVORATA, CON LA LISTA DELL'ISTANZA DELLA CLASSE
		fonte.setListaDipendenti(ListaDipendenti);
		fonte.salvafile();
		
		
		
		
	}

}
