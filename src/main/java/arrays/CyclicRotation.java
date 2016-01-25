package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class CyclicRotation {

    public int[] solution(int[] A, int K) {

        final int[] rotatedArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int newIdx = (i + K) % A.length;
            rotatedArr[newIdx] = A[i];
        }

        return rotatedArr;
    }

    @Test
    public void test() {
        int[] A = { 3, 8, 9, 7, 6 };
        int[] Ares = { 9, 7, 6, 3, 8 };
        Assert.assertEquals(Arrays.toString(Ares), Arrays.toString(solution(A, 3)));
    }
    
}
