package sample;

/** @author Luis D. Hernandez 9/30/2019 */
public abstract class Product implements Item {

  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
    id = 0;
  }

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String theName) {
    name = theName;
  }

  public String getName() {
    return name;
  }

  public void setManufacturer(String theManu) {
    manufacturer = theManu;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setType(ItemType theType) {
    type = theType;
  }

  public ItemType getType() {
    return type;
  }
}

class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
