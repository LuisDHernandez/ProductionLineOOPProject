package sample;

/**
 * @author Luis Hernandez
 * @brief AudioPlayer product that can play music and implements MultimediaControl and extends
 *     Product
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * @param name - name of the audio player product
   * @param manufacturer - creator of the audioplayer
   * @param supportedAudioFormats - what audio formats it can use
   * @param supportedPlaylistFormats - what playlists it can use
   */
  public AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  /** @return string of name, manufacturer, type and supported formats to be displayed */
  public String toString() {
    return "Name: "
        + getName()
        + "\nManufacturer: "
        + getManufacturer()
        + "\nType: "
        + getType()
        + "\nSupported Audio Formats: "
        + supportedAudioFormats
        + "\nSupported Playlist Formats: "
        + supportedPlaylistFormats;
  }

  /** MUTATOR METHODS* */
  public void setSupportedAudioFormats(String supportAF) {
    supportedAudioFormats = supportAF;
  }

  public void setSupportedPlaylistFormats(String supportPF) {
    supportedPlaylistFormats = supportPF;
  }

  /** ACCESSOR METHODS* */
  public String getSupportedAudioFormats() {
    return supportedAudioFormats;
  }

  public String getSupportedPlaylistFormats() {
    return supportedPlaylistFormats;
  }
}
