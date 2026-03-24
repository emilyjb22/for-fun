import os
from random import choice

def _load_names(file_name):
    script_dir = os.path.dirname(os.path.abspath(__file__))
    path = os.path.join(script_dir, file_name)
    names = []
    with open(path, 'r') as n:
        for name in n:
            names.append(name.strip())
    return names

MALE_NAMES = _load_names("male_names.txt")
FEMALE_NAMES = _load_names("female_names.txt")
#LAST_NAMES = _load_names("last_names.txt")


# def random_name(sex):
#     script_dir = os.path.dirname(os.path.abspath(__file__))
#     names = []
#     if sex == "MALE":
#         path = os.path.join(script_dir, "male_names.txt")
#     else:
#         path = os.path.join(script_dir,"female_names.txt")
#     with open(path, 'r') as n:
#         for name in n:
#             name = name.replace("\n", "")
#             names.append(name)
#     return choice(names)


# import csv
# import os

# script_dir = os.path.dirname(os.path.abspath(__file__))
# csv_path = os.path.join(script_dir, "Popular_Baby_Names.csv")
# with open(csv_path, 'r') as f:
#     reader = csv.reader(f)
#     first_names_list = list(reader)
# male_names = []
# female_names = []
# for name in first_names_list:
#     if name[1] == "MALE":
#         male_names.append(name[3])
#     else:
#         female_names.append(name[3])

# path2 = os.path.join(script_dir, "male_names.txt")
# with open(path2, 'w') as m:
#     for name in male_names:
#         name = name[0].upper() + name[1:].lower()
#         m.write(f"{name}\n")

# path3 = os.path.join(script_dir, "female_names.txt")
# with open(path3, 'w') as f:
#     for name in female_names:
#         name = name[0].upper() + name[1:].lower()
#         f.write(f"{name}\n")