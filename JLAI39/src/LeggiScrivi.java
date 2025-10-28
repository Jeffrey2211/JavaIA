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
	private ArrayList<Giocatori> listaGiocatori = new ArrayList<Giocatori>(); 
	
	//GETTER AND SETTER
	public ArrayList<Giocatori> getListaGiocatore() {
		return listaGiocatori;
	}


	public void setListaGiocatori(ArrayList<Giocatori> listaGiocatori) {
	    this.listaGiocatori = listaGiocatori;
	}
	
	
	//COSTRUTTORE
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
			
			
			    listaGiocatori.add(new Giocatori(Integer.parseInt(riga[0]), riga[1], riga[2], riga[3], Double.parseDouble(riga[4]), Double.parseDouble(riga[5]), Double.parseDouble(riga[6]), Boolean.parseBoolean(riga[7]))); //CREA UN ARRAY (DI STRINGHE)
			  
		}
    }
        //METODO  
		public void salvafile () throws IOException {
		             scrittore = new PrintWriter(new FileWriter(nomefile, false));
		             scrittore.println(primariga); //SOLO ALL'INIZIO
	
	                 for (int i = 0; i < listaGiocatori.size(); i++) {
		
		                  scrittore.print(listaGiocatori.get(i).id);
		                  scrittore.print(";");
		                  scrittore.print(listaGiocatori.get(i).nome);
		                  scrittore.print(";");
		                  scrittore.print(listaGiocatori.get(i).cognome);
		                  scrittore.print(";");
		                  scrittore.print(listaGiocatori.get(i).ruolo);
		                  scrittore.print(";");
		                  scrittore.print(listaGiocatori.get(i).altezza);
		                  scrittore.print(";");
		                  scrittore.print(listaGiocatori.get(i).peso);
		                  scrittore.print(";");
		                  scrittore.print(listaGiocatori.get(i).ingaggio);
		                  scrittore.print(";");
		                  scrittore.println(listaGiocatori.get(i).extracomunitario);
		
	                 }
	
    	             scrittore.close(); //SALVATAGGIO
        }
}
