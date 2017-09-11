package bandera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) throws FileNotFoundException {
	String miPathEntrada = "Bandera.in";
	Scanner sc = new Scanner (new File(miPathEntrada));
	Carretel carretel = new Carretel(sc.nextDouble());
	Bandera [] escuelas = new Bandera [sc.nextInt()];
	for (int i = 0; i < escuelas.length; i++) {
		escuelas[i] = new Bandera(sc.nextDouble());
		escuelas[i].alargarBandera(escuelas[i].getPrimerRetazo(), carretel);
		carretel.cortarRetazo(escuelas[i].getPrimerRetazo());
	}
	
	while(carretel.getLargo()>0 && carretel.puedeCortarDelCarretel(escuelas[0].sacarDigitoUltimoRetazo()+escuelas[0].getUltimoRetazo())) {
	for (int i = 0; i < escuelas.length; i++) {
		double largoACoser=escuelas[i].sacarDigitoUltimoRetazo()+escuelas[i].getUltimoRetazo();
		if(carretel.cortarRetazo(largoACoser));
				escuelas[i].alargarBandera(largoACoser,carretel);
		}
	}
	sc.close();
	}
	
	

	

}
