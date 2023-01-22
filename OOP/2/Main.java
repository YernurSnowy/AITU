//import util for using scanner
import java.util.Scanner;
//import util for using arrays
import java.util.ArrayList;
public class Main {
    public static void main (String[] args){
        //array list for vagons
        ArrayList<Vagon> vagons = new ArrayList<>();
        //variable for scanning
        Scanner scan = new Scanner(System.in);
        System.out.println("Create your train");
        //create lokomotives objects
        Vagon lokomotiv_A = new Lokomotiv_A();
        Vagon lokomotiv_B = new Lokomotiv_B();
        Vagon lokomotiv_C = new Lokomotiv_C();
        //show info about lokomotives
        System.out.println(lokomotiv_A+"\n");
        System.out.println(lokomotiv_B+"\n");
        System.out.println(lokomotiv_C+"\n");
        //choose a lokomotiv
        System.out.println("Firstly choose lokomotive:\n1)Lokomotiv A\n2)Lokomotiv B\n3)Lokomotiv C");
        int lok = scan.nextInt();
        double speed = 0;
        int traction = 0;
        int seats = 0;
        if(lok == 1){
            speed = lokomotiv_A.getSpeed();
            traction = lokomotiv_A.getTraction();
        } else if (lok == 2) {
            speed = lokomotiv_B.getSpeed();
            traction = lokomotiv_B.getTraction();
        } else if (lok == 3) {
            speed = lokomotiv_C.getSpeed();
            traction = lokomotiv_C.getTraction();
        }
        //create vagon's objects
        Vagon coupe = new Coupe();
        Vagon lux = new Lux();
        Vagon plaskart = new Plaskart();
        //create an infinite loop
        while(true){
            System.out.println("What do you want?\n1)Show type of vagons\n2)Add vagon to train\n3)Show train's vagons\n4)Show statistics");
            int com = scan.nextInt();
            //show info about type of vagons
            if(com == 1){
                System.out.println(coupe+"\n");
                System.out.println(lux+"\n");
                System.out.println(plaskart+"\n");
            }
            //add vagons to the train
            else if (com == 2) {
                System.out.println("1)Coupe\n2)Lux\n3)Plaskart") ;
                int vag = scan.nextInt();
                if(vag == 1){
                    vagons.add(coupe);
                    seats += 20;
                } else if (vag == 2) {
                    vagons.add(lux);
                    seats += 10;
                } else if (vag == 3) {
                    vagons.add(plaskart);
                    seats += 50;
                }
            }
            //show vagons in array
            else if (com == 3) {
                System.out.println(vagons);
            }
            //show statistics about train
            else if (com == 4) {
                System.out.println("Train" +
                        "\nSpeed: " + speed +
                        "\nTraction: " + traction +
                        "\nSeats: " + seats);
            }
        }
    }
}
