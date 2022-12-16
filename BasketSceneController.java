import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.Action;

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
import javafx.scene.control.Cell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BasketSceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private List<Course> secList = Student.AvailableCourses;

    public void switchToScheduleScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScheduleSceneController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1200, 800);

        stage.setTitle("Schedule Planner");
        stage.setScene(scene);
        // stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Section, String> Activity;

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
    private TableColumn<Section, Button> add;

    @FXML
    private TableColumn<Section, Button> remove;

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

    @FXML
    public void handler(ActionEvent e) {
        // System.out.println(a.getCourseName());

    }

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
        add.setCellValueFactory(new PropertyValueFactory<Section, Button>("addButton"));
        WaitList.setCellValueFactory(new PropertyValueFactory<Section, String>("waitList"));
        add.setCellValueFactory(new PropertyValueFactory<Section, Button>("addButton"));
        remove.setCellValueFactory(new PropertyValueFactory<Section, Button>("removeButton"));
        setUpTable();

    }

    public void setUpTable() {

        for (int i = 0; i < secList.size(); i++) {
            Course a = secList.get(i);
            table.getItems().add((Section) a);

        }
    }

}