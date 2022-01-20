package dataAcces.accesofichero.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
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
import javafx.stage.DirectoryChooser;
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
    private ListView<File> ficherosListDerecho;

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
		ficherosListDerecho.itemsProperty().bind(acceso.listadoDerechoProperty());
		modificarText.textProperty().bindBidirectional(acceso.subRutaProperty());
		
		////////////////////////////////////////////////////////
		
		acceso.subRutaProperty().addListener(o->OnActualizarSubRuta());
		//acceso.subRutaProperty().addListener(o->onClickListadoDerecho(null));
		
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
			  acceso.setSubRuta(ficherosListDerecho.getSelectionModel().getSelectedItem().getAbsolutePath());	  
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
	 void verFicherosOnAction(ActionEvent event) {

		 try {
			 acceso.getListadoIzquierdo().clear();
		 acceso.setFichero(new File(acceso.getRutaActual()));
			acceso.getListadoIzquierdo().addAll(acceso.getFichero().listFiles());
	    }
		 catch (NullPointerException e) {
			e.printStackTrace();
		}
	 }
	
	 @FXML
	 void moverOnAction(ActionEvent event) throws IOException {

		 File moverAlDirectorio=acceso.getFichero();
		 File directorioDestino;
		 
		 DirectoryChooser directorio=new DirectoryChooser();
		 
		 directorio.setTitle("Ruta destino: ");

		directorioDestino=directorio.showDialog(splitpaneMain.getContextMenu());
		 
		mover(moverAlDirectorio, directorioDestino);
		
	    }
	private void mover(File moverAlDirectorio, File directorioDestino) throws IOException {
		if(moverAlDirectorio.isFile()) {
			Files.move(acceso.getFichero().toPath(),directorioDestino.toPath());
		}
	}
	
	 @FXML
	 void CrearOnAction(ActionEvent event) {

		 
		 
	    }
	 
	 @FXML
	 void EliminarOnAction(ActionEvent event) {

		 File aux;
		 aux=acceso.getFichero().getParentFile();
		 eliminar(acceso.getFichero());
		 acceso.setSubRuta(aux.getAbsolutePath());
		 
	    }
	private void eliminar(File fileABorrar) {
		if(fileABorrar.isFile()) {
			 
			 fileABorrar.delete();
			 
		 }
		 else {
			for (File subFileABorrar : fileABorrar.listFiles()) {
				eliminar(subFileABorrar);
			}
			fileABorrar.delete();
		 }
	}
	 
	 @FXML
	 void confirmarOnAction(ActionEvent event) {

		 
	    }
	 
	 @FXML
	    void enterPressed(KeyEvent event) {

		 
	    }
	 
	 @FXML
	    void onClickListenerIzquierdo(MouseEvent event) {
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
