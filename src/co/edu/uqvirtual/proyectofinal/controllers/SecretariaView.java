package co.edu.uqvirtual.proyectofinal.controllers;

import java.util.ArrayList;

import co.edu.uqvirtual.proyectofinal.model.Oficina;
import co.edu.uqvirtual.proyectofinal.model.Tramite;

public class SecretariaView {

	 ModelFactoryController modelFactoryController;
	 Oficina oficina;
	public SecretariaView(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
		oficina = modelFactoryController.getOficina();
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
	
	public ArrayList<Tramite> obtenerTramitesSecretaria(){
        return  modelFactoryController.obtenerTramitesSecretaria();
    }

}
