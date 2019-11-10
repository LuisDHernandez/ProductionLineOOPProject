package sample;

/**
 * @author Luis Herenandez
 * @brief Screen object that contains the code to display a movie to movieplayers.
 */
public class Screen implements ScreenSpec {

  // local screen properties
  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * @param theResolution - resolution of the screen
   * @param theRefreshRate - time it takes to update screen with next part of movie
   * @param theResponseTime - the speed the screen react to inputs and displaying of the movie
   */
  public Screen(String theResolution, int theRefreshRate, int theResponseTime) {
    resolution = theResolution;
    refreshRate = theRefreshRate;
    responseTime = theResponseTime;
  }

  /** @return string that contains the screen resolution,refresh, and response times */
  public String toString() {

    return "Screen:"
        + "\nResolution: "
        + resolution
        + "\nRefresh rate: "
        + refreshRate
        + "\nResponse time: "
        + responseTime;
  }

  /** ACCESSOR METHODS* */
  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }
}
