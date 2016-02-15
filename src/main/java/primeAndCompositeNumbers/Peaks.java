package primeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Peaks {

    //
    public int solution(int A[]) {
        final int N = A.length;
        final double sqrtN = Math.sqrt(N);

        final List<Integer> peaks = new ArrayList<Integer>();

        // O(N)
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }

        if (peaks.isEmpty()) {
            return 0;
        }

        int max = 0;
        for (int i = peaks.get(0); i <= sqrtN; i++) {
            if (N % i == 0) {
                if (isCorrect(i, N, peaks)) {
                    max = Math.max(max, i);
                }

                // Then try i's matching pair
                int j = N / i;
                if (j <= i) {
                    continue;
                }
                if (isCorrect(j, N, peaks)) {
                    max = Math.max(max, i);
                }
            }
        }

        return max;
    }

    private boolean isCorrect(int gap, int N, List<Integer> peaks) {
        int st = 0;
        int end;
        while (st < N) {
            end = st + gap - 1;
            boolean peakFound = false;
            for (int p : peaks) {
                if (p >= st && p <= end) {
                    peakFound = true;
                    break;
                }
            }

            if (!peakFound) {
                return false;
            }

            st += gap;
        }

        return true;
    }

    @Test
    public void test() {
        final int[] A = { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
        Assert.assertEquals(3, solution(A));

        final int[] B = { 5 };
        Assert.assertEquals(0, solution(B));
    }
}
