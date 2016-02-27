package sieveOfEratosthenes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CountSemiprimes {

    //
    public int[] solution(int N, int[] P, int[] Q) {


        return null;
    }

    @Test
    public void test() {
        final int[] P = { 1, 4, 16 };
        final int[] Q = { 26, 10, 20 };
        final int[] ans = { 10, 4, 0 };
        Assert.assertEquals(Arrays.toString(ans), Arrays.toString(solution(26, P, Q)));
    }
}
