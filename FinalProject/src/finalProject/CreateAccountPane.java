package finalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class CreateAccountPane extends BorderPane {

    Button back = new Button("Back");
    Button enter = new Button("Enter");
    TextField enterUser = new TextField();
    TextField enterPassword = new TextField();

    CreateAccountPane(Scene scene){

        Label usernameLabel = new Label("Enter username");
        Label passwordLabel = new Label("Enter password");

        VBox userPassBox = new VBox(10);
        VBox labelBox = new VBox(10);
        HBox vboxHold = new HBox(10);
        userPassBox.setAlignment(Pos.CENTER_LEFT);

        userPassBox.getChildren().addAll(enterUser, enterPassword);
        labelBox.setAlignment(Pos.CENTER_LEFT);
        labelBox.getChildren().addAll(usernameLabel, passwordLabel);
        usernameLabel.setLabelFor(enterUser);
        usernameLabel.setAlignment(Pos.CENTER_LEFT);
        passwordLabel.setLabelFor(enterPassword);

        vboxHold.setAlignment(Pos.CENTER);
        vboxHold.getChildren().addAll(labelBox, userPassBox);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vboxHold, back, enter);

        this.setCenter(root);

        back.setOnAction(e->{
            try {
                scene.setRoot(new StartSelectionPane(scene));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        enter.setOnAction(e->{

            try {
                Connection infoConnect = StartSelectionPane.getConnection();
                String query = " insert into user (userName, userPass, userId)"
                        + " values (?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = infoConnect.prepareStatement(query);
                preparedStmt.setString(1, enterUser.getText());
                preparedStmt.setString(2, enterPassword.getText());
                Driver.userId+= 1;
                preparedStmt.setInt(3, Driver.userId );


                // execute the preparedstatement
                preparedStmt.execute();
                scene.setRoot(new StartSelectionPane(scene));

            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        });

    }
}
