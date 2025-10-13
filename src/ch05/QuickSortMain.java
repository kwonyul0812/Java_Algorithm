package ch05;

import java.util.Arrays;

public class QuickSortMain {
    public static void main(String[] args) {
        int[] arr = {15, 22, 13, 27, 12, 10, 20, 25};
        System.out.println("정렬전 배열 : ");
        System.out.println(Arrays.toString(arr));

        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length-1);
        System.out.println("정렬후 배열 : ");
        System.out.println(Arrays.toString(arr));
    }
}
