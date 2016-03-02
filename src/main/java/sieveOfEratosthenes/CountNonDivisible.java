package sieveOfEratosthenes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {

    // Time O(N*sqrt(N)) Space O(N)
    public int[] solution(int[] A) {
        final int N = A.length;

        final Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int a : A) {
            int curr = elementCountMap.containsKey(a) ? elementCountMap.get(a) : 0;
            elementCountMap.put(a, curr + 1);
        }

        final Map<Integer, Integer> divisorCountMap = new HashMap<>();
        // Loop over set of unique numbers
        for (int a : elementCountMap.keySet()) {
            // Loop up to sqrt(a) to find all possible factors
            for (int i = 1; i*i <= a; i++) {
                if (a % i == 0)  {
                    // Found a divisor 'i'
                    int toAdd = 0;
                    if (elementCountMap.keySet().contains(i)) {
                        toAdd += elementCountMap.get(i);
                    }

                    int matchingDivisor = a / i;
                    if (i != matchingDivisor && elementCountMap.keySet().contains(matchingDivisor)) {
                        toAdd += elementCountMap.get(matchingDivisor);
                    }

                    if (toAdd > 0) {
                        int curr = divisorCountMap.containsKey(a) ? divisorCountMap.get(a) : 0;
                        divisorCountMap.put(a, curr + toAdd);
                    }
                }
            }
        }

        // We need non-divisor count, so do (N - divisor count) for each entry
        final int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            Integer divisorCount = divisorCountMap.get(A[i]);
            ans[i] = divisorCount == null ? N : N - divisorCount;
        }

        return ans;
    }

    @Test
    public void test() {
        final int[] A =   { 3, 1, 2, 3, 6 };
        final int[] ans = { 2, 4, 3, 2, 0 };
        Assert.assertEquals(Arrays.toString(ans), Arrays.toString(solution(A)));

        final int[] B = { 2, 4 };
        final int[] ansB = { 1, 0 };
        Assert.assertEquals(Arrays.toString(ansB), Arrays.toString(solution(B)));

        final int[] C =    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        final int[] ansC = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Assert.assertEquals(Arrays.toString(ansC), Arrays.toString(solution(C)));
    }
}
