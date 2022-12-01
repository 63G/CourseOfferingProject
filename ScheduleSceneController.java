import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ScheduleSceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToBasketScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("BasketSceneController.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void initialize() {

    }

}
