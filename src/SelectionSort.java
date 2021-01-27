import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int index = i;

            for (int j = i + 1; j < length; j++)
                if (arr[j] < arr[index])
                    index = j;

            if (index != i) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 4, 2, 5, 3, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr)); // [0, 2, 3, 4, 5, 9]
    }
}
