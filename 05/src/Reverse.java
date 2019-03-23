import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Reverse {
    public static void main(String args[]) {

        FastScanner scanner = new FastScanner();
        ArrayList<ArrayList<Integer>> inputData = new ArrayList<>();

        try {
            while (true) {
                String line = scanner.nextLine();
                if (line == null) {
                    break;
                }

                String[] numbers = line.split(" ");

                ArrayList<Integer> array = new ArrayList<>();

                for (String num : numbers) {
                    if (!num.equals(""))
                        array.add(Integer.parseInt(num));
                }
                inputData.add(array);
            }

            for (int i = inputData.size() - 1; i >= 0; i--) {
                for (int j = inputData.get(i).size() - 1; j >= 0; j--) {
                    System.out.print(inputData.get(i).get(j) + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {

        }
    }
}
