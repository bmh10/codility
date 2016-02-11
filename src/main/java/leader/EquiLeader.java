package leader;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class EquiLeader {

    // Time O(N) Space O(N)
    public int solution(int[] A) {
        final int N = A.length;
        final int halfN = N >> 1; // Bit shift to divide by 2

        final Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int a : A) {
            if (stack.isEmpty() || stack.peek() == a) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return 0;
        }

        final int candidateLeader = stack.pop();
        int count = 0;
        int[] leaderCountAtPoint = new int[N];
        for (int i = 0; i < N; i++) {
            if (A[i] == candidateLeader) {
                count++;
            }

            leaderCountAtPoint[i] = count;
        }

        // If candidate leader is not a leader -> will be no equileaders
        if (count <= halfN) {
            return 0;
        }

        int equiLeaderCount = 0;
        int lessCount, moreCount, lowerMinThreshold, upperMinThreshold;
        for (int i = 0; i < N; i++) {
            lessCount = leaderCountAtPoint[i];
            moreCount = leaderCountAtPoint[N-1] - lessCount;

            lowerMinThreshold = (i+1) >> 1;
            upperMinThreshold = (N-(i+1)) >> 1;

            if (lessCount > lowerMinThreshold && moreCount > upperMinThreshold) {
                equiLeaderCount++;
            }
        }

        return equiLeaderCount;
    }

    @Test
    public void test() {
        final int A[] = { 4, 3, 4, 4, 4, 2 };
        Assert.assertEquals(2, solution(A));

        final int B[] = { 4, 4, 2, 5, 3, 4, 4, 4 };
        Assert.assertEquals(3, solution(B));
    }
}
