package co.edu.uqvirtual.proyectofinal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Ciudades;
import co.edu.uqvirtual.proyectofinal.model.Comprador;
import co.edu.uqvirtual.proyectofinal.model.Propietario;
import co.edu.uqvirtual.proyectofinal.model.Tramite;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TramitadorTramitesViewController {

	Aplicacion aplicacion;
	Tramite tramiteSeleccionado;
	ModelFactoryController modelFactoryController;
	TramitadorView tramitadorView;

	ObservableList<Tramite> listaTramitesData = FXCollections.observableArrayList();
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
	private TableView<?> tblwTramitesPendientes;

	@FXML
	private TableColumn<?, ?> tbwColumCiudadPendiente;

	@FXML
	private TableColumn<Tramite, String> tbwColumCiudadTramite;

	@FXML
	private TableColumn<?, ?> tbwColumCompradorPendiente;

	@FXML
	private TableColumn<Tramite, Comprador> tbwColumCompradorTramite;

	@FXML
	private TableColumn<?, ?> tbwColumCorreoPendiente;

	@FXML
	private TableColumn<?, ?> tbwColumPropietarioPendiente;

	@FXML
	private TableColumn<Tramite, Propietario> tbwColumPropietarioTramite;

	@FXML
	private TableColumn<?, ?> tbwColumVehiculoPendiente;

	@FXML
	private TableColumn<Tramite, Vehiculo> tbwColumVehiculoTramite;

	@FXML
	void entregarTarjetaa(ActionEvent event) {

	}

	@FXML
	void llenarFormulario(ActionEvent event) throws IOException {

		aplicacion.abrirTramitadorFormularios();

	}

	@FXML
	void realizarTramite(ActionEvent event) {

	}

	@FXML
	void tramiteRelacionado(ActionEvent event) {

	}

	@FXML
	void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		tramitadorView = new TramitadorView(modelFactoryController);
		inicializarTramites();

	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void inicializarTramites() {
		this.tbwColumCiudadTramite.setCellValueFactory(new PropertyValueFactory<>("Ciudad"));
		this.tbwColumCompradorTramite.setCellValueFactory(new PropertyValueFactory<>("Comprador"));
		this.tbwColumPropietarioTramite.setCellValueFactory(new PropertyValueFactory<>("Propietario"));
		this.tbwColumVehiculoTramite.setCellValueFactory(new PropertyValueFactory<>("Vehiculo"));

		tblwTramites.getItems().clear();
		tblwTramites.setItems(getListaTramitesData());

	}

	public ObservableList<Tramite> getListaTramitesData() {
		listaTramitesData.addAll(tramitadorView.obtenerTramites());
		return listaTramitesData;
	}

}
