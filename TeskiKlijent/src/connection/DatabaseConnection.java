package connection;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection implements Connection {

    private java.sql.Connection connection;
    private DatabaseMetaData metaData;
    private Statement statement;

    private static String url = "jdbc:mysql://64.225.110.65:3306/tim_403_5_si2019";
    private static String user = "tim_403_5_si2019", pass = "LDCUMAKG";
    private static ArrayList<String> tableNames;

    @Override
    public void Connect() {
        try {
            System.out.println("Connecting to " + url);

            connection = DriverManager.getConnection(url,user, pass);
            metaData = connection.getMetaData();
            statement = connection.createStatement();

            System.out.println("Connected..\n");

        } catch (SQLException e) {
            System.out.println("Error connecting -->" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String getTableNames() {
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

        return null;
    }

    @Override
    public String getTableData(String tableName) {
        return null;
    }

    public ArrayList<String> getTableColumns(String tableName) {
        ResultSet columns = null;
        ArrayList<String> attributes = new ArrayList<>();
        try {
            columns = metaData.getColumns(null, null, tableName, null);

            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String datatype = columns.getString("DATA_TYPE");
                attributes.add(columnName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attributes;
    }

    public ResultSet selectAllFrom(String tableName) {
        String query = "SELECT * FROM " + tableName;
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  resultSet;
    }

    @Override
    public void insertInto(String tableName) {

    }

    @Override
    public void deleteFrom(String tableName) {

    }


}
