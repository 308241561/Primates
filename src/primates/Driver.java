package primates;

import java.util.ArrayList;

/**
 * This is a driver class to test the different functions of sanctuary, isolation and enclosure.
 */
public class Driver {

  /**
   * main function of the driver class.
   *
   * @param args args
   */
  public static void main(String[] args) {
    // =========================================================================================//
    System.out.println("The Jungle Friends Primate Sanctuary provides a permanent home \n"
        + "and high-quality sanctuary care for New World primates who have been cast-off from \n"
        + "the pet trade, retired from research, or confiscated by authorities.\n");

    System.out.println("Let me show you how this program works to make the management easier!\n");

    System.out.println("<<<<<<=============================================================>>>>>>");

    System.out.println("Step 1: Found some monkeys in the new world. Let's help them find a home.");

    // Created 2 isolations and 3 enclosures
    System.out.println("Step 2: Created a sanctuary with 2 isolations and 3 enclosures.");
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    //created two lists, one for isolations, one for enclosures
    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    //created a sanctuary with iso limit of 2, enc limit of 3
    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);

    //add the previously created 2 isolations and 3 enclosures to the sanctuary.
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);

    // add monkeys to isolation
    System.out.println("Step 3: Adding one monkey in isolationOne for the initial check up.");
    Monkey monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 2, 1, Food.EGGS);
    isolationOne.addMonkey(monFriday);

    // remove it from isolationOne
    System.out.println(
        "Step 4: Checked up, then ready for transporting monkey for larger enclosures.");
    Monkey monFridayFromIsolationOne = isolationOne.removeMonkey();

    //add the removed monkey to enclosureOne
    System.out.println("Step 5: Transported the monkey to enclosureOne.");
    enclosureOne.addMonkey(monFridayFromIsolationOne);

    System.out.println("Step 6: Here are some standard report for the sanctuary.");
    printSpecificationRequiredMessage(enclosureOne, sanctuary);

    // =========================================================================================//

    System.out.println("Step 7: Add two monkeys to the two isolations of the sanctuary.");
    Monkey monSunday = new Monkey("Sunday", Species.DRILL, Sex.MALE, Size.LARGE, 3,
        1, Food.FRUITS);
    Monkey monMonday = new Monkey("Monday", Species.DRILL, Sex.FEMALE, Size.LARGE, 5,
        2, Food.SEEDS);
    isolationOne.addMonkey(monSunday);
    isolationTwo.addMonkey(monMonday);
    System.out.println(
        "Step 8: Checked up, then ready for transporting them for larger enclosures.");
    Monkey monSundayFromIsolationOne = isolationOne.removeMonkey();
    Monkey monMondayFromIsolationTwo = isolationTwo.removeMonkey();
    System.out.println(
        "Step 9: Try to transport the monkey to the enclosureOne currently housed Drill types.");
    System.out.println(
        "Step 10: We can call get Species of EnclosureOne now: "
            + enclosureOne.getCurrEnclosureSpecies());
    System.out.println("Step 11: The first monkey should be okay to add");
    try {
      enclosureOne.addMonkey(monSundayFromIsolationOne);
    } catch (IllegalArgumentException e) {
      System.out.println("If we successfully transport current monkey, it should not show");
    }
    System.out.println(
        "Step 12: After adding, we can see the monkeys in EnclosureOne: \n"
            + enclosureOne.getMonkeyList());
    System.out.println("However, we can see that the capacity is too low for the second monkey: "
        + enclosureOne.getCurrEnclosureCapacity());
    System.out.println("We use try-catch block to see how it goes: ");
    try {
      enclosureOne.addMonkey(monMondayFromIsolationTwo);
    } catch (IllegalArgumentException e) {
      System.out.println("This code is from the catch block which proves that we are right.\n"
          + "This monkey is too big for this enclosure, we need to move it to another one");
    }
    System.out.println("Step 13: So we need to move it to another enclosure");
    enclosureTwo.addMonkey(monMondayFromIsolationTwo);
    System.out.println("Step 14: Done!,let's check the monkey in Enclosure Two");
    System.out.println(enclosureTwo.getMonkeyList());
    System.out.println("Step 15: Sanctuary monkeyList:");
    System.out.println(sanctuary.produceMonkeyList());
    System.out.println("We can see that all the monkeys are housed in Enclosures\n");
    // =========================================================================================//
    System.out.println("<<<<<<=============================================================>>>>>>");
    System.out.println("Step 16: Now, let's add another monkey with different types!");
    System.out.println("Step 17: like always, we need to put it in the isolation for medical "
        + "attention");
    Monkey monTuesday = new Monkey("Tuesday", Species.GUEREZA, Sex.FEMALE, Size.MEDIUM,
        4, 3, Food.NUTS);
    isolationOne.addMonkey(monTuesday);
    System.out.println(
        "Step 18: Checked up, then ready for transporting them for larger enclosures.");
    Monkey monTuesdayFromIsolationOne = isolationOne.removeMonkey();
    System.out.println(
        "Step 19: Now, we try to add to the current existing enclosures, but it should not work");
    try {
      enclosureOne.addMonkey(monTuesdayFromIsolationOne);
    } catch (IllegalArgumentException e) {
      System.out.println(
          "Step 20: We are correct that different species monkey can't go in the same enclosure.");
    }
    System.out.println("Step 21: So we now can try to add a new enclosure.");
    enclosureThree.addMonkey(monTuesdayFromIsolationOne);
    System.out.println("Step 22: Done, let's check if the monkey is in Enclosure Three");
    System.out.println(enclosureThree.getMonkeyList());
    System.out.println("Step 23: Let's do one more thing, to get the standard full scale report:");
    printSpecificationRequiredMessage(enclosureOne, sanctuary);
    System.out.println("Step 24: Now, we have tested all of the functionalities.");
    System.out.println("<<<<<<=============================================================>>>>>>");
    // =========================================================================================//
  }

  private static void printSpecificationRequiredMessage(Enclosure enclosureOne,
      Sanctuary sanctuary) {
    System.out.println("\t\tReport all the species in the sanctuary.");
    System.out.println("\t\t" + sanctuary.reportSpecies());
    System.out.println("\t\tLook up the species Drill.");
    System.out.println("\t\t" + sanctuary.lookUp(Species.DRILL));
    System.out.println("\t\tProduce a sign for the enclosure of your choice.");
    System.out.println("\t\t" + sanctuary.produceSign(enclosureOne));
    System.out.println("\t\tProduce a monkey list.");
    System.out.println("\t\t" + sanctuary.produceMonkeyList());
    System.out.println("\t\tProduce a shopping list.");
    System.out.println("\t\t" + sanctuary.produceShoppingList());
  }
}
