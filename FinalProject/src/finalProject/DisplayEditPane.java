package finalProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

public class DisplayEditPane extends BorderPane{

    HBox btnBox = new HBox(10);
    Button display = new Button("Display");
    Button save = new Button("Save");
    //Boolean edit = true;
    //EditPane ePane = new EditPane();
    Button back = new Button("Back");

    DisplayEditPane(Scene scene){
        btnBox.setPadding(new Insets(10, 10, 10, 10));
        btnBox.setAlignment(Pos.CENTER);
        btnBox.getChildren().addAll(back, display, save);

        this.setTop(btnBox);
        this.setCenter(new ScrollPane(new EditPane()));

        display.setOnAction(e ->{
            this.setCenter(new ScrollPane(new EditPane()));
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
