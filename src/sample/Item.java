package sample;

/** @author Luis D. Hernandez 9/30/2019 */
public interface Item {

  // fields for practice
  // implicitly all fields in interface are public static final
  // String name = " ";

  public void printItemInfo();

  public int getId();

  public void setName(String theName);

  public String getName();

  public void setManufacturer(String theManu);

  public String getManufacturer();
}
