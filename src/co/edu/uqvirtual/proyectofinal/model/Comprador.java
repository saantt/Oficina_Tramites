package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Comprador extends Persona implements Serializable {
   

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
    Vehiculo vehiculo;
    private String ocupacion;
    private String estadoCivil;

  
  

	public Comprador(String usuario, String contraenia, String nombre, String direccion, String cedula, String celular,
			String email, String genero, String preguntaSeguridad, String respuestaSeguridad) {
		super(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, preguntaSeguridad, respuestaSeguridad);
		// TODO Auto-generated constructor stub
	}

	public Comprador(String ocupacion, String estadoCivil, String nombre, String direccion, String cedula, String celular, String email, String genero, String ocupacion2, String estadoCivil2, String preguntaSeguridad, String respuestaSeguridad) {
		super();
		this.ocupacion = ocupacion;
		this.estadoCivil = estadoCivil;
	}

	public Comprador(Vehiculo vehiculo, String ocupacion, String estadoCivil) {
		super();
		this.vehiculo = vehiculo;
		this.ocupacion = ocupacion;
		this.estadoCivil = estadoCivil;
	}

	public Comprador(){

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
        return "Comprador{" +
                "vehiculo=" + vehiculo +
                ", ocupacion='" + ocupacion + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
    public boolean validarExistencia(String usuario, String password) {
		// TODO Auto-generated method stub
		if (this.usuario.equalsIgnoreCase(usuario)&&this.contraenia.equals(password)) {
			return true;
		}
		return false;
	}
}
