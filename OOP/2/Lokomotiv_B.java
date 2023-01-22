//create a subclass for Vagon class
public class Lokomotiv_B extends Vagon {
    //constructor
    public Lokomotiv_B(){
        setSeats(0);
        setSpeed(110);
        setTraction(20);
    }
    //method of showing information
    @Override
    public String toString() {
        return "Lokomotiv_B" +
                "\nSpeed: " + getSpeed() +
                "\nTraction: " + getTraction() +
                "\nSeats: " + getSeats();
    }
}