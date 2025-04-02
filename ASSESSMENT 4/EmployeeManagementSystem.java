package DAY5;

import java.util.*;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }

    public static Comparator<Employee> SalaryComparator = Comparator.comparingDouble(Employee::getSalary);

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Dept: " + department;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employeesList = new ArrayList<>();
        Set<Employee> employeesSet = new HashSet<>();
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        // Adding employees
        Employee e1 = new Employee(1, "Alice", 50000, "HR");
        Employee e2 = new Employee(2, "Bob", 60000, "IT");
        Employee e3 = new Employee(3, "Charlie", 55000, "HR");

        employeesList.add(e1);
        employeesList.add(e2);
        employeesList.add(e3);
        employeesSet.addAll(employeesList);

        // Grouping by department
        for (Employee emp : employeesList) {
            departmentMap.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }

        // Sorting by salary
        employeesList.sort(Employee.SalaryComparator);
        System.out.println("Employees sorted by salary:");
        employeesList.forEach(System.out::println);

        // Searching by ID
        int searchId = 2;
        Employee found = employeesList.stream().filter(e -> e.getId() == searchId).findFirst().orElse(null);
        System.out.println("\nFound employee with ID " + searchId + ": " + found);

        // Displaying department-wise employees
        System.out.println("\nEmployees by department:");
        departmentMap.forEach((dept, emps) -> System.out.println(dept + ": " + emps));
    }
}
