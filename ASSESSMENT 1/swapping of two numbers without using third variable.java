public class SwapVariables {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        System.out.println("Before swapping:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        x = x ^ y;  
        y = x ^ y;  
        x = x ^ y;  
        System.out.println("After swapping:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
