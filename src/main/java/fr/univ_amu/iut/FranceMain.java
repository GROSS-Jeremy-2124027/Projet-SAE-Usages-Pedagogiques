package fr.univ_amu.iut;

import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FranceMain extends Application {
    France france;

    @Override
    public void init() {
        france = FranceBuilder.create()
                .backgroundColor(Color.web("#123456"))
                .fillColor(Color.web("#c0dcf7"))
                .strokeColor(Color.web("#000"))
                .hoverColor(Color.web("#80f0ae"))
                //.pressedColor(Color.web("#6cee85"))
                .selectedColor(Color.web("#f0cba0"))
                .mousePressHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());
                })
                .selectionEnabled(true)
                .build();
    }

    @Override
    public void start(Stage stage) {
        StackPane pane = new StackPane(france);
        pane.setBackground(new Background(new BackgroundFill(france.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(pane);
        stage.setTitle("Carte des académie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
