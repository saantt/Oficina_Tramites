package co.edu.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Carro;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Tramite;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecretariaViewController {
	ObservableList<Tramite> listaTramitesData = FXCollections.observableArrayList();

	Aplicacion aplicacion;
	SecretariaView secretariaView;
	ModelFactoryController modelFactoryController;
	Tramite tramiteSeleccionado;
	TramitadorTramitesViewController tramitadorTramitesViewController;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRealizarTramite;

	@FXML
	private Button btnRechazarTramite;

	@FXML
	private Button btnRevisarMultasPersona;

	@FXML
	private Button btnRevisarMultasVehiculo;

	@FXML
	private TableView<Tramite> tblwTramitesPendientes;

	@FXML
	private TableColumn<Tramite, Comprador> tbwColumCompradorPendiente;

	@FXML
	private TableColumn<Tramite, Propietario> tbwColumPropietarioPendiente;

	@FXML
	private TableColumn<Tramite, Vehiculo> tbwColumVehiculoPendiente;

	@FXML
	void realizarTramite(ActionEvent event) {
		realizarTramite();
	}

	@FXML
	void rechazarTramite(ActionEvent event) {
		rechazarTramite();

	}

	@FXML
	void revisarMultasPersonas(ActionEvent event) {
		revisarMultasPersona();

	}

	@FXML
	void revisarMultasVehiculo(ActionEvent event) {
		revisarMultasVehiculo();

	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		secretariaView = new SecretariaView(modelFactoryController);
		inicializarTramites();

	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void inicializarTramites() {

		this.tbwColumCompradorPendiente.setCellValueFactory(new PropertyValueFactory<>("Comprador"));
		this.tbwColumPropietarioPendiente.setCellValueFactory(new PropertyValueFactory<>("Propietario"));
		this.tbwColumVehiculoPendiente.setCellValueFactory(new PropertyValueFactory<>("Vehiculo"));

		tblwTramitesPendientes.getItems().clear();
		tblwTramitesPendientes.setItems(getListaTramitesData());
		tblwTramitesPendientes.getSelectionModel().selectedItemProperty()
				.addListener((obs, oldSelection, newSelection) -> {

					tramiteSeleccionado = newSelection;
				});

	}

	public void realizarTramite() {

		if (tramiteSeleccionado != null) {
			modelFactoryController.getOficina().getListaTramiteRealizado().add(tramiteSeleccionado);
			mostrarMensaje("Notificaci�n Tramite", "El tramite fue realizado con exito", "Tramite Realizado",
					AlertType.CONFIRMATION);
			listaTramitesData.remove(tramiteSeleccionado);

		} else {
			mostrarMensaje("Notificaci�n Tramite", "El tramite NO fue realizado con exito",
					"Selecciona el tramite que desea realizar", AlertType.ERROR);
		}
	}

	public void revisarMultasPersona() {

		if (tramiteSeleccionado != null) {
			mostrarMensaje("Notificaci�n Multas", "Ninguna de las personas tiene multas a su nombre",
					"Se revisaron las multas con exito", AlertType.INFORMATION);
		} else {
			mostrarMensaje("Notificaci�n Tramite", "Tramite NO seleccionado", "Seleccione un Tramite", AlertType.ERROR);

		}
	}

	public void rechazarTramite() {

		if (tramiteSeleccionado != null) {

			if (mostrarMensajeConfirmacion("Esta segura de RECHAZAR este tramite?")) {
				listaTramitesData.remove(tramiteSeleccionado);
			}
		} else {
			mostrarMensaje("Notificaci�n Tramite", "Tramite NO RECHAZADO", "El tramite no fue rechazado con exito",
					AlertType.ERROR);

		}
	}

	public void revisarMultasVehiculo() {
		Carro carro;

		if (tramiteSeleccionado != null) {

			mostrarMensaje("Notificaci�n Multas", "El Vehiculo no presenta multas", "Se revisaron las multas con exito",
					AlertType.INFORMATION);
		} else {
			mostrarMensaje("Notificaci�n Tramite", "Tramite NO seleccionado", "Seleccione un Tramite", AlertType.ERROR);

		}
	}

	private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

		Alert alert = new Alert(alertType);

		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}

	private boolean mostrarMensajeConfirmacion(String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Confirmacion");
		alerta.setContentText(mensaje);
		Optional<ButtonType> action = alerta.showAndWait();
		if (action.get() == ButtonType.OK) {
			return true;
		}

		return false;

	}

	public ObservableList<Tramite> getListaTramitesData() {
		listaTramitesData.addAll(secretariaView.obtenerTramitesSecretaria());
		return listaTramitesData;
	}

	public void setListaTramitesData(ObservableList<Tramite> listaTramitesData) {
		this.listaTramitesData = listaTramitesData;
	}
}
