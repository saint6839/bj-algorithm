package set1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (K >= coin[i]) {

                while (K >= 0) {
                    count++;
                    K -= coin[i];
                }

                if (K < 0) {
                    count--;
                    K += coin[i];
                }

                if (K == 0) {
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
