package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    void abrirComprador(ActionEvent event) throws IOException {

        aplicacion.abrirAgregarComprador();
    }

    @FXML
    void abrirPropietario(ActionEvent event) throws IOException {

        aplicacion.abrirAgregarPropietario();
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

