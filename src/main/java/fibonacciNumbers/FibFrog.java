package fibonacciNumbers;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FibFrog {

    public int solution(int[] A) {
        final int N = A.length;

        Set<Integer> fibs = generateFibs(N);
        Map<Integer, Integer> jumps = new LinkedHashMap<>();

        jumps.put(-1, 0);
        for (int i = 0; i < N; i++) {
            if (A[i] == 1) {
                jumps.put(i, Integer.MAX_VALUE - 1);
            }
        }

        jumps.put(N, Integer.MAX_VALUE);

        for (Map.Entry<Integer, Integer> current : jumps.entrySet()) {
            for (Map.Entry<Integer, Integer> prev : jumps.entrySet()) {
                int currentIdx = current.getKey();
                int prevIdx = prev.getKey();
                if (currentIdx == prevIdx) {
                    break;
                }

                int requiredJumps = currentIdx - prevIdx;
                if (fibs.contains(requiredJumps)) {
                    jumps.put(currentIdx, Math.min(current.getValue(), prev.getValue() + 1));
                }
            }
        }

        int minJumps = jumps.get(N);
        return minJumps == Integer.MAX_VALUE ? -1 : minJumps;
    }

    private Set<Integer> generateFibs(int N) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(0);
        fibs.add(1);
        while (fibs.get(fibs.size() - 1) <= N) {
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }

        return new HashSet<>(fibs);
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

        final int[] B = { 1 };
        Assert.assertEquals(1, solution(B));

        final int[] C = { 1, 1, 0, 0, 0 };
        Assert.assertEquals(2, solution(C));

        final int[] D = { 0, 0, 0 };
        Assert.assertEquals(-1, solution(D));
    }
}
