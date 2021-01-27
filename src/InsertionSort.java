import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int e = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > e) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = e;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 4, 2, 5, 3, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr)); // [0, 2, 3, 4, 5, 9]
    }
}
