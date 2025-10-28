import java.util.Scanner;

public class Inventario {

	public static void main(String[] args) {
		
		/*
		 * MACROANALISI
		 * PROGRAMMA CHE GESTISCE UN ELENCO FINITO DI PRODOTTI IN MAGAZZINO
		 * DI CUI DEVO SAPERE, NOME, PREZZO E QUANTITA
		 * CREATO L'ELENCO DEVO POTERLO VEDERE TOTALMENTE, 
		 * MA ANCHE DEVO POTER CERCARE PER NOME UN PRODOTTO
		 * PER SAPERE LA QUANTITA' IN MAGAZZINO E IL PREZZO
		 */
		
		/*
		 * PROGETTAZIONE
		 * CREO UN MENU CICLICO PER POTER
		 * 1 INSERIRE I PRODOTTI
		 * 2 MOSTRARE TUTTI I PRODOTTI
		 * 3 CERCARE UN PRODOTTO SPECIFICO
		 * MI SERVONO 3 ARRAY nomi, prezzi, quantita
		 * INIZIALMENTE SARANNO VUOTI, POI DEVO INSERIRE I PRODOTTI
		 * NELLA POSIZIONE GIUSTA E SE C'� SPAZIO
		 * CON UN FOR POSSO MOSTRARE IL CONTENUTO TOTALE DEGLI ARRAY
		 * CON UN FOR POSSO CERCARE UN ELEMENTO SPECIFICO
		 */

		//CREO I TUBI SCANNER
		Scanner inputInt = new Scanner (System.in);
		Scanner inputString = new Scanner (System.in);
		Scanner inputDouble = new Scanner (System.in);
		//CREO GLI ARRAY CON LA STESSA DIMENSIONE
		
		System.out.println("Inventario");
		System.out.println("Quanti prodotti ha il tuo magazzino?");
		int quantitaprodotti = inputInt.nextInt(); 
		
		String []nomi = new String[quantitaprodotti];
		double []prezzi = new double[quantitaprodotti];
		int []quantita = new int[quantitaprodotti];
		//VARIABILE PER L'INDICE POSIZIONALE NELL'ARRAY
		int posizione = 0;
		//PRESENTO IL PROGRAMMA
		
		
		int scelta; //CREO LKA VARIABILE DI SCELTA
		//IMPOSTO UN MENU CICLICO DO
		do {
			//MOSTRO IL MENU
			System.out.println("1 - Inserisci prodotto");
			System.out.println("2 - Mostra i prodotti");
			System.out.println("3 - Cerca prodotto");
			System.out.println("0 - Esci");
			//ASCOLTO LA SCELTA UTENTE
			scelta = inputInt.nextInt();
			//FACCIO LO SWITCH SULLA SCELTA DELL'UTENTE
			switch (scelta) {
			
			case 1: //SE HA SCELTO DI INSERIRE..
			
				//CHIEDO LE INFO SUL NUOVO PRODOTTO
				//USANDO I TUBI GIUSTI
				System.out.println("Inserisci nome del prodotto:");
				nomi[posizione] = inputString.nextLine();
				System.out.println("Inserisci il prezzo del prodotto:");
				prezzi[posizione] = inputDouble.nextDouble();
				System.out.println("Inserisci la quantit� del prodotto:");
				quantita[posizione] = inputInt.nextInt();
				//LI INSERISCO DIRETTAMENTE NEGLI ARRAY
				//NELLA POSIZIONE DATA DALLA VARIABILE "POSIZIONE"
				//AVVISO CHE TUTTO E' ANDATO BENE
				System.out.println("Oggetto inserito con successo");
				//INCREMENTO LA POSIZIONE PER IL PROSSIMO INSERIMENTO
				posizione++;
				
				break;
			case 2:  //SCELTA MOSTRA TUTTI I PRODOTTI
				
				//DICO CHE MOSTRO TUTTI
				System.out.println("Elenco dei prodotti nel magazzino...");
				//LEGGO GLI ARRAY CON UN UNICO CICLO FOR
				//SFRUTANDO L'INDICE IN COMUNE
				for (int i = 0; i < nomi.length; i++) {
					
					if (nomi[i] != null) { //NON MOSTRO LE POSIZIONI VUOTE!
					
					System.out.println((i+1) + " nome: " + nomi[i] 
							+ " prezzo: " + prezzi[i] + " quantit�: " + quantita[i]);
					
					}
				}
				//USO L'INDICE POSIZIONALE ANCHE COME CONTATORE DEI PRODOTTI
				//NEGLI ARRAY
				System.out.println("In magazzino ci sono " + posizione + " prodotti");
				
				break;
			case 3: //CERCARE UN PRODOTTO
				
				//RAGIONAMENTO PESSIMISTA
				//DICO CHE NOON LO TROVO
				boolean trovato = false;
				System.out.println("Ricerca di un prodotto...");
				System.out.println("Inserisci il nome del prodotto:");
				
				String cercaprodotto = inputString.nextLine();
				
				//LO CERCO DENTRO L'ARRAY DEI NOMI PRODOTTI
				for (int i = 0; i < nomi.length; i++) {
					
					if (nomi[i] != null) { //CONFRONTA SOLO QUELLI PIENI
					
						if (nomi[i].equals(cercaprodotto)) {
							
							System.out.println("Il prezzo del prodotto " + 
							cercaprodotto + " � " + prezzi[i] + 
							" euro. In magazzino ne abbiamo " + quantita[i]);
							trovato = true;
							
						}
					}
					
				} //FINITA LA RICERCA SE NON L'HO TROVATO AVVISO
				
				if (trovato == false) {
					System.out.println("Oggetto non trovato!");
				}

				
				break;
			case 0:
				System.out.println("...alla prossima");
				break;
				default: System.out.println("Attenzione scelta non valida");
			
			}
			
			
			
		} while(scelta != 0);
		
		
		
	}

}
