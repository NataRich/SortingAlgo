import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr, int l, int r) {
        if (l < r) { // recursive case for recursion
            int left = l, right = r, n = arr[l]; // start from the very left
            // if left !< right, it means there might be more numbers to be swapped in this loop
            // e.g. given {1, 7, 5, 3, 2, 0} where n = 3, left = 1, right = 5
            // 5 and 2 are waiting to be swapped
            while (left < right) {
                // check whether the numbers from RHS of n is bigger than or equal to n
                while (left < right && arr[right] >= n)
                    // if yes, then decrement the index and check the next one
                    // until right <= left or one number from RHS is smaller than n
                    right--;
                // if the program exits the loop due to arr[right] < n, then it means there is a
                // number from RHS of n greater than or equal to n, when a swap should occur
                if (left < right)
                    // 1) swap the numbers
                    // 2) increment left index because the element at current left index is known
                    // to be smaller than n
                    arr[left++] = arr[right];
                // check whether the numbers from LHS of n is smaller than n
                while (left < right && arr[left] < n)
                    // if yes, then increment the index and check the next one
                    // until left >= right or one number from LHS is bigger than or equal to n
                    left++;
                // if the program exits the loop due to arr[left] >= n, then it means there is a
                // number from LHS of n smaller than n, when a swap should occur
                if (left < right)
                    // 1) swap the numbers
                    // 2) decrement right index because the element at current right index is known
                    // to be bigger than or equal to n
                    arr[right--] = arr[left];
            }
            // by now, all the numbers on the LHS of n are smaller than n, and all the numbers
            // on the RHS of n are bigger than or equal to n.
            // e.g. {1, 0, 2, 3, 5, 7} where n = 3, left = 3, right = 3
            arr[left] = n; // swap
            sort(arr, l, left - 1); // do the same thing to the part {1, 0, 2}
            sort(arr, left + 1, r); // do the same thing to the part {5， 7}
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 4, 2, 5, 3, 0};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // [0, 2, 3, 4, 5, 9]
    }
}
