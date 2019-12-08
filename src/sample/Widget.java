package sample;

/** child class of Product to instantiate objects of type product since product is abstract. */
class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
