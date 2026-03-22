# trait and genetics stuff

from abc import ABC
from random import choice
from trait_data import HAIR_COLOR


punnett_table = {
16: ("4",), # AA x AA
12: ("4","3"), # AA x Aa
8: ("3",), # AA x aa
9: ("4","3","3","2"), # Aa x Aa
6: ("3","2"), # Aa x aa
4: ("2",) # aa x aa
}

# random genotype from mom + dad gene
# get random value from punnett square key
def randomize_value(key, dict):
    return choice(dict[key])

def split_gene(trait: int) -> list[int]:
    return [int(digit) for digit in str(trait)]

#take a parent gene, split into a list of ints, multiply the two lists together to get a list of crosses(keys for punnett_table)
#randomize a value for each cross, save as baby_gene_list
#concatenate list into string, return gene string as int -> baby genotype
def parent_cross(mom_gene: int, dad_gene: int) -> int:
    cross = [a1 * a2 for a1, a2 in zip((split_gene(mom_gene)),(split_gene(dad_gene)))]
    baby_gene_list = [randomize_value(gene, punnett_table) for gene in cross]
    return int("".join(baby_gene_list))

#iterate to match specific genotype w/ list(value), then match list(value) with key(phenotype)
def match_phenotype(genotype: int, trait_dict: dict[int,list]) -> str:
    values = trait_dict.values()
    for gene_value in values:
        for gene in gene_value:
            if genotype == gene:
                return next((key for key, value in trait_dict.items() if value == gene_value), None)

def randomize_phenotype(trait_dict: dict[int,list]) -> int:
    return choice(list(trait_dict.keys()))

class Trait(ABC):
    def __init__(self,genotype,phenotype):
        self.genotype = genotype
        self.phenotype = phenotype

    # getter equivalents
    def get_genotype(self):
        return self.genotype
    
    def get_phenotype(self):
        return self.phenotype
    
    # return genotype value from phenotype/genotype dict
    def set_genotype(trait_dict,phenotype):
        return trait_dict[phenotype]
    
    def set_phenotype():
        pass
    
    # not done
    # idk if this should be here
    def user_select_phenotype(trait_menu, phenotypes):
        print(trait_menu)
        entry = input("Please enter the number of your selection: ")
        if entry in phenotypes:
            return entry
        else:
            print("Invalid entry. Please try again")
