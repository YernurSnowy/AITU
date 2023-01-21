import java.util.Scanner;

public class RecursiveOutput {

    public static void Range(int A, int B){
        if(A==B){
            System.out.println(A);
        } else if (A<B) {
            while (A<=B){
                System.out.println(A);
                A++;
            }
        } else {
            while (A>=B){
                System.out.println(A);
                A--;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int A = sc.nextInt();
        System.out.print("Enter second number: ");
        int B = sc.nextInt();
        Range(A,B);
    }
}
