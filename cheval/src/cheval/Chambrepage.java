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
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

public class Chambrepage extends Stage {
	// les composants de la fen�tre

	Font cheval = Font.loadFont("file:./font/jeju.ttf", 45);


	private VBox vbox = new VBox();

	private BorderPane racine = new BorderPane();

	private HBox main = new HBox();
	TableView<Arrivee> table = new TableView<Arrivee>();



	ObservableList<Arrivee> data = FXCollections.observableArrayList(
			new Arrivee(256, 320, 2, 873124234, "Michel", "2023-06-16"),
			new Arrivee(257, 321, 1, 873124235, "Sophie", "2023-06-17"),
			new Arrivee(258, 322, 3, 873124236, "Jean", "2023-06-18"),
			new Arrivee(259, 323, 3, 873124237, "Benoît", "2023-06-15"),
			new Arrivee(260, 324, 3, 873124238, "Ludovic", "2023-06-15"),
			new Arrivee(261, 325, 4, 873124239, "Alan", "2023-06-15"),
			new Arrivee(262, 326, 2, 873124240, "Delphine", "2023-06-15"),
			new Arrivee(263, 327, 1, 873124241, "Evan", "2023-06-15"),
			new Arrivee(264, 328, 1, 873124242, "Gabin", "2023-06-15"),
			new Arrivee(265, 329, 2, 873124243, "Arnaud", "2023-06-15"),
			new Arrivee(266, 330, 4, 873124243, "Bob", "2023-06-15"),
			new Arrivee(267, 331, 3, 873124243, "Jack", "2023-06-15"),
			new Arrivee(268, 332, 2, 873124243, "Paul", "2023-06-15"));

	ObservableList<Arrivee> cloneData = FXCollections.observableArrayList(data);

	private Pagination pagination;

	public Chambrepage() throws FileNotFoundException {

		this.setTitle("Hotel le cheval Blanc");
		this.setMinWidth(960);
		this.setMinHeight(540);
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());

