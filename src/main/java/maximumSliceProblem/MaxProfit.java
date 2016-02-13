package maximumSliceProblem;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfit {

    // Time O(N) Space O(1)
    public int solution(int[] A) {
        final int N = A.length;

        int maxProfit = 0;
        int localMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (A[i] < localMin) {
                localMin = A[i];
            } else {
                maxProfit = Math.max(maxProfit, A[i] - localMin);
            }
        }

        return maxProfit;
    }

    @Test
    public void test() {
        final int A[] = { 23171, 21011, 21123, 21366, 21013, 21367 };
        Assert.assertEquals(356, solution(A));

        final int B[] = { };
        Assert.assertEquals(0, solution(B));

        final int C[] = { 8, 9, 3, 6, 1, 2 };
        Assert.assertEquals(3, solution(C));
    }
}
