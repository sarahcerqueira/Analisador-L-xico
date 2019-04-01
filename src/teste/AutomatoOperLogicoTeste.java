package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperLogico;

public class AutomatoOperLogicoTeste {

	@Test
	public void test() {
		
		AutomatoOperLogico aol = new AutomatoOperLogico();
		
		assertFalse(aol.isOperLogico('b')); 		//Não aceita letra
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('f'));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('w'));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
				
		assertFalse(aol.isOperLogico('*'));			//Não aceita simbolos que não são operadores logicos
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('('));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('='));
		assertTrue(aol.isEstadoErro());
		aol.resetAutomato();
		
		assertFalse(aol.isOperLogico('9'));			//Não aceita digito
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
		assertFalse(aol.isOperLogico('!'));			//Estado final, não aceita mais nada
		
		aol.resetAutomato();
				
		assertTrue(aol.isOperLogico('&'));
		assertFalse(aol.isEstadoFinal());			//Não aceita &
		assertFalse(aol.isOperLogico('!'));			//Não aceita &!, reinicia
		aol.resetAutomato();

		
		assertTrue(aol.isOperLogico('&'));
		assertTrue(aol.isOperLogico('&'));	
		assertTrue(aol.isEstadoFinal());			//Aceita &&
		assertFalse(aol.isOperLogico('b'));			//Não aceita &&b
		
		aol.resetAutomato();
		
		assertTrue(aol.isOperLogico('|'));
		assertFalse(aol.isEstadoFinal());			//Não aceita |
		assertFalse(aol.isOperLogico('-'));			//Não aceita |-, reinicia
		aol.resetAutomato();

		
		assertTrue(aol.isOperLogico('|'));
		assertTrue(aol.isOperLogico('|'));	
		assertTrue(aol.isEstadoFinal());			//Aceita ||
		assertFalse(aol.isOperLogico('.'));			//Não aceita ||.
		
		
		
		
		
	}

}
