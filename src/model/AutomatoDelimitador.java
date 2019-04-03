/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Esse automato identifica delimitadores da linguagem.
 *
 * @author sara
 */
public class AutomatoDelimitador {
	
	private String lexema;
	
	public AutomatoDelimitador() {
		this.lexema = new String("");
	}
    
    
    /** Verifica se um determinado caractere é um um delimitador.
     * 
     * @param c
     * @return 
     */
    public boolean isdelimitado(char c) {
    	
    	if(c == ';' || c == ',' || c == '.' || c == '(' || c == ')'|| c == '[' || c == ']' || c == '{' || c == '}') { 
    	this.lexema += Character.toString(c);
        return true;}
    	
    	return false;
                 

    }
    
    public String getLexema() {
    	
    	return this.lexema;
    }
    
    public void resetAutomato() {
    	this.lexema = "";
    }

    

}
