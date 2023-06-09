package esercizio4.main.test;

import esercizio4.fumetteria.Fumetteria;
import esercizio4.fumetteria.Fumetto;

public class MainTest {

	public static void main(String[] args) {
		Fumetto fumetto1 = new Fumetto("Slam Dunk", "Inoue", (short) 1995, (short) 7, "Panini", "Finale", "Asano");
		Fumetto fumetto2 = new Fumetto("One Piece", "Oda", (short) 1990, (short) 5, "Starcomics", "Omnibus", "Oda");
		Fumetto fumetto3 = new Fumetto("Prova", "Mario", (short) 2005, (short) 15, "Jpop", "Italiano", "Rossi");
		Fumetto fumetti[] = {fumetto1, fumetto2,fumetto3};
		Fumetteria fumetteria = new Fumetteria("FumettiBR", "Via Roma", "Giuseppe Verdi", 1000, fumetti);
		fumetteria.stampaDati();

	}

}
