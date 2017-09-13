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
			largo += aumento;
			ultimoRetazo = aumento;
			costuras++;	
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

}
