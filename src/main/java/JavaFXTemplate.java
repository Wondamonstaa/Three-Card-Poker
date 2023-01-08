import java.util.ArrayList;
import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {

	//FIXME: Step 1: declare all variables => DONE
	private Player playerOne;
	private Player playerTwo;
	private Dealer dealerObject;
	private Menu menu;
	private MenuItem EXIT;
	private Stage stage;
	private MenuBar menubar;
	private MenuItem FreshStart;
	private BorderPane core;
	private MenuItem NewLook;
	private int option;
	private int round = 1;
	final String midLabel = "-fx-background-color: linear-gradient(#5bf57f, #24ec5c);";
	final String midButtonSize = "-fx-font-size: 35;";
	final String midButtonOption = "-fx-background-color: linear-gradient(#5bf57f, #24ec5c);";
	String buttonSize = "-fx-font-size: 30;";
	String buttonSize2 = "-fx-font-size: 25;";
	String buttonSize3 = "-fx-font-size: 33;";
	final int height = 350;
	final int width = 350;
	final int buttonWidth = 200;
	final int midButtonWidth = 250;
	final int midButtonHeight = 150;
	String buttonSize1 = "-fx-font-size: 55;";
	final String fontSize = "-fx-font-size: 50;";
	final String fontSize1 = "-fx-font-size: 65;";
	final String basicPane = "-fx-background-image: url(blackDragon.jpg);-fx-background-color: rgba(0, 0, 0, 0.5);";
	//make basicPane opaque
	public String basicPane2 = "-fx-background-image: url(newBack.jpg); -fx-background-color: rgba(0, 0, 0, 0.5);";
	final String alternativePane = "-fx-background-image: url(backOption3.jpg);";
	final String colorMenu = "-fx-background-color: linear-gradient(to top, rgb(36,236,92), rgb(36,236,92));";
	final String menuBarOption2 = "-fx-background-color: linear-gradient(to top, #24ec5c, #24ec5c);";
	final String buttonLook1 = "-fx-background-color: linear-gradient(#5bf57f, #24ec5c);";
	final String buttonLook3 = "-fx-background-color: linear-gradient(#e52170, #e52170);";
	final String buttonLook2 = "-fx-background-color: linear-gradient(to top, #5bf57f, #9f3ede);";
	final String buttonLook4 = "-fx-background-color: linear-gradient(#5bf57f, #24ec5c);";
	final String buttonLook5 = "-fx-background-color: linear-gradient(#e52170, #e52170);";
	ListView<String> image1;
	ObservableList<String> items;
	Label prompt;
	Image card_back;
	ImageView cardCover;
	Image player1FirstCard;
	ImageView player1CardOption1;
	Image player1SecondCard;
	ImageView player1CardOption2;
	Image player1ThirdCard;
	ImageView player1CardOption3;
	Image player2CardOption1;
	ImageView player2NewCard1;
	Image player2CardOption2;
	ImageView player2NewCard2;
	Image player2CardOption3;
	ImageView player2NewCard3;
	Image dealerCard1;
	ImageView dealerNewCard1;
	Image dealerCard2;
	ImageView dealerNewCard2;
	Image dealerCard3;
	ImageView dealerNewCard3;
	Label p1;
	Label anteLabel;
	Label pairPlus;
	TextField anteBet;
	TextField ppBet;
	Label p2;
	Button pressButton;
	private HBox bottomInfo;
	private HBox box1;
	private HBox box2;
	private HBox playerCardBox;
	private HBox dealerCardBox;
	private VBox allCardsBox;
	private VBox playFoldBox;
	private HBox bottomPlayFoldBox;
	private TextField playCards;
	private Label labelForPlayCards;
	private Label playFoldprompt;
	private VBox promptAndTxt;
	Button foldButton;
	Button playButton;
	private HBox finalHBox;
	Button playAgain;
	Button quitGame;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//This is the start screen scene
	public Scene StartScene() {

		Rectangle r = new Rectangle(100, 40, 100, 100);
		r.setArcHeight(50);
		r.setArcWidth(50);
		r.setFill(Color.VIOLET);

		RotateTransition rt = new RotateTransition(Duration.millis(5000), r);
		rt.setByAngle(270);
		rt.setCycleCount(4);
		rt.setAutoReverse(true);
		SequentialTransition seqTransition = new SequentialTransition(
				new PauseTransition(Duration.millis(500)),
				rt
		);
		seqTransition.play();

		FadeTransition ft = new FadeTransition(Duration.millis(5000), r);
		ft.setFromValue(1.0);
		ft.setToValue(0.3);
		ft.setCycleCount(4);
		ft.setAutoReverse(true);

		ft.play();

		BorderPane root = new BorderPane();
		root.setCenter(r);

		//Scene scene = new Scene(root, 700,700);
		//primaryStage.setScene(scene);
		//primaryStage.show();

		BorderPane paneCenter = new BorderPane();
		paneCenter.setStyle(basicPane);

		BorderPane newPane = new BorderPane();
		newPane.setPadding(new Insets(20, 0, 20, 20));

		EXIT = new MenuItem("EXIT");
		FreshStart = new MenuItem("FRESH START");
		NewLook = new MenuItem("NEW LOOK");

		menubar = new MenuBar();
		menu = new Menu("OPTIONS", null);
		menu.setStyle("-fx-font-weight: bold;");
		menu.setOnHidden(e -> {
			paneCenter.setStyle(basicPane);
		});

		menu.setStyle(colorMenu);
		menu.getItems().addAll(EXIT, FreshStart, NewLook);
		menubar.setEffect(new DropShadow());
		menubar.setMinSize(75, 35);
		menubar.setPadding(new Insets(10, 10, 10, 10));
		menubar.setEffect(new DropShadow());
		menubar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		menubar.setStyle(colorMenu);

		menubar.getMenus().add(menu);
		menu.setStyle(colorMenu);
		menubar.setStyle(colorMenu);
		menubar.setCenterShape(true);
		menubar.setPrefSize(100, 50);


		//Allows to click the menubar
		EXIT.setOnAction(e -> {
			//display root after clicking

			System.exit(0);
		});

		MenuItem EXIT2 = new MenuItem("EXIT");
		MenuItem freshStart2 = new MenuItem("FRESH START");
		MenuItem newLook2 = new MenuItem("NEW LOOK");

		MenuBar menubar2 = new MenuBar();
		Menu menu2 = new Menu("OPTIONS");
		menu2.getItems().addAll(EXIT2, freshStart2, newLook2);
		menubar2.setMinSize(75, 50);
		menubar2.setPadding(new Insets(10, 10, 10, 10));
		menubar2.setEffect(new DropShadow());
		menubar2.setOnKeyPressed(e -> {
			System.out.println("Key Pressed");
		});
		menubar2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		menubar2.getMenus().add(menu2);
		menu2.setStyle(colorMenu);
		menubar2.setStyle(colorMenu);

		newPane.setTop(menubar2);
		BorderPane.setAlignment(menubar2, Pos.TOP_RIGHT);

		ToggleButton rules = new ToggleButton("RULES");
		rules.setEffect(new DropShadow());
		Text newText = new Text("NEW GAME");
		//Contact us button
		ToggleButton contactUs = new ToggleButton("CONTACT US");
		contactUs.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #5bf57f;");
		contactUs.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 20));
		contactUs.setPadding(new Insets(0, 0, 0, 0));
		contactUs.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		contactUs.setOpacity(0.65);

		newText.setStyle(fontSize);
		newText.setEffect(new DropShadow());
		newText.setFill(Color.WHITE);
		newText.setStroke(Color.BLACK);
		newText.setStrokeWidth(2);
		newText.setEffect(new DropShadow());
		newText.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.BLACK, 10, 0, 0, 0));

		newText.setFont(Font.font("Verdana", FontWeight.BOLD, 50));

		Text rulesText = new Text(
				"The goal of poker is to win the pot, " +
						"which contains all the bets that the players have made in any one deal. " +
						"The player who makes the last bet " +
						"or who checks when all other players have folded is entitled to show their hand and declare their bet. " +
						"The player with the winning hand takes the pot. ");


		rules.setOnAction((ActionEvent) -> {

			//Open new scene
			Stage newStage = new Stage();
			BorderPane newPane2 = new BorderPane();
			newPane2.setStyle(basicPane);
			newPane2.setPadding(new Insets(20, 0, 20, 20));
			newPane2.setCenter(rules);


			String rules2 = "The player who makes the last bet or who checks when all other players have folded is entitled to show their hand and declare their bet. " +
					"The player with the winning hand takes the pot.";


			rulesText.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
			rulesText.setFill(Color.WHITE);
			rulesText.setBoundsType(TextBoundsType.VISUAL);

			Rectangle rect = new Rectangle();
			rect.setX(50);
			rect.setY(50);
			rect.setWidth(500);
			rect.setHeight(500);

			LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLACK), new Stop(1, Color.BLACK));
			rect.setFill(gradient);
			rect.setStroke(Color.WHITE);
			rect.setStrokeWidth(5);
			rect.setArcWidth(20);
			rect.setArcHeight(20);
			rect.setEffect(new DropShadow());
			rect.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.BLACK, 10, 0.5, 0, 0));

			//Add text to the rectangle
			TitledPane stack = new TitledPane();
			stack.setAnimated(false);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Poker Rules");
			alert.setHeaderText("Poker Rules");
			alert.setContentText("The goal of poker is to win the pot, which contains all the bets that the players have made in any one deal. " +
					"The player who makes the last bet or who checks when all other players have folded is entitled to show their hand and declare their bet. " +
					"The player with the winning hand takes the pot.");


			alert.getDialogPane().setStyle("-fx-background-color: #ffffff; -fx-text-fill: #FFFFFF; -fx-font-size: 25px; -fx-font-weight: bold; -fx-border-color: #000000; -fx-border-width: 5px; -fx-border-radius: 20px; -fx-background-radius: 20px;");
			alert.getDialogPane().setEffect(new DropShadow());
			alert.getDialogPane().setMinSize(500, 500);
			alert.getDialogPane().setMaxSize(500, 500);
			alert.getDialogPane().setPrefSize(500, 500);
			alert.getDialogPane().setPadding(new Insets(10, 10, 10, 10));
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

			Rectangle rect2 = new Rectangle(500, 500);
			rect2.setArcWidth(20);
			rect2.setArcHeight(20);
			rect2.setFill(Color.BLACK);
			alert.getDialogPane().setClip(rect2);
			alert.showAndWait();
			newPane2.setCenter(stack);
			rulesText.setEffect(new DropShadow());
			rules.setDisable(true);

			ToggleButton escape = new ToggleButton("BACK");
			escape.getBackground();
			escape.setEffect(new Glow());
			escape.setEffect(new DropShadow());
			escape.setOnAction((e) -> {
				newStage.close();
			});

			newPane2.setBottom(escape);
			newStage.show();
		});


		//FIXME: create buttons for the starting scene => DONE
		ToggleButton playBtn = new ToggleButton("NEW GAME");
		playBtn.setStyle(fontSize);
		playBtn.setEffect(new Glow());
		playBtn.setEffect(new DropShadow());
		playBtn.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		playBtn.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

		Button quitBtn = new Button("QUIT");
		quitBtn.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		quitBtn.setEffect(new DropShadow());
		quitBtn.setFont(Font.font("Verdana", FontWeight.BOLD, 50));

		ToggleButton welcomeButton = new ToggleButton("THREE CARD POKER");
		welcomeButton.setEffect(new DropShadow());
		welcomeButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


		welcomeButton.setEffect(new Glow());
		welcomeButton.setStyle("-fx-background-color: MediumSeaGreen");
		welcomeButton.setAlignment(Pos.TOP_CENTER);
		welcomeButton.setOnAction((ActionEvent) -> {
			System.out.println("Welcome to the Three Card Poker Game!");
			welcomeButton.setText("WELCOME! CHOOSE AN OPTION BELOW!");
			welcomeButton.setEffect(new Glow());
			welcomeButton.setEffect(new DisplacementMap());
			welcomeButton.setDisable(true);
		});

		//Contact button
		Button contactBtn = new Button("CONTACT US");
		contactUs.setEffect(new DropShadow());
		contactUs.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		contactUs.setEffect(new Glow());
		contactUs.setStyle("-fx-background-color: MediumSeaGreen");
		contactUs.setAlignment(Pos.BOTTOM_CENTER);
		contactUs.setOnAction((ActionEvent) -> {
			contactUs.setText("CONTACT US: kbara5@uic.edu");
			contactUs.setDisable(false);
		});

		//use contactBtn
		contactBtn.setOnAction((ActionEvent) -> {
			contactBtn.setText("CONTACT US: kbara5@uic.edu");
			//create pop up window with contact info
			Stage newStage = new Stage();
			newStage.setTitle("Contact Us");
			newStage.setResizable(false);
			newStage.initModality(Modality.APPLICATION_MODAL);
			BorderPane np = new BorderPane();
			Scene newScene = new Scene(np, 500, 500);
			newStage.setScene(newScene);
			newStage.show();
			contactBtn.setDisable(false);
		});

		//put contactBtn on the bottom of the box
		contactBtn.setAlignment(Pos.BOTTOM_CENTER);

		//A new border pane for the contact button
		BorderPane contactPane = new BorderPane();
		contactPane.setCenter(contactBtn);

		//Contact Button
		BorderPane.setAlignment(contactPane, Pos.BOTTOM_LEFT);

		Image pic = new Image("KING START SCENE.png");
		ImageView front1 = new ImageView(pic);
		Image pic2 = new Image("ACE START SCENE.png");
		ImageView front2 = new ImageView(pic2);
		Image pic3 = new Image("J START SCENE.png");
		ImageView front3 = new ImageView(pic3);

		//A feedback button
		Button feedbackBtn = new Button("FEEDBACK");
		feedbackBtn.setPrefSize(100, 50);
		feedbackBtn.setStyle(buttonSize + buttonLook3);
		feedbackBtn.setOnAction((ActionEvent) -> {
			feedbackBtn.setText("FEEDBACK:");
			feedbackBtn.setDisable(false);
		});

		//pop up window after clicking feedbackBtn
		feedbackBtn.setOnAction(e -> {
			Stage feedbackStage = new Stage();
			feedbackStage.setTitle("FEEDBACK");
			feedbackStage.initModality(Modality.APPLICATION_MODAL);
			feedbackStage.initOwner(stage);
			feedbackStage.setMinWidth(250);
			feedbackStage.setMinHeight(250);
			feedbackStage.setMaxWidth(250);
			feedbackStage.setMaxHeight(250);
			feedbackStage.setResizable(false);
			feedbackStage.show();
		});

		HBox background = new HBox(front1, front2, front3);
		HBox test = new HBox(200, menubar);

		final Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		spacer.setMaxSize(24, 0);

		//This makes the top of the BorderPane putting menuBar at top and flush image below
		VBox topPane = new VBox(test, background);
		topPane.setSpacing(30);

		playBtn.setPrefSize(300, 100);
		HBox btnBox = new HBox(contactPane, rules, playBtn, quitBtn, feedbackBtn);
		HBox testBox = new HBox(contactPane, feedbackBtn);
		btnBox.setSpacing(20);
		HBox test2Box = new HBox(testBox, btnBox);
		VBox labelBox = new VBox(welcomeButton, btnBox);

		EXIT.setOnAction(e -> System.exit(0));
		FreshStart.setOnAction(e -> {

		});
		NewLook.setOnAction(e -> {
			if(option == 0){
				option = 1;
				welcomeButton.setStyle(fontSize + "-fx-text-fill: #29e843;");
				menu.setStyle(menuBarOption2);
				menubar.setStyle(menuBarOption2);
				paneCenter.setStyle(alternativePane);
				playBtn.setStyle(buttonSize + buttonLook1);
				rules.setStyle(buttonSize + buttonLook3);
				quitBtn.setStyle(buttonSize + buttonLook3);
			}
			else{
				option = 0;
				welcomeButton.setStyle(fontSize + "-fx-text-fill: #24ec5c;");
				menu.setStyle(colorMenu);
				menubar.setStyle(colorMenu);
				paneCenter.setStyle(basicPane);
				playBtn.setStyle(buttonSize + buttonLook1);
				rules.setStyle(buttonSize + buttonLook3);
				quitBtn.setStyle(buttonSize + buttonLook3);
			}
		});

		//Set the front images => DONE
		front1.setFitHeight(height);
		front1.setFitWidth(width);
		front1.setPreserveRatio(true);
		front2.setFitHeight(height);
		front2.setFitWidth(width);
		front2.setPreserveRatio(true);
		front3.setFitHeight(height);
		front3.setFitWidth(width);
		front3.setPreserveRatio(true);
		background.setSpacing(40);
		background.setAlignment(Pos.TOP_CENTER);


		//Buttons to be placed at the bottom
		playBtn.setPrefSize(buttonWidth, 65);
		playBtn.setStyle(buttonSize + buttonLook1);
		playBtn.setOnAction(e -> {
			stage.setScene(playGameScene());
		});

		rules.setPrefSize(buttonWidth, 45);
		rules.setStyle(buttonSize + buttonLook3);
		quitBtn.setPrefSize(buttonWidth, 45);
		quitBtn.setStyle(buttonSize + buttonLook3);
		quitBtn.setOnAction(e -> System.exit(0));
		btnBox.setAlignment(Pos.CENTER);
		btnBox.setSpacing(70);
		btnBox.setPadding(new Insets(70, 0, 0, 0));

		welcomeButton.setStyle(fontSize + "-fx-text-fill: #000000;");
		welcomeButton.setFont(Font.font("Times New Roman", 25));
		labelBox.setPadding(new Insets(20, 0, 0, 0));
		labelBox.setAlignment(Pos.TOP_CENTER);


		paneCenter.setCenter(labelBox);
		paneCenter.setTop(topPane);
		paneCenter.setBottom(contactUs);
		paneCenter.setStyle(basicPane);


		return new Scene(paneCenter, 1200, 750);

	}

	//Set up for the first look
	private void builderOne(){

		menu.setStyle(colorMenu);
		menubar.setStyle(colorMenu);
		core.setStyle(basicPane);
		anteLabel.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #e52170;");
		pairPlus.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #5bf57f;");
		anteLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		pairPlus.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		labelForPlayCards.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #000000;");
		p1.setStyle(fontSize + "-fx-text-fill: #24ec5c;");
		p1.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		p1.setAlignment(Pos.BOTTOM_LEFT);
		p1.setOpacity(0.65);
		p1.setMinWidth(200);
		p1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		p2.setStyle(fontSize + "-fx-text-fill: #24ec5c;");
		p2.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		p2.setAlignment(Pos.BOTTOM_LEFT);
		p2.setOpacity(0.65);
		p2.setMinWidth(200);
		p2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		buttonSize = "-fx-font-size: 35;" + "-fx-text-fill: #ffffff;";
		pressButton.setStyle(buttonSize + buttonLook1);
		playButton.setStyle(buttonSize1 + buttonLook1);
		playButton.setMinSize(100, 45);
		foldButton.setStyle(buttonSize + buttonLook1);
		foldButton.setEffect(new DropShadow());
		playAgain.setStyle(buttonSize + buttonLook1);
		quitGame.setStyle("-fx-background-color: #e52170;" + "-fx-text-fill: #000000;");
		quitGame.setFont(Font.font("Verdana", FontWeight.NORMAL, 35));
		anteBet.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #000000;");
	}

	//Set up for the second look
	void builderTwo(){

		menu.setStyle(menuBarOption2);
		menubar.setStyle(menuBarOption2);
		core.setStyle(alternativePane);
		anteLabel.setStyle("-fx-font-size: 20;" + "-fx-text-fill: #e87373;");
		pairPlus.setStyle("-fx-font-size: 20;" + "-fx-text-fill: #a81fff;");
		labelForPlayCards.setStyle("-fx-font-size: 20;" + "-fx-text-fill: #ffe000;");
		p1.setStyle(fontSize + "-fx-text-fill: #b852fa;");
		p2.setStyle(fontSize + "-fx-text-fill: red;");
		pressButton.setStyle(buttonSize + buttonLook2);
		playButton.setStyle(buttonSize + buttonLook2);
		buttonSize = "-fx-font-size: 35;" + "-fx-text-fill: #ffffff;";
		foldButton.setStyle(buttonSize + buttonLook2);
		playAgain.setStyle(buttonSize + buttonLook2);
		quitGame.setStyle(buttonSize + buttonLook2);
	}

	//Create an observable list of the players
	private ArrayList<String> database() {
		ArrayList<String> holder = new ArrayList<String>();
		holder.add("PLAYER 1");
		holder.add("ANTE BET: $" + playerOne.getAnteBet());
		holder.add("PAIR PLUS BET: $" + playerOne.getPairPlusBet());
		holder.add("PLAY BET: $" + playerOne.getPlayBet());
		holder.add("WON: " + playerOne.getTotalWinnings());
		holder.add("BALANCE: $" + playerOne.getTotalAmount());
		holder.add("");
		holder.add("PLAYER 2");
		holder.add("ANTE BET: $" + playerTwo.getAnteBet());
		holder.add("PAIR PLUS BET: $" + playerTwo.getPairPlusBet());
		holder.add("PLAY BET: $" + playerTwo.getPlayBet());
		holder.add("WON: " + playerTwo.getTotalWinnings());
		holder.add("BALANCE: $" + playerTwo.getTotalAmount());

		return holder;
	}

	//Used to get card images by their name
	private String cardGetter(Card card) {

		String result = "" + card.getValue();
		result += Character.toString(card.getSuit());
		return result;
	}

	//Helper function used to set up the default parameters to the provided object
	private ImageView parameteres(ImageView object){

		object.setFitHeight(175);
		object.setFitWidth(145);
		object.setPreserveRatio(true);

		return object;
	}

	//Helper function to create the HBox
	private void constructor(String card, String card2, String card3, int choice){

		ArrayList<String> holder = new ArrayList<>();
		holder.add(card);
		holder.add(card2);
		holder.add(card3);

		ArrayList<HBox> boxHolder = new ArrayList<>();

		for(String s : holder){
			Image object = new Image(s + ".png");
			ImageView result = new ImageView(object);
			HBox readyBox = new HBox(result);
			boxHolder.add(readyBox);
		}

		if(choice == 1) {
			player1FirstCard = new Image(holder.get(0) + ".png");
			player1SecondCard = new Image(holder.get(1) + ".png");
			player1ThirdCard = new Image(holder.get(2) + ".png");

			player1CardOption1 = new ImageView(player1FirstCard);
			player1CardOption2 = new ImageView(player1SecondCard);
			player1CardOption3 = new ImageView(player1ThirdCard);

			box1 = new HBox(player1CardOption1, player1CardOption2, player1CardOption3);
		}
        if(choice == 2){
			player2CardOption1 = new Image(holder.get(0) + ".png");
			player2CardOption2 = new Image(holder.get(1) + ".png");
			player2CardOption3 = new Image(holder.get(2) + ".png");

			player2NewCard1 = new ImageView(player2CardOption1);
			player2NewCard2 = new ImageView(player2CardOption2);
			player2NewCard3 = new ImageView(player2CardOption3);
			box2 = new HBox(player2NewCard1, player2NewCard2, player2NewCard3);
		}
		if(choice == 3){
			dealerCard1 = new Image(holder.get(0) + ".png");
			dealerCard2 = new Image(holder.get(1) + ".png");
			dealerCard3 = new Image(holder.get(2) + ".png");
			dealerNewCard1 = new ImageView(dealerCard1);
			dealerNewCard2 = new ImageView(dealerCard2);
			dealerNewCard3 = new ImageView(dealerCard3);
			dealerCardBox = new HBox(dealerNewCard1, dealerNewCard2, dealerNewCard3);
			dealerCardBox.setPadding(new Insets(0, 0, 0, 300));
		}
	}

	private void imageBuilder(Image card, Image card2, Image card3, int choice){

		card = new Image("Card Face Down.png");
		card2 = new Image("Card Face Down.png");
		card3 = new Image("Card Face Down.png");

		if(choice == 1) {
			player2NewCard1 = new ImageView(card);
			player2NewCard2 = new ImageView(card2);
			player2NewCard3 = new ImageView(card3);
			box2 = new HBox(player2NewCard1, player2NewCard2, player2NewCard3);
		}
		if(choice == 2){
			dealerNewCard1 = new ImageView(card);
			dealerNewCard2 = new ImageView(card2);
			dealerNewCard3 = new ImageView(card3);
			Region spacer = new Region();
			//spacer.setPrefWidth(2);
			dealerCardBox = new HBox(dealerNewCard1, dealerNewCard2,  dealerNewCard3);
			dealerCardBox.setPadding(new Insets(0, 0, 15, 300));
		}
	}

	//Displays current 3 cards in Player 1 Hand => DONE
	private void openHandFirst() {

		//Get the cards from the deck
		String first = cardGetter(playerOne.getHand().get(0));
		String second = cardGetter(playerOne.getHand().get(1));
		String third = cardGetter(playerOne.getHand().get(2));
		constructor(first, second, third, 1);

		parameteres(player1CardOption1);
		parameteres(player1CardOption2);
		parameteres(player1CardOption3);

		imageBuilder(player2CardOption1, player2CardOption2 , player2CardOption3, 1);
		parameteres(player2NewCard1);
		parameteres(player2NewCard2);
		parameteres(player2NewCard3);

		imageBuilder(dealerCard1, dealerCard2 , dealerCard3, 2);
		parameteres(dealerNewCard1);
		parameteres(dealerNewCard2);
		parameteres(dealerNewCard3);

	}

	//Helper function: allows to flip the player 1's cards
	private void putDown(){
		player1FirstCard = new Image("Card Face Down.png");
		player1SecondCard = new Image("Card Face Down.png");
		player1ThirdCard = new Image("Card Face Down.png");

		player1CardOption1 = new ImageView(player1FirstCard);
		player1CardOption2 = new ImageView(player1SecondCard);
		player1CardOption3 = new ImageView(player1ThirdCard);
		box1 = new HBox(player1CardOption1, player1CardOption2, player1CardOption3);
	}

	//Helper function => allows to reveal player's two hand => DONE
	private void openHandSecond() {

		putDown();
		parameteres(player1CardOption1);
		parameteres(player1CardOption2);
		parameteres(player1CardOption3);

		//Setup images and put them in the right boxes
		String c1 = cardGetter(playerTwo.getHand().get(0));    //player 1
		String c2 = cardGetter(playerTwo.getHand().get(1));
		String c3 = cardGetter(playerTwo.getHand().get(2));
		constructor(c1, c2, c3, 2);

		parameteres(player2NewCard1);
		parameteres(player2NewCard2);
		parameteres(player2NewCard3);

		dealerCard1 = new Image("Card Face Down.png");
		dealerCard2 = new Image("Card Face Down.png");
		dealerCard3 = new Image("Card Face Down.png");

		imageBuilder(dealerCard1, dealerCard2 , dealerCard3, 2);
		parameteres(dealerNewCard1);
		parameteres(dealerNewCard2);
		parameteres(dealerNewCard3);
	}

	//Helper function which allows to display all cards at once
	private void showAllCards() {

		//Collect the top 3 cards from player 1 + construct a box using them
		String c1 = cardGetter(playerOne.getHand().get(0));
		String c2 = cardGetter(playerOne.getHand().get(1));
		String c3 = cardGetter(playerOne.getHand().get(2));
		constructor(c1, c2, c3, 1);

		parameteres(player1CardOption1);
		parameteres(player1CardOption2);
		parameteres(player1CardOption3);

		//Collect the top 3 cards from player 2 + construct a box using them
		c1 = cardGetter(playerTwo.getHand().get(0));
		c2 = cardGetter(playerTwo.getHand().get(1));
		c3 = cardGetter(playerTwo.getHand().get(2));
		constructor(c1, c2, c3, 2);

		//Resizes player 2 cards
		parameteres(player2NewCard1);
		parameteres(player2NewCard2);
		parameteres(player2NewCard3);

		//Collect the top 3 cards from dealer + construct a box using them
		c1 = cardGetter(dealerObject.getDealersHand().get(0));
		c2 = cardGetter(dealerObject.getDealersHand().get(1));
		c3 = cardGetter(dealerObject.getDealersHand().get(2));
		constructor(c1, c2, c3, 3);

		parameteres(dealerNewCard1);
		parameteres(dealerNewCard2);
		parameteres(dealerNewCard3);

	}
	private void foldMakeUp(){

		foldButton.setStyle("-fx-background-color: #e30046");
		foldButton.setPrefSize(100, 50);
		foldButton.setTextFill(Color.BLACK);
		foldButton.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		foldButton.setPadding(new Insets(10, 10, 10, 10));
		foldButton.setEffect(new DropShadow());

		HBox playFoldBox = new HBox(25, playButton, foldButton);
		playFoldBox.setAlignment(Pos.CENTER);
		playFoldBox.setPadding(new Insets(20, 0, 35, 0));

		//playFoldBox = new VBox(20, playButton, foldButton);
		playCards = new TextField("0");

		HBox playBox = new HBox(labelForPlayCards, playCards);
		playFoldprompt = new Label("PLEASE, PLACE YOUR BET BETWEEN $5 TO $25");
		playFoldprompt.setStyle("-fx-font-size: 15;" + "-fx-text-fill: #24ec5c;");
		promptAndTxt = new VBox(playBox, playFoldprompt);
		promptAndTxt.setPadding(new Insets(45, 0, 0, 0));

		bottomPlayFoldBox = new HBox(50, p1, promptAndTxt, playFoldBox);
		bottomPlayFoldBox.setAlignment(Pos.CENTER);
		core.setBottom(bottomPlayFoldBox);
	}
	private void pressHelper(int anteBetNum, int ppBetNum){

		//Begin the new round
		round = 3;
		playerTwo.setAnteBet(anteBetNum);
		playerTwo.setPairPlusBet(ppBetNum);
		ArrayList<String> dataArr2 = database();
		image1.getItems().removeAll(items);
		items.clear();
		items.addAll(dataArr2);
		image1.setItems(items);

		bottomInfo.setVisible(false);
		prompt.setVisible(false);
		
		//Empty the box
		anteBet.clear();
		ppBet.clear();
		
		playerOne.setHand(dealerObject.dealHand());
		playerTwo.setHand(dealerObject.dealHand());
		dealerObject.setDealersHand(dealerObject.dealHand());

		//This displays player 1 cards
		openHandFirst();
		
		playerCardBox = new HBox(200, box2, box1);
		playerCardBox.setAlignment(Pos.CENTER);
		playerCardBox.setPadding(new Insets(200, 0, 0, 0));

		//whole dealerCard box
		allCardsBox = new VBox(dealerCardBox, playerCardBox);
		allCardsBox.setAlignment(Pos.CENTER);
		core.setCenter(allCardsBox);
	}

	private void pressHelper2(int anteBetNum, int ppBetNum){

		//Begin the new round
		round = 3;
		playerTwo.setAnteBet(anteBetNum);
		playerTwo.setPairPlusBet(ppBetNum);
		ArrayList<String> dataArr2 = database();
		image1.getItems().removeAll(items);
		items.clear();
		items.addAll(dataArr2);
		image1.setItems(items);

		bottomInfo.setVisible(false);
		prompt.setVisible(false);

		//Empty the box
		anteBet.clear();
		ppBet.clear();

		playerOne.setHand(dealerObject.dealHand());
		playerTwo.setHand(dealerObject.dealHand());
		dealerObject.setDealersHand(dealerObject.dealHand());

		//This displays player 1 cards
		openHandSecond();

		playerCardBox = new HBox(200, box2, box1);
		playerCardBox.setAlignment(Pos.CENTER);
		playerCardBox.setPadding(new Insets(200, 0, 0, 0));

		//whole dealerCard box
		allCardsBox = new VBox(dealerCardBox, playerCardBox);
		allCardsBox.setAlignment(Pos.CENTER);
		core.setCenter(allCardsBox);
	}

	private void handComparison(){
		evaluator();
	}
	private void gameBrain(){

		//Calculates the pair plus winnings
		//Tracks total winning both positive or negative
		int player1Total = 0;
		int player2Total = 0;
		int choice;

		evaluator();

		//Got a ton of help with this during OH =O
		if (playerTwo.getDidFold()) {
			player2Total = (playerTwo.getAnteBet() + playerTwo.getPairPlusBet() +
					playerTwo.getPlayBet()) * -1;
			System.out.println("Player 2 total: " + player2Total);
		}
		else if (ThreeCardLogic.compareHands(dealerObject.getDealersHand(), playerTwo.getHand()) == 2) {
			player2Total = ((playerTwo.getAnteBet() + playerTwo.getPlayBet() * 2) +
					playerTwo.getPairPlusBet());
			playerTwo.setTotalWinnings(playerTwo.getTotalWinnings() + 1);
			System.out.println("Player 2 wins");
		}
		else if (ThreeCardLogic.compareHands(dealerObject.getDealersHand(), playerTwo.getHand()) == 1) {
			player2Total = playerTwo.getPairPlusBet() + ((playerTwo.getAnteBet() +
					playerTwo.getPlayBet()) * -1);
			System.out.println("Dealer wins");
		}
		else{
			player2Total = playerTwo.getPairPlusBet();
			System.out.println("Tie");
		}

		//Calculates total winnings based on what happened in game
		if(playerOne.getDidFold()){
			player1Total = (playerOne.getAnteBet() + playerOne.getPairPlusBet() +
					playerOne.getPlayBet()) * -1;
			choice = 1;
		}
		else if(playerTwo.getDidFold()){
			player1Total = (playerOne.getAnteBet() + playerOne.getPairPlusBet() +
					playerOne.getPlayBet());
			choice = 2;
		}
		/*else{
			choice = ThreeCardLogic.evalHand(playerOne.getHand(), playerTwo.getHand());
			if(choice == 1){
				player1Total = (playerOne.getAnteBet() + playerOne.getPairPlusBet() +
						playerOne.getPlayBet());
			}
			else if(choice == 2){
				player1Total = (playerOne.getAnteBet() + playerOne.getPairPlusBet() +
						playerOne.getPlayBet()) * -1;
			}
			else{
				player1Total = playerOne.getAnteBet() + playerOne.getPairPlusBet();
			}
		}*/
		else if(ThreeCardLogic.compareHands(dealerObject.getDealersHand(), playerOne.getHand()) == 2){
			player1Total = ((playerOne.getAnteBet() + playerOne.getPlayBet()) * 2) + playerOne.getPairPlusBet();
			choice = 2;
			System.out.println("Player 1 wins");
		}
		else if (ThreeCardLogic.compareHands(dealerObject.getDealersHand(), playerOne.getHand()) == 1){
			player1Total = playerOne.getPairPlusBet() + ((playerOne.getAnteBet() + playerOne.getPlayBet()) * -1);
			playerOne.setTotalWinnings(playerOne.getTotalWinnings() + 1);
			choice = 3;
			System.out.println("Dealer wins");
		}
		else{
			choice = 4;
			player1Total = playerOne.getPairPlusBet();
			System.out.println("Tie");
		}

		playerOne.setTotalAmount(playerOne.getTotalAmount() + player1Total);
		playerTwo.setTotalAmount(playerTwo.getTotalAmount() + player2Total);
		//Sets up screen to show winnings and play or quit options of the game
		Label p1Wins = new Label("PLAYER 1 WINS: " + "$" + player1Total);
		Label p2Wins = new Label("PLAYER 2 WINS: " + "$" + player2Total);
		p1Wins.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #5bf57f;");
		p2Wins.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #5bf57f;");
		p1Wins.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		p2Wins.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		VBox result = new VBox(p1Wins, p2Wins);
		result.setPadding(new Insets(35, 0, 0, 300));
		result.setSpacing(40);

		Region spacer = new Region();
		spacer.setPrefHeight(25);

		VBox endGameWins = new VBox(10, p1Wins, p2Wins);
		HBox endGameOptions = new HBox(15, playAgain, quitGame);
		finalHBox = new HBox(35, endGameWins, endGameOptions);

	}

	private void evaluator() {
		if(playerOne.getPairPlusBet() != 0 && !playerOne.getDidFold()){
			int winBet = (ThreeCardLogic.evalPPWinnings(playerOne.getHand(), playerOne.getPairPlusBet()));
			try{
				if(winBet == 0){
					playerOne.setPairPlusBet(playerOne.getPairPlusBet() * -1);
				}
				else{
					throw new Exception();
				}
			}catch(Exception e){
				playerOne.setPairPlusBet(winBet);
			}
		}

		if(playerTwo.getPairPlusBet() != 0 && !playerTwo.getDidFold()){
			int winBet = (ThreeCardLogic.evalPPWinnings(playerTwo.getHand(), playerTwo.getPairPlusBet()));
			if(winBet == 0){
				playerTwo.setPairPlusBet(playerTwo.getPairPlusBet() * -1);
			}
			else{
				playerTwo.setPairPlusBet(winBet);
			}
		}
	}

	//Activates the majority of event handlers in the game => DONE
	private void engine(TextField newTxt, Button contactUs, TextArea chatWindow, Alert alert){

		//Makes prompt disappear when clicked
		prompt.setOnMouseClicked(e -> {
			prompt.setVisible(false);
			newTxt.setVisible(true);
		});

		contactUs.setOnAction(e -> {
			chatWindow.setVisible(true);
		});

		//allows to repeat the alert message if the user clicks on the New Game button
		prompt.setOnMouseClicked(e -> {
			alert.showAndWait();
		});

		//Activates QUIT button
		quitGame.setOnAction(e -> {
			System.exit(0);
		});

		//Activates PLAY AGAIN button
		playAgain.setOnAction(e -> {
			playerOne.setPlayBet(0);
			playerTwo.setAnteBet(0);
			playerOne.setPairPlusBet(0);
			playerTwo.setDidFold(false);
			playerOne.setAnteBet(0);
			playerOne.setDidFold(false);
			playerTwo.setPairPlusBet(0);
			playerTwo.setPlayBet(0);
			round = 1;
			stage.setScene(playGameScene());
		});

		//Activate NewLook
		NewLook.setOnAction(e -> {

			if(option == 0){
				option = 1;
				menu.setStyle(menuBarOption2);
				menubar.setStyle(menuBarOption2);
				core.setStyle(alternativePane);
				pressButton.setStyle(buttonSize + buttonLook2);
				playButton.setStyle(buttonSize + buttonLook2);
				foldButton.setStyle(buttonSize + buttonLook2);
				playAgain.setStyle(buttonSize + buttonLook1);
				quitGame.setStyle(buttonSize + buttonLook1);
			}
			else{
				option = 0;
				menu.setStyle(colorMenu);
				menubar.setStyle(colorMenu);
				core.setStyle(basicPane);
				pressButton.setStyle(buttonSize + buttonLook1);
				playButton.setStyle(buttonSize + buttonLook1);
				foldButton.setStyle(buttonSize + buttonLook1);
				playAgain.setStyle(buttonSize + buttonLook2);
				quitGame.setStyle(buttonSize + buttonLook2);
			}
		});

		EXIT.setOnAction(e -> System.exit(0));

		FreshStart.setOnAction(e -> {
			round = 1;
			playerOne = new Player();
			playerTwo = new Player();
			dealerObject = new Dealer();
			stage.setScene(playGameScene());
		});

		NewLook.setOnAction(e -> {
			if(option == 0){
				option = 1;
				stage.setScene(playGameScene());
			}
			else if(option == 1){
				option = 0;
				stage.setScene(playGameScene());
			}
		});

		pressButton.setOnAction(e -> {
			if ((!anteBet.getText().trim().isEmpty() && !ppBet.getText().trim().isEmpty()) && round == 1){
				int anteCompare = Integer.parseInt(anteBet.getText());
				int playBetCompare = Integer.parseInt(ppBet.getText());
				if(anteCompare > playerOne.getTotalAmount() || playBetCompare > playerOne.getTotalAmount()){
					Alert alert1 = new Alert(Alert.AlertType.ERROR);
					alert1.setTitle("ERROR");
					alert1.setHeaderText("Oops, your bet is too high!");
					alert1.setContentText("Please enter a valid amount");
					alert1.showAndWait();
				}
				else{
					if ((anteCompare >= 5 && anteCompare <= 25) &&
							((playBetCompare >= 5 && playBetCompare <= 25) || playBetCompare == 0)) {

						playerOne.setAnteBet(anteCompare);
						playerOne.setPairPlusBet(playBetCompare);
						ArrayList<String> dataArr2 = database();
						image1.getItems().removeAll(items);
						items.clear();
						items.addAll(dataArr2);
						round = 2;
						image1.setItems(items);
						anteBet.setText("$0");
						ppBet.setText("$0");
						bottomInfo.getChildren().remove(0);
						bottomInfo.getChildren().add(0, p2);
						prompt.setText("PLAYER 2, PLACE YOUR BETS BETWEEN $5 AND $25");
					}
					else{
						prompt.setText("YOUR BET MUST BE BETWEEN $5 TO $25. PLEASE TRY AGAIN");
					}
				}
			}
			else if(round == 2 && (!anteBet.getText().trim().isEmpty() && !ppBet.getText().trim().isEmpty())){

				/*
				try{
					int anteBetNum = Integer.parseInt(anteBet.getText());
					int ppBetNum = Integer.parseInt(ppBet.getText());
					if ((anteBetNum >= 5 && anteBetNum <= 25) &&
							((ppBetNum >= 5 && ppBetNum <= 25) || ppBetNum == 0)) {

						playerTwo.setAnteBet(anteBetNum);
						playerTwo.setPairPlusBet(ppBetNum);
						turn = 3;
						anteBet.setText("$0");
						ppBet.setText("$0");
						bottomInfo.getChildren().remove(0);
						bottomInfo.getChildren().add(0, p1);
						prompt.setText("PLAYER 1, PRESS PLAY TO CONTINUE");
					}
					else{
						prompt.setText("YOUR BET MUST BE BETWEEN $5 TO $25. PLEASE TRY AGAIN");
					}
				}
				catch(NumberFormatException ex){
					prompt.setText("YOUR BET MUST BE BETWEEN $5 TO $25. PLEASE TRY AGAIN");
				}*/

				int anteCompare = Integer.parseInt(anteBet.getText());
				int playBetCompare = Integer.parseInt(ppBet.getText());
				if((anteCompare >= 5 && anteCompare <= 25) &&
						((playBetCompare >= 5 && playBetCompare <= 25) || playBetCompare == 0)){

					pressHelper(anteCompare, playBetCompare);
					foldMakeUp();
				}
				else{
					prompt.setText("REMEMBER: YOUR BET MUST BE WITHIN $5 TO $25.\n");
				}
			}
		});

		playButton.setOnAction(e -> {
			if(round == 3){
				if(!playCards.getText().trim().isEmpty()){
					int playBetNum = Integer.parseInt(playCards.getText());

					try{
						if(playBetNum != playerOne.getAnteBet()){
							throw new Exception("YOUR PLAY BET MUST BE EQUAL TO YOUR ANTE BET");
						}
						else{
							driver(playBetNum, 3);
							playFoldprompt.setText("PLEASE, PLACE YOUR BET BETWEEN $5 TO $25");
						}

					}catch(Exception ex){
						playFoldprompt.setText(ex.getMessage());
					}
				}
			}
			else if (round == 4){
				if(!playCards.getText().trim().isEmpty()){
					int playBetNum = Integer.parseInt(playCards.getText());
					try{
						if(playBetNum != playerTwo.getAnteBet()){
							throw new Exception();
						}
						else{
							driver(playBetNum, 4);
						}
					}catch(Exception ex){
						playFoldprompt.setText("REMEMBER: PLAY BET MUST BE THE SAME AS ANTE BET.\n");
					}
				}
			}
		});

		foldButton.setOnAction(e -> {
			if(round == 3){
				foldEngine(3);
				playFoldprompt.setText("Place a bet between $5 to $25 or fold.");
			}
			else if(round == 4){
				foldEngine(4);
			}
		});
	}

	//Helper function to set up the first scene
	private void sceneSetup(HBox mBar){
		items = FXCollections.observableArrayList();
		ArrayList<String> data = database();
		items.addAll(data);

		image1 = new ListView<String>();
		image1.setItems(items);
		image1.setPrefWidth(150);
		image1.setPrefHeight(350);
		VBox stat = new VBox(image1);

		//Game starts here for Part 1
		//This helps setup card deck in corner
		card_back = new Image("cardBack2.png");
		cardCover = new ImageView(card_back);
		cardCover.setFitHeight(175);
		cardCover.setFitWidth(155);
		cardCover.setPreserveRatio(true);
		HBox cardDisplay = new HBox(cardCover);
		cardDisplay.setPadding(new Insets(15, 100, 75, 25));
		HBox topBox = new HBox(stat, cardDisplay);
		VBox overallTop = new VBox(mBar, topBox);

		//This sets up the part on bottom for player to input bets
		VBox anteBox = new VBox(14, anteLabel, anteBet);
		VBox ppBox = new VBox(24, ppBet, pairPlus);
		ppBox.setEffect(new DropShadow(15, Color.BLACK));
		VBox txtBox = new VBox(anteBox, ppBox);
		bottomInfo = new HBox(21, p1, txtBox, pressButton);
		playerCardBox = new HBox();
		bottomInfo.setAlignment(Pos.CENTER);
	}
	private void executor(ArrayList<String> dataArr2){

		showAllCards();
		playerCardBox = new HBox(200, box2, box1);
		playerCardBox.setAlignment(Pos.CENTER);
		playerCardBox.setPadding(new Insets(200, 0, 0, 0));
		allCardsBox = new VBox(dealerCardBox, playerCardBox);
		allCardsBox.setAlignment(Pos.CENTER);
		core.setCenter(allCardsBox);
		gameBrain();

		dataArr2 = database();
		image1.getItems().removeAll(items);
		items.clear();

		for(String s : dataArr2){
			items.add(s);
		}

		image1.setItems(items);
		finalHBox.setAlignment(Pos.CENTER);
		core.setBottom(finalHBox);
	}
	private void boxBuilder(){

		openHandSecond();
		bottomPlayFoldBox.getChildren().remove(0);
		bottomPlayFoldBox.getChildren().add(0, p2);

		playerCardBox = new HBox(200, box2, box1);
		playerCardBox.setAlignment(Pos.CENTER);
		playerCardBox.setPadding(new Insets(200, 0, 0, 0));

		allCardsBox = new VBox(dealerCardBox, playerCardBox);
		allCardsBox.setAlignment(Pos.CENTER);
		core.setCenter(allCardsBox);
	}

	//Helper function to set up the second scene
	private void driver(int playBetNum, int choice){

		playerTwo.setPlayBet(playBetNum);

		ArrayList<String> dataArr2 = database();
		image1.getItems().removeAll(items);
		items.clear();
		for(String s : dataArr2){
			items.add(s);
		}
		image1.setItems(items);

		if(choice == 3){
			round = 4;
			boxBuilder();
		}
		if(choice == 4){
			round = 5;
			executor(dataArr2);
		}
		if(choice == 5){
			round = choice;
		}

		playCards.setText("0");
	}
	private void foldStarter(){
		playerTwo.setDidFold(true);
		playCards.setText("0");

		bottomPlayFoldBox.getChildren().remove(0);
		bottomPlayFoldBox.getChildren().add(0, p2);
		showAllCards();


		playerCardBox = new HBox(200, box2, box1);
		playerCardBox.setAlignment(Pos.CENTER);
		playerCardBox.setPadding(new Insets(200, 0, 0, 0));
		allCardsBox = new VBox(dealerCardBox, playerCardBox);
		allCardsBox.setAlignment(Pos.CENTER);
		core.setCenter(allCardsBox);

		//Load the game's engine
		gameBrain();
	}
	private void boxFolder(){

		playerOne.setDidFold(true);
		playCards.setText("0");
		bottomPlayFoldBox.getChildren().remove(0);
		bottomPlayFoldBox.getChildren().add(0, p2);
		openHandSecond();
		//playerCardBox = new HBox(200, box2, p1Box);
		//playerCardBox.setAlignment(Pos.CENTER);
		//playerCardBox.setPadding(new Insets(200, 0, 0, 0));

		allCardsBox = new VBox(dealerCardBox, playerCardBox);
		allCardsBox.setAlignment(Pos.CENTER);
		core.setCenter(allCardsBox);

		playerCardBox = new HBox(100, box2, box1);
		playerCardBox.setAlignment(Pos.CENTER);
		playerCardBox.setPadding(new Insets(150, 0, 0, 0));
	}
	private void boxFolder2(){

		boolean engine = true;

		do{
			foldStarter();
			ArrayList<String> dataArr2 = database();
			image1.getItems().removeAll(items);
			items.clear();

			for(String element : dataArr2){
				items.add(element);
			}
			image1.setItems(items);
			finalHBox.setAlignment(Pos.CENTER);
			core.setBottom(finalHBox);
			engine = false;

		}while(engine != false);
	}
	private void foldEngine(int choice){

		try{
			if(choice != 3){
				throw new Exception("Invalid choice!");
			}
			if(choice != 4){
				throw new Exception("Invalid choice!");
			}

		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		if(choice == 3){
			round = 4;
			boxFolder();
		}
		if(choice == 4){
			round = 5;
			boxFolder2();
		}
	}
	public Scene playGameScene() {

		//Labels for players
		p1 = new Label("PLAYER 1");
		p2 = new Label("PLAYER 2");

		//Sets up the scene for the game
		prompt = new Label("PLACE YOUR BETS BETWEEN $5 AND $25");
		prompt.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #5bf57f;");

		//Text field for the prompt
		TextField newTxt = new TextField();
		newTxt.setPromptText("PLACE A BET FROM $5 TO $25 FOR ANTE AND PAIR PLUS");
		newTxt.setStyle("-fx-font-size: 25;" + "-fx-text-fill: red;");
		newTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		newTxt.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		newTxt.setOpacity(0.5);
		newTxt.setMinWidth(75);
		newTxt.setAlignment(Pos.CENTER);
		newTxt.setPadding(new Insets(0, 0, 0, 0));
		newTxt.setVisible(false);

		Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35);
		prompt.setFont(font);
		prompt.setStyle("-fx-text-fill: #d9c014;" + "-fx-font-size: 35");

		TextArea chatWindow = new TextArea();
		chatWindow.setMinWidth(300);
		chatWindow.setMinHeight(300);
		chatWindow.setEditable(false);
		chatWindow.setStyle("-fx-font-size: 25;" + "-fx-text-fill: #5bf57f;");
		chatWindow.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		chatWindow.setPadding(new Insets(0, 0, 0, 0));
		chatWindow.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		chatWindow.setOpacity(0.5);

		//Contact us button
		Button contactUs = new Button("CONTACT US");
		contactUs.setStyle("-fx-font-size: 20;" + "-fx-text-fill: #5bf57f;");
		contactUs.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		contactUs.setPadding(new Insets(0, 0, 5, 5));
		contactUs.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		contactUs.setOpacity(0.75);

		prompt.setOpacity(0.45);
		prompt.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		prompt.setAlignment(Pos.TOP_CENTER);
		prompt.setPadding(new Insets(50));
		prompt.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 35));

		StackPane popUp = new StackPane();
		popUp.getChildren().addAll(prompt);
		popUp.setAlignment(Pos.CENTER);
		popUp.setPadding(new Insets(0, 0, 0, 0));

		//Displays a pop-up alert
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Three Card Poker");
		alert.setHeaderText("Three Card Poker");
		alert.setContentText(prompt.getText());
		alert.showAndWait();

		StackPane promptFrame = new StackPane();
		promptFrame.getChildren().add(prompt);
		promptFrame.setStyle("-fx-background-color: #000000;");
		promptFrame.setPadding(new Insets(50));
		promptFrame.setPrefSize(500, 100);
		promptFrame.setOnMouseClicked(e -> {
			//if the player clicks on the prompt, then the text field will be focused
			newTxt.requestFocus();
		});

		//Hide the menu
		menubar.setVisible(false);

		//Other labels => ante-bet, bet => set both to 0
		anteLabel = new Label("ANTE BET");
		pairPlus = new Label("PAIR PLUS BET");
		anteBet = new TextField("$0");
		anteBet.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
		ppBet = new TextField("$0");
		ppBet.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
		ppBet.setMinHeight(45);

		pressButton = new Button("BEGIN");
		labelForPlayCards = new Label("YOUR BET");
		ToggleButton PLAYBET = new ToggleButton("PLACE YOUR BETS");

		foldButton = new Button("FOLD");
		foldButton.setMinSize(150, 50);
		playButton = new Button("PLAY");
		playAgain = new Button("PLAY AGAIN");
		quitGame = new Button("QUIT");
		quitGame.setMinSize(150, 50);
		quitGame.setStyle("-fx-background-color: #ff0000;" + "-fx-text-fill: #ffffff;");

		core = new BorderPane();
		menubar = new MenuBar();
		menu = new Menu("OPTIONS");
		menu.setText("OPTIONS");
		items = FXCollections.observableArrayList();
		ArrayList<String> data = database();
		items.addAll(data);

		menu.setMnemonicParsing(true);
		menu.setStyle("-fx-font-size: 25;");
		menu.setStyle("-fx-background-color: #000000;" + "-fx-text-fill: #ffffff;");
		EXIT = new MenuItem("EXIT");
		FreshStart = new MenuItem("FRESH START");
		NewLook = new MenuItem("NEW LOOK");

		//Collect all items in one place
		menu.getItems().addAll(EXIT, FreshStart, NewLook);
		menubar.getMenus().add(menu);
		menubar.setMinSize(150, 50);
		HBox mBar = new HBox(menubar);

		if(option == 0){
			//Activate the first look + set up the elements
			builderOne();
		}
		else if (option == 1){
			//Activate the second look + set up the elements
			builderTwo();
		}

		image1 = new ListView<String>();
		image1.setItems(items);
		image1.setPrefWidth(150);
		image1.setPrefHeight(350);
		VBox stat = new VBox(image1);
		card_back = new Image("cardBack2.png");
		cardCover = new ImageView(card_back);
		cardCover.setFitHeight(175);
		cardCover.setFitWidth(155);
		cardCover.setPreserveRatio(true);
		HBox cardDisplay = new HBox(cardCover);
		cardDisplay.setPadding(new Insets(15, 100, 75, 25));
		HBox topBox = new HBox(stat, cardDisplay);
		VBox overallTop = new VBox(mBar, topBox);
		VBox anteBox = new VBox(14, anteLabel, anteBet);
		VBox ppBox = new VBox(24, ppBet, pairPlus);
		ppBox.setEffect(new DropShadow(15, Color.BLACK));
		VBox txtBox = new VBox(anteBox, ppBox);
		bottomInfo = new HBox(21, p1, txtBox, pressButton);
		playerCardBox = new HBox();
		bottomInfo.setAlignment(Pos.CENTER);

		//Allows to activate the majority of implemented methods
		engine(newTxt, contactUs, chatWindow, alert);

		Rectangle rect = new Rectangle(100, 40, 100, 100);
		rect.setArcHeight(50);
		rect.setArcWidth(50);
		rect.setFill(Color.VIOLET);

		RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
		rt.setByAngle(270);
		rt.setCycleCount(4);
		rt.setAutoReverse(true);
		SequentialTransition seqTransition = new SequentialTransition(
				new PauseTransition(Duration.millis(500)),
				rt
		);
		seqTransition.play();

		FadeTransition ft = new FadeTransition(Duration.millis(5000), rect);
		ft.setFromValue(1.0);
		ft.setToValue(0.3);
		ft.setCycleCount(4);
		ft.setAutoReverse(true);

		ft.play();

		core.setTop(overallTop);
		core.setCenter(prompt);
		core.setBottom(bottomInfo);
		core.setLeft(stat);
		core.setRight(cardDisplay);
		core.setPadding(new Insets(0, 0, 75, 0));

		return new Scene(core, 1350, 750);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Welcome to Project 2!");
		//Initialize dealer and both players => DONE
		dealerObject = new Dealer();
		playerOne = new Player();
		playerTwo = new Player();
		stage = primaryStage;

		Rectangle rect = new Rectangle(100, 40, 100, 100);
		rect.setArcHeight(50);
		rect.setArcWidth(50);
		rect.setFill(Color.VIOLET);

		RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
		rt.setByAngle(270);
		rt.setCycleCount(4);
		rt.setAutoReverse(true);
		SequentialTransition seqTransition = new SequentialTransition(
				new PauseTransition(Duration.millis(500)),
				rt
		);
		seqTransition.play();

		FadeTransition ft = new FadeTransition(Duration.millis(5000), rect);
		ft.setFromValue(1.0);
		ft.setToValue(0.3);
		ft.setCycleCount(4);
		ft.setAutoReverse(true);

		ft.play();
		BorderPane root = new BorderPane();
		root.setCenter(rect);

		Scene scene = new Scene(root, 700, 700);
		//primaryStage.setScene(scene);
		primaryStage.setScene(StartScene());
		primaryStage.show();
	}
}

