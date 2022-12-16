import java.io.IOException;
import java.util.Base64;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyJavaFX extends Application {
  private final int STAGE_WIDTH = 800;
  private final int STAGE_HEIGHT = 350;
  private final String BUTTON_FONT = "Verdana";
  private final double BUTTON_FONT_SIZE = 12;

  @Override // Override the start method in the Application class
  public void start(Stage stage) {
    // Stage stage = new Stage(); //you can add a stage if you want
    try {
      Parent root = FXMLLoader.load(getClass().getResource("BasketSceneController.fxml"));
      Scene scene = new Scene(root);

      Image img = new Image("شعار الجامعة.png");
      stage.getIcons().add(img);
      stage.setTitle("Available Courses Next Semester");
      stage.setScene(scene);
      stage.show();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    Core.main(null);
    launch(args);
  }

}
