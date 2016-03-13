package fibonacciNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Ladder {

    public int[] solution(int[] A, int[] B) {
        final int N = A.length;
        int L = Integer.MIN_VALUE;
        int Bmax = Integer.MIN_VALUE;
        for (int a : A) {
            L = Math.max(L, a);
        }

        for (int b : B) {
            Bmax = Math.max(Bmax, b);
        }

        final int[] fibs = new int[L + 2];
        fibs[1] = 1;
        for (int i = 2; i < L+2; i++) {
            fibs[i] = (fibs[i-1] + fibs[i-2]) & ((1 << Bmax) - 1);
        }

        final int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = fibs[A[i] + 1] & ((1 << B[i]) - 1);
        }

        return ans;
    }

    @Test
    public void test() {
        final int[] A = { 4, 4, 5, 5, 1 };
        final int[] B = { 3, 2, 4, 3, 1 };
        final int[] ans = { 5, 1, 8, 0, 1 };
        Assert.assertEquals(Arrays.toString(ans), Arrays.toString(solution(A, B)));
    }
}
