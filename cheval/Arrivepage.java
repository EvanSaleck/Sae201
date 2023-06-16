package cheval;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Arrivepage  extends Stage {
	// les composants de la fen�tre

	Font cheval = Font.loadFont("file:./font/jeju.ttf", 45);

	DatePicker datePicker = new DatePicker();

	DatePicker datePickerBegin = new DatePicker();

	DatePicker datePickerEnd = new DatePicker();

	Label tauxLabel = new Label("");

	private VBox vbox = new VBox();

	private BorderPane racine = new BorderPane();

	private HBox main = new HBox();
	TableView<Chambre> table = new TableView<Chambre>();

	ComboBox<String> comboBox = new ComboBox<>();
	ObservableList<String> categorieList = FXCollections.observableArrayList(
			"Petite", "Moyenne", "Deluxe");


	ObservableList<Chambre> data = FXCollections.observableArrayList(
			new Chambre(320, 3, "Deluxe", "14-06-2023", "19-06-2023"),
			new Chambre(320, 3, "Deluxe", "10-06-2023", "13-06-2023"));



	public Arrivepage() throws FileNotFoundException {

		this.setTitle("Hotel le cheval Blanc");
		this.setMinWidth(960);
		this.setMinHeight(540);
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());

		laScene.getStylesheets().add(Arrivepage.class.getResource("style.css").toExternalForm());

		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(laScene);
	}

	public Parent creerContenu() {

		comboBox.setItems(categorieList);
		comboBox.setValue("Petite");

		// Création de la topbar
		HBox topBar = new HBox();
		StackPane underBar = new StackPane();

		Label date = new Label("Date");
		final LocalDate today = LocalDate.now();

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.TOP_LEFT);



		Label dateBegin = new Label("Date début");

		Label dateEnd = new Label("Date fin");

		RadioButton begin = new RadioButton("Date");
		Button taux = new Button("Calculer");

		taux.setOnMouseClicked(e -> {
			if((datePicker.getValue() != null) || (datePickerBegin.getValue() != null && datePickerEnd.getValue() != null)) {
				tauxLabel.setText("Le taux d'Occupation est de " + getTaux(!begin.isSelected()) * 100 + "%");
			}
		});

		taux.getStyleClass().add("button-style");

		RadioButton beginEnd = new RadioButton("Période");
		beginEnd.setPrefWidth(100);

		begin.setSelected(true);



		HBox underbarBox = new HBox();


		grid.add(datePicker, 0, 0);

		Callback<DatePicker, DateCell> dayCellFactory = new Callback<>() {
			@Override
			public DateCell call(final DatePicker datePickers) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						// Vérifier si la date est invalide (supérieure à la date sélectionnée dans l'autre DatePicker)
						if (datePickers == datePickerBegin && datePickerEnd.getValue() != null && item.isAfter(datePickerEnd.getValue())) {
							setDisable(true); // Désactiver la date
							setStyle("-fx-background-color: #dddddd;"); // Appliquer un style grisé
						} else if (datePickers == datePickerEnd && datePickerBegin.getValue() != null && item.isBefore(datePickerBegin.getValue())) {
							setDisable(true); // Désactiver la date
							setStyle("-fx-background-color: #dddddd;"); // Appliquer un style grisé
						}
					}
				};
			}
		};

