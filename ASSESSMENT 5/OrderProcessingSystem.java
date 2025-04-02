package DAY6;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

enum OrderStatus {
    PENDING, SHIPPED, DELIVERED
}

class Order {
    private int orderID;
    private double amount;
    private LocalDateTime orderDate;
    private OrderStatus status;

    public Order(int orderID, double amount, LocalDateTime orderDate, OrderStatus status) {
        this.orderID = orderID;
        this.amount = amount;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getOrderID() { return orderID; }
    public double getAmount() { return amount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public OrderStatus getStatus() { return status; }

    public void display() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(orderID + " | $" + amount + " | " + orderDate.format(formatter) + " | " + status);
    }
}

public class OrderProcessingSystem {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order(101, 500.0, LocalDateTime.now().minusHours(2), OrderStatus.PENDING),
            new Order(102, 1200.0, LocalDateTime.now().minusHours(5), OrderStatus.SHIPPED),
            new Order(103, 300.0, LocalDateTime.now().minusDays(1), OrderStatus.DELIVERED),
            new Order(104, 700.0, LocalDateTime.now(), OrderStatus.PENDING)
        );

        LocalDate today = LocalDate.now();

        // Total revenue for today's orders
        double totalRevenue = orders.stream()
            .filter(o -> o.getOrderDate().toLocalDate().equals(today))
            .mapToDouble(Order::getAmount)
            .sum();

        // Pending orders sorted by order date
        List<Order> pendingOrders = orders.stream()
            .filter(o -> o.getStatus() == OrderStatus.PENDING)
            .sorted(Comparator.comparing(Order::getOrderDate))
            .collect(Collectors.toList());

        // Most recent delivered order
        Optional<Order> recentDeliveredOrder = orders.stream()
            .filter(o -> o.getStatus() == OrderStatus.DELIVERED)
            .max(Comparator.comparing(Order::getOrderDate));

        // Display results
        System.out.println("Total Revenue for Today's Orders: $" + totalRevenue);

        System.out.println("\nPending Orders:");
        pendingOrders.forEach(Order::display);

        System.out.println("\nMost Recent Delivered Order:");
        recentDeliveredOrder.ifPresent(Order::display);
    }
}
