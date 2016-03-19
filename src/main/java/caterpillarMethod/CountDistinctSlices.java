package caterpillarMethod;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountDistinctSlices {

    // Time O(N) Space O(M)
    public int solution(int M, int[] A) {
        final int N = A.length;
        int count = 0;
        int start = 0;
        int end = 0;
        // Instead of using bi-directional map
        final Map<Integer, Integer> valToLastSeenIdx = new HashMap<>(M+1);
        final Map<Integer, Integer> lastSeenIdxToVal = new HashMap<>(M+1);

        while (end < N) {
            valToLastSeenIdx.put(A[end], end);
            lastSeenIdxToVal.put(end, A[end]);
            count += (end - start + 1);
            if (count > 1000000000) {
                return 1000000000;
            }

            end++;
            if (end < N && valToLastSeenIdx.containsKey(A[end])) {
                int lastSeenIdx = valToLastSeenIdx.get(A[end]);
                for (int i = start; i <= lastSeenIdx; i++) {
                    Integer val = lastSeenIdxToVal.get(i);
                    if (val == null) {
                        continue;
                    }
                    lastSeenIdxToVal.remove(i);
                    valToLastSeenIdx.remove(val);
                }

                start = lastSeenIdx + 1;
            }
        }

        return count;
    }

    // Brute force
    public int solutionBruteForce(int M, int[] A) {
        final int N = A.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            set.clear();
            for (int j = i; j < N; j++) {
                if (set.contains(A[j])) {
                    break;
                }

                set.add(A[j]);
                count++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        final int[] A = { 3, 4, 5, 5, 2 };
        Assert.assertEquals(9, solution(6, A));

        final int[] B = { 1 };
        Assert.assertEquals(1, solution(5, B));

        final int[] C = { 1, 1 };
        Assert.assertEquals(2, solution(5, C));

        final int[] D = { 0 };
        Assert.assertEquals(1, solution(0, D));

        final int[] E = { 6 };
        Assert.assertEquals(1, solution(6, E));

        final int[] F = { 1, 2, 3, 1, 2, 3 };
        Assert.assertEquals(15, solution(4, F));

        final int[] G = { 1, 2, 1, 2 };
        Assert.assertEquals(7, solution(4, G));

    }
}