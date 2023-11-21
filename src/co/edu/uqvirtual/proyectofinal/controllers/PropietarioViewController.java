package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Ciudades;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Solicitud;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PropietarioViewController {

	Aplicacion aplicacion;
	ModelFactoryController modelFactoryController;
	Propietario propietarioActual;

	@FXML
	private Button btnSeleccionarVehiculo;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAgregarVehiculo;

	@FXML
	private Button btnEnviar;

	@FXML
	private ComboBox<Ciudades> comboCiudad;

	@FXML
	private TextField txtCedulaCom;

	@FXML
	private TextField txtxCedulaPro;

	@FXML
	void agregarVehiculo(ActionEvent event) throws IOException {

		aplicacion.abrirAgregarVehiculo();

	}

	@FXML
	void enviarDatosTramite(ActionEvent event) {
	
		enviarSolicitud();
	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		iniciarComboBox();
		
		txtxCedulaPro.setText("233333");
		txtCedulaCom.setText("1104544039");
	}

	@FXML
	void seleccionarVehiculo(ActionEvent event) throws IOException {
		String cedulaPropietario = txtxCedulaPro.getText();
		if (!cedulaPropietario.equalsIgnoreCase("")) {
			if (modelFactoryController.verificarPropietarioExistente(cedulaPropietario)) {
				modelFactoryController.cedulaPropietario = cedulaPropietario;
				aplicacion.seleccionarVehiculo();
			}

		}

	}

	private void iniciarComboBox() {
		// TODO Auto-generated method stub
		comboCiudad.getItems().addAll(Ciudades.values());

	}

	private void enviarSolicitud() {

		
		String cedulaPropietario = txtxCedulaPro.getText();
		String cedulaComprador = txtCedulaCom.getText();
		Ciudades ciudadSeleccionada = (Ciudades) comboCiudad.getValue();
		Vehiculo vehiculoSeleccionado = modelFactoryController.vehiculoSeleccionadoSoli;
		if (validarDatos(cedulaPropietario, cedulaComprador, ciudadSeleccionada,
				vehiculoSeleccionado)) {
			

			Solicitud nuevaSolicitud = modelFactoryController.crearSolicitud(cedulaPropietario, cedulaComprador,
					ciudadSeleccionada, vehiculoSeleccionado);
			mostrarMensaje("Info", "Exito", "Solicitud creada con exito"+nuevaSolicitud.toString(), AlertType.INFORMATION);
		} else {
			// vdebe seleccionar un vehiculo
			mostrarMensaje("advertencia", "Cuidado", "Debe seleccionar un vehiculo", AlertType.WARNING);
		}
		
		
	}

	private boolean validarDatos(String cedulaPropietario, String cedulaComprador, Ciudades ciudadSeleccionada,
			Vehiculo vehiculo) {
		String mensaje = "";

		if (cedulaPropietario == null || cedulaPropietario.equalsIgnoreCase("")) {
			mensaje += "el Propietario es invalido \n";
		}
		if (cedulaComprador == null || cedulaComprador.equalsIgnoreCase("")) {
			mensaje += "el comprador es invalido \n";
		}
		if (ciudadSeleccionada == null) {
			mensaje += "la ciudad es nula  \n";
		}
		if (vehiculo == null) {
			mensaje += "Debe seleccionar un vehiculo \n";
		}

		if (mensaje.equalsIgnoreCase("")) {
			return true;
		} else {
			mostrarMensaje("Notificación cliente", "Datos Invalidos", mensaje, Alert.AlertType.WARNING);
			return false;
		}

	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public ModelFactoryController getModelFactoryController() {
		return modelFactoryController;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

}
