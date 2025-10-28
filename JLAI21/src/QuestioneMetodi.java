
public class QuestioneMetodi {

	public static void main(String[] args) {
		
		
		/*
		 * 	ATTRIBUTO QUELLO CHE SI E'
		 * METODO: QUELLO CHE SI FA
		 * UN PROGRAMMA AD ESEMPIO HA SEMPRE UN METODO MAIN CHE MI AVVIA IL PRGRAMMA
		 * E FINO AD ORA ABBIAMO MESSO TUTTO NEL MAIN
		 * MA ORA IL MAIN E'DIVENTATO LUNGO E INGESTIBILE
		 * JAVA CI OFFRE LA POSSIBILITÀ DI CREARE NOI
		 * DEI METODI ALL'INTERNO DELLA CLASSE
		 * QUIIINDI IL PROGRAMMA DIVENTA UNA SERIE DI ABILITÀ (METODI)
		 * CHE VENGOO RICHIAMATE DAL METODO PRINCIPALE MAIN
		 */
		
		/*
		 * QUANDO MI CONVIENE USARE QUESTA TECNICA 
		 * 1 - QUANDO IL CODICE VIENE USATO PIÙ VOLTE IN PARTI DIVERSE
		 * 1 - QUANDO LE ABILITÀ SONO TANTE DEL SOFTWARE E SCIVERLE IN MODO SEQUENZIALE ICASINA TANTISSIMO MAIN
		 * 3 - QUANDO LE ABILITÀ SONO SIMILI TRA DI LORO E CAMBIANO
		 * SOLO PER DEI VALORI VARIABILI
		 * I METODI INFATTI SONO PARAMETRIZABILI
		 */
		
		/*
		 * QUESTI METODI SONO VOID
		 * OVVERO VUOTI, NON RESTITUISCONO UN VALORE SPECIFICO
		 * MA UNA SEQUENZA DI ISTRUZIONI
		 */
		
		saluta("Nicola");
		
		saluta("Learco");
		
		saluta("Learco");
		
		saluta("Pippo");
		
		dimmieta("Nicola", 51);
		
		
		
	}//CHIUDE MAIN
	public static void dimmieta(String nome, int eta) {
		
		System.out.println("Mi chiami" + nome + " e ho " + eta);
		
	}
	public static void saluta(String nome) {
		
		//BLOCCO DI ISTRUZIONI
		System.out.println("--------");
		System.out.println("Ciao" + nome);
		System.out.println("--------");
	}

}
