package app;

import javafx.application.Application;
import view.MainFrame;
import java.sql.SQLException;

public class AppCore {

    private static String url = "jdbc:mysql://64.225.110.65:3306/tim_403_5_si2019";
    private static String user = "tim_403_5_si2019", pass = "LDCUMAKG";

    public static void main(String[] args) throws SQLException {

        Application.launch(MainFrame.class, args);

    }
}
