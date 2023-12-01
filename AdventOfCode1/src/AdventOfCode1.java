import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AdventOfCode1 {
    public static void main(String[] args) throws IOException {

        findCoordinatesInASingleWord("a1twothreefouraaaa");

        var sum = sumCoordinates("input.txt");

        System.out.println("Bye!");
    }

    public static int sumCoordinates(String filePath){
        int sum = 0;

        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                data = replaceNumbersInWord(data);
                sum = sum + findCoordinatesInASingleWord(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return sum;
    }

    public static int findCoordinatesInASingleWord(String word) {
        // from 48(0) to 57(9)
        char[] symbols = word.toCharArray();
        char min = 0;
        char max = 0;

        for (int i = 0; i < symbols.length; i++) {
            if (min == 0 && (symbols[i] >= 48 && symbols[i] <= 57)){
                min = symbols[i];
                continue;
            }

            if (min != 0 && (symbols[i] >= 48 && symbols[i] <= 57)) {
                max = symbols[i];
            }
        }

        if (max == 0) {
            max = min;
        }

        return Integer.parseInt(String.valueOf(min) + String.valueOf(max));
    }

    public static String replaceNumbersInWord(String word) {
        String newWord = "";
        if (word.contains("one")) {
            word = word.replace("one", "o1e");
        }
        if (word.contains("two")) {
            word = word.replace("two", "t2o");
        }
        if (word.contains("three")) {
            word = word.replace("three", "t3e");
        }
        if (word.contains("four")) {
            word = word.replace("four", "f4r");
        }
        if (word.contains("five")) {
            word = word.replace("five", "f5e");
        }
        if (word.contains("six")) {
            word = word.replace("six", "s6x");
        }
        if (word.contains("seven")) {
            word = word.replace("seven", "s7n");
        }
        if (word.contains("eight")) {
            word = word.replace("eight", "e8t");
        }
        if (word.contains("nine")) {
            word = word.replace("nine", "n9e");
        }

        return word;
    }
}
