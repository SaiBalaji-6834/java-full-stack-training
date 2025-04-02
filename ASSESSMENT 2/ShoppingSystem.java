package DAY23;
// Abstract class representing an Item
abstract class Item {
    protected double price;

    // Constructor to initialize price
    public Item(double price) {
        this.price = price;
    }

    // Abstract method to calculate discount (to be implemented by subclasses)
    public abstract double getDiscount();
}

// Subclass representing Electronic gadgets
class Gadget extends Item {
    public Gadget(double price) {
        super(price);
    }

    // Implementing getDiscount for Gadgets (10% discount)
    @Override
    public double getDiscount() {
        return price * 0.10; // 10% discount
    }
}

// Subclass representing Apparel
class Apparel extends Item {
    public Apparel(double price) {
        super(price);
    }

    // Implementing getDiscount for Apparel (5% discount)
    @Override
    public double getDiscount() {
        return price * 0.05; // 5% discount
    }
}

// Main class to test the functionality
public class Shoppingsystem {
    public static void main(String[] args) {
        Item laptop = new Gadget(50000);  // Gadget product
        Item tShirt = new Apparel(2000);  // Apparel product

        // Displaying discount amounts
        System.out.println("Gadget Discount: " + laptop.getDiscount()); // 5000.0
        System.out.println("Apparel Discount: " + tShirt.getDiscount()); // 100.0
    }
}
