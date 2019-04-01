package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoIdentificador;

public class AutomatoIdentificadorTeste {

	@Test
	public void test() {
		AutomatoIdentificador ai = new AutomatoIdentificador();
		
		//Apenas uma letra pode iniciar um identificador
		assertFalse(ai.isIdentificador('3'));
		assertFalse(ai.isIdentificador('*'));
		assertFalse(ai.isIdentificador('_'));
		
		assertTrue(ai.isIdentificador('e'));
		assertTrue(ai.isEstadoFinal());			//Ap�s a primeira letra j� entra em estado final
		//Depois da primeira letra
		assertTrue(ai.isIdentificador('U'));	//Pode receber mais letras
		assertTrue(ai.isIdentificador('9'));	//Pode receber digito
		assertTrue(ai.isIdentificador('_'));	//Pode receber anderline
		assertTrue(ai.isEstadoFinal());			
		
		ai.resetAutomato();
		assertTrue(ai.isIdentificador('r'));
		assertFalse(ai.isIdentificador('{'));
		assertFalse(ai.isIdentificador('='));
		
		
	}

}
