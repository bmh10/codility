package maximumSliceProblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxDoubleSliceSum {

    // Time O(N) Space O(N)
    public int solution(int[] A) {
        final int N = A.length;
        final int[] maxEnd = new int[N];
        final int[] maxBegin = new int[N];

        for (int i = 1; i < N-1; i++) {
            maxEnd[i] = Math.max(maxEnd[i-1] + A[i], 0);
            maxBegin[N-1-i] = Math.max(maxBegin[N-i] + A[N-1-i], 0);
        }

        /*for (int i = N-2; i > 0; i--) {
            maxBegin[i] = Math.max(maxBegin[i+1] + A[i], 0);
        }*/

        int max = 0;
        for (int i = 1; i < N-1; i++) {
            max = Math.max(max, maxEnd[i-1] + maxBegin[i+1]);
        }

        return max;
    }

    @Test
    public void test() {
        final int A[] = { 3, 2, 6, -1, 4, 5, -1, 2 };
        Assert.assertEquals(17, solution(A));

        final int B[] = { 5, 5, 5 };
        Assert.assertEquals(0, solution(B));

        final int C[] = { 5, 17, 0, 3 };
        Assert.assertEquals(17, solution(C));

        final int D[] = { 0, 10, -5, -2, 0 };
        Assert.assertEquals(10, solution(D));

        final int E[] = { 6, 1, 5, 6, 4, 2, 9, 4 };
        Assert.assertEquals(26, solution(E));

        final int F[] = { -8, 10, 20, -5, -7, -4 };
        Assert.assertEquals(30, solution(F));

        final int G[] = { -4, -5, -1, -5, -7, -19, -11 };
        Assert.assertEquals(0, solution(G));

        //A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

        //The sum of double slice (X, Y, Z) is the total
        //of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
    }
}
