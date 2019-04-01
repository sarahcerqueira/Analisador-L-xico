package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoOperRelacionais;

public class AutomatoOperRelacionaisTeste {

	@Test
	public void test() {
		AutomatoOperRelacionais aor = new AutomatoOperRelacionais();
		
		assertFalse(aor.isOperRelacional('x'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('i'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('c'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('1'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('5'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('9'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('{'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('_'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
		assertFalse(aor.isOperRelacional('ê'));
		assertTrue(aor.isEstadoErro());
		aor.resetAutomato();
		
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
