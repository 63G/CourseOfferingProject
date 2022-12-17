import java.util.ArrayList;

import javax.swing.*;

import javafx.scene.control.Button;

public class Section extends Course {
    static ArrayList<Course> cart = new ArrayList<>();
    private int CRN;
    private String time; // we will use 24 hours format
    private String Instructor;// instructor name
    private String Activity; // either a lecture or a lab
    private String SectionNumber; // this could be omitted since CRN gives us exact value
    private String Day; // for lecture / lab
    private String Location; // class location
    private String Status; // either open or closed
    private String waitList; // to register in it if the status is closed.
    private String courseDesc;
    private Button addButton;
    private Button removeButton;

    Section(String courseName, String Secnum, String Activity,
            int CRN, String CourseNamex, String Instructorname, String Day, String time, String Location,
            String Status, String waitList) {
        super(courseName);
        this.SectionNumber = Secnum;
        this.Activity = Activity; // either lec or lab
        this.CRN = CRN; // for student registration
        this.courseDesc = CourseNamex;
        this.Instructor = Instructorname; // name for the instructor
        this.Day = Day; // UMTRT
        this.Location = Location;
        this.time = time; // class time
        this.Status = Status;
        this.waitList = waitList;
        this.removeButton = new Button("REMOVE");
        this.removeButton.setId("remove-btn");
        this.removeButton.setScaleX(0);
        this.removeButton.setOnAction(e -> remover());

        this.addButton = new Button("ADD");
        this.addButton.setId("add-btn");
        this.addButton.setOnAction(e -> adder());

    }

    public void adder() {
        // ! ALG.
        // ArrayList<Course> testCart = (ArrayList<Course>) cart.clone();
        // testCart.add(this);
        // while (testCart.size() > 0) {
        // Course a = testCart.get(0);
        // testCart.remove(0);

        // for (int i = 0; i < testCart.size(); i++) {
        // if (Schedule.conflict(a, testCart.get(i))) {
        // System.out.println("confilct");
        // return;
        // }
        // }
        // }

        cart.add(this);
        this.removeButton.setScaleX(1);
        this.addButton.setScaleX(0);
    }

    public void remover() {

        cart.remove(this);
        this.addButton.setScaleX(1);
        this.removeButton.setScaleX(0);
    }

        public String getNameWithoutSec() {
        return super.getCourseName();
    }

    public int getCRN() {
        return CRN;
    }

    public String getInstructor() {
        return Instructor;
    }

    public String getSectionNumber() {
        return SectionNumber;
    }

    public String getActivity() {
        return Activity;
    }

    public String getDay() {
        return Day;
    }

    public String getLocation() {
        return Location;
    }

    public String getStatus() {
        return Status;
    }

    public String getTime() {
        return time;
    }

    public String getWaitList() {
        return waitList;
    }

    @Override
    public String getCourseName() {
        // TODO Auto-generated method stub
        return super.getCourseName() + "-" + SectionNumber;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(Button removeButton) {
        this.removeButton = removeButton;
    }

    public static ArrayList<Course> getCart() {
        return cart;
    }

    public String toString() {
        String c = "Course name is: " + super.getCourseName() + " the instructor is : " + Instructor + " this crn is: "
                + CRN
                + " section number is: " + SectionNumber + " Course Desc : " + courseDesc + ' '
                + " the activity is: " + Activity + " the day is: " + Day + " the time is " + time
                + " the location is: " + Location + " the status is: " + Status + " waitlist condition is: " + waitList
                + "\n";
        return c;

    }

    public static ArrayList<String> strArray() {
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            a.add(cart.get(i).getCourseName() + "\t" + ((Section) (cart.get(i))).getDay()
                    + "\t\t" + ((Section) (cart.get(i))).getTime());
        }
        return a;
    }
}
