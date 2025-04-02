package DAY7;
import java.io.*;
import java.util.*;

class EmployeeDatabase {
    private static final String FILE = "employees.dat";

    public static void addEmployee(Employee e) throws IOException, ClassNotFoundException {
        List<Employee> employees = loadEmployees();
        employees.add(e);
        saveEmployees(employees);
    }

    public static Employee findEmployee(int id) throws IOException, ClassNotFoundException {
        for (Employee e : loadEmployees()) if (e.id == id) return e;
        return null;
    }

    public static void updateSalary(int id, double salary) throws IOException, ClassNotFoundException {
        List<Employee> employees = loadEmployees();
        for (Employee e : employees) if (e.id == id) e.salary = salary;
        saveEmployees(employees);
    }

    public static void deleteEmployee(int id) throws IOException, ClassNotFoundException {
        List<Employee> employees = loadEmployees();
        employees.removeIf(e -> e.id == id);
        saveEmployees(employees);
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> loadEmployees() throws IOException, ClassNotFoundException {
        File file = new File(FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Employee>) in.readObject();
        }
    }

    private static void saveEmployees(List<Employee> employees) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(employees);
        }
    }

    public static void main(String[] args) throws Exception {
        addEmployee(new Employee(1, "John", 50000, "IT"));
        System.out.println(findEmployee(1));
        updateSalary(1, 60000);
        deleteEmployee(1);
    }
}

class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String toString() {
        return id + ", " + name + ", " + salary + ", " + department;
    }
}
