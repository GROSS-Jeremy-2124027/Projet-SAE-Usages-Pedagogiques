package fr.univ_amu.iut;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ControleurChoixJPA {
    public void retourVersConnexionAdmin(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node connexionNode = childs.get(4);
        Node choixJPANode = childs.get(5);
        Node accueilNode = childs.get(2);

        choixJPANode.setId("choixJPANode");
        connexionNode.setId("connexionNode");
        accueilNode.setId("accueilNode");

        choixJPANode.setVisible(false);
        connexionNode.setVisible(true);
        accueilNode.setVisible(true);

    }
}
