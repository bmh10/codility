package timeComplexity;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {

    public int solution(int[] A) {
        final Set<Integer> hashSet = new HashSet();
        for (int a : A) {
            hashSet.add(a);
        }

        for (int i = 1; i <= A.length+1; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    @Test
    public void test() {
        int[] A = { 2, 3, 1, 5 };
        Assert.assertEquals(4, solution(A));
    }
}
