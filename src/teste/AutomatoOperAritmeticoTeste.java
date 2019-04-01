package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperAritmetico;

public class AutomatoOperAritmeticoTeste {

	@Test
	public void test() {
		AutomatoOperAritmetico aoa = new AutomatoOperAritmetico();
		
		assertFalse(aoa.isOperAritmetico('a')); 		//N�o aceita letra
		assertFalse(aoa.isOperAritmetico('{'));			//N�o aceita s�mbolos que n�o fazem oprra��es aritim�tica
		assertFalse(aoa.isOperAritmetico('�'));			//N�o aceita letras com acentua��o
		
		assertTrue(aoa.isOperAritmetico('*'));			
		assertTrue(aoa.isEstadoFinal());				//Aceita *
		assertFalse(aoa.isOperAritmetico('2'));			//N�o aceita digito
		
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
