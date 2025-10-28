import java.util.Scanner;

public class PompaDiBenzina {
	public static Scanner input = new Scanner(System.in);
    // litri disponibili
	public static double litriSerbatoioVerde = 500.0;
	public static double litriSerbatoioDiesel = 500.0;

    // Erogazioni verde
	public static double[] erogazioneVerdePrezzo = new double[100];
	public static double[] erogazioneVerdeLitri = new double[100];

    // Erogazioni diesel
	public static double[] erogazioneDieselPrezzo = new double[100];
	public static double[] erogazioneDieselLitri = new double[100];

    // Carichi serbatoi
	public static double[] caricoLitriVerde = new double[50];
	public static double[] caricoLitriDiesel = new double[50];

    // contatori separati
	public static int posErogazioniVerde = 0;
	public static int posErogazioniDiesel = 0;
	public static int posCarichiVerde = 0;
	public static int posCarichiDiesel = 0;
	
    

    public static void main(String[] args) {

        /*
         * MACROANALISI
         * Il programma gestisce una pompa di benzina
         * il menu principale mi da la possibilità di
         * 1 Erogazione, 2 Carico, 3 Amministrazione, 0 Uscita
         * 
         * PROGETTAZIONE
         * Array erogazioniVerdePrezzo/erogazioniVerdeLitri
         * Array erogazioniDieselPrezzo/erogazioniDieselLitri
         * Array caricoLitriVerde / caricoLitriDiesel
         */




        int scelta;
        do {
             scelta = mostramenu();
             
             faiswitch(scelta);



        } while (scelta != 0);

    }


     public static int mostramenu() {
    	 
    	 System.out.println("===== MENU' PRINCIPALE =====");
         System.out.println("1 Erogazione");
         System.out.println("2 Carico");
         System.out.println("3 Amministrazione");
         System.out.println("0 Esci");
         System.out.println("Inserisci scelta: ");
         
         return input.nextInt();
     }

     public static void faiswitch(int scelta) {
         switch (scelta) {

         // --- MENU EROGAZIONE ---
         case 1:
             int sceltaErogazione;
             do {
             	
             	sceltaErogazione = mostramenuerogazione();

             	faiswitcherogazione(sceltaErogazione);
             	
             } while (sceltaErogazione != 0);
             break;

         // --- MENU CARICO ---
         case 2:
             int sceltaCarico;
             do {
             	
                 sceltaCarico = mostramenucarico();

                 faiswitchcarico(sceltaCarico);
                 
             } while (sceltaCarico != 0);
             break;

         // --- MENU AMMINISTRAZIONE ---
         case 3:
             int sceltaAmministrazione;
             do {

                 
                 sceltaAmministrazione = mostramenuamministratore();

                 faiswitchamministratore(sceltaAmministrazione);
                 
             } while (sceltaAmministrazione != 0);
             break;

         case 0:
             System.out.println("Arrivederci! Ti auguro una buona giornata!");
             break;

         default:
             System.out.println("Scelta non valida!");
             break;
     }
     }
    public static int mostramenuerogazione() {
    	System.out.println("===== MENU' EROGAZIONE =====");
        System.out.println("1 Verde");
        System.out.println("2 Diesel");
        System.out.println("0 Torna al principale");
        System.out.print("Inserisci scelta: ");
    
        return input.nextInt();
    }

