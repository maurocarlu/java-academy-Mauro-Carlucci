package esercizio1;

public class MainTest {
	
	public static void main(String[] args) {
		int[] arr = {547, 87, 1, 24, 4, 9, 54, 37, 26, 19};
		double somma = 0;
		double media = 0;
		for(int i = 0; i < arr.length; i++) {
			somma += arr[i];
		}
		media = somma/arr.length;	
		System.out.print("Media: "+media);
	}

}
