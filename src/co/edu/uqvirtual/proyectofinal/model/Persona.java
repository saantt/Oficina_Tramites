package co.edu.uqvirtual.proyectofinal.model;


import java.io.Serializable;

public class Persona implements Serializable {

    /**
     *
     */
	
    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    public String usuario;
    public String contraenia;
    public String nombre;
    public String direccion;
    public String cedula;
    public String celular;
    public String email;
    public String genero;
    public String preguntaSeguridad;
    public String respuestaSeguridad;

    public Persona() {
    }

	public Persona(String usuario, String contraenia, String nombre, String direccion, String cedula, String celular,
			String email, String genero, String preguntaSeguridad, String respuestaSeguridad) {
		super();
		this.usuario = usuario;
		this.contraenia = contraenia;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cedula = cedula;
		this.celular = celular;
		this.email = email;
		this.genero = genero;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuestaSeguridad = respuestaSeguridad;
	}

	@Override
	public String toString() {
		return "Persona [usuario=" + usuario + ", contraenia=" + contraenia + ", nombre=" + nombre + ", direccion="
				+ direccion + ", cedula=" + cedula + ", celular=" + celular + ", email=" + email + ", genero=" + genero
				+ ", preguntaSeguridad=" + preguntaSeguridad + ", respuestaSeguridad=" + respuestaSeguridad + "]";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraenia() {
		return contraenia;
	}

	public void setContraenia(String contraenia) {
		this.contraenia = contraenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

   
}
