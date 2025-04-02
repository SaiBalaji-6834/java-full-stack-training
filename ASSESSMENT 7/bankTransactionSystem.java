package DAY8;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class BankAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();
    BankAccount(int balance) { this.balance = balance; }
    boolean transfer(BankAccount to, int amount) {
        if (this == to) return false;
        if (lock.tryLock()) {
            try {
                if (to.lock.tryLock()) {
                    try {
                        if (balance >= amount) {
                            balance -= amount;
                            to.balance += amount;
                            return true;
                        }
                    } finally { to.lock.unlock(); }
                }
            } finally { lock.unlock(); }
        }
        return false;
    }
    int getBalance() { return balance; }
}

class BankTransactionSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(1000);
        BankAccount acc2 = new BankAccount(1000);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> acc1.transfer(acc2, 500));
        executor.execute(() -> acc2.transfer(acc1, 200));
        executor.shutdown();
        System.out.println("Final Balance Acc1: " + acc1.getBalance());
        System.out.println("Final Balance Acc2: " + acc2.getBalance());
    }
}
