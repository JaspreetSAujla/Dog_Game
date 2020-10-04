package Java;
import Java.DogClass;
import java.util.Scanner;

public class DayClass {
    DogClass jim = new DogClass("Jim", 3.0, 34, 47, 60);
    DogClass rover = new DogClass("Rover", 5.0, 68, 39, 74);
    DogClass jack = new DogClass("Jack", 4.0, 73, 29, 68);
    DogClass russell = new DogClass("Russell", 8.0, 37, 19, 35);
    DogClass maddie = new DogClass("Maddie", 6.0, 47, 76, 48);
    DogClass chloe = new DogClass("Chloe", 1.0, 23, 28, 48);
    DogClass doggy;
    Scanner scn;

    DayClass(String Doggy, Scanner Scn) {
        this.scn = Scn;
        if (Doggy.equals("jim")) {
            this.doggy = this.jim;
        } else if (Doggy.equals("rover")) {
            this.doggy = this.rover;
        } else if (Doggy.equals("jack")) {
            this.doggy = this.jack;
        } else if (Doggy.equals("russell")) {
            this.doggy = this.russell;
        } else if (Doggy.equals("maddie")) {
            this.doggy = this.maddie;
        } else {
            this.doggy = this.chloe;
        }
        System.out.println("These are your dog's stats.");
        this.doggy.description();
    }

    public void morningSegment() {
        System.out.println("You wake up in the morning with "+ this.doggy.name + " laying next to you." +
        "\r\nIt is breakfast time and this is how your dog is doing: ");
        this.doggy.description();
        System.out.println("What would you like to do with " + this.doggy.name + "? \r\n(feed/relax/exercise/talk)");
        String Activity = this.scn.nextLine();
        if (Activity.equals("feed")) {
            this.doggy.feed();
        } else {
            this.doggy.activityCycle(Activity);
        }
        this.doggy.description();
        this.doggy.healthChecker();
    }

    public void afternoonSegment() {
        System.out.println("It is now the afternoon; the weather is great outside. \r\nWhat would you like to do? \r\n(relax/exercise/talk)");
        String Activity = this.scn.nextLine();
        this.doggy.activityCycle(Activity);
        this.doggy.description();
        this.doggy.healthChecker();
    }

    public void eveningSegment() {
        System.out.println("It is now the evening time.");
        System.out.println("What would you like to do with " + this.doggy.name + "? \r\n(feed/relax/exercise/talk)");
        String Activity = this.scn.nextLine();
        if (Activity.equals("feed")) {
            this.doggy.feed();
        } else {
            this.doggy.activityCycle(Activity);
        }
        this.doggy.description();
        this.doggy.healthChecker();
    }

    public void extraActivity() {
        System.out.println("There is time to do one more activity! \r\nWhat would you like to do? \r\n(relax/exercise/talk)");
        String Activity = this.scn.nextLine();
        this.doggy.activityCycle(Activity);
        this.doggy.description();
        this.doggy.healthChecker();
    }

    public void dayConclusion() {
        System.out.println("The day has come to an end. \r\nYou and " + this.doggy.name + " fall asleep together.");
        this.doggy.age += 0.2;
        this.doggy.ageChecker();
    }
}