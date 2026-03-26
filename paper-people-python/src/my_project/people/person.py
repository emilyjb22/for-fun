from traits.trait_functions import Trait
from people.name_data import MALE_NAMES, FEMALE_NAMES, SURNAMES, WEIGHTS
from random import choice, choices


class Person:
    def __init__(self,first_name,last_name,sex,hair,eyes,mom,dad):
        self.first_name = first_name
        self.last_name = last_name
        self.sex = sex
        self.hair = hair
        self.eyes = eyes
        self.mom = mom
        self.dad = dad

    def __str__(self):
        return f"Name: {self.first_name} {self.last_name}, Sex: {self.sex}, Hair Color: {self.hair}, Eye Color: {self.eyes}"

def default_parent(first_name,sex):
    Default_Hair = Trait("brown",333)
    Default_Eyes = Trait("amber",33)
    return Person(first_name,"Paper",sex,Default_Hair,Default_Eyes,"none","none")

def random_fname(sex):
    if sex == "male":
        name = choice(MALE_NAMES)
    else:
        name = choice(FEMALE_NAMES)
    return name

def random_lname():
    name = choices(SURNAMES, weights=WEIGHTS, k=1)
    return name[0]
