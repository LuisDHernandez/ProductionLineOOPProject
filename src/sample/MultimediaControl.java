package sample;

/**
 * @author Luis Hernandez
 * @breif interface that is implemented between audio and movie players as they have similar
 *     functions like play or stop
 */
public interface MultimediaControl {

  public void play();

  public void stop();

  public void previous();

  public void next();
}
