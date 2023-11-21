package co.edu.uqvirtual.proyectofinal.model.services;

import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;

import java.util.ArrayList;

public interface lOficinaService {

    //----COMPRADOR---------------
    public Comprador crearComprador(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad,String imagen);



    public Comprador obtenerComprador(String idComprador);

    public boolean verificarCompradorExistente(String cedula);

    public ArrayList<Comprador> obtenerCompradors();

    //-----PROPIETARIO--------------------
    public Propietario crearPropietario(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad,String imagen);

    public Propietario obtenerPropietario(String idPropietario);
    public boolean verificarPropietarioExistente(String cedula);

    public ArrayList<Propietario> obtenerPropietarios();

}
