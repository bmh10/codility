package greedyAlgorithms;

import org.junit.Assert;
import org.junit.Test;

public class MaxNonOverlappingSegments {

    // Time O(N) Space O(1)
    public int solution(int[] A, int[] B) {
        final int N = A.length;
        int prevEnd = -1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] > prevEnd) {
                prevEnd = B[i];
                count++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        final int[] A = { 1, 3, 7, 9, 9 };
        final int[] B = { 5, 6, 8, 9, 10 };
        Assert.assertEquals(3, solution(A, B));
    }
}