package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class PazSalvoController {

	ModelFactoryController modelFactoryController;
	Aplicacion aplicacion;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAgregarImgen;

	@FXML
	private Button btnGenerarPazSalvo;

	@FXML
	private TextField txtImagenEstampillas;
	@FXML
	private TextField txtPlaca;
	@FXML
	private TextField txtCorreo;

	@FXML
	void agrgarImagen(ActionEvent event) throws IOException {
		cargarImagenCancion();

	}

	@FXML
	void generarPazSalvo(ActionEvent event) {
		validarCorreo();

	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();

		txtImagenEstampillas.setDisable(true);

	}

	public ModelFactoryController getModelFactoryController() {
		return modelFactoryController;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	private void validarCorreo() {

		String placa = txtPlaca.getText();
		String correo = txtCorreo.getText();
		Comprador comprador;

		comprador = modelFactoryController.getOficina().obtenerCompradorCorreo(correo);

		if (correo != null) {

			EnvioCorreos correoRecuperacion = new EnvioCorreos();
			correoRecuperacion.createEmail(correo, "TU PAZ Y SALVO SE GENERO CORRECTAMENTE",
					"El paz y salvo de tu vehiculo " + placa + "se envio correctamente a la sede de transito");
			correoRecuperacion.sendEmail();
			mostrarMensaje("Exito", "Correo enviado", "Se ha enviado exitosamente el correo a " + correo,
					AlertType.INFORMATION);

		} else {

			mostrarMensaje("No encontrado", "Correo no enviado",
					"No se ha encontrado correo de recuperacion : " + correo, AlertType.WARNING);

		}
	}

	private void cargarImagenCancion() throws IOException {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Imagen");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));

		// Obtener la imagen seleccionada
		File imgFile = fileChooser.showOpenDialog(aplicacion.getPrimaryStage());

		// Mostar la imagen
		if (imgFile != null) {
			Image image = new Image("file:" + imgFile.getAbsolutePath());
			// String rutaAbsoluta=""+imgFile.getAbsolutePath();

			txtImagenEstampillas.setText(imgFile.getAbsolutePath());

		}
	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}

}
