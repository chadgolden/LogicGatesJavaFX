package com.chadgolden.app;

import com.chadgolden.truthtables.TruthTable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.*;

/**
 * Controller class for the JavaFX GUI logic.
 */
public class Controller implements Initializable {

    @FXML
    private MenuItem menuItemClose;

    @FXML
    private ChoiceBox<String> logicChoiceBox;

    @FXML
    private TableView<String[]> truthTableView;

    /**
     * Populates the ChoiceBox with options.
     * @param fxmlFileLocation
     * @param resourceBundle
     */
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resourceBundle) {
        logicChoiceBox.getItems().addAll("Not", "Or", "Xor", "And", "Half-Adder", "Full-Adder");
        clearColumns();
    }

    @FXML
    private void exitApplication() {
        System.out.println("User is exiting...");
        System.exit(0);
    }

    /**
     * Displays the truth table for the selected logic option.
     */
    @FXML
    private void displayTruthTable() {
        if (logicChoiceBox.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        clearColumns();
        fillTableView();
    }

    /**
     * Clears the TableView of data.
     */
    @FXML
    private void clearColumns() {
        truthTableView.getColumns().remove(0, truthTableView.getColumns().size());
    }

    /**
     * Fill the TableView grid with the 2D array getTruthTable
     * from com.chadgolden.truthtables.TruthTable.
     */
    @FXML
    private void fillTableView() {
        TruthTable truthTable = new TruthTable(logicChoiceBox.getSelectionModel().getSelectedItem());
        //TableColumn[] columns = new TableColumn[truthTable.getTruthTable()[0].length];

        String[][] truthTableData = truthTable.getTruthTable();
        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(truthTableData));
        data.remove(0);

        for (int i = 0; i < truthTableData[0].length; i++) {
            TableColumn tableColumn = new TableColumn(truthTableData[0][i]);
            final int columnNumber = i;
            tableColumn.setCellValueFactory(
                    new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> property) {
                    return new SimpleStringProperty((property.getValue()[columnNumber]));
                }
            });
            truthTableView.getColumns().add(tableColumn);
        }
        truthTableView.setItems(data);
    }

}
