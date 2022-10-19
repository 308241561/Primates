import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import primates.Enclosure;
import primates.Food;
import primates.Isolation;
import primates.JungleFriends;
import primates.Monkey;
import primates.Sanctuary;
import primates.Sex;
import primates.Size;
import primates.Species;

/**
 * This is a test class for Sanctuary, to test different functions of the sanctuary.
 */
public class SanctuaryTest {

  ArrayList<Isolation> isolationList;
  ArrayList<Enclosure> enclosuresNum;

  /**
   * To set up the sanctuary for the convenience of test.
   */
  @Before
  public void setUp() {
    isolationList = new ArrayList<>();
    enclosuresNum = new ArrayList<>();
    JungleFriends twoIsoThreeEnc = new Sanctuary(isolationList, 2, enclosuresNum, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullIsolationFailToConstruct() {
    // only added enclosures to sanctuary should report exception
    new Sanctuary(null, 0, enclosuresNum, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullEnclosureFailToConstruct() {
    new Sanctuary(isolationList, 2, null, 0);
  }

  @Test
  public void testMoveMonkeyFromIsolationToEnclosure() {
    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosuresNum, 3);

    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);

    Monkey monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 2, 1, Food.EGGS);

    isolationOne.addMonkey(monFriday);
    Monkey monFridayFromIsolationOne = isolationOne.removeMonkey();
    enclosureOne.addMonkey(monFridayFromIsolationOne);

    assertEquals(monFriday, enclosureOne.getMonkeyList().get(0));
  }

  @Test
  public void testReportSpecies() {
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);

    Monkey monFriday = new Monkey("Friday", Species.SAKI, Sex.MALE, Size.SMALL, 2,
        1, Food.EGGS);
    isolationOne.addMonkey(monFriday);
    assertEquals("Reporting species SAKI:isolation ", sanctuary.reportSpecies());
    Monkey monFridayFromIsolationOne = isolationOne.removeMonkey();
    enclosureOne.addMonkey(monFridayFromIsolationOne);
    assertEquals("Reporting species SAKI:enclosure ", sanctuary.reportSpecies());


    Monkey monSunday = new Monkey("Sunday", Species.DRILL, Sex.MALE, Size.LARGE, 3,
        1, Food.FRUITS);
    isolationTwo.addMonkey(monSunday);
    assertEquals("Reporting species DRILL:isolation SAKI:enclosure ",
        sanctuary.reportSpecies());
  }

  @Test
  public void testLookUpSpecies() {
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);


    Monkey monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 2,
        1, Food.EGGS);
    isolationOne.addMonkey(monFriday);
    assertEquals("Looked up species DRILL, found them in isolation.",
        sanctuary.lookUp(Species.DRILL));
    Monkey monFridayFromIsolationOne = isolationOne.removeMonkey();
    enclosureOne.addMonkey(monFridayFromIsolationOne);
    assertEquals("Looked up species DRILL, found them in enclosure.",
        sanctuary.lookUp(Species.DRILL));
  }

  @Test
  public void testProduceSign() {
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);


    Monkey monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 2,
        1, Food.EGGS);
    isolationOne.addMonkey(monFriday);
    Monkey monFridayFromIsolationOne = isolationOne.removeMonkey();
    enclosureOne.addMonkey(monFridayFromIsolationOne);
    assertEquals("Produced sign for the enclosure：Friday-MALE-EGGS",
        sanctuary.produceSign(enclosureOne));

  }

  @Test
  public void testProduceMonkeyList() {
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);


    Monkey monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 2,
        1, Food.EGGS);
    isolationOne.addMonkey(monFriday);
    assertEquals("Produced monkeys list: [Friday : isolation]",
        sanctuary.produceMonkeyList());
    Monkey monFridayFromIsolationOne = isolationOne.removeMonkey();
    enclosureOne.addMonkey(monFridayFromIsolationOne);
    assertEquals("Produced monkeys list: [Friday : enclosure]",
        sanctuary.produceMonkeyList());

    Monkey monSunday = new Monkey("Sunday", Species.DRILL, Sex.MALE, Size.LARGE, 3,
        1, Food.FRUITS);
    isolationOne.addMonkey(monSunday);

    Monkey monMonday = new Monkey("Monday", Species.DRILL, Sex.FEMALE, Size.LARGE, 5,
        2, Food.SEEDS);
    isolationTwo.addMonkey(monMonday);
    assertEquals(
        "Produced monkeys list: [Friday : enclosure, Monday : isolation, Sunday : isolation]",
        sanctuary.produceMonkeyList());
  }

  @Test
  public void testProduceShoppingList() {
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);

    Monkey monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 2,
        1, Food.EGGS);
    isolationOne.addMonkey(monFriday);
    assertEquals("Produced shopping list: EGGS:100g ", sanctuary.produceShoppingList());
  }

  @Test
  public void testAdjustIsolationLimit() {
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);

    assertEquals(2, sanctuary.checkIsolationLimit());

    sanctuary.adjustIsolationLimit(20);
    assertEquals(20, sanctuary.checkIsolationLimit());

  }

  @Test
  public void testAdjustEnclosureLimit() {
    Isolation isolationOne = new Isolation();
    Isolation isolationTwo = new Isolation();
    Enclosure enclosureOne = new Enclosure(20);
    Enclosure enclosureTwo = new Enclosure(20);
    Enclosure enclosureThree = new Enclosure(20);

    ArrayList<Isolation> isolationList = new ArrayList<>();
    ArrayList<Enclosure> enclosureList = new ArrayList<>();

    Sanctuary sanctuary = new Sanctuary(isolationList, 2, enclosureList, 3);
    sanctuary.addIsolationToSanctuary(isolationOne);
    sanctuary.addIsolationToSanctuary(isolationTwo);
    sanctuary.addEnclosureToSanctuary(enclosureOne);
    sanctuary.addEnclosureToSanctuary(enclosureTwo);
    sanctuary.addEnclosureToSanctuary(enclosureThree);

    assertEquals(3, sanctuary.checkEnclosureLimit());
    sanctuary.adjustEnclosureLimit(30);
    assertEquals(30, sanctuary.checkEnclosureLimit());
  }
}
