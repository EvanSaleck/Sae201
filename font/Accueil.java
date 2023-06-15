package sae;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Accueil extends Stage {
	// Stage
	//private Stage Prestations;
	//private Stage Chambres;
	
	// CSS 
	String css = this.getClass().getResource("styles.css").toExternalForm();
	
	// Insets
	Insets tab = new Insets(40);

	// Vbox
	VBox root = new VBox();
	VBox texttab = new VBox();
	
	// StackPane
	StackPane zoneheader = new StackPane();
	
	//HBox 
	VBox zonetab = new VBox();
	// Couleur Customs 
	Color header = Color.web("#0070C0");
	
	// Boutons
	Button buttonPagePrestations = new Button("Voir les Prestations");
	Button buttonPageChambres = new Button("Voir les Chambres");
	
	// Textes 
	Label HeadText = new Label("Le Cheval Blanc - Accueil");
	Label Welcome = new Label("Bonjour, Voici les arrivées prévues :");
	Label Choix = new Label("Si vous souhaitez voir les Chambres et les prestations: "
			+ "");
	
	Rectangle head = new Rectangle();
	
    Font cheval = Font.loadFont("file:./font/Jeju.ttf", 45);
	//TableView
    
	TableView<Arrivee> Arrivees = new TableView<Arrivee>();
	private static ObservableList<Arrivee> data = FXCollections.observableArrayList();
	// Pagination
	private Pagination pagination;
    
    // Image 
    // logo
    Image logo = new Image(getClass().getResourceAsStream("imgcheval.png"));
    ImageView logovue = new ImageView(logo);
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
	
	
	
	Accueil(){
	this.setTitle("Gestion Hôtel");
	this.setWidth(1920);
	this.setHeight(1024);
	this.setResizable(true);
	this.setMaximized(true);
	Scene laScene = new Scene(creerContenu());
	this.setScene(laScene);
	AjoutData();
	addArrivee(data);

	}
	
	@SuppressWarnings({ "exports", "unchecked" })
	public Parent creerContenu(){

	      
	      TableColumn<Arrivee, String> numresColumn = new TableColumn<>("Numéro de réservation");
	      TableColumn<Arrivee, String> numchambColumn = new TableColumn<>("Numéros de chambres reservés");
	      TableColumn<Arrivee, String> nboccup = new TableColumn<>("Nombre de personnes occupant la chambre");
	      TableColumn<Arrivee, String> num = new TableColumn<>("Numéro Client");
	      TableColumn<Arrivee, String> nom = new TableColumn<>("Nom Client");

	      numresColumn.setCellValueFactory(new PropertyValueFactory<>("numresColumn"));
	      numchambColumn.setCellValueFactory(new PropertyValueFactory<>("numchambColumn"));
	      nboccup.setCellValueFactory(new PropertyValueFactory<>("nboccup"));
	      num.setCellValueFactory(new PropertyValueFactory<>("num"));
	      nom.setCellValueFactory(new PropertyValueFactory<>("nom"));

	      Arrivees.getColumns().addAll(numresColumn, numchambColumn, nboccup, num, nom);

	        
	        numresColumn.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.25));
	        numchambColumn.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.25));
	        nboccup.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.3));
	        num.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.1));
	        nom.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.1));

	        numresColumn.setResizable(false);
	        numchambColumn.setResizable(false);
	        nboccup.setResizable(false);
	        num.setResizable(false);
	        nom.setResizable(false);
	        
	        numresColumn.setReorderable(false);
	        numchambColumn.setReorderable(false);
	        nboccup.setReorderable(false);
	        num.setReorderable(false);
	        nom.setReorderable(false);
	        
	        Arrivees.setPrefWidth(1100);
	        Arrivees.setPrefHeight(1024);
		// Bouton de tp de pages
		

		buttonPageChambres.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        //Page1 Prestations = new Prestations();
		        //Scene page1Scene = new Scene(page1, 400, 300);
		        //Prestations.setScene(page1Scene);
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
		HeadText.setStyle("-fx-font-size:38  ; -fx-translate-x: 100px;");
		HeadText.setFont(cheval);
		HeadText.setTextFill(Color.WHITESMOKE);
        StackPane.setAlignment(HeadText, Pos.CENTER_LEFT);
        // Image de connexion
        
		// Rectangle du header
 
		head.setFill(header);
		head.setWidth(1920);
		head.setHeight(100);
		
		//image des paramètres 
		StackPane.setAlignment(gearvue, Pos.CENTER_RIGHT);
		gearvue.setFitHeight(70);
		gearvue.setStyle("-fx-translate-x: -320px;");
		
		StackPane.setAlignment(logovue, Pos.CENTER_LEFT);
		logovue.setFitWidth(100);
		logovue.setFitHeight(100);
		
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
		Welcome.setStyle("-fx-font-size: 40px;-fx-translate-x: 60px;");
		Welcome.setFont(cheval);
		
		Choix.setStyle("-fx-font-size: 40px;-fx-translate-x: 60px;");
		Choix.setFont(cheval);
		
		buttonPagePrestations.setStyle("-fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 5px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px;");
		buttonPageChambres.setStyle("-fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 5px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px;");
	
		texttab.setAlignment(Pos.CENTER_LEFT);
		zonetab.setAlignment(Pos.CENTER_RIGHT);
		Arrivees.setStyle("-fx-translate-x: 600px;");
		
		zonetab.setMaxWidth(1500);

		
		// Ajout de toutes nos entités dans mes zones
		texttab.getChildren().addAll(Welcome, Choix, buttonPageChambres, buttonPagePrestations);
		
		zonetab.getChildren().addAll(Arrivees);
		
		zoneheader.getChildren().addAll(head, HeadText, gearvue, lignevue, uservue, lignevue2, logoutvue, logovue);
		
		root.getChildren().addAll(zoneheader, texttab);
		return root;
	}
	
	public void addArrivee(ObservableList<Arrivee> data) {
	    // Utilisation de la classe LocalDate pour représenter la date actuelle
	    LocalDate now = LocalDate.now();
	    
	    // Comparaison des dates d'arrivée avec la date actuelle
	    for (Arrivee arrivee : data) {
	        LocalDate arriveeDate = arrivee.convertDateToLocalDate();

	        if (arriveeDate.isBefore(now)) {
	            System.out.println("La date d'arrivée est antérieure à la date actuelle.");
	        } else if (arriveeDate.isAfter(now)) {
	            System.out.println("La date d'arrivée est postérieure à la date actuelle.");
	        } else {
	            // Ajout des objets à la TableView
	            Arrivees.getItems().add(arrivee);
	        }
	    }

	}

	
    public static void AjoutData() {
        data.add(new Arrivee(256, 320, 2, 873124234, "Michel", "2023-06-16"));
        data.add(new Arrivee(257, 321, 1, 873124235, "Sophie", "2023-06-17"));
        data.add(new Arrivee(258, 322, 3, 873124236, "Jean", "2023-06-18"));
        data.add(new Arrivee(259, 323, 3, 873124237, "Benoît", "2023-06-15"));
        data.add(new Arrivee(260, 324, 3, 873124238, "Ludovic", "2023-06-15"));
        data.add(new Arrivee(261, 325, 4, 873124239, "Alan", "2023-06-15"));
        data.add(new Arrivee(262, 326, 2, 873124240, "Delphine", "2023-06-15"));
        data.add(new Arrivee(263, 327, 1, 873124241, "Evan", "2023-06-15"));
        data.add(new Arrivee(264, 328, 1, 873124242, "Gabin", "2023-06-15"));
        data.add(new Arrivee(265, 329, 2, 873124243, "Arnaud", "2023-06-15"));
    }
	

}


