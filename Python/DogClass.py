import random

class Dog:
    """ 
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
    
    Class Variables:
        big_number_list = Stores a list of numbers for when big 
                          changes are required to the attributes.
        
        small_number_list = Stores a list of numbers for when small 
                            changes are required to the attributes.
        
        happy_number_list = Stores a list of numbers for when the 
                            happiness attribute needs to be changed.
    
    Methods:
        __init__ = Initialises the variables of the object.

        __str__ = Returns the status of the dog.

        feed = Feeds the dog.

        relax = Relax with the dog.

        exercise = Exercise the dog.

        talk = Gets the dog to talk.

        happy_checker = Checks how happy the dog is.

        activity_cycle = Makes the activity choosing segment more 
                         condensed.
        
        age_checker = Checks the age of the dog.

        health_checker = Checks the health of the dog.
    """

    big_number_list = list(range(5, 41))
    small_number_list = list(range(0, 21))
    happy_number_list = list(range(0, 6))



    def __init__(self, Name, Age, Fitness, Hunger, Happiness):
        """
        Defines the initial variables of the object.
        
        Variables:
            self.name = The name of the dog.

            self.age = Age of the dog.

            self.fitness = fitness of the dog.

            self.hunger = Hunger of the dog.

            self.happiness = Happiness of the dog.

            self.alive = Stores whether the dog is alive or not.
        """
        self.name = Name
        self.age = Age
        self.fitness = Fitness
        self.hunger = Hunger
        self.happiness = Happiness
        self.alive = "yes"



    def __str__(self):
        """
        Returns the status of the dog.
        """
        return f"Dog: {self.name}, Age: {self.age}, Fitness: {self.fitness}, Hunger: {self.hunger}, Happiness: {self.happiness}"


        
    def feed(self):
        """
        Runs the method to feed the dog.
        Picks a random item of food from the foods list and updates 
        the attributes.

        Variables:
            foods = Stores a list of foods.

            food_increase = Stores how much the hunger attribute 
                            will increase by.
            
            fitness_decrease = Stores how much the fitness attribute 
                               will decrease by.
        """
        foods = ["some cheese.", "some fruit.", "some dogfood.",
                 "a chicken burger? Why??", "a pizza slice.",
                 "a treat."
                 ]
        food_increase = random.choice(self.big_number_list)
        fitness_decrease = random.choice(self.small_number_list)

        print(f"You gave {self.name} {random.choice(foods)}.")
        print(f"The hunger bar has increased by {food_increase}.")
        print(f"{self.name} has not moved much. \nFitness decreased by {fitness_decrease}.")
        self.hunger += food_increase
        self.fitness -= fitness_decrease
        self.happy_checker()


    
    def relax(self):
        """
        Method for relaxing with the dog. 
        Picks a random relaxing task and updates the attributes.

        Variables:
            relaxation = Stores a list of things to do to relax.

            food_decrease = Stores how much the hunger attribute 
                            will decrease by.
            
            fitness_decrease = Stores how much the fitness attribute 
                               will decrease by.
        """
        relaxation = ["cuddle", "watch a movie", "cook",
                      "do yoga", "take selfies", "listen to music", "read"
                      ]
        food_decrease = random.choice(self.small_number_list)
        fitness_decrease = random.choice(self.small_number_list)

        print(f"You {random.choice(relaxation)} with {self.name}.")
        print(f"The hunger bar has decreased by {food_decrease}.")
        print(f"{self.name} has not been active. \nFitness decreased by {fitness_decrease}.")
        self.hunger -= food_decrease
        self.fitness -= fitness_decrease
        self.happy_checker()



    def exercise(self):
        """
        Method for making the dog exercise.
        Picks a random exercise to do.

        Variables:
            workouts = Stores a list of random exercises to do.

            food_decrease = Stores how much the hunger attribute 
                            will decrease by.
            
            fitness_increase = Stores how much the fitness will 
                               increase by.
        """
        workouts = ["go for a walk", "go for a run",
                    "go for a swim", "dance", "play"
                    ]
        food_decrease = random.choice(self.small_number_list)
        fitness_increase = random.choice(self.big_number_list)

        print(f"You {random.choice(workouts)} with {self.name}.")
        print(f"The hunger bar has decreased by {food_decrease}.")
        print(f"The fitness bar has increased by {fitness_increase}.")
        self.fitness += fitness_increase
        self.hunger -= food_decrease
        self.happy_checker()



    def talk(self):
        """
        Method to make the dog talk.
        Picks a random bark.

        Variables:
            barks = Stores random barks.

            food_decrease = Stores how much the hunger attribute 
                            will decrease by.

            fitness_decrease = Stores how much the fitness attribute 
                               will decrease by.
        """
        barks = ["woof", "arf", "yap", "heh", "mlem"]
        print("{0} says {1} {1} {1}.".format(self.name, random.choice(barks)))
        food_decrease = random.choice(self.small_number_list)
        fitness_decrease = random.choice(self.small_number_list)

        print(f"The hunger bar has decreased by {food_decrease}.")
        print(f"{self.name} has been lazy. \nFitness decreased by {fitness_decrease}.")
        self.hunger -= food_decrease
        self.fitness -= fitness_decrease
        self.happy_checker()



    def happy_checker(self):
        """
        Checks how happy the dog is and makes changes to the happy 
        attribute accordingly.
        
        Variables:
            happy_decrease = Stores how much the happiness decreases by.

            happy_increase = Stores how much the happiness increases by.
        """
        if self.hunger > 80:
            happy_decrease = random.choice(self.big_number_list)
            print(f"You have overfed {self.name}.")
            print(f"Happiness decreased by {happy_decrease}.")
            self.happiness -= happy_decrease
        elif self.hunger < 10:
            happy_decrease = random.choice(self.small_number_list)
            print(f"You have underfed {self.name}.")
            print(f"Happiness decreased by {happy_decrease}.")
            self.happiness -= happy_decrease
        elif self.fitness > 90:
            happy_decrease = random.choice(self.big_number_list)
            print(f"You have worked {self.name} too hard.")
            print(f"Happiness decreased by {happy_decrease}.")
            self.happiness -= happy_decrease
        elif self.fitness < 10:
            happy_decrease = random.choice(self.small_number_list)
            print(f"You have not worked {self.name} hard enough.")
            print(f"Happiness decreased by {happy_decrease}.")
            self.happiness -= happy_decrease
        else:
            happy_increase = random.choice(self.happy_number_list)
            print(f"Happiness has increased by {happy_increase}.")
            self.happiness += happy_increase



    def activity_cycle(self, activity):
        """
        Condenses the code for picking an activity.

        Parameters:
            activity = Passes in the activity the user has chosen.
        """
        if activity == "relax":
            self.relax()
        elif activity == "exercise":
            self.exercise()
        else:
            self.talk()



    def age_checker(self):
        """
        Checks the dog's age.
        """
        if self.age > 10:
            print(f"{self.name} is over 10 years old. \nHe has lived a happy life and now is resting with the angels.")
            self.alive = "no"



    def health_checker(self):
        """
        Checks if the dog is healthy and alive.
        """
        if self.fitness > 100:
            self.alive = "no"
            print(f"You worked {self.name} too hard and he died of a heart attack.")      
        elif self.fitness < 0:
            self.alive = "no"
            print(f"You didn't exercise {self.name} enough and he died of obesity.")       
        elif self.hunger > 100:
            self.alive = "no"
            print(f"You fed {self.name} too much food and he died of obesity.")          
        elif self.hunger < 0:
            self.alive = "no"
            print(f"You fed {self.name} too little food and he died of starvation.")         
        elif self.happiness > 200:
            self.alive = "no"
            print(f"You made {self.name} too happy and he died of an overactive heart.")
        elif self.happiness < 0:
            self.alive = "no"
            print(f"You did not make {self.name} happy and he died of sadness.")
            
        if self.alive == "no":
            print(f"{self.name} is resting with the angels now.")