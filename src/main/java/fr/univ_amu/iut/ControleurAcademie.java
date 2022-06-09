package fr.univ_amu.iut;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ControleurAcademie {

    public void retourVersChoixVue(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node choixUsagesNode = childs.get(1);
        Node academieNode = childs.get(3);

        choixUsagesNode.setId("choixUsagesNode");
        academieNode.setId("academieNode");

        choixUsagesNode.setVisible(true);
        academieNode.setVisible(false);
    }

    public void vaVersUsagesAcademie(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node usagesAcademieNode = childs.get(6);
        Node academieNode = childs.get(3);

        usagesAcademieNode.setId("usagesAcademieNode");
        academieNode.setId("academieNode");

        usagesAcademieNode.setVisible(true);
        academieNode.setVisible(false);
    }
}
