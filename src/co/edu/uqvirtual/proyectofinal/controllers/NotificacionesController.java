package co.edu.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class NotificacionesController {
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
	private Aplicacion aplicacion;

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion app) {

	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button bttEnviarCorreo;

	@FXML
	private Tab tabRecup_Correo;

	@FXML
	private TabPane tapPane_RecuperarPassword;

	@FXML
	private TextField txtCorreoRecuperacion;

	@FXML
	void bttEnviarCorreo_Action(ActionEvent event) {
		validarCorreo();
	}

	@FXML
	void initialize() {

	}

	private void validarCorreo() {

		String correo = txtCorreoRecuperacion.getText();
		Comprador comprador;
		comprador = modelFactoryController.getOficina().obtenerCompradorCorreo(correo);
		if (correo != null) {

			EnvioCorreos correoRecuperacion = new EnvioCorreos();
			correoRecuperacion.createEmail(correo, "SU TARJETA DE PROPIEDAD YA ESTA DISPONIBLE",
					"Tu tarjeta de propiedad ya esta lista, dirigete a la oficina 'Tramites Quindio' para reclamarla \n :"
							+ "CEDULA: " + comprador.getCedula() + "\n" + "CELULAR: " + comprador.getCelular() + " \n "
							+ "DIRECCION: " + comprador.getDireccion() + "\n" + "EMAIL: " + comprador.getEmail() + "\n"
							+ "VEHICULO: " + comprador.getVehiculo() + "\n");
			correoRecuperacion.sendEmail();
			mostrarMensaje("Exito", "Correo enviado", "Se ha enviado exitosamente el correo a " + correo,
					AlertType.INFORMATION);

		} else {

			mostrarMensaje("No encontrado", "Correo no enviado",
					"No se ha encontrado correo de recuperacion : " + correo, AlertType.WARNING);

		}
	}

	public void notificar() {
		String correo = txtCorreoRecuperacion.getText();
		Comprador comprador;
		comprador = modelFactoryController.getOficina().obtenerCompradorCorreo(correo);
	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}

}
