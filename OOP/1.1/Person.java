public class Person {
    private String fullName;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void theMove(String fullName, int age){
        System.out.println(age + " year old " + fullName + " is moving");
    }

    public void talk(String fullName, int age){
        System.out.println(age + " year old " + fullName + " is talking");
    }

    Person(){

    }

    Person(String fullName, int age){
        setAge(age);
        setFullName(fullName);
    }

    public static void main(String[] args){
        Person person1 = new Person("Koishybayev Yernur", 18);
        Person person2 = new Person();
        person2.setFullName("Makarov Ibragim");
        person2.setAge(17);

        person1.theMove(person1.fullName, person1.age);
        person2.talk(person2.fullName, person2.age);

    }
}
