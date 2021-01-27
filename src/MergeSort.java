import java.util.Arrays;

public class MergeSort {
    public static void sort(int [] arr, int i, int k) {
        int j;

        if (i < k) {
            j = (i + k) / 2;  // Find the midpoint in the partition

            // Recursively sort left and right partitions
            sort(arr, i, j);
            sort(arr, j + 1, k);

            // Merge left and right partition in sorted order
            merge(arr, i, j, k);
        }
    }

    public static void merge(int [] arr, int i, int j, int k) {
        int mergedSize = k - i + 1;       // Size of merged partition
        int[] mergedNumbers = new int[mergedSize]; // Temporary array for merged numbers
        int mergePos;                     // Position to insert merged number
        int leftPos;                      // Position of elements in left partition
        int rightPos;                     // Position of elements in right partition

        mergePos = 0;
        leftPos = i;                      // Initialize left partition position
        rightPos = j + 1;                 // Initialize right partition position

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= j && rightPos <= k) {
            if (arr[leftPos] < arr[rightPos]) {
                mergedNumbers[mergePos] = arr[leftPos];
                ++leftPos;
            }
            else {
                mergedNumbers[mergePos] = arr[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
            mergedNumbers[mergePos] = arr[leftPos];
            ++leftPos;
            ++mergePos;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
            mergedNumbers[mergePos] = arr[rightPos];
            ++rightPos;
            ++mergePos;
        }

        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            arr[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 4, 2, 5, 3, 0};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [0, 2, 3, 4, 5, 9]
    }
}
