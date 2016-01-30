package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public int solution(int[] A) {
        final Set<Integer> set = new HashSet<Integer>();
        for (int a : A) {
            set.add(a);
        }

        return set.size();
    }


    @Test
    public void test() {
        final int[] A = { 2, 1, 1, 2, 3, 1 };
        Assert.assertEquals(3, solution(A));
    }
}
