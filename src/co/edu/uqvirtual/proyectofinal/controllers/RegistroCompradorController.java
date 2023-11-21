package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class RegistroCompradorController {
	Aplicacion aplicacion;
	ModelFactoryController modelFactoryController;
	CrudRegistroController crudRegistroViewController;
	ObservableList<Comprador> listaCompradorData = FXCollections.observableArrayList();
	Comprador compradorSeleccionado;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAgregarComprador;

	@FXML
	private Button btnAgregarImagen;

	@FXML
	private Button btnIniciarSesionComprador;

	@FXML
	private TextField txtCelularComprador;

	@FXML
	private PasswordField txtContraComprador;

	@FXML
	private TextField txtDireccionComprador;

	@FXML
	private TextField txtEmailComprador;

	@FXML
	private TextField txtEstadoCivilComprador;

	@FXML
	private TextField txtGeneroComprador;

	@FXML
	private TextField txtIdentificacionComprador;

	@FXML
	private TextField txtImagenCdula;

	@FXML
	private TextField txtNombreComprador;

	@FXML
	private TextField txtOcupacionComprador;

	@FXML
	private PasswordField txtPreguntaSeguridad;

	@FXML
	private PasswordField txtRespuestaSeguridad;

	@FXML
	private TextField txtUsuarioComprador;

	@FXML
	void agregarImagen(ActionEvent event) throws IOException {
		cargarImagenCancion();
	}

	@FXML
	void agregarComprador(ActionEvent event) {

		crearComprador();
	}

	@FXML
	void iniciarSesionComprador(ActionEvent event) throws IOException {
		aplicacion.abrirLoginComprador();

	}

	@FXML
	void initialize() {

		modelFactoryController = ModelFactoryController.getInstance();
		crudRegistroViewController = new CrudRegistroController(modelFactoryController);
		txtImagenCdula.setDisable(true);
	}

	private void crearComprador() {

		// 1. Capturar los datos
		String nombre = txtNombreComprador.getText();
		String ocupacion = txtOcupacionComprador.getText();
		String estadoCivil = txtEstadoCivilComprador.getText();
		String identificacion = txtIdentificacionComprador.getText();
		String direccion = txtDireccionComprador.getText();
		String celular = txtCelularComprador.getText();
		String email = txtEmailComprador.getText();
		String genero = txtGeneroComprador.getText();
		String usuario = txtUsuarioComprador.getText();
		String password = txtContraComprador.getText();
		String pregunta = txtPreguntaSeguridad.getText();
		String respuesta = txtRespuestaSeguridad.getText();
		String imagen = txtImagenCdula.getText();

		// 2. Validar la informaci�n
		if (validarDatos(nombre, ocupacion, estadoCivil, identificacion, direccion, celular, email, genero, usuario,
				password)) {
			if (verificarContraseña(password)) {
				mostrarMensaje("Notificación Comprador", "Contraseña Valida", "LA CONTRASEÑA CUMPLE CON LOS REQUISITOS",
						Alert.AlertType.CONFIRMATION);
				Comprador comprador = null;
				try {
					comprador = crudRegistroViewController.crearComprador(usuario, password, nombre, direccion,
							identificacion, celular, email, genero, ocupacion, estadoCivil, pregunta, respuesta,
							imagen);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (comprador != null) {
					
					listaCompradorData.add(comprador);
					modelFactoryController.guardarXML();
					mostrarMensaje("Notificación Comprador", "Comprador creado", "TE HAS REGISTRADO CON EXITO",
							Alert.AlertType.INFORMATION);
					limpiarCamposTexto();
				} else {
					mostrarMensaje("Notificación Comprador", "Comprador no creado", "NO TE HAS RESGISTRADO CON EXITO",
							Alert.AlertType.INFORMATION);
				}
			} else {
				mostrarMensaje("Notificación Comprador", "Comprador no creado", "INGRESA TUS DATOS CORRECTAMENTE",
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
		txtNombreComprador.setText("");
		txtOcupacionComprador.setText("");
		txtEstadoCivilComprador.setText("");
		txtIdentificacionComprador.setText("");
		txtDireccionComprador.setText("");
		txtCelularComprador.setText("");
		txtEmailComprador.setText("");
		txtGeneroComprador.setText("");
		txtUsuarioComprador.setText("");
		txtContraComprador.setText("");

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

			txtImagenCdula.setText(imgFile.getAbsolutePath());

		}
	}

}
