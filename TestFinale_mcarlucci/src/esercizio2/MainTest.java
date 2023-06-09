package esercizio2;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		int vEsame = 0;
		int numEsami = 0;
		double sommaVoti = 0;
		double media = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				System.out.print("Inserisci un voto oppure -1 per terminare l'inserimento: ");
				vEsame = scanner.nextInt();
				if(vEsame != -1) {
					if(vEsame < 18 || vEsame > 30) {
						System.out.println("valore inserito non corretto!");
					} else {
						sommaVoti += vEsame;
						numEsami++;
					}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Inserisci un numero!");
				scanner.next(); //Evito il loop quando non viene inserito un numero.
			}
		}while(vEsame != -1);
		scanner.close();
		if(numEsami != 0) {	//Evito di stampare a video NaN (quando il denominatore è 0)
			media = sommaVoti/numEsami;
			System.out.println("Media dei voti: "+media);
		} else {
			System.out.println("Non sono stati inseriti voti dunque non calcolo la media.");
		}
		

	}

}
