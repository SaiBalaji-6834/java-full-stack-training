package DAY7;
import java.io.*;
import java.util.Base64;

class SecureUserData {
    private static final String FILE = "users.txt";

    static void addUser(String name, String email, String password) throws IOException {
        if (findUser(email) != null) return;
        try (BufferedWriter w = new BufferedWriter(new FileWriter(FILE, true))) {
            w.write(name + "," + email + "," + encrypt(password) + "\n");
        }
    }

    static String findUser(String email) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(FILE))) {
            String line; while ((line = r.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(email)) return parts[0] + "," + parts[1] + "," + decrypt(parts[2]);
            }
        }
        return null;
    }

    private static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private static String decrypt(String data) {
        return new String(Base64.getDecoder().decode(data));
    }

    public static void main(String[] args) throws IOException {
        addUser("John", "john@test.com", "pass123");
        System.out.println(findUser("john@test.com"));
    }
}
