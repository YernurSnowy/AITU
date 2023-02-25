package Purchase;

import Users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Control {
    private static final String url="jdbc:postgresql://localhost:5432/market";
    private static final String username = "postgres";
    private static final String password = "root";
    static Scanner scan = new Scanner(System.in);
    static int uid = User.uid;
    static int balance = 0;

    public static void purchases() throws Exception{
        Connection connection = DriverManager.getConnection(url,username,password);

        String x = "SELECT balance FROM users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(x);
        preparedStatement.setInt(1, uid);
        ResultSet res = preparedStatement.executeQuery();
        if(res.next()){
            balance = res.getInt("balance");
        }
        System.out.println("Your balance: " + balance);

        int type;
        do{
            System.out.println("Choose type of product:");
            System.out.println("1) Phone");
            System.out.println("2) Headphone");
            System.out.println("3) Game");
            System.out.println("4) Exit");

            type = scan.nextInt();

            switch (type){
                case 1: buy_phone();break;
                case 2: buy_headphone();break;
                case 3: buy_game();break;
                default:break;
            }
        }while (type!=4);
        connection.close();
    }

    public static void buy_phone() throws Exception{
        System.out.println("Choose product:");
        System.out.println("1) Iphone");
        System.out.println("2) Iphone Pro");
        System.out.println("3) Samsung");
        System.out.println("4) Xiaomi");
        System.out.println("5) Exit");

        int com = scan.nextInt();
        switch (com){
            case 1: buy_product("applephone");break;
            case 2: buy_product("applephonepro");break;
            case 3: buy_product("samsungphone");break;
            case 4: buy_product("xiaomiphone");break;
            case 5: break;
        }
    }

    public static void buy_headphone() throws Exception{
        System.out.println("Choose product:");
        System.out.println("1) Air pods");
        System.out.println("2) Samsung galaxy");
        System.out.println("3) Exit");

        int com = scan.nextInt();
        switch (com){
            case 1: buy_product("appleheadphones");break;
            case 2: buy_product("samsungheadphones");break;
            case 3: break;
        }
    }

    public static void buy_game() throws Exception {
        System.out.println("Choose brand:");
        System.out.println("1) Playstation");
        System.out.println("2) Xbox");
        System.out.println("3) Exit");

        int com = scan.nextInt();
        switch (com) {
            case 1:
                System.out.println("1) Console");
                System.out.println("2) Gamepad");
                System.out.println("3) Exit");

                int com1 = scan.nextInt();
                switch (com1) {
                    case 1:
                        buy_product("psconsole");
                        break;
                    case 2:
                        buy_product("psgamepad");
                        break;
                    case 3:
                        break;
                }
            case 2:
                System.out.println("1) Console");
                System.out.println("2) Gamepad");
                System.out.println("3) Exit");

                int com2 = scan.nextInt();
                switch (com2) {
                    case 1:
                        buy_product("xboxconsole");
                        break;
                    case 2:
                        buy_product("xboxgamepad");
                        break;
                    case 3:
                        break;

                }
            case 3:break;
        }
    }

    public static void buy_product(String table) throws Exception{
        Connection connection = DriverManager.getConnection(url,username,password);
        String com = "SELECT price FROM " + table + " WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(com);
        System.out.println("Enter product id: ");
        int pid = scan.nextInt();
        preparedStatement.setInt(1, pid);
        ResultSet resultSet = preparedStatement.executeQuery();
        int sum = 0;
        if(resultSet.next()){
            sum = resultSet.getInt("price");
        }

        int remainder = balance - sum;

        String com1 = "UPDATE users SET balance = ? WHERE id = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(com1);
        preparedStatement1.setInt(1,remainder);
        preparedStatement1.setInt(2,uid);
        preparedStatement1.executeUpdate();

        String com2 = "INSERT INTO purchases(userid, total) VALUES(?,?)";
        PreparedStatement preparedStatement2 = connection.prepareStatement(com2);
        preparedStatement2.setInt(1,uid);
        preparedStatement2.setInt(2,sum);
        preparedStatement2.executeUpdate();

        purchase_info(sum);
        connection.close();
    }

    public static void purchase_info(int sum) throws Exception{
        Connection connection = DriverManager.getConnection(url,username,password);
        String com = "SELECT * FROM purchases WHERE userid = ? AND total = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(com);
        preparedStatement.setInt(1,uid);
        preparedStatement.setInt(2,sum);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("Receipt ID: " + resultSet.getInt("id") + " Total: " + resultSet.getInt("total") + " User ID: " + resultSet.getInt("userid"));
        }
    }

}
