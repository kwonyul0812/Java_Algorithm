package ch03;

public class HeapSort {
    public static void main(String[] args) {
        int[] intArray = {0, 1, 2, 6, 4, 8, 7};
        int i;

        // 정렬하기전 배열 출력
        System.out.print("정렬 전 배열: ");

        for (i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

        // 힙 정렬을 사용하여 정렬하기 위해 heapSort 메소드 호출
        heapSort(intArray);

        // 정렬한 후 배열을 출력
        System.out.print("\n 정렬 후 배열: ");

        for (i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

    public static void heapSort(int[] A) {
        int eh, temp;

        eh = A.length - 1;

        // 주어진 배열을 힙으로 만든다
        buildHeap(A, eh);

        // 힙에서 최대값을 제거하고 남은 트리를 다시 힙으로 만듬
        while (eh > 1) {
            // A[1]과 A[eh]를 교환
            temp = A[1];
            A[1] = A[eh];
            A[eh] = temp;

            // 힙에서 최대값 제거
            eh = eh - 1;

            // 남은 트리를 다시 힙으로 만듬
            pushDown(A, 1, eh / 2, eh);
        }
    }

    // 배열 A[1..eh]를 힙으로 만듬
    public static void buildHeap(int[] A, int eh) {
        int bh, x;

        bh = (A.length - 1) / 2 + 1;

        while (bh > 1) {
            bh = bh - 1;
            x = bh;

            // x에서 힙 조건이 만족될 때까지 A[x]를 트리의 아래 층으로
            // 내려 보낸다
            pushDown(A, x, bh, eh);
        }
    }

    // A[x]를 힙 조건이 만족될 때까지 트리의 아래 층으로 내려 보낸다
    public static void pushDown(int[] A, int x, int bh, int eh) {
        int y, temp;

        y = findLarger(A, x, eh);

        while (A[x] < A[y]) {
            temp = A[x];
            A[x] = A[y];
            A[y] = temp;

            x = y;

            y = findLarger(A, x, eh);
        }
    }

    // A[x]보다 큰 값을 가지는 x의 자식 노드의 지수를 구한다.
    public static int findLarger(int[] A, int x, int eh) {
        int y = 0;

        if (2 * x + 1 <= eh) {
            // 자식 노드가 둘 다 있는 경우
            if (A[2 * x] > A[x] || A[2 * x + 1] > A[x]) {
                // A[x]보다 더 큰 값을 가지는 자식 노드의 지수를 구한다
                if (A[2 * x] >= A[2 * x + 1]) y = 2 * x;
                else y = 2 * x + 1;
            }
        } else // 자식 노드가 하나만 있는 경우
            if (2 * x <= eh && A[2 * x] > A[x]) y = 2 * x;

        return y;
    }
}
