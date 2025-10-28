import java.util.Scanner;

public class CicloIndefinito {

	public static void main(String[] args) {

		/*
		 * SPESSO ABBIAMO LA NECESSITA' DI RIPETERE
		 * UNA PORZIONE DI CODICE
		 * MA QUANTE VOLTE LA DOBBIAMO RIPETERE?
		 * SE SAPPIAMO A MONTE QUANTE VOLTE DEVE ESSERE RIPETUTA
		 * ALLORA SIAMO DAVANTI AD UN CICLO DEFINITO
		 * ALTRIMENTI IL NOSTRO CICLO E' INDEFINITO
		 */
		
		/*
		 * CICLO INDEFINITO
		 * JAVA MI FORNISCE IL COSTRUTTO WHILE (MENTRE)
		 * LA STRUTTURA E' SEMPRE LA STESSA
		 * 1 - PAROLA RISERVATA
		 * 2 - CONFRONTO TRA LE TONDE
		 * 3 - ISTRUZIONI TRA LE QUADRE
		 * 
		 * ...FINO A QUANDO IL CONFRONTO TRA LE TONDE
		 * DA ESITO POSITIVO, IL CICLO CONTINUA A RIPETERSI
		 */
		
		/*
		int numero = 6;
		
		while (numero == 5) {
			System.out.println("Ciao");
		}
		*/
		
		//SE LA CONDIZIONE E' SEMPRE VERA -> LOOP
		//SE E' SEMPRE FALSA IL CICLO NON PARTE MAI
		
		/*
		 * MA IL LOOP E' UN ERRORE??
		 * ASSOLUTAMENTE NO!
		 * LA MAGGIOR PARTE DELLE APP OGGI IN USO
		 * SI BASA SU UN LOOP
		 * 
		 */
		
		/*
		 * COME FACCIO QUINDI A GESTIRE UN CICLO INDEFITO 
		 * CHE PARTA E CHE FINISCA?
		 * 
		 * IN REALTA' IL CICLO VIENE DEFINITO
		 * DALL'UTENTE CHE CAMBIA LE CARTE IN TAVOLA
		 * E CREA LA CONDIZIONE DI CHIUSURA DEL CICLO
		 */
		//CREO UN CANALE DI COMUNICAZIONE
		Scanner input = new Scanner(System.in);
		//INIZIALIZZO UNA VARIABILE A 0
		int numero = 0; //CONDIZIONE PER ENTRARE NEL CICLO
		
		//CREO UN CICLO CHE SI RIPETE SE IL NUMERO E'
		//PI� PICCOLO DI 10
		while (numero < 10) {
		
			//MI CHIEDE DI INSERIRE UN NUMERO
			System.out.println("Inserisci un numero");
			numero = input.nextInt();
			//CON UN CONTROLLO IF...
			if (numero < 10) {
				System.out.println("Numero troppo piccolo!");
				System.out.println("...Riprova");
			} else {
				System.out.println("ok va bene");
			}
		
		}
		
		/*
		 * QUINDI QUI E' L'INTERAZIONE CON L'UTENTE
		 * CHE GENERA LA CONDIZIONE DI CHIUSURA 
		 * NON SAPENDO QUANDO QUESTO AVVERR�
		 * IL CICLO SI DICE INDEFINITO 
		 */

		

	}

}
	
