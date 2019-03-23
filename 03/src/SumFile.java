import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SumFile {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File(args[0]));
             PrintStream out = new PrintStream(new FileOutputStream(args[1]))) {
            int sum = 0;
            while (in.hasNext()) {
                try {
                    sum += Integer.parseInt(in.next());
                } catch (NumberFormatException e) {
                    try {
                        sum += Integer.parseInt(in.next(), 16);
                    } catch (NumberFormatException er) {

                    }
                }
            }
            out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
