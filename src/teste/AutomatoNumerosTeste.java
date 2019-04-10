/*package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoNumeros;

public class AutomatoNumerosTeste {

	@Test
	public void test() {
		AutomatoNumeros au = new AutomatoNumeros();
		
		assertFalse(au.isNumero('a'));
		assertTrue(au.isEstadoErro());
		au.resetAutomato();
		
		assertFalse(au.isNumero('*'));
		assertTrue(au.isEstadoErro());
		au.resetAutomato();

		assertFalse(au.isNumero('@'));
		assertTrue(au.isEstadoErro());
		au.resetAutomato();
		
		assertTrue(au.isNumero('4'));
		assertTrue(au.isEstadoFinal());		//Aceita 4
		
		assertTrue(au.isNumero('.'));
		assertFalse(au.isEstadoFinal());	//N�o aceita 4.
		assertTrue(au.isNumero('1'));
		assertTrue(au.isEstadoFinal());		//Aceita 4.1
		assertTrue(au.isNumero('5'));		
		assertTrue(au.isEstadoFinal());		//Aceita 4.15
		
		au.resetAutomato();
		assertFalse(au.isEstadoFinal());
		
		assertTrue(au.isNumero('-'));
		assertFalse(au.isEstadoFinal());	//N�o aceita somente -
		assertTrue(au.isNumero('2'));		
		assertTrue(au.isEstadoFinal());		//Aceita -2
		assertTrue(au.isNumero('4'));
		assertTrue(au.isEstadoFinal());		//Aceita -24
		assertTrue(au.isNumero('.'));
		assertFalse(au.isEstadoFinal()); 	//N�o aceita -24.
		assertTrue(au.isNumero('6'));
		assertTrue(au.isEstadoFinal());		//Aceita -24.6
		assertFalse(au.isNumero('.')); 		//N�o aceita outro ponto
		
		au.resetAutomato();
		
		assertFalse(au.isNumero('.'));
		
		
		
		
	}

}*/
