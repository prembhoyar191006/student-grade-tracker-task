import java.util.ArrayList;
import java.util.Scanner;

public class studentgradetrackertask {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Grade Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine();

                    names.add(name);
                    grades.add(grade);

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (names.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {

                        System.out.println("\n==============================================");
                        System.out.printf("%-20s %-10s %-10s\n",
                                "Student Name", "Grade", "Class");
                        System.out.println("==============================================");

                        for (int i = 0; i < names.size(); i++) {

                            String gradeClass = getGrade(grades.get(i));

                            System.out.printf("%-20s %-10.2f %-10s\n",
                                    names.get(i),
                                    grades.get(i),
                                    gradeClass);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student Name to Search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < names.size(); i++) {

                        if (names.get(i).equalsIgnoreCase(searchName)) {

                            System.out.println("\nStudent Found!");
                            System.out.println("Name  : " + names.get(i));
                            System.out.println("Grade : " + grades.get(i));
                            System.out.println("Class : " + getGrade(grades.get(i)));

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:

                    if (grades.isEmpty()) {
                        System.out.println("No data available.");
                    } else {

                        double total = 0;
                        double highest = grades.get(0);
                        double lowest = grades.get(0);

                        for (double g : grades) {

                            total += g;

                            if (g > highest)
                                highest = g;

                            if (g < lowest)
                                lowest = g;
                        }

                        double average = total / grades.size();

                        System.out.println("\n===== GRADE STATISTICS =====");
                        System.out.printf("Average Score : %.2f\n", average);
                        System.out.printf("Highest Score : %.2f\n", highest);
                        System.out.printf("Lowest Score  : %.2f\n", lowest);
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    public static String getGrade(double marks) {

        if (marks >= 90)
            return "A";

        else if (marks >= 80)
            return "B";

        else if (marks >= 70)
            return "C";

        else if (marks >= 60)
            return "D";

        else
            return "F";
    }
}