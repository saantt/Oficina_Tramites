package co.edu.uqvirtual.proyectofinal.model;

import java.io.Serializable;

public class Carro extends Vehiculo implements Serializable {
    /**
     *
     */
    
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    private String multas;
    private String tipoCombustible;
    private String fechaCompra;

    public Carro(){

    }

    public Carro(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa, String seguro, String modelo, String tecnicoMecanica, String kilometraje, String precio, String color, String numeroMotor, String accidentes, String marca, String multas, String tipoCombustible, String fechaCompra) {
        super(comprador, sedeTransito, propietario, placa, seguro, modelo, tecnicoMecanica, kilometraje, precio, color, numeroMotor, accidentes, marca);
        this.multas = multas;
        this.tipoCombustible = tipoCombustible;
        this.fechaCompra = fechaCompra;
    }

    public Carro(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa, String seguro,
			String modelo, String tecnicoMecanica, String kilometraje, String precio, String color, String numeroMotor,
			String accidentes, String marca, String imagen) {
		super(comprador, sedeTransito, propietario, placa, seguro, modelo, tecnicoMecanica, kilometraje, precio, color,
				numeroMotor, accidentes, marca, imagen);
		// TODO Auto-generated constructor stub
	}

	public Carro(Comprador comprador, SedeTransito sedeTransito, Propietario propietario, String placa, String seguro,
			String modelo, String tecnicoMecanica, String kilometraje, String precio, String color, String numeroMotor,
			String accidentes, String marca) {
		super(comprador, sedeTransito, propietario, placa, seguro, modelo, tecnicoMecanica, kilometraje, precio, color,
				numeroMotor, accidentes, marca);
		// TODO Auto-generated constructor stub
	}

	public String getMultas() {
        return multas;
    }

    public void setMultas(String multas) {
        this.multas = multas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
	public String toString() {
		return  placa;
	}
}
