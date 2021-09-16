#include<iostream>
#include "DogClass.h"
#include "DogClass.cpp"
using namespace std;

#ifndef DAYCLASS_H
#define DAYCLASS_H

class DayClass {
    /*
    A class which highlights the different parts of the day.
    Allows the player to pick a dog.
    Also saves the game regularly.

    Attributes:
        UseSaveFile = Stores whether the user wants to start a new 
                      game or continue from an old one.
    
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
    
    public:
        DayClass(string UseSaveFile);

    private:
        DogClass jim;
        DogClass rover;
        DogClass jack;
        DogClass maddie;
        DogClass chloe;
        DogClass russell;
        DogClass doggy;
        string useSaveFile;

        void startGame();

        void run();

        void morningSegment();

        void afternoonSegment();

        void eveningSegment();

        void extraActivity();

        void dayConclusion();

        void getSaveFile();

        void saveCurrentProgress();
};

#endif