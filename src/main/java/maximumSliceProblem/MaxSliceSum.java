package maximumSliceProblem;

import org.junit.Assert;
import org.junit.Test;

public class MaxSliceSum {

    // Time O(N) Space O(1)
    public int solution(int[] A) {
        final int N = A.length;

        int maxSlice = Integer.MIN_VALUE;
        int maxEnding = 0;
        for (int i = 0; i < N; i++) {
            maxEnding = maxEnding + A[i];
            maxSlice = Math.max(maxSlice, maxEnding);
            if (maxEnding < 0) {
                maxEnding = 0;
            }
        }

        return maxSlice;
    }

    @Test
    public void test() {
        final int A[] = { -10 };
        Assert.assertEquals(-10, solution(A));

        final int B[] = { 3, 2, -6, 4, 0 };
        Assert.assertEquals(5, solution(B));

        final int C[] = { 3, 2, 6, -1, 4, 5, -1, 2 };
        Assert.assertEquals(20, solution(C));

        final int D[] = { -2, 1 };
        Assert.assertEquals(1, solution(D));
    }
}
