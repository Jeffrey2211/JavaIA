import weka.core.*;
import weka.classifiers.trees.J48;

import java.io.*;
import java.util.*;

public class Diagnosi {

    private static Scanner sc = new Scanner(System.in); // SCANNER PER INPUT DA CONSOLE
    private static Instances dataset; // OGGETTO WEKA CHE CONTERRÀ I DATI DEI PAZIENTI

    public static void main(String[] args) throws Exception {
        //CARICVA ARFF SE ESISTE, ALTRIMENTI CREA DATASET VUOTO 
        File file = new File("pazienti.arff");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            dataset = new Instances(reader);
            dataset.setClassIndex(dataset.numAttributes() - 1); //ULTIMO ATTRIBUTO = DIAGNOSI
            reader.close();
            System.out.println("Dataset caricato da pazienti.arff");
        } else {
            inizializzadataset();
            System.out.println("Dataset vuoto creato in memoria");
        }

        int scelta;
        do {
            System.out.println("\n--- Menu Principale ---");
            System.out.println("1) Gestione pazienti");
            System.out.println("2) Previsione diagnosi");
            System.out.println("3) Salva dataset");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");
            scelta = sc.nextInt();
            sc.nextLine();

            switch(scelta) {
                case 1:
                	gestionepazienti();
                	break;
                case 2:
                	predizioanediagnosi();
                	break;
                case 3:
                	salvaindataset();
                	break;
                case 0: 
                	System.out.println("Uscita...");
                	break;
                default:
                	System.out.println("Scelta non valida!");
                	break;
            }
        } while (scelta != 0);
    }

    // ---------- INIZIALIZZAZIONE DATASET ----------
    private static void inizializzadataset() {
        ArrayList<Attribute> attributi = new ArrayList<>();
        //ATTRIBUTO NOME PAZIENTE(string)
        attributi.add(new Attribute("nome", (List<String>) null));
        attributi.add(new Attribute("età"));
        attributi.add(new Attribute("frequenza cardiaca"));
        attributi.add(new Attribute("pressione sanguigna"));
        attributi.add(new Attribute("livello di glucosio"));

        //ATTRIBUTI NOMINALI SÌ/NO
        List<String> SiNo = Arrays.asList("si", "no");
        attributi.add(new Attribute("mal di testa", SiNo));
        attributi.add(new Attribute("nausea", SiNo));
        attributi.add(new Attribute("fever", SiNo));

        // DIAGNOSI FINALE (CLASSE)
        List<String> diagnosi = Arrays.asList("influenza", "ipertensione", "diabete", "nessuna");
        attributi.add(new Attribute("diagnosi", diagnosi));

        //CREAZIONE DATASET
        dataset = new Instances("Pazienti", attributi, 0);
        dataset.setClassIndex(dataset.numAttributes() - 1);
    }

    // ---------- MENÙ GESTIONE PAZIENTI ----------
    private static void gestionepazienti() {
        int scelta;
        do {
            System.out.println("\n--- Gestione Pazienti ---");
            System.out.println("1) Aggiungi paziente");
            System.out.println("2) Visualizza pazienti");
            System.out.println("3) Modifica paziente");
            System.out.println("4) Elimina paziente");
            System.out.println("0) Torna al menu principale");
            System.out.print("Scelta: ");
            scelta = sc.nextInt();
            sc.nextLine();

            switch(scelta) {
                case 1: 
                	aggiungipaziente();
                	break;
                case 2:
                	mostrapaziente();
                	break;
                case 3:
                	modificapaziente();
                	break;
                case 4:
                	cancellapaziente();
                	break;
                case 0:
                	System.out.println("Tornando al menu principale...");
                	break;
                default:
                	System.out.println("Scelta non valida!");
                	break;
            }
        } while (scelta != 0);
    }

    // ---------- CRUD PAZIENTI ----------
    private static void aggiungipaziente() {
        double[] valori = new double[dataset.numAttributes()];

        System.out.print("Nome paziente: ");
        valori[0] = dataset.attribute(0).addStringValue(sc.nextLine());

        System.out.print("Età: "); valori[1] = sc.nextDouble();
        System.out.print("Frequenza cardiaca: "); valori[2] = sc.nextDouble();
        System.out.print("Pressione sanguigna: "); valori[3] = sc.nextDouble();
        System.out.print("Livello di glucosio: "); valori[4] = sc.nextDouble();
        sc.nextLine();

        System.out.print("Mal di testa (si/no): "); valori[5] = dataset.attribute(5).indexOfValue(sc.nextLine());
        System.out.print("Nausea (si/no): "); valori[6] = dataset.attribute(6).indexOfValue(sc.nextLine());
        System.out.print("Febbre (si/no): "); valori[7] = dataset.attribute(7).indexOfValue(sc.nextLine());

        System.out.print("Diagnosi (influenza/ipertensione/diabete/nessuna): ");
        valori[8] = dataset.attribute(8).indexOfValue(sc.nextLine());

        dataset.add(new DenseInstance(1.0, valori));
        System.out.println("Paziente aggiunto!");
    }

    private static void mostrapaziente() {
        if (dataset.isEmpty()) {
            System.out.println("Nessun paziente presente.");
            return;
        }
        for (int i = 0; i < dataset.size(); i++) {
            Instance istanza = dataset.get(i);
            String nome = istanza.stringValue(0);
            System.out.println(i + ": " + nome + " -> " + istanza);
        }
    }

    private static void modificapaziente() {
    	mostrapaziente();
        System.out.print("Seleziona indice paziente da modificare: ");
        int posizione = sc.nextInt();
        sc.nextLine();
        if (posizione >= 0 && posizione < dataset.size()) {
            dataset.remove(posizione);
            System.out.println("Inserisci i nuovi dati:");
            aggiungipaziente();
        } else {
            System.out.println("Indice non valido.");
        }
    }

    private static void cancellapaziente() {
    	mostrapaziente();
        System.out.print("Seleziona indice paziente da eliminare: ");
        int posizione = sc.nextInt();
        sc.nextLine();
        if (posizione >= 0 && posizione < dataset.size()) {
            dataset.remove(posizione);
            System.out.println("Paziente eliminato.");
        } else {
            System.out.println("Indice non valido.");
        }
    }

    // ---------- PREVISIONE PAZIENTI ----------
    private static void predizioanediagnosi() throws Exception {
        if (dataset.size() < 2) {
            System.out.println("Non ci sono dati sufficienti per addestrare il modello.");
            return;
        }

        //CREAZIONE DATASET PER IL MODELLO (SENZA ATTRIBUTO NOME)
        Instances AddestramentoDati = new Instances(dataset);
        AddestramentoDati.deleteAttributeAt(0); //RIMUOVE "NOME"
        AddestramentoDati.setClassIndex(AddestramentoDati.numAttributes() - 1);

        // COSTRUZIONE ALBERO J48
        J48 Albero = new J48();
        Albero.buildClassifier(AddestramentoDati);

        double[] valori = new double[dataset.numAttributes()];

        System.out.print("Nome paziente da prevedere: ");
        String nomepaziente = sc.nextLine();
        valori[0] = dataset.attribute(0).addStringValue(nomepaziente);

        System.out.print("Età: "); valori[1] = sc.nextDouble();
        System.out.print("Frequenza cardiaca: "); valori[2] = sc.nextDouble();
        System.out.print("Pressione sanguigna: "); valori[3] = sc.nextDouble();
        System.out.print("Livello di glucosio: "); valori[4] = sc.nextDouble();
        sc.nextLine();

        System.out.print("Mal di testa (si/no): "); valori[5] = dataset.attribute(5).indexOfValue(sc.nextLine());
        System.out.print("Nausea (si/no): "); valori[6] = dataset.attribute(6).indexOfValue(sc.nextLine());
        System.out.print("Febbre (si/no): "); valori[7] = dataset.attribute(7).indexOfValue(sc.nextLine());

        // ISTANZA PER IL MODELLO (SENZA NOME)
        Instance nuovopazienteperilmodello = new DenseInstance(AddestramentoDati.numAttributes());
        for (int i = 1; i < dataset.numAttributes(); i++) {
        	nuovopazienteperilmodello.setValue(i - 1, valori[i]);
        }
        nuovopazienteperilmodello.setDataset(AddestramentoDati);
        nuovopazienteperilmodello.setClassMissing();

        //CALSSIFICAZIONE
        double resultato = Albero.classifyInstance(nuovopazienteperilmodello);
        String predetto = AddestramentoDati.classAttribute().value((int) resultato);

        System.out.println("Diagnosi prevista: " + predetto);

        // SALVATAGGIO PAZIENTE NEL DATASET
        System.out.print("Vuoi salvare questo paziente con diagnosi prevista? (si/no): ");
        String salvataggio = sc.nextLine();
        if (salvataggio.equalsIgnoreCase("si")) {
            Instance nuovopaziente = new DenseInstance(dataset.numAttributes());
            nuovopaziente.setDataset(dataset); //FONDAMENTALE!
            for (int i = 0; i < valori.length; i++) {
            	nuovopaziente.setValue(i, valori[i]);
            }
            nuovopaziente.setClassValue(predetto);
            dataset.add(nuovopaziente);
            System.out.println("Paziente salvato nel dataset!");
        }
    }

    // ---------- SALVATAGGIO DATASET ----------
    private static void salvaindataset() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("pazienti.arff"));
        writer.write(dataset.toString());
        writer.close();
        System.out.println("Dataset salvato su pazienti.arff");
    }
}
