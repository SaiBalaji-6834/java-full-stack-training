package DAY23;
// User.java
class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        setPassword(password); // Use setter to enforce validation
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for password with validation
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
            System.out.println("Password set successfully.");
        } else {
            System.out.println("Error: Password must be at least 8 characters long.");
        }
    }

    // Method to display user details (without showing password)
    public void displayUserInfo() {
        System.out.println("Username: " + username);
    }
}

// Main class to test User encapsulation
public class UserManagement {
    public static void main(String[] args) {
        User user1 = new User("john_doe", "securePass");  // Valid password
        user1.displayUserInfo();
        
        User user2 = new User("alice_smith", "short");  // Invalid password
        user2.displayUserInfo();

        // Trying to set a new password
        user1.setPassword("newPass123");  // Valid update
        user2.setPassword("12345");  // Invalid update
    }
}
