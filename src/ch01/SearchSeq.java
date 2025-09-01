package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchSeq {
//    정수 배열과 탐색할 정수 X가 주어쪗을때, X가 배열에 존재하면 가장 앞에 등장하는 인덱스(0-based)를 출력하고 존재하지 않으면 -1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄읽기 및 글자 분리
//        System.out.println(st.countTokens()); // 분리된 글자(토큰)의 개수 확인

        int n = Integer.parseInt(st.nextToken());
        int key = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int index = -1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == key && index == -1) {
                index = i;
            }
        }

        System.out.println("위치 : " + index);
    }
}
