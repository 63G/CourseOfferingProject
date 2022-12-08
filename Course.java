import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Course {
    private String CourseName;
    private List<String> Prerequisite;
    private List<String> Corequisite;
    private int CreditHours;
    //static int SectionCount = 0;
    private boolean hasALab; // ?? how to use this information

    Course(String CourseName) {
        this.CourseName = CourseName;
        getStudentPlan(new File("DegreePlan.csv"), CourseName);
        // using the course name we create a list of prerequisite and corequisites
    }

    public void getStudentPlan(File stuPlan, String Coursename){
        try{
            Scanner readFile = new Scanner(stuPlan);
            readFile.nextLine(); // the header
            String current = readFile.nextLine();
            System.out.println(current);
            while(readFile.hasNext()){
                String[] info = current.split(","); // we can create Course classes from this...
                if (info[0].equals(Coursename)) {
                    this.Prerequisite = List.of(info[2].split(";"));
                    this.Corequisite =  List.of(info[3].split(";"));
                    this.CreditHours = Integer.parseInt(info[1]);
                }

                    current = readFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File isn't found");
        }

    }

    public List<String> getPrerequisite() {
        return Prerequisite;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public List<String> getCorequisite() {
        return Corequisite;
    }

    public String getCourseName() {
        return CourseName;
    }
}

