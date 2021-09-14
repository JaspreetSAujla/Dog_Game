package Java;

import java.util.Scanner;

public class DogGame {
    /**
    Class which runs the code for the dog game, after checking whether 
    the user wants to start a new game or continue where they left off.
    
    Methods:
        DogGame = Defines the initial conditions of the game, and runs it.
    */
    private DayClass game;



    DogGame() {
        /**
        Defines the initial conditions of the game, and runs it.

        Variables:
            useSaveFile = Checks to see if the user wants to use 
                          the save file.
            
            validResponse = Stores whether the response was valid.

            scn = Stores the scanner for inputs.
            
            this.game = Initialises the Day class.
        */
        String useSaveFile;
        boolean validResponse = false;
        Scanner scn = new Scanner(System.in);

        // Loops over till user gives valid response.
        while (validResponse == false) {
            validResponse = true;
            System.out.println("Would you like to start a new game or continue where you left off? \r\n(new/continue)");
            useSaveFile = scn.nextLine();
            if (useSaveFile.equals("new") || useSaveFile.equals("continue")) {
                this.game = new DayClass(useSaveFile, scn);
            } else {
                validResponse = false;
                System.out.println("Invalid response, try again.");
            }
        }
        this.game.run();
        scn.close();
    }
}