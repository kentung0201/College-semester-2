package casestudy;

import java.util.Scanner;

public class mainData {
    public static void main(String[] args) {
        Lecturer[] lecturerList = {
                new Lecturer("W001", "Cristiano Ronaldo"),
                new Lecturer("W002", "Kobe Bryant"),
                new Lecturer("W003", "Leonardo Dicaprio"),
                new Lecturer("W004", "Anthony Santos"),
                new Lecturer("W005", "Mykhailo Mudryk")
        };

        Course[] courseList = {
                new Course("L001", "Data Structure", 3),
                new Course("L002", "Java Programming", 2),
                new Course("L003", "Data Base", 3),
                new Course("L004", "Algorithm", 1),
                new Course("L005", "Mathematic", 2),
                new Course("L006", "Computer Network", 3),
                new Course("L007", "Web Programming", 2)
        };

        Schedule[] scheduleList = {
                new Schedule(lecturerList[0], courseList[0], "Monday", "08:00"),
                new Schedule(lecturerList[1], courseList[1], "Tuesday", "10:00"),
                new Schedule(lecturerList[2], courseList[2], "Wednesday", "09:00"),
                new Schedule(lecturerList[0], courseList[3], "Thursday", "13:00"),
                new Schedule(lecturerList[3], courseList[4], "Friday", "07:00"),
                new Schedule(lecturerList[4], courseList[5], "Monday", "11:00"),
                new Schedule(lecturerList[1], courseList[6], "Wednesday", "14:00")
        };

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== LECTURE SCHEDULE MANAGEMENT SYSTEM =====");
            System.out.println("1. Display Lecturer Data");
            System.out.println("2. Display Course Data");
            System.out.println("3. Display Schedule Data");
            System.out.println("4. Sort Schedule By Date and Hour");
            System.out.println("5. Search Schedule Based On Lecturer Name");
            System.out.println("0. Exit");
            System.out.print("Choose Menu: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    displayLecturerData(lecturerList);
                    break;
                case 2:
                    displayCourseData(courseList);
                    break;
                case 3:
                    displayScheduleData(scheduleList);
                    break;
                case 4:
                    sortScheduleByDayHour(scheduleList);
                    break;
                case 5:
                    searchScheduleByLecturerName(scheduleList, sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void displayLecturerData(Lecturer[] lecturerList) {
        System.out.println("\n=== LECTURER DATA ===");
        for (Lecturer lecturer : lecturerList) {
            lecturer.showData();
            System.out.println();
        }
    }

    public static void displayCourseData(Course[] courseList) {
        System.out.println("\n=== COURSE DATA ===");
        for (Course course : courseList) {
            course.showData();
            System.out.println();
        }
    }

    public static void displayScheduleData(Schedule[] scheduleList) {
        System.out.println("\n=== SCHEDULE DATA ===");
        for (Schedule schedule : scheduleList) {
            schedule.showData();
            System.out.println();
        }
    }

    public static void sortScheduleByDayHour(Schedule[] scheduleList) {
        Schedule[] sortedSchedules = new Schedule[scheduleList.length];
        System.arraycopy(scheduleList, 0, sortedSchedules, 0, scheduleList.length);

        for (int i = 0; i < sortedSchedules.length - 1; i++) {
            for (int j = 0; j < sortedSchedules.length - i - 1; j++) {
                int dayComparison = sortedSchedules[j].day.compareTo(sortedSchedules[j + 1].day);
                if (dayComparison > 0 || (dayComparison == 0 && sortedSchedules[j].hour.compareTo(sortedSchedules[j + 1].hour) > 0)) {

                    Schedule temp = sortedSchedules[j];
                    sortedSchedules[j] = sortedSchedules[j + 1];
                    sortedSchedules[j + 1] = temp;
                }
            }
        }

       
            System.out.println("\n=== SORTED SCHEDULE (Days & Hours) ===");
            for (Schedule schedule : sortedSchedules) {
                System.out.printf("%s - %s | %s - %s\n",
                        schedule.day,
                        schedule.hour,
                        schedule.lcr.lecturerName,
                        schedule.crs.CRSname);
            }
    }

    public static void searchScheduleByLecturerName(Schedule[] scheduleList, Scanner scanner) {
        System.out.print("\nEnter lecturer name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        System.out.println("\n=== SCHEDULE SEARCH RESULT ===");
        for (Schedule schedule : scheduleList) {
            if (schedule.lcr.lecturerName.equalsIgnoreCase(searchName)) {
                found = true;
                System.out.println("Lecturer: " + schedule.lcr.lecturerName);
                System.out.println("Course: " + schedule.crs.CRSname);
                System.out.println("Day: " + schedule.day);
                System.out.println("Hours: " + schedule.hour);
                System.out.println();
            }
        }

        if (!found) {
            System.out.println("Data for lecturers with the name \"" + searchName + "\" was not found.");
        }
    }
}

