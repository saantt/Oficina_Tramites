package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Moto extends Vehiculo implements Serializable {
    /**
     *
     */
   
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    private String fechaCompra;
    private String cilindraje;
    private String tipoMotor;

    public Moto() {
    }

    public Moto(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa, String seguro, String modelo, String tecnicoMecanica, String kilometraje, String precio, String color, String numeroMotor, String accidentes, String marca, String fechaCompra, String cilindraje, String tipoMotor) {
        super(comprador, sedeTransito, propietario, placa, seguro, modelo, tecnicoMecanica, kilometraje, precio, color, numeroMotor, accidentes, marca);
        this.fechaCompra = fechaCompra;
        this.cilindraje = cilindraje;
        this.tipoMotor = tipoMotor;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
	public String toString() {
		return  placa;
	}
}
