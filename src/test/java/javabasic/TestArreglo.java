package javabasic;

import org.testng.annotations.Test;

import javaMain.Arreglos;

public class TestArreglo {
	
	@Test
	public void probarArreglos() {
		
		Arreglos arr = new Arreglos();
		
		arr.crearArreglo();
		
		arr.invertirOrdenArreglo();
		
		arr.listasDeEnteros();
		
		arr.arregloDeStrings();
		
		arr.listaDeStrings();
		
	}//end probarArreglos
	
}
