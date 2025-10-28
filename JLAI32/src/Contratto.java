
public abstract class Contratto {
	//ATTRIBUTI
		public String cliente;
		private double importocontratto;
		
		//COSTRUTTORI
		public Contratto (String cliente, double importocontratto) {
			
			 this.cliente = cliente;
		     this.importocontratto = importocontratto;
			
		}

		
		//GETTER AND SETTER
		public double getImportocontratto() {
			return importocontratto;
		}

		public void setImportocontratto(double importocontratto) {
			this.importocontratto = importocontratto;
		}
			
		
		//METODI
		public abstract void presentazionecontratto();


		public abstract double calcolacostocontratto();
}
