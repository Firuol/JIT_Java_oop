import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private int totalMark;
    private String grade;

    public Student(String name, int age, int totalMark, String grade) {
        this.name = name;
        this.age = age;
        this.totalMark = totalMark;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;
    //create final file path
    private static final String FILE_PATH = "stud_info.txt";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    public void registerStudent(String name, int age, int totalMark, String grade) {
        Student student = new Student(name, age, totalMark, grade);
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student registered successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("Registered students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Total Mark: " + student.getTotalMark());
            System.out.println("Grade: " + student.getGrade());
            System.out.println();
        }
    }

    private void saveStudentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Student student : students) {
                writer.println(student.getName() + " " + student.getAge() + " " + student.getTotalMark() + " " + student.getGrade());
            }
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    private void loadStudentsFromFile() {
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    int totalMark = Integer.parseInt(parts[2]);
                    String grade = parts[3];
                    Student student = new Student(name, age, totalMark, grade);
                    students.add(student);
                }
            }
        } catch (FileNotFoundException e) {
            // File does not exist, ignore the error
        }
    }
}
 class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Student Management System -----");
            System.out.println("1. Register Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student total mark: ");
                    int totalMark = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    system.registerStudent(name, age, totalMark, grade);
                    break;
                case 2:
                    system.displayStudents();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
