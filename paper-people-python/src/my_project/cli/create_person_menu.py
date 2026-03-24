# Choice 1 in main menu -> create person
# print menu
# get variables
# make person
# save person

from random import choice

menu1 = """
        Let's create your person.
          
        Biologically speaking, is your person male or female? Please enter "M" for male, "F" for female, or "R" to randomize
        """

print(f"Great! Your person is {sex}")

print("""
    Please give your person a name, or type "r" to randomize
    """)

print(f"Your person's name is {first_name} {last_name}")

def get_sex():
    entry = input("Biological sex: ").lower()
    match entry:
        case "f":
            sex = "female"
        case "m":
            sex = "male"
        case "r":
            sex = choice(("male","female"))
    pronoun = "her" if sex == "female" else pronoun = "his"
    return sex, pronoun

def get_name():
    first_name = input("First name: ").lower()
        # if first_name == "r":
            # randomize_value() #make function
    last_name = input("Last name: ").lower()
        # if last_name == "r":
            # randomize_value() #make function
    return first_name, last_name

def get_traits(first_name, pronoun):
    print(f"Next, we're going to give {first_name} {pronoun} traits. Would you like to randomize their traits, or select their traits manually?")
    print("""
        1. Randomize
        2. Select Manually
        """)
    entry = int(input("Enter a command: "))
    if entry == 1: 
        pass
        # randomize_traits()
    elif entry == 2:
        pass
        #select_traits()
    else: print("Invalid option. Please try again") #make better function. Raise...
    

                    # hair_pheno = randomize_phenotype(HAIR_COLOR)
                    # hair_geno = randomize_value(hair_pheno,HAIR_COLOR)
                    # Hair_Color = Trait(hair_geno,hair_pheno)

                    # eye_pheno = randomize_phenotype(EYE_COLOR)
                    # eye_geno = randomize_value(eye_pheno,EYE_COLOR)
                    # Eye_Color = Trait(eye_geno,eye_pheno)

                    # p = Person(first_name,last_name,sex,Hair_Color,Eye_Color,"no dad","no mom")
                    # print(f"Congratulations! Your person is {first_name} {last_name}. They are {sex} and have {hair_pheno} hair and {eye_pheno} eyes.")

def save_person(first_name, person, sex):
    print(f"Do you want to save {first_name} to your population? y/n")
    c = input("Enter a command: ")
    if c.lower() == "y":
        if {sex} == "male":
            pass
            #save to males
        else:
            pass
            #save to females

                