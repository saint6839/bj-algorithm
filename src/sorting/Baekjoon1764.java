package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N+M];

        HashSet<String> results = new HashSet<>();

        int index = 0;
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            if (results.contains(name)) {
                names[index] = name;
                index++;
            }
            results.add(name);
        }

        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = names[i];
        }

        Arrays.sort(result);

        System.out.println(index);
        for (String s : result) {
            System.out.println(s);
        }

    }
}
