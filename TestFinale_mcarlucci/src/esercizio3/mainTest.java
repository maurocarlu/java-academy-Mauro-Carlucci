package esercizio3;

import esercizio3.implementazione.Calciatore;

public class mainTest {

	public static void main(String[] args) {
		Calciatore calciatore = new Calciatore("Mauro", "Carlucci", 2002, "Brindisi", "Juve", "ATT", 1000, 5, 12000);
		calciatore.stampaDati();
		System.out.println("Stipendio mensile: "+calciatore.calcolaStipendioMensile());
	}

}
