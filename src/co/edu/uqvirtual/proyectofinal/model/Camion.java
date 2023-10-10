package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Camion extends Vehiculo implements Serializable {
    /**
     *
     */
    
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    private String tipoCombustible;
    private String capacidadCarga;
    private String añoFabricacion;

    public Camion() {
    }

    public Camion(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa, String seguro, String modelo, String tecnicoMecanica, String kilometraje, String precio, String color, String numeroMotor, String accidentes, String marca, String tipoCombustible, String capacidadCarga, String añoFabricacion) {
        super(comprador, sedeTransito, propietario, placa, seguro, modelo, tecnicoMecanica, kilometraje, precio, color, numeroMotor, accidentes, marca);
        this.tipoCombustible = tipoCombustible;
        this.capacidadCarga = capacidadCarga;
        this.añoFabricacion = añoFabricacion;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(String capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(String añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "tipoCombustible='" + tipoCombustible + '\'' +
                ", capacidadCarga='" + capacidadCarga + '\'' +
                ", añoFabricacion='" + añoFabricacion + '\'' +
                '}';
    }
}
