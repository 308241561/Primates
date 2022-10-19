package primates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * This is the sanctuary class which will serve as a main holder to host the monkeys.
 */
public class Sanctuary implements JungleFriends {
  private final ArrayList<Isolation> isolationList;
  private int isolationLimit;
  private final ArrayList<Enclosure> enclosureList;
  private int enclosureLimit;

  /**
   * Construct the sanctuary with the isolation list limit enclosure list limit.
   *
   * @param isolationList  isolationList
   * @param isolationLimit isolationLimit
   * @param enclosureList  enclosureList
   * @param enclosureLimit enclosureLimit
   * @throws IllegalArgumentException if not providing the required arguments
   */
  public Sanctuary(ArrayList<Isolation> isolationList, int isolationLimit,
      ArrayList<Enclosure> enclosureList, int enclosureLimit) throws IllegalArgumentException {
    if (isolationList == null) {
      throw new IllegalArgumentException("Isolations are a must in the sanctuary.");
    }
    if (enclosureList == null) {
      throw new IllegalArgumentException("Enclosures are a must in the sanctuary.");
    }
    this.isolationList = isolationList;
    this.isolationLimit = isolationLimit;
    this.enclosureList = enclosureList;
    this.enclosureLimit = enclosureLimit;
  }


  @Override
  public String reportSpecies() {
    HashMap<Species, String> speciesDistribution = calcSpeciesDistribution(isolationList,
        enclosureList);
    TreeMap<Species, String> sorted = new TreeMap<>(speciesDistribution);

    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<Species, String> entry : sorted.entrySet()) {
      Species key = entry.getKey();
      String value = entry.getValue();
      stringBuilder.append(key).append(":").append(value).append(" ");
    }
    return "Reporting species " + stringBuilder;
  }


  @Override
  public String lookUp(Species species) throws IllegalArgumentException {
    if (species == null) {
      throw new IllegalArgumentException("species provided is invalid.");
    }

    HashMap<Species, String> speciesDistribution = calcSpeciesDistribution(isolationList,
        enclosureList);

    if (speciesDistribution.containsKey(species)) {
      return "Looked up species " + species + ", found them in " + speciesDistribution.get(species)
          + ".";
    } else {
      return "Looked up species " + species + ", found none in the Sanctuary.";
    }
  }


  @Override
  public String produceSign(Enclosure enclosure) throws IllegalArgumentException {

    StringBuilder stringBuilder = new StringBuilder();

    for (Enclosure e : enclosureList) {
      if (e.getMonkeyList() == null) {
        break;
      }
      if (e == enclosure) {
        for (Monkey m : e.getMonkeyList()) {
          stringBuilder.append(m.getName()).append("-").append(m.getSex()).append("-")
              .append(m.getFavFood());
        }
      }
      return "Produced sign for the enclosure：" + stringBuilder;
    }
    throw new IllegalArgumentException("No enclosure found.");
  }


  @Override
  public String produceMonkeyList() {
    ArrayList<String> monkeyNameList = new ArrayList<>();

    for (Isolation i : isolationList) {
      if (i.getCurrMonkey() == null) {
        continue;
      }
      monkeyNameList.add(i.getCurrMonkey().getName() + " : isolation");
    }

    for (Enclosure e : enclosureList) {
      for (Monkey m : e.getMonkeyList()) {
        monkeyNameList.add(m.getName() + " : enclosure");
      }
    }

    Collections.sort(monkeyNameList);
    return "Produced monkeys list: " + monkeyNameList;
  }


  @Override
  public String produceShoppingList() {
    ArrayList<Monkey> monkeyList = new ArrayList<>();

    for (Isolation i : isolationList) {
      if (i.getCurrMonkey() != null) {
        monkeyList.add(i.getCurrMonkey());
      }
    }

    for (Enclosure e : enclosureList) {
      if (e.getMonkeyList() != null) {
        monkeyList.addAll(e.getMonkeyList());
      }
    }

    HashMap<Food, Integer> shoppingList = new HashMap<>();
    for (Monkey m : monkeyList) {
      if (m.getMonSize() == Size.SMALL) {
        shoppingList.put(m.getFavFood(), shoppingList.getOrDefault(m.getFavFood(), 0) + 100);
      }
      if (m.getMonSize() == Size.MEDIUM) {
        shoppingList.put(m.getFavFood(), shoppingList.getOrDefault(m.getFavFood(), 0) + 300);
      }
      if (m.getMonSize() == Size.LARGE) {
        shoppingList.put(m.getFavFood(), shoppingList.getOrDefault(m.getFavFood(), 0) + 500);
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<Food, Integer> entry : shoppingList.entrySet()) {
      Food key = entry.getKey();
      Integer value = entry.getValue();
      stringBuilder.append(key).append(":").append(value).append("g ");
    }

    return "Produced shopping list: " + stringBuilder;
  }


  @Override
  public String toString() {
    return "Sanctuary ID:" + hashCode() + " {" + "isolationList= " + isolationList
        + ", isolationLimit= " + isolationLimit + ", enclosureList= " + enclosureList
        + ", enclosureLimit= " + enclosureLimit + '}';
  }

  /**
   * Helper class to cal the species distribution in the sanctuary.
   *
   * @param isolationList isolationList
   * @param enclosureList enclosureList
   * @return a hashmap containing the species distribution
   */
  private HashMap<Species, String> calcSpeciesDistribution(ArrayList<Isolation> isolationList,
      ArrayList<Enclosure> enclosureList) {
    HashMap<Species, String> speciesDistribution = new HashMap<>();
    for (Isolation i : isolationList) {
      if (i.getCurrMonkey() == null) {
        continue;
      }
      Species currentSpecies = (i.getCurrMonkey().getSpecies());

      if (speciesDistribution.containsKey(currentSpecies)) {
        if (speciesDistribution.get(currentSpecies).equals("isolation")) {
          continue;
        }
        speciesDistribution.put(currentSpecies,
            speciesDistribution.get(currentSpecies).concat(" isolation"));
      } else {
        speciesDistribution.put(currentSpecies, "isolation");
      }
    }

    for (Enclosure e : enclosureList) {
      Species currentSpecies = (e.getCurrEnclosureSpecies());
      if (currentSpecies == null) {
        continue;
      }
      if (speciesDistribution.containsKey(currentSpecies)) {
        speciesDistribution.get(currentSpecies).concat(" enclosure");
      } else {
        speciesDistribution.put(currentSpecies, "enclosure");
      }
    }
    return speciesDistribution;
  }

  @Override
  public void addIsolationToSanctuary(Isolation isolation) throws IllegalArgumentException {
    if (this.isolationLimit > this.isolationList.size()) {
      this.isolationList.add(isolation);
    } else {
      throw new IllegalArgumentException(
          "Isolation limits reached, consider moving to Enclosure of this Sanctuary.");
    }
  }

  @Override
  public void addEnclosureToSanctuary(Enclosure enclosure) throws IllegalArgumentException {
    if (this.enclosureLimit > this.enclosureList.size()) {
      this.enclosureList.add(enclosure);
    } else {
      throw new IllegalArgumentException(
          "Enclosure limits reached, consider moving to other Sanctuary.");
    }
  }

  /**
   * Adjust the limit of isolations in the sanctuary.
   *
   * @param newIsolationLimit newIsolationLimit
   */
  public void adjustIsolationLimit(int newIsolationLimit) {
    this.isolationLimit = newIsolationLimit;
  }

  /**
   * Adjust the limit of enclosures in the sanctuary.
   *
   * @param newEnclosureLimit new enclosure limit
   */
  public void adjustEnclosureLimit(int newEnclosureLimit) {
    this.enclosureLimit = newEnclosureLimit;
  }

  /**
   * Check the isolation limit of the sanctuary.
   *
   * @return the isolation limit of the sanctuary
   */
  public int checkIsolationLimit() {
    return this.isolationLimit;
  }

  /**
   * Check the enclosure limit of the sanctuary.
   *
   * @return the enclosure limit of the sanctuary
   */
  public int checkEnclosureLimit() {
    return this.enclosureLimit;
  }
}
