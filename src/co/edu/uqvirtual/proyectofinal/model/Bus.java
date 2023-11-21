package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Bus extends Vehiculo implements Serializable {
    /**
     *
     */
    
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    private String capacidad;
    private String tipoCombustible;
    private String tipoBus;

    public Bus() {
    }

    public Bus(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa, String seguro, String modelo, String tecnicoMecanica, String kilometraje, String precio, String color, String numeroMotor, String accidentes, String marca, String capacidad, String tipoCombustible, String tipoBus) {
        super(comprador, sedeTransito, propietario, placa, seguro, modelo, tecnicoMecanica, kilometraje, precio, color, numeroMotor, accidentes, marca);
        this.capacidad = capacidad;
        this.tipoCombustible = tipoCombustible;
        this.tipoBus = tipoBus;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipoBus() {
        return tipoBus;
    }

    public void setTipoBus(String tipoBus) {
        this.tipoBus = tipoBus;
    }

    @Override
	public String toString() {
		return  placa;
	}
   
}
