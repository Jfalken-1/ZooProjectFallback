import java.time.LocalDate;

public class Animal {
    private static int numOfAnimals;
   private final int age;
   private final String sex;
   private final String species;
   private final String seasonBorn;
   private final String color;
   private final String weight;  // Corrected typo
   private final String origen;
   private final String name;
   private final String id;
   private final LocalDate birthDay;

    public Animal(int age, String sex, String species, String seasonBorn, String color, String wight, String origen, String name, String id, LocalDate birthDay) {
        this.age = age;
        this.sex = sex;
        this.species = species;
        this.seasonBorn = seasonBorn;
        this.color = color;
        this.weight = wight;
        this.origen = origen;
        this.name = name;
        this.id = id;
        this.birthDay = birthDay;
        numOfAnimals++;
    }

    public int getAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public String getSpecies() {
        return species;
    }
    public String getSeasonBorn() {
        return seasonBorn;
    }
    public String getColor() {
        return color;
    }
    public String getWeight() {
        return weight;
    }
    public String getOrigen() {
        return origen;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String makeSound() {
        return "";
    }

    public static int getNumOfAnimals() {
        return numOfAnimals;
    }
}
