import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        File Offering = new File("CourseOffering.csv");
        File Plan = new File("DegreePlan.csv");
        File FinishedCourses = new File("FinishedCourses.csv");
        List<Course> SectionList = new ArrayList<Course>();
        OfferingToObject(Offering, SectionList);
        // checking method worked
        System.out.println();
        Section lmao = (Section) SectionList.get(71);
        System.out.println("-------------------------------------------");
        System.out.println(lmao.getCourseName());
        System.out.println(lmao.getCreditHours());

        System.out.println(lmao.getCorequisite());
        System.out.println(lmao.getPrerequisite());

        //

    }
    // i'll try to make this method general for all files.
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
    // lets read other files

}