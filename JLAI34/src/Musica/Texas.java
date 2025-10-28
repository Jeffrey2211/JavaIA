package Musica;

import Strumenti.CollezioneChitarra;

public class Texas extends MusicaBlues implements CollezioneChitarra{
	
	//COSTRUTTORE
	public Texas(String titolobrano, String artista) {
		
		super(titolobrano, artista);

	}
	// Implementazione del metodo astratto dell'interfaccia
    @Override
    public void suonochitarra() {
        System.out.println("Suono la chitarra nel brano Texas: " + titolobrano + " di " + artista);
    }

}
