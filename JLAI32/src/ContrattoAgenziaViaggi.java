public class ContrattoAgenziaViaggi extends Contratto {
	
	//ATTRIBUTI
	public String tipo;

    // COSTRUTTORE
    // Questo costruttore permette di creare un oggetto ContrattoImmobiliare
    // Riceve come parametri il nome del cliente e l'importo del contratto
    // Chiama il costruttore della superclasse Contratto con super()
    public ContrattoAgenziaViaggi(String cliente, double importo) {
        super(cliente, importo);
        this.tipo = "Agenzia Viaggi";
    }

    // METODI 
    @Override
    public void presentazionecontratto() {
        System.out.println("Contratto " + tipo + " - Cliente: " + cliente
                + ", Importo: " + getImportocontratto());
    }

    @Override
    public double calcolacostocontratto() {       
    	//Calcola la provvigione specifica per Agenzia Viaggi
    	//Provvigione del 10% dell'importo
        return getImportocontratto() * 0.10;
    }
}
