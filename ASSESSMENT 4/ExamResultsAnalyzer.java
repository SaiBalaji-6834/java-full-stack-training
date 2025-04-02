package DAY5;

import java.util.*;

public class ExamResultsAnalyzer {
    public static void main(String[] args) {
        // HashMap to store student scores
        HashMap<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 72);
        studentScores.put("Charlie", 90);

        // Convert to TreeMap for alphabetical sorting
        TreeMap<String, Integer> sortedScores = new TreeMap<>(studentScores);
        System.out.println("Students (sorted by name): " + sortedScores);

        // Find highest and lowest scores
        System.out.println("\nHighest score: " + Collections.max(studentScores.values()));
        System.out.println("Lowest score: " + Collections.min(studentScores.values()));

        // Process scores using Arrays.asList()
        List<Integer> scoresList = Arrays.asList(85, 72, 90);
        System.out.println("\nAverage score: " + 
            scoresList.stream().mapToInt(Integer::intValue).average().orElse(0));
    }
}
