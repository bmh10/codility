package binarySearchAlgorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class NailingPlanks {

    // TODO: this does not work
    public int solution(int[] A, int[] B, int[] C) {
        final int N = A.length;
        final int M = C.length;

        Map<Integer, Integer> nailPositionToIdx = new HashMap<>();

        for (int i = 0; i < M; i++) {
            nailPositionToIdx.put(C[i], i);
        }

        int overallMaxNailIdx = Integer.MIN_VALUE;

        // Find min idx nail for each plank
        for (int i = 0; i < N; i++) {
            int plankStart = A[i];
            int plankEnd = B[i];
            int minNailIdxForPlank = Integer.MAX_VALUE;
            // TODO: find min nail idx using binary search
            for (int j = plankStart; j <= plankEnd; j++) {
                Integer nailIdx = nailPositionToIdx.get(j);
                if (nailIdx == null) continue;
                minNailIdxForPlank = Math.min(minNailIdxForPlank, nailIdx);
            }

            // No nail for this plank
            if (minNailIdxForPlank == Integer.MAX_VALUE) {
                return -1;
            }

            overallMaxNailIdx = Math.max(overallMaxNailIdx, minNailIdxForPlank);
        }

        return overallMaxNailIdx + 1;
    }


    public int solutionBruteForce(int[] A, int[] B, int[] C) {
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



