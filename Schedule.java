public class Schedule {
    // important:
    // we need to figure out how to avoid time conflict with other courses,
    // how to avoid adding multiple sections of the same course
    // To work on this we first need
    public void addCourse(Section someSection) {

    }

    public static boolean conflict(Course A, Course B) {
        System.out.println(((Section) A).getDay() + " == " + ((Section) B).getDay() + "-----------------"
                + ((Section) A).getTime() + " == " + ((Section) B).getTime());
        if (((Section) A).getDay().equals(((Section) B).getDay())) {
            System.out.println("Conflict");
            return true;

        }
        return false;

    }

}