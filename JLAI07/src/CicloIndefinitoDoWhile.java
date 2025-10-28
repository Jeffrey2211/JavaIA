import java.util.Scanner;

public class CicloIndefinitoDoWhile {

	public static void main(String[] args) {
		
		/*
		 * MOLTO SPESSO, COME NEL CASO DEI MENU
		 * LA CONDIZIONE INIZIALE E' DETTATA DAL PROGRAMMATORE
		 * QUINDI INUTILE CONTROLLARLA
		 * QUANDO LE COSE POI CAMBIANO PER EFFETTO DELLA
		 * INTERAZIONE CON L'UTENTE, ALLORA HA SICURAMENTE
		 * SENSO FARE UN CONFRONTO LOGICO	
		 *
		 * PER QUESTO MOTIVO NASCE IL COSTRUTTO DO WHILE
		 * (IL COSTRUTTO CHE SI FIDA - ALMENO LA PRIMA VOLTA)
		 * 	 
		 */
		
		/*
		 * MOLTO USATO AD ESEMPIO PER I MENU
		 */
		
		//CREO UN CANALE DI COMUNICAZIONE
		Scanner input = new Scanner (System.in);
		//imposto una variabile pER LA SCLTA DEL MENU
		int scelta;
		//CREO UN CICLO INDEFINITO - CHE SI FIDA
		do {
			
			System.out.println("1 - Per opzione A");
			System.out.println("2 - Per opzione B");
			System.out.println("3 - Per opzione C");
			System.out.println("0 - Uscita");
			
			//ASCOLTO LA SCELTA DELL'UTENTE
			scelta = input.nextInt();
			
			//COSTRUTTO IF SULLA SCELTA DELL'UTENTE
			if (scelta == 1) {
				System.out.println("Hai scelto opzione A");
 			} else if (scelta == 2) {
 				System.out.println("Hai scelto opzione B");
 			} else if (scelta == 3) {
 				System.out.println("Hai scelto opzione C");
 			}
			
			
		} while (scelta != 0);

	}

}
