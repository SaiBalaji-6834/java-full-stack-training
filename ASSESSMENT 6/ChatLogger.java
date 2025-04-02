package DAY7;
import java.io.*;

class ChatLogger {
    private static final String FILE_PREFIX = "chat_logs";
    private static final long MAX_SIZE = 5 * 1024 * 1024;
    
    private static File getCurrentLogFile() {
        int index = 0;
        File file;
        do { file = new File(FILE_PREFIX + "_" + index + ".txt"); index++; } 
        while (file.exists() && file.length() >= MAX_SIZE);
        return file;
    }
    
    static void logMessage(String message) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(getCurrentLogFile(), true))) {
            w.write(message + "\n");
        }
    }
    
    static void searchMessages(String keyword) throws IOException {
        File dir = new File(".");
        for (File file : dir.listFiles((d, name) -> name.startsWith(FILE_PREFIX))) {
            try (BufferedReader r = new BufferedReader(new FileReader(file))) {
                String line; while ((line = r.readLine()) != null)
                    if (line.contains(keyword)) System.out.println(line);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        logMessage("Hello, how are you?");
        logMessage("This is a test chat message.");
        searchMessages("test");
    }
}
