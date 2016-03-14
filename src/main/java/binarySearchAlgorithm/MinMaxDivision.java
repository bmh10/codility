package binarySearchAlgorithm;

import org.junit.Assert;
import org.junit.Test;

public class MinMaxDivision {

    /**
     * @param K Max block count
     * @param M Every element of A is not greater than M
     * @param A Array of integers, size N
     * @return Minimal largest sum of any block
     */
    public int solution(int K, int M, int[] A) {
        int lb = Integer.MIN_VALUE;
        int ub = 0;
        for (int a : A) {
            lb = Math.max(lb, a);
            ub += a;
        }

        if (K == 1) return ub;
        if (K >= A.length) return lb;

        // Binary search
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (isBlockSizeValid(A, K, mid)) {
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }

        return lb;
    }

    private boolean isBlockSizeValid(int[] A, int maxBlockCount, int maxBlockSum) {
        int blockSum = 0;
        int blockCount = 0;

        for (int a : A) {
            if (blockSum + a <= maxBlockSum) {
                blockSum += a;
            } else {
                blockCount++;
                blockSum = a;
            }

            if (blockCount >= maxBlockCount) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        final int[] A = { 2, 1, 5, 1, 2, 2, 2 };
        Assert.assertEquals(6, solution(3, 5, A));
    }
}