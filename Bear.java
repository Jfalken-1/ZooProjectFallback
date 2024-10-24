import java.time.LocalDate;

public class Bear extends Animal {
    private static int numOfBears;
    public Bear (int age, String sex, String species, String seasonBorn, String color, String weight, String origen, String name, String id, LocalDate birthDay) {
        super(age, sex, species, seasonBorn, color, weight, origen, name, id, birthDay);
        numOfBears++;
    }

    static int soundIndex = -1;

    public String makeSound() {
        String[] bearSounds = new String[]{"Grrf", "Rawrf", "Hrumph", "Gronk"};
        soundIndex++;
        return bearSounds[soundIndex];
    }

    public static int getNumOfBears() {
        return numOfBears;
    }


}
