package javabasic;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HolaMundo {
	
	int sumatoria = 10;
	static int suma = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Hola Mundo");
		
	}
	
	@Test(priority=2)
	public void showConsole() {
		System.out.println("Hola Mundo");
		Reporter.log("Hola Mundo",true);
		sumatoria = sumatoria + 1;
		Reporter.log("La sumatoria es:" + sumatoria,true);
		
	}
	
	@Test(priority=1)
	public void typeOfVariables() {
		int numero1 = 10;
		char letra = 's';
		float numeroDecimail = 10.5f;
		double numeroGrande = 10.2387492387;
		boolean flag = true;
		String nombre = "Nohemi";
		Boolean flag2=false;
		Double numeroGrande2 = 20.872937129379812738;
		int numero2;
		sumatoria = numero1 + sumatoria;
		Reporter.log("La sumatoria es: " + sumatoria,true);
		Reporter.log("El valor de la variable: " + numero1,true);
	}
	
	@Test(priority=3)
	public void operacionesAritmeticas() {
		int numero1 = 10;
		int numero2 = 99;
		double resultado = 0;
		
		resultado = numero1+numero2;
		Reporter.log("El resultado de la suma es: " + resultado,true);
		
		resultado = numero1 - numero2;
		Reporter.log("El resultado de la resta es: " + resultado,true);
		
		resultado = numero1*numero2;
		Reporter.log("El resultado de la aplicacion es: " + resultado,true);
		
		resultado = numero2/numero1;
		Reporter.log("El resultado de la division es: " + resultado,true);
		
		resultado = numero2%numero1;
		Reporter.log("El resultado del residuo es: " + resultado,true);
		
	}

}
