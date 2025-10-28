import java.util.Scanner;
/*
*MACROANALISI
*Il programma gestisce un elenco di contratti di diverso tipo
*Per ogni tipo di contratto il commerciale guadagna una provvigione calcolata diversamente
*il programma da la possibilità di inserire i contratti, di riepilogare tutti e di calcolare la provvigione per ogni contratto mostrando poi il guadagno del commerciale

*PROGETTAZIONE
*Creo un array per gestire i contratti
*Avrò quindi una classe Contratto, che potrà estendersi in Immobiliare, FornituraHardware, AgenziaViaggio
*Per ognuna delle tipologie il commerciale guadagna una provvigione diversa, calcolata in modo specifico.
*Quindi avrò un menu principale
*1 inserisci contratto, 2 mostra contratti, 3 calcola e mostra provvigioni
*Sottomenu per decidere il tipo di contratto 
*Attenzione alla posizione da tenere in variabile e incrementare
*Attenzione alle posizioni (inizialmente 100) dell'elenco contratto da non mostrare se null nei riepiloghi.
*La classe Congtratto potrà quindi alla fine divenire astratta.
*/

public class GestioneContrattiPerCommerciale {
	
	//Scanner per input dell'utente
	public static Scanner inputString = new Scanner (System.in);
	public static Scanner inputInt = new Scanner (System.in);
	public static Scanner inputDouble = new Scanner (System.in);
	
	//Array per salvare i contratti
	public static Contratto [] ElencoContratti = new Contratto[100] ;
	public static int posizione = 0;//Tiene traccia del numero di contratti inseriti
	

	public static void main(String[] args) {
		
		int scelta;
		do {
			
			scelta = mostramenu();//Mostra il menu principale e legge la scelta dell'utente
			
			faiswitch(scelta);//Esegue l'azione corrispondente alla scelta
		} while(scelta != 0);
		

	}

	//Metodo per mostrare il menu principale
	private static int mostramenu() {
		
		System.out.println("Gestione di un elenco di contratti");
		System.out.println("1 Inserire contratto");
		System.out.println("2 Mostra contratti");
		System.out.println("3 Calcola e mastra provvigioni");
		System.out.println("0 Esci");
		
		return inputInt.nextInt();//legge la scelta
	}

	//Metodo per gestire la scelta dell'utente
	private static void faiswitch(int scelta) {
		
		switch(scelta) {
		
		case 1:
			inseriscicontratti();//Inserimento di un nuovo contratto
			break;
		case 2:
			mostracontratti();//Mostra tutti i contratti inseriti
			break;
		case 3:
			calcolaemostraprovvigioni();//Calcola e mostra provvigioni
			break;
		case 0:
			break;
		default:
			System.out.println("Valore contratto non corretto!");
			break;
		}
		
	}

	//Metodo per scegliere il tipo di contratto da inserire
	private static void inseriscicontratti() {
		
		System.out.println("Seleziona tipo di contratto da inserire:");
	    System.out.println("1 - Immobiliare");
	    System.out.println("2 - Fornitura Hardware");
	    System.out.println("3 - Agenzia Viaggi");
	    System.out.println("0 Torna al menu principale");
	    
	    int scelta = inputInt.nextInt();
	    inputInt.nextLine(); // per consumare l'invio
	    
	    switch (scelta) {
	        case 1:
	            contrattoimmobiliare();
	            break;
	        case 2:
	            contrattoforniturahardware();
	            break;
	        case 3:
	            contrattoagenziaviaggi();
	            break;
	        case 0:
	            System.out.println("Sei tornato al menu principale!");
	            break;
	        default:
	            System.out.println("Scelta non valida!");
	            break;
	    }
		
		
	}

	//Metodo per mostrare tutti i contratti
	private static void mostracontratti() {
		int scelta;
	    do {
	        System.out.println("1 - Mostra tutti i contratti");
	        System.out.println("0 - Torna al menu principale");
	        
	        scelta = inputInt.nextInt();
	        
	        switch(scelta) {
	            case 1:
	            	for(int i = 0; i < posizione; i++) {
	                    if(ElencoContratti[i] != null) {
	                       ElencoContratti[i].presentazionecontratto();
	                     }
	                }
	                break;
	            case 0:
	                System.out.println("Ritorno al menu principale...");
	                break;
	            default:
	                System.out.println("Scelta non valida!");
	        }
	    } while(scelta != 0);
	}

	//Metodo per calcolare e mostrare le provvigioni
	private static void calcolaemostraprovvigioni() {
		int scelta;
	    do {
	        System.out.println("1 - Mostra tutti i contratti");
	        System.out.println("0 - Torna al menu principale");
	        
	        scelta = inputInt.nextInt();
	        
	        switch(scelta) {
	            case 1:
	            	double totaleProvvigioni = 0;
	        	    for(int i = 0; i < posizione; i++) {
	        	    	if(ElencoContratti[i] != null) {//Sicurezza contro eventuali null
	        	    		double provvigione = ElencoContratti[i].calcolacostocontratto();
	        	            totaleProvvigioni += provvigione;
	        	            System.out.println("Cliente: " + ElencoContratti[i].cliente + " - Provvigione: " + provvigione + " €");
	        	    	}
	        	    }
	        	    System.out.println("Totale provvigioni: " + totaleProvvigioni + " €");
	        	    break;
	            case 0:
	                System.out.println("Ritorno al menu principale...");
	                break;
	            default:
	                System.out.println("Scelta non valida!");
	        }
	    } while(scelta != 0);
		
		
	}


	private static void contrattoimmobiliare() {
		
	    System.out.print("Nome cliente: ");
	    String cliente = inputString.nextLine();

	    System.out.print("Importo contratto: ");
	    double importo = inputDouble.nextDouble();
		
		ContrattoImmobiliare Immobiliare = new ContrattoImmobiliare(cliente, importo);
	    // Salva nell'array
	    ElencoContratti[posizione++] = Immobiliare;

	    System.out.println("Contratto immobiliare inserito!");
    
	}


	private static void contrattoforniturahardware() {
		
	    System.out.print("Nome cliente: ");
	    String cliente = inputString.nextLine();

	    System.out.print("Importo contratto: ");
	    double importo = inputDouble.nextDouble();
		
		ContrattoFornituraHardware Forniturehardware = new ContrattoFornituraHardware(cliente, importo);
	    // Salva nell'array
	    ElencoContratti[posizione++] = Forniturehardware;

	    System.out.println("Contratto forniture hardware inserito!");

	}


	private static void contrattoagenziaviaggi() {
		
	    System.out.print("Nome cliente: ");
	    String cliente = inputString.nextLine();

	    System.out.print("Importo contratto: ");
	    double importo = inputDouble.nextDouble();
		
		ContrattoAgenziaViaggi Agenziaviaggi = new ContrattoAgenziaViaggi(cliente, importo);
	    // Salva nell'array
	    ElencoContratti[posizione++] = Agenziaviaggi;

	    System.out.println("Contratto Agenzia viaggi inserito!");
	}

}
