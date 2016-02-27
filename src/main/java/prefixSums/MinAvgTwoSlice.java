package prefixSums;

import org.junit.Assert;
import org.junit.Test;

public class MinAvgTwoSlice {

    // Time O(N) Space O(1)
    public int solution(int[] A) {
        final int N = A.length;

        double minAvg = Double.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < N-2; i++) {
            double avg2 = (A[i] + A[i+1]) / 2d;
            if (avg2 < minAvg) {
                minAvg = avg2;
                minIdx = i;
            }

            double avg3 = (A[i] + A[i+1] + A[i+2]) / 3d;
            if (avg3 < minAvg) {
                minAvg = avg3;
                minIdx = i;
            }
        }

        double avg2 = (A[N-2] + A[N-1]) / 2d;
        if (avg2 < minAvg) {
            minIdx = N-2;
        }

        return minIdx;
    }

    public int solutionNaive(int[] A) {
        final int N = A.length;

        final int[] prefixSum = new int[N];
        prefixSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = A[i] + prefixSum[i-1];
        }

        double minAvg = Double.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int upper = prefixSum[j];
                int lower = i-1 < 0 ? 0 : prefixSum[i-1];
                double avg = (double)(upper-lower) / (double)(j-i+1);
                if (avg < minAvg) {
                    minAvg = avg;
                    minIdx = i;
                }
            }
        }

        return minIdx;
    }

    @Test
    public void test() {
        final int[] A = { 4, 2, 2, 5, 1, 5, 8 };
        Assert.assertEquals(1, solution(A));

        final int[] B = { 1000, -1000 };
        Assert.assertEquals(0, solution(B));

        final int[] C = { -3, -5, -8, -4, -10 };
        Assert.assertEquals(2, solution(C));
    }
}
