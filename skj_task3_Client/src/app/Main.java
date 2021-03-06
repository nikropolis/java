package app;
 
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
   
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage state) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/MainView.fxml"));
        
        Scene scene = new Scene(root, 600, 700);
//        scene.getStylesheets().add("/style/style.css");
//        scene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());
                
        state.setScene(scene);
        state.setTitle("DNS KILLA");
        state.show();
        System.out.println(". Main start");
    }
}