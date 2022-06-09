package fr.univ_amu.iut;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
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
public class TestConnexion {
    Stage stage;
    ControleurConnexionAdmin controlleurConnexionAdmin = new ControleurConnexionAdmin();

    public TestConnexion() throws MalformedURLException {
    }

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestConnexion.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new AccueilMain().start(TestConnexion.this.stage);
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
    void should_initialize_button_with_correct_name() {
        verifyThat("#connexionAdminButtonRetourAccueil",hasText("Retour"));
        verifyThat("#connexionAdminButtonConnect",hasText("Connexion"));
    }
    @Test
    void should_initialize_working_retour_accueil_button(FxRobot robot) {
        robot.clickOn("#connectbutton");
        robot.clickOn("#connexionAdminButtonRetourAccueil");
        verifyThat("#accueilNode", (Node node) -> node.isVisible() == true);
        verifyThat("#connexionAdminNode", (Node node) -> node.isVisible() == false);
    }
    @Test
    void should_initialize_working_button_connect_as_admin(FxRobot robot) {
        robot.clickOn("#connectbutton");
        robot.clickOn("#userTextField");
        robot.write("admin");
        robot.clickOn("#passwordField");
        robot.write("password");
        robot.clickOn("#connexionAdminButtonConnect");
        verifyThat("#reponseConnexionAdmin", (Node node) -> node.isVisible());
        verifyThat("#reponseConnexionAdmin", hasText("Vous etes à présent connecté"));
        verifyThat("#modificationUsages", (Node node) -> node.isVisible());
    }

    //Les deux derniers tests fonctionnent uniquement si on les lance indépendemment des autres
    @Disabled
    @Test
    void should_initialize_working_button_when_you_are_not_admin(FxRobot robot) {
        robot.clickOn("#connectbutton");
        robot.clickOn("#connexionAdminButtonConnect");
        verifyThat("#reponseConnexionAdmin", (Node node) -> node.isVisible());
        verifyThat("#modificationUsages", (Node node) -> node.isVisible() == false);
        verifyThat("#reponseConnexionAdmin", hasText("echec de connexion"));
    }
    @Disabled
    @Test
    void should_initialize_working_button_modification_usages(FxRobot robot) {
        robot.clickOn("#connectbutton");
        robot.clickOn("#userTextField");
        robot.write("admin");
        robot.clickOn("#passwordField");
        robot.write("password");
        robot.clickOn("#connexionAdminButtonConnect");
        robot.clickOn("#modificationUsages");
        verifyThat("#choixJPA", (Node node) -> node.isVisible());
    }
}
