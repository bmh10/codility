package fibonacciNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FibFrog {

    public int solution(int[] A) {
        final int N = A.length;
        final int LEFT_BANK = 0;
        final int RIGHT_BANK = N + 1;

        final Set<Integer> fibs = generateFibs(RIGHT_BANK);
        fibs.remove(0);

        final int[] jumps = new int[N + 2];
        jumps[LEFT_BANK] = 0;
        jumps[RIGHT_BANK] = -1;

        final int[] Anew = new int[N + 2];
        Anew[LEFT_BANK] = 1;
        Anew[RIGHT_BANK] = 1;

        for (int i = LEFT_BANK + 1; i < RIGHT_BANK; i++) {
            jumps[i] = -1;
            Anew[i] = A[i-1];
        }

        for (int i = LEFT_BANK + 1; i <= RIGHT_BANK; i++) {
            if (Anew[i] == 0) {
                continue;
            }

            jumps[i] = Integer.MAX_VALUE;

            for (int jumpSize : fibs) {
                int prevIdx = i - jumpSize;
                if (prevIdx < 0 || Anew[prevIdx] == 0 || jumps[prevIdx] == -1) {
                    continue;
                }

                jumps[i] = Math.min(jumps[i], jumps[prevIdx] + 1);
            }

            if (jumps[i] == Integer.MAX_VALUE) {
                jumps[i] = -1;
            }
        }

        return jumps[RIGHT_BANK];
    }

    private Set<Integer> generateFibs(int N) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(0);
        fibs.add(1);
        while (fibs.get(fibs.size() - 1) <= N) {
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }

        return new HashSet<>(fibs);
    }

    @Test
    public void test() {
        final int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
        Assert.assertEquals(3, solution(A));

        final int[] B = { 1 };
        Assert.assertEquals(1, solution(B));

        final int[] C = { 1, 1, 0, 0, 0 };
        Assert.assertEquals(2, solution(C));

        final int[] D = { 0, 0, 0 };
        Assert.assertEquals(-1, solution(D));
    }
}
