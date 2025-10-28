import java.util.Scanner;


public class EsercizioSugliArray {

	public static void main(String[] args) {
		
		/*
		*MACROANALISI
		*Programma per le comande in una pizzeria
		*Il programma gestisce un menu di 10 tipi di pizze e 10 tipi di birre
		*tutte con il loro relativo prezzo
		*Quando il cameriere arriva al tavolo chiede ad ogni cliente cosa vuole
		*mostrando il menu prima delle pizze e pio delle birre da cui ogni commensale sceglie la pizza e la birra che vuole
		*Devo poter sempre riepilogare la comanda a cui devo anche aggiungere per ogni commensale (pizza)
		*2 euro di coperto
		*Il riepilogo della comanda deve quindi darmi alla fine il conto del tavolo
		*/
		
        /*
		*PROGETTAZIONE
		8Programma con più menu ciclici
		*il menu principale sarà
		*1 Mostra Pizze, 2 Mostra birre, 3 Riepilogo comanda
		*Ogni volta che mostro le pizze o le birre devo poter scegliere quale aggiungere alla comanda (da un menu secondario)
		*La scelta deve essere fatta sempre numericamente.
		*La quantità è sempre 1 per ogni singola scelta.
		*Quindi avremo due coppie di array pizze/prezzipizza - birre/prezzibirre
		*più una quinta coppia scelta/prozzoscelta che rappresenta la comanda
		*Inserisci a monte le 10 pizze e le 10 birre con i loro prezzi con l'utilizzo 
		*diretto in fase di dichiarazione (parentesi graffe)
		*Quando scorri la comanda (voce menu 3) per calcolare il conto ricorda di aggiungere 2 euro di coperto per ogni pizza
		*Imposta una variabile coperto a monte che poi la aggiungi come incremento ad ogni prezzo di pizza
        */ 
		
		//CREO I TUBI SCANNER
		Scanner input = new Scanner (System.in);
		
		
		//CREO ARRAY PIZZE
		String []nomipizze = {"1 - Margherita", "2 - Diavola", "3 - Capricciosa", "4 - Quattro Stagioni", "5 - Prosciutto",
                "6 - Funghi", "7 - Bufalina", "8 - Tonno e Cipolla", "9 - Vegetariana", "10 - Quattro Formaggi"};
		double []prezzipizze = {5.0, 6.5, 7.0, 7.5, 6.0, 6.0, 7.5, 7.0, 6.5, 7.5};
		
		//CREO ARRAY BIRRE
		String []nomibirre = {"1 - Moretti", "2 - Ichnusa", "3 - Peroni", "4 - Heineken", "5 - Corona",
                "6 - Tuborg", "7 - Guinness", "8 - Tennent's", "9 - Paulaner", "10 - Nastro Azzurro"};
		double []prezzibirre = {3.0, 3.5, 3.0, 3.5, 4.0, 3.5, 4.5, 4.5, 5.0, 3.5};
		
		//CREO ARRAY COMANDA
		String[] ordini = new String[100];//per salvare cosa sceglie l’utente
        int index = 0;//per sapere a che punto sei nell’array ordini
        double[] prezziOrdini = new double[100]; // per salvare il prezzo di ogni ordine
        double totale = 0;//per sommare i prezzi
        //COPERTO
        int coperto = 2;
        		
        //CREO LA VARIABILE SCELTA
        int scelta;
    	//MENU DELLE PIZZE
        do {
        	
        	System.out.println("Menu Pizze");
        	for (int i = 0; i < nomipizze.length; i++) {
        	    System.out.println((i+1) + ". " + nomipizze[i] + " - €" + prezzipizze[i]);
        	}
        	System.out.println("0. Esci dal menù delle pizze"); // opzione per uscire
			
			scelta = input.nextInt();
			
			switch (scelta) {
			
			case 1:
				ordini[index] = nomipizze[0];
				prezziOrdini[index] = prezzipizze[0];
			    totale += prezzipizze[0] + coperto;
			    index++;
			    System.out.println("Hai scelto: " + nomipizze[0]);
				break;
		    case 2:
		    	ordini[index] = nomipizze[1];
		    	prezziOrdini[index] = prezzipizze[1];
		        totale += prezzipizze[1] + coperto;
		        index++;
		        System.out.println("Hai scelto: " + nomipizze[1]);
		    	break;
		    case 3:
		    	ordini[index] = nomipizze[2];
		    	prezziOrdini[index] = prezzipizze[2];
		        totale += prezzipizze[2] + coperto;
		        index++;
		        System.out.println("Hai scelto: " + nomipizze[2]);
		    	break;
		    case 4:
	        	ordini[index] = nomipizze[3];
	        	prezziOrdini[index] = prezzipizze[3];
	            totale += prezzipizze[3] + coperto;
	            index++;
	            System.out.println("Hai scelto: " + nomipizze[3]);
	        	break;
	        case 5:
	        	ordini[index] = nomipizze[4];
	        	prezziOrdini[index] = prezzipizze[4];
	            totale += prezzipizze[4] + coperto;
	            index++;
	            System.out.println("Hai scelto: " + nomipizze[4]);
	            break;
	        case 6:
	        	ordini[index] = nomipizze[5];
	        	prezziOrdini[index] = prezzipizze[5];
	            totale += prezzipizze[5] + coperto;
	            index++;
	            System.out.println("Hai scelto: " + nomipizze[5]);
	            break;
	        case 7:
	        	ordini[index] = nomipizze[6];
	        	prezziOrdini[index] = prezzipizze[6];
	            totale += prezzipizze[6] + coperto;
	            index++;
	            System.out.println("Hai scelto: " + nomipizze[6]);
	            break;
	        case 8:
	        	ordini[index] = nomipizze[7];
	        	prezziOrdini[index] = prezzipizze[7];
	            totale += prezzipizze[7] + coperto;
	            index++;
	            System.out.println("Hai scelto: " + nomipizze[7]);
	            break;
	        case 9:
	        	ordini[index] = nomipizze[8];
	        	prezziOrdini[index] = prezzipizze[8];
	            totale += prezzipizze[8] + coperto;
	            index++;
	            System.out.println("Hai scelto: " + nomipizze[8]);
	            break;
	        case 10:
	        	ordini[index] = nomipizze[9];
	        	prezziOrdini[index] = prezzipizze[9];
	            totale += prezzipizze[9] + coperto;
	            index++;
	            System.out.println("Hai scelto: " + nomipizze[9]);
	            break;
		    case 0:
		    	System.out.println("Uscita dal menu pizze...");
			    break;
			} 
			
        	} while(scelta != 0);
			
			//MENU DELLE BIRRE
            do {
            	
            	System.out.println("Menu Birre");
            	for (int i = 0; i < nomibirre.length; i++) {
            	    System.out.println((i+1) + ". " + nomibirre[i] + " - €" + prezzibirre[i]);
            	}
            	System.out.println("0. Esci dal menù delle birre"); // opzione per uscire
    			
    			scelta = input.nextInt();
    			
    			switch (scelta) {
    			
    			case 1:
    				ordini[index] = nomibirre[0];
    				prezziOrdini[index] = prezzibirre[0];
    			    totale += prezzibirre[0];
    			    index++;
    			    System.out.println("Hai scelto: " + nomibirre[0]);
    				break;
    		    case 2:
    		    	ordini[index] = nomibirre[1];
    		    	prezziOrdini[index] = prezzibirre[1];
    		        totale += prezzibirre[1];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[1]);
    		    	break;
    		    case 3:
    		    	ordini[index] = nomibirre[2];
    		    	prezziOrdini[index] = prezzibirre[2];
    		        totale += prezzibirre[2];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[2]);
    		    	break;
    		    case 4:
    		        ordini[index] = nomibirre[3];
    		        prezziOrdini[index] = prezzibirre[3];
    		        totale += prezzibirre[3];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[3]);
    		        break;
    		    case 5:
    		        ordini[index] = nomibirre[4];
    		        prezziOrdini[index] = prezzibirre[4];
    		        totale += prezzibirre[4];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[4]);
    		        break;
    		    case 6:
    		        ordini[index] = nomibirre[5];
    		        prezziOrdini[index] = prezzibirre[5];
    		        totale += prezzibirre[5];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[5]);
    		        break;
    		    case 7:
    		        ordini[index] = nomibirre[6];
    		        prezziOrdini[index] = prezzibirre[6];
    		        totale += prezzibirre[6];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[6]);
    		        break;
    		    case 8:
    		        ordini[index] = nomibirre[7];
    		        prezziOrdini[index] = prezzibirre[7];
    		        totale += prezzibirre[7];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[7]);
    		        break;
    		    case 9:
    		        ordini[index] = nomibirre[8];
    		        prezziOrdini[index] = prezzibirre[8];
    		        totale += prezzibirre[8];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[8]);
    		        break;
    		    case 10:
    		        ordini[index] = nomibirre[9];
    		        prezziOrdini[index] = prezzibirre[9];
    		        totale += prezzibirre[9];
    		        index++;
    		        System.out.println("Hai scelto: " + nomibirre[9]);
    		        break;
    			case 0:
    				System.out.println("Uscita dal menu birre...");
    				break;
    			
    			} 
            } while(scelta != 0);
    			
            System.out.println("\n=== RIEPILOGO ORDINE ===");
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ". " + ordini[i] + " - €" + prezziOrdini[i]);
            }
            System.out.println("Totale da pagare: €" + totale);

    	        
    	        
    	        
    	        
          }
		
}
		

	


