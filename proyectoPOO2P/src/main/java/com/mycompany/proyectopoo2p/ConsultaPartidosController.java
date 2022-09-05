/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo2p;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Partido;

/**
 * FXML Controller class
 *
 * @author Usurario
 */
public class ConsultaPartidosController implements Initializable {
    @FXML
    public VBox vbroot;
    @FXML
    public ComboBox<String> cbFase;
    @FXML
    public ComboBox<String> cbGrupos;
    @FXML
    public ComboBox<String> cbEquipo1;
    @FXML
    public ComboBox<String> cbEquipo2;
    @FXML
    public Button btnConsultarP;
    public Partido partidoSeleccionado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbFase.getItems().addAll("Group", "Round of 16", "Quarter-finals", "Semi-finals", "Final");
        cbFase.setOnAction(eh -> {
            cbGrupos.getItems().clear();
            cbEquipo1.getItems().clear();
            cbEquipo2.getItems().clear();
            if (cbFase.getValue().equals("Group")) {
                cbGrupos.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
                cbGrupos.setOnAction(eh2 -> {
                    cbEquipo1.getItems().clear();
                    cbEquipo2.getItems().clear();
                    ArrayList<String> equipos = new ArrayList<>();
                    String seleccionGrupos = "Group " + cbGrupos.getValue();
                    for (Partido p : crearListaPartido()) {
                        if (p.getStage().equals(seleccionGrupos)) {
                            if (!equipos.contains(p.getHomeTeamName())) {
                                equipos.add(p.getHomeTeamName());
                            }
                        }
                    }
                    cbEquipo1.getItems().addAll(equipos);
                    cbEquipo1.setOnAction(eh3 -> {
                        cbEquipo2.getItems().clear();
                        ArrayList<String> equipos2 = new ArrayList<>();
                        for (Partido p : crearListaPartido()) {
                            if (p.getStage().equals(seleccionGrupos)) {
                                if (!equipos2.contains(p.getAwayTeamName())) {
                                    if (!p.getAwayTeamName().equals(cbEquipo1.getValue())) {
                                        equipos2.add(p.getAwayTeamName());
                                    }
                                }
                            }
                        }
                        cbEquipo2.getItems().addAll(equipos2);
                    });
                });
            } else {
                cbEquipo1.getItems().clear();
                cbEquipo2.getItems().clear();
                ArrayList<String> equipos = new ArrayList<>();
                String seleccionFase = cbFase.getValue();
                for (Partido p : crearListaPartido()) {
                    if (p.getStage().equals(seleccionFase)) {
                        if (!equipos.contains(p.getHomeTeamName())) {
                            equipos.add(p.getHomeTeamName());
                        }
                    }
                }
                cbEquipo1.getItems().addAll(equipos);
                cbEquipo1.setOnAction(eh3 -> {
                    cbEquipo2.getItems().clear();
                    ArrayList<String> equipos2 = new ArrayList<>();
                    for (Partido p : crearListaPartido()) {
                        if (p.getStage().equals(seleccionFase)) {
                            if (!equipos2.contains(p.getAwayTeamName())) {
                                if (!p.getAwayTeamName().equals(cbEquipo1.getValue())) {
                                    equipos2.add(p.getAwayTeamName());
                                }
                            }
                        }
                    }
                    cbEquipo2.getItems().addAll(equipos2);
                });
            }

        });

    }

    @FXML
    public void consultar() {
        if(cbFase.getValue().equals("Group")){
            for(Partido p:crearListaPartido()){
                if(p.getStage().equals("Group "+cbGrupos.getValue())&& p.getHomeTeamName().equals(cbEquipo1.getValue()) && p.getAwayTeamName().equals(cbEquipo2.getValue())){
                    partidoSeleccionado=p;
                }
            }
        }else{
            for(Partido p:crearListaPartido()){
                if(p.getStage().equals(cbFase.getValue())&& p.getHomeTeamName().equals(cbEquipo1.getValue()) && p.getAwayTeamName().equals(cbEquipo2.getValue())){
                    partidoSeleccionado=p;
                }
            }
        }
        VBox vb1=new VBox();
        VBox vb2=new VBox();
        VBox vb3=new VBox();
        HBox hb1=new HBox();
        Button btExportar=new Button("EXPORTAR RESULTADOS DE GRUPO");
        Button btVerDetalle=new Button("VER DETALLE DE EQUIPOS");
        Label lblTitulo=new Label("Resultados del Partido");
        Label lblFecha=new Label(partidoSeleccionado.getDatetime());
        Label lblGrupo=new Label(partidoSeleccionado.getStage());
        Label lblEstadio=new Label(partidoSeleccionado.getStadium());
        Label lblCiudad=new Label(partidoSeleccionado.getCity());
        Label lblFinal=new Label("Final del partido");
        Label lblMarcador=new Label(partidoSeleccionado.getHomeTeamGoals()+" - "+partidoSeleccionado.getAwayTeamGoals());
        HBox hbEquipoLocal=crearHBequipo(partidoSeleccionado.getHomeTeamName());
        HBox hbEquipoVisitante=crearHBequipo(partidoSeleccionado.getAwayTeamName());
        
        vb2.getChildren().addAll(lblFecha,lblGrupo,lblEstadio,lblCiudad);
        vb3.getChildren().addAll(lblFinal,lblMarcador);
        hb1.getChildren().addAll(vb2,hbEquipoLocal,vb3,hbEquipoVisitante);
        hb1.setSpacing(50);
        hb1.setAlignment(Pos.CENTER);
        vb1.getChildren().addAll(lblTitulo,hb1,btExportar,btVerDetalle);
        vb1.setAlignment(Pos.CENTER);
        vbroot.getChildren().add(vb1);
        
    }

    public ArrayList<Partido> crearListaPartido() {
        ArrayList<Partido> partidos = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(App.pathFiles + "WorldCupMatchesBrasil2014.csv"))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String lista[] = linea.trim().split(",");
                partidos.add(new Partido(lista[0], lista[1], lista[2], lista[3], lista[4], lista[5], lista[6], lista[7], lista[8], lista[9], lista[10], lista[11], lista[12], lista[13], lista[14], lista[15], lista[16], lista[17], lista[18], lista[19]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return partidos;
    }
    public HBox crearHBequipo(String nombreEquipo){
        HBox hb=new HBox();
        try(FileInputStream input=new FileInputStream(App.pathImg+nombreEquipo+".jpg")){
            Image img= new Image(input);
            ImageView imgv=new ImageView(img);
            hb.getChildren().add(imgv);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        hb.getChildren().add(new Label(nombreEquipo));
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        return hb;
    }
}
