package co.edu.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Carro;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Persona;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Secretaria;
import co.edu.uqvirtual.proyectofinal.model.SedeTransito;
import co.edu.uqvirtual.proyectofinal.model.Tramitador;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TramitadorFormulariosController {

	Aplicacion aplicacion;
	TramitadorView tramiadorView;
	ModelFactoryController modelFactoryController;

	ObservableList<Comprador> listaCompradoresData = FXCollections.observableArrayList();
	ObservableList<Propietario> listaPropietariosData = FXCollections.observableArrayList();
	ObservableList<Persona> listaSecretariasData = FXCollections.observableArrayList();
	ObservableList<SedeTransito> listaSedesData = FXCollections.observableArrayList();
	ObservableList<Tramitador> listaTramitadoresData = FXCollections.observableArrayList();
	ObservableList<Vehiculo> listaVehiculosData = FXCollections.observableArrayList();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnGenerarPazSalvo;

	@FXML
	private Button btnLlenarFormulario;

	@FXML
	private ComboBox<Comprador> comboComprador;

	@FXML
	private ComboBox<Propietario> comboPropietario;

	@FXML
	private ComboBox<Persona> comboSecretaria;

	@FXML
	private ComboBox<SedeTransito> comboSedeTransito;

	@FXML
	private ComboBox<Tramitador> comboTramitador;

	@FXML
	private ComboBox<Vehiculo> comboVehiculo;

	@FXML
	void generarPazSalvo(ActionEvent event) {
		mostrarPazSalvo();

	}

	@FXML
	void llenarFormulario(ActionEvent event) {
		llenarFormulario();
	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		tramiadorView = new TramitadorView(modelFactoryController);
		incicializarFormularios();

	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void incicializarFormularios() {
		this.comboComprador.setItems(getListaCompradoresData());
		this.comboPropietario.setItems(getListaPropietariosData());
		this.comboSecretaria.setItems(getListaSecretariasData());
		this.comboSedeTransito.setItems(getListaSedesData());
		this.comboTramitador.setItems(getListaTramitadoresData());
		this.comboVehiculo.setItems(getListaVehiculosData());
	}

	public void mostrarPazSalvo() {
		Comprador comprador;
		Propietario propietario;
		SedeTransito sedeTransito;
		Vehiculo vehiculo;
		String vehiculoPlaca;
		String vehiculoColor;
		String vehiculoSeguro;
		String vehiculoMarca;
		String vehiculoModelo;

		if (comboComprador.getSelectionModel().getSelectedItem() != null
				&& comboPropietario.getSelectionModel().getSelectedItem() != null
				&& comboSecretaria.getSelectionModel().getSelectedItem() != null
				&& comboSedeTransito.getSelectionModel().getSelectedItem() != null
				&& comboTramitador.getSelectionModel().getSelectedItem() != null
				&& comboVehiculo.getSelectionModel().getSelectedItem() != null) {

			comprador = comboComprador.getValue();
			propietario = comboPropietario.getValue();
			sedeTransito = comboSedeTransito.getValue();
			vehiculo = comboVehiculo.getValue();
			vehiculoPlaca = comboVehiculo.getValue().getPlaca();
			vehiculoColor = comboVehiculo.getValue().getColor();
			vehiculoSeguro = comboVehiculo.getValue().getSeguro();
			vehiculoMarca = comboVehiculo.getValue().getMarca();
			vehiculoModelo = comboVehiculo.getValue().getModelo();

			mostrarMensaje("PAZ Y SALVO GENERADO",
					"COMPRADOR: " + comprador + "\n" + "PROPIETARIO: " + propietario + "\n" + "SEDE: " + sedeTransito
							+ "\n" + "VEHICULO: " + vehiculo + "\n" + "VEHICULO COLOR: " + vehiculoColor + "\n"
							+ "VEHICULO MARCA: " + vehiculoMarca + "\n" + "VEHICULO MODELO: " + vehiculoModelo + "\n"
							+ "VEHICULO PLACA: " + vehiculoPlaca + "\n" + "VEHICULO SEGURO: " + vehiculoSeguro,
					"El Paz y Salvo se genero correctamente", AlertType.CONFIRMATION);
			establecerCombo();
		} else {
			mostrarMensaje("Notificacion Paz y Salvo", "NO se pudo generar el paz y salvo",
					"Los campos estan incompletos", AlertType.ERROR);
		}
	}

	public void llenarFormulario() {
		if (comboComprador.getSelectionModel().getSelectedItem() != null
				&& comboPropietario.getSelectionModel().getSelectedItem() != null
				&& comboSecretaria.getSelectionModel().getSelectedItem() != null
				&& comboSedeTransito.getSelectionModel().getSelectedItem() != null
				&& comboTramitador.getSelectionModel().getSelectedItem() != null
				&& comboVehiculo.getSelectionModel().getSelectedItem() != null) {

			mostrarMensaje("Notificacion Formulario", "El Formulario Se Lleno Correctamente",
					"El Formulario Esta Lleno", AlertType.CONFIRMATION);

			establecerCombo();

		} else {
			mostrarMensaje("Notificacion Formulario", "NO se pudo llenar el formulario", "Los campos estan incompletos",
					AlertType.ERROR);
		}

	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}

	private void establecerCombo() {
		comboComprador.setValue(null);
		comboPropietario.setValue(null);
		comboSecretaria.setValue(null);
		comboSedeTransito.setValue(null);
		comboTramitador.setValue(null);
		comboVehiculo.setValue(null);
	}

	public ObservableList<Comprador> getListaCompradoresData() {
		listaCompradoresData.addAll(tramiadorView.obtenerCompradores());
		return listaCompradoresData;
	}

	public ObservableList<Propietario> getListaPropietariosData() {
		listaPropietariosData.addAll(tramiadorView.obtenerPropietarios());
		return listaPropietariosData;
	}

	public ObservableList<Persona> getListaSecretariasData() {
		listaSecretariasData.addAll(tramiadorView.obtenerSecretarias());
		return listaSecretariasData;
	}

	public ObservableList<SedeTransito> getListaSedesData() {
		listaSedesData.addAll(tramiadorView.obtenerSedes());
		return listaSedesData;
	}

	public ObservableList<Tramitador> getListaTramitadoresData() {
		listaTramitadoresData.addAll(tramiadorView.obtenerTramitadores());
		return listaTramitadoresData;
	}

	public ObservableList<Vehiculo> getListaVehiculosData() {
		listaVehiculosData.addAll(tramiadorView.obtenerVehiculos());
		return listaVehiculosData;
	}

}
