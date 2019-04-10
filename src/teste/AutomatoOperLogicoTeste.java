/*package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperLogico;

public class AutomatoOperLogicoTeste {

	@Test
	public void test() {
		
		AutomatoOperLogico aol = new AutomatoOperLogico();
		
		assertFalse(aol.isOperLogico('b')); 		//N�o aceita letra
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('f'));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('w'));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
				
		assertFalse(aol.isOperLogico('*'));			//N�o aceita simbolos que n�o s�o operadores logicos
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('('));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('='));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('9'));			//N�o aceita digito
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('7'));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('0'));
		assertFalse(aol.isEstadoFinal());
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();

		
		assertTrue(aol.isOperLogico('!'));
		assertTrue(aol.isEstadoFinal());			//Aceita !
		assertFalse(aol.isOperLogico('!'));			//Estado final, n�o aceita mais nada
		
		aol.resetAutomato();
				
		assertTrue(aol.isOperLogico('&'));
		assertFalse(aol.isEstadoFinal());			//N�o aceita &
		assertFalse(aol.isOperLogico('!'));			//N�o aceita &!, reinicia
		aol.resetAutomato();

		
		assertTrue(aol.isOperLogico('&'));
		assertTrue(aol.isOperLogico('&'));	
		assertTrue(aol.isEstadoFinal());			//Aceita &&
		assertFalse(aol.isOperLogico('b'));			//N�o aceita &&b
		
		aol.resetAutomato();
		
		assertTrue(aol.isOperLogico('|'));
		assertFalse(aol.isEstadoFinal());			//N�o aceita |
		assertFalse(aol.isOperLogico('-'));			//N�o aceita |-, reinicia
		aol.resetAutomato();

		
		assertTrue(aol.isOperLogico('|'));
		assertTrue(aol.isOperLogico('|'));	
		assertTrue(aol.isEstadoFinal());			//Aceita ||
		assertFalse(aol.isOperLogico('.'));			//N�o aceita ||.
		
		
		
		
		
	}

}*/
