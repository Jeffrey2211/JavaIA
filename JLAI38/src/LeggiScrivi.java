import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LeggiScrivi {
	
	//ATTRIBUTI
	public String nomefile;
	public BufferedReader lettore;
	public String linea;
	public String primariga;
	public String[] riga;
	public PrintWriter scrittore;
	private ArrayList<Dipendente> ListaDipendenti = new ArrayList<Dipendente>(); 
	
	
	//COSTRUTTORe che legge il file
	public LeggiScrivi(String nomefile) throws NumberFormatException, IOException {
		
		this.nomefile = nomefile;
		
		lettore = new BufferedReader(new FileReader(nomefile));
		primariga = lettore.readLine(); // VUOTO PER SALTARE LA PRIMA RIGA
		while ((linea = lettore.readLine()) != null) { //FINO A QUANDO NON TRO LINEE NULLE
			
			riga = linea.split(";");
			
			/*
			 * tip
			 * PER POTER CONVERTIRE DEI VALORI TRA LE VARIABILI PRIMITIVE
			 * JAVA HA CREATO UNA CLASSE PER OGNI VARIABILE PRIMITIVA
			 * CHE TRA I METODI HA IL PARSE DI CONVERSIONE
			 * 
			 * int -> Integer
			 * double -> Double
			 * boolean -> Boolean
			 * 
			 */
			
			
			ListaDipendenti.add(new Dipendente(Integer.parseInt(riga[0]), riga[1], riga[2], riga[3], Double.parseDouble(riga[4]))); //CREA UN ARRAY (DI STRINGHE)
			
		}
		
		
	}

	
	//GETTER AND SETTER

	public ArrayList<Dipendente> getListaDipendenti() {
		return ListaDipendenti;
	}


	public void setListaDipendenti(ArrayList<Dipendente> listaDipendenti) {
		ListaDipendenti = listaDipendenti;
	}
	
	
	
	//METODo che scrive il file
	public void salvafile () throws IOException {
		
		scrittore = new PrintWriter(new FileWriter(nomefile, false));
		
		scrittore.println(primariga); //SOLO ALL'INIZIO
		
		for (int i = 0; i < ListaDipendenti.size(); i++) {
			
			scrittore.print(ListaDipendenti.get(i).id);
			scrittore.print(";");
			scrittore.print(ListaDipendenti.get(i).nome);
			scrittore.print(";");
			scrittore.print(ListaDipendenti.get(i).cognome);
			scrittore.print(";");
			scrittore.print(ListaDipendenti.get(i).mansione);
			scrittore.print(";");
			scrittore.println(ListaDipendenti.get(i).stipendio);
			
			//OGNI ELEMENTO LO METTO IN UNA ARRAY
			//String[] riga = ListaDipendenti.get(i);
			//SCRIVO NEL FILE SEPARANDO I VALORI DELL'ARRAY RIGA CON UN COMMA ;
			//scrittore.println(String.join(";", riga));
			 //MI PORTO SULLA NUOVA RIGA PER SCRIVERE LA PROSSIMA
			
		}
		
		scrittore.close(); //SALVATAGGIO
		
	}

}
