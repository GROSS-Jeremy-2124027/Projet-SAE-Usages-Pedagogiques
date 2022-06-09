package fr.univ_amu.iut;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URI;

public class ControleurAccueil {
    @FXML
    private VBox vboxAide;

    public void vaVersChoixVue(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node accueilNode = childs.get(2);
        Node choixUsagesNode = childs.get(1);

        accueilNode.setId("accueilNode");
        choixUsagesNode.setId("choixUsagesNode");

        accueilNode.setVisible(false);
        choixUsagesNode.setVisible(true);
    }

    public void vaVersConnexionAdmin(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node accueilNode = childs.get(2);
        Node connexionNode = childs.get(4);

        accueilNode.setId("accueilNode");
        connexionNode.setId("connexionNode");

        connexionNode.setVisible(true);
    }

    public void afficheAide(ActionEvent event) {
        // A tester et commenter
        if (vboxAide.isVisible() == false) {
            vboxAide.setVisible(true);
        } else {
            vboxAide.setVisible(false);
        }
    }

}