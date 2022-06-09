package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControleurChoixVue {

    public void vaVersUsagesPédagogiques(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node choixUsagesNode = childs.get(1);
        Node usagesPedagogiquesNode = childs.get(0);

        choixUsagesNode.setId("choixUsagesNode");
        usagesPedagogiquesNode.setId("usagesPedagogiquesNode");

        choixUsagesNode.setVisible(false);
        usagesPedagogiquesNode.setVisible(true);
    }

    public void vaVersAcademie(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node choixUsagesNode = childs.get(1);
        Node academieNode = childs.get(3);

        choixUsagesNode.setId("choixUsagesNode");
        academieNode.setId("academieNode");

        choixUsagesNode.setVisible(false);
        academieNode.setVisible(true);
    }

    public void vaVersAccueil(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node accueilNode = childs.get(2);
        Node choixUsagesNode = childs.get(1);

        accueilNode.setId("accueilNode");
        choixUsagesNode.setId("choixUsagesNode");

        accueilNode.setVisible(true);
        choixUsagesNode.setVisible(false);
    }


}
