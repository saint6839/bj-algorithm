package permutationandcombination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15652 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static int N;
    private static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);

        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i)
                  .append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
