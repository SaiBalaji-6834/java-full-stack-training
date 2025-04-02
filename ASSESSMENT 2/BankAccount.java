package DAY23;

// BankAccount class demonstrating constructor chaining
class BankAccount {
    private double balance;
    private String ownerName;

    // Default constructor (no parameters)
    public BankAccount() {
        this(0, "Unknown"); // Calls the third constructor with default values
    }

    // Constructor with balance only
    public BankAccount(double balance) {
        this(balance, "Unknown"); // Calls the third constructor with default owner name
    }

    // Constructor with balance and owner name
    public BankAccount(double balance, String ownerName) {
        this.balance = balance;
        this.ownerName = ownerName;
    }

    // Method to display account details
    public void displayAccountInfo() {
        System.out.println("Owner: " + ownerName + ", Balance: $" + balance);
    }

    public static void main(String[] args) {
        // Creating different BankAccount objects using different constructors
        BankAccount acc1 = new BankAccount();              // Default constructor
        BankAccount acc2 = new BankAccount(1000);         // Constructor with balance
        BankAccount acc3 = new BankAccount(5000, "John Doe"); // Constructor with balance and owner name

        // Displaying account details
        acc1.displayAccountInfo(); 
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
    }
}
