import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BasketSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> Activity;

    @FXML
    private TableColumn<?, ?> AddRemove;

    @FXML
    private TableColumn<?, ?> CRN;

    @FXML
    private TableColumn<?, ?> CourseName;

    @FXML
    private TableColumn<?, ?> CourseSec;

    @FXML
    private TableColumn<?, ?> Day;

    @FXML
    private TableColumn<?, ?> Instructor;

    @FXML
    private Button Next;

    @FXML
    private Button SavedSchedule;

    @FXML
    private TableColumn<?, ?> Status;

    @FXML
    private TableColumn<?, ?> Time;

    @FXML
    private TableColumn<?, ?> WaitList;

    @FXML
    private TableView<?> table;

    @FXML
    void OnNextClicked(ActionEvent event) {

    }

    @FXML
    void OnSavedClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Activity != null : "fx:id=\"Activity\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert AddRemove != null : "fx:id=\"AddRemove\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert CRN != null : "fx:id=\"CRN\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert CourseName != null : "fx:id=\"CourseName\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert CourseSec != null : "fx:id=\"CourseSec\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Day != null : "fx:id=\"Day\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Instructor != null : "fx:id=\"Instructor\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Next != null : "fx:id=\"Next\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert SavedSchedule != null : "fx:id=\"SavedSchedule\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Status != null : "fx:id=\"Status\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert WaitList != null : "fx:id=\"WaitList\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'MainFrame.fxml'.";

    }

}
