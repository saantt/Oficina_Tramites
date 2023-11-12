package co.edu.uqvirtual.proyectofinal.aplicacion;


import co.edu.uqvirtual.proyectofinal.controllers.LoginCompradorViewController;
import co.edu.uqvirtual.proyectofinal.controllers.LoginPropietarioViewController;
import co.edu.uqvirtual.proyectofinal.controllers.LoginSecretariaViewController;
import co.edu.uqvirtual.proyectofinal.controllers.LoginTramitadorViewController;
import co.edu.uqvirtual.proyectofinal.controllers.NotificacionesController;
import co.edu.uqvirtual.proyectofinal.controllers.RecuperarPassCompradorController;
import co.edu.uqvirtual.proyectofinal.controllers.RecuperarPassPropietario;
import co.edu.uqvirtual.proyectofinal.controllers.RegistroCompradorController;
import co.edu.uqvirtual.proyectofinal.controllers.RegistroPropietarioController;
import co.edu.uqvirtual.proyectofinal.controllers.SecretariaViewController;
import co.edu.uqvirtual.proyectofinal.controllers.TramitadorFormulariosController;
import co.edu.uqvirtual.proyectofinal.controllers.TramitadorTramitesViewController;
import co.edu.uqvirtual.proyectofinal.controllers.VistaInicialController;
import co.edu.uqvirtual.proyectofinal.model.Oficina;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    Oficina oficina = new Oficina();


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("OFICINA TRAMITES");
        
        mostrarVentanaPrincipal();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uqvirtual/proyectofinal/view/ViewInicial.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VistaInicialController vistaInicialController = loader.getController();
            vistaInicialController.setAplicacion(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public void abrirAgregarPropietario() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/RegistroPropietarioView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        RegistroPropietarioController vcc = (RegistroPropietarioController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();



    }
    public void abrirAgregarComprador() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/RegistroCompradorView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        RegistroCompradorController vcc = (RegistroCompradorController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    public void abrirLoginComprador() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/LoginCompradroView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        LoginCompradorViewController vcc = (LoginCompradorViewController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    public void abrirLoginPropietario() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/LoginPropietarioView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        LoginPropietarioViewController vcc = (LoginPropietarioViewController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    public void recuperarContrasenaComprador() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/RecuperarPassCompradorView.fxml"));
		Parent root2 = (Parent) fxmlLouder.load();
		RecuperarPassCompradorController vcc = (RecuperarPassCompradorController) fxmlLouder.getController();
		vcc.setAplicacion(this);
		Stage stage = new Stage();
		stage.setTitle("Tramites");
		stage.setScene(new Scene(root2));
		stage.initModality(Modality.APPLICATION_MODAL);//esta linea hace que no retorne a la otra vista hasta que cierres esta
		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
		stage.setResizable(false);
		stage.show();
	}
    public void recuperarContrasenaPropietario() throws IOException {
  		// TODO Auto-generated method stub
  		FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/RecuperarPassPropietarioView.fxml"));
  		Parent root2 = (Parent) fxmlLouder.load();
  		RecuperarPassPropietario vcc = (RecuperarPassPropietario) fxmlLouder.getController();
  		vcc.setAplicacion(this);
  		Stage stage = new Stage();
  		stage.setTitle("Tramites");
  		stage.setScene(new Scene(root2));
  		stage.initModality(Modality.APPLICATION_MODAL);//esta linea hace que no retorne a la otra vista hasta que cierres esta
  		//stage.getIcons().add(new Image("/co/com/emo/Proyecto_Activos_TIC/Resources/Icons/miIconoRed.png"));
  		stage.setResizable(false);
  		stage.show();
  	}
    public void abrirLoginTramitador() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/LoginTramitadorView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        LoginTramitadorViewController vcc = (LoginTramitadorViewController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    public void abrirLoginSecretaria() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/LoginSecretariaView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        LoginSecretariaViewController vcc = (LoginSecretariaViewController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    
    public void abrirTramitadorTramites() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/TramitadorTramitesView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        TramitadorTramitesViewController vcc = (TramitadorTramitesViewController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    
    public void abrirSecretariaView() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/SecretariaView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        SecretariaViewController vcc = (SecretariaViewController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    
    public void abrirTramitadorFormularios() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/TramitadorFormularioView.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        TramitadorFormulariosController vcc = (TramitadorFormulariosController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    public void abrirEnviarNotificacion() throws IOException {
        FXMLLoader fxmlLouder = new FXMLLoader(getClass().getResource("/co/edu/uqvirtual/proyectofinal/view/EnviarCorreoNotificacion.fxml"));
        Parent root2 = (Parent) fxmlLouder.load();
        NotificacionesController vcc = (NotificacionesController) fxmlLouder.getController();
        vcc.setAplicacion(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();


    }
    
   
    
}
