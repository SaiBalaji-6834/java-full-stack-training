package DAY8;

import java.util.concurrent.*;

class OrderProcessingSystem {
    private static final BlockingQueue<String> orders = new LinkedBlockingQueue<>();
    private static volatile boolean running = true;
    
    static void placeOrder(String order) throws InterruptedException {
        orders.put(order);
    }
    
    static void processOrders() {
        new Thread(() -> {
            try {
                while (running || !orders.isEmpty()) {
                    String order = orders.poll(1, TimeUnit.SECONDS);
                    if (order != null) System.out.println("Processed: " + order);
                }
            } catch (InterruptedException ignored) {}
        }).start();
    }
    
    public static void main(String[] args) throws InterruptedException {
        processOrders();
        placeOrder("Order1");
        placeOrder("Order2");
        Thread.sleep(2000);
        running = false;
    }
}
