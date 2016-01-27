package countingElements;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    // space O(n), time O(n)
    public int solution(int[] A) {
        final Set set = new HashSet(A.length);
        for (int a : A) {
            set.add(a);
        }

        for (int i = 1; i <= A.length; i++) {
            if (!set.contains(i)) {
                return 0;
            }
        }

        return 1;
    }

    @Test
    public void test() {
        final int[] A = { 4, 1, 3, 2 };
        Assert.assertEquals(1, solution(A));
        final int[] B = { 4, 1, 3 };
        Assert.assertEquals(0, solution(B));
    }
}
