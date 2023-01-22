//create a subclass for Vagon class
public class Lux extends Vagon {
    //constructor
    public Lux(){
        setSeats(10);
        setSpeed(0);
        setTraction(0);
    }
    //method of showing information
    @Override
    public String toString() {
        return "Lux" +
                "\nSpeed: " + getSpeed() +
                "\nTraction: " + getTraction() +
                "\nSeats: " + getSeats();
    }
}