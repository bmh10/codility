package primeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Flags {

    // Time O(N) Space O(N)
    public int solution(int A[]) {
        final int N = A.length;

        // Calculate peaks O(N)
        final List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > Math.max(A[i-1], A[i+1])) {
                peaks.add(i);
            }
        }

        if (peaks.isEmpty()) {
            return 0;
        }

        // At each position calculate the next peak O(N)
        int[] next = new int[N];
        int peak = 0;
        for (int i = 0; i < N; i++) {
            if (peak < peaks.size()) {
                next[i] = peaks.get(peak);
                if (peaks.get(peak) == i) {
                    peak++;
                }
            } else {
                next[i] = -1;
            }
        }

        final int maxPossibleFlags = Math.min(peaks.size(), (int)Math.floor(Math.sqrt(N))+1);

        // Check possible flags O(N)
        int flags;
        for (flags = maxPossibleFlags; flags > 0; flags--) {
            if (check(next, flags, N)) {
                return flags;
            }
        }

        return flags;
    }

    private boolean check(int[] next, int x, int N) {
        int flags = x;
        int pos = 0;
        while (pos < N && flags > 0) {
            pos = next[pos];
            if (pos == -1) {
                break;
            }

            flags--;
            pos += x;
        }

        return flags == 0;
    }

    @Test
    public void test() {
        final int[] A = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        Assert.assertEquals(3, solution(A));

        final int[] B = { 1, 3, 2 };
        Assert.assertEquals(1, solution(B));
    }
}
