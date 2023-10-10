package co.edu.uqvirtual.proyectofinal.persistence;

import co.edu.uqvirtual.proyectofinal.model.Oficina;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Persistencia {

	
	
	public static final String RUTA_ARCHIVO_RESPALDO_LOG= "C://td//persistence//respaldo//Log.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_XML= "C://td//persistence//respaldo//XML.txt";
	public static final String RUTA_ARCHIVO_LOG = "C://td//persistence//log//TramitesLog.txt";
	public static final String RUTA_ARCHIVO_MODELO_SUBASTA_XML = "C://td//persistence//model.xml";




	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {

		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_RESPALDO_LOG);

	}

	
	public static Oficina cargarRecursoBancoXML() {

		Oficina subasta = null;

		try {
			subasta = (Oficina) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subasta;

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

}