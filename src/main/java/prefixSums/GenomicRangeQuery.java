package prefixSums;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {

    // Time O(N + M) Space O(N)
    public int[] solution(String S, int[] P, int[] Q) {
        final int N = S.length();
        final int M = P.length;
        final Map<Character, Integer> boostFactors = new HashMap<Character, Integer>();
        boostFactors.put('A', 0);
        boostFactors.put('C', 1);
        boostFactors.put('G', 2);
        boostFactors.put('T', 3);

        // Create prefix sum per letter
        final int[][] prefixSum = new int[4][N];
        int impact = boostFactors.get(S.charAt(0));
        prefixSum[impact][0] = 1;

        for (int i = 1; i < N; i++) {
            impact = boostFactors.get(S.charAt(i));

            for (int j = 0; j < 4; j++) {
                prefixSum[j][i] = prefixSum[j][i-1];
                if (j == impact) {
                    prefixSum[j][i]++;
                }
            }
        }

        // Go over queries and use prefix sum to calculate minimum
        int[] mins = new int[M];
        for (int i = 0; i < M; i++) {
            int minIdx = P[i];
            int maxIdx = Q[i];

            if (minIdx == maxIdx) {
                mins[i] = boostFactors.get(S.charAt(minIdx)) + 1;
                continue;
            }

            for (int j = 0; j < 4; j++) {
                int max = prefixSum[j][maxIdx];
                int min = minIdx - 1 < 0 ? 0 : prefixSum[j][minIdx-1];
                if (max > min) {
                    mins[i] = j + 1;
                    break;
                }
            }
        }

        return mins;
    }

    public int[] solutionNaive(String S, int[] P, int[] Q) {
        final int N = S.length();
        final int M = P.length;
        final Map<Character, Integer> boostFactors = new HashMap<Character, Integer>();
        boostFactors.put('A', 1);
        boostFactors.put('C', 2);
        boostFactors.put('G', 3);
        boostFactors.put('T', 4);

        final int[] impacts = new int[S.length()];
        for (int i = 0; i < N; i++) {
            impacts[i] = boostFactors.get(S.charAt(i));
        }

        int[] mins = new int[M];
        for (int i = 0; i < M; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = P[i]; j <= Q[i]; j++) {
                min = Math.min(min, impacts[j]);
            }

            mins[i] = min;
        }

        return mins;
    }

    @Test
    public void test() {
        final int[] P = { 2, 5, 0 };
        final int[] Q = { 4, 5, 6 };
        final int[] ans = { 2, 4, 1 };
        Assert.assertEquals(Arrays.toString(ans), Arrays.toString(solution("CAGCCTA", P, Q)));

        final int[] P2 = { 0, 0, 1 };
        final int[] Q2 = { 0, 1, 1 };
        final int[] ans2 = { 1, 1, 2 };
        Assert.assertEquals(Arrays.toString(ans2), Arrays.toString(solution("AC", P2, Q2)));
    }
}
