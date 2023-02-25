package Entities.Gamepart.Xbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Xboxgamepad extends Xbox{
    private static final String url="jdbc:postgresql://localhost:5432/market";
    private static final String username = "postgres";
    private static final String password = "root";

    public static void show_catalog() throws  Exception{
        Connection connection = DriverManager.getConnection(url,username,password);
        String com = "SELECT * FROM xboxgamepad";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(com);
        while (res.next()){
            System.out.println("ID: "+res.getInt("id")+" Model: "+res.getString("model")+" Price: "+res.getInt("price"));
        }
        connection.close();
    }
}
