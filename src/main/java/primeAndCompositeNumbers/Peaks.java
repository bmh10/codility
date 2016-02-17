package primeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Peaks {

    // Time O(N*log(log(N)) Space O(N)
    public int solution(int A[]) {
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

        final int maxPossibleBlocks = peaks.size();

        for (int blocks = maxPossibleBlocks; blocks > 0; blocks--) {
            if (N % blocks == 0) {
                final int blockSize = N / blocks;
                final Set<Integer> completeBlocks = new HashSet<Integer>();
                for (int peakIdx : peaks) {
                    final int peakBlock = Math.floorDiv(peakIdx, blockSize);
                    completeBlocks.add(peakBlock);
                }

                if (completeBlocks.size() == blocks) {
                    return blocks;
                }
            }
        }

        return 0;
    }

    @Test
    public void test() {
        final int[] A = { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        Assert.assertEquals(3, solution(A));

        final int[] B = { 5 };
        Assert.assertEquals(0, solution(B));
    }
}
