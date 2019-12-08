package sample;

/**
 * Movie Player class that utilizes an interface and super class to create an object that can be a
 * movie player.
 *
 * @author Luis Hernandez
 * @brief object class that can play visuals and implements multimedia control and extends product.
 */
public class MoviePlayer extends Product implements MultimediaControl {

  // local properties for movie player only
  private Screen screen;
  private MonitorType monitorType;

  /**
   * Constructor that uses inputted name, manufacturer, screen, and monitor type to create object.
   *
   * @param name - the name of the MoviePlayer product
   * @param manufacturer - company that makes the MoviePlayer
   * @param screen - screen that displays visuals and implements resolution, etc.
   * @param monitorType - enum that describes the kind of monitor it has
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * Overrides toString to give desired output in a formatted way.
   *
   * @return string of object name, manufacturer, type, screen and monitor type
   */
  public String toString() {
    return "Name: "
        + getName()
        + "\nManufacturer: "
        + getManufacturer()
        + "\nType: "
        + getType()
        + "\nScreen Type "
        + screen
        + "\nMonitor Type: "
        + monitorType;
  }

  /** MUTATOR METHODS.* */
  public void setScreen(Screen theScreen) {
    screen = theScreen;
  }

  public void setMonitorType(MonitorType theMonitor) {
    monitorType = theMonitor;
  }

  /** ACCESSOR METHODS.* */
  public Screen getScreen() {
    return screen;
  }

  public MonitorType getMonitorType() {
    return monitorType;
  }
}
