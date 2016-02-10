package stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Fish {

    // Time O(N) Space O(N)
    public int solution(int[] A, int[] B) {
        final int N = A.length;
        final Deque<Integer> survivors = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            if (survivors.isEmpty() || B[i] == 1) {
                survivors.push(i);
                continue;
            }

            // B[i] == 0 now
            Integer prevIdx = survivors.peek();
            boolean currentFishWins = true;
            while (prevIdx != null && B[prevIdx] == 1 && currentFishWins) {
                currentFishWins = false;
                if (A[i] > A[prevIdx]) {
                    survivors.pop();
                    currentFishWins = true;
                }

                prevIdx = survivors.peek();
            }

            if (currentFishWins) {
                survivors.push(i);
            }
        }

        return survivors.size();
    }

    @Test
    public void test() {
        final int A[] = { 4, 3, 2, 1, 5 };
        final int B[] = { 0, 1, 0, 0, 0 };

        Assert.assertEquals(2, solution(A, B));
    }
}
