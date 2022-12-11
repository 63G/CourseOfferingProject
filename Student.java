import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
    private List<Course> finishedCourses = new ArrayList<>();
    private List<Course> NeededCourses = new ArrayList<>();
    private List<Section> AvailableSections = new ArrayList<>();

    public Student(File FinishedCourses) {
        Student.getFinishedCourses(FinishedCourses, finishedCourses);
        getStudentPlan(new File("DegreePlan.csv"));

    }
    public void AvailableCourses(){
        for(Course e : NeededCourses){
            for(Course i : finishedCourses){
                if(e.getPrerequisite().contains(i) || e.getCorequisite().contains(i));
                AvailableSections.add((Section) e);
            }
        }

    }
    public void getStudentPlan(File stuPlan){
        try{
            Scanner readFile = new Scanner(stuPlan);
            readFile.nextLine(); // the header
            String current = readFile.nextLine();
            while(readFile.hasNext()){
                String[] info = current.split(","); // we can create Course classes from this...
                this.NeededCourses.add(new Course(info[0]));
                current = readFile.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File isn't found");
        }
    }
    public static void getFinishedCourses(File FinishedCourses, List<Course> list){
        try {
            Scanner input = new Scanner(FinishedCourses);
            String line;
            while(input.hasNext()){
                line = input.nextLine();
                String[] SectionInfo = line.split(",");
                String CourseName = SectionInfo[0];
                String Grade = SectionInfo[2];
                //list.add(new Course(CourseName,Grade));
            }
            System.out.println("DONE");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Isn't found!");
            throw new RuntimeException(e);
        }
    }

    public List<Course> getFinishedCourses() {
        return finishedCourses;
    }

    public List<Course> getNeededCourses() {
        return NeededCourses;
    }
}