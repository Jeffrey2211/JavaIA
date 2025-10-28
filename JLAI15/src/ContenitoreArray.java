import java.util.Scanner;

public class ContenitoreArray {

	public static void main(String[] args) {
		
		/*
		 * FINO AD ORA ABBIAMO USATO DELLE VARIABILI
		 * MA OGNI VARIABILE E' SINGOLA E A SE STANTE
		 * SE VOGLIO METTERE IN RELAZIONE DUE VARIABILI
		 * HO BISOGNO DI UN CONTENITORE PI� GRANDE
		 * JAVA OFFRE GLI ARRAY
		 * ARRAY: SEQUENZA ORDINATA E FINITA DI VARIABILI DELLO STESSO TIPO
		 * STESSO TIPO: SE LA BATTEZZO INT AD ESEMPIO, SARANNO TUTTE VARIABILI INT
		 * FINITA: DEVI SAPERE IN FASE DI DICHIARAZIONE QUANTE SONO LE 
		 * 		   VARIABILI DELLA SEQUENZA
		 * ORDINATA: OGNI ELEMENTO E' INDIVIDUABILE DAL SUO INDICE POSIZIONALE
		 * QUINDI SE UN ARRAY E' COMPOSTO DA UN NUMERO FINITO DI ELEMENTI, 
		 * POSSIAMO SEMPRE USARE IL CICLO DEFINITO FOR PER GUARDARCI DENTRO
		 */
		
		//DEFINIRE UNA VARIABILE
		int numero;
		//DEFINIRE UN ARRAY SEQUENZA DI 10 INTERI
		int []numeri = new int[10]; 
		
		//System.out.println(numero); //NON POSSO USARE UNA VARIABILE
									//SENNON E' INIZIALIZZATA
		
		//IN UN ARRAY QUANDO GLI ELEMENTI VENGONO CREATI
		//VENGONO COMUNQUE INIZIALIZZATI CON IL LORO VALORE DI DEFAULT
		//PER GLI INTERI -> 0
		//PER GLI DOUBLE -> 0.0
		//PER LE STRINGHE -> null
		//PER I BOOLEAN -> false
		
		System.out.println(numeri[3]);
		
		String [] nomi = new String[10]; //ARRAY DI 10 STRINGHE
		
		System.out.println(nomi[3]);
		
		boolean [] stati = new boolean[10]; //ARRAY DI 10 STRINGHE
		
		System.out.println(stati[3]);
		
		
		String [] mansioni = {"Operaio", "Ingegnere", "Tecnico"};
		
		System.out.println(mansioni[2]);
		
		//NB: L'ACCESSO AL VALORE INDICIZZATO DELL'ARRAY
		//E' SIA IN LETTURA CHE IN SCRITTURA
		
		nomi[8] = "Pippo";
		
		System.out.println(nomi[8]);
		
		//QUINDI POTENDO ACCEDERE IN LETTURA E IN SCRITTURA
		//POSSO USARE UN FOR SIA PER LEGGERE CHE PER SCRIVERE
		
		//PER SCRIVERE
		Scanner input = new Scanner(System.in);
		
		System.out.println("Riempi l'array di 10 stringhe");
		for (int i = 0; i < nomi.length; i++) {
		
			System.out.println("Inserisci la stringa al posto " + (i+1)); //UMANIZZAZIONE
			nomi[i] = input.nextLine();
		}
		
		//MOSTRO I 10 VALORI INSERITI
		System.out.println("Riepilogo delle 10 stringhe");
		for (int i = 0; i < nomi.length; i++) {
			
			System.out.println("Stringa al posto " + (i+1) + " � " + nomi[i]); //UMANIZZAZIONE
	
		}
		
		
		

	}

}
