package countingElements;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxCounters {

    // Space O(N), time O(M+N)
    // A is of size 'M'
    // N.B. new int[N] for large N is expensive so only do it if necessary
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0; // Current max counter val
        int base = 0; // Base value after each 'max counter' op

        for (int a : A) {
            if (a <= N) {
                counters[a-1]++;
                max = Math.max(max, counters[a-1]);
            } else { // a == N+1
                base += max;
                if (max > 0) {
                    counters = new int[N]; // Reset counters - actual vals given by base + counters
                }
                max = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] += base;
        }

        return counters;
    }

    @Test
    public void test() {
        final int[] A = { 3, 4, 4, 6, 1, 4, 4 };
        final int[] Ares = { 3, 2, 2, 4, 2 };
        Assert.assertEquals(Arrays.toString(Ares), Arrays.toString(solution(5, A)));

        // All max_counter ops -> result should be all 0s
        int[] B = new int[100000];
        for (int i = 0; i < B.length; i++) {
            B[i] = 100001;
        }

        final int[] Bres = new int[100000];

        final long start = System.currentTimeMillis();
        Assert.assertEquals(Arrays.toString(Bres), Arrays.toString(solution(100000, B)));
        final long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }
}
