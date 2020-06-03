package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;
import view.Tree;

public class TreeController implements ChangeListener {

    private final Stage primaryStage;
    private final Tree view = new Tree(this);
    private String selectedTable;

    public TreeController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Tree getView() {
        return view;
    }

    public String getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(String selectedTable) {
        this.selectedTable = selectedTable;
    }

    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        selectedTable =  observableValue.getValue().toString();
        TreeItem t = (TreeItem) observableValue.getValue();
        System.out.println(t.toString());
    }
}
