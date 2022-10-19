package primates;

import java.util.Objects;

/**
 * A monkey class to represent the monkey.
 */
public class Monkey {
  private final String name;
  private final Species species; // enum
  private final Sex sex;        //enum
  private final Size monSize;   // enum
  private final int weight;
  private final int age;
  private final Food favFood;   // enum

  private boolean quarantined;

  /**
   * Construct monkey with required parameters. include name, species, sex, size, weight, age, etc.
   *
   * @param name    name
   * @param species species
   * @param sex     sex
   * @param monSize monSize
   * @param weight  weight
   * @param age     age
   * @param favFood favFood
   * @throws IllegalArgumentException if required argument is not provided.
   */
  public Monkey(String name, Species species, Sex sex, Size monSize, int weight, int age,
      Food favFood) throws IllegalArgumentException {

    if (weight <= 0) {
      throw new IllegalArgumentException("Negative weight is not supported");
    }

    if (age <= 0) {
      throw new IllegalArgumentException("Negative age is not supported");
    }

    this.name = name;
    this.species = species;
    this.sex = sex;
    this.monSize = monSize;
    this.weight = weight;
    this.age = age;
    this.favFood = favFood;
    this.quarantined = false; // quarantined to be used for transferring from isolation to enc.
  }

  /**
   * Get the name of the monkey.
   *
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the species of the monkey.
   *
   * @return species
   */
  public Species getSpecies() {
    return this.species;
  }

  /**
   * Get the sex of the monkey.
   *
   * @return sex
   */
  public Sex getSex() {
    return this.sex;
  }

  /**
   * Get the size of the monkey.
   *
   * @return size
   */
  public Size getMonSize() {
    return this.monSize;
  }

  /**
   * Get the weight of the monkey.
   *
   * @return weight
   */
  public int getWeight() {
    return this.weight;
  }

  /**
   * Get the age of the monkey.
   *
   * @return age
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Get the favorite food of the monkey.
   *
   * @return favorite food
   */
  public Food getFavFood() {
    return this.favFood;
  }

  /**
   * Get if the monkey is quarantined.
   *
   * @return if monkey is quarantined
   */
  public boolean getQuarantined() {
    return this.quarantined;
  }

  /**
   * Set the new monkey as quarantined. ready for transporting to other places of the sanctuary.
   */
  public void setQuarantined() {
    this.quarantined = true;
  }

  @Override
  public String toString() {
    return String.format(
        this.name + "," + this.species + "," + this.sex + "," + this.monSize + "," + this.weight
            + "," + this.age + "," + this.favFood);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Monkey monkey = (Monkey) o;
    return weight == monkey.weight && age == monkey.age && name.equals(monkey.name)
        && species == monkey.species && sex == monkey.sex && monSize == monkey.monSize
        && favFood == monkey.favFood;
  }


  @Override
  public int hashCode() {
    return Objects.hash(name, species, sex, monSize, weight, age, favFood);
  }
}
