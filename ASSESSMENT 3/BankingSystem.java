package DAY3;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
class BankAccount {
    private double balance;
    public BankAccount(String accountNumber, double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ". New balance: " + balance);
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Current balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ". Remaining balance: " + balance);
    }
    public double getBalance() {
        return balance;
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", 1000.0);
        try {
            account.deposit(500.0);
            account.withdraw(200.0);
            account.deposit(-100.0);
        } catch (InvalidAmountException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.err.println("Error: " + e.getMessage());
        }
        try {
            account.withdraw(2000.0);
        } catch (InsufficientBalanceException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
