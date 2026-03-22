from random import choice
from trait.trait_functions import randomize_phenotype
from trait.trait_data import HAIR_COLOR

def run_main_menu():
    selection = 0
    while selection != 5:
        print(("""
            ------------------------------------------------------------------
                                Paper People Project
            ------------------------------------------------------------------
                    A simulation using simple Mendelian inheritance
            ------------------------------------------------------------------
                """))
        print("""
            ------------------------------------------------------------------
                Menu:
                    1.  Create a New Person
                    2.  Have a Baby
                    3.  View Your Population
                    4.  View Allele Frequencies
                    5.  Exit
            ------------------------------------------------------------------
                """)  
        selection = int(input("Enter a command: "))
        match selection:
            case 1:
                #create_person()
                print("""
          Let's create your person.
          
          Biologically speaking, is your person male or female? Please enter "M" for male, "F" for female, or "R" to randomize
          """)
                entry = input("Biological sex: ").lower()
                match entry:
                    case "f":
                        sex = "female"
                    case "m":
                        sex = "male"
                    case "r":
                        sex = choice(("male","female"))
                print(f"Great! Your person is {sex}")

                print("""
            Please give your person a name, or type "r" to randomize
                      """)
                first_name = input("First name: ").lower()
                # if first_name == "r":
                #     randomize_value() #make function
                last_name = input("Last name: ").lower()
                # if last_name == "r":
                #     randomize_value() #make function
                
                print(f"Your person's name is {first_name} {last_name}")

                print(f"Next, we're going to give {first_name} their traits. Would you like to randomize their traits, or select their traits manually?")
                print("""
                      1. Randomize
                      2. Select Manually
                      """)
                entry = int(input("Enter a command: "))
                if entry == 1:
                    hair_pheno = randomize_phenotype(HAIR_COLOR)
                    hair_geno = ""
                elif entry == 2: 
                    pass #make function
                else: print("Invalid option. Please try again") #make better function. Raise...?
                
                
            case 2:
                print("Have a baby")
            case 3:
                print("View your population")
            case 4:
                print("Do statistics")
            case 5:
                print("end program")
