package bandera;

public class Bandera {



	public int sacarDigitoUltimoRetazo (){
		int numero=0;
		double numParcial=this.getUltimoRetazo();
		double digito;
		while(numParcial > 0) {
			digito = numParcial %10;
			numero += (int)digito;
			numParcial /= 10;
		} //Si no me equivoco es O(n)
		return numero;
		}

	public boolean RetazosIguales(Bandera bandera2) {
		if(this.getUltimoRetazo()==bandera2.getUltimoRetazo())
				return true;
		return false;
	}
	
	public static int buscarCosturasMaximas (Bandera [] escuelas) {
		int maximo=escuelas[0].getCosturas();
		for (int i = 1; i < escuelas.length; i++) {
			if(escuelas[i].getCosturas()>maximo)
				maximo=escuelas[i].getCosturas();
		}
		return maximo;
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

public static void mostrarRetazos(int[][] mat){
	
	for (int i=0;i<mat.length;i++){
		for (int a=0;a<mat[0].length;a++) {
				System.out.print(mat[i][a]+"\t");
		}
	System.out.println(" ");
} //O(N2) PARA RECORRER
	
}


public Bandera () {
	this(0);
}

public double getLargo() {
	return largo;
}

public void setLargo(double largo) {
	this.largo = largo;
}

public int getCosturas() {
	return costuras;
}

public void setCosturas(int costuras) {
	this.costuras = costuras;
}

public void alargarBandera(double aumento, Carretel carretel) {
		this.largo += aumento;
		this.ultimoRetazo = aumento;
		if(this.getLargo() != aumento) // VER COMO MEJORAR ESTA PARTE DE CODIGO
		this.costuras++;	
} //O(1)

public double getUltimoRetazo() {
	return ultimoRetazo;
}

public double getPrimerRetazo() {
	return primerRetazo;
}

public void setPrimerRetazo(double primerRetazo) {
	this.primerRetazo = primerRetazo;
}

public Bandera (double largo) {
	this.primerRetazo=largo;
	this.ultimoRetazo=largo;
}

private double largo;
private int costuras;
private double ultimoRetazo;
private double primerRetazo;


}