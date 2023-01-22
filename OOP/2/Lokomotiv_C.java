//create a subclass for Vagon class
public class Lokomotiv_C extends Vagon {
    //constructor
    public Lokomotiv_C(){
        setSeats(0);
        setSpeed(100);
        setTraction(10);
    }
    //method of showing information
    @Override
    public String toString() {
        return "Lokomotiv_C" +
                "\nSpeed: " + getSpeed() +
                "\nTraction: " + getTraction() +
                "\nSeats: " + getSeats();
    }
}
