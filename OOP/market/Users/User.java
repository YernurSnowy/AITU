package Users;

import java.sql.*;
import java.util.Scanner;

public class User {
    private static final String url="jdbc:postgresql://localhost:5432/market";
    private static final String username = "postgres";
    private static final String password = "root";
    static Scanner scan = new Scanner(System.in);
    public static int uid=0;

    public static void set_balance() throws Exception{
        Connection connection = DriverManager.getConnection(url, username,password);
        System.out.println("Set a balance:");
        int balance = scan.nextInt();
        String com = "UPDATE users SET balance = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(com);
        preparedStatement.setInt(1,balance);
        preparedStatement.setInt(2, uid);
        preparedStatement.executeUpdate();
        System.out.println("Balance was changed successfully!");
    }
    public  static  void add_user() throws Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Create a login for an account:");
        String login = scan.nextLine();
        System.out.println("Create a password for an account:");
        String password = scan.nextLine();

        String com = "SELECT login FROM users WHERE login = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(com);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean equal = false;
        while (resultSet.next()){
            equal = true;
        }
        if(equal){
            System.out.println("The account with this login is already created!\nTry again.");
        } else {
            String command = "INSERT INTO users(login, password) VALUES(?,?);";
            PreparedStatement pS = connection.prepareStatement(command);
            pS.setString(1,login);
            pS.setString(2,password);
            pS.executeUpdate();
            System.out.println("Account was created successfully!");
        }
        connection.close();
    }

    public static void user_info() throws  Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        String command = "SELECT * FROM users WHERE id = ?";
        PreparedStatement pS = connection.prepareStatement(command);
        pS.setInt(1,uid);
        ResultSet res = pS.executeQuery();
        if(res.next()){
            System.out.println("ID: "+res.getInt("id")+" Login: "+res.getString("login")+" Balance: "+res.getInt("balance"));
        }
        connection.close();
    }

    public  static void authorization() throws  Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Login: ");
        String login = scan.nextLine().strip();
        System.out.println("Password: ");
        String password = scan.nextLine().strip();

        String com = "SELECT login, password FROM users WHERE login = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(com);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean sign = false;
        while(resultSet.next()){
            sign = true;
        }

        if(sign){
            String id = "SELECT id FROM users WHERE login = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(id);
            preparedStatement1.setString(1, login);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if(resultSet1.next()){
                uid = resultSet1.getInt("id");
                System.out.println("Hello, " + login);
            }
        }else{
            System.out.println("Incorrect login or password!");
        }
        connection.close();
    }
}
