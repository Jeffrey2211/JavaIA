
public class VariabiliOggetto {

	public static void main(String[] args) {
		/*
		 * ABBIAMO DETTO CHE UNA VARIABILE OGGETTO
		 * OLTRE AD AVERE
		 * 1 NOME
		 * 2 TIPO
		 * 3 CONTENUTO
		 * ..... HA ANCHE
		 * 4 ATTRIBUTI
		 * 5 METODI
		 * 
		 * DOVE SONO ATTRIBUTI E METODI? DENTRO L'OGGETTO
		 * PER ENTRARE NELL'OGGETTO USO IL PUNTO
		 */
		
		int numero = 3;
		
		String nome = "nicola";
		
		//NOTA BENE JAVA CONTA INIZIANDO DA 0
		
		System.out.println(nome.charAt(3)); //CERCA LA VCHAR AD UNA POSIZIONE
		
		System.out.println(nome.length()); //MI DA IL VALORE DELLA LUNGHEZZA DELLA STRINGA
		
		System.out.println(nome.contains("ico"));
		
		//N.B. I METODI HANNO DEI PARAMENTRI E RESTITUISCONO DEI VALORI
		//I VALORI RESTITUITI POSSO VEDERLI USANDO L'AIUTO CTRL + SPAZIO
	}

}
