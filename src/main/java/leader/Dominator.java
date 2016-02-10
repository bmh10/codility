package leader;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dominator {

    // Time O(N)
    public int solution(int[] A) {
        final int N = A.length;
        final int halfN = N >> 1; // Bit shift to divide by 2

        final Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int a : A) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (stack.peek() != a) {
                    stack.pop();
                } else {
                    stack.push(a);
                }
            }
        }

        if (stack.isEmpty()) {
            return -1;
        }

        final int candidate = stack.pop();
        int count = 0;
        int idx = -1;
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                count++;
                idx = i;
            }
        }

        if (count > halfN) {
            return idx;
        }

        return -1;
    }

    @Test
    public void test() {
        final int A[] = { 3, 4, 3, 2, 3, -1, 3, 3 };
        Assert.assertEquals(7, solution(A));

        final int B[] = { 2, 1, 1, 1, 3 };
        Assert.assertEquals(3, solution(B));
    }
}
