public class AnimalParser {
    // Once split, age sex and species all have a consistent location
    public static int findAge(String line) {
        String[] section1Array = section1Array(line);
        return Integer.parseInt(section1Array[0]);
    }
    public static String findSex(String line) {
        String[] section1Array = section1Array(line);
        return section1Array[3];
    }
    public static String findSpecies(String line) {
        String[] section1Array = section1Array(line);
        return  section1Array[4];
    }
    // Season born is consistent but needs switch
    public static String findSeasonBorn(String line) {
        String[] section2Array = section2Array(line);
        String seasonBorn;

        switch (section2Array[3].toLowerCase()) {
            case "spring" -> seasonBorn = "Spring";
            case "summer" -> seasonBorn = "Summer";
            case "fall" -> seasonBorn = "Fall";
            case "winter" -> seasonBorn = "Winter";
            default -> seasonBorn = "Unknown";
        }
        return seasonBorn;
    }
    // Gets color from the substring starting at the first character of the array that contains color and ending on the last character
    public static String findColor (String line) {
        String[] lineArray = lineArray(line);
        return lineArray[2].substring(1, lineArray[2].indexOf("color") - 1);
    }
    // Weight location is consistent
    public static String findWeight(String line) {
        String[] lineArray = lineArray(line);
        return lineArray[3].substring(1);
    }
    // Origen always is two parts separated by a comma, so all that is needed is to combine the last two places in the array and add a literal comma
    public static String findOrigen(String line) {
        String[] lineArray = lineArray(line);
        return lineArray[4].substring(6) + "," + lineArray[5];
    }

    // Methods to split the lines
    public static String[] section1Array(String line) {
        String[] lineArray = lineArray(line);
        return lineArray[0].split(" ");
    }
    public static String[] section2Array(String line) {
        String[] lineArray = lineArray(line);
        return lineArray[1].split(" ");
    }
    public static String[] lineArray (String line) {
        return line.split(",");
    }
}
