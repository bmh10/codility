package euclideanAlgorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CommonPrimeDivisors {

    public int solution(int[] A, int[] B) {
        final int Z = A.length;

        int sameCount = 0;
        for (int i = 0; i < Z; i++) {
            Set<Integer> primeDivsA = findPrimeDivisors(A[i]);
            Set<Integer> primeDivsB = findPrimeDivisors(B[i]);
            if (primeDivsA.equals(primeDivsB)) {
                sameCount++;
            }
        }

        return sameCount;
    }

    private Set<Integer> findPrimeDivisors(int n) {
        Set<Integer> primeDivisors = new HashSet<>();
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                if (isPrime(i)) {
                    primeDivisors.add(i);
                }

                int matchingDivisor = n / i;
                if (isPrime(matchingDivisor)) {
                    primeDivisors.add(matchingDivisor);
                }
            }
        }

        return primeDivisors;
    }

    // Use sieve to generate all in advance
    private boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(isPrime(1));
        Assert.assertTrue(isPrime(2));
        Assert.assertFalse(isPrime(4));
        Assert.assertTrue(isPrime(5));
        Assert.assertTrue(isPrime(17));

        int[] A = { 15, 10, 3 };
        int[] B = { 75, 30, 5 };
        Assert.assertEquals(1, solution(A, B));
    }
}
