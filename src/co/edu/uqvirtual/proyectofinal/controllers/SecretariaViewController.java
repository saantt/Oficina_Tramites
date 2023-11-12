package co.edu.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SecretariaViewController {
	
	Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRealizarTramite;

    @FXML
    private Button btnRechazarTramite;

    @FXML
    private Button btnRevisarMultasPersona;

    @FXML
    private Button btnRevisarMultasVehiculo;

    @FXML
    private TableView<?> tblwTramitesPendientes;

    @FXML
    private TableColumn<?, ?> tbwColumCiudadPendiente;

    @FXML
    private TableColumn<?, ?> tbwColumCompradorPendiente;

    @FXML
    private TableColumn<?, ?> tbwColumCorreoPendiente;

    @FXML
    private TableColumn<?, ?> tbwColumPropietarioPendiente;

    @FXML
    private TableColumn<?, ?> tbwColumVehiculoPendiente;

    @FXML
    void realizarTramite(ActionEvent event) {

    }

    @FXML
    void rechazarTramite(ActionEvent event) {

    }

    @FXML
    void revisarMultasPersonas(ActionEvent event) {

    }

    @FXML
    void revisarMultasVehiculo(ActionEvent event) {

    }

    @FXML
    void initialize() {
       
    }

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
