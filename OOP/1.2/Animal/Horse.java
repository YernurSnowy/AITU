public class Horse extends Animal {
    private double topSpeed;
    public Horse(String food, String location, double topSpeed){
        super(food, location);
        setTopSpeed(topSpeed);
    }

    @Override
    public void makeNoise() {
        System.out.println("Brrrr");
    }

    @Override
    public void eat() {
        System.out.println("Horse is eating");
    }

    @Override
    public void sleeping() {
        System.out.println("Horse is sleeping");
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }
}
