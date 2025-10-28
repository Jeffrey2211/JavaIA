import java.util.Scanner;

/*
		 * MACROANALISI
		 * ILPROGRAMMA GESTISCE UN ELENCO DI CONTRATTI
		 * PU� INSERIRE UN NUOVO CONTRATTO
		 * MOSTRARE TUTTI I CONTRATTI
		 * FILTRARLI PER TIPO
		 * 
		 */
		
		/*
		 * PROGETTAZIONE
		 * CREO UN ARRAY DI OGGETTI DI TIPO CONTRATTO
		 * PER CUI CREO UNA CLASSE SPECIFICA
		 * LA CLASSE DEVE GESTIRE PER OGNI CONTRATTO
		 * IL NOME DEL CLIENTE, TIPO, IMPORTO
		 * INSRISCO I CONTRATTI DENTRO UN ARRAY LA CUI DIMENSIONE
		 * E' SCELTA DALL'UTENTE ALL'APERTURA DEL PROGRAMMA
		 * CON UN FOR NELL'ARRAY POSSO MOSTRARE TUTTI I CONTRATTI
		 * CON UN FOR CON UN IF ALL'INTERNO POSSO FILTRARE PER TIPO I CONTRATTI
		 */


public class GestioneContrattiConClassi {
	
	public static Contratto [] elencocontratti = new Contratto[10];
	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputString = new Scanner(System.in);
	public static Scanner inputDouble = new Scanner(System.in);
	public static int posizione = 0;
	public static double totalecontratti = 0.0;
	
	public static void main(String[] args) {
		
		System.out.println("Gestione elenco contratti");
		
		int scelta;
		do {
			
			scelta = mostramenu();
			faiswitch(scelta);
			
		} while (scelta != 0);

	}

	private static void faiswitch(int scelta) {
		
		switch (scelta) {
		
		case 1:
			inseriscicontratto();
			break;
		case 2:
			mostracontratti();
			break;
		case 3:
			filtracontratti();
			break;
		case 0:
			break;
			default: System.out.println("Attenzione scelta non valida");
		
		}
		
	}

	private static void inseriscicontratto() {
		
		System.out.println("Inserisci il nome del cliente:");
		String cliente = inputString.nextLine();
		System.out.println("Inserisci il tipo di contratto:");
		String tipo = inputString.nextLine();
		System.out.println("Inserisci l'importo de contratto:");
		double importo = inputDouble.nextDouble();
		
		elencocontratti[posizione] = new Contratto(cliente, tipo, importo);
		
		totalecontratti += elencocontratti[posizione].importotassato();
		posizione++;
	}

	private static void mostracontratti() {
		
		System.out.println("Elenco dei contratti archiviati");
		
		for (int i = 0; i < elencocontratti.length; i++) {
			
			if (elencocontratti[i] != null) {
			elencocontratti[i].mostracontratto();
			}
		}
		
		System.out.println("Totale contratti: " + totalecontratti);
		
	}

	private static void filtracontratti() {
		
		System.out.println("Che tipo di contratti vuoi vedere?");
		String tipo = inputString.nextLine();
		double totalecontrattifiltrato = 0;
		
		for (int i = 0; i < elencocontratti.length; i++) {
			
			if (elencocontratti[i] != null) {
			totalecontrattifiltrato += elencocontratti[i].mostracontratto(tipo);
			}
		}
		
		System.out.println("Totale contratti filtrati: " + totalecontrattifiltrato);
	}

	private static int mostramenu() {
		
		System.out.println("1 Inserisci Contratto");
		System.out.println("2 Mostra Contratto");
		System.out.println("3 Filtra Contratti");
		System.out.println("0 Esci");
		
		return inputInt.nextInt();
	}

}
