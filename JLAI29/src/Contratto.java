
public class Contratto {
	
	//ATTRIBUTI
	public String cliente;
	public String tipo;
	private double importo;
	private double tassa = 5;
	
	//COSTRUTTORI
	public Contratto(String cliente, String tipo, double importo) {
		
		this.cliente = cliente;
		this.tipo = tipo;
		this.importo = importo;
		
	}


	
	//GETTER AND SETTER
	
	//METODI
	public void mostracontratto() {
		
		System.out.println("Contratto per il cliente: " + cliente);
		System.out.println("Tipo: " + tipo + " - Importo tassato: " + (importo + tassa));
		System.out.println("--------------------");
		
		
	}



	public double mostracontratto(String tipo) {
		
		if (this.tipo.equals(tipo)) {
		System.out.println("Contratto per il cliente: " + cliente);
		System.out.println("Tipo: " + tipo + " - Importo tassato: " + (importo + tassa));
		System.out.println("--------------------");
		return (importo+tassa);
		} else {
		return 0;
		}
	}
	
	public double importotassato() {
		
		return (importo+tassa);
	}

}
