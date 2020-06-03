package repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import connection.Connection;
import connection.ServiceConnection;

import java.util.ArrayList;

public class ServiceRepository implements Repository{

    private Connection connection;

    public ServiceRepository() {
        connection = new ServiceConnection();
    }

    @Override
    public ArrayList<String> fillTree() {
        Gson gson = new Gson();
        ArrayList<String> list;

        connection.Connect();
        String response = connection.getTableNames();

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(response).getAsJsonArray();

        list = gson.fromJson(array, ArrayList.class);

        return list;
    }

    @Override
    public JsonArray fillTable(String tableName) {
        Gson gson = new Gson();
        ArrayList<String> list;

        String response = connection.getTableData(tableName);

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(response).getAsJsonArray();

        return array;
    }


}
