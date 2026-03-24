from traits.trait_functions import Trait
import os
from random import choice


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