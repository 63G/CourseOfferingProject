import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Course {
    private String CourseName;
    private List<String> Prerequisite = new ArrayList<>();
    private List<String> Corequisite = new ArrayList<>();
    private List<Course> corequisiteCourse;
    private List<Course> prerequisiteCourse;
    private int CreditHours;
    private String Grade;
    //static int SectionCount = 0;
    private boolean hasALab; // ?? how to use this information

    Course(String CourseName) {
        this.CourseName = CourseName;
        getStudentPlan(new File("DegreePlan.csv"), CourseName);
        // using the course name we create a list of prerequisite and corequisites
    }

    Course(String CourseName, String Grade) {
        this.CourseName = CourseName;
        this.Grade = Grade;
        getStudentPlan(new File("DegreePlan.csv"), CourseName);
        // using the course name we create a list of prerequisite and corequisites
    }

    // rework this
    public void getStudentPlan(File stuPlan, String Coursename){
        try{
            Scanner readFile = new Scanner(stuPlan);
            String current = readFile.nextLine();
            while(readFile.hasNext()){
                String[] info = current.split(","); // we can create Course classes from this...
                if (info[0].equals(Coursename)) {
                    String[] PrerequisiteArr = info[2].split(";");
                    String[] CorequisiteArr =  info[3].split(";");
                    this.corequisiteCourse = ArraytoCourse(CorequisiteArr);
                    this.prerequisiteCourse = ArraytoCourse(PrerequisiteArr);
                    // ICS108 ICS 108 use strip!!!
                    this.Prerequisite.addAll(Arrays.asList(PrerequisiteArr));
                    this.Corequisite.addAll(Arrays.asList(CorequisiteArr));
                    this.CreditHours = Integer.parseInt(info[1]);
                }

                current = readFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File isn't found");
        }

    }
    public List<Course> ArraytoCourse(String[] list){
        List<Course> result = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            if(!(list[i].equals("None")))
                result.add(new Course(list[i].replaceAll(" ", "")));

        }
        return result;
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
    public void setGrade(String grade) {
        Grade = grade;
    }
    public String getGrade() {
        return Grade;
    }
//    public String toString() {
//
//        //return //"Course name is "+ CourseName+" The Prerequisite is "+Prerequisite+" the Corequisite is "+Corequisite+" the credit hours is "+CreditHours;
//    }

    public List<Course> getCorequisiteCourse() {
        return corequisiteCourse;
    }

    public List<Course> getPrerequisiteCourse() {
        return prerequisiteCourse;
    }
}