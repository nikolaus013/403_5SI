package repository;

import com.google.gson.JsonArray;
import connection.DatabaseConnection;

import java.util.ArrayList;

public class DatabaseRepository implements Repository{

    @Override
    public ArrayList<String> fillTree() {
        DatabaseConnection connection = new DatabaseConnection();

        return null;
    }

    @Override
    public JsonArray fillTable(String tableName) {
        return null;
    }



}
