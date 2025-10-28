import java.util.Scanner;

public class UnioneMetodi {
	
	public static Scanner input = new Scanner (System.in);
	public static double totbenzina = 0;
	public static double totdiesel = 0;
	
	public static void main(String[] args) {
		
		/*
		 * PU� SUCCEDERE CHE NELLA CREAZIONE DEI METODI
		 * ALCUNI METODI SI "ASSOMIGLINO" MOLTO
		 * OVVERO VARIANO SOLO PER PICCOLE COSE
		 * IN GENERALE QUANDO SUCCEDE E' SEMPRE POSSIBILE
		 * UNIRLI AUMENTANDO IL NUMERO DEI SEGNAPOSTI
		 */

		//aggiungibenzina();
		
		//aggiungidiesel();
		
		
		aggiungi("benzina");
		
		aggiungi("Diesel");
		
	}

	private static void aggiungi(String tipo) {
		
		System.out.println("Inserisci il numero dei litri di " + tipo +":");
		int litri = input.nextInt();
		if (tipo.equals("benzina")) {
		totbenzina += litri;
		} else {
		totdiesel += litri;	
		}
		System.out.println("Incremento effettuato con successo!");
		
	}

	/*
	private static void aggiungidiesel() {
		
		System.out.println("Inserisci il numero dei litri di Diesel:");
		int litri = input.nextInt();
		totdiesel += litri;
		System.out.println("Incremento effettuato con successo!");
		
		
	}

	private static void aggiungibenzina() {
		
		System.out.println("Inserisci il numero dei litri di benzina:");
		int litri = input.nextInt();
		totbenzina += litri;
		System.out.println("Incremento effettuato con successo!");
	}

	*/

}
