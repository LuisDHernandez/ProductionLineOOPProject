package sample;

import java.util.Date;

public class ProductionRecord {

  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;

  public ProductionRecord(int productId) {

    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  public ProductionRecord(
      int productId, int productionNumber, String serialNumber, Date dateProduced) {
    this.dateProduced = dateProduced;
    this.serialNumber = serialNumber;
    this.productionNumber = productionNumber;
    this.productId = productId;
  }

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