		laScene.getStylesheets().add(Chambrepage.class.getResource("styles.css").toExternalForm());

		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(laScene);
	}

	public Parent creerContenu() {

		// Création de la topbar
		HBox topBar = new HBox();
		HBox underBar = new HBox();

		Label date = new Label("Date");
		final LocalDate today = LocalDate.now();

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.TOP_LEFT);

		DatePicker datePicker = new DatePicker();
		datePicker.setDayCellFactory(picker -> new DateCell() {
			@Override
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date.isBefore(LocalDate.now())) {
					setDisable(true);
					setStyle("-fx-background-color: #cccccc;"); // Couleur de fond pour les dates désactivées
				}
			}
		});

		datePicker.setOnAction(event -> {
			LocalDate selectedDate = datePicker.getValue();

			// Filtrer les éléments de l'ObservableList en fonction de la date sélectionnée
			ObservableList<Arrivee> filteredList = FXCollections.observableArrayList();

			if(selectedDate == null) {
				return;
			}

			System.out.println("taille " + cloneData.size());

			for (Arrivee arrivee : cloneData) {
				if (Arrivee.convertDateToLocalDate(arrivee.getDate()).isEqual(selectedDate)) {
					filteredList.add(arrivee);
					System.out.println(selectedDate + " - " + arrivee.getNom());
				}
			}

			// Mettre à jour les données du TableView avec les éléments filtrés
			table.setItems(filteredList);
			data.setAll(filteredList);
			pagination.setPageCount((int) Math.ceil((double) filteredList.size() / rowsPerPage()));

		});

		Button reloadButton = new Button("Recharger");
		reloadButton.setPrefWidth(100);

		reloadButton.getStyleClass().add("button-style");


		reloadButton.setOnMouseClicked(e -> {
			data = FXCollections.observableArrayList(cloneData);
			table.setItems(data);
			pagination.setPageCount((int) Math.ceil((double) data.size() / rowsPerPage()));
			datePicker.setValue(null);
		});

		Button addButton = new Button("Ajouter");
		addButton.setPrefWidth(100);

		addButton.getStyleClass().add("button-style");

		grid.add(datePicker, 0, 0);



		date.setStyle("-fx-font-size: 30; -fx-translate-x: 20px;");
		date.setFont(cheval);
		date.setTextFill(Color.BLACK);
		underBar.setAlignment(Pos.CENTER_LEFT);
		underBar.setSpacing(30);

		underBar.getChildren().addAll(date, datePicker, reloadButton, addButton);

		underBar.setPrefHeight(50);

		topBar.setStyle("-fx-background-color: #0070C0;");

		topBar.prefHeightProperty().bind(this.heightProperty().multiply(0.1));


		// Ajout d'un label pour le texte de la topbar

		topBar.setPadding(new Insets(10));


		StackPane stackPane = new StackPane();

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

		Label headText = new Label("Le Cheval Blanc - Arrivées");

		zoneheader.getChildren().addAll(topBar, headText, gearvue, lignevue, uservue, lignevue2, logoutvue, logovue);

		headText.setStyle("-fx-font-size:38  ; -fx-translate-x: 100px;");
		headText.setFont(cheval);
		headText.setTextFill(Color.WHITESMOKE);
		StackPane.setAlignment(headText, Pos.CENTER_LEFT);

		VBox container = new VBox(zoneheader, underBar, stackPane);

		racine.setTop(container);

		createPagination();


		VBox paginationContainer = new VBox(pagination);
		paginationContainer.setPadding(new Insets(70)); // Définir le padding désiré

		vbox.getChildren().addAll(racine, paginationContainer);

		vbox.setStyle("-fx-background-color:#0000;");

		return vbox;
	}

	private void createPagination() {
		System.out.println(data.size() + "\n" + table.getItems().size());
		pagination = new Pagination((data.size() / rowsPerPage() + 1), 0);
		//   pagination = new Pagination(20 , 0);
		pagination.setPageFactory(new Callback<Integer, Node>() {
			@Override
			public Node call(Integer pageIndex) {
				if (pageIndex > data.size() / rowsPerPage() + 1) {
					return null;
				} else {
					return createPage(pageIndex);
				}
			}
		});

		pagination.getStyleClass().add("custom-pagination");
	}


	public VBox createPage(int pageIndex) {
		int lastIndex = 0;
		int displace = data.size() % rowsPerPage();
		if (displace > 0) {
			lastIndex = data.size() / rowsPerPage();
		} else {
			lastIndex = data.size() / rowsPerPage() - 1;
		}

		VBox box = new VBox(5);
		int page = pageIndex * itemsPerPage();

		for (int i = page; i < page + itemsPerPage(); i++) {


			// Create column UserName (Data type of String).
			TableColumn<Arrivee, String> IDReservation //
					= new TableColumn<Arrivee, String>("Numéro de réservation");

			// Create column Email (Data type of String).
			TableColumn<Arrivee, String> IDChambre//
					= new TableColumn<Arrivee, String>("Numéro de chambre");

			// Create column FullName (Data type of String).
			TableColumn<Arrivee, String> NbOccupants//
					= new TableColumn<Arrivee, String>("Nombre d'occupants");

			// Create 2 sub column for FullName.
			TableColumn<Arrivee, String> clientID//
					= new TableColumn<Arrivee, String>("Numéro du client");

			TableColumn<Arrivee, String> clientName//
					= new TableColumn<Arrivee, String>("Nom du client");

			TableColumn<Arrivee, Void> iconColumn//
					= new TableColumn<Arrivee, Void>("");

			iconColumn.setPrefWidth(30);

			table.getColumns().addAll(IDReservation, IDChambre, NbOccupants, clientID, clientName, iconColumn);

			IDReservation.setCellValueFactory(new PropertyValueFactory<>("numresColumn"));
			IDChambre.setCellValueFactory(new PropertyValueFactory<>("numchambColumn"));
			NbOccupants.setCellValueFactory(new PropertyValueFactory<>("nboccup"));
			clientID.setCellValueFactory(new PropertyValueFactory<>("num"));
			clientName.setCellValueFactory(new PropertyValueFactory<>("nom"));

			IDReservation.setEditable(false);
			IDChambre.setEditable(false);
			NbOccupants.setEditable(false);
			clientID.setEditable(false);
			clientName.setEditable(false);
			iconColumn.setEditable(false);


			IDReservation.setSortable(false);
			IDChambre.setSortable(false);
			NbOccupants.setSortable(false);
			clientID.setSortable(false);
			clientName.setSortable(false);
			iconColumn.setSortable(false);


			IDReservation.setReorderable(false);
			IDChambre.setReorderable(false);
			NbOccupants.setReorderable(false);
			clientID.setReorderable(false);
			clientName.setReorderable(false);
			iconColumn.setReorderable(false);




/**
 IDReservation.prefWidthProperty().bind(this.widthProperty());
 IDChambre.prefWidthProperty().bind(this.widthProperty());
 NbOccupants.prefWidthProperty().bind(this.widthProperty());
 clientID.prefWidthProperty().bind(this.widthProperty());
 clientName.prefWidthProperty().bind(this.widthProperty());
 iconColumn.prefWidthProperty().bind(this.widthProperty());
 */

			iconColumn.setCellFactory(column -> new TableCell<Arrivee, Void>() {
				private final ImageView imageView = new ImageView();

				@Override
				protected void updateItem(Void item, boolean empty) {
					super.updateItem(item, empty);

					if (empty) {
						setGraphic(null);
					} else {
						// Charger votre image à partir d'un fichier ou d'une ressource
						Image image = new Image(getClass().getResourceAsStream("trash.png"));
						imageView.setImage(image);
						setGraphic(imageView);
					}
				}
			});
			if (lastIndex == pageIndex) {
				table.setItems(FXCollections.observableArrayList(data.subList(pageIndex * rowsPerPage(), pageIndex * rowsPerPage() + displace)));
			} else {
				table.setItems(FXCollections.observableArrayList(data.subList(pageIndex * rowsPerPage(), pageIndex * rowsPerPage() + rowsPerPage())));
			}


			box.getChildren().add(table);
		}
		return box;
	}

	public int itemsPerPage() {
		return 1;
	}

	public int rowsPerPage() {
		return 9;
	}
}
