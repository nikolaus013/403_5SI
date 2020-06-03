package view;

import app.AppCore;
import controller.TreeController;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayList;

public class Tree extends TreeView {

    TreeItem<String> root = new TreeItem<>();
    //ArrayList<String> list = AppCore.getTableNames();

    public Tree(TreeController controller) {


//        for (int i = 0; i < list.size(); i++) {
//            makeBranch(list.get(i), root);
//        }

        this.setRoot(root);
        this.setShowRoot(false);
        this.getSelectionModel().selectedItemProperty().addListener(controller);
    }

    public TreeItem makeBranch(String name, TreeItem parent) {
        TreeItem item = new TreeItem(name);
        parent.getChildren().add(item);
        return item;
    }
}
