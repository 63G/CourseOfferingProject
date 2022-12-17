import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

import javax.security.auth.Subject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class Course implements Serializable {
    private String courseName;
    File Plan = new File("DegreePlan.csv");
    private List<String> Prerequisite = new ArrayList<>();
    private List<String> Corequisite = new ArrayList<>();
    private ArrayList<Course> corequisiteCourse = new ArrayList<>();
    private ArrayList<Course> prerequisiteCourse = new ArrayList<>();
    private int creditHours;
    private String grade;

    Course(String courseName) {
        this.courseName = courseName;
        this.getStudentPlanDH7(Plan, courseName);

        // using the course name we create a list of prerequisite and corequisites
    }

    Course(String courseName, Button button) {
        System.out.println("hi");
    }

    // ! new function to read the prerequisite and corequisite courses correctly and
    // ! added them to each corresponding course.
    public void getStudentPlanDH7(File Planfile, String courseName) {
        try {
            Scanner input = new Scanner(Planfile);
            input.nextLine();
            String line;
            while (input.hasNext()) {
                line = input.nextLine();
                String[] SectionInfo = line.split(",");
                // System.out.println(Core.formatName(courseName) + "---" +
                // Core.formatName(SectionInfo[0]));

                if (Core.formatName(SectionInfo[0]).equals(Core.formatName(courseName))) {
                    // Pre
                    {
                        String pre = Core.formatName(SectionInfo[2]);
                        if (pre.equals("None"))
                            return;
                        String[] courses = pre.split(";"); // [ics 104] , [phys 101 , math 101]
                        for (int i = 0; i < courses.length; i++) {
                            this.prerequisiteCourse.add(new Course(courses[i]));
                        }

                    }
                    // Co

                    {
                        String co = Core.formatName(SectionInfo[3]);
                        if (co.equals("None"))
                            return;

                        String[] courses = co.split(";"); // [ics 104] , [phys 101 , math 101]
                        for (int i = 0; i < courses.length; i++) {
                            this.corequisiteCourse.add(new Course(courses[i]));
                        }

                    }
                }
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }

    public List<Course> ArraytoCourse(String[] list) {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (!(list[i].equals("None")))
                result.add(new Course(list[i].replaceAll(" ", "")));

        }
        return result;
    }

    public ArrayList<String> getPrerequisite() {
        ArrayList<String> String = new ArrayList<>();
        for (int i = 0; i < this.getPrerequisiteCourse().size(); i++) {
            String.add(this.getPrerequisiteCourse().get(i).courseName);
        }
        return String;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public List<String> getCorequisite() {
        return Corequisite;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setGrade(String grade) {
        grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String toString() {
        return "Course name is " + courseName + " The Prerequisite is " +
                Prerequisite + " the Corequisite is "
                + Corequisite + " the credit hours is " + creditHours;

    }

    public List<Course> getCorequisiteCourse() {
        return corequisiteCourse;
    }

    public List<Course> getPrerequisiteCourse() {
        return this.prerequisiteCourse;
    }

}