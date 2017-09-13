package bandera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.*;

public class Ejercicio {

	public static void main(String[] args) throws FileNotFoundException {
	String miPathEntrada = "Bandera.in";
	Scanner sc = new Scanner (new File(miPathEntrada));
	Carretel carretel = new Carretel(sc.nextDouble());
	Bandera [] escuelas = new Bandera [sc.nextInt()]; 
	int fi=0,co=0;
	double sobrante;
	int cantMaxDeCosturas ;
	int [][] matRetazos = new int [escuelas.length][6];
	for (int i = 0; i < escuelas.length; i++) {
		escuelas[i] = new Bandera(sc.nextDouble());
		if(carretel.cortarRetazo(escuelas[i].getPrimerRetazo())) {
			escuelas[i].alargarBandera(escuelas[i].getPrimerRetazo(), carretel);
			matRetazos[i][0]=(int)escuelas[i].getPrimerRetazo();
		}

			}
	
	int j=1;
	double largoACoser;
	while(carretel.getLargo()>0 && carretel.puedeCortarDelCarretel(escuelas[0].sacarDigitoUltimoRetazo()+escuelas[0].getUltimoRetazo())) {
	for (int i = 0; i < escuelas.length; i++) {
		fi++;
		largoACoser=escuelas[i].sacarDigitoUltimoRetazo()+escuelas[i].getUltimoRetazo();
		if(carretel.cortarRetazo(largoACoser)) {
				escuelas[i].alargarBandera(largoACoser,carretel);
				matRetazos[i][j]=(int)largoACoser;
		}
	}
	j++;
	co++;
}
	
	for (int i = 0; i < escuelas.length && carretel.getLargo()>0 ; i++) {
		largoACoser=escuelas[i].sacarDigitoUltimoRetazo()+escuelas[i].getUltimoRetazo();
		if(carretel.cortarRetazo(largoACoser)) {
				escuelas[i].alargarBandera(largoACoser,carretel);
				matRetazos[i][j]=(int)largoACoser;
				}
		
	}
		
	sc.close();	

	for (int i=0;i<escuelas.length;i++){
			for (int a=0;a<6;a++) {
					System.out.print(matRetazos[i][a]+"\t");
			}
		System.out.println(" ");
	}
	
	sobrante=carretel.getLargo();
	cantMaxDeCosturas=buscarCosturasMaximas (escuelas);
	int [][] subMatriz = new int [2][cantMaxDeCosturas+1];
	int maximaSubsecuencia=0;
	subMatriz=crearSubMatrizDe2Escuelas(matRetazos,1,5,cantMaxDeCosturas+1);
	maximaSubsecuencia=contadorDeSubsecuencia (subMatriz,2,cantMaxDeCosturas+1);
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
	
	public static int [][] crearSubMatrizDe2Escuelas (int [][]mat,int escuela1,int escuela2, int co) {
		int [][]subMatriz = new int [2][co];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < co; j++) {
				subMatriz [i][j]=mat[escuela1-1][j]; 	
			}
			escuela1=escuela2;
		}
		return subMatriz;
	}
	
	public static int contadorDeSubsecuencia (int [][]mat,int fi,int co) {
		int contador=0;
		int [][]matAux = new int [co][co];
		for (int RetEsc1=0;RetEsc1<co;RetEsc1++) {
			for (int RetEsc2=0;RetEsc2<co;RetEsc2++) {
				if (mat[0][RetEsc1]==mat[1][RetEsc2])
					matAux[RetEsc1][RetEsc1]=1;
				else
					matAux[RetEsc1][RetEsc1]=0;
			}
		}
		return contador;
	}
}

