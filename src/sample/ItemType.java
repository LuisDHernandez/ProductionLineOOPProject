package sample;

/** @author Luis D. Hernandez 9/30/2019 */
public enum ItemType {
  // AU, VI, AM, VM
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");
  public final String code;

  ItemType(String itemCode) {
    code = itemCode;
  }
}
