package fibonacciNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FibFrog {

    public int solution(int[] A) {
        final int N = A.length;

        int jumps = 0;


        return jumps;
    }

    private int fib(int n) {
        final double sqrt5 = Math.sqrt(5);
        double a = Math.pow((1d + sqrt5) / 2d, n);
        double b = Math.pow((1d - sqrt5) / 2d, n);
        return (int)((a - b) / sqrt5);
    }

    @Test
    public void test() {
        Assert.assertEquals(0, fib(0));
        Assert.assertEquals(1, fib(1));
        Assert.assertEquals(1, fib(2));
        Assert.assertEquals(13, fib(7));

        final int[] A = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };
        Assert.assertEquals(3, solution(A));
    }
}
