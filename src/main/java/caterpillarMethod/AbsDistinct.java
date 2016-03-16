package caterpillarMethod;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbsDistinct {

    // Time O(N) Space(N)
    public int solution(int[] A) {
        final Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(Math.abs(a));
        }

        return set.size();
    }

    // Time O(N) Space O(1)
    public int solutionPointers(int[] A) {
        int head = 0;
        int tail = A.length - 1;

        int absCount = 0;
        while (head <= tail) {
            int absHead = Math.abs(A[head]);
            int absTail = Math.abs(A[tail]);

            absCount++;
            // Must have been Integer.MIN_VALUE (special case: abs(Integer.MIN_VALUE) = INTEGER.MIN_VALUE
            if (absHead < 0) {
                head = move(A, absHead, head, true);
            } else if (absTail < 0) {
                tail = move(A, absTail, tail, false);
            } else if (absTail == absHead) {
                head = move(A, absHead, head, true);
                tail = move(A, absTail, tail, false);
            } else if (absTail > absHead) {
                tail = move(A, absTail, tail, false);
            } else {
                head = move(A, absHead, head, true);
            }
        }

        return absCount;
    }

    private int move(int[] A, int currValue, int currIdx, boolean inc) {
        while (currIdx >= 0 && currIdx < A.length && Math.abs(A[currIdx]) == currValue) {
            if (inc) currIdx++; else currIdx --;
        }

        return currIdx;
    }



    @Test
    public void test() {
        final int[] A = { -5, -3, -1, 0, 3, 6 };
        Assert.assertEquals(5, solution(A));

        final int[] B = { -2147483648, -1, 0, 1 };
        Assert.assertEquals(3, solution(B));

        final int[] C = { 1, 1, 1, 1, 1 };
        Assert.assertEquals(1, solution(C));
    }
}



