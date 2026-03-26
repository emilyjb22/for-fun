# Choice 1 in main menu -> create person
# print menu
# get variables
# make person
# save person

from random import choice
from people.person import random_fname, random_lname

def create_person():
    print( """
        Let's create your person.
            
        Biologically speaking, is your person male or female? Please enter "M" for male, "F" for female, or "R" to randomize
        """)
    sex, pronoun = get_sex()
    print(f"Great! Your person is {sex}")

    print(f"""
            Please enter your new person's name, or type "r" to randomize
            """)
    first_name = get_first_name(sex)
    print(f"Your person's name is {first_name}")

    print(f"""
            Please enter your new person's last name, or type "r" to randomize
            """)
    last_name = get_last_name()

    print(f"Great! Your person's name is {first_name} {last_name}.")




def get_sex():
    entry = input("Biological sex: ").lower()
    match entry:
        case "f":
            sex = "female"
        case "m":
            sex = "male"
        case "r":
            sex = choice(("male","female"))
    if sex == "female":
        pronoun = "her"
    else: pronoun = "his"
    return sex, pronoun

# randomize or enter first name
# def get_name(message, sex):
#     first_name = input("First name: ").lower()
#     if first_name == "r":
#         first_name = random_fname(sex)
#     return(first_name[0].upper() + first_name[1:])

def get_first_name(sex):
    name = input("First name: ").lower()
    if name == "r":
        name = random_fname(sex)
    return name[0].upper() + name[1:]

def get_last_name():
    name = input("Last name: ").lower()
    if name == "r":
        name = random_lname()
    return name[0].upper() + name[1:]


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

                