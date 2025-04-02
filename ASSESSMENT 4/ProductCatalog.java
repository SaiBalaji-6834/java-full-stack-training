package DAY5;

import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;
    private Set<String> categories = new HashSet<>();

    public Product(int id, String name, double price, String... categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories.addAll(Arrays.asList(categories));
    }

    public static Comparator<Product> PriceAscComparator = Comparator.comparingDouble(Product::getPrice);
    public static Comparator<Product> PriceDescComparator = (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice());

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public Set<String> getCategories() { return categories; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Categories: " + categories;
    }
}

public class ProductCatalog {
    public static void main(String[] args) {
        TreeMap<Integer, Product> productMap = new TreeMap<>();
        productMap.put(101, new Product(101, "Laptop", 50000, "Electronics", "Gadgets"));
        productMap.put(102, new Product(102, "Shirt", 999, "Fashion", "Clothing"));

        // Searching in price range (30000 - 60000)
        System.out.println("Products in price range 30000-60000:");
        productMap.values().stream()
                .filter(p -> p.getPrice() >= 30000 && p.getPrice() <= 60000)
                .forEach(System.out::println);

        // Sorting by price (descending)
        List<Product> products = new ArrayList<>(productMap.values());
        products.sort(Product.PriceDescComparator);
        System.out.println("\nProducts sorted by price (descending):");
        products.forEach(System.out::println);
    }
}
