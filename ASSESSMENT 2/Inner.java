package DAY23;
import java.util.*;

// Class for Authentication System using an Inner Class
class Authenticator {
    private String correctPassword = "admin123";

    // Inner class to validate password
    private class Validator {
        private boolean validate(String inputPassword) {
            return correctPassword.equals(inputPassword);
        }
    }

    // Method to perform login
    public void login(String password) {
        Validator validator = new Validator();
        if (validator.validate(password)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Incorrect Password");
        }
    }
}

// Class for Student representation
class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

// Main class to test both functionalities
public class Inner {
    public static void main(String[] args) {
        // Q9: Testing the Authentication System
        Authenticator auth = new Authenticator();
        auth.login("admin123"); // Expected Output: Login Successful
        auth.login("wrongPass"); // Expected Output: Incorrect Password

        // Q10: Sorting Students using an Anonymous Comparator
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 90),
            new Student("Charlie", 78)
        );

        // Anonymous inner class to sort students by marks
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.marks - s1.marks; // Descending order
            }
        });

        // Display sorted student list
        System.out.println("\nSorted Student List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
