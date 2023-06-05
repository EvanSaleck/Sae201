package fr.beastsheep.jeusociete;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class FenListe extends Stage {
	// les composants de la fen�tre
	private BorderPane	racine			= new BorderPane();


	public FenListe() throws FileNotFoundException {
		this.setTitle("Hotel le cheval Blanc");
		this.setMinWidth(960);
		this.setMinHeight(540);
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());
		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(laScene);

	}
	
	public Parent creerContenu(){

		// Création de la topbar
		HBox topBar = new HBox();
		topBar.setStyle("-fx-background-color: #5FA4E3;");

		topBar.prefHeightProperty().bind(this.heightProperty().multiply(0.1));
		topBar.setMinHeight(this.getHeight() / 10);


		// Ajout d'un label pour le texte de la topbar
		Label titleLabel = new Label("Ma TopBar");
		titleLabel.setTextFill(Color.WHITE);
		topBar.getChildren().add(titleLabel);

		// Ajout de la topbar à la racine de la scène
		racine.setTop(topBar);

		return racine;
	}
	
}
