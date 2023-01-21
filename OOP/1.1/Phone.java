import java.util.Scanner;

public class Phone {
    private int number;
    private String model;
    private int weight;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    Phone() {

    }

    Phone(int number, String model) {
        setNumber(number);
        setModel(model);
    }

    Phone(int number, String model, int weight) {
        this(number, model);
        setWeight(weight);
    }

    public void receiveCall(String name){
        System.out.println(name + " is ringing");
    }

    public void receiveCall(String name, int number){
        System.out.println(name + " is ringing with number " + number);
    }

    public void sendMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        number = sc.nextInt();
        System.out.println("Message will be sent to" + number);
    }

    @Override
    public String toString() {
        return number + " " + model + " " + weight;
    }

    public static void main(String[] args){
        Phone[] phone = new Phone[3];
        phone[0] = new Phone(1, "Iphone 11", 80);
        phone[1] = new Phone(2,"Iphone 12", 100);
        phone [2] = new Phone(3,"Iphone 13", 120);

        for(int i =0; i< phone.length;i++){
            System.out.println(phone[i]);
        }

        for(int i =0;i< phone.length;i++){
            phone[i].receiveCall("Yernur");
        }

        phone[0].receiveCall("Daniar", 123123123);
        phone[0].sendMessage();
        }

    }


