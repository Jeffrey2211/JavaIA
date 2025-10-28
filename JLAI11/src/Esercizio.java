import java.util.Scanner;

public class Esercizio {

	public static void main(String[] args) {
		/*
		Scanner input = new Scanner (System.in);
		
		System.out.println("inserisic il tuo nome:");
		String nome = input.nextLine();
		
		for (int i = 0; i < nome.length(); i++) {
			
			System.out.println(nome.charAt(i));
		}
		/*
		/*
		 * ESERCIZIO 
		 * PARTENDO DA QUESTO PRGRAMMA FALLO DIVENTARE CICLICO
		 * ALL'APERTURA IL PRGRAAMMA MI CHIEDE SE VOGLIO
		 * FARE LO SPELLING OPPURE SE VOGLIO L'ULTIMA
		 * LETTERA DEL NOME INSERITO
		 * DOPO LA SCELTA INSERISCI IL NOME E FAI QUELLO CHE HA CHIESTO
		 * PER POI TORNARE SUL MENU IN MODO CICLICO
		 * IL PROGRAMMA SI CHIUDE SE L'UTENTE SCEGLIE 0
		 */

		    
	        
	        Scanner input = new Scanner(System.in);
	        int scelta;
	        do {
	            // Menu
	            System.out.println("--- MENU ---");
	            System.out.println("1) Spelling del nome");
	            System.out.println("2) Ultima lettera del nome");
	            System.out.println("0) Uscita");
	            System.out.print("Scelta: ");

	            scelta = input.nextInt();
	            input.nextLine(); 
	            
	            switch (scelta) {
	                case 1:
	                    System.out.println("Inserisci un nome: ");
	                    String nome1 = input.nextLine();
	                    System.out.println("Spelling del nome:");
	                    for (int i = 0; i < nome1.length(); i++) {
	                        System.out.println(nome1.charAt(i));
	                    }
	                    break;

	                case 2:
	                	System.out.println("Inserisci un nome: ");
	                	String nome2 = input.nextLine();
	                	char ultima = nome2.charAt(nome2.length() - 1);
	                	System.out.println("Ultima lettera: " + ultima);
	                    break;

	                case 0:
	                    System.out.println("Chiusura programma...");
	                    break;

	                default:
	                    System.out.println("Scelta non valida!");
	            }

	        } while (scelta != 0);{
	        	}
	        }

}
