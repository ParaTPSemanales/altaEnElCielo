package bandera;

public class Bandera {

	private double largo;
	private int costuras;
	private double ultimoRetazo;
	private double primerRetazo;
	
	public Bandera (double largo) {
		this.primerRetazo=largo;
		this.ultimoRetazo=largo;
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

}
