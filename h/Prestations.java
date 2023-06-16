package cheval;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Prestations extends Stage{
	Pane root = new Pane();
	
	Color header = Color.web("#0070C0");
	
	Rectangle head = new Rectangle();
	
	// StackPane
	StackPane zoneheader = new StackPane();
	
	Label HeadText = new Label("Le Cheval Blanc - Prestations");
	
    Font cheval = Font.loadFont("file:./font/Jeju.ttf", 45);
    
    //HBox 
    HBox zonebtn = new HBox();
    
    //button
	Button buttonSupprPresta = new Button("Supprimer une Prestation");
    Button buttonCréerPresta = new Button("Créer une prestation");
    Button buttontri = new Button("Afficher Par période");
    
	//TableView
    
	TableView<PrestationsServies> Prestations = new TableView<PrestationsServies>();
	private static ObservableList<PrestationsServies> data = FXCollections.observableArrayList();
    
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
    
	Prestations(){
		this.setTitle("Gestion Hôtel");
		this.setWidth(1920);
		this.setHeight(1024);
		this.setResizable(false);
		this.setMaximized(true);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		
		ajouter();
		Prestations.setItems(data);
		
		laScene.getStylesheets().add(Accueil.class.getResource("styles.css").toExternalForm());
	}
	
	public Parent creerContenu(){
		
		TableColumn<PrestationsServies, String> date = new TableColumn<>("Date de la prestation");
	      TableColumn<PrestationsServies, String> type = new TableColumn<>("Type de prestation");
	      TableColumn<PrestationsServies, String> libelle = new TableColumn<>("libellé");
	      TableColumn<PrestationsServies, String> quantite = new TableColumn<>("Quantité");


	      date.setCellValueFactory(new PropertyValueFactory<>("date"));
	      type.setCellValueFactory(new PropertyValueFactory<>("type"));
	      libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
	      quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));


	      Prestations.getColumns().addAll(date, type, libelle, quantite);

	        
	      date.prefWidthProperty().bind(Prestations.widthProperty().multiply(0.25));
	        type.prefWidthProperty().bind(Prestations.widthProperty().multiply(0.3));
	        libelle.prefWidthProperty().bind(Prestations.widthProperty().multiply(0.3));
	        quantite.prefWidthProperty().bind(Prestations.widthProperty().multiply(0.2));

	        date.setResizable(false);
	        type.setResizable(false);
	        libelle.setResizable(false);
	        quantite.setResizable(false);

	        date.setReorderable(false);
	        type.setReorderable(false);
	        libelle.setReorderable(false);
	        quantite.setReorderable(false);
	        
	        Prestations.setPrefWidth(1920); // Définit une largeur préférée de 400 pixels
	        Prestations.setPrefHeight(800); // Définit une hauteur préférée de 300 pixels
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
		
		buttonCréerPresta.setStyle("-fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 10px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px;");
		buttontri.setStyle("-fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 10px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px; -fx-translate-x: -75px");
		buttonSupprPresta.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-padding: 10px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px; -fx-translate-x: 25px");
		
		Button back = new Button("< Retour");

		back.setOnAction(e -> {
		    Accueil accueil = new Accueil();
		    accueil.show();
		    this.close();
		});

		
		StackPane.setAlignment(back, Pos.BOTTOM_LEFT);
		back.setStyle("-fx-translate-y: 975px; -fx-transale-x: -600px; -fx-background-color: #0070C0; -fx-text-fill: white; -fx-padding: 10px; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 ); -fx-border-radius: 50px;");

		StackPane center = new StackPane(back);
		
		buttonCréerPresta.setOnAction(e -> AjoutData());
		buttontri.setOnAction(e -> trierParPeriode());
		Prestations.setStyle("-fx-translate-y: 150px;");
		zonebtn.setStyle("-fx-translate-y: 110px; -fx-translate-x: 1475px");
		
		zonebtn.getChildren().addAll(buttontri, buttonCréerPresta, buttonSupprPresta);
		
		zoneheader.getChildren().addAll(head, HeadText, gearvue, lignevue, uservue, lignevue2, logoutvue, logovue);
		
		root.getChildren().addAll(zoneheader, zonebtn, Prestations, center);
		
		return root;
	}
    
    public static void definirIcone(Stage stage) {
        // Chargement de l'icône
        Image icon = new Image(Prestations.class.getResourceAsStream("imgcheval.png"));

        // Définition de l'icône pour la fenêtre
        stage.getIcons().add(icon);
    }
    
    public static void AjoutData() {
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Création Prestation");

        Label label = new Label("Renseignez les informations sur la prestation :");

        TextField libelleField = new TextField();
        libelleField.setPromptText("Libellé");

        Label libelleErrorLabel = new Label();
        libelleErrorLabel.setTextFill(Color.RED);

        ToggleGroup toggleGroup = new ToggleGroup();
        
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now()); // Définit la date actuelle comme valeur par défaut

        RadioButton radioButton1 = new RadioButton("Pressing");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton1.setSelected(true);

        RadioButton radioButton2 = new RadioButton("Consommation au bar");
        radioButton2.setToggleGroup(toggleGroup);

        RadioButton radioButton3 = new RadioButton("Consommation en chambre");
        radioButton3.setToggleGroup(toggleGroup);

        TextField prixField = new TextField();
        prixField.setPromptText("Prix");

        Label prixErrorLabel = new Label();
        prixErrorLabel.setTextFill(Color.RED);

        Button closeButton = new Button("Fermer");
        closeButton.setOnAction(e -> modalStage.close());

        Button ApplyButton = new Button("Sauvegarder");
        ApplyButton.setOnAction(e -> {
            String libelle = libelleField.getText();
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            String type = selectedRadioButton.getText();
            LocalDate date = datePicker.getValue();
            double prix = 0;

            boolean hasError = false;

            // Vérifier si le champ libellé est vide
            if (libelle.isEmpty()) {
                libelleErrorLabel.setText("Le champ libellé est requis");
                hasError = true;
            } else {
                libelleErrorLabel.setText(""); // Effacer le message d'erreur précédent
            }

            // Vérifier si le champ prix est vide ou contient une valeur invalide
            try {
                prix = Double.parseDouble(prixField.getText());
                prixErrorLabel.setText(""); // Effacer le message d'erreur précédent
            } catch (NumberFormatException ex) {
                prixErrorLabel.setText("Le champ prix est invalide");
                hasError = true;
            }

            if (!hasError) {
                try {
                    Prestation prestation = new Prestation(libelle, type, prix, date); // Remplacez null par la valeur de la date
                    // Faites quelque chose avec la prestation sauvegardée (par exemple, l'ajouter à une liste)
                    System.out.println("Prestation sauvegardée : " + prestation.toString());

                    modalStage.close();
                } catch (LibelleInvalideException ex) {
                    libelleErrorLabel.setText(ex.getMessage());
                } catch (TarifInvalideException ex) {
                    prixErrorLabel.setText(ex.getMessage());
                }
            }
        });


        VBox vbox = new VBox(label, libelleField, libelleErrorLabel, radioButton1, radioButton2, radioButton3, datePicker, prixField, prixErrorLabel, closeButton, ApplyButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        Scene modalScene = new Scene(vbox);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
        }
    
    public void trierParPeriode() {
        // Créer un comparateur personnalisé pour comparer les dates des prestations
        Comparator<PrestationsServies> comparator = Comparator.comparing(p -> LocalDate.parse(p.getDate(), DateTimeFormatter.ISO_LOCAL_DATE));

        // Trier les données de la TableView en utilisant le comparateur
        FXCollections.sort(data, comparator);

        // Rafraîchir la TableView pour refléter les nouvelles données triées
        Prestations.refresh();
    }
    
    public void ajouter() {
        data.add(new PrestationsServies("2023-06-16", "Consommation au bar", "Pina Colada", 2));
        data.add(new PrestationsServies("2023-06-17", "Consommation au bar", "Pina Colada", 2));
        data.add(new PrestationsServies("2023-06-18", "Consommation au bar", "Pina Colada", 2));
        data.add(new PrestationsServies("2023-06-19", "Consommation au bar", "Pina Colada", 2));
        data.add(new PrestationsServies("2023-06-16", "Pressing", "Lavage", 2));
        data.add(new PrestationsServies("2023-06-16", "Pressing", "Lavage", 2));
        data.add(new PrestationsServies("2023-06-17", "Pressing", "Lavage", 2));
        data.add(new PrestationsServies("2023-06-18", "Pressing", "Lavage", 2));
        data.add(new PrestationsServies("2023-06-19", "Pressing", "Lavage", 2));
        data.add(new PrestationsServies("2023-06-20","Pressing", "Lavage", 2));
    }
}

