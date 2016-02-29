package sieveOfEratosthenes;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CountNonDivisible {

    public int[] solution(int[] A) {
        final int N = A.length;
        int[] Aorig = Arrays.copyOf(A, N);
        Arrays.sort(A);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            // If next element has same value, skip to that one
            if (i+1 < N && A[i+1] == A[i]) {
                continue;
            }

            for (int j = 0; j <= i; j++) {
                // Store non-divisor count in map
                if (A[i] % A[j] != 0) {
                    if (map.containsKey(A[i])) {
                        map.put(A[i], map.get(A[i]) + 1);
                    } else {
                        map.put(A[i], 1);
                    }
                }
            }

            Integer nonDivisorCount = map.get(A[i]);
            if (nonDivisorCount == null) {
                nonDivisorCount = 0;
            }
            nonDivisorCount += (N - i - 1);
            map.put(A[i], nonDivisorCount);

        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = map.get(Aorig[i]);
        }

        return ans;
    }

    @Test
    public void test() {
        final int[] A =   { 3, 1, 2, 3, 6 };
        final int[] ans = { 2, 4, 3, 2, 0 };
        Assert.assertEquals(Arrays.toString(ans), Arrays.toString(solution(A)));
    }
}
