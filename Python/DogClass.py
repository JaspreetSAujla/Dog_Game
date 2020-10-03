import time
import random

class Dog:
    """ 
    A class which creates dog objects and gives them their behaviours.
    Contains a feed, relax, exercise and talk methods. These are the activities the dog can do.
    Also checks how happy the dog is, as well as the age and health.
    """

    bigNumList = list(range(5, 41))
    smallNumList = list(range(0, 21))
    happyNumList = list(range(0, 6))
    alive = "yes"

    #Sets the initial parameters.
    def __init__(self, Name, Age, Fitness, Hunger, Happiness):
        self.name = Name
        self.age = Age
        self.fitness = Fitness
        self.hunger = Hunger
        self.happiness = Happiness

    #Describes the instance of the class.
    def __str__(self):
        return "Dog: {0}, Age: {1}, Fitness: {2}, Hunger: {3}, Happiness: {4}".format(self.name, self.age, self.fitness, self.hunger, self.happiness)
        
    #Describes the different things you can feed your dog and changes the stats randomly in accordance to the action.
    def feed(self):
        foods = ["some cheese.", "some fruit.", "some dogfood.",
                 "a chicken burger? Why??", "a pizza slice.",
                 "a treat."
                 ]
        foodInc = random.choice(self.bigNumList)
        fitnessDec = random.choice(self.smallNumList)
        print("You gave", self.name, random.choice(foods))
        print("The hunger bar has increased by {0}.".format(foodInc))
        print("{0} has not moved much. \nFitness decreased by {1}.".format(self.name, fitnessDec))
        self.hunger += foodInc
        self.fitness -= fitnessDec
        self.happyChecker()
    
    #This method describes the relax option and also changes the dog's stats.
    def relax(self):
        relaxation = ["cuddle", "watch a movie", "cook",
                      "do yoga", "take selfies", "listen to music", "read"
                      ]
        foodDec = random.choice(self.smallNumList)
        fitnessDec = random.choice(self.smallNumList)
        print("You {0} with {1}.".format(random.choice(relaxation), self.name))
        print("The hunger bar has decreased by {0}.".format(foodDec))
        print("{0} has not been active. \nFitness decreased by {1}.".format(self.name, fitnessDec))
        self.hunger -= foodDec
        self.fitness -= fitnessDec
        self.happyChecker()

    #This method describes the exercise option and changes the stats.
    def exercise(self):
        workouts = ["go for a walk", "go for a run",
                    "go for a swim", "dance", "play"
                    ]
        foodDec = random.choice(self.smallNumList)
        fitnessInc = random.choice(self.bigNumList)
        print("You {0} with {1}.".format(random.choice(workouts), self.name))
        print("The hunger bar has decreased by {0}.".format(foodDec))
        print("The fitness bar has increased by {0}.".format(fitnessInc))
        self.fitness += fitnessInc
        self.hunger -= foodDec
        self.happyChecker()

    #This method makes the dog talk.
    def talk(self):
        barks = ["woof", "arf", "yap", "heh", "mlem"]
        print("{0} says {1} {1} {1}.".format(self.name, random.choice(barks)))
        foodDec = random.choice(self.smallNumList)
        fitnessDec = random.choice(self.smallNumList)
        print("The hunger bar has decreased by {0}.".format(foodDec))
        print("{0} has been lazy. \nFitness decreased by {1}.".format(self.name, fitnessDec))
        self.hunger -= foodDec
        self.fitness -= fitnessDec
        self.happyChecker()

    #This method checks the happiness of the dog.
    def happyChecker(self):
        if self.hunger > 80:
            happyDec = random.choice(self.bigNumList)
            print("You have overfed {0}.".format(self.name))
            print("Happiness decreased by {0}.".format(happyDec))
            self.happiness -= happyDec
        elif self.hunger < 10:
            happyDec = random.choice(self.smallNumList)
            print("You have underfed {0}.".format(self.name))
            print("Happiness decreased by {0}.".format(happyDec))
            self.happiness -= happyDec
        elif self.fitness > 90:
            happyDec = random.choice(self.bigNumList)
            print("You have worked {0} too hard.".format(self.name))
            print("Happiness decreased by {0}.".format(happyDec))
            self.happiness -= happyDec
        elif self.fitness < 10:
            happyDec = random.choice(self.smallNumList)
            print("You have not worked {0} hard enough.".format(self.name))
            print("Happiness decreased by {0}.".format(happyDec))
            self.happiness -= happyDec
        else:
            happyInc = random.choice(self.happyNumList)
            print("Happiness has increased by {0}.".format(happyInc))
            self.happiness += happyInc

    #This function makes the activites code more condensed because it is repeated.
    def activityCycle(self, activity):
        if activity == "relax" or activity == "Relax":
            self.relax()
        elif activity == "exercise" or activity == "Exercise":
            self.exercise()
        else:
            self.talk()

    #This method checks the dogs age.
    def ageChecker(self):
        if self.age > 10:
            print("{0} is over 10 years old. \nHe has lived a happy life and now is resting with the angels.".format(self.name))
            self.alive = "no"

    #This method checks if the dog is healthy and alive.
    def healthChecker(self):
        if self.fitness > 100:
            self.alive = "no"
            print("You worked {0} too hard and he died of a heart attack.".format(self.name))
            print(self.name, "is resting with the angels now.")
        elif self.fitness < 0:
            self.alive = "no"
            print("You didn't exercise", self.name, "enough and he died of obesity.")
            print(self.name, "is resting with the angels now.")
        elif self.hunger > 100:
            self.alive = "no"
            print("You fed", self.name, "too much food and he died of obesity.")
            print(self.name, "is resting with the angels now.")
        elif self.hunger < 0:
            self.alive = "no"
            print("You fed", self.name, "too little food and he died of starvation.")
            print(self.name, "is resting with the angels now.")
        elif self.happiness > 200:
            self.alive = "no"
            print("You made", self.name, "too happy and he died of an overactive heart.")
            print(self.name, "is resting with the angels now.")
        elif self.happiness < 0:
            self.alive = "no"
            print("You did not make", self.name, "happy and he died of sadness.")
            print(self.name, "is resting with the angels now.")