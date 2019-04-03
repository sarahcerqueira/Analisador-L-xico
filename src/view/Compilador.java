package view;

import java.io.IOException;

import util.ModoException;

public class Compilador {

	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	
      AnalisadorLexico al = new AnalisadorLexico();
      al.inicializar();
      try {
    	  al.executar();
      } catch (ModoException e) {
    	  e.printStackTrace();
      }
    	
    }
	
}
