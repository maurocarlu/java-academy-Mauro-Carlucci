package esercizio4.fumetteria;

import java.util.Arrays;

public class Fumetteria {
	private String nome;
	private String via;
	private String titolare;
	private int numeroFumettiMassimi;
	private Fumetto[] fumetti;
	
	public Fumetteria(String nome, String via, String titolare, int numeroFumettiMassimi, Fumetto[] fumetti) {
		this.nome = nome;
		this.via = via;
		this.titolare = titolare;
		this.numeroFumettiMassimi = numeroFumettiMassimi;
		this.fumetti = fumetti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

	public int getNumeroFumettiMassimi() {
		return numeroFumettiMassimi;
	}

	public void setNumeroFumettiMassimi(int numeroFumettiMassimi) {
		this.numeroFumettiMassimi = numeroFumettiMassimi;
	}

	public Fumetto[] getFumetti() {
		return fumetti;
	}

	public void setFumetti(Fumetto[] fumetti) {
		this.fumetti = fumetti;
	}

	@Override
	public String toString() {
		return "Fumetteria \n[Nome=" + nome + "\nVia=" + via + "\nTitolare=" + titolare + "\nNumeroFumettiMassimi="
				+ numeroFumettiMassimi + "]";
		
	}
	
	public void stampaDati() {
		System.out.println(this.toString());
		for(int i = 0; i < this.fumetti.length; i++) {
			System.out.println(this.fumetti[i].toString());
		}
	}
	
	
	
	
	
}
