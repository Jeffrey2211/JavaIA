
public class ArrayOrdinati {

	public static void main(String[] args) {
		
		/*
		 * ORA CON GLI ARRAY ABBIAMO DEI CONTENITORI
		 * GRANDI IN MODO DEFINITO E CONTENENTI VARAIBILI DELLO STESSO TIPO
		 * MA SE DEVO METTERE IN RELAZIONE DUE VALORI CHE NON SONO DELLO STESSO TIPO?
		 * AD ESEMPIO IL NOME DI UN PRODOTTO E IL SUO PREZZO?
		 * POSSO ASSUMERE CHE CREANDO DUE ARRAY GLI ELEMENTI CHE OCCUPANO
		 * LA STESSA POSIZIONE NELL'ARRAY SONO RELAZIONATI TRA LORO
		 */
		
		String []nomioggetti = {"TV", "Radio", "PC", "Lavatrice", "Frigo"};
		double []prezzioggetti = {120.50, 80, 350.40, 600.70, 500};
		
		
		System.out.println("Elenco dei prodotti....");
		
		for (int i = 0; i < nomioggetti.length; i++) {
			
			System.out.println((i+1) + " Oggetto: " + nomioggetti[i] 
					+ " al prezzo di " + prezzioggetti[i] + " euro");
			
		}
		
		
		
		

	}

}
