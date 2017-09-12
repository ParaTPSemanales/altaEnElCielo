package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import bandera.Bandera;
import bandera.Carretel;

public class TestBandera {

	Bandera bandera;
	Bandera bandera2;
	Carretel carretel;
	
	@Before
	public void setUp(){
	bandera = new Bandera(200);	
	bandera2 = new Bandera(200);	
	carretel = new Carretel(600);
	}

	@Test
	public void EscuelaConRetazoInicial() {
	Assert.assertTrue(bandera.getPrimerRetazo()!=0);
	}
	
	@Test 
	public void CarretelConLargoInicial() {
		Assert.assertTrue(carretel.getLargo()!=0);
	}

	@Test
	public void cortarRetazoDeCarretel() {
		double largoCarretel = carretel.getLargo();
		largoCarretel = largoCarretel - bandera.getPrimerRetazo();
		carretel.cortarRetazo(bandera.getPrimerRetazo());
		Assert.assertEquals(largoCarretel, carretel.getLargo(),0.1);
	}
	
	@Test
	public void puedeCortar () {
		Assert.assertTrue(carretel.puedeCortarDelCarretel(bandera.getPrimerRetazo()));
	}
	
	@Test
	public void agregarRetazoABandera(){
		double largoBandera = bandera.getLargo();
		largoBandera+=bandera.getUltimoRetazo();
		bandera.alargarBandera(bandera.getUltimoRetazo(),carretel);
		Assert.assertEquals(largoBandera,bandera.getLargo(),0.1);
	}
	
	@Test
	public void SonRetazosIguales() {
	 Assert.assertTrue(bandera.RetazosIguales(bandera2));
	}
}