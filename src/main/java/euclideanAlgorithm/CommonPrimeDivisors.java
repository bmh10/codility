package euclideanAlgorithm;

import org.junit.Assert;
import org.junit.Test;

public class CommonPrimeDivisors {

    // Time: O(Z * log(max(A) + max(B))**2) Space: O(1)
    public int solution(int[] A, int[] B) {
        final int Z = A.length;

        int sameCount = 0;
        for (int i = 0; i < Z; i++) {
            int gcd = gcd(A[i], B[i]);
            if (check(A[i], gcd) && check(B[i], gcd)) {
                sameCount++;
            }
        }

        return sameCount;
    }

    // Checks if all prime divisors of n can be found
    // in prime divisors of gcd(a,b)
    private boolean check(int n, int gcd) {
        int rest = n / gcd;
        while (gcd % rest != 0) {
            int gcd_tmp = gcd(gcd, rest);
            if (gcd_tmp == 1){
                return false;
            }

            rest /= gcd_tmp;
        }

        return true;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }


    @Test
    public void test() {
        int[] A = { 15, 10, 3 };
        int[] B = { 75, 30, 5 };
        Assert.assertEquals(1, solution(A, B));
    }
}
