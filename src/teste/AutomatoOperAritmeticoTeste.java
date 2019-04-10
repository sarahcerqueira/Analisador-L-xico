/*package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperAritmetico;

public class AutomatoOperAritmeticoTeste {

	@Test
	public void test() {
		AutomatoOperAritmetico aoa = new AutomatoOperAritmetico();
		
		assertFalse(aoa.isOperAritmetico('a')); 		//N�o aceita letra
		assertTrue(aoa.isEstadoErro());
		aoa.resetAutomato();
		
		assertFalse(aoa.isOperAritmetico('{'));			//N�o aceita s�mbolos que n�o fazem oprra��es aritim�tica
		assertTrue(aoa.isEstadoErro());
		aoa.resetAutomato();
		
		assertFalse(aoa.isOperAritmetico('�'));			//N�o aceita letras com acentua��o
		assertTrue(aoa.isEstadoErro());
		aoa.resetAutomato();
		
		assertTrue(aoa.isOperAritmetico('*'));			
		assertTrue(aoa.isEstadoFinal());				//Aceita *
		assertFalse(aoa.isOperAritmetico('2'));			//N�o aceita digito
		assertTrue(aoa.isEstadoErro());

		
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

}*/