// Appliquer la classe d'usine aux DatePicker
		datePickerBegin.setDayCellFactory(dayCellFactory);
		datePickerEnd.setDayCellFactory(dayCellFactory);




		date.setStyle("-fx-font-size: 30; -fx-translate-x: 20px;");
		date.setFont(cheval);
		date.setTextFill(Color.BLACK);

		dateBegin.setStyle("-fx-font-size: 30; -fx-translate-x: 20px;");
		dateBegin.setFont(cheval);
		dateBegin.setTextFill(Color.BLACK);

		dateEnd.setStyle("-fx-font-size: 30; -fx-translate-x: 20px;");
		dateEnd.setFont(cheval);
		dateEnd.setTextFill(Color.BLACK);
		underbarBox.setAlignment(Pos.CENTER_LEFT);
		underBar.setPadding(new Insets(0, 20, 0, 20));

		StackPane.setAlignment(underbarBox, Pos.CENTER_LEFT);
		StackPane.setAlignment(comboBox, Pos.CENTER_RIGHT);
		underbarBox.setSpacing(30);

		underbarBox.getChildren().addAll(comboBox, begin, beginEnd, date, datePicker);

		underBar.getChildren().addAll(underbarBox, comboBox);

		begin.setOnAction(e -> {
			if(beginEnd.isSelected()) {
				beginEnd.setSelected(false);
				if(!underbarBox.getChildren().contains(date) && !underBar.getChildren().contains(datePicker)) {
					underbarBox.getChildren().removeAll(dateBegin, datePickerBegin, dateEnd, datePickerEnd);
					underbarBox.getChildren().addAll(date, datePicker);
				}
			} else {
				begin.setSelected(true);
			}
		});

		beginEnd.setOnAction(e -> {
			if(begin.isSelected()) {
				begin.setSelected(false);

				if(!underbarBox.getChildren().contains(dateBegin) && !underBar.getChildren().contains(datePickerBegin)) {
					underbarBox.getChildren().removeAll(date, datePicker);
					underbarBox.getChildren().addAll(dateBegin, datePickerBegin, dateEnd, datePickerEnd);
				}
			}
			else {
				beginEnd.setSelected(true);
			}
		});

		underBar.setPrefHeight(50);

		topBar.setStyle("-fx-background-color: #0070C0;");

		topBar.prefHeightProperty().bind(this.heightProperty().multiply(0.1));


		// Ajout d'un label pour le texte de la topbar

		topBar.setPadding(new Insets(10));

		VBox mid = new VBox();


		// Ajout de la topbar à la racine de la scène

		underBar.getStyleClass().add("container");
		underBar.setPrefHeight(85);

		Image gear = new Image(getClass().getResourceAsStream("gear.png"));
		ImageView gearvue = new ImageView(gear);

		gearvue.setOnMouseEntered(event -> {
			gearvue.getStyleClass().add("hoverable-image");
		});

		// Supprimez la classe CSS lorsque le curseur quitte la cellule
		gearvue.setOnMouseExited(event -> {
			gearvue.getStyleClass().remove("hoverable-image");
		});

		// Ligne
		Image logo = new Image(getClass().getResourceAsStream("imgcheval.png"));
		ImageView logovue = new ImageView(logo);

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

		StackPane.setAlignment(gearvue, Pos.CENTER_RIGHT);
		gearvue.setFitWidth(50.4);
		gearvue.setFitHeight(61.6);
		gearvue.setStyle("-fx-translate-x: -330px;");

		StackPane.setAlignment(lignevue, Pos.CENTER_RIGHT);
		lignevue.setFitWidth(1);
		lignevue.setFitHeight(75);
		lignevue.setStyle("-fx-translate-x: -310px;");

		StackPane.setAlignment(uservue, Pos.CENTER_RIGHT);
		uservue.setFitWidth(188.8);
		uservue.setFitHeight(57.6);
		uservue.setStyle("-fx-translate-x: -105px;");

		StackPane.setAlignment(lignevue2, Pos.CENTER_RIGHT);
		lignevue2.setFitWidth(1);
		lignevue2.setFitHeight(75);
		lignevue2.setStyle("-fx-translate-x: -90px;");

		StackPane.setAlignment(logovue, Pos.CENTER_LEFT);
		logovue.setFitWidth(100);
		logovue.setFitHeight(100);

		StackPane.setAlignment(logoutvue, Pos.CENTER_RIGHT);
		logoutvue.setFitWidth(40);
		logoutvue.setFitHeight(40);
		logoutvue.setStyle("-fx-translate-x: -20px;");

		StackPane zoneheader = new StackPane();

		Label headText = new Label("Le Cheval Blanc - Chambres");

		zoneheader.getChildren().addAll(topBar, headText, gearvue, lignevue, uservue, lignevue2, logoutvue, logovue);

		headText.setStyle("-fx-font-size:38  ; -fx-translate-x: 100px;");
		headText.setFont(cheval);
		headText.setTextFill(Color.WHITESMOKE);
		StackPane.setAlignment(headText, Pos.CENTER_LEFT);

		StackPane.setAlignment(taux, Pos.CENTER);
		StackPane.setAlignment(tauxLabel, Pos.CENTER_RIGHT);
		taux.setPrefSize(100, 60);
		taux.setStyle("-fx-font-size: 15px;");
		tauxLabel.setStyle("-fx-font-size: 30px;");
		mid.getChildren().addAll(taux, tauxLabel);
		mid.setPadding(new Insets(50));
		mid.setSpacing(20);
		mid.setAlignment(Pos.CENTER);

		StackPane.setAlignment(mid, Pos.CENTER);

		Button button = new Button("< Retour");

		button.setOnAction(e -> {
            Stage stage2 = new Accueil();
            System.out.println("caca");
            this.setScene(stage2.getScene());
		});


		StackPane.setAlignment(button, Pos.BOTTOM_LEFT);

		StackPane center = new StackPane(button);



		button.getStyleClass().add("button-style");

		center.setAlignment(Pos.BOTTOM_LEFT);

		center.setPadding(new Insets(50));

		VBox container = new VBox(zoneheader, underBar, mid);

		racine.setTop(container);

		racine.setBottom(center);





		vbox.setStyle("-fx-background-color:#0000;");


		return racine;
	}

	private float calculerTaux(LocalDate date) {
		int nbChambreOccupee = 0;
		int nbChambreCategorie = 0;
		for(Chambre chambre : data) {
			if(chambre.getCategorie().equals(comboBox.getValue())) {
				nbChambreCategorie++;
			}
			if(!chambre.estLibrePourDate(date) && chambre.getCategorie().equals(comboBox.getValue())) {
				nbChambreOccupee++;
			}
		}
		if(nbChambreCategorie == 0) return 0;

		float res = (float) nbChambreOccupee / nbChambreCategorie;
		return res;
	}

	private float getTaux(boolean periode) {
		if(periode) {
			System.out.println("Période");
			float moy = 0;
			ArrayList<LocalDate> lesDates = new ArrayList<>();
			lesDates = Chambre.getAllDatesInRange(formatLocalDate(datePickerBegin.getValue()), formatLocalDate(datePickerEnd.getValue()));
			for (LocalDate date : lesDates) {
				System.out.println("Pour le " + date + "le taux est de " + calculerTaux(date));
				moy += calculerTaux(date);
			}
			if(lesDates.size() == 0) return 0;
			System.out.println(moy + " DIVISE PAR " + lesDates.size() + " EGAL " + moy/lesDates.size());
			return moy/lesDates.size();
		}
		else {
			System.out.println("Date");
			return calculerTaux(formatLocalDate(datePicker.getValue()));
		}
	}

	public static LocalDate formatLocalDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedString = date.format(formatter);
		return LocalDate.parse(formattedString, formatter);
	}

}
