public class Main {
    public static void main(String[] args) {
        Veterinary vet = new Veterinary();
        Animal[] animal = new Animal[3];
        animal[0] = new Cat("fish","home","white");
        animal[1] = new Dog("meat", "booth", "husky");
        animal[2] = new Horse("hay", "barn", 15);

        for(int i = 0; i< animal.length; i++){
            System.out.println(animal[i]);
            vet.treatAnimal(animal[i]);
        }
    }
}