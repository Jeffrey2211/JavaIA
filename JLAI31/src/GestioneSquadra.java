import java.util.Scanner;

/*
		 * ABBIAMO VISTO COME CREARE UNA CLASSE "LA FABBRICA"
		 * OGNI CLASSE SAR� DOTATA DI 
		 * ATTRIBUTI
		 * COSTRUTTORI
		 * GETTER AND SETTER
		 * METODI
		 * CON I COSTRUTTORI ISTANZIO (CREO) GLI OGGETTI
		 * IL MIO PROGRAMMA OOP SAR� QUINDI UN PROGRAMMA CHE GESTISCE LE
		 * INTERAZIONI TRA I DIVERSI OGGETTI
		 * 
		 * NB: MOLTO SPESSO NEI PROGRAMMI CREIAMO IGGETTI DIVERSI
		 * MA MOLTO SIMILI TRA DI LORO, OVVERO CHE HANNO MOLTE COSE
		 * IN COMUNE MA CHE POI SI DIFFERENZIANO PER ALCUNI ASPETTI
		 * 
		 * JAVA MI PERMETTE DI CREARE UNA CLASSE CHE CONTIENE
		 * LE COSE IN COMUNE (LA SUPERCLASSE) E CREARE POI
		 * DELLE CLASSI CHE PARTENDO DA QUELLO CHE HA LA SUPERCLASSE
		 * (LE EREDITANO) SI DIVERSIFICANO OGNUNO PER LE SUE 
		 * CARATTERISTICHE (SI ESTENDONO)
		 * 
		 * NB: PER JAVA UN OGGETTO ISTANZIATO DA UNA CLASSE ESTESA
		 * RESTA COMUNQUE UN OGGETTO ESTESO DELLA CLASSE SUPER!
		 */

/*
 * MACROANALISI
 * gestione dei componenti tutti di una squadra
 * IN UN SQUADRA DI MAX 20 ELEMENTI
 * DEVO POTER INSERIRE GIOCATORI, ALLENATORI E DIRIGENTI
 * OGNUNO CON LE SUE CARATTERISTICHE, PER POTER AVERE IL COSTO
 * DELLA MIA SQUADRA. OGNI TIPO DI COMPONENTE HA UN COMPENSO CALCOLATO
 * DIVERSAMENTE
 */

/*
 * PROGETTAZIONE
 * CREO UN ARRAY DI CONTENIMENTO PER LA SQUADRA
 * CREO UNA CLASSE COMPONENTE ESTESA IN GIOCATORE, ALLENATORE, DIRIGENTE
 * PER OGNI CLASSE CREO UNA MODALIT� DI CALCOLO DEL COMPENSO
 * CON UN CICLO FOR SULL'ARRAY DEVO CALCOLARE IL COSTO TOTALE DELLA SQUADRA
 */


public class GestioneSquadra {

	public static Scanner inputInt = new Scanner (System.in);
	public static Scanner inputString = new Scanner (System.in);
	public static Scanner inputDouble = new Scanner (System.in);
	public static Componente [] ElencoComponenti = new Componente[20];
	public static int posizione = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Gestione componenti della squadra");
		
