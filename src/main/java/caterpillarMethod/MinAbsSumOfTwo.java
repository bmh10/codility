package caterpillarMethod;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MinAbsSumOfTwo {

    public int solution(int[] A) {
        final int N = A.length;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = N - 1;
        Arrays.sort(A);

        while (start <= end) {
            min = Math.min(min, Math.abs(A[start] + A[end]));
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                start++;
            } else {
                end--;
            }
        }

        return min;
    }

    @Test
    public void test() {
        final int[] A = { 1, 4, -3 };
        Assert.assertEquals(1, solution(A));

        final int[] B = { -8, 4, 5, -10, 3 };
        Assert.assertEquals(3, solution(B));

        final int[] C = { 1 };
        Assert.assertEquals(2, solution(C));

        final int[] D = { 3, 1, 3 };
        Assert.assertEquals(2, solution(D));

        final int[] E = {2, 2, 2 };
        Assert.assertEquals(4, solution(E));
    }
}