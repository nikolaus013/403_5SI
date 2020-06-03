package repository;

import com.google.gson.*;
import connection.Connection;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlToJson {

    Connection database;

    public SqlToJson(Connection database) {
        this.database = database;
    }

    public ResultSet retrieveData(String tableName) {
        ResultSet rs = null;

//        rs = database.selectAllFrom(tableName);

        return rs;
    }


    public void MakeFile(String tableName) throws Exception {
//        //Creating a JSONObject object
//        JsonObject jsonObject = new JsonObject();
//        //Creating a json array
//        JsonArray array = new JsonArray();
//        ResultSet rs = retrieveData(tableName);
//        ArrayList<String> attributes = database.getTableColumns(tableName);
//
//        //ubacujemo array kolona kao json elemenat
//        JsonArray columns = new JsonArray();
//        for (String s : attributes) {
//            JsonPrimitive element = new JsonPrimitive(s);
//            columns.add(element);
//        }
//
//        JsonObject o = new JsonObject();
//        o.add("columns", columns);
//        array.add(o);
//
//        //Inserting ResultSet data into the json object
//        while(rs.next()) {
//            JsonObject record = new JsonObject();
//
//            for (String a : attributes) {
//                record.addProperty(a, rs.getString(a));
//            }
//            array.add(record);
//        }
//        jsonObject.add(tableName, array);
//        Gson gson = new Gson();
//        try {
//            FileWriter file = new FileWriter("C:\\Users\\kriscreates\\IdeaProjects\\TeskiKlijent\\src\\files\\output.txt");
//            gson.toJson(array, file);
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("JSON file created......");
    }
}
