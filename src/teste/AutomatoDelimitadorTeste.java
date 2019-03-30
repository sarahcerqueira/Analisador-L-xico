package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoDelimitador;

public class AutomatoDelimitadorTeste {

	@Test
	public void test() {
		AutomatoDelimitador ad = new AutomatoDelimitador();
		
		//Aceita ; , ( ) [ ] { } .
		assertTrue(ad.isdelimitado(';'));	
		assertFalse(ad.isdelimitado(';')); //Estado final
		assertTrue(ad.isEstadoFinal());
		
		
		
	}

}
