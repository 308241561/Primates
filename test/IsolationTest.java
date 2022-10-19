import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import primates.Food;
import primates.Isolation;
import primates.Monkey;
import primates.Sex;
import primates.Size;
import primates.Species;

/**
 * This is a test class for Isolation. to test different functions of the Isolation.
 */
public class IsolationTest {

  private Isolation defaultIsolation;

  /**
   * Set up the isolation for the testing.
   */
  @Before
  public void setUp() {
    Monkey monFriday = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 10,
        15, Food.EGGS);
    defaultIsolation = initialIsolation();
    defaultIsolation.addMonkey(monFriday);
  }

  protected Isolation initialIsolation() {
    return new Isolation();
  }

  /**
   * Test getter method getCurrMonkey.
   */
  @Test
  public void tesGetCurrMonkey() {
    Monkey expected = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 10,
        15, Food.EGGS);
    assertEquals(expected, defaultIsolation.getCurrMonkey());
  }

  /**
   * Test add monkey to an empty isolation.
   */
  @Test
  public void tesAddMonkeySuccess() {
    defaultIsolation.removeMonkey();
    Monkey expected = new Monkey("Sunday", Species.DRILL, Sex.MALE, Size.MEDIUM, 3,
        1, Food.FRUITS);
    Monkey monSunday = new Monkey("Sunday", Species.DRILL, Sex.MALE, Size.MEDIUM, 3,
        1, Food.FRUITS);
    defaultIsolation.addMonkey(monSunday);
    assertEquals(expected, defaultIsolation.getCurrMonkey());

  }

  /**
   * Test adding monkey to an isolation that is already taken by another monkey.
   */
  @Test(expected = IllegalArgumentException.class)
  public void tesAddMonkeyFailToFullCapacityIsolation() {
    Monkey monSunday = new Monkey("Sunday", Species.DRILL, Sex.MALE, Size.MEDIUM, 3,
        1, Food.FRUITS);
    defaultIsolation.addMonkey(monSunday);
  }

  /**
   * Test if remove monkey success.
   */
  @Test
  public void removeMonkeySuccess() {
    Monkey expected = new Monkey("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 10,
        15, Food.EGGS);
    assertFalse(expected.getQuarantined());
    assertTrue(defaultIsolation.removeMonkey().getQuarantined());
    assertNull(defaultIsolation.getCurrMonkey());

  }

  /**
   * Test remove from an empty isolation.
   */
  @Test(expected = IllegalStateException.class)
  public void removeMonkeyFail() {
    defaultIsolation.removeMonkey(); // Monkey is already removed
    defaultIsolation.removeMonkey(); // Now trying to remove monkey from an empty isolation
  }
}