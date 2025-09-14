package ch02;

import java.util.Scanner;

public class BinarySearchPractice {
    public static void main(String[] args) {
        int[] A = {10, 12, 13, 14, 18, 20, 25, 27, 30, 35, 40, 45, 47};

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("찾고 싶은 정수를 입력하세요 : ");
            int target = sc.nextInt();
            int result = binarySearch(A, 0, A.length - 1, target);

            System.out.println("찾고자 하는 값의 인덱스는 " + result + "입니다.");
        }
    }

    public static int binarySearch(int[] A, int first, int last, int x) {
        if (first > last) return -1;
        else {
            int mid = (first + last) / 2;

            if (x == A[mid]) return mid; // 찾은 경우
            else if (x < A[mid]) // 찾는 x 값이 중간값보다 작다면
                return binarySearch(A, first, mid - 1, x);
            else // 중간값 뒤쪽에서 x 찾기
                return binarySearch(A, mid + 1, last, x);
        }
    }
}
