package co.edu.uqvirtual.proyectofinal.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uqvirtual.proyectofinal.aplicacion.Aplicacion;
import co.edu.uqvirtual.proyectofinal.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SeleccionVehiculoController {
	Aplicacion aplicacion;
	// SE LLAMA LA INSTANCIA DEL MODEL FACTORY CONTROLLER
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	ObservableList<Vehiculo> listVheiculos = FXCollections.observableArrayList();
	public void setModelFactoryController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button bttSeleccionar;

	@FXML
	private TableColumn<Vehiculo, String> colKilometraje;

	@FXML
	private TableColumn<Vehiculo, String> colMarca;

	@FXML
	private TableColumn<Vehiculo, String> colModelo;

	@FXML
	private TableColumn<Vehiculo, String> colPlaca;

	@FXML
	private TableView<Vehiculo> tblVehiculos;
	Vehiculo vehiculoSeleccionado=null;

	@FXML
	void seleccionarVehiculo(ActionEvent event) {
		if (vehiculoSeleccionado!=null) {
			modelFactoryController.vehiculoSeleccionadoSoli = vehiculoSeleccionado;
			cerrarVentana();
		}
	}
	private void cerrarVentana() {
		// TODO Auto-generated method stub
		Stage stage =  (Stage) this.bttSeleccionar.getScene().getWindow();
		stage.close();
	}
	@FXML
	void initialize() {
		inicializar();
	}

	public void inicializar() {
		this.colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		this.colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		this.colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		this.colKilometraje.setCellValueFactory(new PropertyValueFactory<>("kilometraje"));

		tblVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {


			vehiculoSeleccionado = newSelection;


		});
		cargarVehiculosPropietario();
	}

	private void cargarVehiculosPropietario() {
		// TODO Auto-generated method stub
		tblVehiculos.getItems().clear();
		tblVehiculos.setItems(obtenerVehiculosPropietario());
	}

	private ObservableList<Vehiculo> obtenerVehiculosPropietario() {
		// TODO Auto-generated method stub
		listVheiculos.addAll(modelFactoryController.obtenerVehiculosPropietario());
		return listVheiculos;
	}
}
