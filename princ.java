package ihm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class princ extends Stage {
	// Vbox
	VBox root = new VBox();
	
	// Hbox
	StackPane zoneheader = new StackPane();
	
	// Couleur Customs 
	Color header = Color.web("#5FA4E3");
	
	
	// Textes 
	Label HeadText = new Label("Le Cheval Blanc");
	
	Rectangle head = new Rectangle();
	
	
	
	princ(){
	this.setTitle("Gestion Hôtel");
	this.setWidth(1280);
	this.setHeight(1024);
	this.setResizable(true);
	this.setMaximized(true);
	Scene laScene = new Scene(creerContenu());
	this.setScene(laScene);
	}
	
	public Parent creerContenu(){
		// Texte sur le header
		HeadText.setStyle("-fx-font-size:38 ; -fx-font-weight:BOLD ; -fx-font-style: JejuGothic");
		HeadText.setPadding(10);
		HeadText.setTextFill(Color.WHITESMOKE);
        StackPane.setAlignment(HeadText, Pos.CENTER_LEFT);
        // Image de connexion
        
		// Rectangle du header
		head.setFill(header);
		head.setWidth(1280);
		head.setHeight(100);

		
		// Ajout de toutes nos entités dans la Hbox du header
		zoneheader.getChildren().addAll(head, HeadText);
		
		root.getChildren().addAll(zoneheader);
		return root;
	}
}
