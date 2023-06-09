package esercizio4.fumetteria;

public class Libro {
	private String titolo;
	private String autore;
	private short annoPubblicazione;
	private short costo;
	private String editore;
	
	public Libro(String titolo, String autore, short annoPubblicazione, short costo, String editore) {
		this.titolo = titolo;
		this.autore = autore;
		this.annoPubblicazione = annoPubblicazione;
		this.costo = costo;
		this.editore = editore;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public void setAnnoPubblicazione(short annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	public short getCosto() {
		return costo;
	}
	public void setCosto(short costo) {
		this.costo = costo;
	}
	public String getEditore() {
		return editore;
	}
	public void setEditore(String editore) {
		this.editore = editore;
	}

	@Override
	public String toString() {
		return "Libro \n[Titolo=" + titolo + "\nAutore=" + autore + "\nAnnoPubblicazione=" + annoPubblicazione
				+ "\nCosto=" + costo + "\nEditore=" + editore + "]\n";
	}
	
	
	
	
}	
