package primates;

/**
 * This is the interface JungleFriends for the implementation of sanctuary.
 */
public interface JungleFriends {

  /**
   * Report the species that are currently being housed in {alphabetical} order. The list should
   * include where in the sanctuary each species is (both in enclosures and in isolation).
   *
   * @return String about Species information
   */
  String reportSpecies();

  /**
   * Look up where a particular species is currently housed. If none of a particular species is
   * currently being housed, it should report this fact.
   *
   * @param species species of the sanctuary
   * @return String about Species location information
   */
  String lookUp(Species species) throws IllegalArgumentException; // Species -- location

  /**
   * Produce a sign for a given enclosure that lists each individual monkey that is currently housed
   * there. For each individual monkey, the sign should include their name, sex, and favorite food.
   *
   * @param enclosure enclosure of the sanctuary
   * @return String of sign about enclosure information
   */
  String produceSign(Enclosure enclosure) throws IllegalArgumentException;

  /**
   * Produce an alphabetical list (by name) of all the monkeys housed in the Sanctuary. This
   * information should include where each monkey can be found.
   *
   * @return String about monkey distribution information
   */
  String produceMonkeyList(); // toString() in Monkey

  /**
   * Produce a shopping list of the favorite foods of the inhabitants of the Sanctuary. For each
   * food listed, the quantity needed should also be listed. Large monkeys should receive 500 grams
   * of their favourite food while medium and small monkeys require 300 grams and 100 grams,
   * respectively.
   *
   * @return String about food to buy information
   */
  String produceShoppingList();

  /**
   * Add an isolation to sanctuary. Because isolation is a must for building a sanctuary.
   *
   * @param isolation isolation of the sanctuary
   * @throws IllegalArgumentException if isolation is not required type
   */
  void addIsolationToSanctuary(Isolation isolation) throws IllegalArgumentException;

  /**
   * Add the enclosure to sanctuary. Because enclosure is a must for building a sanctuary.
   *
   * @param enclosure enclosure of the sanctuary
   * @throws IllegalArgumentException if enclosure is not required type
   */
  void addEnclosureToSanctuary(Enclosure enclosure) throws IllegalArgumentException;
}
