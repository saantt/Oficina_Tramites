package co.edu.uqvirtual.proyectofinal.model;

import java.io.Serializable;

public class Solicitud  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cedulaPropietario;
	String cedulaComprador;
	Ciudades ciudad;
	String placa;

	

	public Solicitud() {
		// TODO Auto-generated constructor stub
	}

	public String getCedulaPropietario() {
		return cedulaPropietario;
	}

	public String getCedulaComprador() {
		return cedulaComprador;
	}

	public Ciudades getCiudad() {
		return ciudad;
	}

	public String getPlaca() {
		return placa;
	}

	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}

	public void setCedulaComprador(String cedulaComprador) {
		this.cedulaComprador = cedulaComprador;
	}

	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Solicitud [cedulaPropietario=" + cedulaPropietario + ", cedulaComprador=" + cedulaComprador
				+ ", ciudad=" + ciudad + ", placa=" + placa + "]";
	}

	public Solicitud(String cedulaPropietario, String cedulaComprador, Ciudades ciudad, String placa) {
		super();
		this.cedulaPropietario = cedulaPropietario;
		this.cedulaComprador = cedulaComprador;
		this.ciudad = ciudad;
		this.placa = placa;
	}

}
