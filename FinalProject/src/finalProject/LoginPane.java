package finalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginPane extends BorderPane {

	TextField username = new TextField();
	PasswordField password = new PasswordField();
	Button login = new Button("Login");
	Button createAcc = new Button("Create Account");
	Button back = new Button("Back");

	LoginPane(Scene scene) throws SQLException, ClassNotFoundException{

		Label usernameLabel = new Label("Username");
		Label passwordLabel = new Label("Password");

		VBox userPassBox = new VBox(10);
		VBox labelBox = new VBox(10);
		HBox vboxHold = new HBox(10);
		userPassBox.setAlignment(Pos.CENTER_LEFT);

		userPassBox.getChildren().addAll(username, password);
		labelBox.setAlignment(Pos.CENTER_LEFT);
		labelBox.getChildren().addAll(usernameLabel, passwordLabel);
		usernameLabel.setLabelFor(username);
		usernameLabel.setAlignment(Pos.CENTER_LEFT);
		passwordLabel.setLabelFor(password);

		vboxHold.setAlignment(Pos.CENTER);
		vboxHold.getChildren().addAll(labelBox, userPassBox);


		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(vboxHold, login, createAcc, back);

		this.setCenter(root);


		//Login button action
			login.setOnAction(e -> {

				try {

					//scene.setRoot(new StartSelectionPane());
					//Connect to Database
					Connection infoConnect = StartSelectionPane.getConnection();

					Statement statement = infoConnect.createStatement();

					//Get column title info
					String queryColTitles = "SELECT userName, userPass FROM user";
					ResultSet rs = statement.executeQuery(queryColTitles);

					while(rs.next()){
						System.out.println(rs.getString(1) + " " + rs.getString(2));
						System.out.println(username.getText() + " " + password.getText());

						//Checks username and password
						if(username.getText().equals(rs.getString(1)) &&  password.getText().equals(rs.getString(2))){
							Driver.adminLogin = true;
							scene.setRoot(new StartSelectionPane(scene));
							System.out.println("Working!");

						}

					}


			}catch (Exception ex){
					ex.printStackTrace();

				}
			}
			);



			createAcc.setOnAction(e ->{
				scene.setRoot(new CreateAccountPane(scene));
			});

		back.setOnAction(e->{
			try {
				scene.setRoot(new StartSelectionPane(scene));
			}catch (Exception ex){
				ex.printStackTrace();
			}
		});

	}
}
