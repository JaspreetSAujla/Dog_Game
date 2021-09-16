#include<iostream>
#include "DayClass.h"
using namespace std;

DayClass::DayClass() {}



DayClass::DayClass(string UseSaveFile) {
    /*
    Initialises the variables.
    Tries to find a save file to start a game.
    If not, then starts a new game.
        
    Variables:
        useSaveFile = Stores whether the user wants to 
                      continue where they left off or not.
        
        jim,...,chloe = Instances of all the different dogs that 
                        are playable.
    */
    useSaveFile = UseSaveFile;

    DogClass jim = DogClass("Jim", 3.0, 34, 47, 60);
    DogClass rover = DogClass("Rover", 5.0, 68, 39, 74);
    DogClass jack = DogClass("Jack", 4.0, 73, 29, 68);
    DogClass russell = DogClass("Russell", 8.0, 37, 19, 35);
    DogClass maddie = DogClass("Maddie", 6.0, 47, 76, 48);
    DogClass chloe = DogClass("Chloe", 1.0, 23, 28, 48);

    // Tries to find a save file.
    if (useSaveFile == "continue") {
        try {
            getSaveFile();
        } catch (exception e) {
            cout << "There was no save file detected. \nStarting a new game... \n";
            startGame();
        }
    } else if (useSaveFile == "new") {
        startGame();
    }
}



void DayClass::startGame() {
    /*
    Starts the game and allows the user to pick a dog.
        
    Variables:
        doggyChoice = Stores the choice the user made.

        validResponse = Stores whether the response was valid.
    */
    string doggyChoice;
    bool validResponse = false;

    cout << "Hello! Welcome to your very own virtual pet dog simulator. \n";
    cout << "Pick a dog to get started. \n";
    jim.description();
    rover.description();
    jack.description();
    russell.description();
    maddie.description();
    chloe.description();

    while (validResponse == false) {
        cout << "(jim/rover/jack/russell/maddie/chloe) \n";
        validResponse = true;
        cin >> doggyChoice;
        if (doggyChoice == "jim") {
            doggy = jim;
        } else if (doggyChoice == "rover") {
            doggy = rover;
        } else if (doggyChoice == "jack") {
            doggy = jack;
        } else if (doggyChoice == "russell") {
            doggy = russell;
        } else if (doggyChoice == "maddie") {
            doggy = maddie;
        } else if (doggyChoice == "chloe") {
            doggy = chloe;
        } else {
            validResponse = false;
            cout << "Invalid response, try again. \n";
        }
    }
    cout << "These are your dog's stats. \n";
    doggy.description();
}



void DayClass::run() {
    /*
    Runs the code for the whole day.
    */
    while (doggy.alive == true) {
        morningSegment();
        if (doggy.alive == false) {
            break;
        }
        afternoonSegment();
        if (doggy.alive == false) {
            break;
        }
        eveningSegment();
        if (doggy.alive == false) {
            break;
        }
        extraActivity();
        if (doggy.alive == false) {
            break;
        }
        dayConclusion();
    }
    cout << "Thank you for playing. \n";
}



void DayClass::dayConclusion() {
    /*
    Increases the dog's age and saves the data to a file.
    */
    cout << "The day has come to an end. \nYou and " << doggy.name << " fall asleep together. \n";
    doggy.age += 0.2;
    doggy.ageChecker();
    try {
        saveCurrentProgress();
        cout << "PROGRESS HAS BEEN SAVED. \nFeel free to quit. \n";
    } catch (exception e) {
        cout << "Progress NOT saved successfully!! \n";
    }
}