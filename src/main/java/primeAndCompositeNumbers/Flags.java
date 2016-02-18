package primeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Flags {

    // Time O(N) Space O(N)
    public int solution(int A[]) {
        // TODO: this is not completed
        final int N = A.length;
        final List<Integer> peaks = new ArrayList<Integer>();

        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }

        if (peaks.isEmpty()) {
            return 0;
        }

        final int maxPossibleFlags = peaks.size();

        Integer lastFlagPlacedIdx = null;
        int flags = 0;
        for (int peakIdx : peaks) {
            if (lastFlagPlacedIdx == null) {
                lastFlagPlacedIdx = peakIdx;
                flags++;
            } else {
                int diff = Math.abs(peakIdx - lastFlagPlacedIdx);
                if (diff >= maxPossibleFlags) {
                    lastFlagPlacedIdx = peakIdx;
                    flags++;
                }
            }
        }

        return flags;
    }

    @Test
    public void test() {
        final int[] A = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        Assert.assertEquals(3, solution(A));
    }
}
