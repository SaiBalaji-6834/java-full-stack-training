package DAY3;
import java.util.*;
import java.util.Map;

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
class Product {
    private String id;
    private String name;
    private int stock;
    private double price;
    public Product(String id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public int getStock() { return stock; }
    public double getPrice() { return price; }
    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > stock) {
            throw new OutOfStockException("Only " + stock + " items available for " + name);
        }
        stock -= quantity;
    }
}
class OrderManager {
    private Map<String, Product> products;
    public OrderManager() {
        products = new HashMap<>();
        products.put("P001", new Product("P001", "Laptop", 5, 999.99));
        products.put("P002", new Product("P002", "Phone", 0, 699.99));
        products.put("P003", new Product("P003", "Tablet", 10, 299.99));
    }
    public void placeOrder(String productId, String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                throw new NumberFormatException("Quantity must be positive");
            }
            Product product = products.get(productId);
            if (product == null) {
                throw new ProductNotFoundException("Product with ID " + productId + " not found");
            }
            product.reduceStock(quantity);
            System.out.println("Order placed: " + quantity + " x " + product.getName() + " for $" + (product.getPrice() * quantity));
        } catch (NumberFormatException | OutOfStockException | ProductNotFoundException e) {
            System.err.println("Order failed: " + e.getMessage());
        }
    }
}
public class EcommerceSystem {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        manager.placeOrder("P001", "2");
        manager.placeOrder("P001", "abc");
        manager.placeOrder("P002", "1");
        manager.placeOrder("P004", "1");
        manager.placeOrder("P003", "-1");
    }
}
