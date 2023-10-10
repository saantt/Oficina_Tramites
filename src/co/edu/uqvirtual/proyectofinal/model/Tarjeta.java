package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Tarjeta implements Serializable {
    /**
     *
     */
    
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    Vehiculo vehiculo;
    Propietario propietario;

    public Tarjeta() {
    }

    public Tarjeta(Vehiculo vehiculo, Propietario propietario) {
        this.vehiculo = vehiculo;
        this.propietario = propietario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "vehiculo=" + vehiculo +
                ", propietario=" + propietario +
                '}';
    }
}
