package DAY23;
import java.util.*;
class Student {
    private String name;
    private int marks;
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }
    public void display() {
        System.out.println(name + ": " + marks);
    }
}
public class Anonymous {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 90),
            new Student("Charlie", 78)
        );
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMarks(), s1.getMarks()); // Sorting in descending order
            }
        });

        // Display sorted list
        System.out.println("Students sorted by marks (Descending Order):");
        for (Student s : students) {
            s.display();
        }
    }
}
