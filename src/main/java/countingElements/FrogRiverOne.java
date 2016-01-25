package countingElements;

import org.junit.Assert;
import org.junit.Test;

public class FrogRiverOne {

    // O(N) time, O(X) space
    public int solution(int X, int[] A) {
        final boolean[] seen = new boolean[X];
        int progess = 0;

        for (int i = 0; i < A.length; i++) {
            int idx = A[i]-1;
            // If already seen element skip, else set bit and increment progress
            if (!seen[idx]) {
                seen[idx] = true;
                progess++;
                if (progess == X) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Test
    public void test() {
        final int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
        Assert.assertEquals(6, solution(5, A));

        final int[] B = { 1, 3, 1, 4, 2, 3, 2, 4 };
        Assert.assertEquals(-1, solution(5, B));
    }
}
