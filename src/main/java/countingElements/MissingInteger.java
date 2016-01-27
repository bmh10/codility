package countingElements;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    // Time O(N) Space O(N)
    public int solution(int[] A) {
        final Set set = new HashSet(A.length);
        for (int a : A) {
            set.add(a);
        }

        int i = 1;
        while (i <= Integer.MAX_VALUE) {
            if (!set.contains(i)) {
                return i;
            }

            i++;
        }

        return -1;
    }

    @Test
    public void test() {
        final int[] A = { 1, 3, 6, 4, 1, 2 };
        Assert.assertEquals(5, solution(A));
    }
}
