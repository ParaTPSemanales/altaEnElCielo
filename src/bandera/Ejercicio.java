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
	double sobrante;
	int cantMaxDeCosturas ;
	int [][] matRetazos = new int [escuelas.length][5];
	for (int i = 0; i < escuelas.length; i++) {
		escuelas[i] = new Bandera(sc.nextDouble());
		escuelas[i].alargarBandera(escuelas[i].getPrimerRetazo(), carretel);
		carretel.cortarRetazo(escuelas[i].getPrimerRetazo());
	}
	
	int j=0;
	while(carretel.getLargo()>0 && carretel.puedeCortarDelCarretel(escuelas[0].sacarDigitoUltimoRetazo()+escuelas[0].getUltimoRetazo())) {
	for (int i = 0; i < escuelas.length; i++) {
		double largoACoser=escuelas[i].sacarDigitoUltimoRetazo()+escuelas[i].getUltimoRetazo();
		if(carretel.cortarRetazo(largoACoser))
				escuelas[i].alargarBandera(largoACoser,carretel);
				matRetazos[i][j]=(int)escuelas[i].sacarDigitoUltimoRetazo();
		}
	j++;
	}
	sc.close();	

	for (int i=0;i<escuelas.length;i++){
			for (int a=0;a<4;a++) {
					System.out.print(matRetazos[i][a]+"\t");
			}
		System.out.println(" ");
	}

	sobrante=carretel.getLargo();
	cantMaxDeCosturas=buscarCosturasMaximas (escuelas);
	System.out.println("Sobrante del carretel:"+sobrante);
	System.out.println("Cantidad de costuras Maximas:"+cantMaxDeCosturas);
}
	
	public static int buscarCosturasMaximas (Bandera [] escuelas) {
		int maximo=escuelas[0].getCosturas();
		for (int i = 1; i < escuelas.length; i++) {
			if(escuelas[i].getCosturas()>maximo)
				maximo=escuelas[i].getCosturas();
		}
		return maximo;
	}

}
