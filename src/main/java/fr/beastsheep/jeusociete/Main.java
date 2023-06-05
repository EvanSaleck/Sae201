package fr.beastsheep.jeusociete;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {
        stage = new FenListe();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}