		int scelta;
		do {
			
			scelta = mostramenu();
			fauiswitch(scelta);
			
		} while (scelta != 0);

	}

	private static void fauiswitch(int scelta) {
		
		switch(scelta) {
		
		case 1:
			inseriscinuovocomponente();
			break;
		case 2:
			mostracomponenti();
			break;
		case 3:
			mostracosticomponenti();
			break;
		case 0:
			break;
			
			default: System.out.println("Attenzione scelta non valida");
		
		}
		
		
	}

	private static void inseriscinuovocomponente() {
		
		int scelta;
		do {
			
			scelta = mostramenuinscomponente();
			fauiswitchinscomponente(scelta);
			
		} while (scelta != 0);
		
	}

	private static int mostramenuinscomponente() {
		
		System.out.println("1 - Inserisci Giocatore");
		System.out.println("2 - Inserisci Allenatore");
		System.out.println("3 - Inserisci Dirigente");
		System.out.println("0 - Torna al menu principale");
		
		return inputInt.nextInt();
	}

	private static void fauiswitchinscomponente(int scelta) {
		
		switch(scelta) {
		
		case 1:
			inseriscigiocatore();
			break;
		case 2:
			inserisciallenatore();
			break;
		case 3:
			inseriscidirigente();
			break;
		case 0:
			break;
			
			default: System.out.println("Attenzione scelta non valida");
		
		}
		
	}

	private static void inseriscidirigente() {
		
		System.out.println("Inserisci Nome dirigente:");
		String nome = inputString.nextLine();
		System.out.println("Inserisci Cognome dirigente:");
		String cognome = inputString.nextLine();
		System.out.println("Inserisci Ingaggio dirigente:");
		double ingaggio = inputDouble.nextDouble();
		System.out.println("Inserisci Competenza dirigente:");
		String competenza = inputString.nextLine();
		System.out.println("Inserisci numero mesi di ingaggio:");
		int mesiingaggio = inputInt.nextInt();
		
		ElencoComponenti[posizione] = new Dirigente(nome, cognome, ingaggio, competenza, mesiingaggio);
		
		System.out.println("dirigente inserito con successo!");
		
		posizione++;
		
		
		
	}

	private static void inserisciallenatore() {
		
		System.out.println("Inserisci Nome Allenatore:");
		String nome = inputString.nextLine();
		System.out.println("Inserisci Cognome Allenatore:");
		String cognome = inputString.nextLine();
		System.out.println("Inserisci Ingaggio Allenatore:");
		double ingaggio = inputDouble.nextDouble();
		boolean primoallenatore = dimmiseprimoallenatore();
		
		System.out.println("Inserisci il suo moltiplicatore ingaggio:");
		double moltiplicatore = inputDouble.nextDouble();
		
		ElencoComponenti[posizione] = new Allenatore(nome, cognome, ingaggio, primoallenatore, moltiplicatore);
		
		System.out.println("Allenatore inserito con successo!");
		
		posizione++;
		
	}

	private static boolean dimmiseprimoallenatore() {
		
		boolean esito = false; //PESSIMISTA
		System.out.println("E' il primo allenatore?:");
		System.out.println("1 - Si");
		System.out.println("2 - No");
		
		int scelta = inputInt.nextInt();
		if (scelta==1) {
			esito = true;	
		} else if (scelta==2) {
			esito = false;
		}
		
		return esito;
		
		
	}

	private static void inseriscigiocatore() {
		
		System.out.println("Inserisci Nome giocatore:");
		String nome = inputString.nextLine();
		System.out.println("Inserisci Cognome giocatore:");
		String cognome = inputString.nextLine();
		System.out.println("Inserisci Ingaggio giocatore:");
		double ingaggio = inputDouble.nextDouble();
		System.out.println("Inserisci Ruolo giocatore:");
		String ruolo = inputString.nextLine();
		System.out.println("Inserisci numero maglia giocatore:");
		int numeromaglia = inputInt.nextInt();
		System.out.println("Inserisci bonus giocatore:");
		double bonus = inputDouble.nextDouble();
		
		ElencoComponenti[posizione] = new Giocatore(nome, cognome, ingaggio, ruolo, numeromaglia, bonus);
		
		System.out.println("Giocatore inserito con successo!");
		
		posizione++;
	}

	private static void mostracomponenti() {
		
		System.out.println("Mostro il roster della squadra:");
		
		for (int i = 0; i < ElencoComponenti.length; i++) {
			
			if (ElencoComponenti[i] != null) {
			ElencoComponenti[i].Presentazione();
			}
		}
		
	}

	private static void mostracosticomponenti() {
		
		double costototale = 0;
		
		for (int i = 0; i < ElencoComponenti.length; i++) {
			
			if (ElencoComponenti[i] != null) {
			ElencoComponenti[i].Presentazione();
			costototale += ElencoComponenti[i].calcolacostocomponente();
			}
		}
		
		System.out.println("Il costo totale della squadra �: " + costototale);
		
	}

	private static int mostramenu() {
		
		System.out.println("1 Inserisci nuovo componente");
		System.out.println("2 Mostra componenti squadra");
		System.out.println("3 Mostra e Calcola costo totale squadra");
		System.out.println("0 Esci");
		
		return inputInt.nextInt();
	}

}
