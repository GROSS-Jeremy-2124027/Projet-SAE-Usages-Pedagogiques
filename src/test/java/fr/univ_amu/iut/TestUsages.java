package fr.univ_amu.iut;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import java.net.MalformedURLException;
import java.util.concurrent.TimeoutException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
public class TestUsages {
    Stage stage;
    ControleurAccueil controlleurAccueil = new ControleurAccueil();

    public TestUsages() throws MalformedURLException {
    }

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestUsages.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new AccueilMain().start(TestUsages.this.stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (TimeoutException e) {

            }
        });
    }
    @AfterEach
    void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }
    @Test
    void should_initialize_stage_is_showing() {
        assertThat(stage.isShowing()).isTrue();
    }
    @Test
    void should_initialize_with_correct_title() {
        assertThat(stage.getTitle()).isEqualTo("Accueil");
    }
    @Test
    void should_initialize_stage_is_resizable() {
        assertThat(stage.resizableProperty().get()).isTrue();
    }
    @Test
    void should_initialize_working_button_return_choix_vue(FxRobot robot) {
        robot.clickOn("#nextbutton");
        robot.clickOn("#usagespedagogiquesbutton");
        robot.clickOn("#usageButtonRetourChoixVue");
        verifyThat("#usagesPedagogiquesNode", (Node node) -> node.isVisible() == false);
        verifyThat("#choixUsagesNode", (Node node) -> node.isVisible());
    }
    @Test
    void should_initialize_button_with_correct_title() {
        verifyThat("#classeInverséeButton",hasText("Classe inversée"));
        verifyThat("#créationNumériqueButton",hasText("Création numérique"));
        verifyThat("#différenciationPédagogiqueButton",hasText("Différenciation pédagogique"));
        verifyThat("#écoleInclusiveButton",hasText("École inclusive"));
        verifyThat("#EMICitoyennetéNumériqueButton",hasText("EMIcitoyenneté numérique"));
        verifyThat("#enseignerADistanceButton",hasText("Enseigner à distance"));
        verifyThat("#expressionOralePodcast",hasText("Expression orale/podcast"));
        verifyThat("#evaluationButton",hasText("Évaluation"));
        verifyThat("#formationAuxOutilsNumériquesButton",hasText("Formation aux outils numériques"));
        verifyThat("#formerADistanceButton",hasText("Former à distance"));
        verifyThat("#hybridationButton",hasText("Hybridation"));
        verifyThat("#ludificationButton",hasText("Ludification"));
        verifyThat("#pédagogieDeProjetButton",hasText("Pédagogie de projet"));
        verifyThat("#programmationCodageRobotiqueButton",hasText("Programmation/Codage/Robotique"));
        verifyThat("#réalitéVirtuelleEtAugmentéeButton",hasText("Réalité virtuelle et augmentée"));
        verifyThat("#réseauxSociauxButton",hasText("Réseaux sociaux"));
        verifyThat("#sexercerSentraînerButton",hasText("S’exercer/ s’entraîner"));
        verifyThat("#tiersLabButton",hasText("Tiers lab"));
        verifyThat("#TNEButton",hasText("TNE"));
        verifyThat("#travailCollaboratifMutualisationButton",hasText("Travail collaboratif/ mutualisation"));
        verifyThat("#travailEntrePairsButton",hasText("Travail entre pairs"));
        verifyThat("#webradioButton",hasText("Webradio"));
    }
}