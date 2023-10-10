package co.edu.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import javax.swing.*;

public class RecuperarPassCompradorController {
	private Aplicacion aplicacion;

	private Comprador compradorEncontrado;

	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	public Comprador getCompradorEncontrado() {
		return compradorEncontrado;
	}

	public void setCompradorEncontrado(Comprador compradorEncontrado) {
		this.compradorEncontrado = compradorEncontrado;
	}

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
	private Button bttCambiarPassword;

	@FXML
	private Button bttEnviarCorreo;

	@FXML
	private Button bttResponderPregunta;

	@FXML
	private Tab tabCambiar_Pass;

	@FXML
	private Tab tabRecup_Correo;

	@FXML
	private TabPane tapPane_RecuperarPassword;

	@FXML
	private PasswordField txtContrasenaNueva;

	@FXML
	private PasswordField txtContrasenaNuevaRepetida;

	@FXML
	private TextField txtCorreoRecuperacion;

	@FXML
	private TextField txtRespuesta;

	@FXML
	void bttCambiarPassword_Action(ActionEvent event) throws Exception {
		cambiarPassword();

	}

	@FXML
	void bttEnviarCorreo_Action(ActionEvent event) {
		validarCorreo();

	}

	@FXML
	void bttResponderPregunta_Action(ActionEvent event) {
		validarRespuesta();
	}

	@FXML
	void initialize() {

	}

	private void validarCorreo() {
		// TODO Auto-generated method stub
		vistaInicial();
		String correo = txtCorreoRecuperacion.getText();
		Comprador usuario = modelFactoryController.validarCorreoRecuperacionComprador(correo);
		if (usuario != null) {
			EnvioCorreos correoRecuperacion = new EnvioCorreos();
			correoRecuperacion.createEmail(correo, "Correo de recuperación",
					"Para recuperar tu contraseña debes responder la siguiente pregunta: \n "
							+ usuario.getPreguntaSeguridad());
			correoRecuperacion.sendEmail();
			mostrarMensaje("Exito", "Correo enviado",
					"Se ha enviado exitosamente el correo de recuperacion a " + correo, AlertType.INFORMATION);
			vistaCorreoEnviado();
			compradorEncontrado = usuario;
		} else {
			mostrarMensaje("No encontrado", "Correo no enviado",
					"No se ha encontrado correo de recuperacion : " + correo, AlertType.WARNING);
			vistaInicial();
		}
	}

	
	private void cambiarPassword() throws  Exception {
		// TODO Auto-generated method stub
		Comprador persona = null;
		String password = txtContrasenaNueva.getText();
		String passwordConfirma = txtContrasenaNuevaRepetida.getText();
		if (validarTexto(password) && validarTexto(passwordConfirma)) {
			if (verificarContraseña(password)) {
				if (password.equalsIgnoreCase(passwordConfirma)) {
					persona = modelFactoryController.cambiarPaswordComprador(compradorEncontrado.getCedula(), password);
					if (persona != null) {
						mostrarMensaje("Se ha cambiado la contrase�a con �xito",
								"Se cambi� la contrase�a", "Se ha cambiado la contrase�a con exito",
								AlertType.INFORMATION);
						modelFactoryController.guardarXML();
						cerrarVentana();
					} else {
						mostrarMensaje("Ha ocurrido algo", "No se cambi� la contrase�a",
								"Se ha cambiado la contrase�a con exito", AlertType.INFORMATION);

					}
				} else {
					mostrarMensaje("Ha ocurrido algo", "No se cambi� la contrase�a",
							"Las contrase�as deben ser iguales en los dos campos", AlertType.INFORMATION);
				}
			}

		} else {
			mostrarMensaje("Ha ocurrido algo", "No se cambi� la contrase�a",
					"Hay algun campo vacio o nulo", AlertType.INFORMATION);
		}

	}

	private void vistaCorreoEnviado() {
		// TODO Auto-generated method stub
		txtRespuesta.setDisable(false);
		bttResponderPregunta.setDisable(false);
	}

	public void vistaRespuetaCorrecta() {
		// TODO Auto-generated method stub
		tabRecup_Correo.setDisable(true);
		tabCambiar_Pass.setDisable(false);
		tapPane_RecuperarPassword.getSelectionModel().select(tabCambiar_Pass);
	}

	
	private void vistaInicial() {
		// TODO Auto-generated method stub
		tapPane_RecuperarPassword.getSelectionModel().select(tabRecup_Correo);
		tabCambiar_Pass.setDisable(true);
		txtRespuesta.setDisable(true);
		bttResponderPregunta.setDisable(true);
	}

	
	private void validarRespuesta() {
		int contador = 0;
		do {// SOLO SE PUEDE ENVIAR LA RESPUESTA 3 VECES
			String respuesta = txtRespuesta.getText();
			// TODO Auto-generated method stub
			if (respuesta == null || respuesta.equalsIgnoreCase("")) {// SE VALIDA QUE NO SEA NULA NI VACIA LA CADENA
				JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
			} else {
				if (compradorEncontrado.getRespuestaSeguridad().equalsIgnoreCase(respuesta)) {
					JOptionPane.showMessageDialog(null, "Respuesta Correcta");
					vistaRespuetaCorrecta();
					break;
				}
			}
		} while (contador <= 3);

	}

	
	private void cerrarVentana() {
		// TODO Auto-generated method stub
		Stage stage = (Stage) this.bttCambiarPassword.getScene().getWindow();
		stage.close();
	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}
	private boolean validarTexto(String texto) {
		return texto != null && !texto.equalsIgnoreCase("") ? true : false;
	}
	 public static boolean verificarContraseña(String contraseña) {
	       
	        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

	       
	        Pattern pattern = Pattern.compile(regex);

	       
	        Matcher matcher = pattern.matcher(contraseña);


	       
	        return matcher.matches();
	    }
}
