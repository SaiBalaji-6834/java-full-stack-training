package DAY3;
import java.util.Random;
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
class NumberGenerator implements Runnable {
    private final int[] numbers;
    private final Random random = new Random();
    public NumberGenerator(int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(100) - 10;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.err.println("Number generation interrupted: " + e.getMessage());
        }
    }
}
class SquareRootCalculator implements Runnable {
    private final int[] numbers;
    public SquareRootCalculator(int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            try {
                if (numbers[i] < 0) {
                    throw new NegativeNumberException("Negative number found at index " + i + ": " + numbers[i]);
                }
                double sqrt = Math.sqrt(numbers[i]);
                System.out.println("Square root of " + numbers[i] + " is " + sqrt);
                Thread.sleep(150);
            } catch (NegativeNumberException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Square root calculation interrupted: " + e.getMessage());
            }
        }
    }
}
public class MultiThreaded {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        int[] sharedArray = new int[ARRAY_SIZE];
        Thread generatorThread = new Thread(new NumberGenerator(sharedArray));
        Thread calculatorThread = new Thread(new SquareRootCalculator(sharedArray));
        try {
            generatorThread.start();
            calculatorThread.start();
            generatorThread.join();
            calculatorThread.join();
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed");
        }
    }
}
