package sample;

/**
 * @author Luis Hernandez
 * @breif interface that is implemented between audio and movie players as they have similar
 * functions like play or stop
 */
public interface MultimediaControl {

  void play();

  void stop();

  void previous();

  void next();
}
