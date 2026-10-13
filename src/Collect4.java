import java.util.*;

public class Collect4 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scr.nextLine();

        String cleaned = text.toLowerCase().replace("[^a-z\\s", "");
        String[] words = cleaned.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words) {
            if (word.isEmpty()) continue;
            map.merge(word, 1, Integer::sum);
        }

        System.out.println();
        System.out.println("Всего слов в тексте: " + words.length);
        System.out.println("Различных слов: " + map.size() + "\nСлова с указанием количества:");
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        scr.close();
    }
}
