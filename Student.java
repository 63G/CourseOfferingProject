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
    private List<Course> AvailableCourses = new ArrayList<>();
    private List<Course> SectionList = new ArrayList<Course>();

    public Student(File FinishedCourses) {
        Student.getFinishedCourses(FinishedCourses, finishedCourses);
        getStudentPlan(new File("DegreePlan.csv"));
        File Offering = new File("CourseOffering.csv");
        OfferingToObject(Offering, SectionList);

    }
    public void AvailableCourses(){
        for(Course e : SectionList){
            if(NeededCourses.contains(e))
                SectionList.add(e);
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
                list.add(new Course(CourseName,Grade));
            }
            System.out.println("DONE");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Isn't found!");
            throw new RuntimeException(e);
        }
    }

    public List<Course> getSectionList() {
        return SectionList;
    }

    public List<Course> getFinishedCourses() {
        return finishedCourses;
    }

    public List<Course> getNeededCourses() {
        return NeededCourses;
    }

    public List<Course> getAvailableCourses() {
        return AvailableCourses;
    }
    public static void OfferingToObject(File fileToRead, List<Course> list){
        try {
            Scanner input = new Scanner(fileToRead);
            input.nextLine(); // this is just a header
            String line = input.nextLine();
            while(input.hasNext()){
                String[] SectionInfo = line.split(",");
                String[] SectionNamenNumber = SectionInfo[0].split("-");
                list.add(new Section(SectionNamenNumber[0], SectionNamenNumber[1],
                        SectionInfo[1], Integer.parseInt(SectionInfo[2]), SectionInfo[3], SectionInfo[4], SectionInfo[5], SectionInfo[6], SectionInfo[7], SectionInfo[8], SectionInfo[9]));
                line = input.nextLine();
            }
            System.out.println("DONE, We have sectiob objects");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Isn't found!");
            throw new RuntimeException(e);
        }
        //

    }
}