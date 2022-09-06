/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectopoo2p;

import static com.mycompany.proyectopoo2p.ConsultaPartidosController.partidoSeleccionado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Jugador;

/**
 * FXML Controller class
 *
 * @author Usurario
 */
public class DetalledeEquiposController implements Initializable {

    @FXML
    Label lblEquipo1Detalle;
    @FXML
    Label lblEquipo2Detalle;
    @FXML
    HBox hbscroll1;
    @FXML
    HBox hbscroll2;

    public String equipo1 = partidoSeleccionado.getHomeTeamName();
    public ArrayList<Jugador> listaEquipo1 = new ArrayList<>();
    public String equipo2 = partidoSeleccionado.getAwayTeamName();
    public ArrayList<Jugador> listaEquipo2 = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblEquipo1Detalle.setText(equipo1);
        lblEquipo2Detalle.setText(equipo2);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(new File(App.pathFiles + "WorldCupPlayersBrasil2014.csv")))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String lista[] = linea.trim().split(",");
                if (lista[1].equals(partidoSeleccionado.getMatchID())) {
                    jugadores.add(new Jugador(lista[0], lista[1], lista[2], lista[3], lista[4], lista[5], lista[6]));
                }

            }
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (Jugador j : jugadores) {
            if (j.getTeamInitials().equals(partidoSeleccionado.getHomeTeamInitials())) {
                listaEquipo1.add(j);
            }
            if (j.getTeamInitials().equals(partidoSeleccionado.getAwayTeamInitials())) {
                listaEquipo2.add(j);
            }
        }
        for (Jugador j : listaEquipo1) {
            VBox vb = new VBox();
            randomVB(vb,j,randomN());
            vb.setSpacing(10);
            vb.setAlignment(Pos.CENTER);
            hbscroll1.getChildren().add(vb);
            hbscroll1.setSpacing(10);
            detalleJugador(vb, j);
        }
        for (Jugador j : listaEquipo2) {
            VBox vb = new VBox();
            randomVB(vb,j,randomN());
            vb.setSpacing(10);
            vb.setAlignment(Pos.CENTER);
            hbscroll2.getChildren().add(vb);
            hbscroll2.setSpacing(10);
            detalleJugador(vb, j);
        }
    }
    /**
     * Metodo que crea un numero entero aletorio
     * @return int
     */
    public int randomN() {
        int n = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
        return n;
    }
    /**
     * Metodo que añade las imagenes de los jugadores de un equipo progresivamente en tiempo aleatorio
     * @param vb indica el contenedor donde se añaden las imgenes
     * @param j indica el jugador 
     * @param n indica un numero aleatorio
     */
    public void randomVB(VBox vb, Jugador j, int n) {
        vb.getChildren().clear();
        Label nombreJugador = new Label(j.getPlayerName());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * n);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                try ( FileInputStream input = new FileInputStream(App.pathImg + j.getPlayerName() + ".jpg")) {
                    Image img = new Image(input);
                    ImageView imgv = new ImageView(img);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            imgv.setFitHeight(50);
                            imgv.setFitWidth(50);
                            vb.getChildren().addAll(imgv,nombreJugador);
                            
                        }

                    });

                } catch (IOException ex) {
                    System.out.println("No se encontro el archivo de imagen");
                }
            }

        });
        t.start();

    }
    /**
     * Metodo que muestra los datos de un jugador
     * @param vb indica el contenedor donde se añaden los datos
     * @param j indica el jugador
     */
    public void detalleJugador(VBox vb, Jugador j) {
        vb.setOnMouseClicked(eh -> {
            Label contador = new Label();

            VBox vbventana = new VBox();
            vbventana.setAlignment(Pos.CENTER);
            vbventana.setSpacing(10);
            Label nombre = new Label(j.getPlayerName());
            nombre.setFont(new Font(24));
            vbventana.getChildren().add(nombre);
            VBox detalles = new VBox();
            detalles.setAlignment(Pos.CENTER);
            detalles.setSpacing(10);
            Label initials = new Label(j.getTeamInitials());
            Label camiseta = new Label("Camiseta NRO " + j.getShirtNumber());
            Label director = new Label("DIR. TEC. " + j.getCoachName());
            detalles.getChildren().addAll(initials, camiseta, director);
            try ( FileInputStream input = new FileInputStream(App.pathImg + j.getPlayerName() + ".jpg")) {
                Image img = new Image(input);
                ImageView imgv = new ImageView(img);
                imgv.setFitHeight(100);
                imgv.setFitWidth(100);
                vbventana.getChildren().add(imgv);
            } catch (IOException ex) {
                System.out.println("No se encontro el archivo de imagen");
            }
            vbventana.getChildren().add(detalles);
            vbventana.getChildren().add(contador);

            Scene scene = new Scene(vbventana, 200, 300);
            Stage stage = new Stage();
            stage.setTitle("DETALLE JUGADOR");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 10; i > 0; i--) {
                        final int n = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                contador.setText("Mostrando por " + n + " segundos");
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            stage.close();
                        }

                    });
                }

            });
            t.start();
        });
    }

}
