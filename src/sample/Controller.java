package sample;

import static sample.ItemType.AUDIO;
import static sample.ItemType.AUDIO_MOBILE;
import static sample.ItemType.VISUAL;
import static sample.ItemType.VISUAL_MOBILE;
import sample.ItemType.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/** @author Luis Hernandez 9/20/2019 */
public class Controller {

  private Connection conn;
  private Statement stmt;

  static final String JDBC_DRIVER = "org.h2.Driver"; // could be private but chose not to
  static final String DB_URL = "jdbc:h2:./res/ProdLineDB"; // could be private but chose not to

  /** create comboBox object to hold quantity amount of items */
  @FXML ComboBox<ItemType> cbxitemType;

  @FXML ComboBox<Integer> cbxQuantity;

  /** @param event when the button is pressed it will add input to Product DB */
  @FXML
  void btnAddProduct(ActionEvent event) {

    try {
      stmt.execute(
          "INSERT INTO Product(type, manufacturer, name) VALUES"
              + " ( 'AUDIO', 'Apple', 'iPod' );");
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  /**
   * @param event this action records the product & prints out to the screen that it was successful
   */
  @FXML
  void btnRecordProduction(ActionEvent event) {

    System.out.println("Product was recorded");
  }

  /** Initialize the Database and add items to combobox */
  public void initialize() {

    //  Database credential
    stmt = null;
    conn = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      cbxQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
      cbxQuantity.setEditable(true);
      cbxQuantity.getSelectionModel().selectFirst();
      cbxitemType.getItems().addAll(AUDIO, VISUAL, AUDIO_MOBILE, VISUAL_MOBILE);
      cbxitemType.getSelectionModel().selectFirst();

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);
      stmt = conn.createStatement();

      // Clean-up environment

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) { // sql exception needed
      e.printStackTrace();
    }
  }
}
