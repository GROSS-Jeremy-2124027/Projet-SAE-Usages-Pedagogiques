package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.model.UsageAcademie;
import fr.univ_amu.iut.model.UsageThematique;
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


public class ControleurUsagesAcademie {
    public List<Usage> listeUsage = new ArrayList<>();

    @FXML
    Label nom1 = new Label();
    @FXML
    Label nom2 = new Label();
    @FXML
    Label nom3 = new Label();
    @FXML
    Label thematique1 = new Label();
    @FXML
    Label thematique2 = new Label();
    @FXML
    Label thematique3 = new Label();
    @FXML
    Label discipline1 = new Label();
    @FXML
    Label discipline2 = new Label();
    @FXML
    Label discipline3 = new Label();
    @FXML
    Label commentaire1 = new Label();
    @FXML
    Label commentaire2 = new Label();
    @FXML
    Label commentaire3 = new Label();
    @FXML
    GridPane gridPaneAcademies;
    @FXML
    GridPane gridPaneUsage;
    public void retourVersAcademie(ActionEvent actionEvent) {

        ObservableList<Node> childs = AccueilMain.pile.getChildren();
        Node academieNode = childs.get(3);
        Node usagesAcademieNode = childs.get(6);

        academieNode.setId("academieNode");
        usagesAcademieNode.setId("usagesAcademieNode");

        academieNode.setVisible(true);
        usagesAcademieNode.setVisible(false);
    }
    //fonction permettant de
    public void rechercheListeUsageAcademie(String nomAcademie) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU")) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<UsageAcademie> query = em.createNamedQuery("UsageAcademie.findByAcademie", UsageAcademie.class);
                query.setParameter("nomAcademie", nomAcademie);
                List<UsageAcademie> usageAcademies = query.getResultList();
                for (int i = 0; i < usageAcademies.size(); ++i) {
                    TypedQuery<Usage> query2 = em.createNamedQuery("Usage.findById", Usage.class);
                    query2.setParameter("id", usageAcademies.get(i).getIdUsage());
                    Usage usage = query2.getResultList().get(0);
                    listeUsage.add(usage);
                }

            }
        }
    }
    @FXML
    public void afficheUsageAcademie(ActionEvent event) {
        listeUsage = new ArrayList<>();
        Button clickedButton = (Button)event.getSource();
        String academie = clickedButton.getText();
        //System.out.println(event.getSource().toString());
        //String thematique = event.getSource().toString();

        rechercheListeUsageAcademie(academie);

        if (listeUsage.size() >= 3) {
            nom1.setText(listeUsage.get(0).getNom());
            nom2.setText(listeUsage.get(1).getNom());
            nom3.setText(listeUsage.get(2).getNom());
            discipline1.setText(listeUsage.get(0).getDiscipline().getNom());
            discipline2.setText(listeUsage.get(1).getDiscipline().getNom());
            discipline3.setText(listeUsage.get(2).getDiscipline().getNom());
            thematique1.setText(listeUsage.get(0).getThematique().getNom());
            thematique2.setText(listeUsage.get(1).getThematique().getNom());
            thematique3.setText(listeUsage.get(2).getThematique().getNom());
            commentaire1.setText(listeUsage.get(0).getCommentaire());
            commentaire2.setText(listeUsage.get(1).getCommentaire());
            commentaire3.setText(listeUsage.get(2).getCommentaire());
        }
        else if (listeUsage.size() == 2) {
            nom1.setText(listeUsage.get(0).getNom());
            nom2.setText(listeUsage.get(1).getNom());
            nom3.setText("");
            discipline1.setText(listeUsage.get(0).getDiscipline().getNom());
            discipline2.setText(listeUsage.get(1).getDiscipline().getNom());
            discipline3.setText("");
            thematique1.setText(listeUsage.get(0).getThematique().getNom());
            thematique2.setText(listeUsage.get(1).getThematique().getNom());
            thematique3.setText("");
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
            thematique1.setText(listeUsage.get(0).getThematique().getNom());
            thematique2.setText("");
            thematique3.setText("");
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
            thematique1.setText("");
            thematique2.setText("");
            thematique3.setText("");
            commentaire1.setText("");
            commentaire2.setText("");
            commentaire3.setText("");
        }

    }


}
