package stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneWall {

    // Time O(N) Space O(N)
    public int solution(int[] H) {
        final int N = H.length;

        int blockCount = 1;
        final Deque<Integer> reusableHeights = new ArrayDeque<>();
        reusableHeights.push(H[0]);

        for (int i = 1; i < N; i++) {
            if (H[i] == H[i-1]) {
                continue;
            } else if (H[i] > H[i-1]) {
                blockCount++;
                reusableHeights.push(H[i]);
            } else {
                if (!reusableHeights.contains(H[i])) {
                    blockCount++;
                }
                while (!reusableHeights.isEmpty() && reusableHeights.peek() >= H[i]) {
                    reusableHeights.pop();
                }
                reusableHeights.push(H[i]);
            }
        }

        return blockCount;
    }

    @Test
    public void test() {
        final int[] A = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
        Assert.assertEquals(7, solution(A));

        final int[] B = { 2, 3, 2, 1 };
        Assert.assertEquals(3, solution(B));
    }
}
