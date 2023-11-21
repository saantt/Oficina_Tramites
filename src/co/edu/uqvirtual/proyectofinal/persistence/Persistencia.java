package co.edu.uqvirtual.proyectofinal.persistence;

import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Oficina;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Solicitud;
import co.edu.uqvirtual.proyectofinal.model.Tramite;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

	public static final String RUTA_ARCHIVO_RESPALDO_LOG = "C://td//persistence//respaldo//Log.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_XML = "C://td//persistence//respaldo//XML.txt";
	public static final String RUTA_ARCHIVO_LOG = "C://td//persistence//log//TramitesLog.txt";
	public static final String RUTA_ARCHIVO_MODELO_SUBASTA_XML = "C://td//persistence//model.xml";
	public static final String RUTA_XML_VEHICULOS = "C://td//persistence//log//Vehiculos.xml";
	public static final String RUTA_XML_PROPIETARIOS = "C://td//persistence//log//Propietarios.xml";
	public static final String RUTA_XML_COMPRADORES = "C://td//persistence//log//Compradores.xml";
	public static final String RUTA_XML_TRAMITES = "C://td//persistence//log//Tramites.xml";
	public static final String RUTA_XML_SOLICIUD = "C://td//persistence//log//Solicitudes.xml";

	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {

		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_RESPALDO_LOG);

	}

	public static Oficina cargarRecursoOficinaXML() {

		Oficina oficina = null;

		try {
			oficina = (Oficina) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oficina;

	}

	public static void guardarRecursoBancoXML(Oficina subasta) {

		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML, subasta);
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_RESPALDO_XML, subasta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void guardarVehiculosXML(ArrayList<Vehiculo> guardados) {
		// TODO Auto-generated method stub
		try {

			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_VEHICULOS, guardados);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Vehiculo> cargarVehiculos() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Object object = null;
		ArrayList<Vehiculo> mark = null;

		try {
			object = ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_VEHICULOS);
			mark = (ArrayList<Vehiculo>) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;
	}

	public static void guardarPropietariosXML(ArrayList<Propietario> guardados) {
		// TODO Auto-generated method stub
		try {

			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_PROPIETARIOS, guardados);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Propietario> cargarPropietarios() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Object object = null;
		ArrayList<Propietario> mark = null;

		try {
			object = ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_PROPIETARIOS);
			mark = (ArrayList<Propietario>) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;
	}

	public static void guardarCompradorXML(ArrayList<Comprador> guardados) {
		// TODO Auto-generated method stub
		try {

			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_COMPRADORES, guardados);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Comprador> cargarCompradores() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Object object = null;
		ArrayList<Comprador> mark = null;

		try {
			object = ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_COMPRADORES);
			mark = (ArrayList<Comprador>) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;
	}

	public static void guardarTramiteXML(ArrayList<Tramite> guardados) {
		// TODO Auto-generated method stub
		try {

			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_TRAMITES, guardados);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Tramite> cargarTramites() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Object object = null;
		ArrayList<Tramite> mark = null;

		try {
			object = ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_TRAMITES);
			mark = (ArrayList<Tramite>) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;
	}

	public static void guardarSolicitudXML(ArrayList<Solicitud> guardados) {
		// TODO Auto-generated method stub
		try {

			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_XML_SOLICIUD, guardados);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Solicitud> cargarSolicitud() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Object object = null;
		ArrayList<Solicitud> mark = null;

		try {
			object = ArchivoUtil.cargarRecursoSerializadoXML(RUTA_XML_SOLICIUD);
			mark = (ArrayList<Solicitud>) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;
	}
}