import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
    private List<Course> finishedCourses = new ArrayList<>();
    private List<Course> NeededCourses = new ArrayList<>();
    static List<Course> AvailableCourses = new ArrayList<>();
    private List<Course> SectionList = new ArrayList<Course>();

    public Student(File FinishedCourses, File offering) {
        getFinishedCourses(FinishedCourses, finishedCourses);
        fillNeededCourses(offering);

        AvailableCourses(AvailableCourses);

    }

    public void AvailableCourses(List<Course> AvailableCourses) {
        // ! Add only courses that he should register
        List<Course> allCourses = Core.SectionList;

        for (int i = 0; i < allCourses.size(); i++) {

            List<Course> pre = allCourses.get(i).getPrerequisiteCourse();

            for (int j = 0; j < NeededCourses.size(); j++) {

                if (Core.formatName(allCourses.get(i).getCourseName()).equals(NeededCourses.get(j).getCourseName())
                        && pre.isEmpty() && !IsFinished(allCourses.get(i))) {
                    // ! check if the course is in plan but dosen't have prerequisit
                    AvailableCourses.add(allCourses.get(i));
                }
            }

            for (int j = 0; j < pre.size(); j++) {
                for (int j2 = 0; j2 < finishedCourses.size(); j2++) {
                    // ! check if the student finished the prerequisit
                    if (finishedCourses.get(j2).getCourseName().equals(pre.get(j).getCourseName())
                            && !IsFinished(allCourses.get(i))) {
                        AvailableCourses.add(allCourses.get(i));

                    }
                }
            }

        }
        System.out.println(AvailableCourses);
    }

    public void fillNeededCourses(File F32) { // ! method to add the courses that he should register
        try {
            Scanner input = new Scanner(F32);
            input.nextLine();
            String line;
            while (input.hasNext()) {
                line = input.nextLine();

                String[] SectionInfo = line.split(",");
                NeededCourses.add(new Course(Core.formatName(SectionInfo[0].split("-")[0])));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getFinishedCourses(File FinishedCourses, List<Course> list) {
        try {
            Scanner input = new Scanner(FinishedCourses);
            String line;
            while (input.hasNext()) {
                line = input.nextLine();
                String[] SectionInfo = line.split(",");
                String CourseName = Core.formatName(SectionInfo[0]);

                String Grade = SectionInfo[2];
                list.add(new Course(CourseName));
            }
            System.out.println("DONE");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Isn't found!");
            throw new RuntimeException(e);
        }
    }

    public boolean IsFinished(Course a) {
        boolean Flag = false;
        for (int i = 0; i < finishedCourses.size(); i++) {
            if (a.getCourseName().equals(finishedCourses.get(i).getCourseName())) {
                Flag = true;
            }

        }
        return Flag;
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

}