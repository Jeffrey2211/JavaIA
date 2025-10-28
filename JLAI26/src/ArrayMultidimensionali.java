
public class ArrayMultidimensionali {

	public static void main(String[] args) {
		
		/*
		 * GLI ARRAY SONO:
		 * SEQUENZE FINITE DI VARIABILI ORDINATE DELLO STESSO TIPO
		 * MA QUELLI CHE ABBIAMO VISTO FINO AD ORA 
		 * SONO RAPPRESENTABILI COME UNA COLONNA SINGOLA
		 * X
		 * X
		 * X
		 * X
		 * X
		 * UN ELENCO DI VALORI MONODIMENSIONALE
		 * PARLIAMO DEGLI ARRAY BIDIMENSIONALI
		 * 
		 * 
		 */

		int [][]numeri = new int[3][3]; //9 VALORI
		
		//UNA ARRAY MULTIDIMENSIONALE CONTINE UN NUMERO DI VALORI
		//OTTENUTO DALLA MOLTIPLICAZIONE DELLE SINGOLE DIMENSIONI
		
		/*
		 * 0 - 0 - 3
		 * 0 - 9 - 0
		 * 0 - 0 - 0
		 */
		
		numeri[0][2] = 3; 
		numeri[1][1] = 9;
		
		
		for (int i = 0; i < numeri[0].length; i++) {
			
			for (int l = 0; l < numeri[1].length; l++) {
				
				System.out.println("Posto " + i + l +" = " + numeri[i][l]);
				
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}

}
