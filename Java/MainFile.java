package Java;
import Java.DogClass;

public class MainFile {
    public static void main(String[] args) {
        DogClass doggy = new DogClass("Test", 2, 20, 20, 20);
        doggy.description();
        doggy.relax();
    }
}
