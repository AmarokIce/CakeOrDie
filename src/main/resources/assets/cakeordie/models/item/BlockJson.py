Item = [
    "plant",
    "pinata",
    "chili_crop",
    "bowl",
    "choco_bowl",
    "eggnog_bowl",
    "random_cake",
    "chocolate_cake",
    "chili_cake",
    "apple_cake",
    "cake_random_block",
    "chocolate_cake_block",
    "chili_cake_block",
    "apple_cake_block"
]

for NameHelper in Item:
    Icon = '''\
{
  "parent": "cakeordie:block/%s"
}\
'''%NameHelper

    with open('./%s.json'%NameHelper, 'w') as json:
        json.write(Icon)