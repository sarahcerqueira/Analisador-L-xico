package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperLogico;

public class AutomatoOperLogicoTeste {

	@Test
	public void test() {
		
		AutomatoOperLogico aol = new AutomatoOperLogico();
		
		assertFalse(aol.isOperLogico('b')); 		//Não aceita letra
		assertFalse(aol.isOperLogico('f'));
		assertFalse(aol.isOperLogico('w'));
		assertFalse(aol.isEstadoFinal());
		assertFalse(aol.isOperLogico('*'));			//Não aceita simbolos que não são operadores logicos
		assertFalse(aol.isOperLogico('('));
		assertFalse(aol.isOperLogico('='));
		assertFalse(aol.isEstadoFinal());
		assertFalse(aol.isOperLogico('9'));			//Não aceita digito
		assertFalse(aol.isOperLogico('7'));
		assertFalse(aol.isOperLogico('0'));
		assertFalse(aol.isEstadoFinal());

		
		assertTrue(aol.isOperLogico('!'));
		assertTrue(aol.isEstadoFinal());			//Aceita !
		assertFalse(aol.isOperLogico('!'));			//Estado final, não aceita mais nada
		
		aol.resetAutomato();
				
		assertTrue(aol.isOperLogico('&'));
		assertFalse(aol.isEstadoFinal());			//Não aceita &
		assertFalse(aol.isOperLogico('!'));			//Não aceita &!, reinicia
		
		assertTrue(aol.isOperLogico('&'));
		assertTrue(aol.isOperLogico('&'));	
		assertTrue(aol.isEstadoFinal());			//Aceita &&
		assertFalse(aol.isOperLogico('b'));			//Não aceita &&b
		
		aol.resetAutomato();
		
		assertTrue(aol.isOperLogico('|'));
		assertFalse(aol.isEstadoFinal());			//Não aceita |
		assertFalse(aol.isOperLogico('-'));			//Não aceita |-, reinicia
		
		assertTrue(aol.isOperLogico('|'));
		assertTrue(aol.isOperLogico('|'));	
		assertTrue(aol.isEstadoFinal());			//Aceita ||
		assertFalse(aol.isOperLogico('.'));			//Não aceita ||.
		
		
		
		
		
	}

}
