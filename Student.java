import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
    List<Course> finishedCourses = new ArrayList<>();
    

public Student(File FinishedCourses) {
    Student.getFinishedCourses(FinishedCourses, finishedCourses);
}


    public static void getFinishedCourses(File FinishedCourses, List<Course> list){
        try {
            Scanner input = new Scanner(FinishedCourses);
            
            String line;
            while(input.hasNext()){
                line = input.nextLine();
                String[] SectionInfo = line.split(",");
                System.out.println(Arrays.toString(SectionInfo));
                String CourseName = SectionInfo[0];
                String Grade = SectionInfo[2];
               
                list.add(new Course(CourseName,Grade));
               
              
            }
            System.out.println(list);
            System.out.println("DONE");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Isn't found!");
            throw new RuntimeException(e);
        }
    }

}
