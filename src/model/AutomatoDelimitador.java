/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Esse automato tem 2 estados;
 * @author sara
 */
public class AutomatoDelimitador {
    
    private int estado;
    
    
    public AutomatoDelimitador(){
        estado = 0;
    }
    
    public boolean isdelimitado(char c){
        
        switch (estado){
            case(0):{
                if (c == ';' || c == ',' || c == '.' || c == '(' || c == ')' 
                        || c == '[' || c == ']' || c == '{' || c == '}'){
                    this.estado = 1;
                }else{
                    //passar pra outro automato
                    return false;
                }                
                break;      
            }
            case(1):{
                    this.estado = 1;
                    resetarAutomato();
                    return true;      
            }
        
        }
        return false;
    }

    private void resetarAutomato() {
        this.estado = 0;
    }
    
}
