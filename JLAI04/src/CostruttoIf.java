
public class CostruttoIf {

	public static void main(String[] args) {
		/*
		 * IL PRIMO COSTRUTTO CHE VEDIAMO 
		 * E'IL COSTRUTTO DECISIONALE IF (SE)
		 * MI PERMETTE DI CREARE DELLE STRADE ALTERNATIVE
		 * NEL FLUSSO DEL MIO PROGRAMMA
		 * ATTRAVERSO DEI CONFRONTI
		 * 
		 * PER CONFORNTARE JAVA MI FORNISCE GLI OPERATORI DI CONFRONTO
		 * 
		 * == CONFORNTA SE DUE VALORI SONO UGUALI
		 * > MAGGIORE
		 * < MINORE
		 * >=
		 * <=
		 * != DIVERSO
		 * 
		 * NB. IL PUNTO ESCAMATIVO ! VIENE CHIAMATO OPERATORE DI NEGAZIONE
		 * QUANDO VIENE POSTO DAVANTI AD UN OPERATORE LO NEGA
		 */
		
		/*
		 * COME SI PRESENTA UN COSTRUTTO?
		 * TUTTI I COSTRUTTI SONO FATTI IN QUESTO MODO
		 * 1 PAROLA RISERVATA
		 * 2 PARENTESI TONDA PER UN CONFRONTO
		 * 3 PARENTESI GRAFFA PER SCRIVERE LE ISTRUZIONI
		 * 
		 * NEL COSTRUTTO IF LE ISTRUZIONI IN GRAFFA VEGONO ESEGUITE SOLO SE IL CONFRONTO IN TONDA
		 * DA ESITO POSITIVO (TRUE)
		 */
		int numero = 3;
		
		if (numero > 1) {
			System.out.println("Ciao");
		}
		
		if (numero < 1) {
			System.out.println("Ciao");
		}
		
		if (numero != 1) {//IL CONFRONTO TRA LE TONDE E'SEMPRE UN BOOLEANO
			System.out.println("Ciao");
		}
		
		//IL COSTRUTTO IF E' UN COSTRUTTO AD ENTRATA MULTIPLA
		//MA A SINGOLA USCITA
		/*
		 * POSSO FARE DIVERSI CONTROLLI
		 * MA SE TROVO UNA USCITA (CONTROLLO VERO)
		 * TUTTI GLI ALTRI VENGONO SALTATI
	    */
				
		
        int anni = 50;
		
		if (anni >= 50) {
			System.out.println("Ti sei fatto grande");
		} else if (anni >= 40) {
			System.out.println("E' ora che ti fai una famiglia");
		} else if (anni >= 30) {
			System.out.println("Hai ancora la testa al gioco");
		} else if (anni >= 20 ) {
			System.out.println("Sei un uomo ormai");
		} else { //ELSE SENZA IF VUOL DIRE IN TUTTI GLI ALTRI CASI
					//NON E' OBBLIGATORIO METTERLO
			
			System.out.println("Sei ancora un ragazzino");
		}
		
		
	}

}
