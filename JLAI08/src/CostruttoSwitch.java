import java.util.Scanner;

public class CostruttoSwitch {

	public static void main(String[] args) {

		/*
		 * IN UN MENU CICLICO
		 * POSSO DARE ALL'UTENTE LA POSSIBILITA' DI SCEGLIERE
		 * COSA FARE PER POI TORNARE AL MENU FINITO
		 * L'ESITO DELLA SACELTA
		 * 
		 * UNA VOLTA ASCOLTATA LA SCELTA COME FACCIAMO A DIRE
		 * COSA DEVE ESSERE ESEGUITO?
		 * NELL'ESEMPIO PRECEDENTE ABBIAMO USATO IF 
		 * CHE VA BENE, MA IN QUESTO CASO E' LIMITANTE
		 * PERCHE' IF HA UNA MULTIENTRATA, MA UNA UNICA USCITA
		 * IN PI� IL CONFRONTO E' UN BOOLEANO, A NOI SERVIREBBE PI� UN
		 * CONFRONTO VALORIALE, OVVERO SUL VALORE SCELTO
		 * DALL'UTENTE TRA QUELLI SCEGLILBILI
		 * JAVA PER MIGLIORARE QUESTE DUE CARATTERISTICHE
		 * CI FORNISCE IL COSTRUTTO SWITCH
		 * 
		 */
		
		/*
		 * USIAMOLO IN UN MENU CICLICO
		 */
		
		Scanner input = new Scanner (System.in);
		
		int scelta;
		
		do {
		
			System.out.println("1 - Per opzione A");
			System.out.println("2 - Per opzione B");
			System.out.println("3 - Per opzione C");
			System.out.println("0 - Uscita");
			
			scelta = input.nextInt();
			
			//QUI ABBIAMO INSERITO UN IF...MA
			
			switch (scelta) {
			
			case 1:
				System.out.println("Hai scelto A");
				break; //MI FERMA IL COSTRUTTO SWITCH
			case 2:
				System.out.println("Hai scelto B");
				break;
			case 3:
				System.out.println("Hai scelto C");
				break;
			case 0:
				System.out.println("Alla prossima...");
				break;
				
				default: System.out.println("Attenzione scelta non valida");
			
			}

		} while (scelta != 0);
		
		

	}

}
