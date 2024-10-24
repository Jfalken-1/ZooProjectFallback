# Design Document

- animalNames.txt is imported with BufferedReader. 
- All the raw lines are fed into an Arraylist called animalNamesLines.
- animalNamesLines is sent to AnimalNamesUtil.
- animalNamesLines is parsed to get only the names, which are stored in different Arrays for each species.
- arrivingAnimals.txt is imported and read line by line.
- Each line is sent to the makeAnimal method in AnimalFactory.
- Fields are made by sending the arrivingAnimalLine to the AnimalParser class, which has methods to parse all fields except name, ID and birthday.
- A name is assigned with the nameAnimal method in AnimalNamesUtil.
- ID is made with makeID method in AnimalFactory using species field and NumOfAnimal.
- Birthday is made with generateBirthday method in AnimalFactory using age and seasonBorn.
- When all fields are stored a switch and constructors are used to make new Animal based off species field.
- Animal is returned to App.
- Animal is sorted into ArrayList list based off its species.
- Animal report is generated.
