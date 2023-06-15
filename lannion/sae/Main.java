package fr.lannion.sae;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    Stage stage;

    public void start(Stage stage) throws Exception {
        stage = new FenChambre();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}