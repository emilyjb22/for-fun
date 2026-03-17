#-------------------------------------------------------------------------------
#Author: Emily Brereton
#Project: Paper People Python Project
#Date: 3/16/26
#Module: Main
#Description: Main Module
#-------------------------------------------------------------------------------

#main menu
def main():

    print("""
            --------------------------------------------------------
                    Paper People Project
            --------------------------------------------------------
                A simulation using simple Mendelian inheritance
            --------------------------------------------------------
            """)
    
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
    
    main_menu_choice = int(input("Enter a command: "))

    while main_menu_choice != 5:
        match main_menu_choice:
            case 1:
                print("Create a Person")
            case 2:
                print("Have a baby")
            case 3:
                print("View your population")
            case 4:
                print("Do statistics")
            case 5:
                print("end program")

if __name__ == "__main__":
    main()