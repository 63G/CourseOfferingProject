import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ScheduleSceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    static ArrayList<Course> addded = new ArrayList<>();

    // this will switch to basket Scene
    public void switchToBasketScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BasketSceneController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Available Courses Next Semester");
        stage.setScene(scene);
        stage.show();
    }

    // Rectangle rectangle = new Rectangle(102, );

    @FXML
    private Label myLable;

    @FXML
    private ListView<String> myListView;

    // String[] food = new String[addded.size()];// basket
    ArrayList<Course> cart = Section.getCart();
    String activeCourse = cart.get(0).getCourseName();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    DraggableMaker draggableMaker = new DraggableMaker();

    @FXML
    void initialize() {
        draggableMaker.makeDraggable(rect1);

    }

    @FXML
    private Rectangle rect1;

    @Override // This method to add list elemnts to table in GUI
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        myListView.getItems().addAll(Section.strArray());
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // TODO Auto-generated method stub
                activeCourse = myListView.getSelectionModel().getSelectedItem();// this will stor the select Item on the
                                                                                // table to current food
                myLable.setText(activeCourse);// this will set the label to the current food
            }

        });

    }

}
