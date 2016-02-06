package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    // Time: O(nlogn) Space: O(n)
    public int solution(int[] A) {
        final int N = A.length;
        final double[] mins = new double[N];
        final double[] maxs = new double[N];

        for (int i = 0; i < N; i++) {
            mins[i] = (double)i - (double)A[i];
            maxs[i] = (double)i + (double)A[i];
        }

        Arrays.sort(mins);
        Arrays.sort(maxs);

        int maxIdx = 0;
        int minIdx = 0;
        int count = 0;
        int mult = 0;

        while (minIdx < N && maxIdx < N) {
            if (mins[minIdx] <= maxs[maxIdx]) {
                // We are at a min
                count += mult;
                if (count > 10000000) {
                    return -1;
                }
                mult++;
                minIdx++;
            } else {
                // We are at a max
                mult--;
                maxIdx++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        final int[] A = { 1, 5, 2, 1, 4, 0 };
        Assert.assertEquals(11, solution(A));

        final int[] B = { 1, 2147483647, 0 };
        Assert.assertEquals(2, solution(B));
    }
}
