package co.edu.uqvirtual.proyectofinal.controllers;

import co.edu.uqvirtual.proyectofinal.model.Carro;
import co.edu.uqvirtual.proyectofinal.model.Ciudades;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Oficina;
import co.edu.uqvirtual.proyectofinal.model.Persona;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Secretaria;
import co.edu.uqvirtual.proyectofinal.model.SedeTransito;
import co.edu.uqvirtual.proyectofinal.model.Tarjeta;
import co.edu.uqvirtual.proyectofinal.model.Tramitador;
import co.edu.uqvirtual.proyectofinal.model.Tramite;
import co.edu.uqvirtual.proyectofinal.model.services.lModelFactoryService;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import co.edu.uqvirtual.proyectofinal.persistence.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController implements lModelFactoryService, Runnable {
	public Oficina oficina;
	String mensajelog = "";
	String nombrelog = "";

	Ciudades ciudades;
	Propietario propietarioActual;

	Comprador compradorActual;

	Tramitador tramitadorActual;

	Persona personaActual;

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

		// cargarRecursoXML();
		Comprador comprador = new Comprador();
		comprador.setNombre("Camila Hernandez");
		comprador.setCedula("1104544039");
		comprador.setCelular("3216040238");
		comprador.setContraenia("Santiago05$");
		comprador.setDireccion("Torre Verde");
		comprador.setEmail("camilahernandezpena@gmail.com");
		comprador.setEstadoCivil("Soltero");
		comprador.setGenero("Hombre");
		comprador.setOcupacion("Estudiante");
		comprador.setUsuario("Santt");
		comprador.setPreguntaSeguridad("¿parcial?");
		comprador.setRespuestaSeguridad("2");

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

		Tramitador tramitador = new Tramitador();
		tramitador.setNombre("Andres");
		tramitador.setCedula("10092833");
		tramitador.setCelular("31283378393");
		tramitador.setContraenia("Andress05$");
		tramitador.setDireccion("Ciuadela Comfenalco mz H39");
		tramitador.setEmail("Santiagomaring05@gmail.com");
		tramitador.setSalario("100000000");
		tramitador.setGenero("Hombre");
		tramitador.setNacionalidad("Colombiano");
		tramitador.setUsuario("andress");
		tramitador.setEducacion("Basica");
		tramitador.setReferencias("No tiene");
		tramitador.setPreguntaSeguridad("¿Cuantos años tengo?");
		tramitador.setRespuestaSeguridad("20");

		Secretaria secretaria = new Secretaria();
		secretaria.setNombre("Sofia");
		secretaria.setCedula("29202829");
		secretaria.setCelular("129383839");
		secretaria.setContraenia("Sofiaass05$");
		secretaria.setDireccion("Ciuadela Comfenalco mz H39");
		secretaria.setEmail("Santiagomaring05@gmail.com");
		secretaria.setSalario("100000000");
		secretaria.setGenero("Mujer");
		secretaria.setNacionalidad("Colombiano");
		secretaria.setUsuario("sofiaa");
		secretaria.setEducacion("Basica");
		secretaria.setDiscapacidad("No tiene");
		secretaria.setEstadoCivil("Soltera");
		secretaria.setCertificaciones("No tiene");
		secretaria.setPreguntaSeguridad("¿Cuantos años tengo?");
		secretaria.setRespuestaSeguridad("20");

		Carro carro = new Carro();
		carro.setAccidentes("NO");
		carro.setColor("Negro");
		carro.setComprador(comprador);
		carro.setFechaCompra("11/11/23");
		carro.setKilometraje("1200");
		carro.setMarca("Mercedes");
		carro.setModelo("2023");
		carro.setMultas("NO");
		carro.setNumeroMotor("12922229999");
		carro.setPlaca("JKL909");
		carro.setPrecio("1090000000");
		carro.setPropietario(propietario);
		carro.setSeguro("SI");
		carro.setTecnicoMecanica("SI");
		carro.setTipoCombustible("DIESEL");
		comprador.setVehiculo(carro);

		SedeTransito sede = new SedeTransito();
		sede.setCiudades(ciudades.ARMENIA);
		sede.setComprador(comprador);
		sede.setSecretaria(secretaria);
		sede.setTramitador(tramitador);
		sede.setPropietario(propietario);
		sede.setVehiculo(carro);
		carro.setSedeTransito(sede);
		

		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setPropietario(propietario);
		tarjeta.setVehiculo(carro);

		Tramite tramite = new Tramite();
		tramite.setComprador(comprador);
		tramite.setPropietario(propietario);
		tramite.setSecretaria(secretaria);
		tramite.setSedeTransito(sede);
		tramite.setTarjeta(tarjeta);
		tramite.setTramitador(tramitador);
		tramite.setVehiculo(carro);

		Comprador comprador1 = new Comprador();
		comprador1.setNombre("Raul ");
		comprador1.setCedula("85555222");
		comprador1.setCelular("3128028428");
		comprador1.setContraenia("OrlandoDia05$");
		comprador1.setDireccion("Barrio la milagrosa");
		comprador1.setEmail("ryrivera@uniquindio.edu.co");
		comprador1.setEstadoCivil("Soltero");
		comprador1.setGenero("Hombre");
		comprador1.setOcupacion("Estudiante");
		comprador1.setUsuario("Santt");
		comprador1.setPreguntaSeguridad("¿En que Parcial Estamos?");
		comprador1.setRespuestaSeguridad("3");

		Propietario propietario1 = new Propietario();
		propietario1.setNombre("Alfredo");
		propietario1.setCedula("122333322");
		propietario1.setCelular("3123444444");
		propietario1.setContraenia("Santiago05$");
		propietario1.setDireccion("Ciuadela Comfenalco mz H39");
		propietario1.setEmail("Santiagomaring05@gmail.com");
		propietario1.setEstadoCivil("Casado");
		propietario1.setGenero("Hombre");
		propietario1.setOcupacion("Profesor");
		propietario1.setUsuario("Alfred");
		propietario1.setPreguntaSeguridad("¿Cuantos años tengo?");
		propietario1.setRespuestaSeguridad("24");

		Tramitador tramitador1 = new Tramitador();
		tramitador1.setNombre("Edwin");
		tramitador1.setCedula("33444444");
		tramitador1.setCelular("31283378393");
		tramitador1.setContraenia("Edwinnn05$");
		tramitador1.setDireccion("Ciuadela Comfenalco mz H39");
		tramitador1.setEmail("Santiagomaring05@gmail.com");
		tramitador1.setSalario("100000000");
		tramitador1.setGenero("Hombre");
		tramitador1.setNacionalidad("Colombiano");
		tramitador1.setUsuario("Edwin");
		tramitador1.setEducacion("Basica");
		tramitador1.setReferencias("No tiene");
		tramitador1.setPreguntaSeguridad("¿Cuantos años tengo?");
		tramitador1.setRespuestaSeguridad("56");

		Secretaria secretaria1 = new Secretaria();
		secretaria1.setNombre("Andrea");
		secretaria1.setCedula("29202829");
		secretaria1.setCelular("129383839");
		secretaria1.setContraenia("Andreass90$");
		secretaria1.setDireccion("Ciuadela Comfenalco mz H39");
		secretaria1.setEmail("Santiagomaring05@gmail.com");
		secretaria1.setSalario("100000000");
		secretaria1.setGenero("Mujer");
		secretaria1.setNacionalidad("Colombiano");
		secretaria1.setUsuario("Andreea");
		secretaria1.setEducacion("Basica");
		secretaria1.setDiscapacidad("No tiene");
		secretaria1.setEstadoCivil("Soltera");
		secretaria1.setCertificaciones("No tiene");
		secretaria1.setPreguntaSeguridad("¿Cuantos años tengo?");
		secretaria1.setRespuestaSeguridad("20");

		Carro carro1 = new Carro();
		carro1.setAccidentes("NO");
		carro1.setColor("Azul");
		carro1.setComprador(comprador);
		carro1.setFechaCompra("11/11/23");
		carro1.setKilometraje("1200");
		carro1.setMarca("Mazda");
		carro1.setModelo("2023");
		carro1.setMultas("NO");
		carro1.setNumeroMotor("12922229999");
		carro1.setPlaca("JQK000");
		carro1.setPrecio("1090000000");
		carro1.setPropietario(propietario);
		carro1.setSeguro("SI");
		carro1.setTecnicoMecanica("SI");
		carro1.setTipoCombustible("GASOLINA");
		comprador1.setVehiculo(carro1);

		SedeTransito sede1 = new SedeTransito();
		sede1.setCiudades(ciudades.BUCARAMANGA);
		sede1.setComprador(comprador1);
		sede1.setSecretaria(secretaria1);
		sede1.setTramitador(tramitador1);
		sede1.setPropietario(propietario1);
		sede1.setVehiculo(carro1);
		carro1.setSedeTransito(sede1);

		Tarjeta tarjeta1 = new Tarjeta();
		tarjeta1.setPropietario(propietario1);
		tarjeta1.setVehiculo(carro1);

		Tramite tramite1 = new Tramite();
		tramite1.setComprador(comprador1);
		tramite1.setPropietario(propietario1);
		tramite1.setSecretaria(secretaria1);
		tramite1.setSedeTransito(sede1);
		tramite1.setTarjeta(tarjeta1);
		tramite1.setTramitador(tramitador1);
		tramite1.setVehiculo(carro1);
		
		
		
		oficina.getListaTramiteSecretaria().add(tramite);
		oficina.getListaTramite().add(tramite);
		oficina.getListaTarjeta().add(tarjeta);
		oficina.getListaVehiculo().add(carro);
		
		oficina.getListaSedes().add(sede);
		oficina.getListaPersona().add(secretaria);
		oficina.getListaTramitador().add(tramitador);
		oficina.getListaPropietario().add(propietario);
		oficina.getListaComprador().add(comprador);
		oficina.getListaTramite().add(tramite1);
		oficina.getListaTramiteSecretaria().add(tramite1);
		oficina.getListaTarjeta().add(tarjeta1);
		oficina.getListaVehiculo().add(carro1);
		oficina.getListaSedes().add(sede1);
		oficina.getListaPersona().add(secretaria1);
		oficina.getListaTramitador().add(tramitador1);
		oficina.getListaPropietario().add(propietario1);
		oficina.getListaComprador().add(comprador1);
		guardarXML();

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

	public Tramitador getTramitadorActual() {
		return tramitadorActual;
	}

	public Persona getPersonaActual() {
		return personaActual;
	}

	public void setTramitadorActual(Tramitador tramitadorActual) {
		this.tramitadorActual = tramitadorActual;
	}

	public void setPersonaActual(Persona personaActual) {
		this.personaActual = personaActual;
	}

	// -----------PROPIETARIO-------------------
	@Override
	public Propietario crearPropietario(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,
			String preguntaSeguridad, String respuestaSeguridad) throws IOException, ClassNotFoundException {
		mensajelog = "";
		nombrelog = "";

		Propietario propietario = oficina.crearPropietario(usuario, contraenia, nombre, direccion, cedula, celular,
				email, genero, ocupacion, estadoCivil, preguntaSeguridad, respuestaSeguridad);
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
	public Comprador crearComprador(String usuario, String contraenia, String nombre, String direccion, String cedula,
			String celular, String email, String genero, String ocupacion, String estadoCivil, String preguntaSeguridad,
			String respuestaSeguridad) {
		mensajelog = "";
		nombrelog = "";
		Comprador comprador = null;
		try {

			comprador = getOficina().crearComprador(usuario, contraenia, nombre, direccion, cedula, celular, email,
					genero, ocupacion, estadoCivil, respuestaSeguridad, preguntaSeguridad);
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

	public Tramitador obtenerTramitadorActual(Tramitador comprador) {
		// TODO Auto-generated method stub
		for (Tramitador compradorEncontrado : oficina.getListaTramitador()) {
			if (compradorEncontrado.getUsuario().equalsIgnoreCase(comprador.getUsuario())
					&& compradorEncontrado.getContraenia().equalsIgnoreCase(comprador.getContraenia())) {
				return compradorEncontrado;
			}
		}

		return null;
	}

	public Persona obtenerSecretariaActual(Persona comprador) {
		// TODO Auto-generated method stub
		for (Persona compradorEncontrado : oficina.getListaPersona()) {
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
		Comprador encontrado = null;

		encontrado = oficina.validarCorreoComprador(correo);
		if (encontrado != null) {
			return encontrado;
		}

		return null;
	}

	public Propietario validarCorreoRecuperacionPropietario(String correo) {
		// TODO Auto-generated method stub
		Propietario encontrado = null;

		encontrado = oficina.validarCorreoPropietario(correo);
		if (encontrado != null) {
			return encontrado;
		}

		return null;
	}

	public Comprador cambiarPaswordComprador(String identificacion, String password) throws Exception {
		// TODO Auto-generated method stub
		Comprador encontrado = null;
		encontrado = oficina.cambiarPasswordComprador(identificacion, password);
		if (encontrado != null) {
			return encontrado;
		}
		return null;
	}

	public Propietario cambiarPaswordPropietario(String identificacion, String password) throws Exception {
		// TODO Auto-generated method stub
		Propietario encontrado = null;
		encontrado = oficina.cambiarPasswordPropietario(identificacion, password);
		if (encontrado != null) {
			return encontrado;
		}
		return null;
	}

	public Tramitador obtenerTramitador(String idPropietario) {

		Tramitador propietario;
		propietario = getOficina().obtenerTramitador(idPropietario);
		// TODO Auto-generated method stub
		return propietario;
	}

	public Boolean verificarTramitadorExistente(String cedula) {

		boolean propietario = false;

		propietario = getOficina().verificarPropietarioExistente(cedula);
		// TODO Auto-generated method stub
		return propietario;
	}

	public ArrayList<Tramitador> obtenerTramitadoress() {
		// TODO Auto-generated method stub
		return getOficina().obtenerTramitadores();
	}

	public Persona obtenerSecretaria(String idPropietario) {

		Persona propietario;
		propietario = getOficina().obtenerSecretaria(idPropietario);
		// TODO Auto-generated method stub
		return propietario;
	}

	public Boolean verificarSecretariaExistente(String cedula) {

		boolean propietario = false;

		propietario = getOficina().verificarSecretariaExistente(cedula);
		// TODO Auto-generated method stub
		return propietario;
	}

	public ArrayList<Persona> obtenerSecretariass() {
		// TODO Auto-generated method stub
		return getOficina().obtenerSecretarias();
	}
	
	public ArrayList<SedeTransito> obtenerSedess() {
		// TODO Auto-generated method stub
		return getOficina().obtenerSedes();
	}

	public Vehiculo obtenerVehiculo(String idPropietario) {

		Vehiculo propietario;
		propietario = getOficina().obtenerVehiculo(idPropietario);
		// TODO Auto-generated method stub
		return propietario;
	}

	public Boolean verificarVehiculoExistente(String cedula) {

		boolean propietario = false;

		propietario = getOficina().verificarVehiculoExistente(cedula);
		// TODO Auto-generated method stub
		return propietario;
	}

	public ArrayList<Vehiculo> obtenerVehiculoss() {
		// TODO Auto-generated method stub
		return getOficina().obtenerVehiculos();
	}

	public Tramite obtenerTramite(String idPropietario) {

		Tramite propietario;
		propietario = getOficina().obtenerTramite(idPropietario);
		// TODO Auto-generated method stub
		return propietario;
	}

	public Boolean verificarTramiteExistente(String cedula) {

		boolean propietario = false;

		propietario = getOficina().verificarTramiteExistente(cedula);
		// TODO Auto-generated method stub
		return propietario;
	}

	public ArrayList<Tramite> obtenerTramitess() {
		// TODO Auto-generated method stub
		return getOficina().obtenerTramites();
	}
	
	public ArrayList<Tramite> obtenerTramitesRealizados() {
		// TODO Auto-generated method stub
		return getOficina().obtenerTramitesRealizados();
	}
	
	public ArrayList<Tramite> obtenerTramitesSecretaria() {
		// TODO Auto-generated method stub
		return getOficina().obtenerTramitesSecretaria();
	}

	public Tramitador validarIngresoTramitador(String usuario, String contraseña) {

		mensajelog = "";
		nombrelog = "";
		Tramitador comprador = null;

		comprador = oficina.validarIngresoTramitador(usuario, contraseña);
		if (comprador != null) {
			setTramitadorActual(comprador);
			mensajelog += "ingreso el Tramitador  " + comprador.getUsuario();
			nombrelog = comprador.getUsuario();
		} else {
			mensajelog += "no pudo ingresor el Tramitador";
			nombrelog = usuario;
		}

		hiloServicioGuardarLog = new Thread(this);
		hiloServicioGuardarLog.start();
		return comprador;
	}

	public Persona validarIngresoSecretaria(String usuario, String contraseña) {

		mensajelog = "";
		nombrelog = "";
		Persona comprador = null;

		comprador = oficina.validarIngresoSecretaria(usuario, contraseña);
		if (comprador != null) {
			setPersonaActual(comprador);
			mensajelog += "ingreso La Secretaria  " + comprador.getUsuario();
			nombrelog = comprador.getUsuario();
		} else {
			mensajelog += "no pudo ingresor La Secretaria";
			nombrelog = usuario;
		}

		hiloServicioGuardarLog = new Thread(this);
		hiloServicioGuardarLog.start();
		return comprador;
	}

}
