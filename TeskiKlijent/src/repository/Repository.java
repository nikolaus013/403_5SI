package repository;

import com.google.gson.JsonArray;

import java.util.ArrayList;

public interface Repository {

    ArrayList<String> fillTree();

    JsonArray fillTable(String tableName);



}
