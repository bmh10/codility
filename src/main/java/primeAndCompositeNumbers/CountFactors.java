package primeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

public class CountFactors {

    // Time O(sqrt(N)) Space O(1)
    public int solution(int N) {
        final double sqrtN = Math.sqrt(N);

        int factors = 0;
        for (int i = 1; i < sqrtN; i++) {
            if (N % i == 0) {
                factors += 2;
            }
        }

        if (N % sqrtN == 0) {
            factors++;
        }

        return factors;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solution(1));
        Assert.assertEquals(2, solution(2));
        Assert.assertEquals(2, solution(3));
        Assert.assertEquals(3, solution(4));
        Assert.assertEquals(8, solution(24));
    }
}
