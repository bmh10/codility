package iterations;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGap {

    public int solution(int N) {
        final String binaryN = Integer.toBinaryString(N);

        int longestBinaryGap = 0;
        int count = 0;

        for (int i = 0; i < binaryN.length(); i++) {
            char c = binaryN.charAt(i);
            if (c == '1') {
                if (count > longestBinaryGap) {
                    longestBinaryGap = count;
                }

                count = 0;
            } else { // c == '0'
                count++;
            }
        }

        return longestBinaryGap;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, solution(9));
        Assert.assertEquals(4, solution(529));
        Assert.assertEquals(1, solution(20));
        Assert.assertEquals(5, solution(1041));
    }
}
