package dataAcces.accesofichero.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import dataAcces.accesofichero.Model.AccesoFicheroModelo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class AccesoFicheroController implements Initializable{
	
	
    AccesoFicheroModelo acceso=new AccesoFicheroModelo();
	
	@FXML
    private SplitPane splitpaneMain;
	
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
		////////////////////////////////////////
		
		ubicacionFicheroText.textProperty().bindBidirectional(acceso.rutaActualProperty());
		listadoIzquierdaFicheroListView.itemsProperty().bind(acceso.listadoIzquierdoProperty());
		ficherosList.itemsProperty().bind(acceso.listadoDerechoProperty());
		modificarText.textProperty().bindBidirectional(acceso.subRutaProperty());
		
		////////////////////////////////////////////////////////
		acceso.rutaActualProperty().addListener(o->onRutaActualChanged());
	}

	private void onRutaActualChanged() {
		
		acceso.setFichero(new File(acceso.getRutaActual()));
		
		acceso.getListadoIzquierdo().addAll(Arrays.asList(acceso.getFichero().listFiles()));
		
	}

	public void initialize(URL location, ResourceBundle resources) {
		splitpaneMain.getItems().remove(modificarView);
		acceso.setRutaActual(System.getProperty("user.home"));
		onRutaActualChanged();
	}

	
	public SplitPane getView() {
		return splitpaneMain;
	}
	
	
	
	
	
}
