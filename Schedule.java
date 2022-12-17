import java.util.List;

public class Schedule {
    // important:
    // we need to figure out how to avoid time conflict with other courses,
    // how to avoid adding multiple sections of the same course
    // To work on this we first need
    public void addCourse(Section someSection) {

    }

    public static boolean conflict(Course A, Course B) {
        String aDay = ((Section) A).getDay();
        String bDay = ((Section) B).getDay();

        if (!aDay.contains(bDay)) {
            // * NOT on same day
            // * NOT conflict
            return false;
        }

        int aTimeStart = Integer.parseInt(((Section) A).getTime().split("-")[0]); // 800
        int aTimeEnd = Integer.parseInt(((Section) A).getTime().split("-")[1]); // 850

        int bTimeStart = Integer.parseInt(((Section) B).getTime().split("-")[0]); // 830
        int bTimeEnd = Integer.parseInt(((Section) B).getTime().split("-")[1]); // 920

        boolean stateOne = bTimeStart <= aTimeEnd && bTimeStart >= aTimeStart;
        boolean stateTwo = aTimeStart <= bTimeEnd && aTimeStart >= bTimeStart;

        if (stateOne || stateTwo) {
            // * conflict
            return true;
        }

        // * They are on same day but not conflict
        return false;
    }

    public static boolean isRepeat(Course a, Course b) {
        if (((Section) a).getNameWithoutSec().equals(((Section) b).getNameWithoutSec())) {
            if (((Section) a).getActivity().equals(((Section) b).getActivity())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean hasLab(Course a) { // ! this function check if couse has lab
        List<Course> ShowedCourses = Student.AvailableCourses;

        // get course name check all section that have this name and activity lab if it
        // happend return true; otherwise return false
        for (int i = 0; i < ShowedCourses.size(); i++) {
            if (Core.formatName(a.getCourseName()).equals(Core.formatName(ShowedCourses.get(i).getCourseName()))) {
                if (((Section) ShowedCourses.get(i)).getActivity().equals("LAB")) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean hasRec(Course a) { // ! this function check if couse has rec
        List<Course> ShowedCourses = Student.AvailableCourses;

        // get course name check all section that have this name and activity lab if it
        // happend return true; otherwise return false
        for (int i = 0; i < ShowedCourses.size(); i++) {
            if (Core.formatName(a.getCourseName()).equals(Core.formatName(ShowedCourses.get(i).getCourseName()))) {
                if (((Section) ShowedCourses.get(i)).getActivity().equals("REC")) {
                    return true;
                }
            }
        }
        return false;
    }

}
