from DayClass import Day

class DogGame:
    """
    Class which runs the code for the dog game, after checking whether 
    the user wants to start a new game or continue where they left off.
    
    Methods:
        __init__ = Defines the initial conditions of the game, and runs it.        
    """



    def __init__(self):
        """
        Defines the initial conditions of the game, and runs it.

        Variables:
            use_save_file = Checks to see if the user wants to use 
                            the save file.
            
            valid_response = Stores whether the response was valid.
            
            self.simulation = Initialises the Day class.
        """
        use_save_file = None
        valid_response = False

        # Loops over till user gives valid response.
        while valid_response == False:
            valid_response = True
            print("Would you like to start a new game or continue where you left off?")
            use_save_file = input("(new/continue) \n")
            if use_save_file == "new" or use_save_file == "continue":
                self.simulation = Day(UseSaveFile = use_save_file)
            else:
                valid_response = False
                print("Invalid response, try again.")
        
        self.simulation.run()