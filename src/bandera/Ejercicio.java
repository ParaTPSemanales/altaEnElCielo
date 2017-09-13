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

	mostrarMatriz(matRetazos);

	sobrante=carretel.getLargo();
	cantMaxDeCosturas= Bandera.buscarCosturasMaximas (escuelas);
	System.out.println("Sobrante del carretel:"+sobrante);
	System.out.println("Cantidad de costuras Maximas:"+cantMaxDeCosturas);
	int maximo[] = new int [3];
	maximo = subsecuencia(matRetazos);
	System.out.println(maximo[0] + " " + maximo [1] + " " + maximo[2]);
}
	
public static int[] subsecuencia(int[][] matEscuelas){
	int[] maximo = new int[3];
	int valor;
	int [][] matAuxiliar = new int[matEscuelas.length + 1][matEscuelas[0].length + 1];
	
	
	for (int i = 0; i < matEscuelas.length -1; i++) {
		for (int j = i + 1; j < matEscuelas.length; j++) {
			valor = secuenciaMaxima(matEscuelas[i],matEscuelas[j], matAuxiliar);
			if(maximo[0] < valor ){
				maximo[0] = valor;
				maximo[1] = i +1;
				maximo[2] = j +1;
			}
				
		}
	}
	 
 
	
	 return maximo;
}

public static int secuenciaMaxima(int[] vec1, int[] vec2, int[][] mat){
	int i , j = 1;
	iniMat(mat);

	for ( i = 1; i <= vec2.length; i++) {
		for ( j = 1; j <= vec1.length; j++) {
			
			
			if(vec2[i-1] ==vec1[j-1])
				mat[i][j]= mat[i-1][j-1]+1;
			else
				if(mat[i-1][j] >= mat[i][j-1])
					mat[i][j]= mat[i-1][j];
				else 
					mat[i][j]= mat[i][j-1];
		}
	}
	
	return  mat[i-1][j-1];
}

public static void iniMat(int[][] mat){
	
	for (int i = 0; i < mat.length; i++) {
		for (int j = 0; j < mat[0].length; j++) {
			mat[i][j] = 0;
		}
	}
}

public static void mostrarMatriz(int[][] mat){
	
	for (int i=0;i<mat.length;i++){
		for (int a=0;a<mat[0].length;a++) {
				System.out.print(mat[i][a]+"\t");
		}
	System.out.println(" ");
} //O(N2) PARA RECORRER
	
}

}