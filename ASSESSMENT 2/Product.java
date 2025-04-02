package DAY23;
// Class representing a Product with name and price
public class Product {
    private String name;
    private double price;

    // Constructor to initialize product details
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Overriding equals method to compare products by name and price
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // If both references point to the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check null and class type
        Product product = (Product) obj; // Typecast to Product
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Laptop", 50000);
        Product p3 = new Product("Phone", 30000);

        // Comparing products
        System.out.println(p1.equals(p2)); // true (Same name and price)
        System.out.println(p1.equals(p3)); // false (Different name and price)
    }
}
