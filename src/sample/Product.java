package sample;

/**
 * @author Luis D. Hernandez
 * @brief abstract class that is used as a basis for all objects and integrates database
 *     functionality with program 9/30/2019
 */
public abstract class Product implements Item {

  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  /**
   * @param name take name of product
   * @param manufacturer the creator of the product
   * @param type the type of product based on ItemType
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
    id = 0;
  }

  /** @return a string of the name, manufacturer and type of the product */
  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }

  /** ACCESSOR METHODS* */
  public int getId() {
    return id;
  }

  public ItemType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  /** MUTATOR METHODS* */
  public void setId(int id) {
    this.id = id;
  }

  public void setName(String theName) {
    name = theName;
  }

  public void setManufacturer(String theManu) {
    manufacturer = theManu;
  }

  public void setType(ItemType theType) {
    type = theType;
  }
}

/** child class of Product to instantiate objects of type product since product is abstract */
class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
