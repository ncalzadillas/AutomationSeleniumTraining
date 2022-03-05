package javabasic;

import java.util.Scanner;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TareaAutomation1 {
	
	double numero1 = 0;
	double numero2 = 0;
	
	Scanner reader = new Scanner(System.in);
	
	@Test
	public void compararNumeros() {
		
		Reporter.log("Ingresa el primer numero: ",true);
		numero1 = reader.nextDouble();
		
		Reporter.log("Ingresa el segundo numero: ",true);
		numero2 = reader.nextDouble();
		
		if(numero1<numero2) {
			Reporter.log(numero1 + " es menor que " + numero2,true);
		}else if(numero1>numero2) {
			Reporter.log(numero1 + " es mayor que " + numero2,true);
		}else {
			Reporter.log(numero1 + " es igual que " + numero2,true);
		}
		
		reader.close();
		
	}
	
	@Test
	public void NumerosIguales() {
		
		do {
			Reporter.log("Ingresa el primer numero: ",true);
			numero1 = reader.nextDouble();
			
			Reporter.log("Ingresa el segundo numero: ",true);
			numero2 = reader.nextDouble();
			
		}while(numero1!=numero2);
		
		reader.close();
		
		
	}

}
