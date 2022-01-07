package dataAcces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dataAcces.accesofichero.Controller.AccesoFicheroController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable{
	

	AccesoFicheroController ficheroControl;
	
	    @FXML
	    private Tab accesoAleatorioTab;

	    @FXML
	    private Tab accesoFicheroTab;

	    @FXML
	    private Tab accesoXMLTab;

	    @FXML
	    private BorderPane root;

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Root.fxml"));
		loader.setController(this);
		loader.load();
	}

	public BorderPane getView() {
		
		return root;
	}



	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			
			ficheroControl =new AccesoFicheroController();
			accesoFicheroTab.setContent(ficheroControl.getView());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
