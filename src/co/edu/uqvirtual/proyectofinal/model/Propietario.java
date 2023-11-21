package co.edu.uqvirtual.proyectofinal.model;

import java.io.Serializable;

public class Propietario extends Persona implements Serializable {
	/**
	 *
	 */

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	Vehiculo vehiculo;
	private String ocupacion;
	private String estadoCivil;
	String imagen;

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Propietario(String usuario, String contraenia, String nombre, String direccion, String cedula,
			String celular, String email, String genero, String ocupacion, String estadoCivil, String preguntaSeguridad,
			String respuestaSeguridad) {
		super(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, respuestaSeguridad,
				respuestaSeguridad);
		this.ocupacion = ocupacion;
		this.estadoCivil = estadoCivil;
	}

	public Propietario(String usuario, String contraenia, String nombre, String direccion, String cedula,
			String celular, String email, String genero, String ocupacion, String estadoCivil, String preguntaSeguridad,
			String respuestaSeguridad,String imagen,Vehiculo vehiculo) {
		super(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, respuestaSeguridad,
				respuestaSeguridad);
		this.ocupacion = ocupacion;
		this.estadoCivil = estadoCivil;
		this.imagen = imagen;
		this.vehiculo=vehiculo;
	}
	public Propietario(String usuario, String contraenia, String nombre, String direccion, String cedula,
			String celular, String email, String genero, String ocupacion, String estadoCivil, String preguntaSeguridad,
			String respuestaSeguridad,String imagen) {
		super(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, respuestaSeguridad,
				respuestaSeguridad);
		this.ocupacion = ocupacion;
		this.estadoCivil = estadoCivil;
		this.imagen = imagen;
	
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Propietario() {

	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public String toString() {
		return   nombre ;
	}

	public boolean validarExistencia(String usuario, String password) {
		// TODO Auto-generated method stub
		if (this.usuario.equalsIgnoreCase(usuario) && this.contraenia.equals(password)) {
			return true;
		}
		return false;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraenia() {
		return contraenia;
	}

	public void setContraenia(String contraenia) {
		this.contraenia = contraenia;
	}

	public String getNombre() {
		return nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}
}
