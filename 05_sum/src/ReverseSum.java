import java.util.ArrayList;

public class ReverseSum {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        ArrayList<Integer> columnSum = new ArrayList<>();
        ArrayList<Integer> lineSum = new ArrayList<>();
        ArrayList<ArrayList<Integer>> inputData = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split(" ");

                int columnNumber = 0;
                int sumCurrentLine = 0;
                ArrayList<Integer> currentLine = new ArrayList<>();

                for (int i = 0; i < numbers.length; i++) {
                    if (!numbers[i].equals("")) {
                        int currentNum = Integer.parseInt(numbers[i]);
                        currentLine.add(currentNum);
                        sumCurrentLine += currentNum;

                        if (columnSum.size() <= columnNumber) {
                            columnSum.add(currentNum);
                        } else {
                            columnSum.set(columnNumber, columnSum.get(columnNumber) + currentNum);
                        }
                        columnNumber++;
                    }
                }
                inputData.add(currentLine);
                lineSum.add(sumCurrentLine);
            }

            for (int i = 0; i < inputData.size(); i++) {
                for (int j = 0; j < inputData.get(i).size(); j++) {
                    System.out.print(columnSum.get(j) + lineSum.get(i) - inputData.get(i).get(j) + " ");
                }
                System.out.println();
            }
    }
}
