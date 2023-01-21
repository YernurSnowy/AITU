public class Cat extends Animal{
    private String color;
    public  Cat(String food, String location, String color){
        super(food, location);
        setColor(color);
    }

    @Override
    public void makeNoise() {
        System.out.println("Mew Mew");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void sleeping() {
        System.out.println("Cat is sleeping");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
