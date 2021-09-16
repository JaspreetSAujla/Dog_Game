#include<iostream>
#include<ctime>
#include<cstdlib>
#include<vector>
using namespace std;

#ifndef DOGCLASS_H
#define DOGCLASS_H

class DogClass {
    /*
    A class which creates dog objects and gives them their behaviours.
    Contains feed, relax, exercise and talk methods. 
    These are the activities the dog can do.
    Also checks how happy the dog is, as well as the age and health.

    Attributes:
        Name = Name of the dog.

        Age = Age of the dog.

        Fitness = fitness of the dog.

        Hunger = Hunger of the dog.

        Happiness = Happiness of the dog.        
    
    Methods:
        DogClass = Initialises the variables of the object.

        description = Returns the status of the dog.

        feed = Feeds the dog.

        relax = Relax with the dog.

        exercise = Exercise the dog.

        talk = Gets the dog to talk.

        happyChecker = Checks how happy the dog is.

        activityCycle = Makes the activity choosing segment more 
                        condensed.
        
        ageChecker = Checks the age of the dog.

        healthChecker = Checks the health of the dog.

        randomNumber = Used to generate random numbers for attributes.
    */
    
    public:
        bool alive;
        string name;
        double age;
        int fitness;
        int hunger;
        int happiness;

        DogClass();

        DogClass(string Name, double Age, int Fitness, int Hunger, int Happiness);

        void description();

        void feed();

        void relax();

        void exercise();

        void talk();

        void activityCycle(string activity);

        void ageChecker();

        void healthChecker();

    private:
        void happyChecker();

        int randomNumber(int startNumber, int endNumber);
};

#endif