import javax.swing.*;

public class Section extends Course {
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

    }

    // can be handy for abdullah in the Schedule class.
    public String getNameAndSection() {
        return this.getCourseName() + "-" + this.getSectionNumber();
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
        return super.getCourseName();
    }

    public String getCourseDesc() {
        return courseDesc;
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
}