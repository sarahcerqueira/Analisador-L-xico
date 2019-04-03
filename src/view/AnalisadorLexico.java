/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import model.AutomatoCadeiaCaractere;
import model.AutomatoComentario;
import model.AutomatoDelimitador;
import model.AutomatoIdentificador;
import model.AutomatoNumeros;
import model.AutomatoOperAritmetico;
import model.AutomatoOperLogico;
import model.AutomatoOperRelacionais;
import util.ManipuladorDeArquivo;
import util.Modo;
import util.ModoException;
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
	private ArrayList<String> palavraReservada;

	private int linha = 1;
	private String classe;
	private char c;

	public void executar() throws FileNotFoundException, IOException, ModoException {

		listaDeTokens = new ArrayList<>();
		listaDeErro = new ArrayList<>();
		palavraReservada = new ArrayList<>();
		this.classe = "NULL";
		this.startPalavraRevervada();

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
				this.classe = "NULL";
				ativo = true;


			} else if (this.delimitador.isdelimitado(c)) {
				
				if (!this.classe.equals("NULL")) {
					classificaToken();}
				classe = "DELIMITADOR";
				classificaToken();
				this.resetarAutomatos();
				this.classe = "NULL";
				ativo = true;


			} else if (this.aritmetico.isOperAritmetico(c)) {

				if (!this.classe.equals("NULL")) {
					classificaToken();}
				classe = "OPERADOR ARITMETICO";
				classificaToken();
				this.resetarAutomatos();
				this.classe = "NULL";
				ativo = true;

			} else if (this.logico.isOperLogico(c)) {
				
				if (!this.classe.equals("NULL")) {
					classificaToken();}
				
				classe = "OPERADOR LOGICO";
				classificaToken();
				this.resetarAutomatos();
				this.classe = "NULL";
				ativo = true;

			} else if (this.relacional.isOperRelacional(c)) {
				
				if (!this.classe.equals("NULL")) {
					classificaToken();}
				classe = "OPERADOR RELACIONAL";
				classificaToken();
				this.resetarAutomatos();
				this.classe = "NULL";
				ativo = true;

			} else {

				if ( c != '\r' && c != '\n' && this.identificador.isIdentificador(c)) {
					classe = "IDENTIFICADOR";
					ativo = true;

				}

				if (this.numero.isNumero(c)) {
					classe = "NUMERO";
					ativo = true;

				}

				if (this.cadeia.isCadeiaCaractere(c)) {
					classe = "CADEIA DE CARACTERES";
					ativo = true;

				}

				if (this.comentario.isComentario(c)) {
					classe = "COMENTARIO";
					ativo = true;

				}
				
				this.resetOperadores();

			}
			
			if (c == '\r' || c == '\n') {
				
				if (c == '\n') {
					linha++;}

				if (!this.classe.equals("COMENTARIO") && !this.classe.equals("NULL") && c != '\n') {
					classificaToken();
					this.resetarAutomatos();
					 this.classe = "NULL";
				} else if (this.classe.equals("NULL")) {
					this.resetarAutomatos();

				}
				
				ativo = true;

			}

			if (!ativo) {
				classificaToken();
				this.resetarAutomatos();
				this.classe = "NULL";
				
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

	private Token createToken(String valor, String classe, int linha) {
		return new Token(valor, classe, linha);
	}

	private void classificaToken() {

		String lexema = "NULL";
		boolean erro = false;

		switch (this.classe) {
		case "IDENTIFICADOR":
			lexema = identificador.getLexema();
			erro = identificador.isEstadoErro();
			
			if(this.palavraReservada.contains(lexema)) {
				this.classe= "PALAVRA RESERVADA";
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
		this.classe = "Erro";
		Token t = createToken(lexema, this.classe, this.linha);
		this.listaDeErro.add(t);

	}
	
	private void startPalavraRevervada() {
		
		this.palavraReservada.add("variaveis");
		this.palavraReservada.add("se");
		this.palavraReservada.add("enquanto");


		
		
	}

}
