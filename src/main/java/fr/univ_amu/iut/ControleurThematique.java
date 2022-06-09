package fr.univ_amu.iut;

import fr.univ_amu.iut.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import javafx.fxml.FXML;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;


public class ControleurThematique {
    public List<Usage> listeUsage = new ArrayList<>();
    public List<UsageAcademie> listeAcademie = new ArrayList<>();

    @FXML
    Button programmationCodageRobotiqueButton = new Button();
    @FXML
    Label nom1 = new Label();
    @FXML
    Label nom2 = new Label();
    @FXML
    Label nom3 = new Label();
    @FXML
    Label discipline1 = new Label();
    @FXML
    Label discipline2 = new Label();
    @FXML
    Label discipline3 = new Label();
    @FXML
    Label academie1 = new Label();
    @FXML
    Label academie2 = new Label();
    @FXML
    Label academie3 = new Label();
    @FXML
    Label commentaire1 = new Label();
    @FXML
    Label commentaire2 = new Label();
    @FXML
    Label commentaire3 = new Label();
    @FXML
    GridPane gridPaneThematiques;
    @FXML
    GridPane gridPaneUsage;
    public void retourVersChoixVue(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node accueilNode = childs.get(2);
        Node choixUsagesNode = childs.get(1);
        Node usagesPedagogiquesNode = childs.get(0);

        accueilNode.setId("accueilNode");
        choixUsagesNode.setId("choixUsagesNode");
        usagesPedagogiquesNode.setId("usagesPedagogiquesNode");

        accueilNode.setVisible(false);
        choixUsagesNode.setVisible(true);
        usagesPedagogiquesNode.setVisible(false);
    }
    //fonction permettant de recherchcer et stocker dans une liste tout les usages d'une meme thématique
    public void rechercheListeUsageThematique(String thematique) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageThematique> query = em.createNamedQuery("UsageThematique.findByThematique", UsageThematique.class);
                query.setParameter("nomThematique", thematique);
                List<UsageThematique> usagesThematique = query.getResultList();
                for (int i = 0; i < usagesThematique.size(); ++i) {
                    TypedQuery<Usage> query2 = em.createNamedQuery("Usage.findById", Usage.class);
                    query2.setParameter("id", usagesThematique.get(i).getIdUsage());
                    Usage usage = query2.getResultList().get(0);
                    listeUsage.add(usage);
                }
               /*for (int i = 0; i < listeUsage.size(); ++i) {
                    TypedQuery<UsageDiscipline> query3 = em.createNamedQuery("UsageDiscipline.findByDiscipline", UsageDiscipline.class);
                    query3.setParameter("id", usagesThematique.get(i).getIdUsage());
                    UsageDiscipline usageDiscipline = query3.getResultList().get(0);
                    listeDiscipline.add(usageDiscipline);
                }*/

            }
        }
    }
    @FXML
    public void afficheUsage(ActionEvent event) {
        listeUsage = new ArrayList<>();
        Button clickedButton = (Button)event.getSource();
        String thematique = clickedButton.getText();
        //System.out.println(event.getSource().toString());
        //String thematique = event.getSource().toString();

        rechercheListeUsageThematique(thematique);

        if (listeUsage.size() >= 3) {
            nom1.setText(listeUsage.get(0).getNom());
            nom2.setText(listeUsage.get(1).getNom());
            nom3.setText(listeUsage.get(2).getNom());
            discipline1.setText(listeUsage.get(0).getDiscipline().getNom());
            discipline2.setText(listeUsage.get(1).getDiscipline().getNom());
            discipline3.setText(listeUsage.get(2).getDiscipline().getNom());
            commentaire1.setText(listeUsage.get(0).getCommentaire());
            commentaire2.setText(listeUsage.get(1).getCommentaire());
            commentaire3.setText(listeUsage.get(2).getCommentaire());

            /*discipline1.setText(listeDiscipline.get(0).getNomDiscipline());
            discipline2.setText(listeDiscipline.get(1).getNomDiscipline());
            discipline3.setText(listeDiscipline.get(2).getNomDiscipline());*/


        }
        else if (listeUsage.size() == 2) {
            nom1.setText(listeUsage.get(0).getNom());
            nom2.setText(listeUsage.get(1).getNom());
            nom3.setText("");
            discipline1.setText(listeUsage.get(0).getDiscipline().getNom());
            discipline2.setText(listeUsage.get(1).getDiscipline().getNom());
            discipline3.setText("");
            commentaire1.setText(listeUsage.get(0).getCommentaire());
            commentaire2.setText(listeUsage.get(1).getCommentaire());
            commentaire3.setText("");

        }
        else if (listeUsage.size() == 1) {
            nom1.setText(listeUsage.get(0).getNom());
            nom2.setText("");
            nom3.setText("");
            discipline1.setText(listeUsage.get(0).getDiscipline().getNom());
            discipline2.setText("");
            discipline3.setText("");
            commentaire1.setText(listeUsage.get(0).getCommentaire());
            commentaire2.setText("");
            commentaire3.setText("");

        }
        else if (listeUsage.size() == 0) {
            nom1.setText("");
            nom2.setText("");
            nom3.setText("");
            discipline1.setText("");
            discipline2.setText("");
            discipline3.setText("");
            commentaire1.setText("");
            commentaire2.setText("");
            commentaire3.setText("");
        }
    }


}
