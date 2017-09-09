package bandera;

import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) {
	String miPath = "bandera.in";
	Scanner sc = new Scanner (miPath);
	Carretel carretel = new Carretel();
	carretel.setLargo(sc.nextInt());
	
	
	sc.close();
	}

}
