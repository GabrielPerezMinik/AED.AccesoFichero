package dataAcces.accesofichero.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dataAcces.accesofichero.Model.AccesoFicheroModelo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class AccesoFicheroController implements Initializable{
	
	
    AccesoFicheroModelo acceso=new AccesoFicheroModelo();
	
	@FXML
    private SplitPane splitpaneMain;
	
	 @FXML
	 private Button backButton;
	
	@FXML
    private Button crearButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private ListView<File> listadoIzquierdaFicheroListView;

    @FXML
    private Button moverButton;

    @FXML
    private TextField ubicacionFicheroText;

    @FXML
    private Button verFicheroCarpetasButton;
    
    //vistaSubcarpeta
    
    @FXML
    private Button cancelarButton;

    @FXML
    private Button confirmarButton;

    @FXML
    private ListView<File> ficherosList;

    @FXML
    private TextField modificarText;

    @FXML
    private BorderPane modificarView;
    
	
	public AccesoFicheroController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/AccesoFichero.fxml"));
		loader.setController(this);
		loader.load();
		////////////////////////////////////////////////////////
		
		ubicacionFicheroText.textProperty().bindBidirectional(acceso.rutaActualProperty());
		listadoIzquierdaFicheroListView.itemsProperty().bind(acceso.listadoIzquierdoProperty());
		ficherosList.itemsProperty().bind(acceso.listadoDerechoProperty());
		modificarText.textProperty().bindBidirectional(acceso.subRutaProperty());
		
		////////////////////////////////////////////////////////
		
		acceso.subRutaProperty().addListener(o->OnActualizarSubRuta());
	//	acceso.listadoDerechoProperty().addListener(o->onClickListadoDerecho(null));
		
	}
	private void OnActualizarSubRuta() {
		 acceso.getListadoDerecho().clear();
		 acceso.setFichero(new File(acceso.getSubRuta()));
		 if(acceso.getFichero().isDirectory()) {
		 acceso.getListadoDerecho().addAll(acceso.getFichero().listFiles());
		 } 
	}
	
	
	 @FXML
	    void onClickListadoDerecho(MouseEvent event) {

		  if(null!=acceso.getFichero().getParent()) {
			 
		  }
		  
	    }
	
	
	public void initialize(URL location, ResourceBundle resources) {
		splitpaneMain.getItems().remove(modificarView);
		acceso.setRutaActual(System.getProperty("user.home"));
		 acceso.setFichero(new File(acceso.getRutaActual()));
		acceso.getListadoIzquierdo().addAll(acceso.getFichero().listFiles());
		
	}

	
	public SplitPane getView() {
		return splitpaneMain;
	}
	
	@FXML
	void cancelarButtonOnAction(ActionEvent event) {
		
	}
	
	 @FXML
	 void verFicherosOnAction(ActionEvent event) {

		 try {
		 acceso.setFichero(new File(acceso.getRutaActual()));
			acceso.getListadoIzquierdo().addAll(acceso.getFichero().listFiles());
	    }
		 catch (NullPointerException e) {
			e.printStackTrace();
		}
	 }
	
	 @FXML
	 void moverOnAction(ActionEvent event) {

		 
	    }
	
	 @FXML
	 void CrearOnAction(ActionEvent event) {

		 
		 
	    }
	 
	 @FXML
	 void EliminarOnAction(ActionEvent event) {

		 
	    }
	 
	 @FXML
	 void confirmarOnAction(ActionEvent event) {

		 
	    }
	 
	 @FXML
	    void enterPressed(KeyEvent event) {

		 
	    }
	 
	 @FXML
	    void onClickListener(MouseEvent event) {
		 if(!splitpaneMain.getItems().contains(modificarView)) {
			 splitpaneMain.getItems().add(modificarView);
		 }
		 
		 acceso.setSubRuta(listadoIzquierdaFicheroListView.getSelectionModel().getSelectedItem().getAbsolutePath());
		 
		 
		 
	    }
	 
	  @FXML
	    void onBackAction(ActionEvent event) {

		  if(null!=acceso.getFichero().getParent()) {
		  acceso.setSubRuta(acceso.getFichero().getParent());
		  acceso.setFichero(acceso.getFichero().getParentFile());
		  
		  
		  //hacer listener en la lista derecha, que actualice la subruta y actualice el file de la derecha
		  
		  }
	    }
	  
	  
	  
	 
}
