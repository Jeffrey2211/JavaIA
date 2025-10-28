
public class ContrattoFornituraHardware extends Contratto {
	
	//ATTRIBUTI
	public String tipo;
	
	
    // COSTRUTTORE
    // Questo costruttore permette di creare un oggetto ContrattoImmobiliare
    // Riceve come parametri il nome del cliente e l'importo del contratto
    // Chiama il costruttore della superclasse Contratto con super()
	public ContrattoFornituraHardware(String cliente, double importo) {
	       super(cliente, importo);
	       this.tipo = "Fornitura Hardware";
	   }

	   @Override
	   public void presentazionecontratto() {
	        System.out.println("Contratto " + tipo + " - Cliente: " + cliente
	                + ", Importo: " + getImportocontratto());
	   }


	   @Override
	   public double calcolacostocontratto() {
	        // Calcola la provvigione specifica per Fornitura Hardware
	        // Provvigione fissa di 50€ più il 2% dell'importo del contratto
	       return 50 + getImportocontratto() * 0.02;
	   }

}
