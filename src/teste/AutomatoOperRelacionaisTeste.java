package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperRelacionais;

public class AutomatoOperRelacionaisTeste {

	@Test
	public void test() {
		AutomatoOperRelacionais aor = new AutomatoOperRelacionais();
		
		assertFalse(aor.isOperRelacional('x'));
		assertFalse(aor.isOperRelacional('i'));
		assertFalse(aor.isOperRelacional('c'));
		assertFalse(aor.isOperRelacional('1'));
		assertFalse(aor.isOperRelacional('5'));
		assertFalse(aor.isOperRelacional('9'));
		assertFalse(aor.isOperRelacional('{'));
		assertFalse(aor.isOperRelacional('_'));
		assertFalse(aor.isOperRelacional('ê'));
		
		assertTrue(aor.isOperRelacional('<'));
		assertTrue(aor.isEstadoFinal());			//Aceita <
		assertFalse(aor.isOperRelacional('-'));		//Não aceita <-
		
		aor.resetAutomato();
		
		assertTrue(aor.isOperRelacional('<'));
		assertTrue(aor.isEstadoFinal());			//Aceita <
		assertTrue(aor.isOperRelacional('='));
		assertTrue(aor.isEstadoFinal());			//Aceita <=
		
		aor.resetAutomato();
		
		assertTrue(aor.isOperRelacional('='));
		assertFalse(aor.isOperRelacional('<'));			// Não aceita =<
		
		aor.resetAutomato();
		
		assertTrue(aor.isOperRelacional('>'));
		assertTrue(aor.isEstadoFinal());			//Aceita >
		assertTrue(aor.isOperRelacional('='));
		assertTrue(aor.isEstadoFinal());			//Aceita >=
		
		aor.resetAutomato();
		
		assertTrue(aor.isOperRelacional('='));
		assertFalse(aor.isOperRelacional('>'));	// Não aceita =>
		
		aor.resetAutomato();
		
		assertTrue(aor.isOperRelacional('!'));
		assertFalse(aor.isEstadoFinal());			//Não aceita !
		assertTrue(aor.isOperRelacional('='));
		assertTrue(aor.isEstadoFinal());			//Aceita !=
		
		aor.resetAutomato();
		
		assertTrue(aor.isOperRelacional('='));
		assertTrue(aor.isEstadoFinal());			//Aceita =
		assertFalse(aor.isOperRelacional('!'));		// Não aceita =!
		
		aor.resetAutomato();
		
		assertTrue(aor.isOperRelacional('='));
		assertTrue(aor.isOperRelacional('='));
		assertTrue(aor.isEstadoFinal());			//Aceita ==

		
		
		
	}

}
