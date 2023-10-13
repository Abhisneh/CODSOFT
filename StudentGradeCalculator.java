import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator");

        // Prompt the user to enter the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        for (int student = 1; student <= numStudents; student++) {
            double totalMarks = 0.0;

            System.out.print("Enter the name of Student " + student + ": ");
            String studentName = scanner.next();
            
            System.out.println("Enter marks for " + studentName + ":");
            double[] marks = new double[6];

            for (int subject = 0; subject < 6; subject++) {
                String subjectName;
                switch (subject) {
                    case 0:
                        subjectName = "Maths";
                        break;
                    case 1:
                        subjectName = "English";
                        break;
                    case 2:
                        subjectName = "Physics";
                        break;
                    case 3:
                        subjectName = "Chemistry";
                        break;
                    case 4:
                        subjectName = "Biology";
                        break;
                    case 5:
                        subjectName = "Computer Science";
                        break;
                    default:
                        subjectName = "Unknown";
                }

                System.out.print("Enter marks for " + subjectName + ": ");
                marks[subject] = scanner.nextDouble();
                totalMarks += marks[subject];
            }

            double averageMarks = totalMarks / 6;
            char grade = calculateGrade(averageMarks);

            System.out.println("Student: " + studentName);
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Marks: " + averageMarks);
            System.out.println("Grade: " + grade);
        }

        scanner.close();
    }

    public static char calculateGrade(double averageMarks) {
        if (averageMarks >= 90) {
            return 'A';
        } else if (averageMarks >= 80) {
            return 'B';
        } else if (averageMarks >= 70) {
            return 'C';
        } else if (averageMarks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
