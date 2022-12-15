import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Core {
    static List<Course> SectionList = new ArrayList<Course>();

    public static void main(String[] args) {
        File Offering = new File("CourseOffering.csv");

        File FinishedCourses = new File("FinishedCourses.csv");
        OfferingToObject(Offering, SectionList);

        Student a = new Student(FinishedCourses, new File("DegreePlan.csv"));
        Schedule.conflict(a.getAvailableCourses().get(10), a.getAvailableCourses().get(15));

    }

    // i'll try to make this method general for all files.
    public static void OfferingToObject(File fileToRead, List<Course> list) {
        try {
            Scanner input = new Scanner(fileToRead);
            input.nextLine(); // this is just a header
            String line = input.nextLine();
            while (input.hasNext()) {
                String[] SectionInfo = line.split(",");
                String[] SectionNamenNumber = SectionInfo[0].split("-");
                String courseName = formatName(SectionNamenNumber[0]); // * To Make correct format
                list.add(new Section(courseName, SectionNamenNumber[1],
                        SectionInfo[1], Integer.parseInt(SectionInfo[2]), SectionInfo[3], SectionInfo[4],
                        SectionInfo[5], SectionInfo[6], SectionInfo[7], SectionInfo[8], SectionInfo[9]));
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

    // lets read other files
    public static String formatName(String courseName) {
        // ! the most important method that clean the garbage in course offering file.
        String name = "";
        for (int i = 0; i < courseName.split(" ").length; i++) {
            name += courseName.split(" ")[i];
        }

        return name;
    }

}