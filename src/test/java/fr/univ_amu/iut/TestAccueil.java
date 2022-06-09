package fr.univ_amu.iut;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
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
public class TestAccueil {
    Stage stage;
    ControleurAccueil controlleurAccueil = new ControleurAccueil();

    public TestAccueil() throws MalformedURLException {
    }

    @Start
    public void start(Stage stage) throws Exception {
        Platform.runLater(() -> {
            TestAccueil.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new AccueilMain().start(TestAccueil.this.stage);
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
    void should_initialize_button_with_correct_name(){
        verifyThat("#connectbutton",hasText("Connexion"));
        verifyThat("#nextbutton",hasText("Suivant"));
        verifyThat("#aideButton",hasText("Aide"));
    }
    @Test
    void should_initialize_working_next_button_on_accueil_page(FxRobot robot) {
        robot.clickOn("#nextbutton");
        verifyThat("#choixUsagesNode", (Node node) -> node.isVisible());
        verifyThat("#accueilNode", (Node node) -> node.isVisible() == false);
    }
    @Test
    void should_show_help(FxRobot robot) {
        robot.clickOn("#aideButton");
        verifyThat("#vboxAide", (Node node) -> node.isVisible());
    }
    @Test
    void should_disable_help(FxRobot robot) {
        robot.clickOn("#aideButton");
        robot.clickOn("#aideButton");
        verifyThat("#vboxAide", (Node node) -> node.isVisible() == false);
    }
    @Test
    void should_initialize_working_connect_button_on_accueil_page(FxRobot robot){
        robot.clickOn("#connectbutton");
        verifyThat("#connexionNode", (Node node) -> node.isVisible());
    }

}