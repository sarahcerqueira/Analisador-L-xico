package teste;

import static org.junit.Assert.*;
import org.junit.Test;
import model.AutomatoComentario;

public class AutomatoComentarioTest {

	@Test
	public void test() {
		
		AutomatoComentario ac = new AutomatoComentario();
		
		assertFalse(ac.isComentario('a')); //Comentário começa obrigatóriamente por /
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();
		assertFalse(ac.isComentario('3'));
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();
		assertTrue(ac.isComentario('/')); //Carectere inicial válido
		
		assertFalse(ac.isComentario('x')); //Depois da primeira barra só é aceito outra / ou *
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();
		assertFalse(ac.isComentario('a'));	//Automato tem que ser resetado
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();

		assertTrue(ac.isComentario('/')); 
		assertTrue(ac.isComentario('/')); 	//Comentário com //
		
		//Depois de duas barras aceita qualquer coisa até entrar em \n
		
		assertTrue(ac.isComentario('/'));	//Aceita simbolos
		assertTrue(ac.isComentario('*'));
		assertTrue(ac.isComentario('{'));
		assertTrue(ac.isComentario(')'));
		assertTrue(ac.isComentario('k'));	//Aceita Letras
		assertTrue(ac.isComentario('P'));
		assertFalse(ac.isEstadoFinal()); 	//Não está em estado final ainda
		assertTrue(ac.isComentario('e'));
		assertTrue(ac.isComentario('9'));	//Aceita digitos
		assertTrue(ac.isComentario('7'));
		assertTrue(ac.isComentario('Ó'));	//Aceita acentuação
		assertTrue(ac.isComentario('á'));
		assertTrue(ac.isComentario(' ')); 	//Aceita espaço
		assertTrue(ac.isComentario('\n'));  //Aceita quebra de linha
		
		assertTrue(ac.isEstadoFinal());		//Estado final
		assertFalse(ac.isComentario('r')); //Não aceita mais nenhum caractere pois está em estado final
		
		ac.resetAutomato();
		assertFalse(ac.isComentario('r')); //Se automato resetado, só aceita / como entrada inicial
		assertTrue(ac.isEstadoErro());
		ac.resetAutomato();

		assertTrue(ac.isComentario('/')); 
		assertTrue(ac.isComentario('/'));
		assertTrue(ac.isComentario(' '));
		assertTrue(ac.isComentario('y'));
		assertTrue(ac.isComentario('2'));
		assertTrue(ac.isComentario('\r'));// Deve aceita \r como final também
		
		assertTrue(ac.isEstadoFinal());	
		assertFalse(ac.isComentario('f')); //Não aceita mais nenhum caractere pois está em estado final
		assertTrue(ac.isEstadoErro());

		
		ac.resetAutomato();
		assertTrue(ac.isComentario('/'));
		assertTrue(ac.isComentario('*'));	//Comentário /*
		
		assertTrue(ac.isComentario('/'));	//Aceita simbolos
		assertTrue(ac.isComentario('*'));
		assertTrue(ac.isComentario('{'));
		assertTrue(ac.isComentario(')'));
		assertTrue(ac.isComentario('k'));	//Aceita Letras
		assertTrue(ac.isComentario('P'));
		assertTrue(ac.isComentario('\n'));  //Aceita quebra de linha
		assertTrue(ac.isComentario('\r'));
		assertFalse(ac.isEstadoFinal()); 	//Não está em estado final ainda
		assertTrue(ac.isComentario('e'));
		assertTrue(ac.isComentario('9'));	//Aceita digitos
		assertTrue(ac.isComentario('7'));
		assertTrue(ac.isComentario('Â'));	//Aceita acentuação
		assertTrue(ac.isComentario('õ'));
		assertTrue(ac.isComentario('ç'));
		assertTrue(ac.isComentario(' ')); 	//Aceita espaço
		assertTrue(ac.isComentario('\n'));
		
		assertTrue(ac.isComentario('*'));
		assertTrue(ac.isComentario('/'));	//Fecha comentário
		
		assertTrue(ac.isEstadoFinal());
		assertFalse(ac.isComentario('b'));	//Estado final, não deve aceitar mais nada
		assertTrue(ac.isEstadoErro());

	}

}
