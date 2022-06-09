package fr.univ_amu.iut;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.scene.control.Button;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeoutException;


import static org.assertj.core.api.Assertions.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
public class TestChoixVue {
    Stage stage;
    ControleurAccueil controlleurAccueil = new ControleurAccueil();

    public TestChoixVue() throws MalformedURLException {
    }

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestChoixVue.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new AccueilMain().start(TestChoixVue.this.stage);
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
    void should_initialize_button_retour_with_correct_text(){
        verifyThat("#retourChoixBoutton",hasText("Retour"));
    }
    @Test
    void should_initialize_working_next_button_on_choix_vue_page(FxRobot robot) {
        robot.clickOn("#nextbutton");
        robot.clickOn("#usagespedagogiquesbutton");
        verifyThat("#usagesPedagogiquesNode", (Node node) -> node.isVisible());
        verifyThat("#choixUsagesNode", (Node node) -> node.isVisible() == false);
        verifyThat("#accueilNode", (Node node) -> node.isVisible() == false);
    }
    @Test
    void should_initialize_working_next_button_on_academie(FxRobot robot) {
        robot.clickOn("#nextbutton");
        robot.clickOn("#academieChoixBoutton");
        verifyThat("#academieNode", (Node node) -> node.isVisible());
        verifyThat("#choixUsagesNode", (Node node) -> node.isVisible() == false);
        verifyThat("#accueilNode", (Node node) -> node.isVisible() == false);
    }
    @Test
    void should_initialize_working_retour_button_on_accueil(FxRobot robot) {
        robot.clickOn("#nextbutton");
        robot.clickOn("#retourChoixBoutton");
        verifyThat("#accueilNode", (Node node) -> node.isVisible());
        verifyThat("#choixUsagesNode", (Node node) -> node.isVisible() == false);
    }
    @Test
    void should_initialize_button_with_image(){
        verifyThat("#academieChoixBoutton", (Button node) -> ((ImageView) node.getGraphic()).getImage() != null);
        verifyThat("#usagespedagogiquesbutton", (Button node) -> ((ImageView) node.getGraphic()).getImage() != null);
    }
}