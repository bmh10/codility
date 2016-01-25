package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        assert (A.length % 2) == 1;

        final Set<Integer> hashSet = new HashSet();

        for (int a : A) {
            if (hashSet.contains(a)) {
                hashSet.remove(a);
            } else {
                hashSet.add(a);
            }
        }

        return hashSet.iterator().next();
    }

    @Test
    public void test() {
        int[] A = { 9, 3, 9, 3, 9, 7, 9 };
        Assert.assertEquals(7, solution(A));
    }

}
