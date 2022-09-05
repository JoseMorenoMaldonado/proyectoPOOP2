/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo2p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.Copa;

/**
 * FXML Controller class
 *
 * @author Usurario
 */
public class ConsultaCopasController implements Initializable {
    
    @FXML
    public VBox vbrootcopas;
    @FXML
    public Label lblTitulo;
    @FXML
    public Label lblAno;
    @FXML
    public TextField tfAno;
    @FXML
    public Button btConsultarC;
    
    public VBox vbaccion=new VBox();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            vbrootcopas.setAlignment(Pos.TOP_CENTER);
            vbaccion.setAlignment(Pos.BASELINE_CENTER);
            VBox vbtitulo=new VBox();
            vbtitulo.setAlignment(Pos.BASELINE_CENTER);
            vbtitulo.setPrefHeight(50);
            lblTitulo=new Label("Consulta Historia de Copas Mundiales");
            lblTitulo.setStyle("-fx-font: 24 arial;");
            vbtitulo.getChildren().add(lblTitulo);
            HBox hbcopas=new HBox();
            hbcopas.setPadding(new Insets(10, 10, 10, 10));
            hbcopas.setSpacing(20);
            hbcopas.setAlignment(Pos.BASELINE_CENTER);
            lblAno=new Label("Ano:");
            tfAno=new TextField();
            btConsultarC=new Button("CONSULTAR");
            btConsultarC.setOnAction(eh->{
                buscarMundial();
            });
            
            hbcopas.getChildren().addAll(lblAno,tfAno,btConsultarC);
            vbrootcopas.getChildren().addAll(vbtitulo,hbcopas,vbaccion);
            System.out.println(consultarCopas());
    }    
    public ArrayList<Copa> consultarCopas(){
        ArrayList<Copa> copas=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(new File(App.pathFiles+"WorldCups.csv")))){
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String lista[]=linea.trim().split(",");
                copas.add(new Copa(Integer.valueOf(lista[0]),
                        lista[1],
                        lista[2],
                        lista[3],
                        lista[4],
                        lista[5],
                        Integer.valueOf(lista[6]),
                        Integer.valueOf(lista[7]),
                        Integer.valueOf(lista[8]),
                        lista[9]));
            }
        }catch(FileNotFoundException ex1){
            ex1.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return copas;
    }
    public void buscarMundial(){
        vbaccion.getChildren().clear();
        consultarCopas().forEach(a->{
            if(tfAno.getText().equals(String.valueOf(a.getYear()))){
                String ganador= a.getWinner();
                String segundo= a.getRunnersUp();
                String tercero= a.getThird();
                String cuarto= a.getFourth();
                String golesTotales= String.valueOf(a.getGoalsScored());
                String equiposTotales= String.valueOf(a.getQualifiedTeams());
                String partidosTotales= String.valueOf(a.getMatchesPlayed());
                String asistenciaMundial= String.valueOf(a.getAttendance());
                
                HBox hb1=new HBox();
                hb1.setAlignment(Pos.TOP_CENTER);
                hb1.setSpacing(30);
                VBox vb1=new VBox();
                vb1.setAlignment(Pos.BASELINE_CENTER);
                vb1.setSpacing(10);
                VBox vb2=new VBox();
                vb2.setAlignment(Pos.BASELINE_CENTER);
                vb2.setSpacing(10);
                HBox hb2=new HBox();
                hb2.setSpacing(10);
                HBox hb3=new HBox();
                hb3.setSpacing(10);
                HBox hb4=new HBox();
                hb4.setSpacing(10);
                HBox hb5=new HBox();
                hb5.setSpacing(10);
                HBox hb6=new HBox();
                HBox hb7=new HBox();
                HBox hb8=new HBox();
                HBox hb9=new HBox();
                
                Label lblPremios=new Label("Premios");
                lblPremios.setStyle("-fx-font: 15 arial;");
                Label lblDatos=new Label("Datos generales");
                lblDatos.setStyle("-fx-font: 15 arial;");
                Label lblGanador=new Label("Ganador:");
                Label lblSegundo=new Label("Segundo:");
                Label lblTercero=new Label("Tercero:");
                Label lblCuarto=new Label("Cuarto:");
                Label lblEquipoGanador=new Label(ganador);
                Label lblEquipoSegundo=new Label(segundo);
                Label lblEquipoTercero=new Label(tercero);
                Label lblEquipoCuarto=new Label(cuarto);
                Label lblGoles=new Label("Goles anotados: ");
                Label lblEquipos=new Label("Equipos: ");
                Label lblPartidos=new Label("Partidos Jugados: ");
                Label lblAsistencia=new Label("Asistencia: ");
                Label lblNGoles=new Label(golesTotales);
                Label lblNEquipos=new Label(equiposTotales);
                Label lblNPartidos=new Label(partidosTotales);
                Label lblNAsistencia=new Label(asistenciaMundial);
                
                hb2.getChildren().add(lblGanador);
                llenarBanderas(ganador,hb2);
                hb2.getChildren().add(lblEquipoGanador);
                llenarCopas(ganador,hb2);
                
                hb3.getChildren().add(lblSegundo);
                llenarBanderas(segundo,hb3);
                hb3.getChildren().add(lblEquipoSegundo);
                llenarCopas(segundo,hb3);
                
                hb4.getChildren().add(lblTercero);
                llenarBanderas(tercero,hb4);
                hb4.getChildren().add(lblEquipoTercero);
                llenarCopas(tercero,hb4);
                
                hb5.getChildren().add(lblCuarto);
                llenarBanderas(cuarto,hb5);
                hb5.getChildren().add(lblEquipoCuarto);
                llenarCopas(cuarto,hb5);
                
                hb6.getChildren().addAll(lblGoles,lblNGoles);
                hb7.getChildren().addAll(lblEquipos,lblNEquipos);
                hb8.getChildren().addAll(lblPartidos,lblNPartidos);
                hb9.getChildren().addAll(lblAsistencia,lblNAsistencia);
                
                vb1.getChildren().addAll(lblPremios,hb2,hb3,hb4,hb5);
                vb2.getChildren().addAll(lblDatos,hb6,hb7,hb8,hb9);
                hb1.getChildren().addAll(vb1,vb2);
                vbaccion.getChildren().add(hb1);
                
            }
        });
    }
    public void llenarBanderas(String nombreEquipo, HBox hb){
        try(FileInputStream input=new FileInputStream(App.pathImg+nombreEquipo+".jpg")){
            Image img= new Image(input);
            ImageView imgv=new ImageView(img);
            hb.getChildren().add(imgv);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void llenarCopas(String nombreEquipo,HBox hb){
        int n=0;
        for(Copa c:consultarCopas()){
            if(nombreEquipo.equals(c.getWinner())){
                n++;
            }
        }
        System.out.println(n);
        for(int i=0;i<n;i++){
            try(FileInputStream input=new FileInputStream(App.pathImg+"copa.jpg")){
                Image img=new Image(input);
                ImageView imgv=new ImageView(img);
                imgv.setFitHeight(20);
                imgv.setFitWidth(20);
                hb.getChildren().add(imgv);
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
}
