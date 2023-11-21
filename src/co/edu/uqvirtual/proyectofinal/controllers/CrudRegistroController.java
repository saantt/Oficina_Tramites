package co.edu.uqvirtual.proyectofinal.controllers;

import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Oficina;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;

import java.io.IOException;
import java.util.ArrayList;

public class CrudRegistroController {


    ModelFactoryController modelFactoryController;

    Oficina oficina;
    public CrudRegistroController(ModelFactoryController modelFactoryController) {
        this.modelFactoryController = modelFactoryController;
        oficina = modelFactoryController.getOficina();
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public ArrayList<Propietario> obtenerPropietarios() {
        return modelFactoryController.obtenerPropietarioss();
    }

    public ArrayList<Comprador> obtenerCompradores() {
        return modelFactoryController.obtenerCompradors();
    }

    public Propietario crearPropietario(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad,String imagen)
            throws IOException, ClassNotFoundException{
        return modelFactoryController.crearPropietario(usuario, contraenia, nombre,  direccion,  cedula, celular, email,
                genero,
                ocupacion, estadoCivil,preguntaSeguridad,respuestaSeguridad,imagen);
    }

    public Comprador crearComprador(String usuario, String contraenia, String nombre, String direccion,
			String cedula, String celular, String email, String genero, String ocupacion, String estadoCivil,String preguntaSeguridad, String respuestaSeguridad, String imagen){
        return modelFactoryController.crearComprador(usuario, contraenia,  nombre, direccion,  cedula,
                celular, email,  genero,    ocupacion, estadoCivil,preguntaSeguridad,respuestaSeguridad,imagen);
    }
}
