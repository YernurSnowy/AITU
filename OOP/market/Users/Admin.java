package Users;

import Entities.Devices;
import Entities.Gamepart.Ps.Playstationconsole;
import Entities.Gamepart.Ps.Playstationgamepad;
import Entities.Gamepart.Xbox.Xboxconsole;
import Entities.Gamepart.Xbox.Xboxgamepad;
import Entities.Headphonespart.Appleheadphone;
import Entities.Headphonespart.Headphone;
import Entities.Headphonespart.Samsungheadphone;
import Entities.Smartphonepart.Apple.NotProIphone;
import Entities.Smartphonepart.Apple.ProIphone;
import Entities.Smartphonepart.Samsung.Samsungphone;
import Entities.Smartphonepart.Smartphone;
import Entities.Smartphonepart.Xiaomi.Xiaomiphone;

import java.sql.*;
import java.util.Scanner;

public class Admin {
    private static final String url="jdbc:postgresql://localhost:5432/market";
    private static final String username = "postgres";
    private static final String password = "root";
    static Scanner scan = new Scanner(System.in);
    static int uid = User.uid;

    public  static  void show_user() throws Exception{
        Connection connection = DriverManager.getConnection(url,username,password);
        String com = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(com);
        while (res.next()){
            System.out.println("ID: "+res.getInt("id")+" Login: "+res.getString("login")+ " Password: "+res.getString("password")+" Balance: "+res.getInt("balance"));
        }
        connection.close();
    }

    public  static void delete_user() throws Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        show_user();
        System.out.println("What user do you want to delete: ");
        int id = scan.nextInt();
        String com = "DELETE FROM users WHERE id = ?";
        PreparedStatement pS = connection.prepareStatement(com);
        pS.setInt(1, id);
        pS.executeUpdate();
        connection.close();
    }

    public static void delete_products() throws Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        int i;
        do{
            Devices.text();
            i = scan.nextInt();
            switch (i){
                case 1:
                    Smartphone.text();
                    int com = scan.nextInt();
                    if(com == 1){
                        NotProIphone.show_catalog();
                        delete("applephone");
                        break;
                    } else if (com == 2) {
                        ProIphone.show_catalog();
                        delete("applephonepro");
                        break;
                    } else if (com == 3) {
                        Samsungphone.show_catalog();
                        delete("samsungphone");
                        break;
                    } else if (com == 4) {
                        Xiaomiphone.show_catalog();
                        delete("xiaomiphone");
                        break;
                    } else {
                        break;
                    }
                case 2:
                    Headphone.text();
                    int com1 = scan.nextInt();
                    if(com1 == 1){
                        Appleheadphone.show_catalog();
                        delete("appleheadphones");
                        break;
                    } else if (com1 == 2) {
                        Samsungheadphone.show_catalog();
                        delete("samsungheadphones");
                        break;
                    }else{
                        break;
                    }
                case 3:
                    System.out.println("1) Playstation console");
                    System.out.println("2) Playstation gamepad");
                    System.out.println("3) Xbox console");
                    System.out.println("4) Xbox gamepad");
                    System.out.println("5) Exit");
                    int com2 = scan.nextInt();
                    if(com2 == 1){
                        Playstationconsole.show_catalog();
                        delete("psconsole");
                        break;
                    } else if (com2 == 2) {
                        Playstationgamepad.show_catalog();
                        delete("psgamepad");
                        break;
                    } else if (com2 == 3) {
                        Xboxconsole.show_catalog();
                        delete("xboxconsole");
                        break;
                    } else if (com2 == 4) {
                        Xboxgamepad.show_catalog();
                        delete("xboxgamepad");
                        break;
                    } else {
                        break;
                    }
            }
        }while (i!=4);
    }

    public static void add_products() throws Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        int i;
        do{
            Devices.text();
            i = scan.nextInt();
            switch (i){
                case 1:
                    Smartphone.text();
                    int com = scan.nextInt();
                    if(com == 1){
                        insert("applephone");
                        break;
                    } else if (com == 2) {
                        insert("applephonepro");
                        break;
                    } else if (com == 3) {
                        insert("samsungphone");
                        break;
                    } else if (com == 4) {
                        insert("xiaomiphone");
                        break;
                    } else {
                        break;
                    }
                case 2:
                    Headphone.text();
                    int com1 = scan.nextInt();
                    if(com1 == 1){
                        insert("appleheadphones");
                        break;
                    } else if (com1 == 2) {
                        insert("samsungheadphones");
                        break;
                    }else{
                        break;
                    }
                case 3:
                    System.out.println("1) Playstation console");
                    System.out.println("2) Playstation gamepad");
                    System.out.println("3) Xbox console");
                    System.out.println("4) Xbox gamepad");
                    System.out.println("5) Exit");
                    int com2 = scan.nextInt();
                    if(com2 == 1){
                        insert("psconsole");
                        break;
                    } else if (com2 == 2) {
                        insert("psgamepad");
                        break;
                    } else if (com2 == 3) {
                        insert("xboxconsole");
                        break;
                    } else if (com2 == 4) {
                        insert("xboxgamepad");
                        break;
                    } else {
                        break;
                    }
            }
        }while (i!=4);
    }

    public static void insert(String table) throws Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Enter model of product: ");
        scan.nextLine();
        String model = scan.nextLine();
        System.out.println("Enter price of product: ");
        int price = scan.nextInt();
        String com = "INSERT INTO " + table + "(model, price) VALUES(?,?);";
        PreparedStatement pS = connection.prepareStatement(com);
        pS.setString(1, model);
        pS.setInt(2, price);
        pS.executeUpdate();
        connection.close();
    }

    public static void delete(String table) throws Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("What product do you want to delete: ");
        int id = scan.nextInt();
        String com = "DELETE FROM " + table + " WHERE id = ?";
        PreparedStatement pS = connection.prepareStatement(com);
        pS.setInt(1, id);
        pS.executeUpdate();
        connection.close();
    }
}
