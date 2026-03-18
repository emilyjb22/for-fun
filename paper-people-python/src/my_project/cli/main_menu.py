def run_main_menu():
    choice = 0
    while choice != 5:
        print(("""
                --------------------------------------------------------
                        Paper People Project
                --------------------------------------------------------
                    A simulation using simple Mendelian inheritance
                --------------------------------------------------------
                """))
        print("""
                --------------------------------------------------------
                Menu:
                1.  Create a New Person
                2.  Have a Baby
                3.  View Your Population
                4.  View Allele Frequencies
                5.  Exit
                --------------------------------------------------------
                """)  
        choice = int(input("Enter a command: "))
        match choice:
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

def create_person():
    print("""
          Let's create your person.
          
          Biologically speaking, is your person male or female? Please enter M for male, F for female, or R to randomize"
          """)
    sex = input("Biological sex: ").lower()
