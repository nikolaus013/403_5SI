package connection;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface Connection {

    void Connect();

    //Imena svih tabela u bazi
    String getTableNames();

    String getTableData(String tableName);

    void insertInto(String tableName);

    void deleteFrom(String tableName);
}
