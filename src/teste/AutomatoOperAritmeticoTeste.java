package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperAritmetico;

public class AutomatoOperAritmeticoTeste {

	@Test
	public void test() {
		AutomatoOperAritmetico aoa = new AutomatoOperAritmetico();
		
		assertFalse(aoa.isOperAritmetico('a')); 		//Não aceita letra
		assertFalse(aoa.isOperAritmetico('{'));			//Não aceita símbolos que não fazem oprrações aritimética
		assertFalse(aoa.isOperAritmetico('ç'));			//Não aceita letras com acentuação
		
		assertTrue(aoa.isOperAritmetico('*'));			
		assertTrue(aoa.isEstadoFinal());				//Aceita *
		assertFalse(aoa.isOperAritmetico('2'));			//Não aceita digito
		
		aoa.resetAutomato();
		
		assertTrue(aoa.isOperAritmetico('/'));
		assertTrue(aoa.isEstadoFinal());				//Aceita /

		aoa.resetAutomato();
		
		assertTrue(aoa.isOperAritmetico('+'));
		assertTrue(aoa.isEstadoFinal());				//Aceita +
		assertTrue(aoa.isOperAritmetico('+'));			
		assertTrue(aoa.isEstadoFinal());				//aceita ++
		
		aoa.resetAutomato();
		
		assertTrue(aoa.isOperAritmetico('-'));
		assertTrue(aoa.isEstadoFinal());				//Aceita -	
		assertTrue(aoa.isOperAritmetico('-'));
		assertTrue(aoa.isEstadoFinal());				//Aceita --
		
		
		
	}

}
