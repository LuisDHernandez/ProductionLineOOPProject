package sample;

/**
 * Enum class that defines products with special data types.
 *
 * @author Luis D. Hernandez
 * @brief Enum that gives Product objects a type and assigns it a string value to be commonly used
 *     9/30/2019
 */
public enum ItemType {
  // AU, VI, AM, VM
  AUDIO("AU"), // 0
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM"); // 3
  public final String code;

  /**
   * Takes the item code and assigns a String value according to the type name.
   *
   * @param itemCode give string value corresponding to Enum type
   */
  ItemType(String itemCode) {
    code = itemCode;
  }
}
