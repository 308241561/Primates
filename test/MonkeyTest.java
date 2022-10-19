import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import primates.Food;
import primates.Monkey;
import primates.Sex;
import primates.Size;
import primates.Species;


/**
 * This is a test class for Monkey.to test different functions of the monkey.
 */
public class MonkeyTest {

  private Monkey defaultMonkey;

  @Before
  public void setUp() {
    defaultMonkey = initialMon("Friday", Species.DRILL, Sex.MALE, Size.SMALL, 10, 15, Food.EGGS);
  }

  /**
   * This method is providing shorthand way of creating instances.
   *
   * @param name    name
   * @param species species
   * @param sex     sex
   * @param monSize monSize
   * @param weight  weight
   * @param age     age
   * @param favFood favFood
   * @return shorthand way of creating instances Monkey
   */

  protected Monkey initialMon(String name, Species species, Sex sex, Size monSize, int weight,
      int age, Food favFood) {
    return new Monkey(name, species, sex, monSize, weight, age, favFood);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructMonkeyWithNegativeWeight() {
    new Monkey("1", Species.DRILL, Sex.MALE, Size.SMALL, -1, 1, Food.EGGS);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructMonkeyWithNullSize() {
    new Monkey("1", Species.DRILL, Sex.MALE, null, -1, 1, Food.EGGS);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructMonkeyWithNullFood() {
    new Monkey("1", Species.DRILL, Sex.MALE, Size.SMALL, -1, 1, null);
  }

  @Test
  public void testGetNameDefault() {
    String expected = "Friday";
    assertEquals(expected, defaultMonkey.getName());
  }

  @Test
  public void testGetName() {
    Monkey defaultMonkeyToTestGetName = initialMon("Sunday", Species.SAKI, Sex.FEMALE,
        Size.MEDIUM, 1, 5, Food.FRUITS);
    String expected = "Sunday";
    assertEquals(expected, defaultMonkeyToTestGetName.getName());
  }

  @Test
  public void testGetSpecies() {
    Species expected = Species.DRILL;
    assertEquals(expected, defaultMonkey.getSpecies());
  }

  @Test
  public void testGetSex() {
    Sex expected = Sex.MALE;
    assertEquals(expected, defaultMonkey.getSex());
  }

  @Test
  public void testGetMonSize() {
    Size expected = Size.SMALL;
    assertEquals(expected, defaultMonkey.getMonSize());
  }

  @Test
  public void testGetWeight() {
    int expected = 10;
    assertEquals(expected, defaultMonkey.getWeight());
  }

  @Test
  public void testGetAge() {
    int expected = 15;
    assertEquals(expected, defaultMonkey.getAge());
  }

  @Test
  public void testGetFavFood() {
    Food expected = Food.EGGS;
    assertEquals(expected, defaultMonkey.getFavFood());
  }
}