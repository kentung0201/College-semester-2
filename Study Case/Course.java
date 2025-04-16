package casestudy;

public class Course {
    String CRScode, CRSname;
    int sks;

    public Course(String CRScode, String CRSname, int sks) {
        this.CRScode = CRScode;
        this.CRSname = CRSname;
        this.sks = sks;
    }

    void showData() {
        System.out.println("Course Code: " + CRScode);
        System.out.println("Course Name: " + CRSname);
        System.out.println("SKS: " + sks);
    }
}
