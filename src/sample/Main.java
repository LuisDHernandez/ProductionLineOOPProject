package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Luis Hernandez
 */
public class Main extends Application {

  /**
   * The start method is the starting point of a JavaFX program. This start method sets the title.
   *
   * @author Luis Hernandez
   * @param primaryStage Set the GUI program to be viewed
   * @throws Exception throw an exception that would cause the code to crash
   */
  // ctrl alt L does automatic formatting
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  public static void main(String[] args) {

    launch(args);

  }
}
