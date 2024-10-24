import java.time.LocalDate;

public class Tiger extends Animal{
    private static int numOfTigers;
    public Tiger (int age, String sex, String species, String seasonBorn, String color, String weight, String origen, String name, String id, LocalDate birthDay) {
        super(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
        numOfTigers++;
    }

    // soundIndex will increment once before method is called so it will start at 0. It will increment each time it's called, working through the Array
    static int soundIndex = -1;

    public String makeSound() {
        String[] tigerSounds = new String[]{"Raaargh", "Chuff", "Growl", "Snarl"};
        soundIndex++;
        return tigerSounds[soundIndex];
    }

    public static int getNumOfTigers() {
        return numOfTigers;
    }
}

