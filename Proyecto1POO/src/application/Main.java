package application;
	
import java.util.ArrayList;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;

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
		
		//Codigo
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
        obj1.contadorRedBull(obj1.getNumTweets());
        obj1.contadorMerc(obj1.getNumTweets());
        obj1.contadorFia(obj1.getNumTweets());
        obj1.contadorLatifi(obj1.getNumTweets());
		
		//Grafica
        
        CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Palabra Buscada");
        
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Frecuencia");

       
		BarChart<Number, String> chart = new BarChart<Number, String>(xAxis, yAxis);
        chart.setTitle("Tweets F1 2021");
        // agregamos datos 
        chart.setData(obtenerDatos(obj1));
        
        // Paneles
        StackPane root = new StackPane();
        root.getChildren().add(chart);
        
        // Tamaño del Frame
        Scene scene = new Scene(root, 640, 427);
        
        

        primaryStage.setTitle("Prueba MFg");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	@SuppressWarnings("unchecked")
	public static ObservableList<XYChart.Series<Number, String>> obtenerDatos(DataWorker obj1) {
	
        XYChart.Series<Number, String> frecuenciasPalabras = new XYChart.Series<>();
        frecuenciasPalabras.setName("Cantidad Palabras");
      
        frecuenciasPalabras.getData().addAll(		
        new XYChart.Data<>(obj1.contadorRedBull(obj1.getNumTweets()), "RB/Verstappen"), 
        new XYChart.Data<>(obj1.contadorMerc(obj1.getNumTweets()), "Mercedes/Hamilton"),
        new XYChart.Data<>(obj1.contadorFia(obj1.getNumTweets()), "FIA/Masi"),
        new XYChart.Data<>(obj1.contadorLatifi(obj1.getNumTweets()), "Latifi"));
        

        ObservableList<XYChart.Series<Number, String>> data = FXCollections.observableArrayList();
        data.addAll(frecuenciasPalabras);

        return data;
    }
	
	public static void main(String[] args) {
        launch(args);
	}
}
