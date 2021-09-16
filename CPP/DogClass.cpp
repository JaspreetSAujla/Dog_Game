#include<iostream>
#include<ctime>
#include<cstdlib>
#include<vector>
#include "DogClass.h"
using namespace std;

DogClass::DogClass(string Name, double Age, int Fitness, int Hunger, int Happiness) {
    name = Name;
    age = Age;
    fitness = Fitness;
    hunger = Hunger;
    happiness = Happiness;
    alive = true;
}



void DogClass::description() {
    /*
    Prints out the status of the dog
    */
    cout << "Name: " << name << ", Age: " << age << ", Fitness: " << fitness << 
            ", Happiness: " << happiness << ", Hunger: " << hunger << endl;
}



void DogClass::feed() {
    /*
    Runs the method to feed the dog.
    Picks a random item of food from the foods list and updates 
    the attributes.

    Variables:
        foods = Stores a list of foods.

        foodIncrease = Stores how much the hunger attribute 
                       will increase by.
            
        fitnessDecrease = Stores how much the fitness attribute 
                          will decrease by.
    */
    vector<string> food = {"some cheese.", "some fruit.", "some dogfood.",
                           "a chicken burger? Why??", "a pizza slice.",
                           "a treat."};
    int foodIncrease = randomNumber(0, 41) + 5;
    int fitnessDecrease = randomNumber(0, 21);
    cout << "You gave " << name << " " << food[randomNumber(0, food.size())] << 
            ". \nThe hunger bar has increased by " << foodIncrease << ". \n" << 
            name << " has not moved much. \nFitness decreased by " << fitnessDecrease << ". \n";
    hunger += foodIncrease;
    fitness -= fitnessDecrease;
    happyChecker();
}



void DogClass::relax() {
    /*
    Method for relaxing with the dog. 
    Picks a random relaxing task and updates the attributes.

    Variables:
        relaxation = Stores a list of things to do to relax.

        foodDecrease = Stores how much the hunger attribute 
                       will decrease by.
            
        fitnessDecrease = Stores how much the fitness attribute 
                          will decrease by.
    */
    vector<string> relaxation = {"cuddle", "watch a movie", "cook",
                                 "do yoga", "take thisies", "listen to music", "read"};
    int foodDecrease = randomNumber(0, 21);
    int fitnessDecrease = randomNumber(0, 21);
    cout << "You " << relaxation[randomNumber(0, relaxation.size())] << " with " << name << 
            ". \nThe hunger bar has decreased by " << foodDecrease << 
            ". \nFitness also decreased by " << fitnessDecrease << ". \n";
    hunger -= foodDecrease;
    fitness -= fitnessDecrease;
    happyChecker();
}



void DogClass::exercise() {
    /*
    Method for making the dog exercise.
    Picks a random exercise to do.

    Variables:
        workouts = Stores a list of random exercises to do.

        foodDecrease = Stores how much the hunger attribute 
                       will decrease by.
            
        fitnessIncrease = Stores how much the fitness will 
                          increase by.
    */
    vector<string> workouts = {"go for a walk", "go for a run",
                               "go for a swim", "dance", "play"};
    int foodDecrease = randomNumber(0, 21);
    int fitnessIncrease = randomNumber(0, 41) + 5;
    cout << "You " << workouts[randomNumber(0, workouts.size())] << " with " + name <<
            ". \nThe hunger bar has decreased by " << foodDecrease <<
            ". \nFitness also increased by " << fitnessIncrease << ". \n";
    fitness += fitnessIncrease;
    hunger -= foodDecrease;
    happyChecker();
}



