package view;

import com.google.gson.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import repository.Repository;
import repository.ServiceRepository;
import repository.DatabaseRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainFrame extends Application {

    TreeView<String> treeView;
    TableView<Map> tableMain;
    TableView<Map> tableRelation;
    String selectedTable = null;
    HBox hBox = new HBox();
    VBox vBox = new VBox();
    BorderPane borderPane = new BorderPane();
    ArrayList<TextField> textFields = new ArrayList<>();
    Button addButton = new Button("Add");
    Button deleteButton = new Button("Delete");
    Button refreshButton = new Button("Update");

    /*
    Za rad sa web servisom repository je tipa ServiceRepository
    Za direktan rad sa bazom repository ne je tipa DatabaseRepository
     */

    Repository repository = new ServiceRepository();
    //Repository repository = new DatabaseRepository();

    public MainFrame() { }

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("TURBO POWER DITRA-2020");
        primaryStage.setOnCloseRequest(e -> {
            System.out.println("*Program closed*");
        });

        //Tree
        TreeItem<String> root = new TreeItem<>();
        ArrayList<String> list = repository.fillTree();

        for (int i = 0; i < list.size(); i++) {
            makeBranch(list.get(i), root);
        }

        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if(newValue != null) {
                        selectedTable = newValue.getValue();
                        try {
                            clearTable();
                            makeTable();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

        addButton.setOnAction(e -> addRecord());
        deleteButton.setOnAction(e -> deleteRecord());

        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);

        tableMain = new TableView<>();
        tableRelation = new TableView<>();

        //Button
        refreshButton.setOnAction(actionEvent -> {
            System.out.println("*Button clicked*");
        });

        //vBox.getChildren().addAll(tableMain, tableRelation, new ToolbarController(primaryStage).getView());
        //borderPane.setLeft(new TreeController(primaryStage).getView());

        vBox.getChildren().addAll(tableMain, tableRelation, hBox);
        borderPane.setLeft(treeView);
        borderPane.setCenter(vBox);
        primaryStage.setScene(new Scene(borderPane, 1200, 750));
        primaryStage.show();
    }

    public TreeItem<String> makeBranch(String name, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(name);
        parent.getChildren().add(item);
        return item;
    }

    //Add button clicked
    public void addRecord() {
        System.out.println("ADD to table " + selectedTable);
        for (TextField field : textFields) {
            String key = field.getPromptText();
            String value = field.getText();
            System.out.println("   \"" + key + "\": \"" + value + "\"");
        }
    }

    //Delete button clicked
    public void deleteRecord() {
        ObservableList<Map> selected, all;
        all = tableMain.getItems();
        selected = tableMain.getSelectionModel().getSelectedItems();
        selected.forEach(all::remove);
    }

    private void makeInputFields(JsonArray columns) throws IOException {
        hBox.getChildren().clear();
        textFields.clear();
        for (JsonElement el : columns) {
            String columnName = el.getAsString();
            TextField field = new TextField();
            field.setPromptText(columnName);
            hBox.getChildren().add(field);
            textFields.add(field);
        }
        hBox.getChildren().addAll(addButton, deleteButton,refreshButton);
    }

    private void makeTable() throws IOException {
        Gson gson = new Gson();
        JsonArray array = repository.fillTable(selectedTable);
        JsonElement jsonElement = array.get(0);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray columns = jsonObject.getAsJsonArray("columns");

        for (JsonElement el : columns) {
            String columnName = el.getAsString();
            TableColumn column = new TableColumn(columnName);
            column.setCellValueFactory(new MapValueFactory<>(columnName));
            column.setMinWidth(140);
            column.setMaxWidth(200);
            tableMain.getColumns().add(column);
        }

        makeInputFields(columns);

        ObservableList<Map> rowMapsList = FXCollections.observableArrayList();
        for (int i = 1; i < array.size(); i++) {

            JsonElement element = array.get(i);
            Map<String,String> map = gson.fromJson(element, Map.class);

            //dodaj jedan red
            rowMapsList.add(map);
        }
        tableMain.setItems(rowMapsList);
        tableMain.refresh();
    }

    private void clearTable() {
        tableMain.getItems().clear();
        tableMain.getColumns().clear();
    }

//    private void makeTable() throws IOException {
//
//        Gson gson = new Gson();
//        Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\kriscreates\\IdeaProjects\\TeskiKlijent\\src\\files\\output.json"));
//
//        JsonParser parser = new JsonParser();
//        JsonArray array = parser.parse(reader).getAsJsonArray();
//
//        ObservableList<Map> rowMapsList = FXCollections.observableArrayList();
//
//        for (int i = 1; i < array.size(); i++) {
//
//            JsonElement element = array.get(i);
//            Map<String,String> map = gson.fromJson(element, Map.class);
//
//            //dodaj jedan red
//            rowMapsList.add(map);
//        }
//
//        tableMain.setItems(rowMapsList);
//        tableMain.refresh();
//    }

}
