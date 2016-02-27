package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Triangle {

    // Time: O(nlogn) Space: O(1)
    public int solution(int[] A) {
        Arrays.sort(A);

        double a, b, c;
        for (int i = 0; i < A.length-2; i++) {
            a = A[i];
            b = A[i+1];
            c = A[i+2];
            if (a + b > c &&
                a + c > b &&
                b + c > a) {
                return 1;
            }
        }

        return 0;
    }


    @Test
    public void test() {
        final int[] A = { 10, 2, 5, 1, 8, 20 };
        Assert.assertEquals(1, solution(A));
    }
}
