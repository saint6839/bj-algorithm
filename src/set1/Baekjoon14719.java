package set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14719 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] heights = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;

        int result = 0;


        for (int i = 1; i < W-1; i++) {
            left = right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(heights[j], left);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(heights[j], right);
            }

            if (heights[i] < left && heights[i] < right) {
                result += Math.min(left, right) - heights[i];
            }
        }

        System.out.println(result);

    }
}
