package sample;

import java.util.Date;

/**
 * Production Record class is used to create objects of that type in order to produce a log of
 * products.
 *
 * @author Luis Hernandez
 * @brief class that integrates with database and creates a view of the products that are being
 *     produced/ have been produced at this business
 */
public class ProductionRecord {

  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;

  /**
   * Constructor that uses productID to make a record but sets other fields to a default value.
   *
   * @param productId products generated id record a product by using its ID
   */
  public ProductionRecord(int productId) {

    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * Constructor that takes in id,number,serial,and date produced to create an object of production
   * record.
   *
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
   * Using a product and a count variable, this constructor creates a record of how many products to
   * create.
   *
   * @param item product item that has name, manufacturer, type being produced
   * @param count updated variable to give unique serial number
   */
  public ProductionRecord(Product item, int count) {
    serialNumber = item.getManufacturer().substring(0, 3) + item.getType().code + "007";
    dateProduced = new Date();
  }

  @Override
  public String toString() {
    return "\nProd. Num: "
        + productionNumber
        + " Product ID: "
        + productId
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced
        + "\n";
  }

  /** MUTATOR METHODS. * */
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

  /** ACCESSOR METHODS. * */
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
