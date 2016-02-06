package stacksAndQueues;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Brackets {

    // Time: O(n) Space: O(n)
    public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }

        final Map<Character, Character> chars = new HashMap<Character, Character>();
        chars.put('(', ')');
        chars.put('{', '}');
        chars.put('[', ']');

        final Deque<Character> stack = new ArrayDeque<Character>();

        for (Character c : S.toCharArray()) {
            Character peek = stack.peek();
            if (peek == null || chars.keySet().contains(c)) {
                stack.push(c);
            } else if (chars.get(peek) == c) {
                stack.pop();
            } else {
                return 0;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solution("{[()()]}"));
        Assert.assertEquals(0, solution("([)()]"));
    }
}
