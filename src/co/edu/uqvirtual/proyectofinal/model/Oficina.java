package co.edu.uqvirtual.proyectofinal.model;


import co.edu.uqvirtual.proyectofinal.model.services.lOficinaService;

import java.io.Serializable;
import java.util.ArrayList;

public class Oficina implements lOficinaService, Serializable {
	/**
	 *
	 */

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	private String nombre;
	private ArrayList<Persona> listaPersona = new ArrayList<Persona>();
	private ArrayList<Comprador> listaComprador = new ArrayList<Comprador>();
	private ArrayList<Propietario> listaPropietario = new ArrayList<Propietario>();
	private ArrayList<Tramite> listaTramite = new ArrayList<Tramite>();
	private ArrayList<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();
	private ArrayList<Carro> listaCarro = new ArrayList<Carro>();
	private ArrayList<Moto> listaMoto = new ArrayList<Moto>();
	private ArrayList<Bus> listaBus = new ArrayList<Bus>();
	private ArrayList<Camion> listaCamion = new ArrayList<Camion>();
	private ArrayList<Tarjeta> listaTarjeta = new ArrayList<Tarjeta>();
	private ArrayList<Tramitador> listaTramitador = new ArrayList<Tramitador>();
	private ArrayList<SedeTransito> listaSedes = new ArrayList<SedeTransito>();

	public Oficina() {
	}

	public Oficina(String nombre, ArrayList<Persona> listaPersona, ArrayList<Comprador> listaComprador,
			ArrayList<Propietario> listaPropietario, ArrayList<Tramite> listaTramite, ArrayList<Vehiculo> listaVehiculo,
			ArrayList<Carro> listaCarro, ArrayList<Moto> listaMoto, ArrayList<Bus> listaBus,
			ArrayList<Camion> listaCamion, ArrayList<Tarjeta> listaTarjeta, ArrayList<Tramitador> listaTramitador) {
		this.nombre = nombre;
		this.listaPersona = listaPersona;
		this.listaComprador = listaComprador;
		this.listaPropietario = listaPropietario;
		this.listaTramite = listaTramite;
		this.listaVehiculo = listaVehiculo;
		this.listaCarro = listaCarro;
		this.listaMoto = listaMoto;
		this.listaBus = listaBus;
		this.listaCamion = listaCamion;
		this.listaTarjeta = listaTarjeta;
		this.listaTramitador = listaTramitador;
	}

	public ArrayList<SedeTransito> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(ArrayList<SedeTransito> listaSedes) {
		this.listaSedes = listaSedes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Persona> getListaPersona() {
		return listaPersona;
	}

	public void setListaPersona(ArrayList<Persona> listaPersona) {
		this.listaPersona = listaPersona;
	}

	public ArrayList<Comprador> getListaComprador() {
		return listaComprador;
	}

	public void setListaComprador(ArrayList<Comprador> listaComprador) {
		this.listaComprador = listaComprador;
	}

	public ArrayList<Propietario> getListaPropietario() {
		return listaPropietario;
	}

	public void setListaPropietario(ArrayList<Propietario> listaPropietario) {
		this.listaPropietario = listaPropietario;
	}

	public ArrayList<Tramite> getListaTramite() {
		return listaTramite;
	}

	public void setListaTramite(ArrayList<Tramite> listaTramite) {
		this.listaTramite = listaTramite;
	}

	public ArrayList<Vehiculo> getListaVehiculo() {
		return listaVehiculo;
	}

	public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
		this.listaVehiculo = listaVehiculo;
	}

	public ArrayList<Carro> getListaCarro() {
		return listaCarro;
	}

