import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> Activity;

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
    private TableColumn<?, ?> Status;

    @FXML
    private TableColumn<?, ?> Time;

    @FXML
    private TableColumn<?, ?> WaitList;

    @FXML
    void initialize() {
        assert Activity != null : "fx:id=\"Activity\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert CRN != null : "fx:id=\"CRN\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert CourseName != null : "fx:id=\"CourseName\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert CourseSec != null : "fx:id=\"CourseSec\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Day != null : "fx:id=\"Day\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Instructor != null : "fx:id=\"Instructor\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Status != null : "fx:id=\"Status\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file 'MainFrame.fxml'.";
        assert WaitList != null : "fx:id=\"WaitList\" was not injected: check your FXML file 'MainFrame.fxml'.";

    }

}
