package javabasic;

import java.util.Scanner;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class promedioDeCalificaciones {
	
	double cal1=24;
	double cal2=90;
	double cal3=87;
	double cal4=500;
	
	@Test
	public void calcularPromedio() {
		double resultado = (cal1+cal2+cal3+cal4)/4;
		
//		Reporter.log("El resultado del promedio es: [" + resultado + "]",true);
		
		if(resultado>=70 && resultado<=100) {
			Reporter.log("Estas aprobado con: [" + resultado + "]",true);
			
		}else if(resultado<70 && resultado>=0) {
			
			Reporter.log("Estas reprobado con: [" + resultado+ "]",true);
		}else {
			Reporter.log("Las calificaciones estan fuera de ranngo, promedio [" + resultado + "]",true);
		}
		
		if(resultado>=70 || resultado<=100) {
			Reporter.log("OR Estas aprobado con: [" + resultado + "]",true);
			
		}
	}//End Calcular Promedio
	
	@Test
	public void calcularPromedioPor100Teclado() {
		Scanner reader = new Scanner(System.in);
		
		do {
		Reporter.log("Ingresa la calificacion 1",true);
		cal1=reader.nextDouble();
		
		Reporter.log("Ingresa la calificacion 2",true);
		cal2=reader.nextDouble();
		}while(cal1 <0 || cal1 >100 || cal2 <0 || cal2 >100);
		
		Reporter.log("El promedio de las calificaciones es: " + (cal1+cal2)/2,true);
		double resultado = resultadoPromedio(cal1,cal2);
		calcularPromedio(resultado);
		double result = calcularPromedioRetorno(87);
		Reporter.log("El valor de retorno es: " + result,true);
		
	}//Por Teclado
	
	public void calcularPromedio(double resultado) {
		
		Reporter.log("El resultado del promedio es: [" + resultado + "]",true);
		
		if(resultado>=70 && resultado<=100) {
			Reporter.log("Estas aprobado con: [" + resultado + "]",true);
			
		}else if(resultado<70 && resultado>=0) {
			
			Reporter.log("Estas reprobado con: [" + resultado+ "]",true);
		}else {
			Reporter.log("Las calificaciones estan fuera de ranngo, promedio [" + resultado + "]",true);
		}
		
		if(resultado>=70 || resultado<=100) {
			Reporter.log("OR Estas aprobado con: [" + resultado + "]",true);
			
		}
	}
	
public double calcularPromedioRetorno(double resultado) {
		
		Reporter.log("El resultado del promedio es: [" + resultado + "]",true);
		
		if(resultado>=70 && resultado<=100) {
			Reporter.log("Estas aprobado con: [" + resultado + "]",true);
			
		}else if(resultado<70 && resultado>=0) {
			
			Reporter.log("Estas reprobado con: [" + resultado+ "]",true);
		}else {
			Reporter.log("Las calificaciones estan fuera de ranngo, promedio [" + resultado + "]",true);
		}
		
		if(resultado>=70 || resultado<=100) {
			Reporter.log("OR Estas aprobado con: [" + resultado + "]",true);
			
		}
		return resultado+23;
	}//CalcularPromedioRetorno

	public double resultadoPromedio(double num1, double num2) {
		return (num1+num2/2);
	}

}
