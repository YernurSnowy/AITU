//create a subclass for Vagon class
public class Coupe extends Vagon {
    //constructor
    public Coupe(){
        setSeats(20);
        setSpeed(0);
        setTraction(0);
    }
    //method of showing information
    @Override
    public String toString() {
        return "Coupe" +
                "\nSpeed: " + getSpeed() +
                "\nTraction: " + getTraction() +
                "\nSeats: " + getSeats();
    }
}
