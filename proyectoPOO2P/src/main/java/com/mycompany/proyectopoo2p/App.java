package com.mycompany.proyectopoo2p;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    
    public static String pathImg="src/main/resources/recursos/imagenes/";
    public static String pathFiles="src/main/resources/recursos/archivos/";

    


    private static Scene scene;

    @Override
    public void start(Stage stage)throws Exception{
        FXMLLoader fxmlloader=new FXMLLoader(App.class.getResource("/com/mycompany/proyectopoo2p/FXML.fxml"));
        Parent root=fxmlloader.load();
        scene= new Scene(root,800,600);
        stage.setTitle("COPA MUNDIAL BRASIL 2014");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}