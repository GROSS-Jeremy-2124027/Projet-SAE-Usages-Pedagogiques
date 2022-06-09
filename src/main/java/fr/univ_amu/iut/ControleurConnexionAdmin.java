package fr.univ_amu.iut;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleurConnexionAdmin {
    @FXML
    private Button connexionAdminButtonRetourAccueil;
    @FXML
    private TextField userTextField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button boutonConnexion;
    @FXML
    private Label reponseConnexionAdmin;
    @FXML
    private Button modificationUsages;
    public static boolean isConnected = false;
    public String validuser = "admin";
    public String password = "password";

    public boolean isConnected() {
        return isConnected;
    }

    public void retourVersAccueil(ActionEvent actionEvent) {
        AccueilMain.pile.getChildren().get(4).setVisible(false);
        AccueilMain.pile.getChildren().get(2).setId("accueilNode");
        AccueilMain.pile.getChildren().get(4).setId("connexionAdminNode");

    }

    //procédure qui permet à l'administrateur de se connecter(s'il ne l'est pas déja) s'il entre le bon utilisateur et le bon mot de passe
    // la procédure rend alors le bouton modificationUsages visible
    public void modifieStatutUser(ActionEvent event) {

        if (isConnected != true) {

            if(userTextField.getText().equals(validuser) & passwordField.getText().equals(password)) {
                isConnected = true;
                modificationUsages.setVisible(true);
                reponseConnexionAdmin.setText("Vous etes à présent connecté");
                reponseConnexionAdmin.setStyle("-fx-color-label-visible: green");
                reponseConnexionAdmin.setVisible(true);
            }

            else {
                reponseConnexionAdmin.setText("echec de connexion");
                reponseConnexionAdmin.setVisible(true);
            }

        }

    }

    public void vaVersChoixJPA(ActionEvent event) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node accueilNode = childs.get(2);
        Node connexionAdminNode = childs.get(4);
        Node choixJPA = childs.get(5);

        connexionAdminNode.setId("connexionAdminNode");
        choixJPA.setId("choixJPA");

        connexionAdminNode.setVisible(false);
        accueilNode.setVisible(false);
        choixJPA.setVisible(true);
    }

}
