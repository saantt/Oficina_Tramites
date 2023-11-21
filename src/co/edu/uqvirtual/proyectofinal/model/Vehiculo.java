package co.edu.uqvirtual.proyectofinal.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {
	/**
	 *
	 */

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	Comprador comprador;
	SedeTransito sedeTransito;
	Propietario propietario;
	protected String placa;
	private String seguro;
	private String modelo;
	private String tecnicoMecanica;
	private String kilometraje;
	private String precio;
	private String color;
	private String numeroMotor;
	private String accidentes;
	private String marca;
	private String imagen;

	public Vehiculo() {
		this.propietario = new Propietario();
		this.comprador = new Comprador();
	}

	public Vehiculo(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa,
			String seguro, String modelo, String tecnicoMecanica, String kilometraje, String precio, String color,
			String numeroMotor, String accidentes, String marca) {
		this.comprador = comprador;
		this.sedeTransito = sedeTransito;
		this.propietario = propietario;
		this.placa = placa;
		this.seguro = seguro;
		this.modelo = modelo;
		this.tecnicoMecanica = tecnicoMecanica;
		this.kilometraje = kilometraje;
		this.precio = precio;
		this.color = color;
		this.numeroMotor = numeroMotor;
		this.accidentes = accidentes;
		this.marca = marca;
	}

	public Vehiculo(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa,
			String seguro, String modelo, String tecnicoMecanica, String kilometraje, String precio, String color,
			String numeroMotor, String accidentes, String marca, String imagen) {
		super();
		this.comprador = comprador;
		this.sedeTransito = sedeTransito;
		this.propietario = propietario;
		this.placa = placa;
		this.seguro = seguro;
		this.modelo = modelo;
		this.tecnicoMecanica = tecnicoMecanica;
		this.kilometraje = kilometraje;
		this.precio = precio;
		this.color = color;
		this.numeroMotor = numeroMotor;
		this.accidentes = accidentes;
		this.marca = marca;
		this.imagen = imagen;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public SedeTransito getSedeTransito() {
		return sedeTransito;
	}

	public void setSedeTransito(SedeTransito sedeTransito) {
		this.sedeTransito = sedeTransito;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTecnicoMecanica() {
		return tecnicoMecanica;
	}

	public void setTecnicoMecanica(String tecnicoMecanica) {
		this.tecnicoMecanica = tecnicoMecanica;
	}

	public String getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public String getAccidentes() {
		return accidentes;
	}

	public void setAccidentes(String accidentes) {
		this.accidentes = accidentes;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return  placa;
	}

	public boolean validarPropietario(String cedulaPropietario) {
		// TODO Auto-generated method stub
		if (cedulaPropietario.equalsIgnoreCase(this.getPropietario().getCedula())) {
			return true;
		}
		return false;
	}
}
