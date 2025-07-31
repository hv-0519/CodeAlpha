import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        int sum = 0;
        for (int g : grades) sum += g;
        return grades.size() > 0 ? (double) sum / grades.size() : 0.0;
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int g : grades) if (g > max) max = g;
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int g : grades) if (g < min) min = g;
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

public class StudentGradeTracker {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Grade Tracker");
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            Student s = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int gCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < gCount; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = sc.nextInt();
                s.addGrade(grade);
            }
            sc.nextLine();
            students.add(s);
        }

        System.out.println("\nSummary Report:");
        for (Student s : students) {
            System.out.println("Student: " + s.name);
            System.out.println(" - Average: " + s.getAverage());
            System.out.println(" - Highest: " + s.getHighest());
            System.out.println(" - Lowest: " + s.getLowest());
            System.out.println();
        }
        sc.close();
    }
}
