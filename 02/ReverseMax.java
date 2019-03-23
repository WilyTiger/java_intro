import java.util.Scanner;
import java.util.ArrayList;

public class ReverseMax {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Integer> inputColumnSize = new ArrayList<Integer>();
		ArrayList<Integer> colMax = new ArrayList<Integer>();
		ArrayList<Integer> lineMax = new ArrayList<Integer>();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] numbers = line.split(" ");                                             

			int colSize = 0;                                     
			int maxInLine = Integer.MIN_VALUE;

			for (int i = 0; i < numbers.length; i++) {        				 
				if (!numbers[i].equals("")) {
					colSize++;

					int num = Integer.parseInt(numbers[i]);
					maxInLine = Math.max(maxInLine, num);

					if (colMax.size() < colSize) {
						colMax.add(num);
					} else {
						colMax.set(colSize - 1, Math.max(colMax.get(colSize - 1), num));
					}
				}
			}
			inputColumnSize.add(colSize);
			lineMax.add(maxInLine);
		}

		for (int i = 0; i < inputColumnSize.size(); i++) {
			for (int j = 0; j < inputColumnSize.get(i); j++) {
				System.out.print(Math.max(colMax.get(j), lineMax.get(i)) + " ");
			}
			System.out.println();
		}
	}
}