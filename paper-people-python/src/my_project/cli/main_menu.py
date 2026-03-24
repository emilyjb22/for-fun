from random import choice
from traits.trait_functions import randomize_phenotype, randomize_value, Trait
from traits.trait_data import HAIR_COLOR, EYE_COLOR
from people.person import Person, default_parent

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
                create_person()
                

            case 2:
                print("Have a baby")
            case 3:
                print("View your population")
            case 4:
                print("Do statistics")
            case 5:
                print("end program")
