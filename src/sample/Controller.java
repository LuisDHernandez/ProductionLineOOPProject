package sample;

import static sample.ItemType.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

  /** create comboBox object to hold quantity amount of items */
  @FXML private TextField txtFprodName;

  @FXML private TextField txtFmanu;

  @FXML private TextArea prodLogtxtA;

  @FXML private ComboBox<ItemType> cbxitemType;

  @FXML private TableView<?> tbvExProd;

  @FXML private ListView<?> chooseProdLSV;

  @FXML private ComboBox<Integer> cbxQuantity;

  @FXML private Button btnrecordProd;
  private Connection conn;
  private Statement stmt;

  static final String JDBC_DRIVER = "org.h2.Driver"; // could be private but chose not to
  static final String DB_URL = "jdbc:h2:./res/ProdLineDB"; // could be private but chose not to

  /** Initialize the Database and add items to combobox */
  public void initialize() {

    //  Database credential
    stmt = null;
    conn = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);
      stmt = conn.createStatement();

      // Clean-up environment

      cbxQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
      cbxQuantity.setEditable(true);
      cbxQuantity.getSelectionModel().selectFirst();
      cbxitemType.getItems().addAll(AUDIO, VISUAL, AUDIO_MOBILE, VISUAL_MOBILE);
      cbxitemType.getSelectionModel().selectFirst();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) { // sql exception needed
      e.printStackTrace();
    }
  }
  /** @param event when the button is pressed it will add input to Product DB */
  @FXML
  void btnAddProduct(ActionEvent event) {

    try {
      String query = "INSERT INTO PRODUCT(name, manufacturer, type) VALUES (?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, txtFprodName.getText());
      ps.setString(2, txtFmanu.getText());
      ps.setString(3, cbxitemType.getValue().code);

      ps.executeUpdate();

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
}
