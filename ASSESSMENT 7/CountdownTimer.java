package DAY8;
import java.util.concurrent.*;

class CountdownTimer {
    public static void main(String[] args) throws InterruptedException {
        int tasks = 3;
        CountDownLatch latch = new CountDownLatch(tasks);
        ExecutorService executor = Executors.newFixedThreadPool(tasks);
        
        for (int i = 0; i < tasks; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task completed");
                } catch (InterruptedException ignored) {}
                latch.countDown();
            });
        }
        
        latch.await();
        System.out.println("All tasks completed. Proceeding...");
        executor.shutdown();
    }
}
