import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SumHexFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: SumHexFile <input file> <output file>");
            System.exit(0);
        }

        try (Scanner input = new Scanner(new File(args[0]))) {
            PrintStream output = new PrintStream(new FileOutputStream(args[1]));
            int sum = 0;
            while (input.hasNext()) {
                String currentNumber = input.next();
                int base = 10;

                if (currentNumber.toLowerCase().startsWith("0x")) {
                    base = 16;
                    currentNumber = currentNumber.substring(2);
                }

                try {
                    sum += Long.parseLong(currentNumber.toLowerCase(), base);
                } catch (NumberFormatException err) {
                    System.out.println("Incorrect number: \"" + currentNumber +  "\" Use only decimal and heximal started with \"0x\" ");
                }
             }

             output.println(sum);
             output.close();
         } catch (FileNotFoundException err) {
             System.out.println("Cannot find input file " + args[0]);
         }
    }
}
