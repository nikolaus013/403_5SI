package vu.che.mvcrest.repository;

import java.sql.*;
import java.util.ArrayList;

public class Repository {

    private static String url = "jdbc:mysql://64.225.110.65:3306/tim_403_5_si2019";
    private static String user = "tim_403_5_si2019", pass = "LDCUMAKG";

    private static java.sql.Connection connection;
    private static DatabaseMetaData metaData;
    private static Statement statement;

    static {
        Connect();
    }

    public static void Connect() {
        try {
            System.out.println("Connecting to " + url);

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user, pass);
            metaData = connection.getMetaData();
            statement = connection.createStatement();

            System.out.println("Connected..\n");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error connecting -->" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getTableNames() {

        ArrayList<String> list = new ArrayList<>();

        try {
            ResultSet resultSet = metaData.getTables(null,null,null, new String[]{"TABLE"});

            while(resultSet.next())
            {
                list.add(resultSet.getString("TABLE_NAME"));
            }
        } catch (SQLException e){
            System.out.println("Error -->" + e.getMessage());
        }

        return list;
    }

    public static ArrayList<String> getTableColumns(String tableName) {
        ResultSet resultSet = null;
        ArrayList<String> columns = new ArrayList<>();
        try {
            resultSet = metaData.getColumns(null, null, tableName, null);

            while (resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                columns.add(columnName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return columns;
    }

    public static ResultSet selectAllFrom(String tableName) {
        String query = "SELECT * FROM " + tableName;
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  resultSet;
    }





}
