package ch01;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] num = {72, 60, 83, 47, 89, 95};

        Map<String, Integer> result = new FindMaxValue().findMaximun(num);
        System.out.println("최대 값: " + result.get("max") + " 최대값 인덱스 : " + result.get("index"));

    }
}
