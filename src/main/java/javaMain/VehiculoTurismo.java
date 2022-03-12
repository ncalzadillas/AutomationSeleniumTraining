package javaMain;

public class VehiculoTurismo extends Vehiculo {
	
	private int numeroPuertas;
	
	/**
	 * @Description Constructor de Vehiculo Deportivo
	 * @author ncalzadillas
	 * @date 03/12/2022
	 * @param String, String, String, int
	 */
	public VehiculoTurismo(int numeroPuertas, String matricula, String marca, String modelo) {
		super(matricula, marca, modelo);
		this.numeroPuertas=numeroPuertas;
	}
	
	public VehiculoTurismo(String matricula, String marca, String modelo, int numeroPuertas) {
		super(matricula, marca, modelo);
		this.numeroPuertas=numeroPuertas;
	}

	/**
	 * @return the numeroPuertas
	 */
	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	/**
	 * @param numeroPuertas the numeroPuertas to set
	 */
	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	
	@Override
	public String mostrarDatosDeVehiculo() {
		return "Matricula: " + getMatricula() + "\nMarca: " + getMarca() + "\nModelo: " + getModelo() + "\nNumero de Puertas: " 
		+ getNumeroPuertas();
	}

}
