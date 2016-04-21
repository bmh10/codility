package dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

public class NumberSolitaire {

    // Time O(N) Space O(N)
    // Could make space O(1) by only storing dp for last 6 items
    public int solution(int[] A) {
        final int N = A.length;
        final int[] dp = new int[N];
        dp[0] = A[0];

        for (int i = 1; i < N; i++) {
            int last6Max = Integer.MIN_VALUE;
            for (int j = 1; j <= Math.min(6, i); j++) {
                last6Max = Math.max(last6Max, dp[i - j]);
            }

            dp[i] = last6Max + A[i];
        }

        return dp[N - 1];
    }

    @Test
    public void test() {
        final int[] A = { 1, -2, 0, 9, -1, -2 };
        Assert.assertEquals(8, solution(A));

        final int[] B = { 1, -2, 0, 9, -1, -2, 3, 0, -1, 4, -4, 6 };
        Assert.assertEquals(23, solution(B));

        final int[] C = { 1, -1, -2, -3, -4, -5, -100, -7, -8, -9, -10, 5 };
        Assert.assertEquals(1, solution(C));

        final int[] D = { 1, 1, 1, 1 };
        Assert.assertEquals(4, solution(D));

        final int[] E = { -3, -4, -3, 2, -7, -1 };
        Assert.assertEquals(-2, solution(E));
    }
}