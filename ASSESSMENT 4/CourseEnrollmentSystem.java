package DAY5;

import java.util.*;

class Course {
    private String code;
    private String name;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return code + ": " + name;
    }
}

public class CourseEnrollmentSystem {
    public static void main(String[] args) {
        LinkedList<Course> courses = new LinkedList<>();
        courses.add(new Course("CS101", "Intro to Programming"));
        courses.add(new Course("MATH202", "Advanced Calculus"));
        courses.add(new Course("ENG105", "Technical Writing"));

        // Sorting alphabetically
        Collections.sort(courses, Comparator.comparing(c -> c.toString()));

        // Using ListIterator for forward/backward navigation
        ListIterator<Course> it = courses.listIterator();
        System.out.println("Courses (forward):");
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nCourses (backward):");
        while (it.hasPrevious()) System.out.println(it.previous());

        // Dropping a course
        it = courses.listIterator();
        while (it.hasNext()) {
            if (it.next().toString().contains("Calculus")) {
                it.remove();
                System.out.println("\nAfter dropping MATH202:");
                courses.forEach(System.out::println);
                break;
            }
        }
    }
}
