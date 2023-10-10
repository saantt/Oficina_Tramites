package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Propietario extends Persona implements Serializable {
    /**
     *
     */

    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    private String ocupacion;
    private String estadoCivil;

    public Propietario(String usuario, String contraenia, String nombre, String direccion, String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil, String preguntaSeguridad, String respuestaSeguridad) {
        super(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, respuestaSeguridad, respuestaSeguridad);
        this.ocupacion = ocupacion;
        this.estadoCivil = estadoCivil;
    }
    public Propietario(){

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
        return "Propietario{" +
                "ocupacion='" + ocupacion + '\'' +
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