void DogClass::talk() {
    /*
    Method to make the dog talk.
    Picks a random bark.

    Variables:
        barks = Stores random barks.

        foodDecrease = Stores how much the hunger attribute 
                       will decrease by.

        fitnessDecrease = Stores how much the fitness attribute 
                          will decrease by.
    */
    vector<string> barks = {"woof", "arf", "yap", "heh", "mlem"};
    cout << name << " says " << barks[randomNumber(0, barks.size())] << ". \n";
    int foodDecrease = randomNumber(0, 21);
    int fitnessDecrease = randomNumber(0, 21);
    cout << "The hunger bar has decreased by " << foodDecrease <<
            ". \nFitness also decreased by " << fitnessDecrease << ". \n";
    hunger -= foodDecrease;
    fitness -= fitnessDecrease;
    happyChecker();
}



void DogClass::happyChecker() {
    /*
    Checks how happy the dog is and makes changes to the happy 
    attribute accordingly.
        
    Variables:
        happyDecrease = Stores how much the happiness decreases by.

        happyIncrease = Stores how much the happiness increases by.
    */
    if (hunger > 80) {
        int happyDecrease = randomNumber(0, 41) + 5;
        cout << "You have overfed " << name << ". \nHappiness decreased by " << happyDecrease << ". \n";
        happiness -= happyDecrease;
    } else if (hunger < 10) {
        int happyDecrease = randomNumber(0, 21);
        cout << "You have underfed " << name << ". \nHappiness decreased by " << happyDecrease << ". \n";
        happiness -= happyDecrease;
    } else if (fitness > 90) {
        int happyDecrease = randomNumber(0, 41) + 5;
        cout << "You have worked " << name << " too hard. \nHappiness decreased by " << happyDecrease << ". \n";
        happiness -= happyDecrease;
    } else if (fitness < 10) {
        int happyDecrease = randomNumber(0, 21);
        cout << "You have not worked " << name << " hard enough. \nHappiness decreased by " << happyDecrease << ". \n";
        happiness -= happyDecrease;
    } else {
        int happyIncrease = randomNumber(0, 6);
        cout << "Happiness increased by " << happyIncrease;
        happiness += happyIncrease;
    }
}



void DogClass::activityCycle(string activity) {
    /*
    Condenses the code for picking an activity.

    Parameters:
        activity = Passes in the activity the user has chosen.
    */
    if (activity == "relax") {
        relax();
    } else if (activity == "exercise") {
        exercise();
    } else {
        talk();
    }
}



void DogClass::ageChecker() {
    /*
    Checks the age of the dog.
    */
    if (age > 10) {
        cout << name << " is over 10 years old. \r\nHe has lived a happy life and now is resting with the angels. \n";
        alive = false;
    }
}



void DogClass::healthChecker() {
    /*
    Checks if the dog is healthy and alive.
    */
    if (fitness > 100) {
        alive = false;
        cout << "You worked " << name << " too hard and he died of a heart attack. \n";
        cout << name << " is resting with the angels now. \n";
    } else if (fitness < 0) {
        alive = false;
        cout << "You did not do enough exercise and your dog died of obesity. \n";
        cout << name << " is resting with the angels now. \n";
    } else if (hunger > 100) {
        alive = false;
        cout << "You fed your dog too much and they died of obesity. \n";
        cout << name << " is resting with the angels now. \n";
    } else if (hunger < 0) {
        alive = false;
        cout << "You starved your dog and they died of obesity. \n";
        cout << name << " is resting with the angels now. \n";
    } else if (happiness > 200) {
        alive = false;
        cout << "Your dog got too happy and died of an overactive heart. \n";
        cout << name << " is resting with the angels now. \n";
    } else if (happiness < 0) {
        alive = false;
        cout << "Your dog was too sad and died. \n";
        cout << name << " is resting with the angels now. \n";
    }
}



int DogClass::randomNumber(int startNumber, int endNumber) {
    /*
    Retuens a random number between the start number and the end number.
    endNumber is exclusive not inclusive.
    For a range between 5 and 10, the start and end numbers would be 
    5 and 11, respectively.
    */
    srand(time(0));
    int randomNumber = startNumber + (rand() % (endNumber - startNumber));
    return randomNumber;
}