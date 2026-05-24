import java.util.*;
public class University {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.showMenu();
    }
}

class Student implements Comparable<Student> {
    private String fullName;
    private String id;
    private double averagePoint;

    public Student(String fullName, String id, double gpa) {
        setFullName(fullName);
        setId(id);
        setAveragePoint(gpa);
    }

    private void setAveragePoint(double gpa) {
        this.averagePoint = gpa;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
    public String getId() {
        return id;
    }
    public double getAveragePoint() {
        return averagePoint;
    }
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }
    public int hashCode() {
        return Objects.hash(id);
    }
    public String toString() {
        return "Student: \n" +
                "name='" + this.getFullName() + '\'' + "\n" +
                "student Id='" + this.getId() + '\'' + "\n" +
                "average point=" + this.getAveragePoint() + "\n" ;
    }
}


class StudentManagement {
    private TreeSet<Student> students;

    public StudentManagement() {
        students = new TreeSet<>();
    }
    public void addStudent(String fullName, String id, double gpa) {
        Student student = new Student(fullName, id, gpa);
        students.add(student);
    }
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student Average Point: ");
                    double avg = scanner.nextDouble();
                    addStudent(fullName, id, avg);
                    break;
                case 2:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student student = findStudentById(searchId);
                    if (student != null) {
                        System.out.println("Student found: \n" + student.toString());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting!!!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again another one.");
            }
        }
    }
}
