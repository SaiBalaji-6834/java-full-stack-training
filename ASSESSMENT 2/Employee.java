package DAY23;
import java.util.Scanner;

// Base class Employee
class Employee {
    protected double baseSalary; // Base salary as a variable

    // Constructor to initialize base salary
    public Employee(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Method to calculate salary
    public double calculateSalary() {
        return baseSalary; // Return the base salary
    }

    // Main method inside Employee class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking base salary input for Employee
        System.out.print("Enter base salary for Employee: ");
        double empSalary = scanner.nextDouble();

        // Taking base salary and bonus input for Manager
        System.out.print("Enter base salary for Manager: ");
        double mgrSalary = scanner.nextDouble();
        System.out.print("Enter bonus for Manager: ");
        double mgrBonus = scanner.nextDouble();

        // Creating Employee and Manager objects
        Employee emp = new Employee(empSalary);
        Manager mgr = new Manager(mgrSalary, mgrBonus);

        // Displaying salaries
        System.out.println("Employee salary: " + emp.calculateSalary());
        System.out.println("Manager salary: " + mgr.calculateSalary());

        scanner.close();
    }
}

// Derived class Manager
class Manager extends Employee {
    private double bonus;

    // Constructor to initialize base salary and bonus
    public Manager(double baseSalary, double bonus) {
        super(baseSalary); // Call the constructor of Employee
        this.bonus = bonus;
    }

    // Override calculateSalary to add bonus
    @Override
    public double calculateSalary() {
        return baseSalary + bonus; // Return base salary + bonus
    }
}
