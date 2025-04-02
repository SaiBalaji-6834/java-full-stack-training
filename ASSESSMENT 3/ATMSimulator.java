package DAY3;
class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}
class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class DailyLimitExceededException extends Exception {
    public DailyLimitExceededException(String message) {
        super(message);
    }
}
class ATM {
    private static final double DAILY_LIMIT = 1000.0;
    private static final String CORRECT_PIN = "1234";
    private double balance;
    private double dailyWithdrawal;
    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.dailyWithdrawal = 0.0;
    }
    public void withdraw(String pin, double amount) throws NetworkException {
        if (Math.random() < 0.1) {
            throw new NetworkException("Unable to connect to bank server");
        }
        try {
            if (!pin.equals(CORRECT_PIN)) {
                throw new InvalidPINException("Incorrect PIN entered");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient funds. Current balance: " + balance);
            }
            if (dailyWithdrawal + amount > DAILY_LIMIT) {
                throw new DailyLimitExceededException("Daily withdrawal limit exceeded. Limit: " + DAILY_LIMIT);
            }
            balance -= amount;
            dailyWithdrawal += amount;
            System.out.println("Withdrawal successful. Amount: " + amount + ", Remaining balance: " + balance + ", Daily withdrawal: " + dailyWithdrawal);
        } catch (InvalidPINException e) {
            System.err.println("Security Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.err.println("Funds Error: " + e.getMessage());
        } catch (DailyLimitExceededException e) {
            System.err.println("Limit Error: " + e.getMessage());
        }
    }
}
public class ATMSimulator {
    public static void main(String[] args) {
        ATM atm = new ATM(1500.0);
        try {
            atm.withdraw("1234", 500.0);
        } catch (NetworkException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
