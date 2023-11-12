package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Tramitador extends Persona implements Serializable {
    /**
     *
     */
	
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    Tramite tramite;
    private String salario;
    private String nacionalidad;
    private String educacion;
    private String referencias;

  
    public Tramitador(String usuario, String contraenia, String nombre, String direccion, String cedula, String celular,
			String email, String genero, String preguntaSeguridad, String respuestaSeguridad) {
		super(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, preguntaSeguridad, respuestaSeguridad);
		// TODO Auto-generated constructor stub
	}

	public Tramitador(Tramite tramite, String salario, String nacionalidad, String educacion, String referencias) {
		super();
		this.tramite = tramite;
		this.salario = salario;
		this.nacionalidad = nacionalidad;
		this.educacion = educacion;
		this.referencias = referencias;
	}

	public Tramitador(){

    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    @Override
	public String toString() {
		return   nombre ;
	}
}
