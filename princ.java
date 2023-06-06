package ihm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
	Label HeadText = new Label("Le Cheval Blanc - Accueil");
	
	Rectangle head = new Rectangle();
	
    Font cheval = Font.loadFont("file:./font/Jeju.ttf", 45);
   
    // Image 
    // Param
    Image gear = new Image(getClass().getResourceAsStream("gear.png"));
    ImageView gearvue = new ImageView(gear);
    // Ligne
    Image ligne = new Image(getClass().getResourceAsStream("ligne.png"));
    ImageView lignevue = new ImageView(ligne);
    // User 
    Image user = new Image(getClass().getResourceAsStream("user.png"));
    ImageView uservue = new ImageView(user);
    // Ligne 2
    Image ligne2 = new Image(getClass().getResourceAsStream("ligne.png"));
    ImageView lignevue2 = new ImageView(ligne2);
    // Logout
    Image logout = new Image(getClass().getResourceAsStream("logout.png"));
    ImageView logoutvue = new ImageView(logout);
	
	
	
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
		HeadText.setStyle("-fx-font-size:38  ; -fx-translate-x: 20px;");
		HeadText.setFont(cheval);
		HeadText.setTextFill(Color.WHITESMOKE);
        StackPane.setAlignment(HeadText, Pos.CENTER_LEFT);
        // Image de connexion
        
		// Rectangle du header
		head.setFill(header);
		head.setWidth(1280);
		head.setHeight(100);
		
		//image des paramètres 
		StackPane.setAlignment(gearvue, Pos.CENTER_RIGHT);
		gearvue.setFitWidth(40);
		gearvue.setFitHeight(50);
		gearvue.setStyle("-fx-translate-x: -320px;");
		
		StackPane.setAlignment(lignevue, Pos.CENTER_RIGHT);
		lignevue.setFitWidth(1);
		lignevue.setFitHeight(75);
		lignevue.setStyle("-fx-translate-x: -300px;");
		
		StackPane.setAlignment(uservue, Pos.CENTER_RIGHT);
		uservue.setFitWidth(175);
		uservue.setFitHeight(50);
		uservue.setStyle("-fx-translate-x: -105px;");
		
		StackPane.setAlignment(lignevue2, Pos.CENTER_RIGHT);
		lignevue2.setFitWidth(1);
		lignevue2.setFitHeight(75);
		lignevue2.setStyle("-fx-translate-x: -90px;");
		
		StackPane.setAlignment(logoutvue, Pos.CENTER_RIGHT);
		logoutvue.setFitWidth(40);
		logoutvue.setFitHeight(40);
		logoutvue.setStyle("-fx-translate-x: -20px;");
		
		// Ajout de toutes nos entités dans la Hbox du header
		zoneheader.getChildren().addAll(head, HeadText, gearvue, lignevue, uservue, lignevue2, logoutvue);
		
		root.getChildren().addAll(zoneheader);
		return root;
	}
}
