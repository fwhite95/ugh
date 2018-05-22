package finalProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class DisplayInformationPane extends BorderPane {

    HBox displayBox = new HBox(10);
    Button back = new Button("Back");
    Button displayAll = new Button("Display All");
    ComboBox<String> informationChoices = new ComboBox<>();
    HBox backBox = new HBox(10);
    HBox centerBox = new HBox(10);
    Button search = new Button("Search");
    TextField searchBar = new TextField();

    DisplayInformationPane(Scene scene) {

        displayBox.setPadding(new Insets(10, 10, 10, 10));
        displayBox.setAlignment(Pos.CENTER);

        // Pane creations

        // Display Selection
        backBox.setAlignment(Pos.CENTER_LEFT);
        backBox.getChildren().add(back);

        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(displayAll, informationChoices);

        informationChoices.getItems().addAll("objectId", "xLocation", "yLocation", "facilityType",
                "facilityName", "address", "city", "zipCode", "localDesignation", "countyDesignation");
        displayBox.getChildren().addAll(backBox, centerBox, searchBar, search);

        this.setTop(displayBox);
        this.setAlignment(displayBox, Pos.CENTER);


        this.setCenter(new ScrollPane(new InformationPane()));
        // **********Information Display All************

        displayAll.setOnAction(e -> {
            this.setCenter(new ScrollPane(new InformationPane()));

        });

        // *********Information display selection list


        search.setOnAction(ex -> {
            this.setCenter(new ScrollPane(new InformationPane(informationChoices.getValue(), searchBar.getText())));
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
