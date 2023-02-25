// Package for entities related to Playstation gamepad
package Entities.Gamepart.Ps;
// Importing required classes and interfaces
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// Class for Playstation gamepad extending Playstation class
public class Playstationgamepad extends Playstation {
    // Database connection details
    private static final String url="jdbc:postgresql://localhost:5432/market";
    private static final String username = "postgres";
    private static final String password = "root";
    // Method to show the catalog of Playstation gamepads
    public static void show_catalog() throws  Exception{
        // Establishing connection to the database
        Connection connection = DriverManager.getConnection(url,username,password);
        // SQL command to select all the gamepads from the table
        String com = "SELECT * FROM psgamepad";
        // Creating a statement object for executing the command
        Statement statement = connection.createStatement();
        // Executing the command and storing the result set
        ResultSet res = statement.executeQuery(com);
        // Looping through each record in the result set and printing them
        while (res.next()){
            System.out.println("ID: "+res.getInt("id")+" Model: "+res.getString("model")+" Price: "+res.getInt("price"));
        }
        // Closing the database connection
        connection.close();
    }

}
