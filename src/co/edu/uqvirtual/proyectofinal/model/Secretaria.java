package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Secretaria extends Persona implements Serializable {
    /**
     *
     */
	
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    private String salario;
    private String educacion;
    private String nacionalidad;
    private String discapacidad;
    private String estadoCivil;
    private String certificaciones;
    SedeTransito sedeTransito;

public Secretaria(){

}

   

    public Secretaria(String usuario, String contraenia, String nombre, String direccion, String cedula, String celular,
		String email, String genero, String preguntaSeguridad, String respuestaSeguridad) {
	super(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, preguntaSeguridad, respuestaSeguridad);
	// TODO Auto-generated constructor stub
}



	public Secretaria(String salario, String educacion, String nacionalidad, String discapacidad, String estadoCivil,
			String certificaciones, SedeTransito sedeTransito) {
		super();
		this.salario = salario;
		this.educacion = educacion;
		this.nacionalidad = nacionalidad;
		this.discapacidad = discapacidad;
		this.estadoCivil = estadoCivil;
		this.certificaciones = certificaciones;
		this.sedeTransito = sedeTransito;
	}



	public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }

    public SedeTransito getSedeTransito() {
        return sedeTransito;
    }

    public void setSedeTransito(SedeTransito sedeTransito) {
        this.sedeTransito = sedeTransito;
    }

    @Override
	public String toString() {
		return   nombre ;
	}
}
