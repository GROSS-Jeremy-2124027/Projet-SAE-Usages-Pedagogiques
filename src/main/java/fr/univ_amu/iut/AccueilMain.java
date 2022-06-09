package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;


public class AccueilMain extends Application {

    @FXML
    static StackPane pile;

    @Override
    public void start(Stage primaryStage) throws Exception {

        pile = new StackPane();

        BorderPane accueil = null;
        try {
            accueil = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane choixVue = null;
        try {
            choixVue = FXMLLoader.load(getClass().getResource("ChoixVue.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane thematiques = null;
        try {
            thematiques = FXMLLoader.load(getClass().getResource("Thematique.fxml"));
        } catch (IOException e) {
             e.printStackTrace();

        }
        BorderPane academie = null;
        try {
            academie = FXMLLoader.load(getClass().getResource("Academie.fxml"));
        } catch (IOException e) {
            e.printStackTrace();

        }
        BorderPane connexion = null;
        try {
            connexion = FXMLLoader.load(getClass().getResource("ConnexionAdmin.fxml"));
        } catch (IOException e) {
            e.printStackTrace();

        }
        BorderPane choixJPA = null;
        try {
            choixJPA = FXMLLoader.load(getClass().getResource("ChoixJPA.fxml"));
        } catch (IOException e) {
            e.printStackTrace();

        }
        BorderPane usagesAcademie = null;
        try {
            usagesAcademie = FXMLLoader.load(getClass().getResource("UsagesAcademie.fxml"));
        } catch (IOException e) {
            e.printStackTrace();

        }


        pile.getChildren().addAll(thematiques, choixVue, accueil, academie, connexion, choixJPA, usagesAcademie);

        choixVue.setVisible(false);
        thematiques.setVisible(false);
        academie.setVisible(false);
        connexion.setVisible(false);
        choixJPA.setVisible(false);
        usagesAcademie.setVisible(false);

        Scene scene = new Scene(pile, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("visualisation des usages pédagogiques");
        primaryStage.show();
    }
}