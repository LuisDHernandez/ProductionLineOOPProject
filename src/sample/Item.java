package sample;

/**
 * @author Luis D. Hernandez
 * @brief Interface that forces item objects to have getters and setters for name, manufacturer, and
 *     id 9/30/2019
 */
public interface Item {

  // fields for practice
  // implicitly all fields in interface are public static final
  // String name = " ";

  /** ACCESSOR METHODS* */
  public int getId();

  public String getName();

  public String getManufacturer();

  /** MUTATOR METHODS* */
  public void setName(String theName);

  public void setManufacturer(String theManu);
}
