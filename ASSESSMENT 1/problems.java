 // 3. Reverse Bits of an Integer
    public static int reverseBits(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (num & 1);
            num >>= 1;
        }
        return result;
    }

    // 4. Check if a Number is a Power of Two
    public static boolean isPowerOfTwo(int num) {
        return (num > 0) && ((num & (num - 1)) == 0);
    }

    
    // 6. Sum of Digits
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // 7. Check Prime Number
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 8. Generate Fibonacci using do-while loop
    public static void fibonacciSeries(int n) {
        int a = 0, b = 1, count = 0;
        do {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
            count++;
        } while (count < n);
        System.out.println();
    }
    
    // 9. Print Pyramid Pattern
    public static void printPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }
    
    // 10. Immutable Configuration Class
    static final class Configuration {
        private final String databaseUrl, username, password;
        public Configuration(String db, String user, String pass) {
            this.databaseUrl = db;
            this.username = user;
            this.password = pass;
        }
        public String getDatabaseUrl() { return databaseUrl; }
        public String getUsername() { return username; }
    }
    
    // 11. Convert RGB to Grayscale
    public static int convertToGrayscale(int r, int g, int b) {
        return (int) (0.3 * r + 0.59 * g + 0.11 * b);
    }
    
    // 12. Encode & Decode Integer
    public static int encode(int num) { return num ^ 0x5A5A5A5A; }
    public static int decode(int num) { return num ^ 0x5A5A5A5A; }
    
    // 13. Discount Calculator
    public static double calculateFinalPrice(double cartValue) {
        if (cartValue > 500) return cartValue * 0.8;
        if (cartValue >= 100) return cartValue * 0.9;
        return cartValue;
    }
    
    // 14. ATM Withdrawal
    public static void atmWithdrawal(int amount) {
        if (amount % 100 != 0) {
            System.out.println("Invalid amount. Must be multiple of 100.");
            return;
        }
        int[] notes = {2000, 500, 100};
        for (int note : notes) {
            if (amount >= note) {
                System.out.println((amount / note) + " x " + note);
                amount %= note;
            }
        }
    }
    
    // 15. Multiplication Table
    public static void multiplicationTable(int num, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
    
    public static void main(String[] args) {
        
        // Example calls to methods
        swapNumbers(10, 20);
        typePromotionDemo(5, 'A', 2.5);
        System.out.println("Reversed Bits: " + reverseBits(5));
        System.out.println("Power of Two: " + isPowerOfTwo(16));
        System.out.println("Sum of Digits: " + sumOfDigits(1234));
        System.out.println("Is Prime: " + isPrime(13));
        fibonacciSeries(5);
        printPyramid(5);
        Configuration config = new Configuration("jdbc:mysql://localhost", "admin", "password123");
        System.out.println(config.getDatabaseUrl());
        System.out.println("Grayscale: " + convertToGrayscale(120, 150, 200));
        int encoded = encode(12345);
        System.out.println("Encoded: " + encoded + ", Decoded: " + decode(encoded));
        System.out.println("Final Price: " + calculateFinalPrice(450));
        atmWithdrawal(3700);
        multiplicationTable(5, 1, 10);
    }
}