	public void setListaCarro(ArrayList<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public ArrayList<Moto> getListaMoto() {
		return listaMoto;
	}

	public void setListaMoto(ArrayList<Moto> listaMoto) {
		this.listaMoto = listaMoto;
	}

	public ArrayList<Bus> getListaBus() {
		return listaBus;
	}

	public void setListaBus(ArrayList<Bus> listaBus) {
		this.listaBus = listaBus;
	}

	public ArrayList<Camion> getListaCamion() {
		return listaCamion;
	}

	public void setListaCamion(ArrayList<Camion> listaCamion) {
		this.listaCamion = listaCamion;
	}

	public ArrayList<Tarjeta> getListaTarjeta() {
		return listaTarjeta;
	}

	public void setListaTarjeta(ArrayList<Tarjeta> listaTarjeta) {
		this.listaTarjeta = listaTarjeta;
	}

	public ArrayList<Tramitador> getListaTramitador() {
		return listaTramitador;
	}

	public void setListaTramitador(ArrayList<Tramitador> listaTramitador) {
		this.listaTramitador = listaTramitador;
	}

	@Override
	public String toString() {
		return "Oficina{" + "nombre='" + nombre + '\'' + ", listaPersona=" + listaPersona + ", listaComprador="
				+ listaComprador + ", listaPropietario=" + listaPropietario + ", listaTramite=" + listaTramite
				+ ", listaVehiculo=" + listaVehiculo + ", listaCarro=" + listaCarro + ", listaMoto=" + listaMoto
				+ ", listaBus=" + listaBus + ", listaCamion=" + listaCamion + ", listaTarjeta=" + listaTarjeta
				+ ", listaTramitador=" + listaTramitador + '}';
	}

	// ------------------------COMPRADOR-----------------------------------
	@Override
	public Comprador crearComprador(String usuario, String contraenia, String nombre, String direccion, String cedula,
			String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad) {

		Comprador comprador = null;

		comprador = obtenerComprador(cedula);
		boolean anuncianteExiste = verificarCompradorExistente(cedula);
		if (anuncianteExiste) {
			System.out.println("El comprador ya existe");

		} else {
			comprador = new Comprador(usuario, contraenia, nombre, direccion, cedula, celular, email, genero, ocupacion,
					estadoCivil,preguntaSeguridad,respuestaSeguridad);

			getListaComprador().add(comprador);
			return comprador;
		}
		return comprador;
	}

	@Override

	public Comprador obtenerComprador(String idComprador) {
		for (Comprador comprador : listaComprador) {
			if (comprador.getCedula().equalsIgnoreCase(idComprador)) {
				return comprador;
			}
		}
		return null;
	}

	public Comprador obtenerEmailComprador(String correo) {
		for (Comprador comprador : listaComprador) {
			if (comprador.getEmail().equalsIgnoreCase(correo)) {
				return comprador;
			}
		}
		return null;
	}

	public Propietario obtenerEmailPropietario(String correo) {
		for (Propietario comprador : listaPropietario) {
			if (comprador.getEmail().equalsIgnoreCase(correo)) {
				return comprador;
			}
		}
		return null;
	}

	@Override

	public boolean verificarCompradorExistente(String cedula) {
		Comprador comprador = null;
		comprador = obtenerComprador(cedula);
		if (comprador == null)
			return false;
		else
			return true;
	}

	@Override
	public ArrayList<Comprador> obtenerCompradors() {
		return getListaComprador();
	}

	// -----------------PROPIETARIO--------------------------
	@Override
	public Propietario crearPropietario(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad) {

		Propietario propietario = null;

		propietario = obtenerPropietario(cedula);
		boolean anuncianteExiste = verificarCompradorExistente(cedula);
		if (anuncianteExiste) {
			System.out.println("El comprador ya existe");

		} else {
			propietario = new Propietario(usuario, contraenia, nombre, direccion, cedula, celular, email, genero,
					ocupacion, estadoCivil,preguntaSeguridad,respuestaSeguridad);

			getListaPropietario().add(propietario);
			return propietario;
		}

		return propietario;
	}

	@Override

	public Propietario obtenerPropietario(String idComprador) {
		for (Propietario comprador : listaPropietario) {
			if (comprador.getCedula().equalsIgnoreCase(idComprador)) {
				return comprador;
			}
		}
		return null;
	}

	@Override

	public boolean verificarPropietarioExistente(String cedula) {
		Propietario propietario = null;
		propietario = obtenerPropietario(cedula);
		if (propietario == null)
			return false;
		else
			return true;
	}

	@Override
	public ArrayList<Propietario> obtenerPropietarios() {
		return getListaPropietario();
	}

	// --------------------VALIDAR INGRESOS---------------------------
	public Propietario validarPropietario(String usuario, String contrasena) {
		Propietario propietario1 = null;

		boolean ingreso = false;
		for (Propietario propietario : listaPropietario) {

			if (propietario.getUsuario().equalsIgnoreCase(usuario)
					&& propietario.getContraenia().equalsIgnoreCase(contrasena)) {
				propietario1 = propietario;
				ingreso = true;
			}
		}
		if (ingreso == false) {
//            throw new ExceptionAnunciante("No coinciden los datos");
			return null;
		}
		return propietario1;
	}

	public Comprador validarIngresoComprador(String usuario, String contrasena) {
		Comprador comprador1 = null;

		boolean ingreso = false;
		for (Comprador comprador : listaComprador) {

			if (comprador.getUsuario().equalsIgnoreCase(usuario)
					&& comprador.getContraenia().equalsIgnoreCase(contrasena)) {
				comprador1 = comprador;
				ingreso = true;
			}
		}
		if (ingreso == false) {
			return null;
		}
		return comprador1;
	}

	public Comprador cambiarPasswordComprador(String identificacion, String password) throws Exception {
		// TODO Auto-generated method stub
		Comprador encontrada = obtenerComprador(identificacion);

		if (identificacion == null) {
			throw new Exception("ERROR");
		}
		if (encontrada != null) {
			encontrada.setContraenia(password);
			return encontrada;
		}
		return null;
	}

	public Propietario cambiarPasswordPropietario(String identificacion, String password) throws Exception {
		// TODO Auto-generated method stub
		Propietario encontrada = obtenerPropietario(identificacion);

		if (identificacion == null) {
			throw new Exception("ERROR");
		}
		if (encontrada != null) {
			encontrada.setContraenia(password);
			return encontrada;
		}
		return null;
	}

	public Comprador validarCorreoComprador(String correo) {
		Comprador comprador1 = null;

		boolean ingreso = false;
		for (Comprador comprador : listaComprador) {

			if (comprador.getEmail().equalsIgnoreCase(correo)) {
				comprador1 = comprador;
				ingreso = true;
			}
		}
		if (ingreso == false) {
			return null;

		}
		return comprador1;
	}
	
	public Propietario validarCorreoPropietario(String correo) {
		Propietario comprador1 = null;

		boolean ingreso = false;
		for (Propietario comprador : listaPropietario) {

			if (comprador.getEmail().equalsIgnoreCase(correo)) {
				comprador1 = comprador;
				ingreso = true;
			}
		}
		if (ingreso == false) {
			return null;

		}
		return comprador1;
	}
	
	
	public Tramitador obtenerTramitador(String idComprador) {
		for (Tramitador comprador : listaTramitador) {
			if (comprador.getCedula().equalsIgnoreCase(idComprador)) {
				return comprador;
			}
		}
		return null;
	}

	

	public boolean verificarTramitadorExistente(String cedula) {
		Tramitador propietario = null;
		propietario = obtenerTramitador(cedula);
		if (propietario == null)
			return false;
		else
			return true;
	}

	
	public ArrayList<Tramitador> obtenerTramitadores() {
		return getListaTramitador();
	}
	public Persona obtenerSecretaria(String idComprador) {
		for (Persona comprador : listaPersona) {
			if (comprador.getCedula().equalsIgnoreCase(idComprador)) {
				return comprador;
			}
		}
		return null;
	}

	

	public boolean verificarSecretariaExistente(String cedula) {
		Persona propietario = null;
		propietario = obtenerSecretaria(cedula);
		if (propietario == null)
			return false;
		else
			return true;
	}

	
	public ArrayList<Persona> obtenerSecretarias() {
		return getListaPersona();
	}
	
	
	public Vehiculo obtenerVehiculo(String idComprador) {
		for (Vehiculo comprador : listaVehiculo) {
			if (comprador.getPlaca().equalsIgnoreCase(idComprador)) {
				return comprador;
			}
		}
		return null;
	}

	

	public boolean verificarVehiculoExistente(String cedula) {
		Vehiculo propietario = null;
		propietario = obtenerVehiculo(cedula);
		if (propietario == null)
			return false;
		else
			return true;
	}

	
	public ArrayList<Vehiculo> obtenerVehiculos() {
		return getListaVehiculo();
	}
	
	public Tramite obtenerTramite(String idComprador) {
		for (Tramite comprador : listaTramite) {
			if (comprador.getVehiculo().getPlaca().equalsIgnoreCase(idComprador)) {
				return comprador;
			}
		}
		return null;
	}

	

	public boolean verificarTramiteExistente(String cedula) {
		Tramite propietario = null;
		propietario = obtenerTramite(cedula);
		if (propietario == null)
			return false;
		else
			return true;
	}

	
	public ArrayList<Tramite> obtenerTramites() {
		return getListaTramite();
	}
	
	public Tramitador validarIngresoTramitador(String usuario, String contrasena) {
		Tramitador comprador1 = null;

		boolean ingreso = false;
		for (Tramitador comprador : listaTramitador) {

			if (comprador.getUsuario().equalsIgnoreCase(usuario)
					&& comprador.getContraenia().equalsIgnoreCase(contrasena)) {
				comprador1 = comprador;
				ingreso = true;
			}
		}
		if (ingreso == false) {
			return null;
		}
		return comprador1;
	}
	public Persona validarIngresoSecretaria(String usuario, String contrasena) {
		Persona comprador1 = null;

		boolean ingreso = false;
		for (Persona comprador : listaPersona) {

			if (comprador.getUsuario().equalsIgnoreCase(usuario)
					&& comprador.getContraenia().equalsIgnoreCase(contrasena)) {
				comprador1 = comprador;
				ingreso = true;
			}
		}
		if (ingreso == false) {
			return null;
		}
		return comprador1;
	}

	public ArrayList<SedeTransito> obtenerSedes() {
		return getListaSedes();
	}
	
	public SedeTransito obtenerSedes(String idComprador) {
		for (SedeTransito comprador : listaSedes) {
			if (comprador.getVehiculo().getPlaca().equalsIgnoreCase(idComprador)) {
				return comprador;
			}
		}
		return null;
	}

	

	public boolean verificarSedeExistente(String cedula) {
		SedeTransito propietario = null;
		propietario = obtenerSedes(cedula);
		if (propietario == null)
			return false;
		else
			return true;
	}


}
