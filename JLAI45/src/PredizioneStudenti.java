import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class PredizioneStudenti {

	private static Scanner scanner = new Scanner(System.in);
	private static Instances dati = null;
	private static Classifier modello = null;
	
	public static void main(String[] args) {
		
		int scelta;
		do {
		    scelta = mostramenu();
		    faiswitch(scelta);
		} while (scelta != 0); // oppure qualsiasi valore tu usi per "Esci"


	}
	
	
	public static int mostramenu() {
	    System.out.println("\n=== MENU PRINCIPALE ===");
	    System.out.println("1. Carica file .arff");
	    System.out.println("2. Addestra modello decisionale");
	    System.out.println("3. Visualizza istanze caricate");
	    System.out.println("4. Aggiungi nuovo studente e predici tipo");
	    System.out.println("5. Visualizza struttura dell’albero decisionale");
	    System.out.println("6. Salva il file .arff");
	    System.out.println("0. Esci");
	    System.out.print("Scelta: ");
	    return scanner.nextInt();
	}


	
	public static void faiswitch(int scelta) {
	    switch (scelta) {
	        case 1:
	            caricaFile();
	            break;
	        case 2:
	            addestraModello();
	            break;
	        case 3:
	            visualizzaIstanze();
	            break;
	        case 4:
	            aggiungiStudenteEPredici();
	            break;
	        case 5:
	            visualizzaAlbero();
	            break;
	        case 6:
	            salvaDatasetSuFile();
	            break;
	        case 0:
	            System.out.println("Uscita dal programma.");
	            break;
	        default:
	            System.out.println("Scelta non valida. Riprova.");
	    }
	}




	public static void visualizzaAlbero() {
	    if (modello == null) {
	        System.out.println("❌ Modello non addestrato. Usa l'opzione 2.");
	        return;
	    }

	    System.out.println("\n=== STRUTTURA DELL'ALBERO DECISIONALE ===");
	    System.out.println(modello.toString());
	}



	public static void salvaDatasetSuFile() {
	    if (dati == null) {
	        System.out.println("❌ Nessun dato da salvare. Carica prima un file .arff.");
	        return;
	    }

	    scanner.nextLine(); // pulizia buffer
	    System.out.print("Inserisci il percorso per salvare il file .arff: ");
	    String percorso = scanner.nextLine();

	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(percorso));
	        writer.write(dati.toString());
	        writer.close();
	        System.out.println("✅ File salvato correttamente in: " + percorso);
	    } catch (IOException e) {
	        System.out.println("❌ Errore durante il salvataggio: " + e.getMessage());
	    }
	}



	public static void addestraModello() {
	    if (dati == null) {
	        System.out.println("❌ Nessun file caricato. Usa l'opzione 1 per caricare un file .arff.");
	    } else {
	        try {
	            modello = new J48(); // Crea l'albero decisionale
	            modello.buildClassifier(dati); // Addestra il modello
	            System.out.println("✅ Modello addestrato correttamente con " + dati.numInstances() + " istanze.");
	        } catch (Exception e) {
	            System.out.println("❌ Errore durante l'addestramento del modello: " + e.getMessage());
	        }
	    }
	}



	public static void aggiungiStudenteEPredici() {
	    if (dati == null || modello == null) {
	        System.out.println("❌ Dati o modello non disponibili. Carica il file e addestra il modello prima.");
	        return;
	    }

	    scanner.nextLine(); // pulizia buffer

	    try {
	        // 1. Raccolta input
	        System.out.print("Ore di studio settimanali: ");
	        double oreStudio = Double.parseDouble(scanner.nextLine());

	        System.out.print("Frequenza alle lezioni (%): ");
	        double frequenza = Double.parseDouble(scanner.nextLine());

	        System.out.print("Partecipazione (alta, media, bassa): ");
	        String partecipazione = scanner.nextLine();

	        System.out.print("Voto medio: ");
	        double votoMedio = Double.parseDouble(scanner.nextLine());

	        System.out.print("Interesse per la materia (alto, medio, basso): ");
	        String interesse = scanner.nextLine();

	        // 2. Creazione istanza vuota
	        Instance nuova = new DenseInstance(dati.numAttributes());
	        nuova.setDataset(dati);

	        // 3. Imposta valori
	        nuova.setValue(0, oreStudio);
	        nuova.setValue(1, frequenza);
	        nuova.setValue(2, partecipazione);
	        nuova.setValue(3, votoMedio);
	        nuova.setValue(4, interesse);

	        // 4. Predizione
	        double predizione = modello.classifyInstance(nuova);
	        String classePredetta = dati.classAttribute().value((int) predizione);

	        System.out.println("🔮 Tipo di studente previsto: " + classePredetta);

	        // 5. Chiedi se aggiungere
	        System.out.print("Vuoi aggiungere questo studente alle istanze? (s/n): ");
	        String risposta = scanner.nextLine();

	        if (risposta.equalsIgnoreCase("s")) {
	            nuova.setClassValue(classePredetta); // imposta la classe
	            dati.add(nuova);
	            System.out.println("✅ Studente aggiunto.");
	        } else {
	            System.out.println("ℹ️ Studente non aggiunto.");
	        }

	    } catch (Exception e) {
	        System.out.println("❌ Errore durante l'inserimento o la predizione: " + e.getMessage());
	    }
	}



	private static void caricaFile() {

		try {
	        System.out.print("Inserisci il percorso del file .arff: ");
	        scanner.nextLine(); // pulizia buffer se necessario
	        String percorso = scanner.nextLine();

	        BufferedReader reader = new BufferedReader(new FileReader(percorso));
	        //CREO IL NUOVO OGGETTO DI ISTANZA
	        dati = new Instances(reader);
	        //CHIUDEO IL READER
	        reader.close();

	        // Imposta l'attributo da predire (ultimo)
	        dati.setClassIndex(dati.numAttributes() - 1);

	        System.out.println("✅ File caricato correttamente. " + dati.numInstances() + " istanze disponibili.");
	    } catch (Exception e) {
	        System.out.println("❌ Errore durante il caricamento del file: " + e.getMessage());
	    }
		
		
		
	}



	public static void visualizzaIstanze() {
	    if (dati == null) {
	        System.out.println("❌ Nessun dato disponibile. Carica prima un file .arff.");
	        return;
	    }

	    System.out.println("\n=== ISTANZE CARICATE ===");

	    // Intestazione
	    for (int i = 0; i < dati.numAttributes(); i++) {
	        System.out.print(dati.attribute(i).name() + "\t");
	    }
	    System.out.println();

	    // Dati
	    for (int i = 0; i < dati.numInstances(); i++) {
	        Instance istanza = dati.instance(i);
	        for (int j = 0; j < dati.numAttributes(); j++) {
	            if (dati.attribute(j).isNominal()) {
	                System.out.print(istanza.stringValue(j) + "\t");
	            } else {
	                System.out.print(istanza.value(j) + "\t");
	            }
	        }
	        System.out.println();
	    }
	}




}
