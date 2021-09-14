package Java;

import java.util.Random;

public class DogClass {
    /**
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
        randomNumber = Used to generate random numbers for attributes.
    
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
    */
    public boolean alive;
    public String name;
    public Double age;
    public int fitness;
    public int hunger;
    public int happiness;
    private Random randomNumber = new Random();



    DogClass(String Name, Double Age, int Fitness, int Hunger, int Happiness) {
        /**
        Defines the initial variables of the object.
        
        Variables:
            this.name = The name of the dog.

            this.age = Age of the dog.

            this.fitness = fitness of the dog.

            this.hunger = Hunger of the dog.

            this.happiness = Happiness of the dog.

            this.alive = Stores whether the dog is alive or not.
        */
        this.name = Name;
        this.age = Age;
        this.fitness = Fitness;
        this.hunger = Hunger;
        this.happiness = Happiness;
        this.alive = true;
    }



    public void description() {
        /**
        Prints out the status of the dog.
        */
        System.out.println("Name: " + this.name + ", Age: " + Double.toString(this.age) + 
                           ", Fitness: " + Integer.toString(this.fitness) + ", Hunger: " + 
                           Integer.toString(this.hunger) + ", Happiness: " + 
                           Integer.toString(this.happiness));
    }



    public void feed() {
        /**
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
        String[] food = {"some cheese.", "some fruit.", "some dogfood.",
                        "a chicken burger? Why??", "a pizza slice.",
                        "a treat."};
        int foodIncrease = randomNumber.nextInt(41) + 5;
        int fitnessDecrease = randomNumber.nextInt(21);
        System.out.println("You gave " + this.name + " " + food[randomNumber.nextInt(food.length)] 
                            + ". \r\nThe hunger bar has increased by " + Integer.toString(foodIncrease)
                            + ". \r\n" + this.name + " has not moved much. \r\nFitness decreased by "
                            + Integer.toString(fitnessDecrease) + ".");
        this.hunger += foodIncrease;
        this.fitness -= fitnessDecrease;
        this.happyChecker();
    }



    public void relax() {
        /**
        Method for relaxing with the dog. 
        Picks a random relaxing task and updates the attributes.

        Variables:
            relaxation = Stores a list of things to do to relax.

            foodDecrease = Stores how much the hunger attribute 
                           will decrease by.
            
            fitnessDecrease = Stores how much the fitness attribute 
                              will decrease by.
        */
        String[] relaxtion = {"cuddle", "watch a movie", "cook",
                            "do yoga", "take thisies", "listen to music", "read"};
        int foodDecrease = randomNumber.nextInt(21);
        int fitnessDecrease = randomNumber.nextInt(21);
        System.out.println("You " + relaxtion[randomNumber.nextInt(relaxtion.length)] + " with " + this.name
                        + ". \r\nThe hunger bar has decreased by " + Integer.toString(foodDecrease)
                        + ". \r\nFitness also decreased by " + Integer.toString(fitnessDecrease) + ".");
        this.hunger -= foodDecrease;
        this.fitness -= fitnessDecrease;
        this.happyChecker();
    }



    public void exercise() {
        /**
        Method for making the dog exercise.
        Picks a random exercise to do.

        Variables:
            workouts = Stores a list of random exercises to do.

            foodDecrease = Stores how much the hunger attribute 
                           will decrease by.
            
            fitnessIncrease = Stores how much the fitness will 
                              increase by.
        */
        String[] workouts = {"go for a walk", "go for a run",
                            "go for a swim", "dance", "play"};
        int foodDecrease = randomNumber.nextInt(21);
        int fitnessIncrease = randomNumber.nextInt(41) + 5;
        System.out.println("You " + workouts[randomNumber.nextInt(workouts.length)] + " with " + this.name
                        + ". \r\nThe hunger bar has decreased by " + Integer.toString(foodDecrease)
                        + ". \r\nFitness also increased by " + Integer.toString(fitnessIncrease) + ".");
        this.fitness += fitnessIncrease;
        this.hunger -= foodDecrease;
        this.happyChecker();
    }



