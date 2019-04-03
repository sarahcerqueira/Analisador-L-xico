/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import model.AutomatoCadeiaCaractere;
import model.AutomatoComentario;
import model.AutomatoDelimitador;
import model.AutomatoIdentificador;
import model.AutomatoNumeros;
import model.AutomatoOperAritmetico;
import model.AutomatoOperLogico;
import model.AutomatoOperRelacionais;
import util.Classe;
import util.ManipuladorDeArquivo;
import util.Modo;
import util.ModoException;
import util.PalavraReservada;
import util.Token;

/**
 *
 * @author User-PC
 */
public class AnalisadorLexico {

	private AutomatoCadeiaCaractere cadeia;
	private AutomatoComentario comentario;
	private AutomatoDelimitador delimitador;
	private AutomatoIdentificador identificador;
	private AutomatoNumeros numero;
	private AutomatoOperAritmetico aritmetico;
	private AutomatoOperLogico logico;
	private AutomatoOperRelacionais relacional;
	private ArrayList<Token> listaDeTokens;
	private ArrayList<Token> listaDeErro;

	private int linha = 1;
	private Classe classe;
	private char c;

	public void executar() throws FileNotFoundException, IOException, ModoException {

		listaDeTokens = new ArrayList<>();
		listaDeErro = new ArrayList<>();
		this.classe = Classe.NULL;
		
		boolean ativo;

		ManipuladorDeArquivo leitura = new ManipuladorDeArquivo("testesah.txt", Modo.LEITURA);
		int ascii;

		while (leitura.hasNextCaractere()) {

			c = leitura.nextCaractere();
			ascii = (int) c;
			ativo = false;


			if (c == ' ') {
				
				if (!this.classe.equals("NULL")) {
					classificaToken();}
				this.resetarAutomatos();
				this.classe = Classe.NULL;
				ativo = true;


			} else if (this.delimitador.isdelimitado(c)) {
				
				if (!this.classe.equals("NULL")) {
					classificaToken();}
				classe = Classe.DELIMITADOR;
				classificaToken();
				this.resetarAutomatos();
				this.classe = Classe.NULL;
				ativo = true;


			} else if (this.aritmetico.isOperAritmetico(c)) {

				if (!this.classe.equals(Classe.NULL)) {
					classificaToken();}
				classe = Classe.OPERADOR_ARITMETICO;
				classificaToken();
				this.resetarAutomatos();
				this.classe = Classe.NULL;
				ativo = true;

			} else if (this.logico.isOperLogico(c)) {
				
				if (!this.classe.equals(Classe.NULL)) {
					classificaToken();}
				
				classe = Classe.OPERADOR_LOGICO;
				classificaToken();
				this.resetarAutomatos();
				this.classe = Classe.NULL;
				ativo = true;

			} else if (this.relacional.isOperRelacional(c)) {
				
				if (!this.classe.equals(Classe.NULL)) {
					classificaToken();}
				classe = Classe.OPERADOR_RELACIONAL;
				classificaToken();
				this.resetarAutomatos();
				this.classe = Classe.NULL;
				ativo = true;

			} else {

				if ( c != '\r' && c != '\n' && this.identificador.isIdentificador(c)) {
					classe = Classe.IDENTIFICADOR;
					ativo = true;

				}

				if (this.numero.isNumero(c)) {
					classe = Classe.NUMERO;
					ativo = true;

				}

				if (this.cadeia.isCadeiaCaractere(c)) {
					classe = Classe.CADEIA_DE_CARACTERES;
					ativo = true;

				}

				if (this.comentario.isComentario(c)) {
					classe = Classe.COMENTARIO;
					ativo = true;

				}
				
				this.resetOperadores();

			}
			
			if (c == '\r' || c == '\n') {
				
				if (c == '\n') {
					linha++;}

				if (!this.classe.equals(Classe.COMENTARIO) && !this.classe.equals(Classe.NULL) && c != '\n') {
					classificaToken();
					this.resetarAutomatos();
					 this.classe = Classe.NULL;
				} else if (this.classe.equals(Classe.NULL)) {
					this.resetarAutomatos();

				}
				
				ativo = true;

			}

			if (!ativo) {
				classificaToken();
				this.resetarAutomatos();
				this.classe = Classe.NULL;
				
			}
			
			

		}
		
		for(int i =0; i< this.listaDeTokens.size(); i++) {
			Token t = this.listaDeTokens.get(i);
			System.out.println(t.getLinha() +" "+ t.getValor()+" "+ t.getClasse());
		}
		

		for(int i =0; i< this.listaDeErro.size(); i++) {
			Token t = this.listaDeErro.get(i);
			System.out.println(t.getLinha() +" "+ t.getValor()+" "+ t.getClasse());
		}
		

	}

