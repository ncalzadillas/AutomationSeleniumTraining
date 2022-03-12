package javaMain;

public class VehiculoDeportivo extends Vehiculo {
	
	private int cilindrada;
	
	/**
	 * @Description Constructor de Vehiculo Deportivo
	 * @author ncalzadillas
	 * @date 03/12/2022
	 * @param String, String, String, int
	 */
	public VehiculoDeportivo(String matricula, String marca, String modelo, int cilindrada) {
		super(matricula, marca, modelo);
		this.cilindrada=cilindrada;
		
	}

	/**
	 * @return the cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * @param cilindrada the cilindrada to set
	 */
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	@Override
	public String mostrarDatosDeVehiculo() {
		return "Matricula: " + getMatricula() + "\nMarca: " + getMarca() + "\nModelo: " + getModelo() + "\nCilindrada: " 
	    + getCilindrada();
	}

}
