package ch01;

import java.util.Map;

public class FindMaxValue {
    // 최대값의 인덱스와 값 출력하기
    // 입력값 72, 60, 83, 47, 89, 95,

    public static Map<String, Integer> findMaximun(int[] num) {
        int max = num[0];
        int index = 0;

        for (int i = 1; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }

        return Map.of("max", max, "index", index);
    }

    public static void main(String[] args) {

        int[] num = {72, 60, 83, 47, 89, 95};

        Map<String, Integer> result = findMaximun(num);
        System.out.println("최대 값: " + result.get("max") + " 최대값 인덱스 : " + result.get("index"));

    }
}
