/*package teste;

import static org.junit.Assert.*;
import org.junit.Test;
import model.AutomatoComentario;

public class AutomatoComentarioTest {

	@Test
	public void test() {
		
		AutomatoComentario ac = new AutomatoComentario();
		
		assertFalse(ac.isComentario('a')); //Coment�rio come�a obrigat�riamente por /
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();
		assertFalse(ac.isComentario('3'));
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();
		assertTrue(ac.isComentario('/')); //Carectere inicial v�lido
		
		assertFalse(ac.isComentario('x')); //Depois da primeira barra s� � aceito outra / ou *
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();
		assertFalse(ac.isComentario('a'));	//Automato tem que ser resetado
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();

		assertTrue(ac.isComentario('/')); 
		assertTrue(ac.isComentario('/')); 	//Coment�rio com //
		
		//Depois de duas barras aceita qualquer coisa at� entrar em \n
		
		assertTrue(ac.isComentario('/'));	//Aceita simbolos
		assertTrue(ac.isComentario('*'));
		assertTrue(ac.isComentario('{'));
		assertTrue(ac.isComentario(')'));
		assertTrue(ac.isComentario('k'));	//Aceita Letras
		assertTrue(ac.isComentario('P'));
		assertFalse(ac.isEstadoFinal()); 	//N�o est� em estado final ainda
		assertTrue(ac.isComentario('e'));
		assertTrue(ac.isComentario('9'));	//Aceita digitos
		assertTrue(ac.isComentario('7'));
		assertTrue(ac.isComentario('�'));	//Aceita acentua��o
		assertTrue(ac.isComentario('�'));
		assertTrue(ac.isComentario(' ')); 	//Aceita espa�o
		assertTrue(ac.isComentario('\n'));  //Aceita quebra de linha
		
		assertTrue(ac.isEstadoFinal());		//Estado final
		assertFalse(ac.isComentario('r')); //N�o aceita mais nenhum caractere pois est� em estado final
		
		ac.resetAutomato();
		assertFalse(ac.isComentario('r')); //Se automato resetado, s� aceita / como entrada inicial
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();

		assertTrue(ac.isComentario('/')); 
		assertTrue(ac.isComentario('/'));
		assertTrue(ac.isComentario(' '));
		assertTrue(ac.isComentario('y'));
		assertTrue(ac.isComentario('2'));
		assertTrue(ac.isComentario('\r'));// Deve aceita \r como final tamb�m
		
		assertTrue(ac.isEstadoFinal());	
		assertFalse(ac.isComentario('f')); //N�o aceita mais nenhum caractere pois est� em estado final
		assertTrue(ac.isEstadoErro());

		
		ac.resetAutomato();
		assertTrue(ac.isComentario('/'));
		assertTrue(ac.isComentario('*'));	//Coment�rio /*
		
		assertTrue(ac.isComentario('/'));	//Aceita simbolos
		assertTrue(ac.isComentario('*'));
		assertTrue(ac.isComentario('{'));
		assertTrue(ac.isComentario(')'));
		assertTrue(ac.isComentario('k'));	//Aceita Letras
		assertTrue(ac.isComentario('P'));
		assertTrue(ac.isComentario('\n'));  //Aceita quebra de linha
		assertTrue(ac.isComentario('\r'));
		assertFalse(ac.isEstadoFinal()); 	//N�o est� em estado final ainda
		assertTrue(ac.isComentario('e'));
		assertTrue(ac.isComentario('9'));	//Aceita digitos
		assertTrue(ac.isComentario('7'));
		assertTrue(ac.isComentario('�'));	//Aceita acentua��o
		assertTrue(ac.isComentario('�'));
		assertTrue(ac.isComentario('�'));
		assertTrue(ac.isComentario(' ')); 	//Aceita espa�o
		assertTrue(ac.isComentario('\n'));
		
		assertTrue(ac.isComentario('*'));
		assertTrue(ac.isComentario('/'));	//Fecha coment�rio
		
		assertTrue(ac.isEstadoFinal());
		assertFalse(ac.isComentario('b'));	//Estado final, n�o deve aceitar mais nada
		assertTrue(ac.isEstadoErro());

	}

}*/
