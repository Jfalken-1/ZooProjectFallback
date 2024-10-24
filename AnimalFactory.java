import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

public class AnimalFactory {
    public static Animal makeAnimal(String arrivingAnimalLine) {
        // Sends the arrivingAnimalLine to animalParser to get the fields
        int age = AnimalParser.findAge(arrivingAnimalLine);
        String sex = AnimalParser.findSex(arrivingAnimalLine);
        String species = AnimalParser.findSpecies(arrivingAnimalLine);
        String seasonBorn = AnimalParser.findSeasonBorn(arrivingAnimalLine);
        String color = AnimalParser.findColor(arrivingAnimalLine);
        String weight = AnimalParser.findWeight(arrivingAnimalLine);
        String origen = AnimalParser.findOrigen(arrivingAnimalLine);
        // Uses species field to get the current corresponding name from the Arraylists in AnimalNamesUtil
        String name = AnimalNamesUtil.nameAnimal(species);
        // Uses species field to generate a unique ID
        String id = makeID(species);
        // Uses age and season born fields to generate a random birthday within the given season
        LocalDate birthDay = generateBirthday(age, seasonBorn);

        Animal animal = null;

        // Constructor makes new animal based on species field
        switch (species) {
            case "hyena" -> animal = new Hyena(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
            case "lion" -> animal = new Lion(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
            case "bear" -> animal = new Bear(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
            case "tiger" -> animal = new Tiger(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
        }
        // Returns animal to app
        return animal;
    }

    /*
    Generates unique ID. Uses substring to get the first two letters of species for ID letter. If less than 10 animals of that species
     exist ID number will be 0 + numOfAnimals, if 10 or more exist than it will only be numOfAnimals
     */

    public static String makeID(String species) {
        String id = "";
        switch (species) {
            case "hyena":
                if (Hyena.getNumOfHyenas() < 10) {
                    id = species.substring(0, 2) + "0" + (Hyena.getNumOfHyenas() + 1);
                } else id = species.substring(0, 2) + (Hyena.getNumOfHyenas() + 1);
                break;
            case "lion":
                if (Lion.getNumOfLions() < 10) {
                    id = species.substring(0, 2) + "0" + (Lion.getNumOfLions() + 1);
                } else id = species.substring(0, 2) + (Lion.getNumOfLions() + 1);
                break;
            case "bear":
                if (Bear.getNumOfBears() < 10) {
                    id = species.substring(0, 2) + "0" + (Bear.getNumOfBears() + 1);
                } else id = species.substring(0, 2) + (Bear.getNumOfBears() + 1);
                break;
            case "tiger":
                if (Tiger.getNumOfTigers() < 10) {
                    id = species.substring(0, 2) + "0" + (Tiger.getNumOfTigers() + 1);
                } else id = species.substring(0, 2) + (Tiger.getNumOfTigers() + 1);
                break;
        }
        return id;
    }


    // Gets birth year from current year - age.
    public static LocalDate generateBirthday(int age, String seasonBorn) {
        Random random = new Random();
        int currentYear = LocalDate.now().getYear();
        int birthYear = currentYear - age;
        int birthMonth = 0;
        int dayOfBirth;
        int monthPicker = random.nextInt(3);

        // Birth month is selected by monthPicker, which will be a random number between 1 and 3 to represent the months within the season born.
        switch (seasonBorn.toLowerCase()) {
            case "spring":
                if (monthPicker == 0) {
                    birthMonth = Month.MARCH.getValue();
                } else if (monthPicker == 1) {
                    birthMonth = Month.APRIL.getValue();
                } else {
                    birthMonth = Month.MAY.getValue();
                }
                break;
            case "summer":
                if (monthPicker == 0) {
                    birthMonth = Month.JUNE.getValue();
                } else if (monthPicker == 1) {
                    birthMonth = Month.JULY.getValue();
                } else {
                    birthMonth = Month.AUGUST.getValue();
                }
                break;
            case "fall":
                if (monthPicker == 0) {
                    birthMonth = Month.SEPTEMBER.getValue();
                } else if (monthPicker == 1) {
                    birthMonth = Month.OCTOBER.getValue();
                } else {
                    birthMonth = Month.NOVEMBER.getValue();
                }
                break;
            case "winter":
                if (monthPicker == 0) {
                    birthMonth = Month.DECEMBER.getValue();
                } else if (monthPicker == 1) {
                    birthMonth = Month.JANUARY.getValue();
                } else {
                    birthMonth = Month.FEBRUARY.getValue();
                }
                break;
                // May require two hours to remember that one of the seasons in the file is unknown and that's why it threw errors no matter what you do.
            case "unknown":
                return null;
        }
        // dayOfBirth equals a random day within the length of each month
        dayOfBirth = switch (birthMonth) {
            case 1, 3, 5, 7, 8, 10, 12 -> random.nextInt(31) + 1;
            case 4, 6, 9, 11 -> random.nextInt(30) + 1;
            case 2 -> random.nextInt(28) + 1;
            default -> throw new IllegalArgumentException("Invalid month: " + birthMonth);
        };

        return LocalDate.of(birthYear, birthMonth, dayOfBirth);
    }
}

