package esercizio4.fumetteria;

public class Fumetto extends Libro{

	private String nome;
	private String disegnatore;
	
	public Fumetto(String titolo, String autore, short annoPubblicazione, short costo, String editore, String nome, String disegnatore) {
		super(titolo, autore, annoPubblicazione, costo, editore);
		this.nome = nome;
		this.disegnatore = disegnatore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisegnatore() {
		return disegnatore;
	}

	public void setDisegnatore(String disegnatore) {
		this.disegnatore = disegnatore;
	}

	@Override
	public String toString() {
		return super.toString() + "Tipologia: Fumetto \nNome=" + nome + "\nDisegnatore=" + disegnatore;
	}
	
	
	
	
	
	
	
}
