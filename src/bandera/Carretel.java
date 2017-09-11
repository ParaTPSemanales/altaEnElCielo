package bandera;

public class Carretel {

	private double largo;

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}
	
	public Carretel () {
		this.setLargo(0);
	}
	
	public Carretel (double largo) {
		this.setLargo(largo);
	}
	
}
