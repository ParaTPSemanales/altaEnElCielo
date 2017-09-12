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
		this.primerRetazo=0;
		this.ultimoRetazo=0;
		this.costuras=0;
		this.largo=0;
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
		if(carretel.puedeCortarDelCarretel(aumento)) {
			largo += aumento;
			ultimoRetazo = aumento;
			costuras++;
		}

	}
	
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
		double digito=this.getUltimoRetazo()%10;
		while(numParcial>=1) {
			digito=numParcial%10;
			numero=numero+(int)digito;
			numParcial=numParcial/10;
		}
		return numero;
		}

	public boolean RetazosIguales(Bandera bandera2) {
		if(this.getUltimoRetazo()==bandera2.getUltimoRetazo())
				return true;
		return false;
	}

}
