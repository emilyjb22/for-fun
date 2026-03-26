import os
#from random import choice

def _load_names(file_name, name_type):
    script_dir = os.path.dirname(os.path.abspath(__file__))
    path = os.path.join(script_dir, file_name)
    with open(path, 'r') as n:
        names = []
        for line in n:
            if name_type == "first":
                names.append(line.strip())
            elif name_type == "last":
                name, weight = line.strip().split()
                name = name.strip(",")
                names.append((name, float(weight)))
            else:
                print("Error")
    return names

_weighted_surnames = _load_names("surnames.txt","last")

MALE_NAMES = _load_names("male_names.txt","first")
FEMALE_NAMES = _load_names("female_names.txt","first")
SURNAMES, WEIGHTS = zip(*_weighted_surnames)

# import csv

# script_dir = os.path.dirname(os.path.abspath(__file__))
# csv_path = os.path.join(script_dir, "Names_2010Census.csv")
# with open(csv_path, 'r') as f:
#     reader = csv.reader(f.readlines()[1:10001])
#     names_list = list(reader)
# raw_surnames = []
# raw_weights = []
# for entry in names_list:
#     raw_surnames.append(entry[0])
# for weight in names_list:
#     raw_weights.append(weight[11])

# surnames = []
# weights = []
# for name in raw_surnames:
#     name = name[0] + name[1:].lower()
#     surnames.append(name)
# for weight in raw_weights:
#     weight = round((float(weight) * 1000),4)
#     weights.append(weight)
# weighted_names = list(zip(surnames,weights))

# print(weighted_names[0:5])

# path2 = os.path.join(script_dir, "surnames.txt")
# with open(path2, 'w') as m:
#     for name in weighted_names:
#         formatted_name = ', '.join(map(str, name))
#         m.write(f"{formatted_name}\n")

# path3 = os.path.join(script_dir, "female_names.txt")
# with open(path3, 'w') as f:
#     for name in female_names:
#         name = name[0].upper() + name[1:].lower()
#         f.write(f"{name}\n")