
public class NumeriRandom {

	public static void main(String[] args) {
		
		/*
		 * JAVA IN MODO NATIVO, CREA NUMERI RANDOMICI IN 1 SOLO MODO
		 * OVVERO TRAMITE LA FUNZIONE RANDOM INSERITA NELLA CLASSE MATH
		 * 
		 * 
		 * QUESTA FUNZIONE GENERA UN NUUMERO DOUBLECOMPRESO TRA 0.1 E 0.9
		 * E TUTTI GLI ALTRI??
		 * MI AIUTA LA MATEMATICA
		 * 
		 */
		
		double numerocasuale = Math.random();
		System.out.println(numerocasuale);
		
		//SE VOGLIO AUMENTARE IL LIMITE LA MATEMATICA CI DICE 
		//CHE POSSIAMO MOLTIPLICARE PER IL NUMERO DI TENDENZA AL LIMITE
		
		double numerocasuale1 = Math.random()*10;
		System.out.println(numerocasuale);
		
		//SE MI SERVE SOLO MLA PARTE INTERA
		//POSSO FARE UN CASTING (TAGLIO)
		int numerocasualeintero = (int)(Math.random()*10);
		System.out.println(numerocasualeintero);
		
		//PER ESCLUDERE LO ZERO E IL INCLUDRE IL LIMITE
		int numerocasualezero = (int)(Math.random()*10 + 1);
		System.out.println(numerocasualezero);
		
		//PER LANCIARE UN DADO
		int dado = (int)(Math.random()*6 + 1);
		System.out.println(dado);
		
		//PER LANCIARE UNA MONETA
		int moneta = (int)(Math.random()*2 + 1);
		System.out.println(moneta);
		
		//PER PESCARE UAN CARTA
		int carta = (int)(Math.random()*40 + 1);
		System.out.println(carta);
		
	}

}
