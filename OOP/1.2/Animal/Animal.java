public class Animal {
    private String food, location;
    public Animal(String food, String location){
        setFood(food);
        setLocation(location);
    }

    public void makeNoise(){
        System.out.println("Animal is making noise");
    }

    public void eat(){
        System.out.println("Animal is eating");
    }

    public void sleeping(){
        System.out.println("Animal is sleeping");
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
