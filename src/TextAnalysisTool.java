import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAnalysisTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Input
        System.out.println("Please enter a paragraph or lengthy text:");
        String text = scanner.nextLine();

        // Character Count
        int totalCharacters = text.length();
        System.out.println("\nTotal number of characters: " + totalCharacters);

        // Word Count
        String[] words = text.split("\\s+");
        int totalWords = words.length;
        System.out.println("Total number of words: " + totalWords);

        // Most Common Character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
            }
        }
        char mostCommonChar = ' ';
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostCommonChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        System.out.println("Most common character: '" + mostCommonChar + "' with " + maxFrequency + " occurrences");

        // Character Frequency
        System.out.println("\nEnter a character to find its frequency (case-insensitive):");
        char charInput = scanner.nextLine().toLowerCase().charAt(0);
        int charCount = charFrequency.getOrDefault(charInput, 0);
        System.out.println("The character '" + charInput + "' appears " + charCount + " times in the text.");

        // Word Frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            String cleanedWord = word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            if (!cleanedWord.isEmpty()) {
                wordFrequency.put(cleanedWord, wordFrequency.getOrDefault(cleanedWord, 0) + 1);
            }
        }
        System.out.println("\nEnter a word to find its frequency (case-insensitive):");
        String wordInput = scanner.nextLine().toLowerCase();
        int wordCount = wordFrequency.getOrDefault(wordInput, 0);
        System.out.println("The word '" + wordInput + "' appears " + wordCount + " times in the text.");

        // Unique Words Count
        int uniqueWordCount = wordFrequency.size();
        System.out.println("Number of unique words: " + uniqueWordCount);

        scanner.close();
    }
}