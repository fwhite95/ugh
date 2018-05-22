package finalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.sql.*;
import java.util.ArrayList;

public class EditPane extends GridPane implements Titles {

   public static TableView tableView = new TableView();
   public static ObservableList ov = FXCollections.observableArrayList();
    //TABLE VIEW AND DATA


    EditPane() {

        //GUI Design
        this.setPadding(new Insets(15, 15, 15, 15));
        this.setAlignment(Pos.CENTER);
        this.setGridLinesVisible(true);


        try {
            //Connect to Database
            Connection infoConnect = StartSelectionPane.getConnection();

            Statement statement = infoConnect.createStatement();

            //Get column title info
            String queryColTitles = "SHOW COLUMNS FROM javabook.facility";
            ResultSet rs = statement.executeQuery(queryColTitles);

            int i = 1;
            int row = 0;
            int col = 0;

            //Set column titles

            while (rs.next()) {
                TextField textField = new TextField();
                textField.setText(" " + rs.getString(i) + " ");
                //Building tableView
               // TableColumn tableColumn = new TableColumn(rs.getString(i));
               // tableView.getColumns().add(tableColumn);

                //Textfield listener


                this.add(textField, col, row);


                col++;
            }



            //Fill GridPane
            String queryFacilityInfo = "SELECT *"
                    + "FROM Facility";

//get data to fill gridpane
            ResultSet rsFacilityInfo = statement.executeQuery(queryFacilityInfo);
            ResultSetMetaData rsmd = rsFacilityInfo.getMetaData();
            int colNum = rsmd.getColumnCount();

            row = 1;
            while (rsFacilityInfo.next()) {

                ArrayList<String> arrayList = new ArrayList<>();
                for (col = 0; col < colNum; col++) {
                    TextField textField = new TextField();

                    textField.setText(" " + rsFacilityInfo.getString(col + 1) + " ");




                    this.add(textField, col, row);

                }
                //ov.add(arrayList);
                row++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
        for(int i = 0; i < tableView.getColumns().size(); i++){

            ((TableColumn) tableView.getColumns().get(i)).setCellValueFactory(
                    new PropertyValueFactory<ArrayList<String>, String>(tableView.getColumns().get(i).toString())
            );
        }

        tableView.setItems(ov);

*/
    }


}
