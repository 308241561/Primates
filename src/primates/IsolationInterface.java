package primates;

/**
 * This is an interface class for the isolation.
 * Isolation should be able to host any type of monkey. But can only host one each time.
 */
public interface IsolationInterface {
  /**
   * To get the current monkey in the isolation. There should be only one in the isolation.
   *
   * @return monkey
   */
  Monkey getCurrMonkey();

  /**
   * To add a monkey to the isolation.To make the adding successful, the isolation must be empty.
   *
   * @param newMonkey a new monkey
   * @throws IllegalArgumentException if newMonkey is not correct type or the isolation is taken.
   */
  void addMonkey(Monkey newMonkey) throws IllegalArgumentException;

  /**
   * To remove the monkey from the isolation. Make it ready for transporting to an enclosure.
   *
   * @return a monkey
   * @throws IllegalStateException if the isolation is not currently occupied by a monkey.
   */
  Monkey removeMonkey() throws IllegalStateException;

}
