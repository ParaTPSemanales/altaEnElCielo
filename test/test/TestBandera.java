package test;

import org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import bandera.Bandera;

public class TestBandera {

	Bandera bandera;
	
	@Before
	public void setUp(){
	bandera = new Bandera(200);	
	}

	@Test
	public void EscuelaConRetazoInicial() {
	Assert.assertTrue(bandera.getPrimerRetazo()!=0);
	}
	
}