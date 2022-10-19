package primates;

/**
 * An isolation class to represent one of the housing option in the sanctuary.
 */
public class Isolation implements IsolationInterface {

  private Monkey currMonkey;
  private int currOccupants;

  /**
   * Construct an isolation of the sanctuary.
   */
  public Isolation() {
    this.currMonkey = null;
    this.currOccupants = 0;
  }

  /**
   * Get the current monkey of the isolation.
   *
   * @return monkey in the isolation or null if there is none.
   */
  public Monkey getCurrMonkey() {
    if (this.currMonkey == null) {
      return null;
    }
    return new Monkey(this.currMonkey.getName(), this.currMonkey.getSpecies(),
        this.currMonkey.getSex(), this.currMonkey.getMonSize(), this.currMonkey.getWeight(),
        this.currMonkey.getAge(), this.currMonkey.getFavFood());
  }

  /**
   * Add a monkey to the isolation.
   *
   * @param newMonkey a new monkey
   * @throws IllegalArgumentException if newMonkey is not the required type, or it is taken already.
   */
  public void addMonkey(Monkey newMonkey) throws IllegalArgumentException {
    if (this.currMonkey == null && this.currOccupants == 0) {
      this.currMonkey = newMonkey;
      this.currOccupants = 1;
      this.currMonkey.setQuarantined(); // get the current monkey and set it as quarantined
      // so that it is ready for transporting to enc.
    } else {
      throw new IllegalArgumentException("This isolation is already taken by one monkey");
    }
  }

  /**
   * Remove a monkey from the isolation.
   *
   * @return current monkey in the isolation
   * @throws IllegalStateException if the current isolation is empty
   */
  public Monkey removeMonkey() throws IllegalStateException {
    if (this.currMonkey == null && this.currOccupants == 0) {
      throw new IllegalStateException("You're trying to remove from an empty isolation.");
    }
    Monkey monkeyToBeRemoved = this.currMonkey;
    this.currMonkey = null;
    this.currOccupants = 0;
    return monkeyToBeRemoved;
  }

  @Override
  public String toString() {
    return "Isolation ID:" + hashCode() + " {" + "currMonkey=" + currMonkey + ", currOccupantsNum="
        + currOccupants + '}';
  }
}
