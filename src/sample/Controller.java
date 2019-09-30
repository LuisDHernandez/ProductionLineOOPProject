package sample;

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
  /** */
  private Connection conn;

  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./res/ProdLineDB";

  @FXML private ComboBox<Integer> cbxQuantity;

  @FXML
  void btnAddProduct(ActionEvent event) {
    try (Statement statement = conn.createStatement()) {
      statement.execute(
          "INSERT INTO Product(type, manufacturer, name) VALUES"
              + " ( 'AUDIO', 'Apple', 'iPod' );");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @FXML
  void btnRecordProduction(ActionEvent event) {

    System.out.println("Product was recorded");
  }

  void Initialize() {

    //  Database credential
    conn = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);

      // Clean-up environment
      conn.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    cbxQuantity.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    cbxQuantity.setEditable(true);
    cbxQuantity.getSelectionModel().selectFirst();
  }
}
