package Java;
import java.util.Random;

public class DogClass {
    String alive = "yes";

    String name;
    Double age;
    int fitness;
    int hunger;
    int happiness;
    Random ranNum = new Random();

    DogClass(String Name, Double Age, int Fitness, int Hunger, int Happiness) {
        this.name = Name;
        this.age = Age;
        this.fitness = Fitness;
        this.hunger = Hunger;
        this.happiness = Happiness;
    }

    public void description() {
        System.out.println("Name: " + this.name + ", Age: " + Double.toString(this.age) + ", Fitness: " + Integer.toString(this.fitness) + ", Hunger: " + Integer.toString(this.hunger) + ", Happiness: " + Integer.toString(this.happiness));
    }

    public void feed() {
        String[] food = {"some cheese.", "some fruit.", "some dogfood.",
                        "a chicken burger? Why??", "a pizza slice.",
                        "a treat."};
        int FoodInc = ranNum.nextInt(41) + 5;
        int FitnessDec = ranNum.nextInt(21);
        System.out.println("You gave " + this.name + " " + food[ranNum.nextInt(food.length)] 
                            + ". \r\nThe hunger bar has increased by " + Integer.toString(FoodInc)
                            + ". \r\n" + this.name + " has not moved much. \r\nFitness decreased by "
                            + Integer.toString(FitnessDec) + ".");
        this.hunger += FoodInc;
        this.fitness -= FitnessDec;
        this.happyChecker();
    }

    public void relax() {
        String[] relaxtion = {"cuddle", "watch a movie", "cook",
                            "do yoga", "take selfies", "listen to music", "read"};
        int FoodDec = ranNum.nextInt(21);
        int FitnessDec = ranNum.nextInt(21);
        System.out.println("You " + relaxtion[ranNum.nextInt(relaxtion.length)] + " with " + this.name
                        + ". \r\nThe hunger bar has decreased by " + Integer.toString(FoodDec)
                        + ". \r\nFitness also decreased by " + Integer.toString(FitnessDec) + ".");
        this.hunger -= FoodDec;
        this.fitness -= FitnessDec;
        this.happyChecker();
    }

    public void exercise() {
        String[] workouts = {"go for a walk", "go for a run",
                            "go for a swim", "dance", "play"};
        int FoodDec = ranNum.nextInt(21);
        int FitnessInc = ranNum.nextInt(41) + 5;
        System.out.println("You " + workouts[ranNum.nextInt(workouts.length)] + " with " + this.name
                        + ". \r\nThe hunger bar has decreased by " + Integer.toString(FoodDec)
                        + ". \r\nFitness also increased by " + Integer.toString(FitnessInc) + ".");
        this.fitness += FitnessInc;
        this.hunger -= FoodDec;
        this.happyChecker();
    }

    public void talk() {
        String[] barks = {"woof", "arf", "yap", "heh", "mlem"};
        System.out.println(this.name + " says " + barks[ranNum.nextInt(barks.length)] + ".");
        int FoodDec = ranNum.nextInt(21);
        int FitnessDec = ranNum.nextInt(21);
        System.out.println("The hunger bar has decreased by " + Integer.toString(FoodDec)
                        + ". \r\nFitness also decreased by " + Integer.toString(FitnessDec) + ".");
        this.hunger -= FoodDec;
        this.fitness -= FitnessDec;
        this.happyChecker();
    }

    public void happyChecker() {
        if (this.hunger > 80) {
            int HappyDec = ranNum.nextInt(41) + 5;
            System.out.println("You have overfed " + this.name 
                            + ". \r\nHappiness decreased by " + Integer.toString(HappyDec) + ".");
            this.happiness -= HappyDec;
        } else if (this.hunger < 10) {
            int HappyDec = ranNum.nextInt(21);
            System.out.println("You have underfed " + this.name 
                            + ". \r\nHappiness decreased by " + Integer.toString(HappyDec) + ".");
            this.happiness -= HappyDec;
        } else if (this.fitness > 90) {
            int HappyDec = ranNum.nextInt(41) + 5;
            System.out.println("You have worked " + this.name 
                            + " too hard. \r\nHappiness decreased by " + Integer.toString(HappyDec) + ".");
            this.happiness -= HappyDec;
        } else if (this.fitness < 10) {
            int HappyDec = ranNum.nextInt(21);
            System.out.println("You have not worked " + this.name 
                            + " hard enough. \r\nHappiness decreased by " + Integer.toString(HappyDec) + ".");
            this.happiness -= HappyDec;
        } else {
            int HappyInc = ranNum.nextInt(6);
            System.out.println("Happiness increased by " + HappyInc);
            this.happiness += HappyInc;
        }
    }

    public void activityCycle(String Activity) {
        if (Activity.equals("relax") || Activity.equals("Relax")) {
            this.relax();
        } else if (Activity.equals("exercise") || Activity.equals("Exercise")) {
            this.exercise();
        } else {
            this.talk();
        }
    }

    public void ageChecker() {
        if (this.age > 10) {
            System.out.println(this.name + " is over 10 years old. \r\nHe has lived a happy life and now is resting with the angels.");
        }
    }

    public void healthChecker() {
        if (this.fitness > 100) {
            this.alive = "no";
            System.out.println("You worked " + this.name + " too hard and he died of a heart attack.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.fitness < 0) {
            this.alive = "no";
            System.out.println("You did not do enough exercise and your dog died of obesity.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.hunger > 100) {
            this.alive = "no";
            System.out.println("You fed your dog too much and they died of obesity.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.hunger < 0) {
            this.alive = "no";
            System.out.println("You starved your dog and they died of obesity.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.happiness > 200) {
            this.alive = "no";
            System.out.println("Your dog got too happy and died of an overactive heart.");
            System.out.println(this.name + " is resting with the angels now.");
        } else if (this.happiness < 0) {
            this.alive = "no";
            System.out.println("Your dog was too sad and died.");
            System.out.println(this.name + " is resting with the angels now.");
        }
    }
}