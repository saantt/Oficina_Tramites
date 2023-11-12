package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class SedeTransito implements Serializable {
    /**
     *
     */
    
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    Comprador comprador;
    Tramitador tramitador;
    Secretaria secretaria;
    Vehiculo vehiculo;
    Ciudades ciudades;
    Propietario propietario;

    
    @Override
	public String toString() {
		return  ""+ciudades ;
	}

	public SedeTransito(Comprador comprador, Tramitador tramitador, Secretaria secretaria, Vehiculo vehiculo,
			Ciudades ciudades, Propietario propietario) {
		super();
		this.comprador = comprador;
		this.tramitador = tramitador;
		this.secretaria = secretaria;
		this.vehiculo = vehiculo;
		this.ciudades = ciudades;
		this.propietario = propietario;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Comprador getComprador() {
		return comprador;
	}


	public Tramitador getTramitador() {
		return tramitador;
	}


	public Secretaria getSecretaria() {
		return secretaria;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public Ciudades getCiudades() {
		return ciudades;
	}


	public Propietario getPropietario() {
		return propietario;
	}


	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}


	public void setTramitador(Tramitador tramitador) {
		this.tramitador = tramitador;
	}


	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public void setCiudades(Ciudades ciudades) {
		this.ciudades = ciudades;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public SedeTransito(){

    }

}
