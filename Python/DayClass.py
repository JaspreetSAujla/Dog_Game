import numpy as np
from DogClass import Dog

class Day:
    """
    A class which highlights the different parts of the day.
    Allows the player to pick a dog.
    Also saves the game regularly.

    Attributes:
        UseSaveFile = Stores whether the user wants to start a new 
                      game or continue from an old one.
    
    Class Variables:
        jim,...,chloe = Instances of all the different dogs that 
                        are playable.
        
        DataOut = Stores the data about the dog to be saved into a 
                  file.
        
        DataIn = Stores the data from the save file to be used in the 
                 game.
    
    Methods:
        __init__ = Defines the initial variables and sets up the game.

        start_game = Allows the user to pick a dog.

        run = Runs the game.

        morning_segment = Defines the morning segment of the day.

        afternoon_segment = Defines the afternoon segment of the day.

        evening_segment = Defines the evening segment of the day.

        extra_activity = Defines the extra activity at the end of the day.

        day_conclusion = Increases age of the dog and saves the game.
    """

    jim = Dog("Jim", 3, 34, 47, 60)
    rover = Dog("Rover", 5, 68, 39, 74)
    jack = Dog("Jack", 4, 73, 29, 68)
    russell = Dog("Russell", 8, 37, 19, 35)
    maddie = Dog("Maddie", 6, 47, 76, 48)
    chloe = Dog("Chloe", 1, 23, 28, 48)

    DataOut = None
    DataIn = None



    def __init__(self, UseSaveFile):
        """
        Initialises the variables.
        Tries to find a save file to start a game.
        If not, then starts a new game.
        
        Variables:
            self.use_save_file = Stores whether the user wants to 
                                 continue where they left off or not.
            
            self.doggy = Stores which dog is picked.
        """
        self.use_save_file = UseSaveFile
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
        Day.DataOut = [self.doggy]



    def start_game(self):
        """
        Starts the game and allows the user to pick a dog.
        
        Variables:
            doggy_choice = Stores the choice the user made.

            valid_response = Stores whether the response was valid.
        """
        doggy_choice = None
        valid_response = False

        #Introduces the game and allows user to pick a dog.
        print("Hello! Welcome to your very own virtual pet dog simulator.")
        print("Pick a dog to get started.")
        print(f"{Day.jim} \n{Day.rover} \n{Day.jack} \n{Day.russell} \n{Day.maddie} \n{Day.chloe}")

        while valid_response == False:
            valid_response = True
            doggy_choice = input("(jim/rover/jack/russell/maddie/chloe) \n")
            if doggy_choice == "jim":
                self.doggy = Day.jim
                print("yes")
            elif doggy_choice == "jack":
                self.doggy = Day.jack
            elif doggy_choice == "russell":
                self.doggy = Day.russell
            elif doggy_choice == "maddie":
                self.doggy = Day.maddie
            elif doggy_choice == "chloe":
                self.doggy = Day.chloe
            elif doggy_choice == "rover":
                self.doggy = Day.rover
            else:
                valid_response = False
                print("Invalid choice, try again.")
        print(f"Your dog is called {self.doggy.name}, and is {self.doggy.age} years old. \n{self.doggy.name} says woof.")


    
    def run(self):
        """
        Runs the code for the whole day.
        """
        while self.doggy.alive == True:
            self.morning_segment()
            if self.doggy.alive == False:
                break
            self.afternoon_segment()
            if self.doggy.alive == False:
                break
            self.evening_segment()
            if self.doggy.alive == False:
                break
            self.extra_activity()
            if self.doggy.alive == False:
                break
            self.day_conclusion()
        print("Thank you for playing.")



    def morning_segment(self):
        """
        Defines the morning segment of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            valid_response = Stores whether the response was valid.
        """
        activity = None
        valid_response = False

        print(f"You wake up in the morning with {self.doggy.name} laying next to you.")
        print(f"It is breakfast time and this is how your dog is doing: \n{self.doggy}")
        print(f"What would you like to do with {self.doggy.name}?")

        while valid_response == False:
            valid_response = True
            activity = input("(feed/relax/exercise/talk) \n")
            if activity == "feed":
                self.doggy.feed()
            elif activity == "relax" or activity == "exercise" or activity == "talk":
                self.doggy.activity_cycle(activity = activity)
            else:
                valid_response = False
                print("Invalid response, try again.")
        print(self.doggy)
        self.doggy.health_checker()



    def afternoon_segment(self):
        """
        Defines the afternoon segment of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            valid_response = Stores whether the response was valid.
        """
        activity = None
        valid_response = False
        print("It is now the afternoon; the weather is great outside. \nWhat would you like to do?")

        while valid_response == False:
            valid_response = True
            activity = input("(relax/exercise/talk) \n")
            if activity == "relax" or activity == "exercise" or activity == "talk":    
                self.doggy.activity_cycle(activity = activity)
            else:
                valid_response = False
                print("Invalid response, try again.")
        print(self.doggy)
        self.doggy.health_checker()



    def evening_segment(self):
        """
        Defines the evening segment of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            valid_response = Stores whether the response was valid.
        """
        activity = None
        valid_response = False
        print(f"Time has passed to the evening. {self.doggy.name} is very excited.")
        print(f"What will you do with {self.doggy.name}?")

        while valid_response == False:
            valid_response = True
            activity = input("(feed/relax/exercise/talk) \n")
            if activity == "feed":
                self.doggy.feed()
            elif activity == "relax" or activity == "exercise" or activity == "talk":
                self.doggy.activity_cycle(activity = activity)
            else:
                valid_response = False
                print("Invalid response, try again.")
        print(self.doggy)
        self.doggy.health_checker()



    def extra_activity(self):
        """
        Defines the code for the extra activity at the end of the day.
        User picks an activity to do with their dog.
        
        Variables:
            activity = Stores the activity the user wants to do.

            valid_response = Stores whether the response was valid.
        """
        activity = None
        valid_response = False
        print(f"There is time to do one more thing! \n{self.doggy.name} is wagging their tail.")
        print("What do you do?")

        while valid_response == False:
            valid_response = True
            activity = input("(relax/exercise/talk) \n")
            if activity == "relax" or activity == "exercise" or activity == "talk":    
                self.doggy.activity_cycle(activity = activity)
            else:
                valid_response = False
                print("Invalid response, try again.")
        print(self.doggy)
        self.doggy.health_checker()



    def day_conclusion(self):
        """
        Increases the dog's age and saves the data to a file.
        """
        print(f"It is the end of the day. \nYou and {self.doggy.name} both go to bed together.")
        Day.DataOut[0] = self.doggy
        self.doggy.age += 0.2
        self.doggy.age_checker()
        np.save("SaveFile", Day.DataOut, allow_pickle=True)
        print("PROGRESS HAS BEEN SAVED. \nFeel free to quit.")