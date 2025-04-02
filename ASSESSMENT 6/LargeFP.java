package DAY7;
import java.io.*;
import java.util.Arrays;
import java.util.concurrent.*;

class LargeFP {
    private static final String INPUT_FILE = "data.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private static final int CHUNK_SIZE = 10000;

    public static void processFile() throws IOException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE)); BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            String[] lines = new String[CHUNK_SIZE];
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                lines[count++] = line;
                if (count == CHUNK_SIZE) {
                    executor.execute(new Task(lines.clone(), writer));
                    count = 0;
                }
            }
            if (count > 0) executor.execute(new Task(Arrays.copyOf(lines, count), writer));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    static class Task implements Runnable {
        private final String[] lines;
        private final BufferedWriter writer;

        Task(String[] lines, BufferedWriter writer) {
            this.lines = lines;
            this.writer = writer;
        }

        public void run() {
            synchronized (writer) {
                try {
                    for (String line : lines) writer.write(line.toUpperCase() + "\n");
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        processFile();
    }
}
