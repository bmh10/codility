package greedyAlgorithms;

import org.junit.Assert;
import org.junit.Test;

public class TieRopes {

    // Time O(N) Space O(1)
    public int solution(int K, int[] A) {
        int ropes = 0;
        int sum = 0;

        for (int a : A) {
            sum += a;
            if (sum >= K) {
                ropes++;
                sum = 0;
            }
        }

        return ropes;
    }

    @Test
    public void test() {
        final int[] A = { 1, 2, 3, 4, 1, 1, 3 };
        Assert.assertEquals(3, solution(4, A));

        final int[] B = { 3 };
        Assert.assertEquals(0, solution(4, B));

        final int[] C = { 4 };
        Assert.assertEquals(1, solution(4, C));
    }
}