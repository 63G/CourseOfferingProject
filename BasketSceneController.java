import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BasketSceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private List<Section> secList = Core.getSecList();

    public void switchToScheduleScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScheduleSceneController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setTitle("Schedule Planner");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Section, String> Activity;

    // @FXML // todo don't forget uncomment
    // private TableColumn<?, ?> AddRemove;

    @FXML
    private TableColumn<Section, Integer> CRN;

    @FXML
    private TableColumn<Section, String> CourseName;

    @FXML
    private TableColumn<Section, String> course;

    @FXML
    private TableColumn<Section, String> Day;

    @FXML
    private TableColumn<Section, String> Instructor;

    @FXML
    private Button Next;

    @FXML
    private Button SavedSchedule;

    @FXML
    private TableColumn<Section, String> Status;

    @FXML
    private TableColumn<Section, String> Time;

    @FXML
    private TableColumn<Section, String> WaitList;

    @FXML
    private TableView<Section> table;

    @FXML
    void OnNextClicked(ActionEvent event) {

    }

    @FXML
    void OnSavedClicked(ActionEvent event) {

    }

    // (Section) Student.getAvailableCourses()
    // Section secList = (Section) Student.getAvailableCourses();
    // ArrayList<Section> secList = (ArrayList<Section>)
    // Student.getAvailableCourses();
    // ObservableList<Course> list = FXCollections.observableArrayList(
    // new Course("IAS111")
    // );

    // @FXML
    // void initialize() {
    // assert Activity != null : "fx:id=\"Activity\" was not injected: check your
    // FXML file 'MainFrame.fxml'.";
    // assert AddRemove != null : "fx:id=\"AddRemove\" was not injected: check your
    // FXML file 'MainFrame.fxml'.";
    // assert CRN != null : "fx:id=\"CRN\" was not injected: check your FXML file
    // 'MainFrame.fxml'.";
    // assert CourseName != null : "fx:id=\"CourseName\" was not injected: check
    // your FXML file 'MainFrame.fxml'.";
    // assert CourseSec != null : "fx:id=\"CourseSec\" was not injected: check your
    // FXML file 'MainFrame.fxml'.";
    // assert Day != null : "fx:id=\"Day\" was not injected: check your FXML file
    // 'MainFrame.fxml'.";
    // assert Instructor != null : "fx:id=\"Instructor\" was not injected: check
    // your FXML file 'MainFrame.fxml'.";
    // assert Next != null : "fx:id=\"Next\" was not injected: check your FXML file
    // 'MainFrame.fxml'.";
    // assert SavedSchedule != null : "fx:id=\"SavedSchedule\" was not injected:
    // check your FXML file 'MainFrame.fxml'.";
    // assert Status != null : "fx:id=\"Status\" was not injected: check your FXML
    // file 'MainFrame.fxml'.";
    // assert Time != null : "fx:id=\"Time\" was not injected: check your FXML file
    // 'MainFrame.fxml'.";
    // assert WaitList != null : "fx:id=\"WaitList\" was not injected: check your
    // FXML file 'MainFrame.fxml'.";
    // assert table != null : "fx:id=\"table\" was not injected: check your FXML
    // file 'MainFrame.fxml'.";
    // }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // System.out.println(CRN);
        // TODO Auto-generated method stub
        course.setCellValueFactory(new PropertyValueFactory<Section, String>("courseName"));
        Activity.setCellValueFactory(new PropertyValueFactory<Section, String>("Activity"));
        CRN.setCellValueFactory(new PropertyValueFactory<Section, Integer>("CRN"));
        CourseName.setCellValueFactory(new PropertyValueFactory<Section, String>("courseDesc"));
        Instructor.setCellValueFactory(new PropertyValueFactory<Section, String>("Instructor"));
        Day.setCellValueFactory(new PropertyValueFactory<Section, String>("Day"));
        Time.setCellValueFactory(new PropertyValueFactory<Section, String>("time"));
        Status.setCellValueFactory(new PropertyValueFactory<Section, String>("Status"));
        WaitList.setCellValueFactory(new PropertyValueFactory<Section, String>("waitList"));
        setUpTable();
    } 

    private void setUpTable() {
        for (int i = 0; i < secList.size(); i++) {
            Section a = secList.get(i);
            System.out.println(a);
            table.getItems().add(a);
        }
    }

}
