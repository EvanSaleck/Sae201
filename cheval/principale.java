package cheval;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;

public class principale extends Application{




@Override
public void start(@SuppressWarnings("exports") Stage primaryStage){
	primaryStage = new Accueil();

	primaryStage.show();
	
    Accueil.definirIcone(primaryStage);
	}

public static void main(String[] args) {
	Application.launch();
	};
	
}