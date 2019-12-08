package sample;

/**
 * Interface that sets what methods need to be included in a class.
 *
 * @author Luis Hernandez
 */
public interface ScreenSpec {

  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
