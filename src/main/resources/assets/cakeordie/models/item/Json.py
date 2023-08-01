Item = [
  "invitation",
  "color_paper",
  "pinata_stick",
  "color_cannon",
  "super_sugar",
  "chili_crop",
  "chili_sauce",
  "candy",
  "meat",
  "apple_pie",
  "eggnog",
  "coco_drink",
  "soda_water",
  "plant",
  "pinata",
  "bowl",
  "choco_bowl",
  "eggnog_bowl",
  "cake_random_block",
  "chocolate_cake_block",
  "chili_cake_block",
  "apple_cake_block",
  "random_cake",
  "chocolate_cake",
  "chili_cake",
  "apple_cake",
  "exploding_cale"
]

for NameHelper in Item:
    Icon = '''\
{
  "parent": "item/generated",
  "textures": {
    "layer0": "cakeordie:item/%s"
  }
}\
'''%NameHelper

    with open('./%s.json'%NameHelper, 'w') as json:
        json.write(Icon)

