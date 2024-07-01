
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class University {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        management.showMenu();
    }
}

class Student implements Comparable<Student> {
    private String name;
    private String studentId;
    private double avragePoint;

    public Student(String name, String studentId, double gpa) {
        setName(name);
        setStuId(studentId);
        setAvgPoint(gpa);
    }

    private void setAvgPoint(double gpa) {
        this.avragePoint = gpa;
    }

    private void setStuId(String studentId) {
        this.studentId = studentId;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getStudentId() {
        return studentId;
    }
    public double getAvragePoint() {
        return avragePoint;
    }
    public int compareTo(Student other) {
        return this.studentId.compareTo(other.studentId);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }
    public int hashCode() {
        return Objects.hash(studentId);
    }
    public String toString() {
        return "Student: \\n" +
                "name='" + this.getName() + '\\'' + "\\n" +

        "student Id='" + this.getStudentId() + '\\'' + "\\n" +
        "avrage point=" + this.getAvragePoint() + "\\n" ;
    }
}

class StudentManagement {
    private TreeSet<Student> students;
    private static final String key = "ThisIsASecretKey";

    public StudentManagement() {
        students = new TreeSet<>();
    }

    public void addStudent(String name, String studentId, double gpa) {
        Student student = new Student(name, studentId, gpa);
        students.add(student);
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
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
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter student Average Point: ");
                    double avg = scanner.nextDouble();
                    addStudent(name, studentId, avg);
                    break;
                case 2:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student student = findStudentById(searchId);
                    if (student != null) {
                        System.out.println("Student found: \\n" + student.toString());
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

    private static byte[] encrypt(String plainText) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText.getBytes());
    }

    private static String decrypt(byte[] cipherText) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return new String(cipher.doFinal(cipherText));
    }
}

