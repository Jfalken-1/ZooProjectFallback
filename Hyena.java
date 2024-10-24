import java.time.LocalDate;

public class Hyena extends Animal {
    private static int numOfHyenas;

    public Hyena(int age, String sex, String species, String seasonBorn, String color, String weight, String origen, String name, String id, LocalDate birthDay) {
        super(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
        numOfHyenas++;
    }
    // Sound index will increment once before being called so it will start at 0. It will increment each time it's called, working through the Array
    static int soundIndex = -1;

    public String makeSound() {
        String[] hyenaSounds = new String[]{"haha", "hehe", "kekeke", "Gnah-gnah"};
        soundIndex++;
        return hyenaSounds[soundIndex];
    }

    public static int getNumOfHyenas() {
        return numOfHyenas;
    }
}


