package finalProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StartSelectionPane extends BorderPane {

	Button displayInformation = new Button("Display Information");
	Button editInformation = new Button("Edit Information");
	Button login = new Button("Login");
	Text title = new Text("EV Charging Database");
	Button graphs = new Button ("Graphs");
	Button maps = new Button("Maps");
	Button createAccount = new Button("Create Account");

	public StartSelectionPane(Scene scene) throws SQLException, ClassNotFoundException{
		VBox holdsBtnBox = new VBox(10);
		holdsBtnBox.setAlignment(Pos.CENTER);
		HBox dataBtnBox = new HBox(10);

		//Lower buttons
		dataBtnBox.setPadding(new Insets(10, 10, 10, 10));
		dataBtnBox.getChildren().addAll(graphs, maps);
		dataBtnBox.setAlignment(Pos.CENTER);

		// Button box and button Creation
		HBox btnBox = new HBox(10);
		btnBox.setPadding(new Insets(10, 10, 10, 10));

		btnBox.getChildren().addAll(login, displayInformation, editInformation);
		btnBox.setAlignment(Pos.CENTER);

		//Add to vbox
		holdsBtnBox.getChildren().addAll(btnBox, dataBtnBox);
		this.setCenter(holdsBtnBox);
		BorderPane.setAlignment(holdsBtnBox, Pos.CENTER);
		
		//Title label
		title.setFont(new Font(50));
		this.setTop(title);
		BorderPane.setAlignment(title, Pos.TOP_CENTER);

		//Bottom Bar
		HBox bottomBar = new HBox(10);
		bottomBar.setPadding(new Insets(10, 10, 10, 10));
		bottomBar.setAlignment(Pos.CENTER);

		//Create Account btn

        HBox createAccountBtnBox = new HBox(10);
        createAccountBtnBox.setAlignment(Pos.BOTTOM_LEFT);
        createAccountBtnBox.getChildren().add(createAccount);
        bottomBar.getChildren().add(createAccountBtnBox);

		//Error text for database connection
		HBox textBox = new HBox(10);
        textBox.setPadding(new Insets(10, 10, 10, 10));
        Text text = new Text("Database Connection: ");
		Text ifConnected = new Text("Disconnected");
        textBox.setAlignment(Pos.BOTTOM_RIGHT);
		textBox.getChildren().addAll(text, ifConnected);
		ifConnected.setFill(Color.RED);


		bottomBar.getChildren().add(textBox);
		this.setBottom(bottomBar);

		try {
            Connection testConnection = getConnection();
            if(!testConnection.isClosed()){
                ifConnected.setText("Connected");
                ifConnected.setFill(Color.GREEN);
            }
        }catch (Exception e){
		    System.out.println("Error");
        }


        //Button actions
		getDisplayInformationBtn().setOnAction(e -> {
			scene.setRoot(new DisplayInformationPane(scene));
		});

		login.setOnAction(e ->{
			try {
				scene.setRoot(new LoginPane(scene));
			}catch(Exception e1){

			}

		});

		editInformation.setOnAction(e ->{
			scene.setRoot(new DisplayEditPane(scene));
		});

		createAccount.setOnAction(e ->{
			scene.setRoot(new CreateAccountPane(scene));
		});


    }

	public StartSelectionPane() throws SQLException, ClassNotFoundException{
		VBox holdsBtnBox = new VBox(10);
		holdsBtnBox.setAlignment(Pos.CENTER);
		HBox dataBtnBox = new HBox(10);

		//Lower buttons
		dataBtnBox.setPadding(new Insets(10, 10, 10, 10));
		dataBtnBox.getChildren().addAll(graphs, maps);
		dataBtnBox.setAlignment(Pos.CENTER);

		// Button box and button Creation
		HBox btnBox = new HBox(10);
		btnBox.setPadding(new Insets(10, 10, 10, 10));

		btnBox.getChildren().addAll(login, displayInformation, editInformation);
		btnBox.setAlignment(Pos.CENTER);

		//Add to vbox
		holdsBtnBox.getChildren().addAll(btnBox, dataBtnBox);
		this.setCenter(holdsBtnBox);
		BorderPane.setAlignment(holdsBtnBox, Pos.CENTER);

		//Title label
		title.setFont(new Font(50));
		this.setTop(title);
		BorderPane.setAlignment(title, Pos.TOP_CENTER);

		//Bottom Bar
		HBox bottomBar = new HBox(10);
		bottomBar.setPadding(new Insets(10, 10, 10, 10));
		bottomBar.setAlignment(Pos.CENTER);

		//Create Account btn
		Button createAccountBtn = new Button("Create Account");
		HBox createAccountBtnBox = new HBox(10);
		createAccountBtnBox.setAlignment(Pos.BOTTOM_LEFT);
		createAccountBtnBox.getChildren().add(createAccountBtn);
		bottomBar.getChildren().add(createAccountBtnBox);

		//Error text for database connection
		HBox textBox = new HBox(10);
		textBox.setPadding(new Insets(10, 10, 10, 10));
		Text text = new Text("Database Connection: ");
		Text ifConnected = new Text("Disconnected");
		textBox.setAlignment(Pos.BOTTOM_RIGHT);
		textBox.getChildren().addAll(text, ifConnected);
		ifConnected.setFill(Color.RED);


		bottomBar.getChildren().add(textBox);
		this.setBottom(bottomBar);

		try {
			Connection testConnection = getConnection();
			if(!testConnection.isClosed()){
				ifConnected.setText("Connected");
				ifConnected.setFill(Color.GREEN);
			}
		}catch (Exception e){
			System.out.println("Error");
		}



	}

	public  Button getDisplayInformationBtn() {
		return displayInformation;
	}

	public static Connection getConnection()throws SQLException, ClassNotFoundException{

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook",
                    "scott", "tiger");
        return connection;


    }

}
