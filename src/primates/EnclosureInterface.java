package primates;

import java.util.ArrayList;

/**
 * This is the interface class for the enclosure to implement the required features.
 */
public interface EnclosureInterface {
  /**
   * Get the current enclosure's species. Because the closure can only have one type.
   *
   * @return Species of the Monkeys
   */
  Species getCurrEnclosureSpecies();

  /**
   * Get the list of monkeys in the current enclosure. The list of monkeys should be the same type.
   *
   * @return list of monkeys
   */
  ArrayList<Monkey> getMonkeyList();

  /**
   * Get the current enclosure's capacity.
   * The capacity is predetermined when construct the sanctuary.
   *
   * @return current enclosure's capacity
   */
  int getCurrEnclosureCapacity();

  /**
   * Add a quarantined monkey from the isolation to the enclosure of the sanctuary.
   *
   * @param monkey monkey to be added
   * @throws IllegalArgumentException if monkey is not a required type of data
   */
  void addMonkey(Monkey monkey) throws IllegalArgumentException;

}
