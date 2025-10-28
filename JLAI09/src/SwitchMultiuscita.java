import java.util.Scanner;

public class SwitchMultiuscita {

	public static void main(String[] args) {
		

		/*
		 * VEDIAMO LA DIFFERENZA IN USCITA DAL CONFRONT CON SWITCH
		 * IF E' MULTI INGRESSO E MONOUSCITA
		 * OVVERO QUANDO TROVA UN CONFRONTO CON ESITO
		 * POSITIVO LO ESEGUE E ESCE DAL COSTRUTTO
		 * 
		 *  IN SWITCH INVECE E' L'ISTRUZIONE BREAK A FARMI USCIRE
		 *  QUINDI SE NON LA TROVA, NON ESCO!!
		 */
		
		/*
		 * USIAMOLO IN UN MENU CICLICO
		 */
		
		Scanner input = new Scanner (System.in);
		
		int scelta;
		do {
		
			/*
			 * IN QUESTO ESEMPIO IL PI� ALTO DIRITTO DI ACCESSO
			 * CONTIENE TUTTI I SEGUENTI
			 * QUINDI 1 CONTIENE TUTTI E 3
			 * 2 CONTIENE ANCHE QUELLI OPERATIVI
			 * 3 CONTIENE SOLO QUELLI OPERATIVI
			 */
			System.out.println("1 - Per diritti Amministrativi");
			System.out.println("2 - Per diritti Organizzativi");
			System.out.println("3 - Per diritti Operatizi");
			System.out.println("0 - Uscita");
			
			scelta = input.nextInt();
			
			//QUI ABBIAMO INSERITO UN IF...MA
			
			switch (scelta) {
			
			case 1:
				System.out.println("Hai i diritti Amministrativi");
				//break; //MI FERMA IL COSTRUTTO SWITCH
			case 2:
				System.out.println("Hai i diritti Organizzativi");
				//break;
			case 3:
				System.out.println("Hai i diritti Operativi");
				break; //ATTENZIONE L'ULTIMO CONVIENE TENERLO!
			case 0:
				System.out.println("Alla prossima...");
				break;
				
				default: System.out.println("Attenzione scelta non valida");
			
			}

		} while (scelta != 0);
		

	}

}
