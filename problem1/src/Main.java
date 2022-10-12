import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(findLongestWordInString(input));
    }

    public static String findLongestWordInString(String input) {
        String[] words = input.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) longestWord = word;
        }
        return longestWord;
    }
}