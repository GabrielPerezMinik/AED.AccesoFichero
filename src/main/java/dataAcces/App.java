package dataAcces;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
	
	private static Stage primaryStage;
	MainController main;

	@Override
	public void start(Stage primaryStage) throws Exception {

		App.primaryStage = primaryStage;
		main=new MainController();
		
		Scene scene = new Scene(main.getView());
		primaryStage.setTitle("Acceso a ficheros");
		primaryStage.getIcons().add(new Image("/image/carpeta.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
