from DayClass import Day

if __name__ == "__main__":
    #Allows the player to either start new or continue where they left off.
    print("Would you like to start a new game or continue where you left off?")
    useSaveFile = input("(new/continue) \n")
    simulation = Day(useSaveFile)

    #Loops the game as long as the dog is healthy.
    while simulation.doggy.alive == "yes":
        simulation.morning_segment()
        if simulation.doggy.alive == "no":
            break
        simulation.afternoon_segment()
        if simulation.doggy.alive == "no":
            break
        simulation.evening_segment()
        if simulation.doggy.alive == "no":
            break
        simulation.extra_activity()
        if simulation.doggy.alive == "no":
            break
        simulation.day_conclusion()
    print("Thank you for playing")