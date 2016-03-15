package binarySearchAlgorithm;

import org.junit.Assert;
import org.junit.Test;

public class NailingPlanks {

    public int solution(int[] A, int[] B, int[] C) {
        final int N = A.length;
        final int M = C.length;

        boolean[] nailed = new boolean[N];
        int nailedPlankCount = 0;

        for (int n = 0; n < M; n++) {
            for (int i = 0; i < N; i++) {
                if (nailed[i]) continue;
                if (A[i] <= C[n] && C[n] <= B[i]) {
                    nailed[i] = true;
                    nailedPlankCount++;
                }
            }

            if (nailedPlankCount == N) {
                return n+1;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        final int[] A = { 1, 4, 5, 8 };
        final int[] B = { 4, 5, 9, 10 };
        final int[] C = { 4, 6, 7, 10, 2 };
        Assert.assertEquals(4, solution(A, B, C));

        final int[] A2 = { 2 };
        final int[] B2 = { 2 };
        final int[] C2 = { 1 };
        Assert.assertEquals(-1, solution(A2, B2, C2));

        final int[] A3 = { 1 };
        final int[] B3 = { 2 };
        final int[] C3 = { 2 };
        Assert.assertEquals(1, solution(A3, B3, C3));
    }
}



