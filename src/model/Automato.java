/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sarah
 */
public abstract class Automato {

    protected int estado;
    protected String lexema;
    
    
    public Automato(){
        this.estado =0;
        this.lexema = new String("");
    }

    /**
     * Faz o automato voltar ao estado inicial.
     */
    public void resetAutomato() {
        this.estado = 0;
        this.lexema = "";
    }

    /**
     * Verifica se o automato est√° no estado final.
     *
     * @return
     */
    public abstract boolean isEstadoFinal() ;
    
    /** 
     * Verifica se o automato est· em estado de erro.
     * 
     * @return
     */
    public boolean isEstadoErro() {
    	return this.estado == -1;
    	
    }
    
    public String getLexema() {
    	
    	return this.lexema;
    }
    
    public void concat(char c) {
    	this.lexema += Character.toString(c);
    }

    
    


}
