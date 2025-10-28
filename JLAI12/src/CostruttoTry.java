import java.util.Scanner;
import java.util.InputMismatchException

public class CostruttoTry {

	public static void main(String[] args) {
		
		/*
		 * ALCUNE VOLTE LE ISTRUZIONI SONO POTENZIALMENT DANNOSE
		 * LA LORO POTENZIALITÀ PUÒ ESSERE DERIVANTE DA UN
		 * CATTIVO UTILIZZO DA PARTE DELL'UTENTE
		 * ANCHE SE LO AVVISIAMO UN UTENTE PUÒ SBGLIARTE!
		 * GLI ERRORI JAVA LI CHIAMA ECCEZIONI
		 * 
		 * PER GESTIRLI JAVA MI OFFRE UN COSTRUTTO TRY
		 * TRY MI DA LA POSSIBILITÀ DI PROVARE DELLE ISTRUZIONI
		 * SE QUASTE FUNZIONANO, TUTTO OKAY
		 * SE GENERANO UNA ECCEZONE ALLOARA JAVA ""PREDE IN MANO
		 * (CATCH) LA SITUAZIONE ESEGUENDO UN CODICE ALTERNATIVO
		 */
		
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci un numero:");
		
		
		try {
			int numero = input.nextInt(); // potenzialmente dannosa
			System.out.println("Hai inserito " + numero);
			
		} catch (Exception e){
			System.out.println("Attenzione valore inerito non valido");
			
		}
		
		//JAVA PUÒ GESTIRE PIÙ TIPI DI ERRORI CON PIÙ CATCH
		try {
		System.out.println("Facciamo una divisione...");
		System.out.println("Inserisci il primo numero:");
		int primonumero = input.nextInt();
		System.out.println("Inserisci il secondo numero:");
		int secondonumero = input.nextInt();
		double divisione = primonumero / secondonumero; // POTENZIALMENTE DANNOSO
		System.out.println("Il risultato della divisione è:");
		
		} catch (ArithmeticException e) {
			
			System.out.println("Attenzione valore inserito non valido");
			
		} catch (ArithmeticException e) {
			
			System.out.println("Attenzione divisione per zero impossibile");
			
		} finally {
			//OPERAZIONE CHE VIENE ESEGUITA  
			//SIA CHE I TRY FUNZIONI
			//SIA CHE INTERVEGA UN CATCH
		}
		
		
		//java.lang.ArithmeticException
		//java.util.InputMismatchException
		
	}

}
