#include<iostream>
#include<fstream>
#include "DayClass.h"
#include "DogClass.h"
#include "DogClass.cpp"
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
    this->useSaveFile = UseSaveFile;

    this->jim = DogClass("Jim", 3.0, 34, 47, 60);
    this->rover = DogClass("Rover", 5.0, 68, 39, 74);
    this->jack = DogClass("Jack", 4.0, 73, 29, 68);
    this->russell = DogClass("Russell", 8.0, 37, 19, 35);
    this->maddie = DogClass("Maddie", 6.0, 47, 76, 48);
    this->chloe = DogClass("Chloe", 1.0, 23, 28, 48);

    // Tries to find a save file.
    if (this->useSaveFile == "continue") {
        try {
            int errorCode = getSaveFile();
            if (errorCode == 1) {
                throw (errorCode);
            }
        } catch (int errorCode) {
            cout << "There was no save file detected. \nStarting a new game... \n";
            this->startGame();
        }
    } else if (this->useSaveFile == "new") {
        this->startGame();
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



void DayClass::morningSegment() {
    /*
    Defines the morning segment of the day.
    User picks an activity to do with their dog.
        
    Variables:
        activity = Stores the activity the user wants to do.

        validResponse = Stores whether the response was valid.
    */
    string activity;
    bool validResponse = false;

    cout << "You wake up in the morning with " << doggy.name << " laying next to you." <<
            "\nIt is breakfast time and this is how your dog is doing: ";
    doggy.description();

    while (validResponse == false) {
        validResponse = true;
        cout << "What would you like to do with " << doggy.name << "? \n(feed/relax/exercise/talk) \n";
        cin >> activity;
        if (activity == "feed") {
            doggy.feed();
        } else if (activity == "relax" || activity == "exercise" || activity == "talk") {
            doggy.activityCycle(activity);
        } else {
            validResponse = false;
            cout << "Invalid response, try again. \n";
        }
    }
    doggy.description();
    doggy.healthChecker(); 
}



void DayClass::afternoonSegment() {
    /*
    Defines the afternoon segment of the day.
    User picks an activity to do with their dog.
        
    Variables:
        activity = Stores the activity the user wants to do.

        validResponse = Stores whether the response was valid.
    */
    string activity;
    bool validResponse = false;

    cout << "It is now the afternoon; the weather is great outside. \nWhat would you like to do? \n";
    while (validResponse == false) {
        validResponse = true;
        cout << "(relax/exercise/talk) \n";
        cin >> activity;
        if (activity == "relax" || activity == "exercise" || activity == "talk") {
            doggy.activityCycle(activity);
        } else {
            validResponse = false;
            cout << "Invalid response, try again. \n";
        }
    }
    doggy.description();
    doggy.healthChecker();
}



void DayClass::eveningSegment() {
    /*
    Defines the evening segment of the day.
    User picks an activity to do with their dog.
        
    Variables:
        activity = Stores the activity the user wants to do.

        validResponse = Stores whether the response was valid.
    */
    string activity;
    bool validResponse = false;

    cout << "It is now the evening time. \n";
    while (validResponse == false) {
        validResponse = true;
        cout << "What would you like to do with " << doggy.name << "? \n(feed/relax/exercise/talk) \n";
        cin >> activity;
        if (activity == "feed") {
            doggy.feed();
        } else if (activity == "relax" || activity == "exercise" || activity == "talk") {
            doggy.activityCycle(activity);
        } else {
            validResponse = false;
            cout << "Invalid response, try again. \n";
        }
    }
    doggy.description();
    doggy.healthChecker(); 
}



void DayClass::extraActivity() {
    /*
    Defines the code for the extra activity at the end of the day.
    User picks an activity to do with their dog.
        
    Variables:
        activity = Stores the activity the user wants to do.

        validResponse = Stores whether the response was valid.
    */
    string activity;
    bool validResponse = false;

    cout << "There is time to do one more activity! \nWhat would you like to do? \n";
    while (validResponse == false) {
        validResponse = true;
        cout << "(relax/exercise/talk) \n";
        cin >> activity;
        if (activity == "relax" || activity == "exercise" || activity == "talk") {
            doggy.activityCycle(activity);
        } else {
            validResponse = false;
            cout << "Invalid response, try again. \n";
        }
    }
    doggy.description();
    doggy.healthChecker();
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



int DayClass::getSaveFile() {
    /*
    Loads a save file if one exists already.
    Assigns the saved data to the doggy variable.

    Variables:
        inputFileStream = Opens file for loading data.
    */
    ifstream inputFileStream("SaveFileCPP.txt");
    inputFileStream >> doggy;
    inputFileStream.close();
    if (doggy.name.size() < 2) {
        return 1;
    } else {
        return 0;
    }
}



void DayClass::saveCurrentProgress() {
    /*
    Saves the current progress into a file.

    Variables:
        fileName = Stores the name of the file.

        outputFileStream = Opens file so data can be saved.
    */
    const char fileName[16] = "SaveFileCPP.txt";
    // Try to delete current file if it exists.
    try {
        remove(fileName);
    } catch(exception e) {
        cout << "File being saved for the first time. \n";
    }
    ofstream outputFileStream("SaveFileCPP.txt");
    outputFileStream << doggy;
    outputFileStream.close();
}