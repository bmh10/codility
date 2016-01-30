package prefixSums;

import org.junit.Assert;
import org.junit.Test;

public class CountDiv {

    public int solution(int A, int B, int K) {
        int incA = (A % K == 0) ? 0 : K - (A % K);
        int decB = (B % K);

        // Move A and B to nearest numbers divisible by K
        int newA = A + incA;
        int newB = B - decB;
        int range = newB - newA;
        return (range / K) + 1;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, solution(6, 11, 2));
        Assert.assertEquals(4, solution(6, 12, 2));
        Assert.assertEquals(4, solution(5, 12, 2));
        Assert.assertEquals(3, solution(7, 12, 2));
        Assert.assertEquals(4, solution(11, 21, 3));
        Assert.assertEquals(1, solution(6, 6, 2));
        Assert.assertEquals(0, solution(7, 7, 2));
        Assert.assertEquals(1, solution(7, 8, 4));
    }
}
