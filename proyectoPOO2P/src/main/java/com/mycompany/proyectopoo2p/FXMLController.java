/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo2p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usurario
 */
public class FXMLController implements Initializable {
    @FXML
    public Button btnPartidos;
    @FXML
    public Button btnCopas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnPartidos.setOnAction((ActionEvent t)->{
            try{
                consultarPartidos();
            }catch(IOException ex){
                ex.printStackTrace();
                System.out.println("ERROR");
            }
        });
        btnCopas.setOnAction((ActionEvent t)->{
            try{
                consultarCopas();
            }catch(IOException ex){
                ex.printStackTrace();
                System.out.println("ERROR");
            }
        });
        }
        
    @FXML
    public void consultarPartidos() throws IOException {
        FXMLLoader fxmlloader=new FXMLLoader(App.class.getResource("/com/mycompany/proyectopoo2p/ConsultaPartidos.fxml"));
        Parent rootPartidos=fxmlloader.load();
        Scene scene=new Scene(rootPartidos);
        Stage stage=new Stage();
        stage.setTitle("CONSULTA DE PARTIDOS");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void consultarCopas() throws IOException {
        FXMLLoader fxmlloader=new FXMLLoader(App.class.getResource("/com/mycompany/proyectopoo2p/ConsultaCopas.fxml"));
        Parent rootCopas=fxmlloader.load();
        Scene scene=new Scene(rootCopas);
        Stage stage=new Stage();
        stage.setTitle("CONSULTA DE COPAS");
        stage.setScene(scene);
        stage.show();
    }
}
