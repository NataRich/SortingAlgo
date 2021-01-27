import java.util.Arrays;

public class MergeSort {
    public static void sort(int [] numbers, int i, int k) {
        int j;

        if (i < k) {
            j = (i + k) / 2;  // Find the midpoint in the partition

            // Recursively sort left and right partitions
            sort(numbers, i, j);
            sort(numbers, j + 1, k);

            // Merge left and right partition in sorted order
            merge(numbers, i, j, k);
        }
    }

    public static void merge(int [] numbers, int i, int j, int k) {
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
            if (numbers[leftPos] < numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                ++leftPos;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
            ++mergePos;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
            ++mergePos;
        }

        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 4, 2, 5, 3, 0};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [0, 2, 3, 4, 5, 9]
    }
}
