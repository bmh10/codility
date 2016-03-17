package caterpillarMethod;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CountTriangles {

    public int solution(int[] A) {
        final int N = A.length;
        int count = 0;

        Arrays.sort(A);

        for (int a = 0; a < N - 2; a++) {
            int b = a + 1;
            int c = a + 2;
            while (c < N) {
                if (A[a] + A[b] > A[c]) {
                    count += c - b;
                    c++;
                } else if (b < c - 1) {
                    b++;
                } else {
                    c++;
                    b++;
                }
            }
        }

        return count;
    }


    @Test
    public void test() {
        final int[] A = { 10, 2, 5, 1, 8, 12 };
        Assert.assertEquals(4, solution(A));

        final int[] B = { 3, 3, 5, 6 };
        Assert.assertEquals(3, solution(B));
    }
}



