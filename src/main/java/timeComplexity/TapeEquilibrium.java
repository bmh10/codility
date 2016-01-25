package timeComplexity;

import org.junit.Assert;
import org.junit.Test;

public class TapeEquilibrium {

    // O(N) space + time
    public int solution(int[] A) {
        // Create cumulative arr
        int[] cum = new int[A.length];
        cum[0] = A[0];
        for (int i = 1; i < cum.length; i++) {
            cum[i] = A[i] + cum[i-1];
        }

        // Figure out min possible diff
        int sum = cum[cum.length-1];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < cum.length-1; i++) {
            int diff = Math.abs(2*cum[i] - sum);
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;
    }

    // O(1) space, O(N) time
    public int solution2(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        // Figure out min possible diff
        int minDiff = Integer.MAX_VALUE;
        int cum = A[0];
        for (int i = 1; i < A.length; i++) {
            int diff = Math.abs(2*cum - sum);
            minDiff = Math.min(diff, minDiff);
            cum += A[i];
        }

        return minDiff;
    }

    @Test
    public void test() {
        int[] A = { 3, 1, 2, 4, 3 };
        Assert.assertEquals(1, solution2(A));
    }
}
