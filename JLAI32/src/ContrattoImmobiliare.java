public class ContrattoImmobiliare extends Contratto {
	
	//ATTRIBUTI
	public String tipo;

    // COSTRUTTORE
    // Questo costruttore permette di creare un oggetto ContrattoImmobiliare
    // Riceve come parametri il nome del cliente e l'importo del contratto
    // Chiama il costruttore della superclasse Contratto con super()
    public ContrattoImmobiliare(String cliente, double importo) {
        super(cliente, importo); //chiama il costruttore della superclasse
        this.tipo = "Immobiliare";
    }

    // METODI 
    @Override
    public void presentazionecontratto() {
        System.out.println("Contratto " + tipo + " - Cliente: " + cliente
                + ", Importo: " + getImportocontratto());
    }


    @Override
    public double calcolacostocontratto() {
        //Calcola la provvigione specifica per questo tipo di contratto
        //Per Immobiliare la provvigione è il 5% dell'importo
        return getImportocontratto() * 0.05;
    }
}
