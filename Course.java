public class Course {
    private String CourseName;
    static int SectionCount = 0;
    private boolean hasALab;
    Course(String CourseName){
        this.CourseName = CourseName;
        SectionCount++;
    }

}
