package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxProductOfThree {

    // Time: O(nlogn) Space: O(1)
    public int solution(int[] A) {
        Arrays.sort(A);

        int obvious = A[A.length-3]*A[A.length-2]*A[A.length-1];
        int twoBigNegs = A[0]*A[1]*A[A.length-1];

        return Math.max(obvious, twoBigNegs);
    }

    @Test
    public void test() {
        final int[] A = { -3, 1, 2, -2, 5, 6 };
        Assert.assertEquals(60, solution(A));

        final int[] B = { -5, 5, -5, 4 };
        Assert.assertEquals(125, solution(B));

        final int[] C = { -5, -6, -4, -7, -10 };
        Assert.assertEquals(-120, solution(C));
    }
}
