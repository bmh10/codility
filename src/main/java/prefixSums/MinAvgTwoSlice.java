package prefixSums;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinAvgTwoSlice {

    /*public int solution(int[] A) {
        final int N = A.length;
        double[] avg = new double[N];
        avg[N-1] = A[N-1];
        for (int i = N-2; i >= 0; i--) {
            avg[i] = A[i] + avg[i+1];
        }

        for (int i = 0; i < N; i++) {
            avg[i] /= (N - i);
        }

        double minVal = Double.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < N; i++) {
            if (avg[i] < minVal) {
                minVal = avg[i];
                minIdx = i;
            }
        }

        return minIdx;
    }*/

    public int solution(int[] A) {

        return -1;
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
    }
}
