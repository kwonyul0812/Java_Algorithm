package ch02;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DataFind {
    // TODO : Arrays, Collecter 클래스 함수 무엇이 있는지 확인하고, lambda, Stream 공부하기.


    private int[] datas;

    // 임의의 갯수의 데이터를 생성 (size, bound)
    public void generatedRandomData(int size, int bound) {
        Random rand = new Random();

        datas = IntStream.range(0, size)
                .map(i -> rand.nextInt(bound))
                .toArray();
    }

    // 배열 내용 출력하기
    public void printArray() {
        if (datas == null || datas.length == 0) {
            throw new IllegalStateException("데이터가 없습니다. generatedRandomData()를 먼저 수행하세요.");
        }
        String result = Arrays.stream(datas)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    // 오름차순 정렬
    public void sortAscending() {
        if (datas == null || datas.length == 0) {
            throw new IllegalStateException("데이터가 없습니다. generatedRandomData()를 먼저 수행하세요.");
        }
        Arrays.sort(datas);
    }

    // 이진 탐색 후 첫번째 위치 확인 / -1
    public int findFirstIndex(int target) {
        if (datas == null || datas.length == 0) {
            throw new IllegalStateException("데이터가 없습니다. generatedRandomData()를 먼저 수행하세요.");
        }
        int index = Arrays.binarySearch(datas, target); // 이진탐색 라이브러리 함수
        if (index < 0) {
            return -1;
        }
        while (index > 0 && datas[index - 1] == target) {
            index--;
        }
        return index;
    }

}
