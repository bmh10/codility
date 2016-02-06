package stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Nesting {

    // Time: O(n) Space: O(1)
    public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return 0;
            }
        }

        return count == 0 ? 1 : 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solution("(()(())())"));
        Assert.assertEquals(0, solution("())"));
    }
}
