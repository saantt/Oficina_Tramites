package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Ciudades;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Solicitud;
import co.edu.uqvirtual.proyectofinal.model.Tramite;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TramitadorTramitesViewController {

	Aplicacion aplicacion;

	public void setListaTramitesData(ObservableList<Tramite> listaTramitesData) {
		this.listaTramitesData = listaTramitesData;
	}

	public void setListaTramitesRealizadosData(ObservableList<Tramite> listaTramitesRealizadosData) {
		this.listaTramitesRealizadosData = listaTramitesRealizadosData;
	}

	Tramite tramiteSeleccionado;
	ModelFactoryController modelFactoryController;
	TramitadorView tramitadorView;
	Solicitud solicitudSelecciona;

	ObservableList<Tramite> listaTramitesData = FXCollections.observableArrayList();
	ObservableList<Tramite> listaTramitesRealizadosData = FXCollections.observableArrayList();
	ObservableList<Solicitud> listaSolicitudesData = FXCollections.observableArrayList();

	@FXML
	private TableColumn<Solicitud, Comprador> tblcCedulaCompradorSolicitud;

	@FXML
	private TableColumn<Solicitud, Propietario> tblcCedulaPropieatarioSolicitud;

	@FXML
	private TableColumn<Solicitud, String> tblcCiudadSolicitud;

	@FXML
	private TableColumn<Solicitud, Vehiculo> tblcVehiculoSolicitud;

	@FXML
	private TableView<Solicitud> tblwSolicitud;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnEntregarTarjetaa;

	@FXML
	private Button btnLlenarFormualrio;

	@FXML
	private Button btnRealizarTramite;

	@FXML
	private Button btnTramiteRealizado;

	@FXML
	private TableView<Tramite> tblwTramites;

	@FXML
	private TableView<Tramite> tblwTramitesPendientes;

	@FXML
	private TableColumn<Tramite, Comprador> tbwColumCompradorPendiente;

	@FXML
	private TableColumn<Tramite, Comprador> tbwColumCompradorTramite;

	@FXML
	private TableColumn<Tramite, Propietario> tbwColumPropietarioPendiente;

	@FXML
	private TableColumn<Tramite, Propietario> tbwColumPropietarioTramite;

	@FXML
	private TableColumn<Tramite, Vehiculo> tbwColumVehiculoPendiente;

	@FXML
	private TableColumn<Tramite, Vehiculo> tbwColumVehiculoTramite;

	@FXML
	void entregarTarjetaa(ActionEvent event) throws IOException {
		aplicacion.abrirEnviarNotificacion();

	}

	@FXML
	void llenarFormulario(ActionEvent event) throws IOException {

		generarFormulario();

	}

	private void generarFormulario() {
		// TODO Auto-generated method stub
		if (solicitudSelecciona!=null) {
			Tramite nuevoFormularioTramite=modelFactoryController.crearTramite(solicitudSelecciona);
		}
	}

	@FXML
	void realizarTramite(ActionEvent event) {
		enviarTramite();

	}

	@FXML
	void tramiteRelacionado(ActionEvent event) {
		mostrarInformacion();

	}

	@FXML
	void generarPazSalvo(ActionEvent event) throws IOException {
		aplicacion.abrirPazSalvo();

	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		tramitadorView = new TramitadorView(modelFactoryController);
		inicializarSolicitudes();
		inicializarTramites();
		inicializarTramitesPendientes();
		

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

		tblwTramites.getItems().clear();
		tblwTramites.setItems(getListaTramitesData());
		tblwTramites.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			tramiteSeleccionado = newSelection;
		});

	}

	public void inicializarTramitesPendientes() {

		this.tbwColumCompradorTramite.setCellValueFactory(new PropertyValueFactory<>("Comprador"));
		this.tbwColumPropietarioTramite.setCellValueFactory(new PropertyValueFactory<>("Propietario"));
		this.tbwColumVehiculoTramite.setCellValueFactory(new PropertyValueFactory<>("Vehiculo"));

		tblwTramitesPendientes.getItems().clear();
		tblwTramitesPendientes.setItems(getListaTramitesRealizadosData());
		tblwTramitesPendientes.getSelectionModel().selectedItemProperty()
		.addListener((obs, oldSelection, newSelection) -> {

			tramiteSeleccionado = newSelection;
		});

	}
	@FXML
	public void inicializarSolicitudes() {

		this.tblcCedulaCompradorSolicitud.setCellValueFactory(new PropertyValueFactory<>("CedulaComprador"));
		this.tblcCedulaPropieatarioSolicitud.setCellValueFactory(new PropertyValueFactory<>("CedulaPropietario"));
		this.tblcVehiculoSolicitud.setCellValueFactory(new PropertyValueFactory<>("placa"));
		this.tblcCiudadSolicitud.setCellValueFactory(new PropertyValueFactory<>("Ciudad"));


		tblwSolicitud.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			solicitudSelecciona = newSelection;
		});
		cargarSolicitudes();
	}

	private void cargarSolicitudes() {
		// TODO Auto-generated method stub
		tblwSolicitud.getItems().clear();
		tblwSolicitud.setItems(getListaSolicitudesData());
	}

	private ObservableList<Solicitud> getListaSolicitudesData() {
		listaSolicitudesData.addAll(modelFactoryController.obtenerSolicitud());
		return listaSolicitudesData;
	}

	public ObservableList<Tramite> getListaTramitesData() {
		listaTramitesData.addAll(tramitadorView.obtenerTramites());
		return listaTramitesData;
	}

	public ObservableList<Tramite> getListaTramitesRealizadosData() {
		listaTramitesRealizadosData.addAll(tramitadorView.obtenerTramitesRealizados());
		return listaTramitesRealizadosData;
	}

	public void mostrarInformacion() {
		String correoComprador;
		Ciudades ciudad;
		if (tramiteSeleccionado != null) {
			ciudad = tramiteSeleccionado.getSedeTransito().getCiudades();
			correoComprador = tramiteSeleccionado.getComprador().getEmail();
			mostrarMensaje("Notificaci�n Tramite", "Tramite Realizado con exito",
					"Para entregar la tarjeta notifique al comprador al siguiente correo  " + correoComprador
					+ " y la ciudad " + ciudad,
					AlertType.CONFIRMATION);
		} else {
			mostrarMensaje("Notificaci�n Tramite", "Tramite NO Realizado", "Seleccione el tramite que desea Notificar",
					AlertType.ERROR);
		}
	}

	public void enviarTramite() {
		Ciudades ciudad;
		if (tramiteSeleccionado != null) {
			ciudad = tramiteSeleccionado.getSedeTransito().getCiudades();
			mostrarMensaje("Notificaci�n Tramite", "Tramite Enviado a Sede de transito " + ciudad,
					"El Tramite se ha enviado con �xito", AlertType.CONFIRMATION);
		} else {
			mostrarMensaje("Notificaci�n Tramite", "Tramite NO seleccionado", "El Tramite NO se ha enviado con �xito",
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

}
