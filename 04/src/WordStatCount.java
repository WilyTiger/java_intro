import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class WordStatCount {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: WordStatCount <input file> <output file>");
            System.exit(0);
        }

        try (Scanner input = new Scanner(new File(args[0]), "UTF-8")) {
            PrintStream output = new PrintStream(new FileOutputStream(args[1]));

            LinkedHashMap <String, Integer> wordStatistics = new LinkedHashMap<>();
            while (input.hasNextLine()) {
                String line = input.nextLine().toLowerCase();
                String[] wordsInLine = line.split("[^\\p{Pd}\\p{L}']");

                for (String currentWord : wordsInLine) {
                    if (!currentWord.equals("")) {
                        if (wordStatistics.containsKey(currentWord)) {
                            wordStatistics.put(currentWord, wordStatistics.get(currentWord) + 1);
                        } else {
                            wordStatistics.put(currentWord, 1);
                        }
                    }
                }
            }

            ArrayList<Map.Entry<String, Integer>> statisticsInOrder = new ArrayList<>(wordStatistics.entrySet());
            statisticsInOrder.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue));

            for (Map.Entry<String, Integer> pair: statisticsInOrder) {
                output.println(pair.getKey() + " " + pair.getValue());
            }
            output.close();
        } catch (FileNotFoundException err) {
            System.out.println("Cannot find input file " + args[0]);
        }
    }
}
