package ihm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class princ extends Stage {
	// Stage
	//private Stage deuxStage;
	//private Stage troisStage;
	
	// Insets
	Insets tab = new Insets(40);

	// Vbox
	VBox root = new VBox();
	
	// StackPane
	StackPane zoneheader = new StackPane();
	
	//HBox 
	HBox zonetab = new HBox();
	HBox zonebtn = new HBox();
	// Couleur Customs 
	Color header = Color.web("#5FA4E3");
	
	// Boutons
	Button buttonPagePrestations = new Button("Voir les Prestations");
	Button buttonPageChambres = new Button("Voir les Chambres");
	
	// Textes 
	Label HeadText = new Label("Le Cheval Blanc - Accueil");
	Label Welcome = new Label("Bonjour, Voici les arrivées prévues :");
	Label Choix = new Label("Si vous souhaitez voir les Chambres et les prestations, "
			+ "");
	
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
	
	@SuppressWarnings({ "exports", "unchecked" })
	public Parent creerContenu(){
	      TableView<Person> Arrivees = new TableView<>();

	        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
	        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");

	        Arrivees.getColumns().addAll(firstNameColumn, lastNameColumn);
	        
	        Arrivees.setPrefWidth(840);
	        Arrivees.setPrefHeight(600);
		// Bouton de tp de pages
		

		buttonPageChambres.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        //Page1 page1 = new Page1();
		        //Scene page1Scene = new Scene(page1, 400, 300);
		        //deuxStage.setScene(page1Scene);
		    }
		});


		buttonPagePrestations.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        //Page2 page2 = new Page2();
		        //Scene page2Scene = new Scene(page2, 400, 300);
		        //troisStage.setScene(page2Scene);
		    }
		});

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
		
		// Zone tableau
		Welcome.setPadding(tab);
		Welcome.setStyle("-fx-font-size: 20px;-fx-translate-x: -20px;");
		Welcome.setFont(cheval);
		
		// Zone Bouton

		
		// Ajout de toutes nos entités dans mes zones
		zonebtn.getChildren().addAll(Choix, buttonPagePrestations, buttonPageChambres);
		
		zonetab.getChildren().addAll(Welcome, Arrivees);
		
		zoneheader.getChildren().addAll(head, HeadText, gearvue, lignevue, uservue, lignevue2, logoutvue);
		
		root.getChildren().addAll(zoneheader, zonetab, zonebtn);
		return root;
	}
	

}


