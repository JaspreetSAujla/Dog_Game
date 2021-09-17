#include<iostream>
#include "DayClass.h"
using namespace std;

#ifndef DOGGAME_H
#define DOGGAME_H

class DogGame {
    /*
    Class which runs the code for the dog game, after checking whether 
    the user wants to start a new game or continue where they left off.
    
    Methods:
        DogGame = Defines the initial conditions of the game, and runs it.
    */
    
    public:
        DogGame();
    
    private:
        DayClass game;
};

#endif