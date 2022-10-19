import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import primates.Enclosure;
import primates.Food;
import primates.Isolation;
import primates.Monkey;
import primates.Sex;
import primates.Size;
import primates.Species;


/**
 * This is an enclosure test class to test the different functions of enclosure.
 */
public class EnclosureTest {

  Monkey monFriday;
  Monkey monSunday = new Monkey("Sunday", Species.DRILL, Sex.MALE, Size.MEDIUM, 3,
      1, Food.FRUITS);
  Monkey monMonday = new Monkey("Monday", Species.GUEREZA, Sex.FEMALE, Size.LARGE, 5,
      2, Food.SEEDS);
  Monkey monMondayTwo = new Monkey("MondayII", Species.GUEREZA, Sex.FEMALE, Size.LARGE,
      5, 2,
      Food.SEEDS);
  Monkey monMondayThree = new Monkey("MondayIII", Species.GUEREZA, Sex.FEMALE, Size.LARGE,
      5, 2,
      Food.SEEDS);

  private Isolation defaultIsolation;
  private Enclosure defaultEnclosure;

  /**
   *  set up an enclosure for the convenience test.
   */
  @Before
  public void setUp() {
    defaultIsolation = initialIsolation();
    defaultEnclosure = initialEnclosure();
    monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 10,
        15, Food.EGGS);
  }

  protected Enclosure initialEnclosure() {
    return new Enclosure(20);
  }

  protected Isolation initialIsolation() {
    return new Isolation();
  }

  @Test
  public void testCurrEnclosureCapacity20() {
    assertEquals(20, defaultEnclosure.getCurrEnclosureCapacity());
  }

  @Test
  public void testCurrEnclosureCapacity13() {
    defaultIsolation.addMonkey(monFriday);
    Monkey monFridayFromDefaultIsolation = defaultIsolation.removeMonkey();
    defaultIsolation.addMonkey(monSunday);
    Monkey monSundayFromDefaultIsolation = defaultIsolation.removeMonkey();
    defaultEnclosure.addMonkey(monFridayFromDefaultIsolation);
    defaultEnclosure.addMonkey(monSundayFromDefaultIsolation);
    assertEquals(13, defaultEnclosure.getCurrEnclosureCapacity());
  }

  @Test
  public void testCurrEnclosureSpeciesNull() {
    assertNull(defaultEnclosure.getCurrEnclosureSpecies());
  }

  @Test
  public void testAddMonkeySuccess() {
    defaultIsolation.addMonkey(monFriday);
    defaultIsolation.removeMonkey();
    defaultEnclosure.addMonkey(monFriday);
    assertEquals(Species.DRILL, defaultEnclosure.getCurrEnclosureSpecies());
    assertEquals(18, defaultEnclosure.getCurrEnclosureCapacity());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMonkeyFailBcSpeciesMismatch() {
    defaultEnclosure.addMonkey(monFriday);
    defaultEnclosure.addMonkey(monMonday);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddMonkeyFailBcSpaceLimited() {
    defaultEnclosure.addMonkey(monMonday);
    defaultEnclosure.addMonkey(monMondayTwo);
    defaultEnclosure.addMonkey(monMondayThree);
  }
}