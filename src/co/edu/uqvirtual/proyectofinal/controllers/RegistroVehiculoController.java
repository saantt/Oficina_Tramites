package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Carro;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class RegistroVehiculoController {
	Aplicacion aplicacion;
	// SE LLAMA LA INSTANCIA DEL MODEL FACTORY CONTROLLER
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAgregarVehiculo;

	@FXML
	private Button btnCargarImagen;

	@FXML
	private TextField txtCedulaComprador;

	@FXML
	private TextField txtCedulaPropietario;

	@FXML
	private TextField txtColor;

	@FXML
	private TextField txtDireccionImagen;

	@FXML
	private TextField txtFecha;

	@FXML
	private TextField txtKilometraje;

	@FXML
	private TextField txtMarca;

	@FXML
	private TextField txtModelo;

	@FXML
	private TextField txtMultas;

	@FXML
	private TextField txtNumeroMotor;

	@FXML
	private TextField txtPlaca;

	@FXML
	private TextField txtPrecio;

	@FXML
	private TextField txtSeguro;

	@FXML
	private TextField txtTEcnicoMecanica;

	@FXML
	private TextField txtTipoCombustible;

	@FXML
	void agregarVehiculo(ActionEvent event) {
		agregarVehiculo();
	}

	private void agregarVehiculo() {
		// TODO Auto-generated method stub
		String cedulaCom = txtCedulaComprador.getText();
		String cedulaPro = txtCedulaPropietario.getText();
		String placa = txtPlaca.getText();
		String seguro = txtSeguro.getText();
		String modelo = txtModelo.getText();
		String tecnicoMecanica = txtTEcnicoMecanica.getText();
		String kilometraje = txtKilometraje.getText();
		String precio = txtPrecio.getText();
		String color = txtColor.getText();
		String numeroMotor = txtNumeroMotor.getText();
		String marca = txtMarca.getText();
		String imagen = txtDireccionImagen.getText();

		if (validarDatosRegistro(placa, seguro, modelo, tecnicoMecanica, kilometraje, precio, color, numeroMotor, marca,
				imagen)) {

			Vehiculo nuevoVehiculo = modelFactoryController.crearVehiculo(placa, seguro, modelo, tecnicoMecanica,
					kilometraje, precio, color, numeroMotor, marca, imagen);
//			Propietario propietario = modelFactoryController.obtenerPropietario(cedulaPro);
//			Comprador comprador = modelFactoryController.obtenerComprador(cedulaCom);
//			propietario.setVehiculo(nuevoVehiculo);
//			comprador.setVehiculo(nuevoVehiculo);
//			modelFactoryController.getOficina().getListaPropietario().add(propietario);
//			modelFactoryController.getOficina().getListaComprador().add(comprador);

			mostrarMensaje("Notificacion Vehiculo", "Vehiculo Creado", "El vehiculo se creo con exito",
					AlertType.INFORMATION);
			limpiarDatos();
		} else {
			mostrarMensaje("Notificacion Vehiculo", "Vehiculo NO Creado", "El vehiculo NO se creo con exito",
					AlertType.ERROR);
		}

	}

	private void limpiarDatos() {
		// TODO Auto-generated method stub
		txtCedulaComprador.setText("");
		txtCedulaPropietario.setText("");
		txtColor.setText("");
		txtDireccionImagen.setText("");
		txtFecha.setText("");
		txtKilometraje.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtMultas.setText("");
		txtNumeroMotor.setText("");
		txtPlaca.setText("");
		txtPrecio.setText("");
		txtSeguro.setText("");
		txtTEcnicoMecanica.setText("");
		txtTipoCombustible.setText("");

	}

	private boolean validarDatosRegistro(String placa, String seguro, String modelo, String tecnicoMecanica,
			String kilometraje, String precio, String color, String numeroMotor, String marca, String imagen) {
		// TODO Auto-generated method stub
		String mensajeError = "Hay valores nulos o vacios en los siguientes campos: \n";
		String mensaje = "Hay valores nulos o vacios en los siguientes campos: \n";
		if (!validarCadenaBoolean(placa)) {
			mensajeError += "-Placa \n ";
		}
		if (!validarCadenaBoolean(seguro)) {
			mensajeError += "-Seguro \n ";
		}
		if (!validarCadenaBoolean(modelo)) {
			mensajeError += "-Modelo \n ";
		}
		if (!validarCadenaBoolean(tecnicoMecanica)) {
			mensajeError += "-Tecni \n ";
		}
		if (!validarCadenaBoolean(kilometraje)) {
			mensajeError += "-Kilometraje \n ";
		}
		if (!validarCadenaBoolean(precio)) {
			mensajeError += "-Precio \n ";
		}
		if (!validarCadenaBoolean(color)) {
			mensajeError += "-Color \n ";
		}
		if (!validarCadenaBoolean(numeroMotor)) {
			mensajeError += "-Num Motor \n ";
		}
		if (!validarCadenaBoolean(marca)) {
			mensajeError += "-Marca \n ";
		}
		if (!validarCadenaBoolean(imagen)) {
			mensajeError += "-Imagen \n ";
		}

		if (!mensajeError.equalsIgnoreCase(mensaje)) {
			mostrarMensaje("Cuidado", "Error en datos digitados", mensajeError, AlertType.ERROR);
			return false;
		} else {
			return true;
		}

	}

	public static boolean validarCadenaBoolean(String cadena) {
		// TODO Auto-generated method stub
		if (cadena != null) {
			if (!cadena.equalsIgnoreCase("")) {
				return true;// retorna verdadero si no es nula ni vacia
			} else {
				// mostrarMensaje("Cuidado!", "Datos invalidos", "La cadena ingrsada estï¿½
				// vacia", AlertType.ERROR);
			}
		} else {
			// mostrarMensaje("Cuidado!", "Datos invalidos", "La cadena ingrsada es nula",
			// AlertType.ERROR);
		}

		return false;
	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}

	@FXML
	void cargarImagen(ActionEvent event) throws IOException {
		cargarImagenCancion();
	}

	@FXML
	void initialize() {
		txtDireccionImagen.setDisable(true);

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

			txtDireccionImagen.setText(imgFile.getAbsolutePath());

		}
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
