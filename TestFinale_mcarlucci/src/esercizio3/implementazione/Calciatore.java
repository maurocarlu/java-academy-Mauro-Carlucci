package esercizio3.implementazione;
import esercizio3.interfaccia.GiocatoreProfessionista;

public class Calciatore implements GiocatoreProfessionista {
	private String cognome;
	private String nome;
	private int annoNascita;
	private String luogoNascita;
	private String squadra;
	private String ruolo;
	private double costoCartellino;
	private int anniContratto;
	private double stipendioAnnuo;
	
	public Calciatore(String cognome, String nome, int annoNascita, String luogoNascita, String squadra, String ruolo,
			double costoCartellino, int anniContratto, double stipendioAnnuo) {
		this.cognome = cognome;
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.luogoNascita = luogoNascita;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.costoCartellino = costoCartellino;
		this.anniContratto = anniContratto;
		this.stipendioAnnuo = stipendioAnnuo;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public double getCostoCartellino() {
		return costoCartellino;
	}

	public void setCostoCartellino(double costoCartellino) {
		this.costoCartellino = costoCartellino;
	}

	public int getAnniContratto() {
		return anniContratto;
	}

	public void setAnniContratto(int anniContratto) {
		this.anniContratto = anniContratto;
	}

	public double getStipendioAnnuo() {
		return stipendioAnnuo;
	}

	public void setStipendioAnnuo(double stipendioAnnuo) {
		this.stipendioAnnuo = stipendioAnnuo;
	}
	
	@Override
	public String toString() {
		return "Calciatore \nCognome= " + cognome + "\nNome= " + nome + "\nAnnoNascita= " + annoNascita + "\nLuogoNascita= "
				+ luogoNascita + "\nSquadra= " + squadra + "\nRuolo=" + ruolo + "\nCostoCartellino= " + costoCartellino
				+ "\nAnniContratto= " + anniContratto + "\nStipendioAnnuo= " + stipendioAnnuo + "";
	}

	public void stampaDati() {
		System.out.println(this.toString());
	}
	
	public double calcolaStipendioMensile() {
		return this.stipendioAnnuo / 12;  //StipendioAnnuo / numero di mesi in un anno
	}
	
	
	
}
