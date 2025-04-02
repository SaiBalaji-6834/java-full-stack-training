package DAY5;

import java.util.*;

class Dictionary<K extends String, V> {  // Bounded type: Key must be String
    private TreeMap<K, V> entries;

    public Dictionary() {
        this.entries = new TreeMap<>(Comparator.comparingInt(String::length));
    }

    public void addWord(K word, V meaning) {
        entries.put(word, meaning);
    }

    public void displaySorted() {
        System.out.println("Dictionary (sorted by word length):");
        entries.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}

public class MultiLanguageDictionary {
    public static void main(String[] args) {
        Dictionary<String, String> englishDict = new Dictionary<>();
        englishDict.addWord("apple", "A fruit");
        englishDict.addWord("zebra", "An animal");
        englishDict.addWord("ant", "Insect");

        englishDict.displaySorted();
    }
}
