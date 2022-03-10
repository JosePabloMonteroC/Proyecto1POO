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
        String[] palabras = {"Max","Verstappen","VER","RedBull","RB","RBR","Horner","Supermax","maxverstappen","verstappen","max",
        					 "Lewis","Hamilton","LH","Mercedes","AMG","Toto","Wolff","lewishamilton","hamilton","lewis",
        					 "Michael", "Masi", "FIA","Safety", "Car","SC",
        					 "Nicholas","Latifi","Williams"};
        

        //obj1.setListPalabras(obj1.regresaArrayList("C:\\Users\\Roman\\Downloads\\archive\\TweetsAbuDhabiGP.csv"));

        
        obj1.setListPalabras(obj1.regresaArrayList("C:\\Users\\pepem\\git\\Proyecto1POO\\Proyecto1POO\\src\\application\\TweetsAbuDhabiGP.csv"));
        obj1.setListPalabras(obj1.eliminarCaracteres(obj1.getListPalabras()));
        obj1.setPalabrasConsultadas(palabras);
        obj1.setNumTweets(obj1.contarPalabras(obj1.getPalabrasConsultadas(),obj1.getListPalabras()));
        obj1.imprimirPalabras(obj1.getNumTweets(), obj1.getPalabrasConsultadas());
        
        obj1.contadorRedBull(obj1.getNumTweets(), obj1.getPalabrasConsultadas());
        obj1.contadorMerc(obj1.getNumTweets(), obj1.getPalabrasConsultadas());
        obj1.contadorFia(obj1.getNumTweets(), obj1.getPalabrasConsultadas());
        obj1.contadorLatifi(obj1.getNumTweets(), obj1.getPalabrasConsultadas());
        
        
        launch(args);
        
        
        
	}
}
