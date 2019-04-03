/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author User-PC
 */
public enum Classe {
   
   NULL("NULL"), IDENTIFICADOR("identificador"), NUMERO("numero"), DELIMITADOR("delimitador"), CADEIA_DE_CARACTERES("cadeia de caracteres"),
   COMENTARIO("comentario"), OPERADOR_LOGICO("operador logico"), OPERADOR_ARITMETICO("operador aritmetico"), OPERADOR_RELACIONAL("operador relacional");
   //Classes disponíveis 
    
    
   private final String classe;
   
   /** @param modo
    */
   Classe(String classe){
       this.classe = classe;
   }
        
   /** Retorna a string que define a classe do lexema.
    * 
    * @return 
    */
   public String getClasse()
   {
       return this.classe;
   }

}
