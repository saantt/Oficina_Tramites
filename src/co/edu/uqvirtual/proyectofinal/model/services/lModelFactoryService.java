package co.edu.uqvirtual.proyectofinal.model.services;

import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;

import java.io.IOException;
import java.util.ArrayList;

public interface lModelFactoryService {

    public Propietario crearPropietario(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad,String imagen) throws IOException, ClassNotFoundException;

    public Propietario obtenerPropietario(String idPropietario);
    public Boolean verificarPropietarioExistente(String cedula);
    public ArrayList<Propietario> obtenerPropietarioss();
    public Comprador crearComprador(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad,String imagen);

    public Comprador obtenerComprador(String idComprador);
    public Boolean verificarCompradorExistente(String cedula);
    public ArrayList<Comprador> obtenerCompradors();
}
