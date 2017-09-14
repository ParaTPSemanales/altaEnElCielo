package bandera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) throws FileNotFoundException {
	String miPathEntrada = "Bandera.in";
	Scanner sc = new Scanner (new File(miPathEntrada));
	Carretel carretel = new Carretel(sc.nextDouble());
	Bandera [] escuelas = new Bandera [sc.nextInt()]; 
	double sobrante;
	int cantMaxDeCosturas ;
	boolean sigueCortando = true;
	int [][] matRetazos = new int [escuelas.length][6];//VER DE SACAR EL 6 POR ALGO MAS ROBUSTO.
	//Insercion de los primeros retazos
	for (int i = 0; i < escuelas.length; i++) {
		escuelas[i] = new Bandera(sc.nextDouble());
		if(carretel.cortarRetazo(escuelas[i].getPrimerRetazo())) {
			escuelas[i].alargarBandera(escuelas[i].getPrimerRetazo(), carretel);
			matRetazos[i][0]=(int)escuelas[i].getPrimerRetazo();
		}

			}//O(n)
	
	int j=1;
	double largoACoser;
	
	while(sigueCortando) {
		sigueCortando = false;
	for (int i = 0; i < escuelas.length; i++) {
		largoACoser=escuelas[i].sacarDigitoUltimoRetazo()+escuelas[i].getUltimoRetazo();
		if(carretel.cortarRetazo(largoACoser)) {
				escuelas[i].alargarBandera(largoACoser,carretel);
				matRetazos[i][j]=(int)largoACoser;
				if(!sigueCortando) sigueCortando = true;
		}
	}
	j++;
}
		
	sc.close();	

	Bandera.mostrarRetazos(matRetazos);

	sobrante=carretel.getLargo();
	cantMaxDeCosturas= Bandera.buscarCosturasMaximas (escuelas);
	System.out.println("Sobrante del carretel:"+sobrante);
	System.out.println("Cantidad de costuras Maximas:"+cantMaxDeCosturas);
	int maximo[] = new int [3];
	maximo = Bandera.subsecuencia(matRetazos);
	System.out.println(maximo[0] + " " + maximo [1] + " " + maximo[2]);
}
	


}