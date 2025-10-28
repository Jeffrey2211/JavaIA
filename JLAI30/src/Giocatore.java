
public class Giocatore {
	
	//ATTRIBUTI
	public String nome;
	public String ruolo;
	private double ingaggio;
	public static String squadra = "Juventus";
	
	//COSTRUTTI
    public Giocatore(String nome, String ruolo, double ingaggio) {
		
		this.nome = nome;
		this.ruolo = ruolo;
		this.setIngaggio(ingaggio);
    }
	//GETTER AND SETTER
	public double getIngaggio() {//ACQUISISCE INGAGGIO
			return ingaggio;
	}

	public void setIngaggio(double ingaggio) {//IMPOSTARE O MODIFICARE INGAGGIO
			this.ingaggio = ingaggio;
	}
	
	//METODI
	//MOSTRA LA SQUADRA CON GIOCATORI, RUOLO E INGAGGI
	public void presentati() {
        System.out.println("Squadra: " + squadra +//RICHIAMA NOME SQUADRA
                           " | Nome: " + nome +//RICHIAMA NOME GIOCATORE
                           " | Ruolo: " + ruolo +//RICHIAMA RUOLO DEL GIOCATORE
                           " | Ingaggio: " + ingaggio + "€");//RICHIAMA INGAGGIO
    }
	
	//FILTRARE RUOLO
	public double mostraSeRuolo(String ruoloCercato) {
	    if (this.ruolo.equals(ruoloCercato)) {      //CONFRONTO RUOLO PER FILTRARLO
	        presentati();                           //STAMPA I DATI
	        return getIngaggio();                   //RESTITUISCE L'INGAGGIO
	    } else {
	        return 0;                               //SE NON CORRISPONDE RITORNA 0
	    }

}
}