package coit11134.assignment2.vehicleregistrationgui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    private static DataHandler dataHandler;

    @Override
    public void start(Stage stage) throws IOException {
        
        //Instantiates the DataHandler object
        dataHandler = new DataHandler("Owners.txt", "Vehicles.txt"); 
        
        // Loads the Menu scene
        scene = new Scene(loadFXML("FXMLMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }
    
    // Method for switching scenes
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    //Method for loading FXML files 
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    //Method to return a reference to the data handler object  
    public static DataHandler getDataHandler()
    {
        return dataHandler;
    } 
    
    // Method for exiting the app
    public static void exit()
    {
        dataHandler.saveDatatoFiles();
        Platform.exit();
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}