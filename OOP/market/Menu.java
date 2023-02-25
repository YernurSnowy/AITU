import Users.User;

import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);
    static int uid = User.uid;
    public  static void admin_menu() throws Exception{
        int com;
        do{
            System.out.println("1) Create new user");
            System.out.println("2) Delete user");
            System.out.println("3) Add new product");
            System.out.println("4) Delete product");
            System.out.println("5) Show users");
            System.out.println("6) Back to the main menu");
            com = scan.nextInt();
            switch(com){
                case 1:
                    Users.User.add_user();break;
                case 2:
                    Users.Admin.delete_user();break;
                case 3:
                    Users.Admin.add_products();break;
                case 4:
                    Users.Admin.delete_products();break;
                case 5:
                    Users.Admin.show_user();break;
            }
        }while(com!=6);
    }

    public static void user_menu() throws Exception{
        int com;
        do{
            System.out.println("1) Catalog");
            System.out.println("2) Make a purchase");
            System.out.println("3) Profile");
            System.out.println("4) Set a balance");
            System.out.println("5) Back to the main menu");
            com = scan.nextInt();
            switch (com){
                case 1:
                    Products.Control.catalog();break;
                case 2:
                    Purchase.Control.purchases();break;
                case 3:
                    Users.User.user_info();break;
                case 4:
                    Users.User.set_balance();break;
            }
        }while(com!=5);
    }
}
