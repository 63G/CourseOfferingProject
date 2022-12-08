import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Course {
    private String CourseName;
    private List<String> Prerequisite;
    private List<String> Corequisite;
    private int CreditHours;
    //static int SectionCount = 0;
    private boolean hasALab;
    Course(String CourseName){
        this.CourseName = CourseName;

        // using the course name we create a list of prerequisite and corequisites
    }
    public static void getStudentCourses(File stuPlan, String name){
        try{
            List<String> someList = new ArrayList<>();
            Scanner readFile = new Scanner(stuPlan);
            readFile.nextLine(); // the header
            String current = readFile.nextLine();
            while(readFile.hasNext()){
                String[] info = current.split(","); // we can create Course classes from this...
                someList.add(Arrays.toString(info));
                current = readFile.nextLine();
            }
            System.out.println(someList);
        } catch (FileNotFoundException e) {
            System.out.println("File isn't found");
        }
    public static void locatePrerequisite(String courseName){

    }
}
