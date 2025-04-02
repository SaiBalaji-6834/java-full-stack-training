package DAY6;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private Optional<LocalDateTime> lastLogin;

    public Employee(int id, String name, LocalDateTime lastLogin) {
        this.id = id;
        this.name = name;
        this.lastLogin = Optional.ofNullable(lastLogin);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Optional<LocalDateTime> getLastLogin() { return lastLogin; }

    public void display() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm a");
        String lastLoginStr = lastLogin.map(formatter::format).orElse("No Record");
        System.out.println(id + " | " + name + " | Last Login: " + lastLoginStr);
    }
}

public class AttendanceTracker {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice", LocalDateTime.now().minusDays(10)),
            new Employee(102, "Bob", LocalDateTime.now().minusDays(3)),
            new Employee(103, "Charlie", LocalDateTime.now().minusDays(7)),
            new Employee(104, "David", null)
        );

        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);

        // Employees who haven't logged in for the past 7 days
        List<Employee> inactiveEmployees = employees.stream()
            .filter(emp -> emp.getLastLogin().map(date -> date.isBefore(sevenDaysAgo)).orElse(true))
            .collect(Collectors.toList());

        // Sorting employees by last login (oldest first)
        List<Employee> sortedEmployees = employees.stream()
            .sorted(Comparator.comparing(emp -> emp.getLastLogin().orElse(LocalDateTime.MIN)))
            .collect(Collectors.toList());

        // Display results
        System.out.println("Employees inactive for 7+ days:");
        inactiveEmployees.forEach(Employee::display);

        System.out.println("\nEmployees sorted by last login:");
        sortedEmployees.forEach(Employee::display);
    }
}
