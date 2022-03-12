package javabasic;

import java.util.Scanner;

import org.testng.annotations.Test;

import javaMain.Cuenta;

public class TestCuenta {
	
	@Test
	public void probarCuenta() {
		Scanner teclado = new Scanner(System.in);
		String nombre;
		String numeroCuenta;
		double tipo;
		double importe;
		
		System.out.println("Ingresa el nombre: ");
		nombre = teclado.next();
		
		System.out.println("Ingresa el numero de cuenta: ");
		numeroCuenta = teclado.next();
		
		System.out.println("Ingresa el tipo de interes: ");
		tipo = teclado.nextDouble();
		
		System.out.println("Saldo: ");
		importe = teclado.nextDouble();
		
		teclado.close();
		
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setNombre(nombre);
		cuenta1.setNumeroCuenta(numeroCuenta);
		cuenta1.setTipoInteres(tipo);
		cuenta1.setSaldo(importe);
		
		System.out.println("El nombre del dueno de la cuenta 1 es: " + cuenta1.getNombre());
		System.out.println("El numero de la cuenta 1 es: " + cuenta1.getNumeroCuenta());
		System.out.println("El tipo de interes de la cuenta 1 es: " + cuenta1.getTipoInteres());
		System.out.println("El saldo de la cuenta 1 es: " + cuenta1.getSaldo());
		
		System.out.println("\n");
		
		Cuenta cuenta2 = new Cuenta("Ivan", "898898",10.5,6000);
		
		System.out.println("El nombre del dueno de la cuenta 2 es: " + cuenta2.getNombre());
		System.out.println("El numero de la cuenta 2 es: " + cuenta2.getNumeroCuenta());
		System.out.println("El tipo de interes de la cuenta 2 es: " + cuenta2.getTipoInteres());
		System.out.println("El saldo de la cuenta 2 es: " + cuenta2.getSaldo());
	
		System.out.println("\n");
		
		Cuenta cuenta3 = new Cuenta(cuenta1);
		cuenta3.setNombre("Raul");
		
		System.out.println("El nombre del dueno de la cuenta 3 es: " + cuenta3.getNombre());
		System.out.println("El numero de la cuenta 3 es: " + cuenta3.getNumeroCuenta());
		System.out.println("El tipo de interes de la cuenta 3 es: " + cuenta3.getTipoInteres());
		System.out.println("El saldo de la cuenta 3 es: " + cuenta3.getSaldo());
		
		System.out.println("\n");
		
		System.out.println("Se hace transferencia de la cuenta 3 a la cuenta 2 d 2000");
		cuenta3.transferencia(cuenta2,2000);
		
		System.out.println("El saldo de la cuenta 2 es: " + cuenta2.getSaldo());
		System.out.println("El saldo de la cuenta 3 es: " + cuenta3.getSaldo());
		
		cuenta3.ingreso(7000);
		cuenta2.retiro(1000);
		
		System.out.println("El saldo de la cuenta 2 es: " + cuenta2.getSaldo());
		System.out.println("El saldo de la cuenta 3 es: " + cuenta3.getSaldo());
		
		System.out.println("\n");
		
		cuenta3.ingreso(-500);
		System.out.println("Se intenta ingresar un numero negativo");
		System.out.println("El saldo de la cuenta 3 es: " + cuenta3.getSaldo());
		
	}

}//end class
