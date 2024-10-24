import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {

        // Holds all lines from the animalNames txt file
        ArrayList<String> animalNamesLines = new ArrayList<>();


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("animalNames.txt"));
            // Will store the current line of animalNames.txt
            String currentNamesLine;


            // Reads animalNames.txt one line at a time
            while ((currentNamesLine = bufferedReader.readLine()) != null) {
                // Adds the current line to animalNamesLines Arraylist
                animalNamesLines.add(currentNamesLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Send animalsNamesArrayList to AnimalNameSorter to have names sorted by species
        AnimalNamesUtil.sortNames(animalNamesLines);

        // Initializes Arraylists to hold the Animal objects
        ArrayList<Animal> hyenas = new ArrayList<>();
        ArrayList<Animal> lions = new ArrayList<>();
        ArrayList<Animal> bears = new ArrayList<>();
        ArrayList<Animal> tigers = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("arrivingAnimals.txt"));
            // Holds the current line of arrivingAnimals.txt
            String arrivingAnimalLine;


            // read arrivingAnimals.txt one line at a time
            while ((arrivingAnimalLine = bufferedReader.readLine()) != null) {
                // Sends arrivingAnimalLine to AnimalFactory to make Animal object. Returns animal
                Animal animal = AnimalFactory.makeAnimal(arrivingAnimalLine);
                // adds the new animal to its respective Arraylist
                    switch (animal.getSpecies().toLowerCase()) {
                        case "hyena" -> hyenas.add(animal);
                        case "lion" -> lions.add(animal);
                        case "bear" -> bears.add(animal);
                        case "tiger" -> tigers.add(animal);
                    }
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Sends arraylist to AnimalReport to generate the animalReport text file
        AnimalReport.generateReport(hyenas, lions, bears, tigers);

    }
}