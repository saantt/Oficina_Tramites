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

    public SedeTransito(Comprador comprador, Tramitador tramitador, Secretaria secretaria, Vehiculo vehiculo, Ciudades ciudades) {
        this.comprador = comprador;
        this.tramitador = tramitador;
        this.secretaria = secretaria;
        this.vehiculo = vehiculo;
        this.ciudades = ciudades;
    }
    public SedeTransito(){

    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    @Override
    public String toString() {
        return "SedeTransito{" +
                "comprador=" + comprador +
                ", tramitador=" + tramitador +
                ", secretaria=" + secretaria +
                ", vehiculo=" + vehiculo +
                ", ciudades=" + ciudades +
                '}';
    }
}
