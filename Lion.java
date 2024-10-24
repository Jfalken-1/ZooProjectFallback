import java.time.LocalDate;

public class Lion extends Animal {
    private static int numOfLions;

    public Lion(int age, String sex, String species, String seasonBorn, String color, String weight, String origen, String name, String id, LocalDate birthDay) {
        super(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
        numOfLions++;
    }

    // Sound index will increment once before being called so it will start at 0. It will increment each time it's called, working through the Array
    static int soundIndex = -1;

    public String makeSound() {
        String[] lionSounds = new String[]{"Roar", "Grrr", "Raaaar", "Arrr"};
        soundIndex++;
        return lionSounds[soundIndex];
    }

    public static int getNumOfLions() {
        return numOfLions;
    }
}
