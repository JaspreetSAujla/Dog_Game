import time
import random
import numpy as np
from DogClass import Dog

class Day:
    """
    A class which highlights the different parts of the day.
    Allows the player to pick a dog.
    Also saves the game regularly.
    """

    jim = Dog("Jim", 3, 34, 47, 60)
    rover = Dog("Rover", 5, 68, 39, 74)
    jack = Dog("Jack", 4, 73, 29, 68)
    russell = Dog("Russell", 8, 37, 19, 35)
    maddie = Dog("Maddie", 6, 47, 76, 48)
    chloe = Dog("Chloe", 1, 23, 28, 48)

    Data = None
    DataIn = None


    #Defines the initial variables.
    def __init__(self, useSaveFile):
        self.use_save_file = useSaveFile
        self.doggy = None
        #Tries to find a save file.
        if self.use_save_file == "continue":
            try:
                Day.DataIn = np.load("SaveFile.npy", allow_pickle=True)
                self.doggy = Day.DataIn[0]
                print("SAVE FILE FOUND. \nContinuing the game.")
            except:
                print("There was no save file detected. \nStarting a new game...")
                self.start_game()
        elif self.use_save_file == "new":
            self.start_game()
        Day.Data = [self.doggy]


    #Defines the start of the game.
    def start_game(self):
        #Introduces the game and allows user to pick a dog.
        print("Hello! Welcome to your very own virtual pet dog simulator.")
        print("Pick a dog to get started.")
        print("{0} \n{1} \n{2} \n{3} \n{4} \n{5}".format(Day.jim, Day.rover, Day.jack, Day.russell, Day.maddie, Day.chloe))
        doggyChoice = input("(jim/rover/jack/russell/maddie/chloe) \n")
        if doggyChoice == "jim" or doggyChoice == "Jim":
            self.doggy = Day.jim
        elif doggyChoice == "jack" or doggyChoice == "Jack":
            self.doggy = Day.jack
        elif doggyChoice == "russell" or doggyChoice == "Russell":
            self.doggy = Day.russell
        elif doggyChoice == "maddie" or doggyChoice == "Maddie":
            self.doggy = Day.maddie
        elif doggyChoice == "chloe" or doggyChoice == "Chloe":
            self.doggy = Day.chloe
        else:
            self.doggy = Day.rover
        print("Your dog is called {0}, and is {1} years old. \n{0} says woof.".format(self.doggy.name, self.doggy.age))


    #Defines the morning segement.
    def morning_segment(self):
        print("You wake up in the morning with {0} laying next to you.".format(self.doggy.name))
        print("It is breakfast time and this is how your dog is doing: \n", self.doggy)
        print("What would you like to do with {0}?".format(self.doggy.name))
        activity = input("(feed/relax/exercise/talk) \n")
        if activity == "feed" or activity == "Feed":
            self.doggy.feed()
        else:
            self.doggy.activityCycle(activity)
        print(self.doggy)
        self.doggy.healthChecker()


    #Defines the afternoon segment.
    def afternoon_segment(self):
        print("It is now the afternoon; the weather is great outside. \nWhat would you like to do?")
        activity = input("(relax/exercise/talk) \n")
        self.doggy.activityCycle(activity)
        print(self.doggy)
        self.doggy.healthChecker()


    #This defines the evening segment.
    def evening_segment(self):
        print("Time has passed to the evening. {0} is very excited.".format(self.doggy.name))
        print("What will you do with {0}?".format(self.doggy.name))
        activity = input("(feed/relax/exercise/talk) \n")
        if activity == "feed" or activity == "Feed":
            self.doggy.feed()
        else:
            self.doggy.activityCycle(activity)
        print(self.doggy)
        self.doggy.healthChecker()


    #Defines code for extra activity.
    def extra_activity(self):
        print("There is time to do one more thing! \n{0} is wagging their tail.".format(self.doggy.name))
        print("What do you do?")
        activity = input("(relax/exercise/talk) \n")
        self.doggy.activityCycle(activity)
        print(self.doggy)
        self.doggy.healthChecker()


    #Defines the end of the day and saves the game.
    def day_conclusion(self):
        print("It is the end of the day. \nYou and {0} both go to bed together.".format(self.doggy.name))
        Day.Data[0] = self.doggy
        self.doggy.age += 0.2
        self.doggy.ageChecker()
        np.save("SaveFile", Day.Data, allow_pickle=True)
        print("PROGRESS HAS BEEN SAVED. \nFeel free to quit.")