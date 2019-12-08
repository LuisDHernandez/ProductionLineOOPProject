package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application that launches the FX program while adding the effects of the css stylesheets.
 *
 * @author Luis Hernandez 9/30/2019
 */
public class Main extends Application {

  /**
   * The start method is the starting point of a JavaFX program. This start method sets the title.
   *
   * @brief This program will help manage product creation in a backend view for an organization
   * @author Luis Hernandez
   * @param primaryStage Set the GUI program to be viewed
   * @throws Exception throw an exception that would cause the code to crash
   */
  // ctrl alt L does automatic formatting
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    root.getStylesheets().add(getClass().getResource("ProductLine.css").toExternalForm());
    primaryStage.setTitle("Production Line");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {

    launch(args);
  }
}
