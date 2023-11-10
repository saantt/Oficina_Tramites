package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Tramite implements Serializable {
    /**
     *
     */
    
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    Tramitador tramitador;
    Secretaria secretaria;
    Propietario propietario;
    Comprador comprador;
    Vehiculo vehiculo;
    SedeTransito sedeTransito;
    Tarjeta tarjeta;

    public Tramite(Tramitador tramitador, Secretaria secretaria, Propietario propietario, Comprador comprador, Vehiculo vehiculo, SedeTransito sedeTransito, Tarjeta tarjeta) {
        this.tramitador = tramitador;
        this.secretaria = secretaria;
        this.propietario = propietario;
        this.comprador = comprador;
        this.vehiculo = vehiculo;
        this.sedeTransito = sedeTransito;
        this.tarjeta = tarjeta;
    }

    public Tramite(Tramitador tramitador, Secretaria secretaria, Propietario propietario, Comprador comprador,
			Vehiculo vehiculo, SedeTransito sedeTransito) {
		super();
		this.tramitador = tramitador;
		this.secretaria = secretaria;
		this.propietario = propietario;
		this.comprador = comprador;
		this.vehiculo = vehiculo;
		this.sedeTransito = sedeTransito;
	}

	public Tramite() {
    }

    public Tramitador getTramitador() {
        return tramitador;
    }

    public void setTramitador(Tramitador tramitador) {
        this.tramitador = tramitador;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public SedeTransito getSedeTransito() {
        return sedeTransito;
    }

    public void setSedeTransito(SedeTransito sedeTransito) {
        this.sedeTransito = sedeTransito;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "Tramite{" +
                "tramitador=" + tramitador +
                ", secretaria=" + secretaria +
                ", propietario=" + propietario +
                ", comprador=" + comprador +
                ", vehiculo=" + vehiculo +
                ", sedeTransito=" + sedeTransito +
                ", tarjeta=" + tarjeta +
                '}';
    }
}
