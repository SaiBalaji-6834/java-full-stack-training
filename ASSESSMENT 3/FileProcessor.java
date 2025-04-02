package DAY3;
import java.io.*;
class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}
public class FileProcessor {
    public static void main(String[] args) {
        String filePath = "numbers.txt";
        try {
            int sum = processFile(filePath);
            System.out.println("Sum of numbers: " + sum);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in file - " + e.getMessage());
        } catch (EmptyFileException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public static int processFile(String filePath) throws FileNotFoundException, EmptyFileException, IOException {
        int sum = 0;
        boolean isEmpty = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                isEmpty = false;
                try {
                    int num = Integer.parseInt(line.trim());
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("'" + line + "' is not a valid integer");
                }
            }
            if (isEmpty) {
                throw new EmptyFileException("File is empty");
            }
        }
        return sum;
    }
}
