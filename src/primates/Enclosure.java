package primates;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is an Enclosure class to represent one of the housing option in the Sanctuary.
 */
public class Enclosure implements EnclosureInterface {
  private final ArrayList<Monkey> monkeyList;
  private Species species;
  private int currEnclosureCapacity;

  /**
   * Construct an enclosure using the capacity.
   *
   * @param currEnclosureCapacity capacity of the enclosure
   */
  public Enclosure(int currEnclosureCapacity) {
    this.monkeyList = new ArrayList<>();
    this.species = null;
    this.currEnclosureCapacity = currEnclosureCapacity;
  }

  /**
   * Get the species and only species of the enclosure.
   *
   * @return species
   */
  public Species getCurrEnclosureSpecies() {
    return this.species;
  }

  /**
   * Get the current monkey list in the enclosure.
   *
   * @return a list of monkeys
   */
  public ArrayList<Monkey> getMonkeyList() {
    return this.monkeyList;
  }

  /**
   * Get the current enclosure's capacity.
   *
   * @return the capacity
   */
  public int getCurrEnclosureCapacity() {
    return this.currEnclosureCapacity;
  }

  /**
   * Add a monkey to the enclosure.
   *
   * @param monkey monkey to be added
   * @throws IllegalArgumentException if the monkey is not a required type or capacity limit
   *                                  reached
   */
  public void addMonkey(Monkey monkey) throws IllegalArgumentException {
    if (monkey.getSpecies() != getCurrEnclosureSpecies() && getCurrEnclosureSpecies() != null) {
      throw new IllegalArgumentException(
          "Species mismatch, " + "can't add this monkey to this enclosure.");
    }
    if (!monkey.getQuarantined()) {
      throw new IllegalArgumentException("Quarantined required, need to go to Isolation first.");
    }
    HashMap<Size, Integer> monkeySizeToInteger = new HashMap<>();
    monkeySizeToInteger.put(Size.SMALL, 2);
    monkeySizeToInteger.put(Size.MEDIUM, 5);
    monkeySizeToInteger.put(Size.LARGE, 10);

    if (monkeySizeToInteger.get(monkey.getMonSize()) <= getCurrEnclosureCapacity()) {
      this.monkeyList.add(monkey);
      this.species = monkey.getSpecies();
      this.currEnclosureCapacity -= monkeySizeToInteger.get(monkey.getMonSize());
    } else {
      throw new IllegalArgumentException("Space limited, can't add this monkey to this enclosure.");
    }
  }

  /**
   * To return a string representation of the enclosure.
   *
   * @return string representation of the enclosure
   */
  @Override
  public String toString() {
    return "Enclosure ID:" + hashCode() + " {" + "monkeyList=" + monkeyList + ", species=" + species
        + ", currEnclosureCapacity=" + currEnclosureCapacity + '}';
  }
}
