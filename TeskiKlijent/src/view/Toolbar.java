package view;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import controller.ToolbarController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Toolbar extends HBox {

    private final Button addButton = new Button("Add");
    private final Button deleteButton = new Button("Delete");
    private final Button refreshButton = new Button("Refresh");

    private ArrayList<TextField> inputFields = new ArrayList<>();

    public Toolbar(ToolbarController controller) {
        addButton.setOnAction(controller);
        deleteButton.setOnAction(controller);
        refreshButton.setOnAction(controller);

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);
        this.getChildren().addAll(inputFields);
        this.getChildren().addAll(addButton, deleteButton, refreshButton);
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public ArrayList<TextField> getInputFields() {
        return inputFields;
    }

    public void setInputFields(ArrayList<TextField> inputFields) {
        this.inputFields = inputFields;
    }
}
