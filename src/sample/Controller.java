package sample;

import static sample.ItemType.*;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * @author Luis Hernandez
 * @brief Controller class for GUI project, holds all code to GUI and functions of the GUI system
 * 9/20/2019
 */
public class Controller {

  @FXML private TabPane tbpaneBox;

  @FXML private Tab tabProductLine;

  @FXML private Tab tabProduce;

  @FXML private Tab tabProductionLog;

  @FXML private GridPane grdpnProductLine;

  @FXML private Label lblExProd;

  @FXML private Label lblProdName;

  @FXML private Label lblManufacturer;

  @FXML private Label lblType;

  @FXML private Label lblQuantity;

  @FXML private Label lblChooseProd;

  @FXML private TextField txtFprodName;

  @FXML private TextField txtFmanu;

  @FXML private TextArea prodLogtxtA;

  @FXML private ComboBox<ItemType> cbxitemType;

  @FXML private TableView<Product> tbvExProd;

  @FXML private ListView<Product> chooseProdLSV;

  @FXML private ComboBox<Integer> cbxQuantity;

  @FXML private Button btnrecordProd;

  @FXML private Button btnaddProduct;

  @FXML private TableColumn<?, ?> colProduct;

  @FXML private TableColumn<?, ?> colManufacturer;

  @FXML private TableColumn<?, ?> colItemType;

  @FXML private TableColumn<?, ?> colID;

  private ObservableList<Product> productLine = FXCollections.observableArrayList();

  // establish database variables
  private Connection conn;
  private Statement stmt;
  // grab jdbc driver and url
  static final String JDBC_DRIVER = "org.h2.Driver"; // could be private but chose not to
  static final String DB_URL = "jdbc:h2:./res/ProdLineDB"; // could be private but chose not to

  /** Initialize the Database and add items to combobox setup GUI initial look */
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

      cbxQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 25, 50, 100);
      cbxQuantity.setEditable(true);
      cbxQuantity.getSelectionModel().selectFirst();
      cbxitemType.getItems().addAll(AUDIO, VISUAL, AUDIO_MOBILE, VISUAL_MOBILE);
      cbxitemType.getSelectionModel().selectFirst();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) { // sql exception needed
      e.printStackTrace();
    }
  } // end initialize
  /**
   * @param event when the button is pressed it will add input to Product DB and then show the
   *     created products in table/list views for the user to see
   */
  @FXML
  void btnAddProduct(ActionEvent event) throws SQLException {

    try {
      String query = "INSERT INTO PRODUCT(name, manufacturer, type) VALUES (?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, txtFprodName.getText());
      ps.setString(2, txtFmanu.getText());
      ps.setString(3, cbxitemType.getValue().code);

      ps.executeUpdate();

      System.out.println("item added to db");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      String sql = "SELECT * FROM PRODUCT";

      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {

        // these lines correspond to the database table columns
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String type = rs.getString(3);
        String manufacturer = rs.getString(4);
        // create object
        ItemType prodType = null;

        if (type.equals("AU")) {
          prodType = AUDIO;
        } else if (type.equals("VI")) {
          prodType = VISUAL;
        } else if (type.equals("AM")) {
          prodType = AUDIO_MOBILE;
        } else if (type.equals("VM")) {
          prodType = VISUAL_MOBILE;
        }

        // show in columns
        colProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        colManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        colItemType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));

        Product product = new Widget(name, manufacturer, prodType);
        // save to observable list
        product.setId(id++);
        productLine.add(product);
      }
      tbvExProd.setItems(productLine);
      chooseProdLSV.setItems(productLine);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  } // end btnAddProduct
  /** @param event this action records the product & sends it to the production log to see output */
  @FXML
  void btnRecordProduction(ActionEvent event) throws SQLException {
    System.out.println("recorded");
  } // end btnRecordProduction
}
