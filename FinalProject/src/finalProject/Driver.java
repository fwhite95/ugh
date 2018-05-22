package finalProject;	

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Driver extends Application{

	public static boolean adminLogin = false;
	public static int userId = 1001;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage mainStage) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		

		StartSelectionPane pane = new StartSelectionPane();

		Scene scene = new Scene(pane, 900, 750);
		mainStage.setScene(scene);
		mainStage.setTitle("Welcome to the program!");
		mainStage.show();
		
		pane.getDisplayInformationBtn().setOnAction(e -> {
			scene.setRoot(new DisplayInformationPane(scene));
		});
		
		pane.login.setOnAction(e ->{
			try {
				scene.setRoot(new LoginPane(scene));
			}catch(Exception e1){

			}

		});

		pane.createAccount.setOnAction(e->{
			scene.setRoot(new CreateAccountPane(scene));
		});

		pane.editInformation.setOnAction(e ->{
			if(adminLogin) {
				scene.setRoot(new DisplayEditPane(scene));
			}
			else{
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Warning!");
				alert.setContentText("Must be logged in to edit");
				alert.showAndWait().ifPresent(rs -> {
					if (rs == ButtonType.OK) {
						System.out.println("Pressed OK.");
					}
				});
			}
		});


		
	}


	
	

}
