
public class ClasseAndOr {

	public static void main(String[] args) {
	/*
	 * IF QUINDI FA UN CONFRONTO E PRENDE UNA DECISIONE
	 * MA SPESSO PER PRENDERE UNA SINGOLA DECISIONE BISOGNA FARE PIÙ CONFRONTI
	 * E IN CHE IN CHE RELAZIONE DEVONO ESSERE TRA LORO QUESTI CONFRONTI?
	 * 
	 * POSSONO ESSERE IN
	 * AND LOGICO - PER AVERE VERO FINALE, TUTTI DEVONO AVERE ESITO POSITIVO
	 * OR LOGICO - PER AVERE VERO FINALE, BASTA CHE ANCHE UNO SOLO SIA POSITIVO
	 */
		
		/*
		 * COLLOQUI - AND LOGICO
		 * 
		 */
		
		boolean laureato = true;
		boolean automunito = true;
		boolean inglese = true;
		
		if (laureato == true && automunito == true && inglese == true) {
			System.out.println("Sei assunto");
		} else {
			System.out.println("Le faremo sapere");
		}
		
		/*
		 * CINEMA - L'OR LOGICO
		 */
		
		boolean pensionato = false;
		boolean studente = false;
		boolean socio = true;
		
		if (laureato == true || automunito == true || inglese == true) {
			System.out.println("Biglietto ridotto");
		} else {
			System.out.println("Biglietto intero");
		}

	}

}
