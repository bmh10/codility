package sieveOfEratosthenes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CountSemiprimes {

    public int[] solution(int N, int[] P, int[] Q) {
        final int M = P.length;

        // Calculate factorization arr in this range
        int[] F = new int[N+1];
        int i = 2;
        while (i*i <= N) { // i <= sqrt(N)
            if (F[i] == 0) {
                int j = i*i;
                while (j <= N) {
                    if (F[j] == 0) {
                        F[j] = i;
                    }
                    j += i;
                }
            }
            i++;
        }

        // Calculate semiprimes over full range and use prefix sum
        int[] semiprimesUpToPoint = new int[N+1];
        int semiprimeCount = 0;
        for (int n = 0; n <= N; n++) {
            int smallestPrimeDivisor = F[n];
            if (smallestPrimeDivisor == 0) {
                semiprimesUpToPoint[n] = semiprimeCount;
                continue;
            }

            int matchingDivisor = n / smallestPrimeDivisor;
            // Only a semi-prime if other divisor is prime as well
            if (F[matchingDivisor] == 0) {
                semiprimeCount++;
            }

            semiprimesUpToPoint[n] = semiprimeCount;
        }

        // For each range calculate no. of semi-primes
        int[] ans = new int[M];
        for (int m = 0; m < M; m++) {
            ans[m] = semiprimesUpToPoint[Q[m]] - semiprimesUpToPoint[P[m]-1];
        }

        return ans;
    }

    @Test
    public void test() {
        final int[] P =   { 1,  4,  16 };
        final int[] Q =   { 26, 10, 20 };
        final int[] ans = { 10, 4,  0 };
        Assert.assertEquals(Arrays.toString(ans), Arrays.toString(solution(26, P, Q)));
    }
}
