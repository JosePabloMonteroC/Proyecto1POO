package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		DataWorker obj1 = new DataWorker();
        String[] palabras = {"Max","Hamilton","FIA"};
        
        obj1.setListPalabras(obj1.regresaArrayList("C:\\Users\\pepem\\git\\Proyecto1POO\\Proyecto1POO\\src\\application\\temporal1.csv"));
        obj1.setListPalabras(obj1.eliminarCaracteres(obj1.getListPalabras()));
        obj1.setPalabras(palabras);
        obj1.setTweets(obj1.contarPalabras(obj1.getPalabras(),obj1.getListPalabras()));
        obj1.imprimirPalabras(obj1.getTweets(), obj1.getPalabras());
		launch(args);
	}
}
