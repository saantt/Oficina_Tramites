package co.edu.uqvirtual.proyectofinal.controllers;

import java.util.ArrayList;


import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Oficina;
import co.edu.uqvirtual.proyectofinal.model.Persona;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Secretaria;
import co.edu.uqvirtual.proyectofinal.model.SedeTransito;
import co.edu.uqvirtual.proyectofinal.model.Tramitador;
import co.edu.uqvirtual.proyectofinal.model.Tramite;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;

public class TramitadorView {

	 ModelFactoryController modelFactoryController;
	 Oficina oficina;

	public TramitadorView(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
		oficina= modelFactoryController.getOficina();
	}

	public ModelFactoryController getModelFactoryController() {
		return modelFactoryController;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	public ArrayList<Comprador> obtenerCompradores() {
        return modelFactoryController.obtenerCompradors();
    }
	public ArrayList<Propietario> obtenerPropietarios() {
        return modelFactoryController.obtenerPropietarioss();
    }

	public ArrayList<Persona> obtenerSecretarias() {
        return modelFactoryController.obtenerSecretariass();
    }

	public ArrayList<SedeTransito> obtenerSedes() {
        return modelFactoryController.obtenerSedess();
    }

	public ArrayList<Tramitador> obtenerTramitadores() {
        return modelFactoryController.obtenerTramitadoress();
    }

	public ArrayList<Vehiculo> obtenerVehiculos() {
        return modelFactoryController.obtenerVehiculoss();
    }
	public ArrayList<Tramite> obtenerTramites(){
        return  modelFactoryController.obtenerTramitess();
    }


}
