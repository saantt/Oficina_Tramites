package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginCompradorViewController {
	Aplicacion aplicacion;
	ModelFactoryController modelFactoryController;
	CrudRegistroController crudRegistroViewController;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnIngresar;

	@FXML
	private Hyperlink lbltxtRecuoerarPass;

	@FXML
	private PasswordField txtContraseñaAutenticacion;

	@FXML
	private TextField txtUsuarioAutenticacion;

	@FXML
	void hyper_RemenberPass_Action_Login(ActionEvent event) throws IOException {

		aplicacion.recuperarContrasenaComprador();
	}

	@FXML
	void initialize() {

		modelFactoryController = ModelFactoryController.getInstance();
		crudRegistroViewController = new CrudRegistroController(modelFactoryController);
	}

	@FXML
	void ingresarUsuario(ActionEvent event) throws ClassNotFoundException, IOException {
		login();

	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void login() throws IOException, ClassNotFoundException {
		String usuario = txtUsuarioAutenticacion.getText();
		String password = txtContraseñaAutenticacion.getText();
		Comprador Comprador = new Comprador();

		Comprador.setUsuario(usuario);
		Comprador.setContraenia(password);

		if (validarTexto(usuario) && validarTexto(password)) {
			if (modelFactoryController.validarIngresoComprador(usuario, password) != null) {
				Comprador anuncianteActual = modelFactoryController.obtenerCompradorActual(Comprador);
				modelFactoryController.compradorActual = anuncianteActual;
				mostrarMensaje("Has ingresado correctamente ", null, " Bienvenido Propietario",
						Alert.AlertType.INFORMATION);
				Stage stage = (Stage) this.btnIngresar.getScene().getWindow();
				stage.close();
				aplicacion.abrirAgregarPropietario();
			} else {
				mostrarMensaje("Datos de acceso equivocados", null, "Asegurese de introducir los datos correctamente",
						Alert.AlertType.ERROR);
			}

		} else {
			mostrarMensaje("Datos de acceso incompletos", null, "Asegurese de introducir todos los datos",
					Alert.AlertType.ERROR);

		}

	}

	private boolean validarTexto(String texto) {
		return texto != null && !texto.equalsIgnoreCase("") ? true : false;
	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}

}
