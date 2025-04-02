package DAY23;
// Payment.java
class Payment {
    // Pay using default method
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using default method.");
    }

    // Pay using a specific method
    public void pay(double amount, String method) {
        System.out.println("Paid " + amount + " using " + method + ".");
    }

    // Pay using EMI with a duration
    public void pay(double amount, String method, int emiMonths) {
        System.out.println("Paid " + amount + " using " + method + " in " + emiMonths + " months EMI.");
    }
}

class Employee {
    public int calculateSalary() {
        return 50000; // Base salary
    }
}

class Manager extends Employee {
    @Override
    public int calculateSalary() {
        return super.calculateSalary() + 10000; // Base salary + Bonus
    }
}

class BankAccount {
    private double balance;
    private String ownerName;

    // Default constructor
    public BankAccount() {
        this(0, "Unknown");
    }

    // Constructor with balance
    public BankAccount(double balance) {
        this(balance, "Unknown");
    }

    // Constructor with balance and owner name
    public BankAccount(double balance, String ownerName) {
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public void displayAccountInfo() {
        System.out.println("Owner: " + ownerName + ", Balance: " + balance);
    }
}

class Payment1 {
    public static void main(String[] args) {
        // Payment System Testing
        System.out.println("---- Payment System ----");
        Payment p = new Payment();
        p.pay(1000); // Default payment
        p.pay(2000, "Credit Card");
        p.pay(5000, "UPI", 12);

        // Employee Salary Testing
        System.out.println("\n---- Employee Salary Calculation ----");
        Employee emp = new Employee();
        Manager mgr = new Manager();
        System.out.println("Employee Salary: " + emp.calculateSalary()); // 50000
        System.out.println("Manager Salary: " + mgr.calculateSalary()); // 60000

        // Bank Account Testing
        System.out.println("\n---- Bank Account System ----");
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount(1000);
        BankAccount acc3 = new BankAccount(5000, "John Doe");

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
    }
}
