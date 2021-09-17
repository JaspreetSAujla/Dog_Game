#include<iostream>
#include "DogGame.h"
#include "DayClass.h"
#include "DayClass.cpp"
using namespace std;

DogGame::DogGame() {
    /*
    Defines the initial conditions of the game, and runs it.

    Variables:
        useSaveFile = Checks to see if the user wants to use 
                      the save file.
            
        validResponse = Stores whether the response was valid.
    */
    string useSaveFile;
    bool validResponse = false;

    // Loops over till user gives valid response.
    while (validResponse == false) {
        validResponse = true;
        cout << "Would you like to start a new game or continue where you left off? \n(new/continue) \n";
        cin >> useSaveFile;
        if (useSaveFile == "new" || useSaveFile == "continue") {
            this->game = DayClass(useSaveFile);
        } else {
            validResponse = false;
            cout << "Invalid response, try again. \n";
        }
    }
    this->game.run();
}