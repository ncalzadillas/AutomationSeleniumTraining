package javaMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Arreglos {
	
	private int numero1;
	private int numero2;
	
	public Arreglos() {
		
	}
	
	/**
	 * @Description Constructor con dos parametros
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
	public Arreglos(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	/**
	 * @Description Inicializa el valor de numero1
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param N/A
	 * @return N/A
	 */
	public int getNumero1() {
		return numero1;
	}
	/**
	 * @Description Inicializa el valor de numero2
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
	public int getNumero2() {
		return numero2;
	}

	/**
	 * @Description Regresa el valor de numero1
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	/**
	 * @Description Regresa el valor de numero2
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}
	
	/**
	 * @Description Crear arreglo y asignarle valor, y mostrar en consola valores
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param int, int
	 * @return N/A
	 */
	public void crearArreglo() {
		int[] arreglo1 = {1,2,3,4};
		
		for(int i=0; i<arreglo1.length; i++) {
			
			System.out.println("el valor del arreglo1 es: " + arreglo1[i]);
			
		}
		
		System.out.println("\n");
		
		//Tiene posiciones de 0 a 8
		int[] arreglo2 = new int [9];
		
		int index2 = 1;
		
		for(int i=0; i<arreglo2.length; i++) {
			
			arreglo2[i] = index2*2;
			index2++;
			System.out.println("el valor del arreglo2 es: " + arreglo2[i]);
			
		}
		
		System.out.println("\n");
		
		int suma = 0;
		for (int i=0; i<arreglo1.length; i++) {
			suma = suma + arreglo1[i];
		}
		
		System.out.println("El valor de la sumatoria del primer arreglo es: " + suma);
		System.out.println("\n");
		
		int suma2 = 0;
		for (int i=0; i<arreglo2.length; i++) {
			suma2 = suma2 + arreglo2[i];
		}
		
		System.out.println("El valor de la sumatoria del segundo arreglo es: " + suma2);
		System.out.println("\n");
		
	}
	
	/**
	 * @Description Invertir el orden de un arreglo, y mostrar en consola valores
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param N/A
	 * @return N/A
	 */
	public void invertirOrdenArreglo() {
		int[] arreglo1 = {1,2,3,4,5};
		int[] arreglo2 = new int [arreglo1.length];
		
		for (int i=0; i<arreglo1.length; i++) {
			System.out.println("El valor del arreglo1 es: [" + arreglo1[i] + " ]");
		}
		
		int index = arreglo1.length-1;
		
		for (int i=(arreglo1.length-1) ; i>=0; i--) {
			System.out.println("El valor invertido del arreglo1 es: [" + arreglo1[i] + " ]");
			
		}
		
		System.out.println("\n");
		
		for(int i = (arreglo1.length-1), j=0; i>=0; i--, j++ ) {
			arreglo2[j]=arreglo1[i];
			System.out.println("El valor del arreglo2 invertido es: [" + arreglo2[j] + " ]");
		}
	}
	
	/**
	 * @Description Lista de enteros, y mostrar en consola valores
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param N/A
	 * @return N/A
	 */
	public void listasDeEnteros() {
		List<Integer> listaNumeros = new ArrayList<>();
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(1);
		listaNumeros.add(4);
		listaNumeros.add(5);
		listaNumeros.add(5);
		listaNumeros.add(4);
		
		int[] numeros = {1,2,3,4,5,6};
		
		System.out.println("El valor de la lista es: " + listaNumeros);
		System.out.println("\n");
		
		Collections.sort(listaNumeros);
		System.out.println("El valor de la lista ordenada de menor a mayor es: " + listaNumeros);
		System.out.println("\n");
		
		Collections.sort(listaNumeros, Collections.reverseOrder());
		System.out.println("El valor de la lista ordenada de mayor a menor es: " + listaNumeros);
		System.out.println("\n");
		
		
		System.out.println("El numero mayor de la lista es es: " + Collections.max(listaNumeros));
		System.out.println("\n");
		
		System.out.println("El numero menor de la lista es es: " + Collections.min(listaNumeros));
		System.out.println("\n");
		
		Object ultimo = null;
		int contador = 0;
		Iterator<Integer> i = listaNumeros.iterator();
		
		while(i.hasNext()) {
			
			Object temporal = i.next();
			
			if(temporal.equals(ultimo)) {
				i.remove();
				contador++;
			}else {
				ultimo=temporal;
			}
			
		}//end while
		
		System.out.println("La cantidad de numeros repetidos fue: " + contador);
		System.out.println("La list sin elementos repetidos es: " + listaNumeros);
		
		for(int numero : numeros) {
			System.out.println("El numero es: " + numero);
		}
	}
	
	/**
	 * @Description Arreglos de Strings, y mostrar en consola valores
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param N/A
	 * @return N/A
	 */
	
	public void arregloDeStrings() {
		String[] nombres = {"Sergio", "Arturo", "Rosa"};
	
		
		for(String nombre: nombres) {
			System.out.println("El nombre es: " + nombre);
			
		}
		
		String[] nombres2 = new String[5];
		
		for(int i=0; i<nombres2.length; i++) {
		
			nombres2[i] = "Texto " + i;
			System.out.println("El nombre es: " + nombres2[i]);
			
		}
		
	}
	
	/**
	 * @Description Lista de Strings, y mostrar en consola valores
	 * @author ncalzadillas
	 * @date 03/05/2022
	 * @param N/A
	 * @return N/A
	 */
	
	public void listaDeStrings() {
		
		List<String> listaNombres = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			listaNombres.add("Persona " + i);
			
		}
		
		listaNombres.add("Persona5");
		listaNombres.add("Persona5");
		listaNombres.add("Persona5");
		
		String test = "Sergio";
		
		if(test.equals("Sergio")) {
			System.out.println("Es igual");
		}
		
		System.out.println(listaNombres);
		
		Collections.sort(listaNombres, Collections.reverseOrder());
		
		System.out.println(listaNombres);
		
		System.out.println(listaNombres.stream().distinct().collect(Collectors.toList()));
		
		System.out.println(listaNombres);
		
		List<String> listaNombreSinRepetir = listaNombres.stream().distinct().collect(Collectors.toList());
		
		Collections.sort(listaNombreSinRepetir);

		System.out.println(listaNombreSinRepetir);
		
	}


}
