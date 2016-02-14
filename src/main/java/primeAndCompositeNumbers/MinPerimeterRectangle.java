package primeAndCompositeNumbers;

import org.junit.Assert;
import org.junit.Test;

public class MinPerimeterRectangle {

    // Time O(sqrt(N)) Space O(1)
    public int solution(int N) {
        final double sqrtN = Math.sqrt(N);

        int minPerimeter = Integer.MAX_VALUE;
        for (int A = 1; A < sqrtN; A++) {
            if (N % A == 0) {
                int B = N / A;
                minPerimeter = Math.min(minPerimeter, 2 * (A + B));
            }
        }

        if (N % sqrtN == 0) {
            minPerimeter = Math.min(minPerimeter, 4 * (int)sqrtN);
        }

        return minPerimeter;
    }

    @Test
    public void test() {
        Assert.assertEquals(22, solution(30));
    }
}
