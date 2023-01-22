//create an abstract super class
public abstract class Vagon  {
    private double speed;
    private int traction;
    private int seats;

    //constructor
    public Vagon(double speed, int traction, int seats){
        setSeats(seats);
        setSpeed(speed);
        setTraction(traction);
    }

    protected Vagon() {
    }


    //method of showing information
    @Override
    public String toString() {
        return "Train" +
                "\nSpeed: " + speed +
                "\nTraction: " + traction +
                "\nSeats: " + seats;
    }
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getTraction() {
        return traction;
    }

    public void setTraction(int traction) {
        this.traction = traction;
    }
}
