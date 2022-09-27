package set1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1062 {

    private static int N;
    private static int K;
    private static String[] subString;
    private static boolean visited[] = new boolean[26];
    private static int max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        subString = new String[N];

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                subString[i] = word.substring(4, word.length() - 4);
            }

            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            dfs(0, 0);
            System.out.println(max);

        }
    }

    private static void dfs(int index, int start) {
        if (index == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean isValid = true;
                for (int j = 0; j < subString[i].length(); j++) {
                    if (!visited[subString[i].charAt(j) - 'a']) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(index + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
