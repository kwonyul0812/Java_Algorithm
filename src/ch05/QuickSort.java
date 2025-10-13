package ch05;

public class QuickSort {
    public void quickSort(int[] A, int low, int high) {
        if(low < high) {
            int s = partition(A, low, high);
            quickSort(A, low, s-1);
            quickSort(A, s+1, high);
        }
    }

    public int partition(int[] A, int low, int high) {
        int i = low + 1;
        int j = high;

        while(i <= j) {
            if(A[i] <= A[low]) {
                i += 1;
            } else if (A[j] > A[low]) {
                j -= 1;
            } else {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j++;
            }
        }
        int temp = A[low];
        A[low] = A[j];
        A[j] = temp;

        return j;
    }
}
