package co.edu.uqvirtual.proyectofinal.controllers;


import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Oficina;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.services.lModelFactoryService;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import co.edu.uqvirtual.proyectofinal.persistence.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController implements lModelFactoryService,Runnable {
	public Oficina oficina;
	String mensajelog = "";
	String nombrelog = "";

	Propietario propietarioActual;

	Comprador compradorActual;

	Thread hiloServicioGuardarLog;
	private static class SingletonHolder {

		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	@Override
	public void run() {
		
		 Thread currentThread = Thread.currentThread();
	        if (hiloServicioGuardarLog == currentThread) {
	            Persistencia.guardaRegistroLog(mensajelog, 1, nombrelog);

	        }
	}

	public ModelFactoryController() {

		inicializarDatos();
		if (oficina == null) {
			cargarRecursoXML();
		}

	}

	private void inicializarDatos() {
		oficina = new Oficina();
		
		cargarRecursoXML();
		Comprador comprador = new Comprador();
		comprador.setNombre("Santiago");
		comprador.setCedula("1004961129");
		comprador.setCelular("3128864250");
		comprador.setContraenia("Santiago05$");
		comprador.setDireccion("Ciuadela Comfenalco mz H39");
		comprador.setEmail("sgomeeez05@gmail.com");
		comprador.setEstadoCivil("Soltero");
		comprador.setGenero("Hombre");
		comprador.setOcupacion("Estudiante");
		comprador.setUsuario("Santt");
		comprador.setPreguntaSeguridad("¿Cuantos años tengo?");
		comprador.setRespuestaSeguridad("20");
		
		Propietario propietario = new Propietario();
		propietario.setNombre("Carlos");
		propietario.setCedula("233333");
		propietario.setCelular("345555");
		propietario.setContraenia("Santiago05$");
		propietario.setDireccion("Ciuadela Comfenalco mz H39");
		propietario.setEmail("Santiagomaring05@gmail.com");
		propietario.setEstadoCivil("Soltero");
		propietario.setGenero("Hombre");
		propietario.setOcupacion("Estudiante");
		propietario.setUsuario("carr");
		propietario.setPreguntaSeguridad("¿Cuantos años tengo?");
		propietario.setRespuestaSeguridad("20");
		
		oficina.getListaPropietario().add(propietario);
		oficina.getListaComprador().add(comprador);
		 //guardarXML();
	}

	private void cargarRecursoXML() {
		// TODO Auto-generated method stub
		Persistencia.cargarRecursoBancoXML();

	}

	public void guardarXML() {

		Persistencia.guardarRecursoBancoXML(oficina);
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public Propietario getPropietarioActual() {
		return propietarioActual;
	}

	public void setPropietarioActual(Propietario propietarioActual) {
		this.propietarioActual = propietarioActual;
	}

	public Comprador getCompradorActual() {
		return compradorActual;
	}

	public void setCompradorActual(Comprador compradorActual) {
		this.compradorActual = compradorActual;
	}

	// -----------PROPIETARIO-------------------
	@Override
	public Propietario crearPropietario(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad)
			throws IOException, ClassNotFoundException {
		mensajelog = "";
		nombrelog = "";

		Propietario propietario = oficina.crearPropietario(usuario, contraenia, nombre, direccion, cedula, celular,
				email, genero, ocupacion, estadoCivil,preguntaSeguridad,respuestaSeguridad);
		Persistencia.guardarRecursoBancoXML(oficina);

		if (propietario != null) {
			mensajelog += "se guardo el propietario satisfactorimente";
			nombrelog = propietario.getNombre().toUpperCase();
		} else {
			mensajelog += "no se guardo el propietario";
			nombrelog = nombre;
		}
		hiloServicioGuardarLog = new Thread(this);
        hiloServicioGuardarLog.start();

		return propietario;
	}

	@Override
	public Propietario obtenerPropietario(String idPropietario) {

		Propietario propietario;
		propietario = getOficina().obtenerPropietario(idPropietario);
		// TODO Auto-generated method stub
		return propietario;
	}

	@Override
	public Boolean verificarPropietarioExistente(String cedula) {

		boolean propietario = false;

		propietario = getOficina().verificarPropietarioExistente(cedula);
		// TODO Auto-generated method stub
		return propietario;
	}

	@Override
	public ArrayList<Propietario> obtenerPropietarioss() {
		// TODO Auto-generated method stub
		return getOficina().obtenerPropietarios();
	}
	// --------------COMPRADOR-----------------------------------

	@Override
	public Comprador crearComprador(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad) {
		mensajelog = "";
		nombrelog = "";
		Comprador comprador = null;
		try {

			comprador = getOficina().crearComprador(usuario, contraenia, nombre, direccion, cedula, celular, email,
					genero, ocupacion, estadoCivil,respuestaSeguridad,preguntaSeguridad);
			Persistencia.guardarRecursoBancoXML(oficina);

			if (comprador != null) {
				mensajelog += "se guardo el Comprador satisfactorimente";
				nombrelog = comprador.getNombre().toUpperCase();
			} else {
				mensajelog += "no se guardo el Comprador";
				nombrelog = nombre;
			}

			hiloServicioGuardarLog = new Thread(this);
	        hiloServicioGuardarLog.start();
			return comprador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Comprador obtenerComprador(String idComprador) {

		Comprador comprador;

		comprador = getOficina().obtenerComprador(idComprador);
		// TODO Auto-generated method stub
		return comprador;
	}

	@Override
	public Boolean verificarCompradorExistente(String cedula) {

		boolean comprador = false;

		comprador = getOficina().verificarCompradorExistente(cedula);
		// TODO Auto-generated method stub
		return comprador;
	}

	@Override
	public ArrayList<Comprador> obtenerCompradors() {
		// TODO Auto-generated method stub
		return getOficina().obtenerCompradors();
	}
	// -----------------------INGRESOS-------------------------------------

	public Propietario validarIngresoPropietario(String usuario, String contrasena) {

		mensajelog = "";
		nombrelog = "";
		Propietario propietario = null;

		propietario = getOficina().validarPropietario(usuario, contrasena);
		if (propietario != null) {
			setPropietarioActual(propietario);
			mensajelog += "ingreso el Propietario  " + propietario.getUsuario();
			nombrelog = propietario.getUsuario();
		} else {
			mensajelog += "no pudo ingresor el Propietario";
			nombrelog = usuario;
		}

		hiloServicioGuardarLog = new Thread(this);
        hiloServicioGuardarLog.start();

		return propietario;
	}

	public Comprador validarIngresoComprador(String usuario, String contraseña) {

		mensajelog = "";
		nombrelog = "";
		Comprador comprador = null;

		comprador = oficina.validarIngresoComprador(usuario, contraseña);
		if (comprador != null) {
			setCompradorActual(comprador);
			mensajelog += "ingreso el Comprador  " + comprador.getUsuario();
			nombrelog = comprador.getUsuario();
		} else {
			mensajelog += "no pudo ingresor el Comprador";
			nombrelog = usuario;
		}

		hiloServicioGuardarLog = new Thread(this);
        hiloServicioGuardarLog.start();
		return comprador;
	}

	public Propietario obtenerPropietarioActual(Propietario propietario) {
		// TODO Auto-generated method stub
		for (Propietario anuncianteEncontrado : oficina.getListaPropietario()) {
			if (anuncianteEncontrado.getUsuario().equalsIgnoreCase(propietario.getUsuario())
					&& anuncianteEncontrado.getContraenia().equalsIgnoreCase(propietario.getContraenia())) {
				return anuncianteEncontrado;
			}
		}

		return null;
	}

	public Comprador obtenerCompradorActual(Comprador comprador) {
		// TODO Auto-generated method stub
		for (Comprador compradorEncontrado : oficina.getListaComprador()) {
			if (compradorEncontrado.getUsuario().equalsIgnoreCase(comprador.getUsuario())
					&& compradorEncontrado.getContraenia().equalsIgnoreCase(comprador.getContraenia())) {
				return compradorEncontrado;
			}
		}

		return null;
	}

	public void guardarDatoSubasta(Oficina subasta) {
		// TODO Auto-generated method stub
		if (subasta != null) {
			oficina = subasta;
			Persistencia.guardarRecursoBancoXML(oficina);
		}
	}
	public Comprador validarCorreoRecuperacionComprador(String correo) {
		// TODO Auto-generated method stub
		Comprador encontrado=null;

		encontrado=oficina.validarCorreoComprador(correo);
		if(encontrado!=null){
			return encontrado;
		}

		return null;
	}
	public Propietario validarCorreoRecuperacionPropietario(String correo) {
		// TODO Auto-generated method stub
		Propietario encontrado=null;

		encontrado=oficina.validarCorreoPropietario(correo);
		if(encontrado!=null){
			return encontrado;
		}

		return null;
	}
	public Comprador cambiarPaswordComprador(String identificacion,String password) throws Exception  {
		// TODO Auto-generated method stub
		Comprador encontrado=null;
		encontrado=oficina.cambiarPasswordComprador(identificacion,password);
		if(encontrado!=null){
			return encontrado;
		}
		return null;
	}
	public Propietario cambiarPaswordPropietario(String identificacion,String password) throws Exception  {
		// TODO Auto-generated method stub
		Propietario encontrado=null;
		encontrado=oficina.cambiarPasswordPropietario(identificacion,password);
		if(encontrado!=null){
			return encontrado;
		}
		return null;
	}


	

}
