package search;


public class BinarySearchMissing {
    // Pre: a[-1] = inf && a[a.length] = -inf && a[i] >= a[i + 1] for i = 0..a.length-1
    // Inv: right' - left' < right - left && a[left'] > key >= a[right']
    // Post: Res = right && a[right - 1] > key >= a[right]
    static int BinRec(int[] array, int key, int left, int right) {
        if (right - left <= 1) {
            // right - left == 1 && Inv => right = left + 1 && Res = right && a[right - 1] > key >= a[right]
            return right;
        } else {
            // right - left > 1
            int middle = left + (right - left) / 2;
            // right - left > 1 && left < middle < right
            if (array[middle] <= key) {
                // right' = middle
                // left' = left
                // left < middle < right => right' - left' < right - left
                // right' - left' < right - left && array[left'] > key >= array[right']
                return BinRec(array, key, left, middle);
            } else {
                // left' = middle
                // right' = right
                // left < middle < right => right' - left' < right - left
                // right' - left' < right - left && array[left'] > key >= array[right']
                return BinRec(array, key, middle, right);
            }
        }
    }

    // Pre: a[-1] = inf && a[a.length] = -inf && a[i] >= a[i + 1] for i = 0..a.length-1
    // Post: Res = right && a[right - 1] > key >= a[right]
    static int BinIter(int[] array, int key) {
        int left = -1;
        int right = array.length;
        // Inv: right' - left' < right - left && a[left'] > key >= a[right']
        while (right - left > 1) {
            //  right - left > 1
            int middle = left + (right - left) / 2;
            // right - left > 1 &&  left < middle < right
            if (array[middle] <= key) {
                right = middle;
                // right' = middle && a[middle] <= key => array[left] > key >= array[right']
                // right' = middle && left < middle < right => right' - left' < right - left
                // array[left] > key >= array[right'] && right' - left' < right - left
            } else {
                // right - left > 1 &&  left < middle < right && array[middle] > key
                left = middle;
                // left' = middle && right' = right && a[middle] > key => array[left'] > key >= array[right']
                // left' = middle && left < middle < right => right' - left' < right - left
                // array[left'] > key >= array[right'] && right' - left' < right - left
            }
        }

        // Inv && right - left == 1 => right = left + 1
        // Res = right && a[right - 1] > key >= a[right]
        return right;
    }

    // type = 0 for iterative bin search
    // type = 1 for recursive bin search
    private static int BinarySearch(int[] array, int key, int type) {
        if (type == 0) {
            return BinIter(array, key);
        }
        if (type == 1) {
            return BinRec(array, key, -1, array.length);
        }
        System.out.println("Wrong usage. type should be 0 or 1");
        return -1;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            int len = args.length - 1;
            int key = Integer.parseInt(args[0]);
            int[] numbers = new int[len];

            for (int i = 1; i <= len; i++) {
                numbers[i - 1] = Integer.parseInt(args[i]);
            }

            int ans = BinarySearch(numbers, key, 1);
            if (ans == len || numbers[ans] != key) {
                System.out.println(-ans - 1);
            } else {
                System.out.println(ans);
            }
        } else {
            System.out.println("Wrong usage");
        }
    }
}
