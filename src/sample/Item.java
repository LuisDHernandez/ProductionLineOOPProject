package sample;

/**
 * Item interface defines what method needs to be implemented by the classes that use it.
 *
 * @author Luis D. Hernandez
 * @brief Interface that forces item objects to have getters and setters for name, manufacturer, and
 *     id 9/30/2019
 */
public interface Item {

  // fields for practice
  // implicitly all fields in interface are public static final
  // String name = " ";

  /** ACCESSOR METHODS.* */
  int getId();

  String getName();

  String getManufacturer();

  /** MUTATOR METHODS.* */
  void setName(String theName);

  void setManufacturer(String theManu);
}
