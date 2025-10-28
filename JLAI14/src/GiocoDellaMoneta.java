import java.util.Scanner;

public class GiocoDellaMoneta {

	public static void main(String[] args) {
		
		/*
		 * GIOCO DELLA MONETINA
		 */
		
		/*
		 * MACROANALISI
		 * IL PRGRAMMA MI CHIEDE DI SCEGLIERE TRA TESTA O CROCE
		 * DOPO C=DI CHE MI CHIEDE DI LANCIARE UNA MONETA
		 * E MI DICE COSA È USCITO
		 * SE HO INDOVINATO MI DICE CHE HO VINTO
		 * 
		 */
		
		/*
		 * PROGETTAZIONE
		 * CREO UN MENU CON LE OPZIONI
		 * 1 TESTA 2 CORCE
		 * CON UNO SCANNER (A VUOTO) FACCIO LANCIARE UNA MONETA
		 * E DICHIARO L'USCITA
		 * CON UN IF CONTROLLO SE LA SCELTA E'UGUALE ALL'USCITA
		 * SE SI L'UTENTE HA VINTO
		 * ATTENZIONE A CHI È CHI!!!
		 * 
		 */
		
		/*
        Scanner input = new Scanner(System.in);
        		
		System.out.println("giochiamo con una moneta.....");
		System.out.println("....scegli");
		System.out.println("1 - TESTA");
		System.out.println("2 - CROCE");
		
		int scelta = input.nextInt();
		if (scelta == 1) {
			System.out.println("Hai scelto testa");
			
		} else if (scelta == 2) {
			
		System.out.println("Hai scelto croce");
		}
		
		System.out.println("Digita 1 e conferma per lanciare la moneta...");
		input.nextInt();//MI FERMO PULENDO IL TUBO
		
		int moneta = (int)(Math.random()*2 + 1);
		
		//MOTRO COSA È USCITO
		if (moneta == 1) {
			System.out.println("È uscita testa");
			
		} else if (moneta == 2) {
			
		System.out.println("È uscita croce");
		}
		
		//DICHIARO IL VINCITORE
		if (moneta == scelta) {
			System.out.println("Hai vinto!!!");
			
		} else if (moneta == scelta) {
			
		System.out.println("Hai perso");
		}
		*/
		
		/*
		 * inserisci il gioco della moneta dentro un programma ciclico (do while)
		 * che mi chiede inizialmente se voglio giocare a moneta o ai dadi
		 * se l'utente sceglie moneta fai partire questp gioco e al termine
		 * torna al menu principale (scelta dei giochi)
		 * se scegliete dadi allora parte il gioco dei dadi
		 * in questo gioco si chiede prima all'utente di tirare un dado
		 * con un random a limite 6
		 * e si mostra e conservi e mostri il valore 
		 * decreta in fine il vincitore confrontando i due valori
		 * e dichiara la fine del gioco
		 * 
		 */
		
		
		int sceltaMenu;
        Scanner input = new Scanner(System.in);

        do {
            // Menu
            System.out.println("Vuoi giocare con al gioco della moneta o dei dadi?");
            System.out.println("1 Moneta");
            System.out.println("2 Dadi");
            System.out.println("0 Esci");
            System.out.println("Scegli:");

            sceltaMenu = input.nextInt();
            input.nextLine();

            switch (sceltaMenu) {
                case 1:
                    // GIOCO DELLA MONETA
                    System.out.println("giochiamo con una moneta.....");
                    System.out.println("....scegli");
                    System.out.println("1 - TESTA");
                    System.out.println("2 - CROCE");
                    
                    //SCELTA UTENTE
                    int sceltaMoneta = input.nextInt();
                    if (sceltaMoneta == 1) {
                        System.out.println("Hai scelto testa");
                    } else if (sceltaMoneta == 2) {
                        System.out.println("Hai scelto croce");
                    }

                    int moneta = (int)(Math.random() * 2 + 1);
                    
                    //MOSTRA COSA IL LATO USCITO  
                    if (moneta == 1) {
                        System.out.println("È uscita testa");
                    } else if (moneta == 2) {
                        System.out.println("È uscita croce");
                    }
                    //MOSTRTA RISULTATO
                    if (moneta == sceltaMoneta) {
                        System.out.println("Hai vinto!!!");
                    } else {
                        System.out.println("Hai perso");
                    }
                    break;

                case 2:
                    // GIOCO DEI DADI
                    System.out.println("Giochiamo con un dado...");
                    System.out.println("Scegli un numero da 1 a 6:");
                    
                    //SCELTA UTENTE
                    int sceltaDado = input.nextInt();
                    System.out.println("Hai scelto " + sceltaDado);

                    //LACIO DEI DADIE NUMERO USCITO
                    int dado = (int)(Math.random() * 6 + 1); // numero casuale tra 1 e 6
                    System.out.println("È uscito: " + dado);
                    
                    //RISULTATO ATTESO
                    if (dado == sceltaDado) {
                        System.out.println("Hai vinto!!!");
                    } else {
                        System.out.println("Hai perso...");
                    }
                    break;
                   

                case 0:
                    System.out.println("Esci dal gioco");
                    break;
                default:
                	System.out.println("Attenzione scelta non valida");
            }

        } while (sceltaMenu != 0);{
        }
		
	}

}


