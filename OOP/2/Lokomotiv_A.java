//create a subclass for Vagon class
public class Lokomotiv_A extends Vagon {
    //constructor
    public Lokomotiv_A(){
        setSeats(0);
        setSpeed(120);
        setTraction(30);
    }
    //method of showing information
    @Override
    public String toString() {
        return "Lokomotiv_A" +
                "\nSpeed: " + getSpeed() +
                "\nTraction: " + getTraction() +
                "\nSeats: " + getSeats();
    }
}
