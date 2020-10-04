package Java;
import Java.DogClass;
import Java.DayClass;
import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Hello! Welcome to your very own virtual pet dog simulator."
                            + "\r\nType a dog's name to get started." +
                            "\r\njim \r\nrover \r\njack \r\nmaddie \r\nchloe \r\nrussel");
        String Doggy = scn.nextLine();
        DayClass simulation = new DayClass(Doggy, scn);

        while (simulation.doggy.alive.equals("yes")) {
            simulation.morningSegment();
            if (simulation.doggy.alive.equals("no")) {
                break;
            }
            simulation.afternoonSegment();
            if (simulation.doggy.alive.equals("no")) {
                break;
            }
            simulation.eveningSegment();
            if (simulation.doggy.alive.equals("no")) {
                break;
            }
            simulation.extraActivity();
            if (simulation.doggy.alive.equals("no")) {
                break;
            }
            simulation.dayConclusion();
        }
        System.out.println("Thank you for playing.");
        scn.close();
    }
}
