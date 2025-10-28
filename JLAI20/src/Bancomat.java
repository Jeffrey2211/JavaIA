import java.util.Scanner;
public class Bancomat {

	public static void main(String[] args) {
		
		/*
		*MACROANALISI
		*Programma per la gestione di uno sportello bancomat
		*all'apertura il programma mi chiede se voglio fare un prellievo, o un versamento o vedere la lista dei movimenti
		*il conto parte da un saldo di 300 euro.
		*Il programma non ammette prelievi maggiori di 200 euro, ne permette di andare sotto al saldo
		*Non posso versare più di 300 euro alla volta.
		*Gestisci i prelievi come valori negativi, i versamenti come positivi in un unico elenco
		*Quando il programma deve mostrare l'elenco dei movimenti li mostra in ordine crescente, dal più piccolo negativo al più grande positivo


		*PROGETTAZIONE
		*Creo un variabile double per il saldo
		*creo un array di double per i movimenti
		*I valori vanno inseriti sempre positivi, li salverà nell'array negativi se è un prelievo.
		*Quando devo mostrare i movimenti in ordine numeri crescente uso l'algoritmo del doppio for.
		*/
		Scanner input = new Scanner(System.in);

        
        double saldo = 300;// saldo iniziale
        double[] movimenti = new double[100];//array movimenti
        int index = 0;   //(Posizione) tiene traccia dei movimenti inseriti
        int scelta;

        do {
            // Menu
            System.out.println("=== MENU BANCOMAT ===");
            System.out.println("1. Prelievo");
            System.out.println("2. Versamento");
            System.out.println("3. Lista dei movimenti");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            
            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    // PRELIEVO
                    System.out.print("Inserisci importo da prelevare: ");
                    double prelievo = input.nextDouble();

                    if (prelievo <= 0) {
                        System.out.println("Errore: l'importo deve essere positivo.");
                    } else if (prelievo > 200) {
                        System.out.println("Errore: non puoi prelevare più di 200€ alla volta.");
                    } else if (prelievo > saldo) {
                        System.out.println("Errore: saldo insufficiente.");
                    } else {
                        saldo -= prelievo;
                        movimenti[index] = -prelievo; // salvo prelievo come negativo
                        index++;
                        System.out.println("Hai prelevato " + prelievo + "€. Nuovo saldo: " + saldo + "€");
                    }
                    break;

                case 2:
                    // VERSAMENTO
                    System.out.print("Inserisci importo da versare: ");
                    double versamento = input.nextDouble();

                    if (versamento <= 0) {
                        System.out.println("Errore: l'importo deve essere positivo.");
                    } else if (versamento > 300) {
                        System.out.println("Errore: non puoi versare più di 300€ alla volta.");
                    } else {
                        saldo += versamento;
                        movimenti[index] = versamento; // salvo versamento come positivo
                        index++;
                        System.out.println("Hai versato " + versamento + "€. Nuovo saldo: " + saldo + "€");
                    }
                    break;

                case 3:
                    // LISTA MOVIMENTI ORDINATA
                    System.out.println("Lista movimenti ordinata:");
                    
                    // ordinamento con doppio for
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (movimenti[i] > movimenti[j]) {
                                double appoggio = movimenti[i];
                                movimenti[i] = movimenti[j];
                                movimenti[j] = appoggio;
                            }
                        }
                    }

                    // stampa movimenti
                    for (int i = 0; i < index; i++) {
                        System.out.println(movimenti[i] + "€" + " Numero movimenti " + i);
                    }
                    break;

                case 0:
                    System.out.println("Chiusura bancomat...");
                    break;

                default:
                    System.out.println("Scelta non valida.");
                    break;
            }

        } while (scelta != 0);
	}

}
