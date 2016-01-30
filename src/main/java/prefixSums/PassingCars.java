package prefixSums;

import org.junit.Assert;
import org.junit.Test;

public class PassingCars {

    // Time O(N) space O(1)
    public int solution(int[] A) {
        int zeros = 0;
        int passingCars = 0;

        for (int a : A) {
            if (a == 0) zeros++;
            else {
                passingCars += zeros;
                if (passingCars > 1000000000) {
                    return -1;
                }
            }
        }

        return passingCars;
    }

    // Time O(N) space O(1)
    // Less efficient that above as requires 2N iterations
    public int solutionPrefixSum(int[] A) {
        // Replace original array with prefix sum
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i-1] + A[i];
        }

        int maxSum = A[A.length - 1];
        int passingCars = 0;
        // Since we no longer have original array, use prefix sum
        // previous value to check if we are at a '0'
        int prevVal = A[0] == 0 ? A[0] : -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == prevVal) {
                passingCars += (maxSum - A[i]);
                if (passingCars > 1000000000) {
                    return -1;
                }
            }

            prevVal = A[i];
        }

        return passingCars;
    }

    @Test
    public void test() {
        final int[] A = { 0, 1, 0, 1, 1 };
        Assert.assertEquals(5, solution(A));
    }
}
