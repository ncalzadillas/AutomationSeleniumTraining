package javabasic;

import org.testng.annotations.Test;

import javaMain.Vehiculo;
import javaMain.VehiculoDeportivo;
import javaMain.VehiculoFurgoneta;
import javaMain.VehiculoTurismo;

public class TestVehiculo {
		
		@Test
		public void datosVehiculo() {
			Vehiculo misVehiculos = new Vehiculo("GSTW-2323", "FORD", "2020");
			
			String datosVehiculo = misVehiculos.mostrarDatosDeVehiculo();
			System.out.println(datosVehiculo);
			misVehiculos.setMatricula("ENA-9089");
			System.out.println(misVehiculos.mostrarDatosDeVehiculo());
			
			misVehiculos = new VehiculoDeportivo("HJK-9098","Mazda","2021",4);
			
			System.out.println(misVehiculos.mostrarDatosDeVehiculo());
			
			
			
		}//End Test
		
		@Test
		public void datosVehiculoEnArreglo() {
			Vehiculo misVehiculos[] = new Vehiculo[4];
			misVehiculos[0] = new Vehiculo("GWO=9090","TOYOTA","2020");
			misVehiculos[1] = new VehiculoDeportivo("KJI=9898","FERRARI","2021",8);
			misVehiculos[2] = new VehiculoFurgoneta("PLOI-9098","FORD","2022",500);
			misVehiculos[3] = new VehiculoTurismo("Mercedes Benz","2021","PLO-9897",5);
			
			for(Vehiculo coche: misVehiculos) {
				System.out.println(coche.mostrarDatosDeVehiculo());
				System.out.println("\n");
			}
			
			
		}

}
