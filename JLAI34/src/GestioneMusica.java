import Strumenti.CollezioneChitarra;
import java.util.Scanner;

import Musica.Gospel;
import Musica.Afro;
import Musica.Texas;
import Musica.Chicago;


public class GestioneMusica {
	
	/*
	*Ambito musicale

	*Abbiamo due elenchi di categorie musicali
	*Musica Soul - Blues 

	*Soul si estende in: Gospel, Afro
	*Blues: Texas, Chicago

	*Superclassi almeno 2 attributi, le estese almeno 1

	*Nel menu principale ho la voce
	*Collezione Chitarra
	*La chitarra viene usata nei brani Gospel e nei brani Texas

	*Scegliere l'elenco, Inserire in uno dei due elenchi mostrando il sottomenu

	*Per la collezione crea una interfaccia

	*Quando l'utente vuole vedere la collezione chitarra, il programma
	*mostrerà un array con i brani che possono farne parte.

	*Per i brani texas e gospel scrivi un metodo suonochitarra che sarà preso dall'interfaccia come metodo astratto. 

	-------------

	*1 Soul
	*2 Blues
	*3 Catalogo Chitarra
	*0 Esci


	*1 -> 
	*1 Gospel
	*2 Afro
	*0 torna al menu...
	*/
	
	
	//Scanner globale per leggere l'input dell'utente
	public static Scanner input = new Scanner(System.in);
    //Array per la collezione chitarra
	public static CollezioneChitarra[] elencobrani = new CollezioneChitarra[10]; // massimo 10 brani
	//Contatore della posizione corrente nell'array
	public static int posizione = 0;

	
	public static void main(String[] args) {
		
		int scelta;
		//Ciclo principale del programma: mostra il menu finché l'utente non sceglie 0 (Esci)
        do {
        	
        	scelta = mostramenu();//mostra il menu principale e legge la scelta
        	
        	faiswitch(scelta);//esegue l'azione
            
        } while (scelta != 0);

	}


	private static int mostramenu() {
		System.out.println("Menu principale:");
        System.out.println("1 - Soul");
        System.out.println("2 - Blues");
        System.out.println("3 - Catalogo Chitarra");
        System.out.println("0 - Esci");
        
		return input.nextInt();
	}


	private static void faiswitch(int scelta) {
        switch (scelta) {
        case 1: //Soul
        	sottomenusoul();//chiama il sottomenù Soul
            break;

        case 2: // Blues
        	sottomenublues();//chiama il sottomenù Blues
            break;

        case 3: // Catalogo chitarra
        	catalogodellachitarra();//mostra tutti i brani con chitarra
            break;

        case 0:
            System.out.println("Uscita...");
            break;

        default:
            System.out.println("Scelta non valida!");
    }
		
	}

    /*
     * Sottomenù della categoria Soul
     * L'utente può inserire brani Gospel o Afro
     * Solo Gospel viene inserito nella collezione chitarra
     */
	private static void sottomenusoul() {
		 System.out.println("1 - Gospel");
		    System.out.println("2 - Afro");
		    System.out.println("0 - Torna al menu principale");

		    int sotto = input.nextInt();
		    input.nextLine(); 

		    if (sotto == 1) { // Gospel
		        System.out.print("Titolo brano: ");
		        String titolo = input.nextLine();
		        System.out.print("Artista: ");
		        String artista = input.nextLine();
		        elencobrani[posizione++] = new Gospel(titolo, artista);//aggiunge alla collezione
		    } else if (sotto == 2) {
		        System.out.println("Afro non ha chitarra, impossibile aggiungere.");
		    }
		
	}

    /*
     *Sottomenù della categoria Blues
     *L'utente può inserire brani Texas o Chicago
     *Solo Texas viene inserito nella collezione chitarra
     */
	private static void sottomenublues() {
	    System.out.println("1 - Texas");
	    System.out.println("2 - Chicago");
	    System.out.println("0 - Torna al menu principale");

	    int sotto = input.nextInt();
	    input.nextLine(); 

	    if (sotto == 1) { // Texas
	        System.out.print("Titolo brano: ");
	        String titolo = input.nextLine();
	        System.out.print("Artista: ");
	        String artista = input.nextLine();
	        elencobrani[posizione++] = new Texas(titolo, artista);//aggiunge alla collezione
	    } else if (sotto == 2) {
	        System.out.println("Chicago non ha chitarra, impossibile aggiungere.");
	    }
		
	}

    /*
     *Mostra la collezione di brani che possono suonare la chitarra
     *Chiama il metodo suonochitarra() per ogni brano nell'array
     */
	private static void catalogodellachitarra() {
	    System.out.println("Catalogo chitarra:");
	    for (int i = 0; i < posizione; i++) {
	        elencobrani[i].suonochitarra();
	    }

	}
}
