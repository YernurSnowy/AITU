import Users.User;

import java.util.Scanner;

public class Main {
    static int uid = User.uid;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int com;

        do {
            System.out.println("Hello, user!");
            System.out.println("1) Create an account");
            System.out.println("2) Log in");
            System.out.println("3) Stop the program");
            com = scan.nextInt();
            switch (com) {

                case 1:
                    Users.User.add_user();
                case 2:
                    Users.User.authorization();
                    uid = User.uid;
                    if(uid == 1){
                        Menu.admin_menu();
                    } else if (uid > 1) {
                        Menu.user_menu();
                    }
            }
        } while (com != 3);
    }
}