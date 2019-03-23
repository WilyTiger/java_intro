import java.util.Scanner;
import java.util.ArrayList;

public class ReverseTranspose {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<ArrayList<Integer>> inputData = new ArrayList<ArrayList<Integer>>();
		int maxLen = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] numbers = line.split(" ");                                             

			ArrayList<Integer> array = new ArrayList<Integer>();

			for (String num : numbers) {
				if (!num.equals(""))
					array.add(Integer.parseInt(num));
			}
			maxLen = max(maxLen, array.size());
			inputData.add(array);
		}

		for (int j = 0; j < maxLen; j++) {
			for (int i = 0; i < inputData.size(); i++) {
				if ()
				
			}
		}
		for (int i = inputData.size() - 1; i >= 0; i--) {
			for (int j = inputData.get(i).size() - 1; j >= 0; j--) {
				System.out.print(inputData.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}