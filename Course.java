public class Course {
    private String CourseName;
    private String[] Prerequisite;
    private String[] Corequisite;
    private int CreditHours;
    //static int SectionCount = 0;
    private boolean hasALab;
    Course(String CourseName){
        this.CourseName = CourseName;
    }

}
