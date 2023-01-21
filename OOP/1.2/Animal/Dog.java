public class Dog extends Animal{
    private String breed;
    public  Dog(String food, String location, String breed){
        super(food, location);
        setBreed(breed);
    }

    @Override
    public void makeNoise() {
        System.out.println("Gav Gav");
    }

    @Override
    public void eat() {
        System.out.println(("Dog is eating"));
    }

    @Override
    public void sleeping() {
        System.out.println("Dog is sleeping");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
