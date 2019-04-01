package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoDelimitador;

public class AutomatoDelimitadorTeste {

	@Test
	public void test() {
		AutomatoDelimitador ad = new AutomatoDelimitador();
		
		//Aceita ; , ( ) [ ] { } .
		assertTrue(ad.isdelimitado(';'));
		assertTrue(ad.isEstadoFinal());
		assertFalse(ad.isdelimitado(';')); //Estado final
		assertTrue(ad.isEstadoErro());
		
		ad.resetAutomato();
		assertFalse(ad.isEstadoFinal());
		assertTrue(ad.isdelimitado(','));
		
		ad.resetAutomato();
		assertTrue(ad.isdelimitado('('));
		
		ad.resetAutomato();
		assertTrue(ad.isdelimitado(')'));
		
		ad.resetAutomato();
		assertTrue(ad.isdelimitado('['));
		
		ad.resetAutomato();
		assertTrue(ad.isdelimitado(']'));
		
		ad.resetAutomato();
		assertTrue(ad.isdelimitado('{'));
		
		ad.resetAutomato();
		assertTrue(ad.isdelimitado('}'));
		
		ad.resetAutomato();
		assertTrue(ad.isdelimitado('('));


		
		
		
	}

}
