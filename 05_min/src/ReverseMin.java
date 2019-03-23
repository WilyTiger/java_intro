import java.io.IOException;
import java.util.ArrayList;

public class ReverseMin {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        ArrayList<Integer> inputColumnSize = new ArrayList<>();
        ArrayList<Integer> colMax = new ArrayList<>();
        ArrayList<Integer> lineMax = new ArrayList<>();

        String line;
        try {
            while ((line = scanner.nextLine()) != null) {
               String[] numbers = line.split(" ");

                int colSize = 0;
                int minInLine = Integer.MAX_VALUE;

                for (int i = 0; i < numbers.length; i++) {
                    if (!numbers[i].equals("")) {
                        colSize++;
                        int num = Integer.parseInt(numbers[i]);
                        minInLine = Math.min(minInLine, num);

                        if (colMax.size() < colSize) {
                            colMax.add(num);
                        } else {
                            colMax.set(colSize - 1, Math.min(colMax.get(colSize - 1), num));
                        }
                    }
                }
                inputColumnSize.add(colSize);
                lineMax.add(minInLine);
            }

            for (int i = 0; i < inputColumnSize.size(); i++) {
                for (int j = 0; j < inputColumnSize.get(i); j++) {
                    System.out.print(Math.min(colMax.get(j), lineMax.get(i)) + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {

        }
    }
}
