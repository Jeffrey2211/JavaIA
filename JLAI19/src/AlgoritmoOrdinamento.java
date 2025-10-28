import java.util.Scanner;

public class AlgoritmoOrdinamento {

	public static void main(String[] args) {
		
		/*
		 * JAVA OFFRE DIVERSI ALGORITMI DI ORDINAMENTO
		 * IL PI� UTILIZZATO E' QUELLO DEI 2 CICLI FOR
		 * PER ORDINARE UNA SEQUENZA DI VALORI 
		 * SECONDO UN DETERMINATO CRITERIO DI ORDINAMENTO 
		 */
		
		/*
		 * ESERCIZIO
		 * DATI 10 VALORI INTERI IN UN ARRAY NON ORDINATI
		 * APPLICARE L'ALGORITMO PER ORDINARLI 
		 */
		
		//CREO UN CANALE DI COMUNICAZIONE
		Scanner input = new Scanner (System.in);
		//CHIEDO QUANTI NUMERI CI SARANNO NELL'ELENCO
		System.out.println("Quanti numeri vuoi ordinare:");
		int quanti = input.nextInt();
		//CREO UN ARRAY CON DIMENSIONE DATA DALL'UTENTE
		int [] numeri = new int[quanti];
		//INIZIO A RIEMPIRE L'ELENCO
		System.out.println("Riempiamo il nostro elenco: ");
		//CON UN CICLO FOR RIEMPIO LE POSIZIONI
		for (int i = 0; i < numeri.length; i++) {
			//CHIEDO DI DARE IL NUMERO CHE PRENDERA' L'IESIMA POSIZIONE
			System.out.println("Inserisci il numero per la posizione " + (i+1));
			numeri[i] = input.nextInt();
			
		}
		//TERMINATO L'INSERIMENTO
		System.out.println("Inserimento terminato, ti mostro l'elenco");
		//CON UN'ALTRO CICLO FOR MOSTRO I VALORI COME LI HO MESSI
        for (int i = 0; i < numeri.length; i++) {
			//MOSTRO L'IESIMO VALORE
			System.out.println((i+1) + " numero: " + numeri[i]);
			
		}
        
        
		//procedo ad ordinare i numeri
		
		/*
		 *  10 - 8 - 2 - 3 - 1
		 *  8 - 10 - 2 - 3 - 1
		 *  2 - 10 - 8 - 3 - 1
		 *  1 - 10 - 8 - 3 - 2 --- HO TROVATO IL PI� BASSO!!
		 *      8 - 10 - 3 - 2
		 *      3 - 10 - 8 - 2 
		 *      2 - 10 - 8 - 3 --- HO TROVATO IL SECONDO
		 *          8 - 10 - 3
		 *          3 - 10 - 8 -- HO TROVATO IL TERZO
		 *              8 - 10 -- HO TROVATO IL QUARTO
		 *                  10 -- HO TROVATO IL QUINTO
		 */
        /*
        //CICLO SUI PRIMI NUMERI
        for (int i = 0; i < numeri.length; i++) {
        	//CICLO SUI RESTANTI NUMERI
        	for (int l = (i+1); l < numeri.length; l++) {
        		//SE IL SUCCESSIVO � PI� PICCOLO
        		if (numeri[l] < numeri[i]) {
        			//DEVO SCAMBIARE!!
        			//MA NON POSSO SCAMBIARE AL VOLO
        			//MI SERVE UN APPOGGIO
        			//METTO IL PI� GRANDE NELL'APPOGGIO
        			int appoggio = numeri[i];
        			//METTO IL PI� PICCOLO NELLA POSIZIONE PRECEDENTE
        			numeri[i] = numeri[l];
        			//METTO IL VALORI DI APPOGGIO DENTRO IL SUCCESSIVO
        			numeri[l] = appoggio;
        		}
        	}
        }
        
        
      //TERMINATO L'INSERIMENTO
      		System.out.println("Ordinamento terminato, ti mostro l'elenco");
      		//CON UN'ALTRO CICLO FOR MOSTRO I VALORI COME LI HO MESSI
              for (int i = 0; i < numeri.length; i++) {
      			//MOSTRO L'IESIMO VALORE
      			System.out.println((i+1) + " numero: " + numeri[i]);
      			
      		}
        */
		// Bnacomat
              /*
              *MACROANALISI
              *Programma per la gestione di uno sportello bancomat
              *all'apertura il programma mi chiede se voglio fare un prellievo, o un versamento o vedere la lista dei movimenti
              *il conto parte da un saldo di 300 euro.
              *Il programma non ammette prelievi maggiori di 200 euro, ne permette di andare sotto al saldo
              *Non posso versare più di 300 euro alla volta.
              *Gestisci i prelievi come valori negativi, i versamenti come positivi in un unico elenco
              *Quando il programma deve mostrare l'elenco dei movimenti li mostra in ordine crescente, dal più piccolo negativo al più grande positivo


              *PROGETTAZIONE
              *Creo un variabile double per il saldo
              *creo un array di double per i movimenti
              *I valori vanno inseriti sempre positivi, li salverà nell'array negativi se è un prelievo.
              *Quando devo mostrare i movimenti in ordine numeri crescente uso l'algoritmo del doppio for.
              */
        double saldo = 300;
        double[] movimenti = new double[100];
        int posizione = 0; //TIENE TRACCIA DEI MOVIMENTI
        
        int scelta;
        do {
        	
        	System.out.println("Prellievo");//opzione prelievo
        	System.out.println("Versamento");//opzione versamento
        	System.out.println("lista dei movimenti");//opzione lista movimeti
            System.out.println("Esci"); // opzione per uscire
			
			scelta = input.nextInt();
        	
        	switch(scelta) {
        	
        	case 1:
        		System.out.println("Inserisci importo da prelevare: ");
        	    double prelievo = input.nextDouble();
        	    
        	    if (prelievo <= 0) {
        	    	
        	    	System.out.println("Errore: non puoi prlevare l'importo deve essere positivo");
        	    	
        	    } else if (prelievo > 200) {
        	    	
        	    	System.out.println("Non puoi prelevare più di 200 euro");
        	    	
        	    } else if (prelievo > saldo) {
        	    	
        	    	System.out.println("Errore: saldo insufficciente");
        	    	
        	    } else {
        	        saldo -= prelievo;  // aggiorna saldo
        	        movimenti[posizione] = -prelievo; // salvo il prelievo come valore negativo
        	        posizione++;
        	        System.out.println("Hai prelevato " + prelievo + "€. Nuovo saldo: " + saldo + "€");
        	    }
        		break;
        	case 2:
        		System.out.println("Inserisci importo da versare?");
        		double versamento = input.nextDouble();
        		
                if (versamento <= 0) {
                	
                	System.out.println("Errore: non puoi versare l'importo deve essere positivo");
        	    	
        	    } else if (versamento > 300) {
        	    	
        	    	System.out.println("Non puoi versare più di 300 euro");
        	    	
        	    } else {
        	        saldo += versamento;              // aggiorna saldo
        	        movimenti[posizione] = versamento;    // salvo il versamento come positivo
        	        posizione++;
        	        System.out.println("Hai versato " + versamento + "€. Nuovo saldo: " + saldo + "€");
        	    }
        		break;
        	case 3:
        		System.out.println("Stampa lista movimeti");
        		for (int i = 0; i < posizione - 1; i++) {
        		    for (int j = i + 1; j < posizione; j++) {
        		        if (movimenti[i] > movimenti[j]) { 
        		            double appoggio = movimenti[i];
        		            movimenti[i] = movimenti[j];
        		            movimenti[j] = appoggio;
        		        }
        		    }
        		}
        		break;
        	case 0:
        		System.out.println("Uscita dal programma");
        		break;
        	default:
        		System.out.println("Attenzione scelta non valida!");
        	    break;
        	} 
        	
        } while (scelta != 0);
        

	}

}
