package Musica;

import Strumenti.CollezioneChitarra;

public class Gospel extends MusicaSoul implements CollezioneChitarra {
	

	
	public Gospel(String titolobrano, String artista) {
		
		super(titolobrano, artista);

	}
	// Implementazione del metodo astratto dell'interfaccia
    @Override
    public void suonochitarra() {
        System.out.println("Suono la chitarra nel brano Gospel: " + titolobrano + " di " + artista);
    }
}
