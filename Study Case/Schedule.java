package casestudy;

public class Schedule {
    Lecturer lcr;
    Course crs;
    String day, hour;

    public Schedule(Lecturer lecturerList, Course CourseList, String day, String hour) {
        this.day = day;
        this.hour = hour;
        this.lcr = lecturerList;
        this.crs = CourseList;
    }

    void showData() {
        System.out.println("Name: " + lcr.lecturerName);
        System.out.println("Course Code: " + crs.CRScode);
        System.out.println("SKS: " + crs.sks);
        System.out.println("Day: " + day);
        System.out.println("Hour: " + hour);
        System.out.println("Duration: " + calculateMinute() + " minute");
    }
    
    int calculateMinute() {
        return crs.sks * 50;
    }

}