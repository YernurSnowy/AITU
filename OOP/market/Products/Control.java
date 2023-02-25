package Products;

import Entities.Devices;
import Entities.Gamepart.Game;
import Entities.Gamepart.Ps.Playstation;
import Entities.Gamepart.Xbox.Xbox;
import Entities.Headphonespart.Headphone;
import Entities.Smartphonepart.Apple.*;
import Entities.Smartphonepart.Smartphone;
import Products.FactoryPattern.Product;
import Products.FactoryPattern.ProductFactory;

import java.util.Scanner;

public class Control {
    static Scanner scan = new Scanner(System.in);
    static String productType;

    public static  void  catalog() throws  Exception{
        int com;
        do{
            Devices.text();
            com = scan.nextInt();
            switch (com){
                case 1:show_smartphones();break;
                case 2:show_headphones();break;
                case 3:show_games();break;
                default:break;
            }
        }while (com!=4);
    }

    public static void show_smartphones() throws Exception{
        Smartphone.text();
        int com = scan.nextInt();
        switch (com){
            case 1:
                NotProApple.text();
                Factory("Iphone");
                break;
            case 2:
                ProApple.text();
                Factory("Iphone Pro");
                break;
            case 3: Factory("Samsung Phone");break;
            case 4: Factory("Xiaomi Phone");break;
            case 5: break;
            default:
                System.out.println("Incorrect command!");
        }
    }

    public static void show_headphones() throws Exception{
        Headphone.text();
        int com = scan.nextInt();
        switch (com){
            case 1:
                Factory("Apple Headphone");break;
            case 2:
                Factory("Samsung Headphone");break;
            case 3:
                break;
            default:
                System.out.println("Incorrect command!");
        }
    }

    public static void show_games() throws Exception{
        Game.text();
        int com = scan.nextInt();
        if(com == 1){
            Playstation.text();
            int x = scan.nextInt();
            switch (x){
                case 1: Factory("Playstation Console");break;
                case 2: Factory("Playstation Gamepad");break;
                case 3: break;
                default:
                    System.out.println("Incorrect command!");
            }
        } else if (com == 2) {
            Xbox.text();
            int x = scan.nextInt();
            switch (x){
                case 1: Factory("Xbox Console");break;
                case 2: Factory("Xbox Gamepad");break;
                case 3: break;
                default:
                    System.out.println("Incorrect command!");
            }
        }
    }

    public static void Factory(String productType) throws Exception{
        Product product = ProductFactory.createProduct(productType);
        product.show_catalog();
    }
}
