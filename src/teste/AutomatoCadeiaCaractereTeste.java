/*package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AutomatoCadeiaCaractere;

public class AutomatoCadeiaCaractereTeste {

	@Test
	public void test() {

		AutomatoCadeiaCaractere acc = new AutomatoCadeiaCaractere();

		assertFalse(acc.isCadeiaCaractere('a')); // O automato s� aceita " como caracterer de entrada.
		assertTrue(acc.isEstadoErro());
		acc.resetAutomato();

		assertTrue(acc.isCadeiaCaractere('"')); // Caractere inicial de uma cadeia.
		assertFalse(acc.isEstadoFinal()); // Se � o primeiro caractere, n�o pode est� em estado final.
		assertTrue(acc.isCadeiaCaractere('2')); // Aceita digito.
		assertFalse(acc.isCadeiaCaractere('�')); // Esse caractere est� fora do intervalo aceito.
		assertTrue(acc.isEstadoErro());

		// N�o faz sentido o automato continuar se houve caractere n�o aceito ent�o ele
		// entra em estado de erro e precisa ser resetado
		acc.resetAutomato();
		assertFalse(acc.isCadeiaCaractere('a'));
		acc.resetAutomato();
		assertTrue(acc.isCadeiaCaractere('"'));
		assertTrue(acc.isCadeiaCaractere('\\')); // teste simbolos
		assertTrue(acc.isCadeiaCaractere('*'));
		assertTrue(acc.isCadeiaCaractere('>'));
		assertTrue(acc.isCadeiaCaractere('['));
		assertTrue(acc.isCadeiaCaractere('\\'));
		assertTrue(acc.isCadeiaCaractere('"')); // Aceita " precedido de \, sem ir para o estado final
		assertFalse(acc.isEstadoFinal());
		assertTrue(acc.isCadeiaCaractere('h')); // Teste letras
		assertTrue(acc.isCadeiaCaractere('J'));
		assertTrue(acc.isCadeiaCaractere('o'));
		assertTrue(acc.isCadeiaCaractere('Z'));
		assertTrue(acc.isCadeiaCaractere('0')); // Teste Digito
		assertTrue(acc.isCadeiaCaractere('9'));
		assertTrue(acc.isCadeiaCaractere('"')); // Fim da cadeia
		assertTrue(acc.isEstadoFinal());


		assertFalse(acc.isCadeiaCaractere('i')); // No estado final n�o aceita mais nada
		assertTrue(acc.isEstadoErro());
		acc.resetAutomato();

		assertFalse(acc.isCadeiaCaractere('i')); // Se automato resetado volta ao inicio e s� aceita " para come�a
		assertTrue(acc.isEstadoErro());
		acc.resetAutomato();
		assertTrue(acc.isCadeiaCaractere('"'));
		assertTrue(acc.isCadeiaCaractere('i'));
		assertFalse(acc.isCadeiaCaractere('�'));
		assertTrue(acc.isEstadoErro());
		acc.resetAutomato();


	}

}**/
