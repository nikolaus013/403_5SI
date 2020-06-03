package vu.che.mvcrest.repository;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Service {

    public ArrayList<String> getTableNames() { return Repository.getTableNames(); }

    public static String getTable(String tableName) {
        JsonArray array = new JsonArray();

        ArrayList<String> columns = Repository.getTableColumns(tableName);
        JsonArray columnsJson = new JsonArray();
        for (String s : columns) {
            JsonPrimitive element = new JsonPrimitive(s);
            columnsJson.add(element);
        }
        JsonObject object = new JsonObject();
        object.add("columns", columnsJson);
        array.add(object);

        ResultSet resultSet = Repository.selectAllFrom(tableName);
        while (true) {
            try {
                if (!resultSet.next()) break;
                JsonObject record = new JsonObject();

                for (String s : columns) {
                    record.addProperty(s, resultSet.getString(s));
                }
                array.add(record);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return array.toString();
    }

    public static void addToTable(String tableName) {

    }

}
