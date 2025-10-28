import java.util.Scanner;

public class MetodiNonVoid {

	public static void main(String[] args) {
		
		
		/*
		 * JAVA MI DA LA POSSIBILITÀ DI CREARE DELLE ABILITÀ O METODI
		 * CHE OLTRE A RESTITUIRE SE VOGLIO DELLE ISTRUZIONI
		 * MI PUÒ RESTITUIRE (return)  UN VALORE DI UN TIPO CHE
		 * "OVVIAMENTE" JAVA DEVE SAPERE PRIMA
		 * 
		 */
		
		Scanner inputit = new Scanner (System.in);
		
		System.out.println("Inserisci il primo numero");
		int primo = inputit.nextInt();
		System.out.println("Inserisci il secondo numero");
		int secondo = inputit.nextInt();
	}	
		
	public static int somma(int primo, int secondo) {
		return primo + secondo;
	}

}