    public void talk() {
        /**
        Method to make the dog talk.
        Picks a random bark.

        Variables:
            barks = Stores random barks.

            foodDecrease = Stores how much the hunger attribute 
                           will decrease by.

            fitnessDecrease = Stores how much the fitness attribute 
                              will decrease by.
        */
        String[] barks = {"woof", "arf", "yap", "heh", "mlem"};
        System.out.println(this.name + " says " + barks[randomNumber.nextInt(barks.length)] + ".");
        int foodDecrease = randomNumber.nextInt(21);
        int fitnessDecrease = randomNumber.nextInt(21);
        System.out.println("The hunger bar has decreased by " + Integer.toString(foodDecrease)
                        + ". \r\nFitness also decreased by " + Integer.toString(fitnessDecrease) + ".");
        this.hunger -= foodDecrease;
        this.fitness -= fitnessDecrease;
        this.happyChecker();
    }



    private void happyChecker() {
        /**
        Checks how happy the dog is and makes changes to the happy 
        attribute accordingly.
        
        Variables:
            happyDecrease = Stores how much the happiness decreases by.

            happyIncrease = Stores how much the happiness increases by.
        */
        if (this.hunger > 80) {
            int happyDecrease = randomNumber.nextInt(41) + 5;
            System.out.println("You have overfed " + this.name 
                            + ". \r\nHappiness decreased by " + Integer.toString(happyDecrease) + ".");
            this.happiness -= happyDecrease;
        } else if (this.hunger < 10) {
            int happyDecrease = randomNumber.nextInt(21);
            System.out.println("You have underfed " + this.name 
                            + ". \r\nHappiness decreased by " + Integer.toString(happyDecrease) + ".");
            this.happiness -= happyDecrease;
        } else if (this.fitness > 90) {
            int happyDecrease = randomNumber.nextInt(41) + 5;
            System.out.println("You have worked " + this.name 
                            + " too hard. \r\nHappiness decreased by " + Integer.toString(happyDecrease) + ".");
            this.happiness -= happyDecrease;
        } else if (this.fitness < 10) {
            int happyDecrease = randomNumber.nextInt(21);
            System.out.println("You have not worked " + this.name 
                            + " hard enough. \r\nHappiness decreased by " + Integer.toString(happyDecrease) + ".");
            this.happiness -= happyDecrease;
        } else {
            int happyIncrease = randomNumber.nextInt(6);
            System.out.println("Happiness increased by " + happyIncrease);
            this.happiness += happyIncrease;
        }
    }



    public void activityCycle(String activity) {
        /**
        Condenses the code for picking an activity.

        Parameters:
            activity = Passes in the activity the user has chosen.
        */
        if (activity.equals("relax")) {
            this.relax();
        } else if (activity.equals("exercise")) {
            this.exercise();
        } else {
            this.talk();
        }
    }



    public void ageChecker() {
        /**
        Checks the age of the dog.
        */
        if (this.age > 10) {
            System.out.println(this.name + " is over 10 years old. \r\nHe has lived a happy life and now is resting with the angels.");
            this.alive = false;
        }
    }



    public void healthChecker() {
        /**
        Checks if the dog is healthy and alive.
        */
        if (this.fitness > 100) {
            this.alive = false;
            System.out.println("You worked " + this.name + " too hard and he died of a heart attack.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.fitness < 0) {
            this.alive = false;
            System.out.println("You did not do enough exercise and your dog died of obesity.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.hunger > 100) {
            this.alive = false;
            System.out.println("You fed your dog too much and they died of obesity.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.hunger < 0) {
            this.alive = false;
            System.out.println("You starved your dog and they died of obesity.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.happiness > 200) {
            this.alive = false;
            System.out.println("Your dog got too happy and died of an overactive heart.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.happiness < 0) {
            this.alive = false;
            System.out.println("Your dog was too sad and died.");
            System.out.println(this.name + " is resting with the angels now.");
        }
    }
}