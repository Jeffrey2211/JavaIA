import java.util.Scanner;

/*
		 * MACROANALISI
		 * GIOCO DELLA BATTAGLIA NAVALE
		 * MI SERVE UN CAMPO DI GIOCO 10X10
		 * DEVO POI NASCONDERE 5 NAVI
		 * E PROVARE AD ATTACCARLE
		 * IL GIOCO FINISCE QUANDO LE HO ABBATTUTE TUTTE
		 */
		
		/*
		 * PROGETTAZIONE
		 * CREO UN ARRAY BIDIMENSIONALE 10X10 CHE E' IL CAMPO REALE
		 * E UN ARRAY 10X10 CHE E' IL CAMPO CHE VEDO IO
		 * GENERO DELLE COPPIE DI NUMERI CON RANDOM
		 * PER NASCONDERE LE NAVI
		 * A QUESTO PUNTO PROVO A COLPIRLE
		 * ATTRAVERSO UN CICLO INDEFINITO
		 * CHE SI CHIUDE QUANDO LE HO COLPITE TUTTE LE 5 NAVI 
		 */


public class GiocoBattagliaNavale {
	
	public static char [][]campogioco = new char [10][10];
	public static char [][]miocampo = new char [10][10];
	public static int numeronavi;
	public static Scanner inputInt = new Scanner(System.in);
	public static int affondate = 0;
	
	/*
	 * N -> NAVE
	 * X -> AFFONDATO
	 * A -> ACQUA
	 * vuoto -> COLPIBILE
	 */

	public static void main(String[] args) {
		
		System.out.println("Quante navi vuoi nascondere?");
		numeronavi = inputInt.nextInt();
		
		//piazzo le 5 navi nel campo di gioco
		riempinavi(numeronavi);
		
		boolean vittoria = false;
		do {

		mostramiocampo();
		vittoria = colpisci();

		} while (vittoria==false);
		
		System.out.println("Hai vinto!!");
		
	}
	
	
	private static boolean colpisci() {
		System.out.println("Dove vuoi sparare?");
		System.out.println("Coordinata X:");
		int primo = inputInt.nextInt(); //OCCHIO CHE E' UMANO!!
		System.out.println("Coordinata Y:");
		int secondo = inputInt.nextInt();
		
			if (campogioco[primo-1][secondo-1] == 'N') {
				
				System.out.println("Nave affondata!");
				affondate++;
				miocampo[primo-1][secondo-1] = 'X';
				
			} else {
				System.out.println("Acqua!!");
				miocampo[primo-1][secondo-1] = 'A';
			}
			
			if (affondate==numeronavi) {
				return true;
			} else {
				return false;
			}
			
			
	}

	private static void mostramiocampo() {
		
		for (int i = 0; i < 10; i++) {
			
			for (int l = 0; l < 10; l++) {
				
				System.out.print(miocampo[i][l]);
				
				if (l < 9) {
					System.out.print(" - ");
				}
				
			}
			System.out.println();
			
		}
		
	}

	private static void riempinavi(int numeronavi) {

		for (int i = 0; i < numeronavi; i++) {
			
			int primacoordinata = (int)(Math.random()*10);
			int secondacoordinata = (int)(Math.random()*10);
			
			campogioco[primacoordinata][secondacoordinata] = 'N';
			
		}
		
	}

}
