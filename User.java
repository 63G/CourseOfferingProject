public class User {
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
    private String CourseName;

    User(String courseName, String Secnum, String Activity,
            int CRN, String CourseNamex, String Instructorname, String Day, String time, String Location,
            String Status, String waitList) {
        this.CourseName = courseName;
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

    public int getCRN() {
        return CRN;
    }
    
}
