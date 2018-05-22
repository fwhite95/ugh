package finalProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javax.sound.sampled.Line;

public class InformationPane extends GridPane implements Titles {


    // Display all
    public InformationPane() {
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
                Label label = new Label();
                label.setText(" " + rs.getString(i) + " ");

                this.add(label, col, row);
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

                    for (col = 0; col < colNum; col++) {
                        Text text = new Text();

                        text.setText(" " + rsFacilityInfo.getString(col + 1) + " ");
                        this.add(text, col, row);

                    }
                row++;

                }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public InformationPane(String columnTitle, String search){
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
                Label label = new Label();
                label.setText(" " + rs.getString(i) + " ");

                this.add(label, col, row);
                col++;
            }

            //Fill GridPane
            /*
            System.out.println("SELECT *"
                    + "FROM Facility "
                    + "WHERE " + columnTitle + " LIKE " + "'%" + search +"%'");
             */

            String querySearchInfo = "SELECT *"
                    + "FROM Facility "
                    + "WHERE " + columnTitle + " LIKE " + "'%" + search +"%'";





//get data to fill gridpane
            ResultSet rsFacilityInfo = statement.executeQuery(querySearchInfo);
            ResultSetMetaData rsmd = rsFacilityInfo.getMetaData();
            int colNum = rsmd.getColumnCount();



            row = 1;
            while (rsFacilityInfo.next()) {

                for (col = 0; col < colNum; col++) {
                    Text text = new Text();

                    text.setText(" " + rsFacilityInfo.getString(col + 1) + " ");
                    this.add(text, col, row);

                }
                row++;

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}

