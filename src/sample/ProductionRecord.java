package sample;

import java.util.Date;

/** @author Luis Hernandez */
public class ProductionRecord {

  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;

  /** @param productId products generated id record a product by using its ID */
  public ProductionRecord(int productId) {

    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * @param productId products generated id
   * @param productionNumber the number assigned to it after being produced
   * @param serialNumber programmed number after it is created
   * @param dateProduced time produced
   */
  public ProductionRecord(
      int productId, int productionNumber, String serialNumber, Date dateProduced) {
    this.dateProduced = dateProduced;
    this.serialNumber = serialNumber;
    this.productionNumber = productionNumber;
    this.productId = productId;
  }

  /**
   * @param item product item that has name, manufacturer, type being produced
   * @param count updated variable to give unique serial number
   */
  public ProductionRecord(Product item, int count) {
    serialNumber = item.getManufacturer().substring(0, 3) + item.getType().code + "00" + count;
    dateProduced = new Date();
  }

  @Override
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productId
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }

  /** MUTATOR METHODS * */
  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /** ACCESSOR METHODS * */
  public int getProductionNumber() {
    return productionNumber;
  }

  public int getProductId() {
    return productId;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public Date getDateProduced() {
    return dateProduced;
  }
}
