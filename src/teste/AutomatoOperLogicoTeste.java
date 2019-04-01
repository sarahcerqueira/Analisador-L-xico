package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperLogico;

public class AutomatoOperLogicoTeste {

	@Test
	public void test() {
		
		AutomatoOperLogico aol = new AutomatoOperLogico();
		
		assertFalse(aol.isOperLogico('b')); 		//N�o aceita letra
		assertFalse(aol.isOperLogico('f'));
		assertFalse(aol.isOperLogico('w'));
		assertFalse(aol.isEstadoFinal());
		assertFalse(aol.isOperLogico('*'));			//N�o aceita simbolos que n�o s�o operadores logicos
		assertFalse(aol.isOperLogico('('));
		assertFalse(aol.isOperLogico('='));
		assertFalse(aol.isEstadoFinal());
		assertFalse(aol.isOperLogico('9'));			//N�o aceita digito
		assertFalse(aol.isOperLogico('7'));
		assertFalse(aol.isOperLogico('0'));
		assertFalse(aol.isEstadoFinal());

		
		assertTrue(aol.isOperLogico('!'));
		assertTrue(aol.isEstadoFinal());			//Aceita !
		assertFalse(aol.isOperLogico('!'));			//Estado final, n�o aceita mais nada
		
		aol.resetAutomato();
				
		assertTrue(aol.isOperLogico('&'));
		assertFalse(aol.isEstadoFinal());			//N�o aceita &
		assertFalse(aol.isOperLogico('!'));			//N�o aceita &!, reinicia
		
		assertTrue(aol.isOperLogico('&'));
		assertTrue(aol.isOperLogico('&'));	
		assertTrue(aol.isEstadoFinal());			//Aceita &&
		assertFalse(aol.isOperLogico('b'));			//N�o aceita &&b
		
		aol.resetAutomato();
		
		assertTrue(aol.isOperLogico('|'));
		assertFalse(aol.isEstadoFinal());			//N�o aceita |
		assertFalse(aol.isOperLogico('-'));			//N�o aceita |-, reinicia
		
		assertTrue(aol.isOperLogico('|'));
		assertTrue(aol.isOperLogico('|'));	
		assertTrue(aol.isEstadoFinal());			//Aceita ||
		assertFalse(aol.isOperLogico('.'));			//N�o aceita ||.
		
		
		
		
		
	}

}
