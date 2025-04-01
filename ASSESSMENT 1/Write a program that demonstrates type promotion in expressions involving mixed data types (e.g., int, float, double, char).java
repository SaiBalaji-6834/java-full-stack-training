public class TypePromotionDemo {
    public static void main(String[] args) {
        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = 0.1234;
        System.out.println("Type Promotion Examples:");
        int result1 = b + c;
        System.out.println("byte + char = int: " + b + " + " + (int)c + " = " + result1);
        int result2 = c + s;
        System.out.println("char + short = int: " + (int)c + " + " + s + " = " + result2);
        float result3 = i + f;
        System.out.println("int + float = float: " + i + " + " + f + " = " + result3);
        double result4 = f + d;
        System.out.println("float + double = double: " + f + " + " + d + " = " + result4);
        int result5 = b * s;
        System.out.println("byte * short = int: " + b + " * " + s + " = " + result5);
        double result6 = (f * b) + (i / c) - (d * s);
        System.out.println("\nComplex expression evaluation:");
        System.out.println("(float * byte) + (int / char) - (double * short) = double");
        System.out.println("(" + f + " * " + b + ") + (" + i + " / " + (int)c + ") - (" + d + " * " + s + ") = " + result6);
        System.out.println("\nExplicit casting vs automatic promotion:");
        float floatResult = (float)(i * d);
        double autoResult = i * d;
        System.out.println("Explicit cast to float: " + floatResult);
        System.out.println("Automatic promotion to double: " + autoResult);
    }
}
