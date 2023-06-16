package cheval;

import java.io.FileNotFoundException;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Accueil extends Stage {
	// Stage
	private Stage Prestations;
	private Stage Arrivepage;
	private Stage FenChambre;
	//private Stage Chambres;
	

	
	// Insets
	Insets tab = new Insets(40);

	// Vbox
	Pane root = new Pane();
	HBox texttab = new HBox();
	
	// StackPane
	StackPane zoneheader = new StackPane();
	
	//HBox 
	VBox zonetab = new VBox();
	// Couleur Customs 
	Color header = Color.web("#0070C0");
	
	// Boutons
	Button buttonPagePrestations = new Button("Voir les Prestations");
	Button buttonPageChambres = new Button("Voir les Chambres");
	Button buttonPageArrivees = new Button("Voir Toutes les Arrivées");
	
	// Textes 
	Label HeadText = new Label("Le Cheval Blanc - Accueil");
	Label Welcome = new Label("Bonjour, Voici les arrivées prévues aujourd'hui:");
	Label ChoixChambre = new Label("Cliquez en dessous si vous souhaitez voir les chambres: "+ "");
	Label Choixpresta = new Label("Cliquez en dessous si vous souhaitez voir les prestations: "+ "");
	
	Rectangle head = new Rectangle();
	
    Font cheval = Font.loadFont("file:./font/Jeju.ttf", 45);
	//TableView
    
	TableView<Arrivee> Arrivees = new TableView<Arrivee>();
	private static ObservableList<Arrivee> data = FXCollections.observableArrayList();
    
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
    //ligne3
    Image ligne3 = new Image(getClass().getResourceAsStream("lignevert.png"));
    ImageView lignevue3 = new ImageView(ligne3);
    // Logout
    Image logout = new Image(getClass().getResourceAsStream("logout.png"));
    ImageView logoutvue = new ImageView(logout);
	
    // Icone
    Image t = new Image(getClass().getResourceAsStream("imgcheval.png"));

	
	Accueil(){
	this.setTitle("Gestion Hôtel");
	this.setWidth(1920);
	this.setHeight(1024);
	this.setResizable(false);
	this.setMaximized(true);
	Scene laScene = new Scene(creerContenu());
	this.setScene(laScene);
	
	laScene.getStylesheets().add(Accueil.class.getResource("styles.css").toExternalForm());

	AjoutData();
	addArrivee(data);
	}

	@SuppressWarnings({ "exports", "unchecked" })
	public Parent creerContenu(){

	      
	      TableColumn<Arrivee, String> numresColumn = new TableColumn<>("Numéro de réservation");
	      TableColumn<Arrivee, String> numchambColumn = new TableColumn<>("Numéros de chambres reservés");
	      TableColumn<Arrivee, String> nboccup = new TableColumn<>("Nombre de personnes occupant la chambre");
			// Create 2 sub column for FullName.
			TableColumn<Arrivee, String> clientID//
					= new TableColumn<Arrivee, String>("Numéro du client");

			TableColumn<Arrivee, String> clientName//
					= new TableColumn<Arrivee, String>("Nom du client");

	      numresColumn.setCellValueFactory(new PropertyValueFactory<>("numresColumn"));
	      numchambColumn.setCellValueFactory(new PropertyValueFactory<>("numchambColumn"));
	      nboccup.setCellValueFactory(new PropertyValueFactory<>("nboccup"));
			clientID.setCellValueFactory(new PropertyValueFactory<>("num"));
			clientName.setCellValueFactory(new PropertyValueFactory<>("nom"));


	      Arrivees.getColumns().addAll(numresColumn, numchambColumn, nboccup, clientID, clientName);

	        
	        numresColumn.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.25));
	        numchambColumn.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.25));
	        nboccup.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.3));
	        clientID.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.1));
	        clientName.prefWidthProperty().bind(Arrivees.widthProperty().multiply(0.1));

	        numresColumn.setResizable(false);
	        numchambColumn.setResizable(false);
	        nboccup.setResizable(false);
	        clientID.setResizable(false);
	        clientName.setResizable(false);
	        
	        numresColumn.setReorderable(false);
	        numchambColumn.setReorderable(false);
	        nboccup.setReorderable(false);
	        clientID.setReorderable(false);
	        clientName.setReorderable(false);
	        
	        Arrivees.setPrefWidth(1920); // Définit une largeur préférée de 400 pixels
	        Arrivees.setPrefHeight(625); // Définit une hauteur préférée de 300 pixels
		// Bouton de tp de pages
		

		buttonPageChambres.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {

		    }
		});

		buttonPageArrivees.setOnAction(e -> {
            Stage stage = null;
			try {
				stage = new Chambrepage();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            this.setScene(stage.getScene());
        });
		
		buttonPagePrestations.setOnAction(e -> {
            Stage stage = new Prestations();
            this.setScene(stage.getScene());
        });
		
		buttonPageChambres.setOnAction(e -> {
            Stage stage = null;
			try {
				stage = new Arrivepage();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            this.setScene(stage.getScene());
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
		Welcome.setStyle("-fx-font-size: 35px;-fx-translate-x: 550px; -fx-translate-y: 60px");
		Welcome.setFont(cheval);
		Welcome.setUnderline(true);
		
		ChoixChambre.setStyle("-fx-font-size: 30px;-fx-translate-x: 40px;");
		ChoixChambre.setFont(cheval);
		ChoixChambre.setUnderline(true);
		
		Choixpresta.setStyle("-fx-font-size: 30px;-fx-translate-x: 385px; fx-translate-y: -20px;");
		Choixpresta.setFont(cheval);
		Choixpresta.setUnderline(true);
		
		buttonPagePrestations.setStyle("-fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 10px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px; -fx-translate-y: 50px; -fx-translate-x: -215px;");
		buttonPageChambres.setStyle("-fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 10px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px; -fx-translate-x: -1200px; -fx-translate-y: 50px");
		buttonPageArrivees.setStyle("-fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 10px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px; -fx-translate-y: -73px; -fx-translate-x: 42px;");
		texttab.setAlignment(Pos.BASELINE_LEFT);
		texttab.setStyle("-fx-translate-y: 850px");
		zonetab.setAlignment(Pos.TOP_RIGHT);
		
		Arrivees.setStyle("-fx-translate-y: 160px");
		
		
		// Ajout de toutes nos entités dans mes zones
		texttab.getChildren().addAll(ChoixChambre, Choixpresta, buttonPageChambres, buttonPagePrestations, buttonPageArrivees);
		
		zoneheader.getChildren().addAll(head, HeadText, gearvue, lignevue, uservue, lignevue2, logoutvue, logovue);
		
		root.getChildren().addAll(zoneheader, texttab, Arrivees, Welcome);
		return root;
	}
	
	public void addArrivee(ObservableList<Arrivee> data) {
	    // Utilisation de la classe LocalDate pour représenter la date actuelle
	    LocalDate now = LocalDate.now();
	    
	    // Comparaison des dates d'arrivée avec la date actuelle
	    for (Arrivee arrivee : data) {
	        LocalDate arriveeDate = arrivee.convertDateToLocalDate();

	        if (arriveeDate.isBefore(now)) {
	        } else if (arriveeDate.isAfter(now)) {
	        } else {
	            // Ajout des objets à la TableView
	            Arrivees.getItems().add(arrivee);
	        }
	    }

	}

	
    public static void AjoutData() {
        data.add(new Arrivee(256, 320, 2, 873124234, "Michel", "2023-06-16"));
        data.add(new Arrivee(257, 321, 1, 873124235, "Sophie", "2023-06-16"));
        data.add(new Arrivee(258, 322, 3, 873124236, "Jean", "2023-06-18"));
        data.add(new Arrivee(259, 323, 3, 873124237, "Benoît", "2023-06-15"));
        data.add(new Arrivee(260, 324, 3, 873124238, "Ludovic", "2023-06-15"));
        data.add(new Arrivee(261, 325, 4, 873124239, "Alan", "2023-06-15"));
        data.add(new Arrivee(262, 326, 2, 873124240, "Delphine", "2023-06-15"));
        data.add(new Arrivee(263, 327, 1, 873124241, "Evan", "2023-06-15"));
        data.add(new Arrivee(264, 328, 1, 873124242, "Gabin", "2023-06-15"));
        data.add(new Arrivee(265, 329, 2, 873124243, "Arnaud", "2023-06-15"));
    }
    
    public static void definirIcone(Stage stage) {
        // Chargement de l'icône
        Image icon = new Image(Accueil.class.getResourceAsStream("imgcheval.png"));

        // Définition de l'icône pour la fenêtre
        stage.getIcons().add(icon);
    }
}


