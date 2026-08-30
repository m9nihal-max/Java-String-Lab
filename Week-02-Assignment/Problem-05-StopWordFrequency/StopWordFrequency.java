import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Comparator;
import java.util.Scanner;

public class StopWordFrequency {

    public static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {
                frequency.put(
                        word,
                        frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        ArrayList<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort(
                Comparator.comparing(
                        Map.Entry<String, Integer>::getValue
                ).reversed()
        );

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}