    public static void faiswitcherogazione(int sceltaErogazione) {
    	
    	switch (sceltaErogazione) {
        case 1: // Verde
            System.out.print("Inserisci importo da erogare (in €): ");
            double importoVerde = input.nextDouble();
            double prezzoLitroVerde = 1.8;
            double litriVerde = importoVerde / prezzoLitroVerde;

            if (litriVerde <= litriSerbatoioVerde) {
                erogazioneVerdePrezzo[posErogazioniVerde] = importoVerde;
                erogazioneVerdeLitri[posErogazioniVerde] = litriVerde;
                posErogazioniVerde++;

                litriSerbatoioVerde -= litriVerde;
                System.out.println("Hai erogato " + litriVerde + " litri di Verde.");
                System.out.println("Litri residui serbatoio Verde: " + litriSerbatoioVerde);
            } else {
                System.out.println("Litri insufficienti nel serbatoio! Disponibili: " + litriSerbatoioVerde);
            }
            break;

        case 2: // Diesel
            System.out.print("Inserisci importo da erogare (in €): ");
            double importoDiesel = input.nextDouble();
            double prezzoLitroDiesel = 1.6;
            double litriDiesel = importoDiesel / prezzoLitroDiesel;

            if (litriDiesel <= litriSerbatoioDiesel) {
                erogazioneDieselPrezzo[posErogazioniDiesel] = importoDiesel;
                erogazioneDieselLitri[posErogazioniDiesel] = litriDiesel;
                posErogazioniDiesel++;

                litriSerbatoioDiesel -= litriDiesel;
                System.out.println("Hai erogato " + litriDiesel + " litri di Diesel.");
                System.out.println("Litri residui serbatoio Diesel: " + litriSerbatoioDiesel);
            } else {
                System.out.println("Litri insufficienti nel serbatoio! Disponibili: " + litriSerbatoioDiesel);
            }
            break;

        case 0:
            System.out.println("Torna al menu principale.");
            break;
        default:
            System.out.println("Scelta non valida!");
            break;
    }
    }
    public static int mostramenucarico() {
    	System.out.println("===== MENU' CARICO =====");
        System.out.println("1 Carica Verde");
        System.out.println("2 Carica Diesel");
        System.out.println("0 Torna al principale");
        System.out.println("Inserisci scelta: ");
    
    
    return input.nextInt();
    }
    public static void faiswitchcarico(int sceltaCarico) {
    	
    	switch (sceltaCarico) {
        case 1: // Carico Verde
            System.out.println("Inserisci litri da caricare: ");
            double caricoVerde = input.nextDouble();
            litriSerbatoioVerde += caricoVerde;
            caricoLitriVerde[posCarichiVerde] = caricoVerde;
            posCarichiVerde++;

            System.out.println("Hai caricato " + caricoVerde + " litri di Verde.");
            System.out.println("Litri totali nel serbatoio Verde: " + litriSerbatoioVerde);
            break;

        case 2: // Carico Diesel
            System.out.println("Inserisci litri da caricare: ");
            double caricoDiesel = input.nextDouble();
            litriSerbatoioDiesel += caricoDiesel;
            caricoLitriDiesel[posCarichiDiesel] = caricoDiesel;
            posCarichiDiesel++;

            System.out.println("Hai caricato " + caricoDiesel + " litri di Diesel.");
            System.out.println("Litri totali nel serbatoio Diesel: " + litriSerbatoioDiesel);
            break;

        case 0:
            System.out.println("Torna al menu principale.");
            break;
        default:
            System.out.println("Scelta non valida!");
            break;
    }
    }

     public static int mostramenuamministratore() {
    	 System.out.println("===== MENU' AMMINISTRAZIONE =====");
         System.out.println("1 Elenco erogazioni e carico Verde - con saldo dei litri");
         System.out.println("2 Elenco erogazioni e carico Diesel - con saldo dei litri");
         System.out.println("3 Totale Entrate");
         System.out.println("0 Torna al principale");
         System.out.println("Inserisci scelta: ");
    
         return input.nextInt();
    }
     
     public static void faiswitchamministratore(int sceltaAmministrazione) {
    	 
    	 switch (sceltaAmministrazione) {
         case 1:
             System.out.println("=== ELENCO EROGAZIONI VERDE ===");
             for (int i = 0; i < posErogazioniVerde; i++) {
                 System.out.println("Erogati: " + erogazioneVerdeLitri[i] + " litri - "
                         + erogazioneVerdePrezzo[i] + " €");
             }
             System.out.println("=== ELENCO CARICHI VERDE ===");
             for (int i = 0; i < posCarichiVerde; i++) {
                 System.out.println("Caricati: " + caricoLitriVerde[i] + " litri");
             }
             System.out.println("Litri residui serbatoio Verde: " + litriSerbatoioVerde);
             break;

         case 2:
             System.out.println("=== ELENCO EROGAZIONI DIESEL ===");
             for (int i = 0; i < posErogazioniDiesel; i++) {
                 System.out.println("Erogati: " + erogazioneDieselLitri[i] + " litri - "
                         + erogazioneDieselPrezzo[i] + " €");
             }
             System.out.println("=== ELENCO CARICHI DIESEL ===");
             for (int i = 0; i < posCarichiDiesel; i++) {
                 System.out.println("Caricati: " + caricoLitriDiesel[i] + " litri");
             }
             System.out.println("Litri residui serbatoio Diesel: " + litriSerbatoioDiesel);
             break;

         case 3:
             System.out.println("=== TOTALE ENTRATE ===");
             double totaleVerde = 0, totaleDiesel = 0;
             for (int i = 0; i < posErogazioniVerde; i++) {
                 totaleVerde += erogazioneVerdePrezzo[i];
             }
             for (int i = 0; i < posErogazioniDiesel; i++) {
                 totaleDiesel += erogazioneDieselPrezzo[i];
             }
             System.out.println("Totale entrate Verde: " + totaleVerde + " €");
             System.out.println("Totale entrate Diesel: " + totaleDiesel + " €");
             System.out.println("Totale complessivo: " + (totaleVerde + totaleDiesel) + " €");
             break;

         case 0:
             break;
         default:
             System.out.println("Scelta non valida!");
             break;
     }
     }
}


