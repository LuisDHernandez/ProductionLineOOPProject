package sample;

/**
 * @author Luis Hernandez
 * @brief interface that forces screen.java to have getter methods for resolution,refresh, and
 *     response times
 */
public interface ScreenSpec {

  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
