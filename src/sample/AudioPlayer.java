package sample;

public class AudioPlayer extends Product implements MultimediaControl {

  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  public AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, "AUDIO");
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public void printItemInfo() {}

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopped");
  }

  @Override
  public void previous() {
    System.out.println("Went back");
  }

  @Override
  public void next() {
    System.out.println("Skipped to next");
  }

  public String toString() {
    return "Name: "
        + getName()
        + "\nManufacturer: "
        + getManufacturer()
        + "\nType: "
        + getType()
        + "\nSupported Audio Formats: "
        + supportedAudioFormats
        + "\nSupported PlaylistFormat: "
        + supportedPlaylistFormats;
  }

  public void setSupportedAudioFormats(String supportAF) {
    supportedAudioFormats = supportAF;
  }

  public void setSupportedPlaylistFormats(String supportPF) {
    supportedPlaylistFormats = supportPF;
  }

  public String getSupportedAudioFormats() {
    return supportedAudioFormats;
  }

  public String getSupportedPlaylistFormats() {
    return supportedPlaylistFormats;
  }
}
