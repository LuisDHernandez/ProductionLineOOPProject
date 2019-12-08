package sample;

import static sample.ItemType.AUDIO;
import static sample.ItemType.AUDIO_MOBILE;
import static sample.ItemType.VISUAL;
import static sample.ItemType.VISUAL_MOBILE;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

/**
 * This controller class runs the production program and utilizes the many coding practices learned
 * in COP 3003.
 *
 * @author Luis Hernandez
 * @brief Controller class for GUI project, holds all code to GUI and functions of the GUI system
 *     9/20/2019
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

  @FXML private TextArea prodLogTA;

  @FXML private ComboBox<ItemType> cbxitemType;

  @FXML private TableView<Product> tbvExProd;

  @FXML private ListView<Product> chooseProdLV;

  @FXML private ComboBox<Integer> cbxQuantity;

  @FXML private Button btnrecordProd;

  @FXML private Button btnaddProduct;

  @FXML private TableColumn<?, ?> colProduct;

  @FXML private TableColumn<?, ?> colManufacturer;

  @FXML private TableColumn<?, ?> colItemType;

  @FXML private TableColumn<?, ?> colID;

  @FXML private Tab tabEmployee;

  @FXML private Label lblEmpName;

  @FXML private TextField txtfEmpName;

  @FXML private Button btnCreateUser;

  @FXML private Label lblPassword;

  @FXML private TextField txtfPassword;

  @FXML private TextField txtfEmail;

  @FXML private Label lblEmail;

  @FXML private TextArea logEmpTA;

  private ObservableList<Product> productLine = FXCollections.observableArrayList();

  private ObservableList<ProductionRecord> productShow = FXCollections.observableArrayList();

  // establish database variables
  private Connection conn;
  private Statement stmt;
  // grab jdbc driver and url
  static final String JDBC_DRIVER = "org.h2.Driver"; // could be private but chose not to
  static final String DB_URL = "jdbc:h2:./res/ProdLineDB"; // could be private but chose not to

  /** Initialize the Database and add items to combobox setup GUI initial look. */
  public void initialize() throws IOException {

    //  Database credential
    stmt = null;
    conn = null;

    final String User = "";
    final String Pass;
    try {
      Properties prop = new Properties();
      prop.load(new FileInputStream("res/properties"));
      Pass = prop.getProperty("password");
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, User, Pass);
      stmt = conn.createStatement();

      // Clean-up environment

      cbxQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 25, 50, 100);
      cbxQuantity.setEditable(true);
      cbxQuantity.getSelectionModel().selectFirst();
      cbxitemType.getItems().addAll(AUDIO, VISUAL, AUDIO_MOBILE, VISUAL_MOBILE);
      cbxitemType.getSelectionModel().selectFirst();
      loadProducts();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) { // sql exception needed
      e.printStackTrace();
    }
  } // end initialize
  /**
   * this will add the values inputted by user into the database to be then displayed in a table
   * view.
   *
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
      ps.close();

    } catch (SQLException e) {
      e.printStackTrace();
      conn.close();
    }
    loadProducts();
  } // end btnAddProduct

  /**
   * this populates the products from the database into the existing views before clickng on
   * buttons.
   */
  public void loadProducts() {
    try {
      String sql = "SELECT * FROM PRODUCT";

      ResultSet rs = stmt.executeQuery(sql);
      productLine.clear();
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
      chooseProdLV.setItems(productLine);
      txtFmanu.clear();
      txtFprodName.clear();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  /**
   * take chosen product and record it into the log and database.
   *
   * @param event this action records the product & sends it to the production log to see output
   */

  @FXML
  void btnRecordProduction(ActionEvent event) throws SQLException {

    productShow.clear();
    Product theRecordedProd = chooseProdLV.getSelectionModel().getSelectedItem();
    ProductionRecord produce = new ProductionRecord(theRecordedProd, 0);

    String prodRec =
        "INSERT INTO PRODUCTIONRECORD(PRODUCTION_NUM, PRODUCT_ID,"
            + " SERIAL_NUM, DATE_PRODUCED ) VALUES (?, ?, ?, ?)";

    try {
      PreparedStatement ps = conn.prepareStatement(prodRec);
      ps.setInt(1, produce.getProductionNumber());
      ps.setInt(2, produce.getProductId());
      ps.setString(3, produce.getSerialNumber());
      ps.setTimestamp(4, Timestamp.from(produce.getDateProduced().toInstant()));

      ps.executeUpdate();
      ps.close();

    } catch (SQLException e) {
      e.printStackTrace();
      conn.close();
    }

    String showProduction = "SELECT * FROM PRODUCTIONRECORD";
    try (ResultSet rs = stmt.executeQuery(showProduction)) {

      ProductionRecord showRecord =
          new ProductionRecord(
              produce.getProductId(),
              produce.getProductionNumber(),
              produce.getSerialNumber(),
              produce.getDateProduced());

      while (rs.next()) {

        int productionNumber = rs.getInt(1);
        int productId = rs.getInt(2);
        String serialNum = rs.getString(3);
        Timestamp dateRec = rs.getTimestamp(4);

        showRecord.setDateProduced(dateRec);
        showRecord.setSerialNumber(serialNum);
        showRecord.setProductId(productId++);
        showRecord.setProductionNumber(productionNumber++);

        productShow.add(showRecord);
        prodLogTA.setText(productShow.toString());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  } // end btnRecordProduction

  /**
   * creates employee based off inputted values.
   *
   * @param actionEvent - button press that gets inputs in text fields
   * @throws SQLException - incase the database is not connected to accept a new employee object
   */
  public void createEmployee(ActionEvent actionEvent) throws SQLException {
    logEmpTA.clear();
    Employee emp = new Employee(txtfEmpName.getText(), txtfPassword.getText());
    logEmpTA.setText(emp.toString());
  }
}
