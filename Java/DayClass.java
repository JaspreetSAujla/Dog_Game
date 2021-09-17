package Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DayClass {
    /**
    A class which highlights the different parts of the day.
    Allows the player to pick a dog.
    Also saves the game regularly.

    Attributes:
        UseSaveFile = Stores whether the user wants to start a new 
                      game or continue from an old one.
        
        Scn = Passes in the scanner.
    
    Class Variables:
        jim,...,chloe = Instances of all the different dogs that 
                        are playable.
    
    Methods:
        DayClass = Defines the initial variables and sets up the game.

        startGame = Allows the user to pick a dog.

        run = Runs the game.

        morningSegment = Defines the morning segment of the day.

        afternoonSegment = Defines the afternoon segment of the day.

        eveningSegment = Defines the evening segment of the day.

        extraActivity = Defines the extra activity at the end of the day.

        dayConclusion = Increases age of the dog and saves the game.

        getSaveFile = Gets the save file if it exists.

        saveCurrentProgress = Saves the progress of the game.
    */

    private DogClass jim = new DogClass("Jim", 3.0, 34, 47, 60);
    private DogClass rover = new DogClass("Rover", 5.0, 68, 39, 74);
    private DogClass jack = new DogClass("Jack", 4.0, 73, 29, 68);
    private DogClass russell = new DogClass("Russell", 8.0, 37, 19, 35);
    private DogClass maddie = new DogClass("Maddie", 6.0, 47, 76, 48);
    private DogClass chloe = new DogClass("Chloe", 1.0, 23, 28, 48);
    private String useSaveFile;
    private DogClass doggy;
    private Scanner scn;



    DayClass(String UseSaveFile, Scanner Scn) {
        /**
        Initialises the variables.
        Tries to find a save file to start a game.
        If not, then starts a new game.
        
        Variables:
            this.useSaveFile = Stores whether the user wants to 
                               continue where they left off or not.
            
            this.scn = Stores the scanner.
        */
        this.useSaveFile = UseSaveFile;
        this.scn = Scn;

        // Tries to find a save file.
        if (this.useSaveFile.equals("continue")) {
            try {
                getSaveFile();
            } catch (Exception e) {
                System.out.println("There was no save file detected. \r\nStarting a new game...");
                startGame();
            }
        } else if (this.useSaveFile.equals("new")) {
            startGame();
        }
    }



    private void startGame() {
        /**
        Starts the game and allows the user to pick a dog.
        
        Variables:
            doggyChoice = Stores the choice the user made.

            validResponse = Stores whether the response was valid.
        */
        String doggyChoice;
        boolean validResponse = false;

        System.out.println("Hello! Welcome to your very own virtual pet dog simulator.");
        System.out.println("Pick a dog to get started.");
        jim.description();
        rover.description();
        jack.description();
        russell.description();
        maddie.description();
        chloe.description();

        while (validResponse == false) {
            System.out.println("(jim/rover/jack/russell/maddie/chloe)");
            validResponse = true;
            doggyChoice = scn.nextLine();
            if (doggyChoice.equals("jim")) {
                this.doggy = jim;
            } else if (doggyChoice.equals("rover")) {
                this.doggy = rover;
            } else if (doggyChoice.equals("jack")) {
                this.doggy = jack;
            } else if (doggyChoice.equals("russell")) {
                this.doggy = russell;
            } else if (doggyChoice.equals("maddie")) {
                this.doggy = maddie;
            } else if (doggyChoice.equals("chloe")) {
                this.doggy = chloe;
            } else {
                validResponse = false;
                System.out.println("Invalid response, try again.");
            }
        }
        System.out.println("These are your dog's stats.");
        this.doggy.description();
    }



    public void run() {
        /**
        Runs the code for the whole day.
        */
        while (this.doggy.alive == true) {
            morningSegment();
            if (this.doggy.alive == false) {
                break;
            }
            afternoonSegment();
            if (this.doggy.alive == false) {
                break;
            }
            eveningSegment();
            if (this.doggy.alive == false) {
                break;
            }
            extraActivity();
            if (this.doggy.alive == false) {
                break;
            }
            dayConclusion();
        }
        System.out.println("Thank you for playing.");
    }



    private void morningSegment() {
        /**
        Defines the morning segment of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            validResponse = Stores whether the response was valid.
        */
        String activity;
        boolean validResponse = false;

        System.out.println("You wake up in the morning with "+ this.doggy.name + " laying next to you." +
        "\r\nIt is breakfast time and this is how your dog is doing: ");
        this.doggy.description();

        while (validResponse == false) {
            validResponse = true;
            System.out.println("What would you like to do with " + this.doggy.name + "? \r\n(feed/relax/exercise/talk)");
            activity = this.scn.nextLine();
            if (activity.equals("feed")) {
                this.doggy.feed();
            } else if (activity.equals("relax") || activity.equals("exercise") || activity.equals("talk")) {
                this.doggy.activityCycle(activity);
            } else {
                validResponse = false;
                System.out.println("Invalid response, try again.");
            }
        }
        this.doggy.description();
        this.doggy.healthChecker();    
    }



    private void afternoonSegment() {
        /**
        Defines the afternoon segment of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            validResponse = Stores whether the response was valid.
        */
        String activity;
        boolean validResponse = false;

        System.out.println("It is now the afternoon; the weather is great outside. \r\nWhat would you like to do?");
        while (validResponse == false) {
            validResponse = true;
            System.out.println("(relax/exercise/talk)");
            activity = this.scn.nextLine();
            if (activity.equals("relax") || activity.equals("exercise") || activity.equals("talk")) {
                this.doggy.activityCycle(activity);
            } else {
                validResponse = false;
                System.out.println("Invalid response, try again.");
            }
        }
        this.doggy.description();
        this.doggy.healthChecker();
    }



    private void eveningSegment() {
        /**
        Defines the evening segment of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            validResponse = Stores whether the response was valid.
        */
        String activity;
        boolean validResponse = false;

        System.out.println("It is now the evening time.");
        while (validResponse == false) {
            validResponse = true;
            System.out.println("What would you like to do with " + this.doggy.name + "? \r\n(feed/relax/exercise/talk)");
            activity = this.scn.nextLine();
            if (activity.equals("feed")) {
                this.doggy.feed();
            } else if (activity.equals("relax") || activity.equals("exercise") || activity.equals("talk")) {
                this.doggy.activityCycle(activity);
            } else {
                validResponse = false;
                System.out.println("Invalid response, try again.");
            }
        }
        this.doggy.description();
        this.doggy.healthChecker();
    }



    private void extraActivity() {
        /**
        Defines the code for the extra activity at the end of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            validResponse = Stores whether the response was valid.
        */
        String activity;
        boolean validResponse = false;

        System.out.println("There is time to do one more activity! \r\nWhat would you like to do?");
        while (validResponse == false) {
            validResponse = true;
            System.out.println("(relax/exercise/talk)");
            activity = this.scn.nextLine();
            if (activity.equals("relax") || activity.equals("exercise") || activity.equals("talk")) {
                this.doggy.activityCycle(activity);
            } else {
                validResponse = false;
                System.out.println("Invalid response, try again.");
            }
        }
        this.doggy.description();
        this.doggy.healthChecker();
    }



    private void dayConclusion() {
        /**
        Increases the dog's age and saves the data to a file.
        */
        System.out.println("The day has come to an end. \r\nYou and " + this.doggy.name + " fall asleep together.");
        this.doggy.age += 0.2;
        this.doggy.ageChecker();
        try {
            saveCurrentProgress();
            System.out.println("PROGRESS HAS BEEN SAVED. \r\nFeel free to quit.");
        } catch (IOException e) {
            System.out.println("Progress NOT saved successfully!!");
        }
    }



    private void getSaveFile() throws IOException, ClassNotFoundException {
        /**
        Opens the save file for the game and assigns the saved data 
        to the doggy variable.

        Variables:
            fileName = Stores the name of the file to be opened.

            fileInputStream = Stores the file input stream.

            objectInputStream = Stores the object input stream.
        */
        String fileName = "SaveFileJava.txt";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        this.doggy = (DogClass) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("SAVE FILE FOUND. \r\nContinuing the game...");
    }



    private void saveCurrentProgress() throws IOException {
        /**
        Saves the progress of the game to a file.
        Allows the user to carry on where they left off.

        Variables:
            fileName = Stores the name of the file.

            fileOutputStream = Stores the file output stream.

            objectOutputStream = Stores the object output stream.
        */
        String fileName = "SaveFileJava.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this.doggy);
        objectOutputStream.close();
    }
}