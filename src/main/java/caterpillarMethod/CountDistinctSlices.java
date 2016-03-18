package caterpillarMethod;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSlices {

    // TODO: incorrect
    /*public int solution(int M, int[] A) {
        final int N = A.length;

        // Pre-store no. of distinct combos obtained from
        // distinct set of each size up to M
        final int[] distinctCombos = new int[M+2];
        distinctCombos[1] = 1;
        for (int i = 2; i < M + 2; i++) {
            distinctCombos[i] = distinctCombos[i-1] + i;
        }

        int count = 0;
        Set<Integer> currSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            currSet.add(A[i]);
            if (i+1 == N || currSet.contains(A[i+1])) {
                count += distinctCombos[currSet.size()];
                if (count > 1000000000) {
                    return 1000000000;
                }
                currSet.clear();
            }
        }

        return count;
    }*/

    // Brute force
    public int solution(int M, int[] A) {
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