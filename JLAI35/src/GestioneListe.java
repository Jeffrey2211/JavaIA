import java.util.ArrayList;
import java.util.Scanner;

/*
		 * FINO AD ORA ABBIAMO USATO COME CONTENITORE GLI ARRAY
		 * CHE SONO SEQUENZE FINITE E ORDINATE DI VARIABILI DELLO STESSO TIPO
		 * IL FATTO CHE SIANO ORDINATE, CI AIUTA
		 * MA CHE SIANO FINITE E DELLO STESSO TIPO CI LIMITA!
		 * 
		 * LE LISTE RISOLVONO QUESTI DUE PROBLEMI
		 * POSSONO CONTENERE DIVERSI TIPO DI ELEMENTI, SIA VARIABILI CHE OGGETTI
		 * LA LORO DIMENSIONE E' DINAMICA ED è AUTOMATICAMENTE
		 * SINCRONIZZATA CON LA CAPACITà
		 * 
		 * QUINDI NELLE LISTE INIZIAMO A PARLARE NON PIù DI POSIZIONI DA RIEMPIRE
		 * MA FACCIAMO QUELLO CHE VIENE CHIAMATO CRUD
		 * 
		 * C - CREATE
		 * R - READ
		 * U - UPDATE
		 * D - DELETE
		 * 
		 * LE LISTE SONO OGGETTI E VENGONO DICHIARATE E INIZIALIZZATE COME TALI
		 * 
		 */

public class GestioneListe {
	
	public static void main(String[] args) {
		
		ArrayList mialista = new ArrayList();
		Scanner input = new Scanner (System.in);
		
		/*
		 * lista dinamica CAPACITA' = DIMENSIONE SEMPRE!
		 */
		
		//CREATE
		mialista.add("Ciao");
		mialista.add(5);
		mialista.add(true);
		mialista.add(7.30);
		mialista.add('A');
		mialista.add(input);
		
		//MOSTRO LA DIMENSONE DELLA LISTA
		//System.out.println(mialista.size());
		
		//READ - GET
		
		for (int i = 0; i < mialista.size(); i++) {
			
			System.out.println(mialista.get(i));
			
		}
		
		
		System.out.println("-----------------");
		
		//UPDATE - SET
		//JAVA CONTA DA ZERO!!!!
		
		mialista.set(5, "Pippo");

		for (int i = 0; i < mialista.size(); i++) {
			
			System.out.println(mialista.get(i));
			
		}
		System.out.println("-----------------");
		
		//DELETE - REMOVE
		
		mialista.remove(2);
		
		
        for (int i = 0; i < mialista.size(); i++) {
			
			System.out.println(mialista.get(i));
			
		}
		

	}

}
