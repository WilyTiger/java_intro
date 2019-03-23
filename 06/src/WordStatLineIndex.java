import java.io.*;
import java.util.*;

public class WordStatLineIndex {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: WordStatIndex <input file> <output file>");
            System.exit(0);
        }
        try (FastScanner input = new FastScanner(args[0])) {
            PrintStream output = new PrintStream(new FileOutputStream(args[1]));

            TreeMap<String, ArrayList<WordPosition>> wordStatistics = new TreeMap<>();
            int lineNumber = 0;
            while (input.hasNextLine()) {
                lineNumber++;
                int wordNumber = 0;
                String line = input.nextLine().toLowerCase();
                String[] wordsInLine = line.split("[^\\p{Pd}\\p{L}']");

                for (String currentWord : wordsInLine) {
                    if (!currentWord.isEmpty()) {
                        if (!wordStatistics.containsKey(currentWord)) {
                            wordStatistics.put(currentWord, new ArrayList<>());
                        }
                        wordStatistics.get(currentWord).add(new WordPosition(lineNumber, ++wordNumber));
                    }
                }
            }

            for (Map.Entry<String, ArrayList<WordPosition>> word : wordStatistics.entrySet()) {
                output.print(word.getKey() + " " + word.getValue().size());
                for (WordPosition position : word.getValue()) {
                    output.print(" " + position.lineNumber + ":" + position.numberInLine);
                }
                output.println();
            }

            output.close();
        } catch (FileNotFoundException err) {
            System.out.println("Cannot find input file " + args[0]);
        }
    }
}
