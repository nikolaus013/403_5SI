package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.Toolbar;

public class ToolbarController implements EventHandler {

    private final Stage primaryStage;
    private final Toolbar view = new Toolbar(this);

    public ToolbarController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(Event event) {
        final Object source = event.getSource();

        if (source.equals(view.getAddButton())) {
            System.out.println("Add button clicked");
        }

        else if (source.equals(view.getDeleteButton())) {
            System.out.println("Delete button clicked");
        }

        else if (source.equals(view.getRefreshButton())) {
            System.out.println("Refresh button clicked");
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Toolbar getView() {
        return view;
    }
}