	public void inicializar() {
		this.cadeia = new AutomatoCadeiaCaractere();
		this.comentario = new AutomatoComentario();
		this.delimitador = new AutomatoDelimitador();
		this.identificador = new AutomatoIdentificador();
		this.numero = new AutomatoNumeros();
		this.aritmetico = new AutomatoOperAritmetico();
		this.logico = new AutomatoOperLogico();
		this.relacional = new AutomatoOperRelacionais();
	}

	private void resetarAutomatos() {
		this.cadeia.resetAutomato();
		this.comentario.resetAutomato();
		this.identificador.resetAutomato();
		this.numero.resetAutomato();
		this.delimitador.resetAutomato();
		this.resetOperadores();
	}
	
	private void resetOperadores() {
		this.aritmetico.resetAutomato();
		this.logico.resetAutomato();
		this.relacional.resetAutomato();
	}

	private Token createToken(String valor, Classe classe, int linha) {
		return new Token(valor, classe, linha);
	}

	private void classificaToken() {

		String lexema = "NULL";
		boolean erro = false;

                String classificacao = classe.getClasse();
                
		switch (classificacao) {
		case "IDENTIFICADOR":
			lexema = identificador.getLexema();
			erro = identificador.isEstadoErro();
			
			if(this.checarPalavraReservada(lexema)) {
				this.classe = Classe.PALAVRA_RESERVADA; 
			}
			
			
			break;
		case "NUMERO":
			lexema = numero.getLexema();
			erro = numero.isEstadoErro();
			break;
		case "CADEIA DE CARACTERES":
			lexema = cadeia.getLexema();
			erro = cadeia.isEstadoErro();
			break;
		case "OPERADOR LOGICO":
			lexema = logico.getLexema();
			erro = logico.isEstadoErro();
			break;
		case "OPERADOR ARITMETICO":
			lexema = aritmetico.getLexema();
			erro = aritmetico.isEstadoErro();
			break;
		case "OPERADOR RELACIONAL":
			lexema = relacional.getLexema();
			erro = relacional.isEstadoErro();
			break;
		case "COMENTARIO":
			lexema = comentario.getLexema();
			erro = comentario.isEstadoErro();
			break;
		case "DELIMITADOR":
			lexema = delimitador.getLexema();
			break;
		case "NULL":
			getErro("");
			return;
			
		}

		if (erro) {
			getErro(lexema);

		} else {

			Token t = createToken(lexema, this.classe, this.linha);
			this.listaDeTokens.add(t);
		}
	}

	private void getErro(String lexema) {

		if (c != '\n' && c != '\r') {
			lexema += Character.toString(c);
		}
		this.classe = Classe.ERRO;
		Token t = createToken(lexema, this.classe, this.linha);
		this.listaDeErro.add(t);

	}
	
        private boolean checarPalavraReservada(String lexema){
            
            return (    lexema.equals(PalavraReservada.BOOLEANO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.CONSTANTES.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.ENQUANTO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.ENTAO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.ESCREVA.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.FALSO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.INTEIRO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.LEIA.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.METODO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.PRINCIPAL.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.PROGRAMA.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.REAL.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.RESULTADO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.SE.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.SENAO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.TEXTO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.VARIAVEIS.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.VAZIO.getPalavraReservada()) ||
                        lexema.equals(PalavraReservada.VERDADEIRO.getPalavraReservada())    );
                        
            
        }


}
