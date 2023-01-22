//create a subclass for Vagon class
public class Plaskart extends Vagon {
    //constructor
    public Plaskart(){
        setSeats(50);
        setSpeed(0);
        setTraction(0);
    }
    //method of showing information
    @Override
    public String toString() {
        return "Plaskart" +
                "\nSpeed: " + getSpeed() +
                "\nTraction: " + getTraction() +
                "\nSeats: " + getSeats();
    }
}