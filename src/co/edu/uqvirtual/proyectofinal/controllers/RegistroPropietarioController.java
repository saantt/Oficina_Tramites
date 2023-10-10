package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroPropietarioController {
	Aplicacion aplicacion;
	ModelFactoryController modelFactoryController;
	CrudRegistroController crudRegistroViewController;
	ObservableList<Propietario> listaPropietarioData = FXCollections.observableArrayList();
	Propietario propietarioSeleccionado;
    @FXML
    private PasswordField txtPreguntaSeguridad;

    @FXML
    private PasswordField txtRespuestaSeguridad;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAgregarPropietario;

	@FXML
	private Button btnIniciarSesionPropietario;

	@FXML
	private TextField txtCelularPropietario;

	@FXML
	private PasswordField txtContraPropietario;

	@FXML
	private TextField txtDireccionPropietario;

	@FXML
	private TextField txtEmailPropietario;

	@FXML
	private TextField txtEstadoCivilPropietario;

	@FXML
	private TextField txtGeneroPropietario;

	@FXML
	private TextField txtIdentificacionPropietario;

	@FXML
	private TextField txtNombrePropietario;

	@FXML
	private TextField txtOcupacionPropietario;

	@FXML
	private TextField txtUsuarioPropietario;

	@FXML
	void agregarPropietario(ActionEvent event) {

		crearPropietario();
	}

	@FXML
	void iniciarSesionPropietario(ActionEvent event) throws IOException {
		aplicacion.abrirLoginPropietario();

	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		crudRegistroViewController = new CrudRegistroController(modelFactoryController);

	}

	private void crearPropietario() {

		// 1. Capturar los datos
		String nombre = txtNombrePropietario.getText();
		String ocupacion = txtOcupacionPropietario.getText();
		String estadoCivil = txtEstadoCivilPropietario.getText();
		String identificacion = txtIdentificacionPropietario.getText();
		String direccion = txtDireccionPropietario.getText();
		String celular = txtCelularPropietario.getText();
		String email = txtEmailPropietario.getText();
		String genero = txtGeneroPropietario.getText();
		String usuario = txtUsuarioPropietario.getText();
		String password = txtContraPropietario.getText();
		String pregunta = txtPreguntaSeguridad.getText();
		String respuesta= txtRespuestaSeguridad.getText();

		// 2. Validar la informaci�n
		if (validarDatos(nombre, ocupacion, estadoCivil, identificacion, direccion, celular, email, genero, usuario,
				password)) {
			Propietario propietario = null;
			if (verificarContraseña(password)) {
				mostrarMensaje("Notificación Comprador", "Contraseña Valida", "LA CONTRASEÑA CUMPLE CON LOS REQUISITOS",
						Alert.AlertType.CONFIRMATION);
				try {
					propietario = crudRegistroViewController.crearPropietario(nombre, ocupacion, estadoCivil,
							identificacion, direccion, celular, email, genero, usuario, password,pregunta,respuesta);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (propietario != null) {
					listaPropietarioData.add(propietario);
					mostrarMensaje("Notificación Propietario", "Propietario creado", "TE HAS REGISTRADO CON EXITO",
							Alert.AlertType.INFORMATION);
					limpiarCamposTexto();
				} else {
					mostrarMensaje("Notificación Propietario", "Propietario no creado",
							"NO TE HAS RESGISTRADO CON EXITO", Alert.AlertType.INFORMATION);
				}
			} else {
				mostrarMensaje("Notificación Propietario", "Propietario no creado", "INGRESA TUS DATOS CORRECTAMENTE",
						Alert.AlertType.ERROR);
			}
		}

	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public static boolean verificarContraseña(String contraseña) {
		// Define una expresión regular que verifica los requisitos
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

		// Compila la expresión regular en un patrón
		Pattern pattern = Pattern.compile(regex);

		// Crea un objeto Matcher para comparar la contraseña con el patrón
		Matcher matcher = pattern.matcher(contraseña);

		// Devuelve true si la contraseña coincide con el patrón
		return matcher.matches();
	}

	private boolean validarDatos(String usuario, String contraenia, String nombre, String direccion, String cedula,
			String celular, String email, String genero, String ocupacion, String estadoCivil) {
		String mensaje = "";

		if (usuario == null || usuario.equalsIgnoreCase("")) {
			mensaje += "el usuario es invalido \n";
		}
		if (contraenia == null || contraenia.equalsIgnoreCase("")) {
			mensaje += "La contraseña es invalida \n";
		}
		if (nombre == null || nombre.equalsIgnoreCase("")) {
			mensaje += "el nombre es invalido \n";
		}
		if (direccion == null || direccion.equalsIgnoreCase("")) {
			mensaje += "la direccion es invalida \n";
		}
		if (cedula == null || cedula.equalsIgnoreCase("")) {
			mensaje += "la cedula es invalida \n";
		}
		if (cedula == null || cedula.equalsIgnoreCase("")) {
			mensaje += "El celular es invalido \n";
		}
		if (email == null || email.equalsIgnoreCase("")) {
			mensaje += "El Email es invalido \n";
		}
		if (genero == null || genero.equalsIgnoreCase("")) {
			mensaje += "El genero es invalido \n";

		}
		if (ocupacion == null || ocupacion.equalsIgnoreCase("")) {
			mensaje += "La ocupacion es invalido \n";
		}
		if (estadoCivil == null || estadoCivil.equalsIgnoreCase("")) {
			mensaje += "El estado civil  es invalido \n";
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

	public void limpiarCamposTexto() {
		txtNombrePropietario.setText("");
		txtOcupacionPropietario.setText("");
		txtEstadoCivilPropietario.setText("");
		txtIdentificacionPropietario.setText("");
		txtDireccionPropietario.setText("");
		txtCelularPropietario.setText("");
		txtEmailPropietario.setText("");
		txtGeneroPropietario.setText("");
		txtUsuarioPropietario.setText("");
		txtContraPropietario.setText("");

	}
}
