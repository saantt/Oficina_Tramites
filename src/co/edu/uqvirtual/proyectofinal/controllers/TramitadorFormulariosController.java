package co.edu.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;


import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Persona;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Secretaria;
import co.edu.uqvirtual.proyectofinal.model.SedeTransito;
import co.edu.uqvirtual.proyectofinal.model.Tramitador;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;

public class TramitadorFormulariosController {
	
	Aplicacion aplicacion;
	TramitadorView tramiadorView;
	ModelFactoryController modelFactoryController;
	
	ObservableList<Comprador> listaCompradoresData = FXCollections.observableArrayList();
	ObservableList<Propietario> listaPropietariosData = FXCollections.observableArrayList();
	ObservableList<Persona> listaSecretariasData = FXCollections.observableArrayList();
	ObservableList<SedeTransito> listaSedesData = FXCollections.observableArrayList();
	ObservableList<Tramitador> listaTramitadoresData = FXCollections.observableArrayList();
	ObservableList<Vehiculo> listaVehiculosData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGenerarPazSalvo;

    @FXML
    private Button btnLlenarFormulario;

    @FXML
    private ComboBox<Comprador> comboComprador;

    @FXML
    private ComboBox<Propietario> comboPropietario;

    @FXML
    private ComboBox<Persona> comboSecretaria;

    @FXML
    private ComboBox<SedeTransito> comboSedeTransito;

    @FXML
    private ComboBox<Tramitador> comboTramitador;

    @FXML
    private ComboBox<Vehiculo> comboVehiculo;

    @FXML
    void generarPazSalvo(ActionEvent event) {

    }

    @FXML
    void llenarFormulario(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	modelFactoryController = ModelFactoryController.getInstance();
    	tramiadorView = new TramitadorView(modelFactoryController);
    	incicializarFormularios();
       
    }

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public void incicializarFormularios() {
        this.comboComprador.setItems(getListaCompradoresData());
        this.comboPropietario.setItems(getListaPropietariosData());
        this.comboSecretaria.setItems(getListaSecretariasData());
        this.comboSedeTransito.setItems(getListaSedesData());
        this.comboTramitador.setItems(getListaTramitadoresData());
        this.comboVehiculo.setItems(getListaVehiculosData());
        
        

      


    }
	
	public ObservableList<Comprador> getListaCompradoresData() {
        listaCompradoresData.addAll(tramiadorView.obtenerCompradores());
        return listaCompradoresData;
    }
	public ObservableList<Propietario> getListaPropietariosData() {
        listaPropietariosData.addAll(tramiadorView.obtenerPropietarios());
        return listaPropietariosData;
    }
	public ObservableList<Persona> getListaSecretariasData() {
        listaSecretariasData.addAll(tramiadorView.obtenerSecretarias());
        return listaSecretariasData;
    }
	public ObservableList<SedeTransito> getListaSedesData() {
        listaSedesData.addAll(tramiadorView.obtenerSedes());
        return listaSedesData;
    }
	public ObservableList<Tramitador> getListaTramitadoresData() {
        listaTramitadoresData.addAll(tramiadorView.obtenerTramitadores());
        return listaTramitadoresData;
    }
	public ObservableList<Vehiculo> getListaVehiculosData() {
        listaVehiculosData.addAll(tramiadorView.obtenerVehiculos());
        return listaVehiculosData;
    }


}
