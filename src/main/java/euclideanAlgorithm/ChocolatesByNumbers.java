package euclideanAlgorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ChocolatesByNumbers {

    // Time: O(log(N+M))
    public int solution(int N, int M) {
        final int gcd = gcd(N, M);
        return N / gcd;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    public int solutionNaive(int N, int M) {
        final Set<Integer> eaten = new HashSet<>();
        int curr = 0;
        while (!eaten.contains(curr)) {
            eaten.add(curr);
            curr = (curr + M) % N;
        }

        return eaten.size();
    }

    @Test
    public void test() {
        Assert.assertEquals(5, solution(10, 4));
    }
}
