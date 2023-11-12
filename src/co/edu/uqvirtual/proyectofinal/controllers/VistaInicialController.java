package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class VistaInicialController {

    Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAbrirComprador;

    @FXML
    private Button btnAbrirPropietario;

	
	@FXML
	private Button btnIngresar;

	@FXML
	private Hyperlink lbltxtRecuoerarPass;

	@FXML
	private PasswordField txtContraseñaAutenticacion;

	@FXML
	private TextField txtUsuarioAutenticacion;

    @FXML
    void abrirComprador(ActionEvent event) throws IOException {

        aplicacion.abrirAgregarComprador();
    }

    @FXML
    void abrirPropietario(ActionEvent event) throws IOException {

        aplicacion.abrirAgregarPropietario();
    }
    @FXML
    void abriTramitador(ActionEvent event) throws IOException {
    	aplicacion.abrirLoginTramitador();

    }
    @FXML
    void abrirSecretaria(ActionEvent event) throws IOException {
    	aplicacion.abrirLoginSecretaria();

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

